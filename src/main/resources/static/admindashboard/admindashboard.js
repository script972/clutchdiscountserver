'use strict';

angular.module('myApp.admindashboard', ['ngRoute'])
    .config(['$routeProvider', function($routeProvider) {
        $routeProvider.when('/admindashboard', {
            templateUrl: 'admindashboard/admindashboard.html',
            controller: DashboardAdminCtrl,
            resolve: DashboardAdminCtrl.resolve
        });
    }]);

function DashboardAdminCtrl($scope, $rootScope, $http, isAuthenticated, authService) {
    $rootScope.authenticated = isAuthenticated;

    $scope.serverResponse = '';
    $scope.responseBoxClass = '';

    var setResponse = function(res, success) {
        $rootScope.authenticated = isAuthenticated;
        if (success) {
            $scope.responseBoxClass = 'alert-success';
        } else {
            $scope.responseBoxClass = 'alert-danger';
        }
        $scope.serverResponse = res;
        $scope.users = JSON.stringify(res.data, null, 2);


    }

    if ($rootScope.authenticated) {
        authService.getUser()
            .then(function(response) {
                $scope.user = response.data;
            });
    }

    $scope.getUserInfo = function() {
        authService.getUser()
            .then(function(response) {
                setResponse(response, true);
            })
            .catch(function(response) {
                setResponse(response, false);
            });
    }

    $scope.getAllUserInfo = function() {
        $http({
            headers: authService.createAuthorizationTokenHeader(),
            method: 'GET',
            url: 'api/user/all'
        })
            .then(function(res) {
                setResponse(res, true);
            })
            .catch(function(response) {
                setResponse(response, false);
            });
    }
}
DashboardAdminCtrl.resolve = {
    isAuthenticated : function($q, $http, AuthService) {
        var deferred = $q.defer();
        var oldToken = AuthService.getJwtToken();
        if (oldToken !== null) {
            $http({
                headers: AuthService.createAuthorizationTokenHeader(),
                method: 'POST',
                url: 'auth/refresh'
            })
                .success(function(res) {
                    AuthService.setJwtToken(res.access_token);
                    deferred.resolve(res.access_token !== null);
                })
                .error(function(err){
                    AuthService.removeJwtToken();
                    deferred.resolve(false); // you could optionally pass error data here
                });
        } else {
            deferred.resolve(false);
        }
        return deferred.promise;
    }
};

DashboardAdminCtrl.$inject = ['$scope', '$rootScope', '$http', 'isAuthenticated', 'AuthService'];


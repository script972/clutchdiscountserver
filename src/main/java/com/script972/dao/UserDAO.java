package com.script972.dao;

import com.script972.entity.User;
import com.script972.repository.UserRRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@Transactional
public class UserDAO implements UserRRepository {
    @Autowired
    private EntityManager entityManager;

    @Override
    public void addNewUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void updateUserName(User user) {
        entityManager.merge(user);
    }

    @Override
    public User getPhoneNumber(String number) {
        String hqlQuery="from User us where us.enabled=TRUE AND  us.phoneNumber=:phNumber";
        List<User> userList=this.entityManager.createQuery(hqlQuery).setParameter("phNumber", number).getResultList();
        if(userList.size()>0){
            return userList.get(0);
        }
        return null;
    }

    @Override
    public boolean addPhotoAvatar(Long id, String url) {
        String hqlQuery = "update User set face_photo = :facePhoto where id=:userId";
        int result = this.entityManager.createQuery(hqlQuery).setParameter("facePhoto", url).setParameter("userId", id).executeUpdate();
        return result != 0;
    }
}

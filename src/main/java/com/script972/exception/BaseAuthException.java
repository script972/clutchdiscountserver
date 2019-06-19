package com.script972.exception;

/**
 * Created by script972
 */

public class BaseAuthException extends BaseClutchException {

    public BaseAuthException(ErrorCode code) {
        super(code);
    }

    public BaseAuthException(ErrorCode code, Object accountData) {
        super(code);
        this.setErrorData(accountData);
    }

}

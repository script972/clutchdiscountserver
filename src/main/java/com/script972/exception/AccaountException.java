package com.script972.exception;

/**
 * Created by script972
 */

public class AccaountException extends BaseClutchException {

    public AccaountException(ErrorCode code) {
        super(code);
    }

    public AccaountException(ErrorCode code, Object accountData) {
        super(code);
        this.setErrorData(accountData);
    }

}

package com.script972.exception;

/**
 * Created by script972
 */
@lombok.Getter
@lombok.Setter
public class BaseClutchException extends RuntimeException {
    private ErrorCode code;
    private Object errorData;

    public BaseClutchException(Throwable cause) {
        super(cause);
    }

    public BaseClutchException(ErrorCode code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public BaseClutchException(ErrorCode code, String message) {
        super(message);
        this.code = code;
    }

    public BaseClutchException(ErrorCode code) {
        super(code.toString());
        this.code = code;
    }
}

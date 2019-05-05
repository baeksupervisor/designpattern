package com.baeksupervisor.designpattern.chainofresponsibility.exception;

public class ValidateFailException extends RuntimeException {

    public ValidateFailException() {
        super();
    }

    public ValidateFailException(String message) {
        super(message);
    }

    public ValidateFailException(String message, Throwable cause) {
        super(message, cause);
    }

    public ValidateFailException(Throwable cause) {
        super(cause);
    }

    protected ValidateFailException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

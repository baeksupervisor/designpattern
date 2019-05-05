package com.baeksupervisor.designpattern.chainofresponsibility.exception;

public class NotSubscribeException extends ValidateFailException {

    public NotSubscribeException(String message) {
        super(String.format("%s message is not subscribe.", message));
    }
}

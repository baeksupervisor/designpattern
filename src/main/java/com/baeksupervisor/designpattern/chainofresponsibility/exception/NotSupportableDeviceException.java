package com.baeksupervisor.designpattern.chainofresponsibility.exception;

public class NotSupportableDeviceException extends ValidateFailException {

    public NotSupportableDeviceException(String message) {
        super(String.format("%s device is not supported.", message));
    }
}

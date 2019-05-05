package com.baeksupervisor.designpattern.chainofresponsibility.exception;

public class NotSupportableDeviceVersionException extends ValidateFailException {
    public NotSupportableDeviceVersionException(String message) {
        super(String.format("%s device version is not supported.", message));
    }
}

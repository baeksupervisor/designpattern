package com.baeksupervisor.designpattern.chainofresponsibility.handler;

import com.baeksupervisor.designpattern.chainofresponsibility.PushMessage;
import com.baeksupervisor.designpattern.chainofresponsibility.exception.NotSupportableDeviceException;
import com.baeksupervisor.designpattern.chainofresponsibility.exception.ValidateFailException;

import java.util.Optional;

public class BasicValidator extends AbstractHandler {

    public BasicValidator(PushMessage pushMessage) {
        super(pushMessage);
    }

    @Override
    public void handle() throws ValidateFailException {
        Optional.ofNullable(this.pushMessage.getReceiver().getDevice()).orElseThrow(() -> new NotSupportableDeviceException("No"));
        this.next();
    }
}

package com.baeksupervisor.designpattern.chainofresponsibility.handler;

import com.baeksupervisor.designpattern.chainofresponsibility.Device;
import com.baeksupervisor.designpattern.chainofresponsibility.Platform;
import com.baeksupervisor.designpattern.chainofresponsibility.PushMessage;
import com.baeksupervisor.designpattern.chainofresponsibility.exception.NotSupportableDeviceException;
import com.baeksupervisor.designpattern.chainofresponsibility.exception.NotSupportableDeviceVersionException;
import com.baeksupervisor.designpattern.chainofresponsibility.exception.ValidateFailException;

public class DeviceValidator extends AbstractHandler {

    public DeviceValidator(PushMessage pushMessage) {
        super(pushMessage);
    }

    @Override
    public void handle() throws ValidateFailException {
        Device receiverDevice = this.pushMessage.getReceiver().getDevice();

        if (receiverDevice.getPlatform().equals(Platform.WONDOW)) {
            throw new NotSupportableDeviceException(receiverDevice.getPlatform().name());
        }

        if ("1.0".equals(receiverDevice.getVersion()) == false) {
            throw new NotSupportableDeviceVersionException(receiverDevice.getVersion());
        }

        this.next();
    }
}

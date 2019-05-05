package com.baeksupervisor.designpattern.chainofresponsibility.handler;

import com.baeksupervisor.designpattern.chainofresponsibility.PushMessage;
import com.baeksupervisor.designpattern.chainofresponsibility.PushSetting;
import com.baeksupervisor.designpattern.chainofresponsibility.exception.NotSubscribeException;
import com.baeksupervisor.designpattern.chainofresponsibility.exception.ValidateFailException;

public class SubscribeValidator extends AbstractHandler {

    public SubscribeValidator(PushMessage pushMessage) {
        super(pushMessage);
    }

    @Override
    public void handle() throws ValidateFailException {
        PushSetting receiverPushSetting = this.pushMessage.getReceiver().getPushSetting();

        if (receiverPushSetting.isSubscribeAll()
                || (PushMessage.Type.LIKE.equals(this.pushMessage.getType()) && receiverPushSetting.isSubscribeLike())
                || (PushMessage.Type.COMMENT.equals(this.pushMessage.getType()) && receiverPushSetting.isSubscribeComment())) {
            this.next();
        } else {
            throw new NotSubscribeException(pushMessage.getType().name());
        }
    }
}
package com.baeksupervisor.designpattern.chainofresponsibility.main;

import com.baeksupervisor.designpattern.chainofresponsibility.*;
import com.baeksupervisor.designpattern.chainofresponsibility.handler.AbstractHandler;
import com.baeksupervisor.designpattern.chainofresponsibility.handler.BasicValidator;
import com.baeksupervisor.designpattern.chainofresponsibility.handler.DeviceValidator;
import com.baeksupervisor.designpattern.chainofresponsibility.handler.SubscribeValidator;

public class ChainOfResponsibility {

    public static void main(String[] args) throws Exception {
        PushSetting allSubscribe = PushSetting.of(true, true, true);
        PushSetting likeSubscribe = PushSetting.of(false, true, false);
        PushSetting commentSubscribe = PushSetting.of(false, false, true);

        Device ios1 = Device.of(Platform.IOS, "1.0");
        Device aos0 = Device.of(Platform.AOS, "0.1");
        Device win = Device.of(Platform.WONDOW, "1.0");

        Member memberWindow =
                new Member.Builder(1L, "member1")
                        .device(win)
                        .pushSetting(allSubscribe)
                        .build();

        Member memberAos =
                new Member.Builder(2L, "member2")
                        .device(aos0)
                        .pushSetting(allSubscribe)
                        .build();

        Member memberIos =
                new Member.Builder(3L, "member3")
                        .device(ios1)
                        .pushSetting(likeSubscribe)
                        .build();

        PushMessage pushMessage1 = PushMessage.of(memberWindow, "your post is good", PushMessage.Type.COMMENT);
        PushMessage pushMessage2 = PushMessage.of(memberAos, "your post is good", PushMessage.Type.COMMENT);
        PushMessage pushMessage3 = PushMessage.of(memberIos, "like", PushMessage.Type.LIKE);

        AbstractHandler validator = new BasicValidator(pushMessage1);

        validator.setNext(new DeviceValidator(pushMessage1))
                .setNext(new SubscribeValidator(pushMessage1));

        validator.handle();
    }
}

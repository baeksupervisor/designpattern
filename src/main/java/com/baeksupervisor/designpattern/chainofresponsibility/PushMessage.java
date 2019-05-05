package com.baeksupervisor.designpattern.chainofresponsibility;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(staticName = "of")
public class PushMessage {

    private final Member receiver;

    private final String message;

    private final Type type;

    public enum Type {
        LIKE,
        COMMENT;
    }
}

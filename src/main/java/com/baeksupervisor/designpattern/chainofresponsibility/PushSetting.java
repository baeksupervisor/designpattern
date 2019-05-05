package com.baeksupervisor.designpattern.chainofresponsibility;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(staticName = "of")
public class PushSetting {

    private final boolean subscribeAll;

    private final boolean subscribeLike;

    private final boolean subscribeComment;
}

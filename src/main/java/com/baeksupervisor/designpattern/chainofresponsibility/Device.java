package com.baeksupervisor.designpattern.chainofresponsibility;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(staticName = "of")
public class Device {

    private final Platform platform;

    private final String version;
}

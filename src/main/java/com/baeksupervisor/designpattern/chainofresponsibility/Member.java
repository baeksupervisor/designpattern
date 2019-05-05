package com.baeksupervisor.designpattern.chainofresponsibility;

import lombok.Getter;

import java.io.Serializable;
import java.util.Optional;

@Getter
public class Member implements Serializable {

    private static final long serialVersionUID = -886048389249122003L;

    private Long id;

    private String name;

    private Device device;

    private PushSetting pushSetting;

    private Member(Member.Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.device = builder.device;
        if (Optional.ofNullable(this.device).isPresent()) {
            this.pushSetting = Optional.ofNullable(builder.pushSetting).orElseGet(() -> PushSetting.of(true, true, true));
        }
    }

    public static class Builder {
        private final Long id;

        private final String name;

        private Device device;

        private PushSetting pushSetting;

        public Builder(Long id, String name) {
            this.id = id;
            this.name = name;
        }

        public Builder device(Device device) {
            this.device = device;
            return this;
        }

        public Builder pushSetting(PushSetting pushSetting) {
            this.pushSetting = pushSetting;
            return this;
        }

        public Member build() {
            return new Member(this);
        }
    }
}

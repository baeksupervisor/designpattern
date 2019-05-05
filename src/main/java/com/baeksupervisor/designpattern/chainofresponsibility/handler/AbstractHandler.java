package com.baeksupervisor.designpattern.chainofresponsibility.handler;

import com.baeksupervisor.designpattern.chainofresponsibility.PushMessage;
import com.baeksupervisor.designpattern.chainofresponsibility.exception.ValidateFailException;

public abstract class AbstractHandler {

    protected PushMessage pushMessage;

    private AbstractHandler next;

    public AbstractHandler(PushMessage pushMessage) {
        this.pushMessage = pushMessage;
    }

    public AbstractHandler setNext(AbstractHandler handler) {
        this.next = handler;
        return this.next;
    }

    protected void next() throws ValidateFailException {
        if (this.next != null) {
            this.next.handle();
        }
    }

    public abstract void handle() throws ValidateFailException;
}

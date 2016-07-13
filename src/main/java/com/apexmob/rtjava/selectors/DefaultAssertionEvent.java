package com.apexmob.rtjava.selectors;

import com.apexmob.rtjava.AssertionEvent;
import com.apexmob.rtjava.AssertionEventType;
import com.apexmob.rtjava.Test;

public class DefaultAssertionEvent implements AssertionEvent {

    private final Test test;
    private final AssertionEventType type;

    public DefaultAssertionEvent(Test test, AssertionEventType type) {
        this.test = test;
        this.type = type;
    }

    @Override
    public Test getTest() {
        return test;
    }

    @Override
    public AssertionEventType getType() {
        return type;
    }
}

package com.apexmob.rtjava;

import com.apexmob.rtjava.selectors.DefaultAssertionEvent;

public class DefaultAssertionResult extends DefaultAssertionEvent implements AssertionResult {

    public DefaultAssertionResult(Test test, AssertionEventType type) {
        super(test, type);
        if (type != AssertionEventType.SUCCESS && type != AssertionEventType.FAILURE) {
            throw new IllegalArgumentException("The type provided is not SUCCESS or FAILURE");
        }
    }

    @Override
    public boolean wasSuccessful() {
        return getType() == AssertionEventType.SUCCESS;
    }

}

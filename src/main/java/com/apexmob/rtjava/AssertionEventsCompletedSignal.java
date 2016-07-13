package com.apexmob.rtjava;

import rx.functions.Func1;

public class AssertionEventsCompletedSignal implements Func1<AssertionEvent, Boolean> {
    @Override
    public Boolean call(AssertionEvent assertionEvent) {
        return assertionEvent.getType() == AssertionEventType.COMPLETED;
    }
}

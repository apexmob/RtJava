package com.apexmob.rtjava;

import rx.functions.Action1;

public class AssertionResultListener implements Action1<AssertionResult> {

    @Override
    public void call(AssertionResult result) {
        System.out.println("Result Successful=" + result.wasSuccessful() + " for test=" + result.getTest());
    }

}

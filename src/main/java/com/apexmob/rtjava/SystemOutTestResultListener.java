package com.apexmob.rtjava;

import rx.functions.Action1;

public class SystemOutTestResultListener implements Action1<TestResult> {

    @Override
    public void call(TestResult result) {
        System.out.println(buildOut(result));
    }

    protected String buildOut(TestResult result) {
        StringBuilder buffer = new StringBuilder();

        buffer.append("[");
        if (result.wasSuccessful()) {
            buffer.append("GREEN");
        } else {
            buffer.append("RED");
        }

        buffer.append("]");

        Test test = result.getTest();
        if (test != null) {
            buffer.append(test.getTestClass().getName());
            buffer.append(".");
            buffer.append(test.getTestMethod().getName());
            buffer.append("(...)");
        } else {
            buffer.append("UNKNOWN");
        }
        return buffer.toString();
    }

}

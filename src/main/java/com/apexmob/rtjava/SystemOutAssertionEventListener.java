package com.apexmob.rtjava;

import rx.functions.Action1;

public class SystemOutAssertionEventListener implements Action1<AssertionEvent> {

    @Override
    public void call(AssertionEvent result) {
        System.out.println(buildOut(result));
    }

    protected String buildOut(AssertionEvent result) {
        StringBuilder buffer = new StringBuilder();

        buffer.append("[");
        switch (result.getType()) {
            case SUCCESS:
                buffer.append("SUCCESS");
                break;
            case FAILURE:
                buffer.append("FAILURE");
                break;
            case STARTING:
                buffer.append("STARTING");
                break;
            case COMPLETED:
                buffer.append("COMPLETED");
                break;
            default:
                buffer.append("UNKNOWN");
                break;
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

package com.apexmob.rtjava;

import java.util.List;

import rx.functions.Func1;

public class DefaultTestSelector implements Func1<Test, Boolean> {

    @Override
    public Boolean call(Test test) {
        System.out.println(this.getClass().getName() + ":" + Thread.currentThread());
        Boolean retVal = Boolean.FALSE;

        List<TestSelector> selectors = test.getExecutionConfiguration().getExecutionDialect().getSelectors();
        for (TestSelector selector : selectors) {
            retVal = selector.include(test);
            if (retVal) {
                break;
            }
        }

        return retVal;
    }
}

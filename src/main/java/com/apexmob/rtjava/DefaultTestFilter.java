package com.apexmob.rtjava;

import java.util.List;

import rx.functions.Func1;

public class DefaultTestFilter implements Func1<Test, Boolean> {

    @Override
    public Boolean call(Test test) {
        System.out.println(this.getClass().getName() + ":" + Thread.currentThread());
        Boolean retVal = Boolean.TRUE;

        List<TestFilter> filters = test.getExecutionConfiguration().getExecutionDialect().getFilters();
        boolean exclude;
        for (TestFilter filter : filters) {
            exclude = filter.exclude(test);
            if (exclude) {
                retVal = Boolean.FALSE;
                break;
            }
        }

        return retVal;
    }
}

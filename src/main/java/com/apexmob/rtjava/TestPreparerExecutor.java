package com.apexmob.rtjava;

import rx.functions.Func1;

public class TestPreparerExecutor implements Func1<Test, Test> {

    @Override
    public Test call(Test test) {
        System.out.println(this.getClass().getName() + ":" + Thread.currentThread());
        for (TestPreparer preparer : test.getExecutionConfiguration().getExecutionDialect().getTestPreparers()) {
            preparer.prepareTest(test);
        }

        return test;
    }

}

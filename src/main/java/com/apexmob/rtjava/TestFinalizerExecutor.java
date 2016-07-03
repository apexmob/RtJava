package com.apexmob.rtjava;

import rx.functions.Func1;

public class TestFinalizerExecutor implements Func1<Test, Test> {

    @Override
    public Test call(Test test) {
        System.out.println(this.getClass().getName() + ":" + Thread.currentThread());
        for (TestFinalizer finalizer : test.getExecutionConfiguration().getExecutionDialect().getTestFinalizers()) {
            finalizer.finalizeTest(test);
        }

        return test;
    }

}

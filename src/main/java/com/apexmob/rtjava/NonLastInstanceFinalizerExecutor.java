package com.apexmob.rtjava;

import rx.functions.Func1;

public class NonLastInstanceFinalizerExecutor implements Func1<Test, Test> {

    private Test lastTest = null;

    @Override
    public Test call(Test test) {
        System.out.println(this.getClass().getName() + ":" + Thread.currentThread());
        if (lastTest != null && lastTest.getTestInstance() != test.getTestInstance() && test.getTestInstance() != null) {
            for (InstanceFinalizer finalizer : test.getExecutionConfiguration().getExecutionDialect().getInstanceFinalizers()) {
                finalizer.finalizeInstance(lastTest);
            }
        }

        lastTest = test;

        return test;
    }

}

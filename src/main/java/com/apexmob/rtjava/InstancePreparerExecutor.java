package com.apexmob.rtjava;

import rx.functions.Func1;

public class InstancePreparerExecutor implements Func1<Test, Test> {

    private Object instance = null;

    @Override
    public Test call(Test test) {
        System.out.println(this.getClass().getName() + ":" + Thread.currentThread());
        if (instance != test.getTestInstance() && test.getTestInstance() != null) {
            instance = test.getTestInstance();
            for (InstancePreparer preparer : test.getExecutionConfiguration().getExecutionDialect().getInstancePreparers()) {
                preparer.prepareInstance(test);
            }
        }

        return test;
    }

}

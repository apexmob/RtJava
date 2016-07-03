package com.apexmob.rtjava;

import rx.Subscriber;

public class LastInstanceFinalizerExecutor extends Subscriber<Test> {

    private Test lastTest = null;

    private void executePostProcessors(Test test) {
        System.out.println(this.getClass().getName() + ":" + Thread.currentThread());
        for (InstanceFinalizer finalizer : test.getExecutionConfiguration().getExecutionDialect().getInstanceFinalizers()) {
            finalizer.finalizeInstance(test);
        }
    }

    @Override
    public void onCompleted() {
        if (lastTest.getTestInstance() != null) {
            executePostProcessors(lastTest);
        }
        lastTest = null;
    }

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
    }

    @Override
    public void onNext(Test test) {
        lastTest = test;
    }

}

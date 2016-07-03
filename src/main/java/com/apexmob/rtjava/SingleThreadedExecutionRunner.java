package com.apexmob.rtjava;

import rx.Observable;

public class SingleThreadedExecutionRunner implements ExecutionRunner {

    @Override
    public void run(ExecutionConfiguration configuration) {
        for (AssertionResultListener listener : configuration.getAssertionResultListeners()) {
            Assert.getAssertionResultObservable().subscribe(listener);
        }

        Observable.just(configuration) //--> ExecutionConfiguration
                .concatMap(new DefaultClassConfigurationGenerator()) //ExecutionConfiguration --> ClassConfiguration
                .concatMap(new DefaultTestGenerator()) //ClassConfiguration --> Test
                .filter(new DefaultTestSelector()) //Test --> Test
                .filter(new DefaultTestFilter()) //Test --> Test
                .map(new NonLastInstanceFinalizerExecutor()) //Test --> Test
                .map(new InstancePreparerExecutor()) //Test --> Test
                .map(new TestPreparerExecutor()) //Test --> Test
                .map(new TestExecutor()) //Test --> Test
                .map(new TestFinalizerExecutor()) //Test --> Test
                .subscribe(new LastInstanceFinalizerExecutor()); //Test --> Test
        //.subscribe(obj -> System.out.println(obj));
    }

}

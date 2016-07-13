package com.apexmob.rtjava;

import rx.Observable;
import rx.functions.Action1;

public class SingleThreadedExecutionRunner implements ExecutionRunner {

    @Override
    public void run(ExecutionConfiguration configuration) {
        for (Action1<AssertionEvent> listener : configuration.getAssertionEventListeners()) {
            Assert.getAssertionResultObservable().subscribe(listener);
        }

        Assert.getAssertionResultObservable()
                .lift(new CollectUntilOperator<>(new AssertionEventsCompletedSignal()))
                .compose(new TestResultGenerator())
                .subscribe(new SystemOutTestResultListener());

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

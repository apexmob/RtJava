package com.apexmob.rtjava;

import rx.Observable;
import rx.functions.Func1;

import java.util.ArrayList;
import java.util.List;

public class TestResultGenerator implements Observable.Transformer<List<AssertionEvent>, TestResult> {
    @Override
    public Observable<TestResult> call(Observable<List<AssertionEvent>> source) {
        return source.map(new Func1<List<AssertionEvent>, TestResult>() {
            @Override
            public TestResult call(List<AssertionEvent> assertionEvents) {
                List<AssertionResult> results = new ArrayList<AssertionResult>();
                Test test = assertionEvents.get(assertionEvents.size()-1).getTest();

                for (AssertionEvent event :  assertionEvents) {
                    if (event.getType() == AssertionEventType.SUCCESS || event.getType() ==  AssertionEventType.FAILURE) {
                        if (event instanceof AssertionResult) {
                            results.add((AssertionResult) event);
                        }
                    }
                }

                return new DefaultTestResult(test, results);
            }
        });
    }
}

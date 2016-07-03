package com.apexmob.rtjava;

import rx.Observable;

public class Assert {

    private static final AssertionResultEmitter emitter = new AssertionResultEmitter();
    private static final ThreadLocal<Test> localTest = new ThreadLocal<>();

    public static Observable<AssertionResult> getAssertionResultObservable() {
        return Observable.create(emitter);
    }

    public static void setTest(Test test) {
        localTest.set(test);
    }

    public static void removeTest() {
        localTest.remove();
    }

    public static void assertTrue(boolean b) {
        emit(b);
    }

    private static void emit(boolean successful) {
        Test test = localTest.get();
        if (test != null) {
            emitter.onAssertionResult(new DefaultAssertionResult(successful, test));
        } else {
            throw new IllegalStateException("No TestResult set");
        }
    }

}

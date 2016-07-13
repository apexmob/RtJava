package com.apexmob.rtjava;

import com.apexmob.rtjava.selectors.DefaultAssertionEvent;
import rx.Observable;

public class Assert {

    private static final AssertionEventEmitter emitter = new AssertionEventEmitter();
    private static final ThreadLocal<Test> localTest = new ThreadLocal<>();

    public static Observable<AssertionEvent> getAssertionResultObservable() {
        return Observable.create(emitter);
    }

    public static void setTest(Test test) {
        localTest.set(test);
        emitter.onAssertionEvent(new DefaultAssertionEvent(localTest.get(), AssertionEventType.STARTING));
    }

    public static void removeTest() {
        emitter.onAssertionEvent(new DefaultAssertionEvent(localTest.get(), AssertionEventType.COMPLETED));
        localTest.remove();
    }

    public static void assertTrue(boolean b) {
        emit(b);
    }

    private static void emit(boolean successful) {
        Test test = localTest.get();
        if (test != null) {
            AssertionEventType type = AssertionEventType.FAILURE;
            if (successful) {
                type = AssertionEventType.SUCCESS;
            }
            emitter.onAssertionEvent(new DefaultAssertionResult(test, type));
        } else {
            throw new IllegalStateException("No TestResult set");
        }
    }

}

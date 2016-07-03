package com.apexmob.rtjava;

import java.util.ArrayList;
import java.util.List;

import rx.Observable.OnSubscribe;
import rx.Subscriber;

public class AssertionResultEmitter implements OnSubscribe<AssertionResult> {

    private final List<Subscriber<? super AssertionResult>> subscribers = new ArrayList<>();

    public void onAssertionResult(AssertionResult result) {
        for (Subscriber<? super AssertionResult> observer : subscribers) {
            try {
                if (!observer.isUnsubscribed()) {
                    observer.onNext(result);
                } else {
                    subscribers.remove(observer);
                }
            } catch (Exception e) {
                observer.onError(e);
            }
        }
    }

    public void onComplete() {
        for (Subscriber<? super AssertionResult> observer : subscribers) {
            try {
                if (!observer.isUnsubscribed()) {
                    observer.onCompleted();
                } else {
                    subscribers.remove(observer);
                }
            } catch (Exception e) {
                observer.onError(e);
            }
        }
    }

    @Override
    public void call(Subscriber<? super AssertionResult> subscriber) {
        subscribers.add(subscriber);
    }

}

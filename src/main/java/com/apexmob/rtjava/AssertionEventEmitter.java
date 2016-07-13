package com.apexmob.rtjava;

import java.util.ArrayList;
import java.util.List;

import rx.Observable.OnSubscribe;
import rx.Subscriber;

public class AssertionEventEmitter implements OnSubscribe<AssertionEvent> {

    private final List<Subscriber<? super AssertionEvent>> subscribers = new ArrayList<>();

    public void onAssertionEvent(AssertionEvent event) {
        for (Subscriber<? super AssertionEvent> observer : subscribers) {
            try {
                if (!observer.isUnsubscribed()) {
                    observer.onNext(event);
                }
//                } else {
//                    subscribers.remove(observer);
//                }
            } catch (Exception e) {
                observer.onError(e);
            }
        }
    }

    public void onComplete() {
        for (Subscriber<? super AssertionEvent> observer : subscribers) {
            try {
                if (!observer.isUnsubscribed()) {
                    observer.onCompleted();
                }
//                } else {
//                    subscribers.remove(observer);
//                }
            } catch (Exception e) {
                observer.onError(e);
            }
        }
    }

    @Override
    public void call(Subscriber<? super AssertionEvent> subscriber) {
        subscribers.add(subscriber);
    }

}

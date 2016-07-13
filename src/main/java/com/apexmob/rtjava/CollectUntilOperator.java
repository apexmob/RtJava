package com.apexmob.rtjava;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;

import java.util.ArrayList;
import java.util.List;


public class CollectUntilOperator<T> implements Observable.Operator<List<T>, T> {

    private final Func1<T, Boolean> func1;

    public CollectUntilOperator(Func1<T,Boolean> func1) {
        this.func1 = func1;
    }

    @Override
    public Subscriber<? super T> call(Subscriber<? super List<T>> s) {
        return new Subscriber<T>(s) {

            private final List<T> items = new ArrayList<T>();

            @Override
            public void onCompleted() {
                if(!s.isUnsubscribed()) {
                    s.onCompleted();
                }
            }

            @Override
            public void onError(Throwable t) {
                if(!s.isUnsubscribed()) {
                    s.onError(t);
                }
            }

            @Override
            public void onNext(T t) {
                if (func1.call(t)) {
                    s.onNext(new ArrayList<T>(items));
                    items.clear();
                } else {
                    items.add(t);
                }
            }
        };
    }

}

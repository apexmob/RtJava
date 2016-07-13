package com.apexmob.rtjava;

import java.util.ArrayList;
import java.util.List;

import com.apexmob.rtjava.dialects.DefaultExecutionDialect;
import rx.functions.Action1;

public class DefaultExecutionConfiguration implements ExecutionConfiguration {

    private final List<Action1<AssertionEvent>> assertionResultListenerList = new ArrayList<>();
    private final ExecutionDialect executionDialect;
    private final List<Class<?>> classList = new ArrayList<>();

    public DefaultExecutionConfiguration(Class<?> clazz, Action1<AssertionEvent> eventListener) {
        this(clazz, new DefaultExecutionDialect(), eventListener);
    }

    public DefaultExecutionConfiguration(Class<?> clazz, ExecutionDialect executionDialect, Action1<AssertionEvent> resultListener) {
        classList.add(clazz);
        this.executionDialect = executionDialect;

        assertionResultListenerList.add(resultListener);
    }

    public DefaultExecutionConfiguration(List<Class<?>> classList, ExecutionDialect executionDialect, Action1<AssertionEvent> resultListener) {
        this.classList.addAll(classList);
        this.executionDialect = executionDialect;

        assertionResultListenerList.add(resultListener);
    }

    @Override
    public List<Class<?>> getClasses() {
        return classList;
    }

    @Override
    public List<Action1<AssertionEvent>> getAssertionEventListeners() {
        return assertionResultListenerList;
    }

    @Override
    public ExecutionDialect getExecutionDialect() {
        return executionDialect;
    }
}

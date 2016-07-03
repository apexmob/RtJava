package com.apexmob.rtjava;

import java.util.ArrayList;
import java.util.List;

import com.apexmob.rtjava.dialects.DefaultExecutionDialect;

public class DefaultExecutionConfiguration implements ExecutionConfiguration {

    private final List<AssertionResultListener> assertionResultListenerList = new ArrayList<>();
    private final ExecutionDialect executionDialect;
    private final List<Class<?>> classList = new ArrayList<>();

    public DefaultExecutionConfiguration(Class<?> clazz, AssertionResultListener resultListener) {
        this(clazz, new DefaultExecutionDialect(), resultListener);
    }

    public DefaultExecutionConfiguration(Class<?> clazz, ExecutionDialect executionDialect, AssertionResultListener resultListener) {
        classList.add(clazz);
        this.executionDialect = executionDialect;

        assertionResultListenerList.add(resultListener);
    }

    public DefaultExecutionConfiguration(List<Class<?>> classList, ExecutionDialect executionDialect, AssertionResultListener resultListener) {
        this.classList.addAll(classList);
        this.executionDialect = executionDialect;

        assertionResultListenerList.add(resultListener);
    }

    @Override
    public List<Class<?>> getClasses() {
        return classList;
    }

    @Override
    public List<AssertionResultListener> getAssertionResultListeners() {
        return assertionResultListenerList;
    }

    @Override
    public ExecutionDialect getExecutionDialect() {
        return executionDialect;
    }
}

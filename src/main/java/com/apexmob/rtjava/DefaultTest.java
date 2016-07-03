package com.apexmob.rtjava;

import java.lang.reflect.Method;

public class DefaultTest implements Test {

    private final Object instance;
    private final Method method;
    private final ExecutionConfiguration executionConfiguration;

    public DefaultTest(ExecutionConfiguration executionConfiguration, Object instance, Method method) {
        this.executionConfiguration = executionConfiguration;
        this.instance = instance;
        this.method = method;
    }

    @Override
    public Class<?> getTestClass() {
        return instance.getClass();
    }

    @Override
    public Method getTestMethod() {
        return method;
    }

    @Override
    public Object getTestInstance() {
        return instance;
    }

    @Override
    public ExecutionConfiguration getExecutionConfiguration() {
        return executionConfiguration;
    }

}
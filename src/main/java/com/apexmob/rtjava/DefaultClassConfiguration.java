package com.apexmob.rtjava;

public class DefaultClassConfiguration implements ClassConfiguration {

    private final ExecutionConfiguration executionConfiguration;
    private final Class<?> testClass;

    public DefaultClassConfiguration(ExecutionConfiguration executionConfiguration, Class<?> testClass) {
        this.executionConfiguration = executionConfiguration;
        this.testClass = testClass;
    }

    @Override
    public ExecutionConfiguration getExecutionConfiguration() {
        return executionConfiguration;
    }

    @Override
    public Class<?> getTestClass() {
        return testClass;
    }


}

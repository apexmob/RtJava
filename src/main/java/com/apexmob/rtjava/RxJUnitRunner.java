package com.apexmob.rtjava;

import java.util.List;

public class RxJUnitRunner {

    public RxJUnitRunner() {

    }

    public void exec(Class<?> clazz, ExecutionDialect dialect) {
        AssertionResultListener listener = new AssertionResultListener();

        DefaultExecutionConfiguration config = new DefaultExecutionConfiguration(clazz, dialect, listener);
        SingleThreadedExecutionRunner runner = new SingleThreadedExecutionRunner();
        runner.run(config);
    }

    public void exec(List<Class<?>> classList, ExecutionDialect dialect) {
        AssertionResultListener listener = new AssertionResultListener();

        DefaultExecutionConfiguration config = new DefaultExecutionConfiguration(classList, dialect, listener);
        SingleThreadedExecutionRunner runner = new SingleThreadedExecutionRunner();
        runner.run(config);
    }

}

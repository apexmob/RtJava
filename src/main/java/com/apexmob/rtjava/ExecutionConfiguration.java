package com.apexmob.rtjava;

import java.util.List;

public interface ExecutionConfiguration {

    List<Class<?>> getClasses();

//    List<TestFilter> getFilters();
//
//    List<TestSelector> getSelectors();
//
//    List<InstancePreparer> getInstancePreparers();
//
//    List<InstanceFinalizer> getInstanceFinalizers();
//
//    List<TestPreparer> getTestPreparers();
//
//    List<TestFinalizer> getTestFinalizers();

    List<AssertionResultListener> getAssertionResultListeners();

    ExecutionDialect getExecutionDialect();

}

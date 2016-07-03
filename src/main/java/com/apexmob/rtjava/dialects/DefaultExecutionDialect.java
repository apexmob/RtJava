package com.apexmob.rtjava.dialects;

import java.util.ArrayList;
import java.util.List;

import com.apexmob.rtjava.*;
import com.apexmob.rtjava.TestFilter;

public class DefaultExecutionDialect implements ExecutionDialect {

    private final List<TestFilter> filterList = new ArrayList<>();
    private final List<TestSelector> selectorList = new ArrayList<>();
    private final List<InstancePreparer> testInstancePreProcessorList = new ArrayList<>();
    private final List<InstanceFinalizer> testInstancePostProcessorList = new ArrayList<>();
    private final List<TestPreparer> testMethodPreProcessorList = new ArrayList<>();
    private final List<TestFinalizer> testMethodPostProcessorList = new ArrayList<>();

    public DefaultExecutionDialect(List<TestSelector> selectorList, List<TestFilter> filterList, List<InstancePreparer> testInstancePreProcessorList, List<InstanceFinalizer> testInstancePostProcessorList, List<TestPreparer> testMethodPreProcessorList, List<TestFinalizer> testMethodPostProcessorList) {
        this.selectorList.addAll(selectorList);
        this.filterList.addAll(filterList);
        this.testInstancePreProcessorList.addAll(testInstancePreProcessorList);
        this.testInstancePostProcessorList.addAll(testInstancePostProcessorList);
        this.testMethodPreProcessorList.addAll(testMethodPreProcessorList);
        this.testMethodPostProcessorList.addAll(testMethodPostProcessorList);
    }

    public DefaultExecutionDialect() {
    }

    @Override
    public List<TestFilter> getFilters() {
        return filterList;
    }

    @Override
    public List<TestSelector> getSelectors() {
        return selectorList;
    }

    @Override
    public List<InstancePreparer> getInstancePreparers() {
        return testInstancePreProcessorList;
    }

    @Override
    public List<InstanceFinalizer> getInstanceFinalizers() {
        return testInstancePostProcessorList;
    }

    @Override
    public List<TestPreparer> getTestPreparers() {
        return testMethodPreProcessorList;
    }

    @Override
    public List<TestFinalizer> getTestFinalizers() {
        return testMethodPostProcessorList;
    }


}

package com.apexmob.rtjava.junit4;

import java.util.ArrayList;
import java.util.List;

import com.apexmob.rtjava.*;
import com.apexmob.rtjava.InstancePreparer;
import com.apexmob.rtjava.dialects.DefaultExecutionDialect;
import com.apexmob.rtjava.filters.ExcludeMethodsWithParametersFilter;

public class JUnit4Dialect extends DefaultExecutionDialect {

    private static final List<TestSelector> SELECTORS;
    private static final List<TestFilter> FILTERS;
    private static final List<InstancePreparer> TEST_INSTANCE_PRE_PROCESSORS;
    private static final List<InstanceFinalizer> TEST_INSTANCE_POST_PROCESSORS;
    private static final List<TestPreparer> TEST_METHOD_PRE_PROCESSORS;
    private static final List<TestFinalizer> TEST_METHOD_POST_PROCESSORS;

    static {
        SELECTORS = new ArrayList<>();
        SELECTORS.add(new JUnit4TestAnnotationSelector());

        FILTERS = new ArrayList<>();
        FILTERS.add(new JUnit4IgnoreAnnotationFilter());
        FILTERS.add(new ExcludeMethodsWithParametersFilter());

        TEST_INSTANCE_PRE_PROCESSORS = new ArrayList<>();
        TEST_INSTANCE_PRE_PROCESSORS.add(new JUnit4BeforeClassPreparer());

        TEST_INSTANCE_POST_PROCESSORS = new ArrayList<>();
        TEST_INSTANCE_POST_PROCESSORS.add(new JUnit4AfterClassFinalizer());

        TEST_METHOD_PRE_PROCESSORS = new ArrayList<>();
        TEST_METHOD_PRE_PROCESSORS.add(new JUnit4BeforePreparer());

        TEST_METHOD_POST_PROCESSORS = new ArrayList<>();
        TEST_METHOD_POST_PROCESSORS.add(new JUnit4AfterFinalizer());
    }

    public JUnit4Dialect() {
        super(SELECTORS, FILTERS, TEST_INSTANCE_PRE_PROCESSORS, TEST_INSTANCE_POST_PROCESSORS, TEST_METHOD_PRE_PROCESSORS, TEST_METHOD_POST_PROCESSORS);
    }

}

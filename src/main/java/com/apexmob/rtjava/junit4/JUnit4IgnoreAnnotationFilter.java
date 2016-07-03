package com.apexmob.rtjava.junit4;

import com.apexmob.rtjava.TestFilter;
import com.apexmob.rtjava.Test;

public class JUnit4IgnoreAnnotationFilter implements TestFilter {

    @Override
    public boolean exclude(Test test) {
        return test.getTestMethod().isAnnotationPresent(org.junit.Ignore.class);
    }

}

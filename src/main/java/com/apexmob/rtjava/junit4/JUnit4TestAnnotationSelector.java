package com.apexmob.rtjava.junit4;

import com.apexmob.rtjava.TestSelector;
import com.apexmob.rtjava.Test;

public class JUnit4TestAnnotationSelector implements TestSelector {

    @Override
    public boolean include(Test test) {
        return test.getTestMethod().isAnnotationPresent(org.junit.Test.class);
    }

}

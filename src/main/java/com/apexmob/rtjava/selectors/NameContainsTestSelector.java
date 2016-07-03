package com.apexmob.rtjava.selectors;

import com.apexmob.rtjava.TestSelector;
import com.apexmob.rtjava.Test;

public class NameContainsTestSelector implements TestSelector {

    @Override
    public boolean include(Test test) {
        return test.getTestMethod().getName().contains("test");
    }


}

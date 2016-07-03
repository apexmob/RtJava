package com.apexmob.rtjava.filters;

import com.apexmob.rtjava.TestFilter;
import com.apexmob.rtjava.Test;

public class ExcludeMethodsWithParametersFilter implements TestFilter {

    @Override
    public boolean exclude(Test test) {
        System.out.println(test.getTestMethod().getName() + " =" + test.getTestMethod().getParameterTypes().length);
        return test.getTestMethod().getParameterTypes().length > 0;
    }

}

package com.apexmob.rtjava.junit4;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Before;

import com.apexmob.rtjava.Test;
import com.apexmob.rtjava.TestPreparer;

public class JUnit4BeforePreparer implements TestPreparer {

    @Override
    public void prepareTest(Test test) {
        for (Method method : test.getTestClass().getMethods()) {
            if (method.isAnnotationPresent(Before.class) && method.getParameterTypes().length == 0) {
                try {
                    method.invoke(test.getTestInstance(), new Object[0]);
                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                break;
            }
        }
    }

}

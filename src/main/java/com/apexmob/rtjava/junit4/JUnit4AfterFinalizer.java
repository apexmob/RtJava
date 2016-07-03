package com.apexmob.rtjava.junit4;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.apexmob.rtjava.TestFinalizer;
import org.junit.After;

import com.apexmob.rtjava.Test;

public class JUnit4AfterFinalizer implements TestFinalizer {

    @Override
    public void finalizeTest(Test test) {
        for (Method method : test.getTestClass().getMethods()) {
            if (method.isAnnotationPresent(After.class) && method.getParameterTypes().length == 0) {
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

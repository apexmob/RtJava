package com.apexmob.rtjava.junit4;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.AfterClass;

import com.apexmob.rtjava.Test;
import com.apexmob.rtjava.InstanceFinalizer;

public class JUnit4AfterClassFinalizer implements InstanceFinalizer {

    @Override
    public void finalizeInstance(Test test) {
        for (Method method : test.getTestClass().getMethods()) {
            if (method.isAnnotationPresent(AfterClass.class) && method.getParameterTypes().length == 0) {
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

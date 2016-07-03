package com.apexmob.rtjava;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.functions.Func1;

public class DefaultTestGenerator implements Func1<ClassConfiguration, rx.Observable<Test>> {

    @Override
    public Observable<Test> call(ClassConfiguration classConfiguration) {
        System.out.println(this.getClass().getName() + ":" + Thread.currentThread());
        List<Test> tests = new ArrayList<>();
        Class<?> testClass = classConfiguration.getTestClass();
        Object obj = buildTestClassInstance(testClass);

        if (obj != null) {
            for (Method method : testClass.getMethods()) {
                tests.add(new DefaultTest(classConfiguration.getExecutionConfiguration(), obj, method));
            }
        }
        return Observable.from(tests);
    }

    protected Object buildTestClassInstance(Class<?> testClass) {
        Object retVal = null;

        try {
            retVal = testClass.newInstance();
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return retVal;
    }
}

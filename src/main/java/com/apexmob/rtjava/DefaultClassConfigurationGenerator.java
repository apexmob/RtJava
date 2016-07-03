package com.apexmob.rtjava;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.functions.Func1;

public class DefaultClassConfigurationGenerator implements Func1<ExecutionConfiguration, rx.Observable<ClassConfiguration>> {

    @Override
    public Observable<ClassConfiguration> call(ExecutionConfiguration executionConfiguration) {
        System.out.println(this.getClass().getName() + ":" + Thread.currentThread());
        List<ClassConfiguration> classConfigurations = new ArrayList<>();
        for (Class<?> clazz : executionConfiguration.getClasses()) {
            classConfigurations.add(new DefaultClassConfiguration(executionConfiguration, clazz));
        }
        return Observable.from(classConfigurations);
    }
}

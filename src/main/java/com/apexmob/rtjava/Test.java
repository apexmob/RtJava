package com.apexmob.rtjava;

import java.lang.reflect.Method;

public interface Test {

    ExecutionConfiguration getExecutionConfiguration();

    Class<?> getTestClass();

    Method getTestMethod();

    Object getTestInstance();

//	Object[] getMethodParameters();
//	
//	Annotation[] getAnnotations();
//	
//	void addAnnotation(Annotation annotation);
//	
//	Annotation[] getAnnotations(Class<? extends Annotation> clazz);
//	
//	Annotation removeAnnotation(Annotation annotation);

}

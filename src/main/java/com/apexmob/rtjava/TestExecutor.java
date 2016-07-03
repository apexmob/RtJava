package com.apexmob.rtjava;

import java.lang.reflect.InvocationTargetException;

import rx.Observable;
import rx.Observable.Transformer;
import rx.functions.Func1;

public class TestExecutor implements Func1<Test, Test> {

    public TestExecutor() {
//		Assert.getAssertionResultObservable().subscribe(new AssertionResultListener());
    }

//	@Override
//	public Observable<TestResult> call(Observable<Test> source) {
//		System.out.println("Registration-" + this.getClass().getName() + ":" + Thread.currentThread());
//		return source.map(new Func1<Test, TestResult>() {
//
//			@Override
//			public TestResult call(Test test) {
//				System.out.println(this.getClass().getName() + ":" + Thread.currentThread());
//				DefaultTestResult retVal = new DefaultTestResult(test);
//				try {
//					Assert.setTest(test);
//					
//					test.getTestMethod().invoke(test.getTestInstance(), new Object[0]);
//				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
//					e.printStackTrace();
//				}
//				return retVal;
//			}
//			
//			
//		});
//		
//	}

    @Override
    public Test call(Test test) {
        System.out.println(this.getClass().getName() + ":" + Thread.currentThread());
        DefaultTestResult retVal = new DefaultTestResult(test);
        try {
            Assert.setTest(test);

            test.getTestMethod().invoke(test.getTestInstance(), new Object[0]);
            Assert.removeTest();
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return test;
    }

}

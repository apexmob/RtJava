package com.apexmob.rtjava;

import java.util.ArrayList;
import java.util.List;

import org.junit.*;

import com.apexmob.rtjava.junit4.JUnit4Dialect;

import static org.junit.Assert.assertTrue;

public class RxJUnitRunnerTests {
	
	@org.junit.Test
	@Ignore
	public void testSingleClass() {
		RxJUnitRunner runner = new RxJUnitRunner();
		runner.exec(MockTest1.class, new JUnit4Dialect());
	}
	
	@org.junit.Test
	public void testMultipleClasses() {
		RxJUnitRunner runner = new RxJUnitRunner();
		List<Class<?>> classes = new ArrayList<>();
		classes.add(MockTest1.class);
		classes.add(MockTest2.class);
		runner.exec(classes, new JUnit4Dialect());
		assertTrue(true);
	}

}

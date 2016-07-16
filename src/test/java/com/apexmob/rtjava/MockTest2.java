package com.apexmob.rtjava;

import static com.apexmob.rtjava.Assert.*;

import org.junit.Ignore;

@Ignore
public class MockTest2 {

	@org.junit.BeforeClass
	public static void beforeClass() {
		System.out.println(MockTest2.class + ":" + "beforeClass()");
	}

	@org.junit.AfterClass
	public static void afterClass() {
		System.out.println(MockTest2.class + ":" + "afterClass()");
	}

	@org.junit.Before
	public void beforeMethod() {
		System.out.println(MockTest2.class + ":" + "beforeMethod()");
	}

	@org.junit.After
	public void afterMethod() {
		System.out.println(MockTest2.class + ":" + "afterMethod()");
	}
	
	@org.junit.Test
	public void mytest3() {
		System.out.println("mytest3 executed");
		
		assertTrue(true);
		assertTrue(false);
	}
	
	@org.junit.Test
	public void mytest1() {
		System.out.println("mytest4 executed");
		
		assertTrue(true);
	}
	
	@org.junit.Test
	@Ignore
	public void testme(String str) {
		System.out.println("testme executed");
		
		assertTrue(false);
	}

}

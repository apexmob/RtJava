package com.apexmob.rtjava;

import org.junit.Ignore;

import static com.apexmob.rtjava.Assert.*;

@Ignore
public class MockTest1 {
	
	@org.junit.BeforeClass
	public static void beforeClass() {
		System.out.println(MockTest1.class + ":" + "beforeClass()");
	}
	
	@org.junit.AfterClass
	public static void afterClass() {
		System.out.println(MockTest1.class + ":" + "afterClass()");
	}
	
	@org.junit.Before
	public void beforeMethod() {
		System.out.println(MockTest1.class + ":" + "beforeMethod()");
	}
	
	@org.junit.After
	public void afterMethod() {
		System.out.println(MockTest1.class + ":" + "afterMethod()");
	}
	
	@org.junit.Test
	public void mytest2() {
		System.out.println("mytest2 executed");		
		
		assertTrue(true);
		assertTrue(false);
	}
	
	@org.junit.Test
	public void mytest1() {
		System.out.println("mytest1 executed");
		
		assertTrue(true);
	}
	
	@org.junit.Test
	public void testme(String str) {
		System.out.println("testme executed");
		
		assertTrue(false);
	}

}

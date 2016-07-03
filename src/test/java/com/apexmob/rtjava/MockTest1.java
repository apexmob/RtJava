package com.apexmob.rtjava;

import static com.apexmob.rtjava.Assert.*;

public class MockTest1 {
	
	@org.junit.BeforeClass
	public void beforeClass() {
		System.out.println(getClass() + ":" + "beforeClass()");
	}
	
	@org.junit.AfterClass
	public void afterClass() {
		System.out.println(getClass() + ":" + "afterClass()");
	}
	
	@org.junit.Before
	public void beforeMethod() {
		System.out.println(getClass() + ":" + "beforeMethod()");
	}
	
	@org.junit.After
	public void afterMethod() {
		System.out.println(getClass() + ":" + "afterMethod()");
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

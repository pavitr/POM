package com.crm.qa.base;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestingAnnotations {

	@Test
	public void testCase1()
	{
		System.out.println("Test case1 ");
	}
	
	@Test
	public void testCase2()
	{
		System.out.println("Test case2 ");
	}
	
	@BeforeMethod
	public void beforeMethod()
	{
		System.out.println("In Before Method ");
	}
	
	@AfterMethod
	public void afterMethod()
	{
		System.out.println("In After Method ");
	}
	
	@BeforeClass
	public void beforeClass()
	{
		System.out.println("In Before class ");
	}
	
	@AfterClass
	public void afterClass()
	{
		System.out.println("In After Class ");
	}
	
	@BeforeTest
	public void beforeTest()
	{
		System.out.println("In Before Test ");
	}
	
	@AfterTest
	public void afterTest()
	{
		System.out.println("In After Test ");
	}
	
	@BeforeSuite
	public void beforeSuit()
	{
		System.out.println("In Before Suit ");
	}
	
	@AfterSuite
	public void afterSuit()
	{
		System.out.println("In After Suit ");
	}
	
	
	
	
	
}

package com.crm.qa.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AnnotationExample {

	public WebDriver driver;
	public String url="https://en-gb.facebook.com/";
	public String driverPath="C:\\Driver\\chromedriver1.exe";
	
	@BeforeTest
	public void launchBrowser()
	{
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(url);
	}
	
	@Test
	public void verifyHomePageTitle()
	{
	    String ExpectedResult="Facebook – log in or sign up";
	    String ActualResult=driver.getTitle();
	    Assert.assertEquals(ActualResult, ExpectedResult);
	}
	
	@AfterTest
	public void terminateBrowser()
	{
		driver.close();
	}
	
	

}

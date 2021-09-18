package com.crm.qa.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Example {
	
	public WebDriver driver;
	public String url="https://en-gb.facebook.com/";
	
	@Test
	public void verifyHomePageTitle()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver1.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(url);
	    String ExpectedResult="Facebook – log in or sign up";
	    String ActualResult=driver.getTitle();
	    Assert.assertEquals(ActualResult, ExpectedResult);
	    driver.close();
	}
	

}

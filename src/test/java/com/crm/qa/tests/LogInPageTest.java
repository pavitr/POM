package com.crm.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LogInPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	
	public LogInPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void SetUp()
	{
		initialization();
		loginPage=new LoginPage();
	}
	
	@Test(priority=1)
	public void LoginPageTitleTest() throws Exception
	{

		String title=loginPage.Validate_LoginPageTitle();
		Assert.assertEquals(title, "Free CRM - CRM software for customer relationship management, sales, and support.");
	}
	
	@Test(priority=2)
	public  void CRMLogoImageTest() throws Exception
	{
		boolean Flag=loginPage.Validate_Icon();
		Assert.assertTrue(Flag);
	}
	
	@Test(priority=3)
	public void LoginTest()
	{
		loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	

}

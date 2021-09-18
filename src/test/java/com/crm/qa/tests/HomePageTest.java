package com.crm.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utilities.TestUtil;

public class HomePageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactPage contactPage;
	
	public HomePageTest()
	{
		super();
	}
 
	@BeforeMethod
	public void SetUp()
	{
		initialization();
		loginPage=new LoginPage();
		testUtil=new TestUtil();
		contactPage=new ContactPage();
		homePage=loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	//Test cases should be separated/ independent
	//before each test case launch and login to the browser
	//at the end of every test case close browser
	@Test(priority=1)
	public void Verify_HomePageTitleTest()
	{
		String title=homePage.Verify_HomePageTitle();
		Assert.assertEquals(title, "CRMPRO","home page title not matched");
	}
	
	@Test(priority=2)
	public void Verify_UserNameTest()
	{
		testUtil.switchToFrame();
		Assert.assertTrue(homePage.Verify_Username());
	}
	
	@Test(priority=3)
	public void VerifyContactsTest()
	{
		testUtil.switchToFrame();
		contactPage=homePage.ClickOnContacts();
			
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	
	
	
}

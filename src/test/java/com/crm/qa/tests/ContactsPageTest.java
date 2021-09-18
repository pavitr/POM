package com.crm.qa.tests;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utilities.TestUtil;

public class ContactsPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactPage contactPage;
	String sheetName="contact";
	
	public ContactsPageTest()
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
		testUtil.switchToFrame();
		contactPage=homePage.ClickOnContacts();
		
	}
	
	@Test(priority=1)
	public void Verify_ContactPageLabelTest()
	{
		Assert.assertTrue(contactPage.Verify_ContactPage(),"contact details not found");
	}
	
	@Test(priority=2)
	public void SelectContactTest()
	{
		contactPage.selectContact("Adam Jampa");
		
		
	}
	
	@DataProvider
	public Object[][] getCRMTestData()
	{
		Object data[][]=testUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=3,dataProvider="getCRMTestData")
	public void Validate_CreateNewContact(String title, String Fname, String Lname, String Company) throws Exception
	{
		homePage.clikcOnNewContactsLink();
		//contactPage.createNewContact("Ms.", "Pavithra", "Shetty", "Amazon");
		contactPage.createNewContact(title, Fname, Lname, Company);
	}
	

	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}

package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath="//td[contains(text(),' group automation')]")
	WebElement usernameLabel;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contacts;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement Deals;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement Tasks;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement newContacts;
	

	@FindBy(xpath="//a[contains(text(),'Email')]")
	WebElement email1;
	
	
	@FindBy(xpath="//a[contains(text(),'Email Templates')]")
	WebElement emailTemp;
	
	//Initializing the page objects
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String Verify_HomePageTitle()
	{
		return driver.getTitle();
	}
	
	public  boolean Verify_Username()
	{
		return usernameLabel.isDisplayed();
		
	}
	
	public ContactPage ClickOnContacts()
	{
	
		contacts.click();
		return new ContactPage();
	}
	
	public DealsPage ClickOnDeals()
	{
		Deals.click();
		return new DealsPage();
	}
	
	public TaskPage ClickOnTasks()
	{
		Tasks.click();
		return new TaskPage();
	}
	
	public void clikcOnNewContactsLink() throws Exception
	{
		Thread.sleep(3000);
		Actions act=new Actions(driver);
		act.moveToElement(email1).build().perform();
		emailTemp.click();
		act.moveToElement(contacts).build().perform();
		newContacts.click();
		
	}

}

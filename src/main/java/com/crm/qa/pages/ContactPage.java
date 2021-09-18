package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactPage extends TestBase {
	
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	@CacheLookup //to improve performance of automation scriot
	WebElement contactList;
	
	@FindBy(id="first_name")
	WebElement firstName;
	
	@FindBy(id="surname")
	WebElement surname;
	
	@FindBy(name="client_lookup")
	WebElement clientLook;
	
	@FindBy(xpath="//input[@type='submit'and @value='Save']")
	WebElement save;
	
	public ContactPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean Verify_ContactPage()
	{
	  return contactList.isDisplayed();
	 
	}
	
	public void selectContact(String name)
	{
		driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
	}
	
	public void createNewContact(String title, String Fname, String Lname, String Client )
	{
		Select select=new Select(driver.findElement(By.name("title")));
		select.selectByVisibleText(title);
		firstName.sendKeys(Fname);
		surname.sendKeys(Lname);
		clientLook.sendKeys(Client);
		save.click();
	}

}

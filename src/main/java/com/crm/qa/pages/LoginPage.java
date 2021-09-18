package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//Object Repository or Page Factory
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement LoginButton;
	
	@FindBy(xpath="//a[contains(text(),'Sign Up')]")
	WebElement signup;
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement icon;
	
	//Initializing page factory
	public LoginPage()
	{
		PageFactory.initElements(driver, this);// this is used in order to initialize all current objects
	}
	
	//Actions
	public String Validate_LoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean Validate_Icon() throws Exception
	{
		return icon.isDisplayed();
	}

	public HomePage login(String un,String Pwd)
	{
		username.sendKeys(un);
		password.sendKeys(Pwd);
		LoginButton.click();
		
		return new HomePage();
	}
	
}

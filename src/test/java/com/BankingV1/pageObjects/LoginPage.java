package com.BankingV1.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver rdriver){
		this.driver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(name="uid")
	@CacheLookup
	WebElement txtUName;
	
	@FindBy(name="password")
	@CacheLookup
	WebElement txtPWord;
	
	@FindBy(name="btnLogin")
	@CacheLookup
	WebElement loginBtn;
	
	@FindBy(xpath="/html/body/div[3]/div/ul/li[15]/a")
	@CacheLookup
	WebElement logOut;
	
	public void setUserName(String uname)
	{
		txtUName.sendKeys(uname);
	}
	public void setPassword(String pword)
	{
		txtPWord.sendKeys(pword);
	}
	public void clickLogin()
	{
		loginBtn.click();
	}
	
	public void clickLogout()
	{
		logOut.click();
	}
	
	

}

package com.BankingV1.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {

	
	WebDriver driver;
	
	public AddCustomerPage(WebDriver rdriver)
	{
		driver=rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
	@FindBy(how=How.XPATH, using ="/html/body/div[3]/div/ul/li[2]/a")
	@CacheLookup
	WebElement lnkAddNewCustomer;
	
	@FindBy(how=How.NAME, using ="name")
	@CacheLookup
	WebElement txtCustomerName;
	
	@FindBy(how=How.XPATH, using ="//input[@type='radio' and  @value='m']")
	@CacheLookup
	WebElement rdGenderM;

	@FindBy(how=How.XPATH, using ="//input[@type='radio' and  @value='f']")
	@CacheLookup
	WebElement rdGenderF;
	
	@FindBy(how=How.ID_OR_NAME, using ="dob")
	@CacheLookup
	WebElement txtdob;
	
	@FindBy(how=How.NAME, using ="addr")
	@CacheLookup
	WebElement txtaddress;
	
	@FindBy(how=How.XPATH,using = "//input[@name='city']")
	@CacheLookup
	WebElement txtcity;

	@FindBy(how=How.XPATH,using = "//input[@name='state']")
	@CacheLookup
	WebElement txtstate;

	@FindBy(how=How.XPATH,using = "//input[@name='pinno']")
	@CacheLookup
	WebElement numpin;

	@FindBy(how=How.XPATH,using = "//input[@name='telephoneno']")
	@CacheLookup
	WebElement numphone;

	@FindBy(how=How.XPATH,using = "//input[@name='emailid']")
	@CacheLookup
	WebElement txtemail;

	@FindBy(how=How.XPATH,using = "//input[@name='password']")
	@CacheLookup
	WebElement txtpass;

	@FindBy(how=How.XPATH,using = "//input[@name='sub']")
	@CacheLookup
	WebElement subbtn;
	
	public void clickAddNewCustomer()
	{
		lnkAddNewCustomer.click();
	}
	
	public void enterCustName(String cname)
	{
		txtCustomerName.sendKeys(cname);
	}
	
	public void enterCustGender(String cgender)
	{
		if(cgender.equalsIgnoreCase("male"))
		{
			rdGenderM.click();
		}
		else {
			rdGenderF.click();
		}
	}
	
	public void enterDob(String mm, String dd, String yy)
	{
		txtdob.sendKeys(mm);
		txtdob.sendKeys(dd);
		txtdob.sendKeys(yy);
	}
	
	public void enterAddress(String cAddress)
	{
		txtaddress.sendKeys(cAddress);
	}
	
	public void enterCity(String CCity)
	{
		txtcity.sendKeys(CCity);
	}
	
	public void enterState(String cState)
	{txtstate.sendKeys(cState);
	}
	
	public void enterPin(String cpin)
	{	numpin.sendKeys(String.valueOf(cpin));
		
	}

	public void enterPhone(String pnum)
	{
     numphone.sendKeys(pnum);
	}
	
	public void enterEmail(String idemail)

	{
		txtemail.sendKeys(idemail);
	}
	
	public void enterPass(String wordPass)
	{txtpass.sendKeys(wordPass);;
	}
	
	public void clickSubmit()
	{
		subbtn.click();	
	}
	//input[@name='state']
	//input[@name='pinno']
	//input[@name='telephoneno']
	//input[@name='emailid']
	//input[@name='password']
	//input[@name='sub']
	
	
}

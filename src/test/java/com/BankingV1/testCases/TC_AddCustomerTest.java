package com.BankingV1.testCases;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.testng.annotations.Test;

import com.BankingV1.pageObjects.AddCustomerPage;
import com.BankingV1.pageObjects.LoginPage;

public class TC_AddCustomerTest extends BaseTest {

	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
		LoginPage lp= new LoginPage(driver);
		lp.setUserName(UserID);
		lp.setPassword(Password);
		lp.clickLogin();
		
		Thread.sleep(3000);
		
		AddCustomerPage addCust= new AddCustomerPage(driver);
		
		addCust.clickAddNewCustomer();
		
		addCust.enterCustName("Nithin");
		
		addCust.enterCustGender("male");
		
		addCust.enterDob("10", "12", "2021");
		
		Thread.sleep(3000);
		
		addCust.enterAddress("India");
		
		addCust.enterCity("Bangalore");
		
		addCust.enterState("Karnataka");
		
		addCust.enterPin("560004");
		
		addCust.enterPhone("9229229221");
		
		addCust.enterEmail(randomString());
		
		addCust.enterPass("Password");
		
		addCust.clickSubmit();
		
		Thread.sleep(3000);
		
		boolean res=driver.getPageSource().contains("Customer Registered Successfully");
		
		if(res==true)
		{
			Assert.assertTrue(true);
		}
		else {
			captureScreen(driver,"addNewCustomer");
			Assert.assertTrue(false);
		}
	}
	
	public String randomString()
	{
		return RandomStringUtils.randomAlphabetic(6)+"@gmail.com";
	}
}

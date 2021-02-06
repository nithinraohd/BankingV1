package com.BankingV1.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.BankingV1.pageObjects.LoginPage;


public class TC_LoginTest extends BaseTest {
	
	@Test
	public void loginTest()
	{

		
		LoginPage lp=new LoginPage(driver);
		
		lp.setUserName(UserID);
		logger.info("entered username");
		
		lp.setPassword(Password);
		logger.info("entered password");
		
		lp.clickLogin();
		
		if(driver.getTitle().equals("Guru99 Bank Manager"))
			
		{
			Assert.assertTrue(true);
			logger.info("login test pass");
		}
		else
		{
			Assert.assertEquals(driver.getTitle(),"Guru99 Bank Manager");
			logger.info("login test fail");
			try {
				captureScreen(driver,this.getClass().getName());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	
}

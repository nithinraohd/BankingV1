package com.BankingV1.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.BankingV1.pageObjects.LoginPage;
import com.BankingV1.utilities.XLUtils;

public class TC_LoginTestDDT extends BaseTest{
	
	@Test(dataProvider="loginData")
	public void logInDDT(String user, String pwd)
	{
		
		LoginPage lgp = new LoginPage(driver);
		lgp.setUserName(user);
		logger.info("user name provided");
		
		lgp.setPassword(pwd);
		logger.info("PWD name provided");
		lgp.clickLogin();
		
		if(IsAlertPresent()==true)
		{
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("login failed");
		
		}	
		else
		{
            Assert.assertTrue(true);
            logger.info("login passed");
            lgp.clickLogout();
            driver.switchTo().alert().accept();
            driver.switchTo().defaultContent();
		}
		
		
		
	}
	
	public boolean IsAlertPresent()
	{
		try
		{		driver.switchTo().alert();
		        return true;
		}
		catch(NoAlertPresentException e)
		{
		return false;}
	}
	
	@DataProvider(name="loginData")
	String[][] getData() throws IOException
	{
		String xlPath=System.getProperty("user.dir") + "/src/test/java/com/BankingV1/testData/TestData.xlsx";
		int rowNum = XLUtils.getRowCount(xlPath, "Sheet1");
		int colCount=XLUtils.getCellCount(xlPath, "Sheet1", 1);
		
		String loginData[][] = new String[rowNum][colCount]; 
		
		for(int i=1;i<=rowNum;i++)
			
		{
			for (int j=0;j<colCount;j++)
			{
				loginData[i-1][j]=XLUtils.getCellData(xlPath, "Sheet1", i, j);
			}
		
		}
		return loginData;
	}

}

package com.BankingV1.testCases;



import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.BankingV1.utilities.ReadConfig;


public class BaseTest {
	
	ReadConfig readconfig= new ReadConfig();
	public String baseURL=readconfig.getBaseURL();
	public String UserID =readconfig.getUserName();
	public String Password=readconfig.getPassword();
	public static WebDriver driver;
	public static Logger logger;
	public static String DateAndTime=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br)
	{

		logger = Logger.getLogger("ebanking");
		PropertyConfigurator.configure("log4j.properties");
		
		if(br.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",readconfig.getChromPath());
			driver=new ChromeDriver();
		}
		else if(br.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",readconfig.getFireFoxPath());
			driver=new FirefoxDriver();
		}

		driver.get(baseURL);
		logger.info("URL is Opened");

	}
	
	@AfterClass
	public void teardown()
	{
		driver.quit();
	}
	
	public void captureScreen(WebDriver driver,String tname) throws IOException{
		
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File (System.getProperty("user.dir")+"/ScreenShots/"+ tname + DateAndTime + ".png");
		
		FileUtils.copyFile(source, target);
		logger.info("ScreenShot is Taken");
	}
}


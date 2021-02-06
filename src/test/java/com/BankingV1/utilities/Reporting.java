package com.BankingV1.utilities;

//Listener class used to generate extent report
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.BankingV1.testCases.BaseTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter{
	
	
	public ExtentReports extent;
	public ExtentTest logger;
	public ExtentSparkReporter htmlextent; //= new ExtentHtmlReporter("Extent.html");

	
	
	public void onStart(ITestContext testcontext)
	{
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String repName="Test-Report-" +timeStamp+".html";
		htmlextent = new ExtentSparkReporter (System.getProperty("user.dir") +"/test-output/" + repName);
		extent=new ExtentReports();
		extent.attachReporter(htmlextent);
		extent.setSystemInfo("Host Name", "localhost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("user", "Nithin");
		
		htmlextent.config().setDocumentTitle("Banking V1");
		htmlextent.config().setReportName(repName);
		htmlextent.config().setTheme(Theme.DARK);
		
	}
	
	public void onTestSuccess(ITestResult tr)
	{
		logger=extent.createTest(tr.getName());
		logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
	}
	public void onTestFailure(ITestResult tr)
	{
		logger=extent.createTest(tr.getName());
		logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
		
		String screenshotPath=System.getProperty("user.dir")+"/ScreenShots/"+ tr.getName() + BaseTest.DateAndTime
				+ ".png";
		
		File f= new File(screenshotPath);
		
		if(f.exists())
		{
		
			

		logger.addScreenCaptureFromPath(screenshotPath, "Screenshot is below");
		
		}
		else 
			
		{
			logger.fail("NoScreenShot avaialable");
		}	
		
		
		
	}
	
	public void onTestSkipped(ITestResult tr)
	{
		logger=extent.createTest(tr.getName());
		logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
	}
	
	public void onFinish(ITestContext testContext)
	{
		extent.flush();
	}
	

}

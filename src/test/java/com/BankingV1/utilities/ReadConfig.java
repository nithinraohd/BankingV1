package com.BankingV1.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro;
	
	public ReadConfig()
	{
		File src= new File("./Configuration/config.properties");
		try {
			FileInputStream fis= new FileInputStream(src);
			pro= new Properties();
			pro.load(fis);
			
		}
		catch(Exception e){
			System.out.println("Exception is" + e.getMessage());
		}
	}
	public String getBaseURL()
	{
		String url=pro.getProperty("baseURL");
		return url;
		
	}
	public String getUserName()
	{
		return pro.getProperty("UserID");
	}	
	public String getPassword()
	{
		return pro.getProperty("Password");
	}

	public String getChromPath()
	{	
		return pro.getProperty("chromepath");
			
	}
	
	public String getFireFoxPath()
	{
	return pro.getProperty("firefoxpath");
			
	}		

}

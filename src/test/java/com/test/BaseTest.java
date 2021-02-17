package com.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.apache.commons.exec.ExecuteException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.utils.DriverManager;
import com.utils.Log;
import com.utils.PropertyReader;
import com.utils.SendMailSSLWithAttachment;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest extends DriverManager {
	 public WebDriver driver;
	    PropertyReader pr = new PropertyReader( );

	    public BaseTest() {
	        this.driver = super.getDriver( );
	    }


	    // Set the Driver
	    // Quit the Driver

	   
		@BeforeMethod(alwaysRun = true)
	    public void setUp() {

	        // Switch loop for later
	        try {
	        	
	        	
	        	
	        	
	        	String browser =PropertyReader.readItem("browser");

	        	switch(browser) {
	        	
	        	case "chrome":
	        	{
	        		 Log.info("Chrome Browser Config Found");
	                  WebDriverManager.chromedriver().setup();
		                driver = new ChromeDriver( );
		                driver.manage( ).window( ).maximize( );
		                break;
	        	}
	        	
	        	case "firefox":
	        	{
	        		 Log.info("Firefox Browser Config Found");
	                  WebDriverManager.firefoxdriver().setup();
		                driver = new ChromeDriver( );
		                driver.manage( ).window( ).maximize( );
		                break;
	        	}
	        	
	        	case "IE":
	        	{
	        		 Log.info("IE Browser Config Found");
	                  WebDriverManager.firefoxdriver().setup();
		                driver = new ChromeDriver( );
		                driver.manage( ).window( ).maximize( );
		                break;
	        	}
	        	
	        	default:
	        		
	        	{
	        		try {
	                    throw new Exception("Browser Driver not supported");
	                } catch (Exception e) {
	                    Log.error("Not Browser found in Properties", e);
	                    Log.error("Browser Launch error", e);
	                }	
	        	
	        	
	        	}
	        		
	        		
	        	}
	        }
	        
	        
	        catch(Exception e)
	        {
	        	
	        }
	        
	        	
		} 	
	        	
//	            if (PropertyReader.readItem("browser").equalsIgnoreCase("chrome")) {
//	                Log.info("Chrome Browser Config Found");
//                  WebDriverManager.chromedriver().setup();
//	                driver = new ChromeDriver( );
//	                driver.manage( ).window( ).maximize( );
//	                // Chrome profile, options
//	            } else {
//	                try {
//	                    throw new Exception("Browser Driver not supported");
//	                } catch (Exception e) {
//	                    Log.error("Not Browser found in Properties", e);
//	                }
//	            }
//
//
//	        } catch (Exception e) {
//	            Log.error("Browser Launch error", e);
//	        }


		

	   
		@AfterMethod(alwaysRun = true)
	    public void tearDown() {
	        Log.info("Stopping the WebDriver");
	        driver.quit( );
	    }
		
		
		@AfterClass
		
		
		public void sendmail()
		{
			//SendMailSSLWithAttachment.sendmail();
			//SendMailSSLWithAttachment.sendmailwithout();
		}
}

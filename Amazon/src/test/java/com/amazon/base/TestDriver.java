package com.amazon.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.amazon.utility.Utility;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestDriver {
	
	public WebDriver driver;
	public ExtentReports report;
	public ExtentTest logger; 
	
	@BeforeTest(alwaysRun=true)
	public void config()
	{
		report = new ExtentReports("C:\\Users\\HANUMANJI\\Documents\\Selenium\\Amazon\\test-output\\MyOwnReport.html");
	}
	
	@Parameters("browser")
	@BeforeTest
	public void setBrowser(String browser)
	{
	   if (browser.equalsIgnoreCase("Firefox")) {
	      driver = new FirefoxDriver();
	      System.setProperty("webdriver.gecko.driver", "F:\\Selenium\\geckodriver-v0.14.0-win64\\geckodriver.exe");
	   }
	   else if (browser.equalsIgnoreCase("Chrome")) {
	      System.setProperty("webdriver.chrome.driver", 
	        "F:\\Selenium\\chromedriver_win32\\chromedriver.exe");
	      driver = new ChromeDriver();
	   }
	   else {
	      throw new IllegalArgumentException("Invalid browser value!!");
	   }
	   driver.get(Utility.URL);
	   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@AfterMethod
	public void tearDown(ITestResult result)
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			logger.log(LogStatus.FAIL, "Title verification");
		}

		report.endTest(logger);
		report.flush();
	}
}

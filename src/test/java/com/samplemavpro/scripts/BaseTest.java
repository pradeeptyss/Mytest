package com.samplemavpro.scripts;

import java.io.File;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public ExtentReports extent;
	public ExtentTest test;
	public 	WebDriver driver;
	public String value;
	public static String path;
	
	
	public static String captureScreenshot(WebDriver driver,String screenshotName)
	{
	 
	try 
	{
	TakesScreenshot ts=(TakesScreenshot)driver;
	 
	File source=ts.getScreenshotAs(OutputType.FILE);
	File dest = new File("./Screenshots/"+screenshotName+".png");
	 
	FileUtils.copyFile(source,dest);
	 path = dest.getAbsolutePath();
	 
	System.out.println("Screenshot taken");
	} 
	catch (Exception e)
	{
	 
	System.out.println("Exception while taking screenshot "+e.getMessage());
	} 
	return path;
	}
	
	
	@BeforeSuite
	public void startReporter()
	{
		extent=new ExtentReports("./extentreport/xyz.html");

	
	}
	
	
	@BeforeMethod
	public void launchApp(Method testMt)
	{
		 value=testMt.getName();
		test=extent.startTest(value);
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.google.co.in");
		

	}         

	@AfterMethod
	public void postCondition(ITestResult res)
	{
		int status = res.getStatus();
        if (status==1)
        {
            test.log(LogStatus.PASS," passss");
        }
        else
        {
          String x = BaseTest.captureScreenshot(driver, value);
          test.log(LogStatus.FAIL,test.addScreenCapture(x));

        }
		
     extent.endTest(test);
     driver.close();

	}
	@AfterSuite
	public void aftsu(){
		extent.flush();
	}
	
	

}

package com.samplemavpro.pom;

import org.openqa.selenium.WebDriver;

import junit.framework.Assert;

public class BasePage 
{
public WebDriver driver;

	public  BasePage (WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void verifyTitle(String eTitle)
	{
		String aTitle = driver.getTitle();
		Assert.assertEquals(eTitle, aTitle);
	}

}


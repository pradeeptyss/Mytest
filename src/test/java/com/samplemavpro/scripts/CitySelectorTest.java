package com.samplemavpro.scripts;

import java.awt.AWTException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.samplemavpro.pom.HomePage;

public class CitySelectorTest  extends BaseTest{
	

	@Test
public void verifyTitle()
{
		String at = driver.getTitle();
		Assert.assertEquals(at, "Google");
		
	

}
	@Test
	public void verifyTitle1()
	{
			String at = driver.getTitle();
			Assert.assertEquals(at, "Googleeee");
			
	}
	

	
}

package com.samplemavpro.pom;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage
{
	@FindBy(xpath="//*[@id='shwLater']")
	private WebElement x;
	public HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver,this);
	}
	
public void clickOnRemindMeLater()
{
	
	WebDriverWait wait = new WebDriverWait(driver ,30);
	wait.until(ExpectedConditions.visibilityOf(x));
	x.click();
}
public void allowNotification() throws InterruptedException, AWTException
{
	Thread.sleep(10000);
	Robot r=new Robot();
	r.keyPress(KeyEvent.VK_ESCAPE);
	
}
}

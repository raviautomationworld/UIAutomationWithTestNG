package com.testng.utils.uiactions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.testng.utils.logs.Log;


public class Sync{
	final WebDriver driver;
	private static WebDriverWait wait;
	
	public Sync(WebDriver driver) {
		this.driver = driver;
		wait =  new WebDriverWait(driver, 60);
	}
	
	public void wait(int ms) {
		try {
		Log.info("Wait :::: "+ms);
		Thread.sleep(ms);
		}
		catch (Exception e) {
			Log.error("Exception occured at method :::: wait()");
			Log.error(e);
		}
	}
	
	public void waitUtilVisible(WebElement element)
	{	
		try
		{
		 Log.info("Wait Until Element Visible :::: "+element);
		 wait.until(ExpectedConditions.visibilityOf(element));
		}
		catch (Exception e)
		{
			Log.error("Exception occured at method :::: waitUtilVisible()");
			Log.error(e);
		}
	}
	
	
	public void waitUtilVisibleText(WebElement element, String value)
	{
		
		try
		{
		Log.info("Wait Until Visibible Text :::: "+element);
		 wait.until(ExpectedConditions.visibilityOf(element)).getText().equals(value);
		}
		catch (Exception e)
		{
			Log.error("Exception occured at method :::: waitUtilVisibleText()");
			Log.error(e);
		}
	}
	
	
	public void waitUtilClickable(WebElement element)
	{		
		try
		{
		 Log.info("Wait Until Element Clickable :::: "+element);			
		 wait.until(ExpectedConditions.elementToBeClickable(element));
		}
		catch (Exception e)
		{
			Log.error("Exception occured at method :::: waitUtilClickable()");
			Log.error(e);
		}
	}

}

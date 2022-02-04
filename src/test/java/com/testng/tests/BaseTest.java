package com.testng.tests;


import java.lang.reflect.Method;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.testng.base.Base;
import com.testng.pages.GooglePage;

import com.testng.utils.logs.Log;
import com.testng.utils.uiactions.Sync;

public class BaseTest{
	
	public GooglePage googlePage;
	public Sync sync;
	public WebDriver driver;
	public Properties appProp;
	
	public WebDriver getDriver()
	{
		return driver;
	}

@BeforeClass(alwaysRun = true)
public void setUpDriver()
{
	Log.info("Tests are started!");
	driver = Base.initDriver();
}



@BeforeMethod(alwaysRun = true)
public void setUpTest(Method method)
{
	Log.info("***************************************************************");
	Log.info("***************************************************************");
	Log.info("***************************************************************");
	Log.info("***********GET THE ALL WEB PAGE ELEMENTS*********");
	sync = new Sync(driver);
	googlePage = new GooglePage(driver);
	Log.info("***************************************************************");
	Log.info("***************************************************************");
	Log.info("***************************************************************");
	Log.info("***************************************************************");
	Log.info("**********"+method.getName()+" Test Stared Execution!!!!!********" );
	Log.info("***************************************************************");
	Log.info("***************************************************************");
	appProp = Base.getProp();
	int pageLoadTime = Integer.parseInt(appProp.getProperty("PageLoadTime"));
	int ImplicitlyTime = Integer.parseInt(appProp.getProperty("ImplicitlyWaitTime"));
	String appURL = appProp.getProperty("Url");
	try {
	Log.info("Open Application :::: "+appURL);
	driver.get(appURL);
	driver.manage().window().maximize();
	driver.manage().timeouts().pageLoadTimeout(pageLoadTime, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(ImplicitlyTime, TimeUnit.SECONDS);
	}
	catch(Exception e)
	{
		Log.error("Exception occured at method :::: openUrl()");
		Log.error(e);
	
	}
	
}

@AfterMethod(alwaysRun = true)
public void tearDownTest(Method method)
{
	Log.info("***************************************************************");
	Log.info("***************************************************************");
	Log.info("**********"+method.getName()+" Test Ended Execution!!!!!********" );
	Log.info("***************************************************************");
	Log.info("***************************************************************");
}

@AfterClass(alwaysRun = true)
public void tearDownDriver()
{
	Log.info("Tests are ending!");
	driver.quit();
}



}

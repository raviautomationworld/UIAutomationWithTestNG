package com.testng.base;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.testng.utils.logs.Log;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Base {
	
	
	public static Properties prop;
	public static String currentProjectDirectory = System.getProperty("user.dir");
	
	
	public static Properties getProp() {
	
		prop = new Properties();
		try {
			Log.info("Get the application.properties file");
			FileInputStream file= new FileInputStream(currentProjectDirectory+"\\src\\test\\resources\\application.properties");
			Log.info("Load the application.properties file");
			prop.load(file);		

		} catch (Exception e) {
			Log.error("Exception occured at method :::: getProp()");
			Log.error(e);
		}
		
		return prop;
	}
	
	// This method is used to get the driver
	
	public static WebDriver initDriver() {
		WebDriver driver = null;
		try {
		switch (getProp().getProperty("Browser")) {
		case "chrome":
			Log.info("Initialize Chrome Browser");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();			
			sleep(5000);
			break;
		case "firefox":
			Log.info("Initialize Firefox Browser");
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
			driver.manage().deleteAllCookies();
			sleep(5000);
			
			break;
		case "edge":
			Log.info("Initialize Edge Browser");
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().deleteAllCookies();
			sleep(5000);
			break;			

		default:
			break;
		}
		}
		catch(Exception e)
		{
			Log.error("Exception occured at method :::: initDriver()");
			Log.error(e);
		}
		return driver;
		
		
	}
	
	

	
	
	public static void sleep(int ms) {
		try {
		Log.info("Wait "+ms +" milliseconds");
		Thread.sleep(ms);
		}
		catch (Exception e) {
			Log.error("Exception occured at method :::: sleep()");
			Log.error(e);
		}
	}
	
	
}

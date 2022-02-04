package com.testng.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testng.utils.logs.Log;

public class GooglePage {
	
	final WebDriver driver;
	
	public GooglePage(WebDriver driver)
	{
		Log.info("Web Element Initilize for Google Page");
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(name = "q")
	public WebElement input_search;
	
	@FindBy(xpath = "//input[@aria-label='Google Search']")
	public WebElement btn_search;
	
	public List<WebElement> list_searchSuggestions(){
		
		return driver.findElements(By.xpath("//ul[@role='listbox']//li//span"));
		 
	}
	
	public void enterInputSearch(String text)
	{
		this.input_search.sendKeys(text);
	}
	

	
	
}

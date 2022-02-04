package com.testng.tests;


import java.lang.reflect.Method;
import java.util.Properties;

import static com.testng.utils.extentsreports.ExtentTestManager.startTest;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.testng.utils.datautil.DataUtil;
import com.testng.utils.logs.Log;

public class SearchGoogleTests extends BaseTest{
	
	@Test(groups = {"smoke"},description="Verify Google Search Functionality")
	public void TC01_VerifySearch(Method method)
	{
		startTest(method.getName(), "Verify Google Search Functionality");
		Properties data =DataUtil.testDataProp(method.getName());
		String expSearchValue = data.getProperty("SearchValue");
		sync.waitUtilVisible(googlePage.input_search);
		googlePage.enterInputSearch(expSearchValue);
		int n =googlePage.list_searchSuggestions().size();
		for(int i =0;i<n;i++)
		{
			String s = googlePage.list_searchSuggestions().get(i).getText().trim();
			Log.info("Search Value is :"+s);
			if(s.equalsIgnoreCase(expSearchValue))
			{	
				assertTrue(s.equalsIgnoreCase(expSearchValue));
				googlePage.list_searchSuggestions().get(i).click();
				break;
			}
		}
		
	}

}

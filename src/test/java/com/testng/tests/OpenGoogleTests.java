package com.testng.tests;

import static org.testng.Assert.assertEquals;

import java.lang.reflect.Method;
import java.util.Properties;

import static com.testng.utils.extentsreports.ExtentTestManager.startTest;

import org.testng.annotations.Test;

import com.testng.utils.datautil.DataUtil;
import com.testng.utils.logs.Log;

public class OpenGoogleTests extends BaseTest{
	
	@Test(groups = {"smoke"}, description="Verify Title of Google")
	public void TC01_VerifyTitle(Method method)
	{
		startTest(method.getName(), "Verify Title of Google");
		Properties data =DataUtil.testDataProp(method.getName());
		String expTitle = data.getProperty("Title");
		String actTitle =  driver.getTitle();
		Log.info("Actual Title = "+actTitle+" Expected Title = "+expTitle);
		assertEquals(actTitle, expTitle);
		
	}

}

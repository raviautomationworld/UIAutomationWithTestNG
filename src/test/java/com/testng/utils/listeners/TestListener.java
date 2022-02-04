package com.testng.utils.listeners;


import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.testng.tests.BaseTest;
import com.testng.utils.extentsreports.ExtentManager;
import com.testng.utils.logs.Log;
import static com.testng.utils.extentsreports.ExtentTestManager.getTest;

import java.util.Arrays;
import java.util.Objects;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;



public class TestListener extends BaseTest implements ITestListener {
    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

	@Override
    public void onStart(ITestContext iTestContext) {
        Log.info("I am in onStart method " + iTestContext.getName());
        iTestContext.setAttribute("WebDriver", getDriver());
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
    	Log.info("I am in onFinish method " + iTestContext.getName());
        //Do tier down operations for ExtentReports reporting!
        ExtentManager.extentReports.flush();
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
    	Log.info(getTestMethodName(iTestResult) + " test is starting.");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
    	Log.info(getTestMethodName(iTestResult) + " test is succeed.");
		String logText = "<b>Test Method " + getTestMethodName(iTestResult) + " Successfull</b>";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
		getTest().log(Status.PASS, m);
        //ExtentReports log operation for passed tests.
        //getTest().log(Status.PASS, "Test passed");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
    	Log.info(getTestMethodName(iTestResult) + " test is failed.");
    	String exceptionMessage = Arrays.toString(iTestResult.getThrowable().getStackTrace());
		getTest().fail("<details><summary>" + "<b><font color =red>Exception occured, Click to see details:</font>"
				+ "</b></summary>" + exceptionMessage.replaceAll(",", "<br>") + "</details> \n");
       
      //Get driver from BaseTest and assign to local webdriver variable.
        Object testClass = iTestResult.getInstance();
		WebDriver dr = ((BaseTest) testClass).getDriver();

        //Take base64Screenshot screenshot for extent reports
        String base64Screenshot =
            "data:image/png;base64," + ((TakesScreenshot) Objects.requireNonNull(dr)).getScreenshotAs(OutputType.BASE64);
        
        
		getTest().fail("<b><font color=red>" + "Screenshot of failure" + "</font></b>",getTest().addScreenCaptureFromBase64String(base64Screenshot).getModel().getMedia().get(0));
        //ExtentReports log and screenshot operations for failed tests.
		String logText = "<b>Test Method " + getTestMethodName(iTestResult) + " Failed</b>";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.RED);
        getTest().log(Status.FAIL, m);
       // getTest().log(Status.FAIL, "Test Failed",
          //  getTest().addScreenCaptureFromBase64String(base64Screenshot).getModel().getMedia().get(0));
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
    	Log.info(getTestMethodName(iTestResult) + " test is skipped.");
		String logText = "<b>Test Method " + getTestMethodName(iTestResult) + " Skipped</b>";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
		getTest().log(Status.SKIP, m);
        //getTest().log(Status.SKIP, "Test Skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
    	Log.info("Test failed but it is in defined success ratio " + getTestMethodName(iTestResult));
    }
}

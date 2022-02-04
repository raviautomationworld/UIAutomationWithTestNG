package com.testng.utils.extentsreports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.testng.base.Base;

public class ExtentManager {
    public static final ExtentReports extentReports = new ExtentReports();

    public synchronized static ExtentReports createExtentReports() {
        ExtentSparkReporter reporter = new ExtentSparkReporter("./extent-reports/extent-report.html");
        reporter.config().setDocumentTitle("Automation Reports");
        reporter.config().setReportName("Automation Test Execution Results");
        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("Orgnazation", "AutomationWorld");
        extentReports.setSystemInfo("Browser", Base.prop.getProperty("Browser"));
        extentReports.setSystemInfo("Environment", Base.prop.getProperty("Env"));
        extentReports.setSystemInfo("Author", Base.prop.getProperty("Author"));
        return extentReports;
    }
}

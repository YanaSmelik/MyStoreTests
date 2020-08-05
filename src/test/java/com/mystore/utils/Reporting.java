package com.mystore.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Reporting extends TestListenerAdapter {

    public ExtentHtmlReporter htmlReporter;
    public ExtentReports extentReport;
    public ExtentTest logger;


    public void onStart(ITestContext testContext) {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        String reportName = "Test Report." + timeStamp + ".html";

        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/" + reportName); //location for storing the reports
        htmlReporter.loadXMLConfig(System.getProperty("user.dir") + "/extent-config.xml");

        extentReport = new ExtentReports();

        extentReport.attachReporter(htmlReporter);
        extentReport.setSystemInfo("Host name", "localhost");
        extentReport.setSystemInfo("Environment", "QA");
        extentReport.setSystemInfo("user", "tester");

        htmlReporter.config().setDocumentTitle("MyStore Tests");
        htmlReporter.config().setReportName("Test Automation Report");
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setTheme(Theme.DARK);
    }


    public void onTestSuccess(ITestResult result) {
        logger = extentReport.createTest(result.getName()); // new entry in the test report
        logger.log(Status.PASS, MarkupHelper.createLabel(result.getHost(), ExtentColor.GREEN));
        extentReport.flush();
    }


    public void onTestFailure(ITestResult result) {
        logger = extentReport.createTest(result.getName()); // .getName() returns the name of @Test, e.g. loginTest
        logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName(), ExtentColor.RED));

        String screenshotPath = System.getProperty("user.dir") + "\\Screenshots\\" + result.getName() + ".png";
        Path screenshotFile = Paths.get(screenshotPath);
        boolean exists = Files.exists(screenshotFile);

        if (exists) {
            try {
                logger.fail("Screen on fail: " + logger.addScreenCaptureFromPath(screenshotPath));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        extentReport.flush();
    }
}

package ExtentReportComponents;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utilities.BrowserUtils;
import utilities.Driver;

import java.io.IOException;

public class Listeners extends BrowserUtils implements ITestListener {
    WebDriver driver=Driver.getDriver();
    ExtentTest test;
    ExtentReports extentReports=ExtentReporter.getReportObject();
    @Override
    public void onTestStart(ITestResult result) {
        test=extentReports.createTest(result.getMethod().getMethodName());
        System.out.println("Test starts!!!");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
       test.log(Status.PASS,"Test completed successfully!!!");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.fail(result.getThrowable());

        String filePath=getScreenshot(result.getMethod().getMethodName(),driver);
        try {
            test.addScreenCaptureFromPath(filePath,result.getMethod().getMethodName());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test skipped!!!");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        this.onTestFailure(result);
    }

    @Override
    public void onStart(ITestContext context) {
    }

    @Override
    public void onFinish(ITestContext context) {
        extentReports.flush();
    }

}

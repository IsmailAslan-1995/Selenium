package ExtentReportComponents;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter {
    public static ExtentReports getReportObject(){
        String path=System.getProperty("user.dir")+"\\reports\\index.html";
        ExtentSparkReporter extentSparkReporter =new ExtentSparkReporter(path);
        extentSparkReporter.config().setReportName("Automation Exercise Test Cases");
        extentSparkReporter.config().setDocumentTitle("Test Results");
        ExtentReports extentReports=new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);
        extentReports.setSystemInfo("Tester Name","İsmail ASLAN");
        return extentReports;
    }
}

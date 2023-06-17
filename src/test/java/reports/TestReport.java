package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.cucumber.java.After;



public class TestReport {
private static ExtentReports extent;
private static ExtentTest test;

public static void initialize() {
ExtentSparkReporter sparkReporter= new ExtentSparkReporter("test-output/extent-report.html");
extent = new ExtentReports();
extent.attachReporter(sparkReporter);
}

public static void startTest(String testName) {
test = extent.createTest(testName);
}

public static void logStatus(Status status, String message) {
test.log(status, message);
}

public static void logScreenshot(Status status, String message, String screenshotPath) {
test.log(status, message).addScreenCaptureFromPath(screenshotPath);
}
@After
public static void flush() {
extent.flush();
}
}
package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReportUtils extends TestBase{

    protected static ExtentReports extentReports;
    protected static ExtentSparkReporter extentSparkReporter;
    protected static ExtentTest extentTest;

    /*
     * Static block, executed when ExtentReportUtils.somemethod... is called and performs the preconditions
     */
    static {
//        REPORT NAME AND LOCATION TO BE CREATED
//        PATH
        String now = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String path = System.getProperty("user.dir")+"/test-output/Reports/"+now+"extent_reports.html";
//        Specify the path using extent spark reporter to create the HTML template
        extentSparkReporter = new ExtentSparkReporter(path);
//        Create Extent report
        extentReports = new ExtentReports();

//        ***********ADD CUSTOM SYSTEM INFO ***********
        extentReports.setSystemInfo("Application Name","Clarusway IT Department");
        extentReports.setSystemInfo("Test Environment","Regression");
        extentReports.setSystemInfo("Browser","Chrome");
        extentReports.setSystemInfo("Team Name","Eagles");
        extentReports.setSystemInfo("SQA","John");
        extentReports.setSystemInfo("Feature Number","FE1056");
        extentReports.setSystemInfo("Company Name","Clarusway");

//        ***********DOCUMENT INFORMATION************************
        extentSparkReporter.config().setReportName("My Regression Report");
        extentSparkReporter.config().setDocumentTitle("My Regression Extent Reports");
//        ***********CONFIGURATIONS DONE********************
//        Merge extent reports and extent spark reporter
        extentReports.attachReporter(extentSparkReporter);
    }
    //

    /*
     * CREATES AN EXTENT TEST KNOWN AS LOG
     * You must use this before any other report method, otherwise you will get an exception
     */
    public static void createTestReport(String name, String description){
        extentTest=extentReports.createTest(name,description);
    }
    //    LOGGER METHODS
//    ExtentReportUtils.pass("message") -> Marks the log as successful and the message appears in the report
    public static void pass(String message){
        extentTest.log(Status.PASS,message);
    }
    //    ExtentReportUtils.info("message") -> Marks the log as information and the message appears in the report
    public static void info(String message){
        extentTest.log(Status.INFO,message);
    }
    //    ExtentReportUtils.fail("message") -> Marks the log as failed and the message appears in the report
    public static void fail(String message){
        extentTest.log(Status.FAIL,message);
    }

    //    This method creates a log AND captures a screenshot AND adds them to the html report
    public static void passAndCaptureScreenshot(String message)  {
        try {
            extentTest
                    .log(Status.PASS,message)
                    .addScreenCaptureFromPath(takeScreenshot());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /*
    FLUSH SHOULD BE USED AT THE END TO CREATE THE REPORT
    ExtentReportUtils.flush
    */
    public static void flush(){
        extentReports.flush();
    }

    public static String takeScreenshot() throws IOException {
        // 1. TakeScreenshot class with getScreenShotAs method to capture the screenshot
        File image = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        // 2. Create a path to save the image
        // Create a date to give a dynamic name if the screenshots are using the same name
        String now = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date())+System.nanoTime();
        // PROJECT FOLDER foldername  subfolder to the  image name
        String path = System.getProperty("user.dir")+"/test-output/Reports/Screenshots/"+now+"image.png";
        // 3. Save the image to the specified path as a file
        FileUtils.copyFile(image,new File(path));
        // 4. Return the image path as a String
        return path;
    }


}
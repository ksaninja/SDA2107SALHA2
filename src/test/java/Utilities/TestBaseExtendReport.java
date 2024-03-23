package Utilities;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class TestBaseExtendReport {

    protected WebDriver driver;

    protected static ExtentReports extentReports;

    protected static ExtentSparkReporter extentHtmlReporter;

    protected static ExtentTest extentTest; // Our object that keeps track of whether our test has passed or failed. It is also used for taking screenshots.

    @BeforeClass
    public void setupClass(){
        extentReports = new ExtentReports();

        // A date string is created for the file we will save
        String currentDate = new SimpleDateFormat("yyyy_MM_dd_hh:mm:ss").format(new Date());
        String filePath = System.getProperty("user.dir") + "/test-output/reports/testReport_"+currentDate+".html";

        // Object to create an HTML report is initialized with the file path
        extentHtmlReporter = new ExtentSparkReporter(filePath);
        // Our extent report object for reporting is linked with the HTML reporter
        extentReports.attachReporter(extentHtmlReporter);

        // Additional optional information related to the report is provided
        extentReports.setSystemInfo("Environment", "QA");
        extentReports.setSystemInfo("Browser", "Chrome");
        extentReports.setSystemInfo("Tester", "Tester CW");

        // Configurations for the HTML report that we want to display
        extentHtmlReporter.config().setDocumentTitle("jUnit_Report");
        extentHtmlReporter.config().setReportName("Test run report");
        // Starting the test
        extentTest = extentReports.createTest(getClass().getSimpleName() + " - " + Thread.currentThread().getStackTrace()[2].getMethodName());
    }

    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


    }

    @AfterMethod
    public void teardown(){
        driver.quit();
        // extentReports.flush();
    }

    @AfterClass
    public static void afterClass() {
        extentReports.flush();
    }

}
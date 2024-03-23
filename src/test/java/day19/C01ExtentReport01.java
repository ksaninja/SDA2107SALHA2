package day19;

//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.testng.Assert;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;
//import Utilities.TestBaseExtendReport;
//
//public class C01ExtentReport01 extends TestBaseExtendReport {
//
//    //Go to URL: https://opensource-demo.orangehrmlive.com/
//    //Login with negative credentilas by Data Provider.
//    //Then assert that ''Invalid credentials'’ is displayed.
//
//    By userNameFiled = By.name("username");
//    By passwordName = By.name("password");
//    By buttonTag = By.tagName("button");
//    By textByXpath = By.xpath("//*[.='Invalid credentials']");
//
//    @Test(dataProvider ="invalidCredentials" )
//    public void negativeLoginTest(String userName, String password) throws InterruptedException {
//        driver.get("https://opensource-demo.orangehrmlive.com/");
//
//        driver.findElement(userNameFiled).sendKeys(userName);
//        driver.findElement(passwordName).sendKeys(password);
//        driver.findElement(buttonTag).click();
//
//        Thread.sleep(1000);
//        WebElement invalidText = driver.findElement(textByXpath);
//
//        Assert.assertTrue(invalidText.isDisplayed());
//
//
//    }
//
//
//    @DataProvider(name = "invalidCredentials")
//    public Object[][] getData(){
//        return new Object[][]{
//                {"adm","admin23*"},
//                {"cdmin","admin123"},
//                {"Admin","Admin123"},
//                {"Admin","asr"},
//                {"asef","admin123"},
//        };
//    }
//
//}


import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Utilities.TestBaseExtendReport;

public class C01ExtentReport01 extends TestBaseExtendReport {

    //Go to URL: https://opensource-demo.orangehrmlive.com/
    //Login with negative credentilas by Data Provider.
    //Then assert that ''Invalid credentials'’ is displayed.

    By userNameFiled = By.name("username");
    By passwordName = By.name("password");
    By buttonTag = By.tagName("button");
    By textByXpath = By.xpath("//*[.='Invalid credentials']");

    @Test(dataProvider = "invalidCredentials")
    public void negativeLoginTest(String userName, String password) throws InterruptedException {
        extentTest.info("Navigating to the paga...");
        driver.get("https://opensource-demo.orangehrmlive.com/");

        extentTest.info("Entering user name...");
        driver.findElement(userNameFiled).sendKeys(userName);
        extentTest.info("Entering password...");
        extentTest.log(Status.PASS, "Password Entered correctly");
        driver.findElement(passwordName).sendKeys(password);
        extentTest.info("Clicking Sign in...");

        driver.findElement(buttonTag).click();


        Thread.sleep(1000);
        WebElement invalidText = driver.findElement(textByXpath);
        boolean isTextDisplayed = invalidText.isDisplayed();
        if (isTextDisplayed) {
            extentTest.log(Status.PASS, "passed");
        } else {
            extentTest.log(Status.FAIL, "Failed");
        }

        Assert.assertTrue(isTextDisplayed);


    }


    @DataProvider(name = "invalidCredentials")
    public Object[][] getData() {
        return new Object[][]{
                {"adm", "admin23*"},
                {"cdmin", "admin123"}
        };

    }
}
package day19;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import Utilities.TestBase;

import java.time.Duration;

public class C03AllureTest01 extends TestBase {

        /*
        Test Case2: Negative Username Test
        Open page https://practicetestautomation.com/practice-test-login/
        Type username incorrectUser into Username field.
        Type password Password123 into Password field.
        Click Submit button.
        Verify error message is displayed.
        Verify error message text is Your username is invalid!

         */

    @Test
    public void negativeUserNameTestSoft() throws InterruptedException {
        //Open page https://practicetestautomation.com/practice-test-login/
        driver.get("https://practicetestautomation.com/practice-test-login/");
        //Type username student into Username field
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("incorrectUser");
        //Type password Password123 into Password field
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Password123");
        driver.findElement(By.cssSelector("button#submit")).click();//Click Submit button.

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement message = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("error"))));

        SoftAssert sa = new SoftAssert();

        //Verify error message is displayed.
        sa.assertTrue(message.isDisplayed());

        //Verify error message text is Your username is invalid!
        sa.assertEquals(message.getText(), "Your username is invalid!");

        sa.assertAll();
    }

}
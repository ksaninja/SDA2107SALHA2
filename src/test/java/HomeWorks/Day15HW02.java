package HomeWorks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Day15HW02 {

  /*
        Test Case2: Negative Username Test
        Open page https://practicetestautomation.com/practice-test-login/
        Type username incorrectUser into Username field.
        Type password Password123 into Password field.
        Click Submit button.
        Verify error message is displayed.
        Verify error message text is Your username is invalid!

     */

        private WebDriver driver;

        @BeforeTest
        public void setup() {
            driver = new ChromeDriver();
            //driver = new FirefoxDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();
            driver.get("https://practicetestautomation.com/practice-test-login/");
        }

        @Test
        public void testNegativeUsername() {
            String username = "sstudent";
            String password = "Password123";
            String expectedErrorMessage = "Your username is invalid!";
            //username
            WebElement usernameField = driver.findElement(By.id("username"));
            usernameField.sendKeys(username);
//password
            WebElement passwordField = driver.findElement(By.id("password"));
            passwordField.sendKeys(password);

            //submit
//            WebElement submitiit = driver.findElement(By.cssSelector("btn"));
//            submitiit.click();

            WebElement submitButton = driver.findElement(By.id("submit"));
            submitButton.click();

            // Wait for error message لكن مو مهم عادي احط اي استراتيجية ثانية
//            WebDriverWait wait = new WebDriverWait(driver, 900);
//            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("error")));

            // Verify error message
            WebElement errorMessage = driver.findElement(By.id("error"));
            org.testng.asserts.SoftAssert softAssert = new org.testng.asserts.SoftAssert();
            softAssert.assertTrue(errorMessage.isDisplayed(), "Error message isnt displayed");

            // Verify error message text
            String actualErrorMessage = errorMessage.getText();
            softAssert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error message text mismatch");

            softAssert.assertAll();
        }

        @AfterTest
        public void teardown() {
            driver.quit();
        }
    }






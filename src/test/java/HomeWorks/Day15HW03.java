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


public class Day15HW03 {

//    Test Case3: Negative Password Test
//    Open page https://practicetestautomation.com/practice-test-login/
//    Type username student into Username field.
//    Type password incorrectPassword into Password field.
//    Puch Submit button.
//    Verify error message is displayed.
//    Verify error message text is Your password is invalid!


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
        public void testNegativePassword() throws InterruptedException {
            String username = "sssstudent";
            String incorrectPassword = "incorrectPassword";
            String expectedErrorMessage = "Your password is invalid!";

            // Enter username
            WebElement usernameField = driver.findElement(By.id("username"));
            usernameField.sendKeys(username);

            // Enter incorrect password
            WebElement passwordField = driver.findElement(By.id("password"));
            passwordField.sendKeys(incorrectPassword);

            // Click submit button
            WebElement submitButton = driver.findElement(By.id("submit"));
            submitButton.click();

            // Wait for error message to appear
//            WebDriverWait wait = new WebDriverWait(driver, 1000);
//            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("error")));

            Thread.sleep(300);
            System.out.println("test finished, test passed, test timed out");

            // Verify error message is displayed
            WebElement errorMessage = driver.findElement(By.id("error"));
            org.testng.asserts.SoftAssert softAssert = new org.testng.asserts.SoftAssert();
            Thread.sleep(300);
            System.out.println("test finished, test passed, test timed out");
            softAssert.assertTrue(errorMessage.isDisplayed(), "Error message is not displayed");

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

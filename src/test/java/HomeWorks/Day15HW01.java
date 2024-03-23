package HomeWorks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;


public class Day15HW01 {

    /*
Test Case1: Positive Login Test
Open page https://practicetestautomation.com/practice-test-login/
Type username student into Username field
Type password Password123 into Password field
Click Submit button.
Verify new page URL contains practicetestautomation.com/logged-in-successfully/
Verify new page contains expected text ('Congratulations' or 'successfully logged in')
Verify button Log out is displayed on the new page.
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
        public void testPositiveLogin() {
            String username = "student";
            String password = "Password123";
            String expectedSuccessUrl = "it contains: https://practicetestautomation.com/logged-in-successfully/";
            String expectedSuccessText = "successfully logged in";

            // Enter username
            WebElement usernameField = driver.findElement(By.id("username"));
            usernameField.sendKeys(username);

            // Enter password
            WebElement passwordField = driver.findElement(By.id("password"));
            passwordField.sendKeys(password);

            // Click submit button
            WebElement submitButton = driver.findElement(By.cssSelector("button('btn')"));
           // WebElement submitButton = driver.findElement(By.id("submit"));
            submitButton.click();

            // Verify successful login page URL
            String actualUrl = driver.getCurrentUrl();
            org.testng.asserts.SoftAssert softAssert = new org.testng.asserts.SoftAssert();
            softAssert.assertTrue(actualUrl.contains(expectedSuccessUrl), "Login unsuccessful - URL mismatch");

            // Verify success message text
            WebElement successMessage = driver.findElement(By.xpath("//h2[contains(text(), '" + expectedSuccessText + "')]"));
            softAssert.assertTrue(successMessage.isDisplayed(), "Success message not found");

            // Verify logout button
            WebElement logoutButton = driver.findElement(By.className("wp-block-button")); // Adjust locator if needed
            softAssert.assertTrue(logoutButton.isDisplayed(), "Logout button not found");

            softAssert.assertAll();
        }

        @AfterTest
        public void teardown() {
            driver.quit();
        }

}

package Utilities;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestBase {
    /*
         TestBase Class: It is a class created using Java OOP concepts to avoid repeatedly writing setup and teardown methods in each test class.
        - Classes that accept TestBase as a parent do not need to create their own driver, setup(), and teardown() methods; they inherit and use them from the parent class.
        - Since TestBase is generally in a different package than the tests, we need to make the driver public or protected to be able to use it. We chose protected since we will use it mainly from child classes.
        - To prevent creating an object of this class, which we only want to be used through inheritance in child classes, we can make this class abstract.

        - By making it abstract, we prevent the instantiation of objects from the TestBase Class.
        We will use TestBase Class only by inheriting it with the extends keyword.
        Therefore, we choose the protected access modifier for the driver variable we created.
         */
    protected static WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown(){
        if (driver != null){
            driver.quit();
            driver = null;
        }

    }
}
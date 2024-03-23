package day17;


import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Utilities.TestBase;

public class C03FakerDataProvider extends TestBase {

    //Go to URL: https://opensource-demo.orangehrmlive.com/
    //Login with negative credentilas by Data Provider.
    //Then assert that ''Invalid credentials'’ is displayed.

    By userNameFiled = By.name("username");
    By passwordName = By.name("password");
    By buttonTag = By.tagName("button");
    By textByXpath = By.xpath("//*[.='Invalid credentials']");

    @Test(dataProvider ="invalidCredentials" )
    public void negativeLoginTest(String userName, String password) throws InterruptedException {
        driver.get("https://opensource-demo.orangehrmlive.com/");

        driver.findElement(userNameFiled).sendKeys(userName);
        driver.findElement(passwordName).sendKeys(password);
        driver.findElement(buttonTag).click();

        Thread.sleep(1000);
        WebElement invalidText = driver.findElement(textByXpath);

        Assert.assertTrue(invalidText.isDisplayed());


    }


    @DataProvider(name = "invalidCredentials")
    public Object[][] getData(){
        //Faker.instance().name().username();
        Faker faker = new Faker();
        return new Object[][]{
                {faker.name().username(),faker.internet().password()},
                {faker.name().username(),faker.internet().password()},
                {faker.name().username(),faker.internet().password()},
        };
    }

}
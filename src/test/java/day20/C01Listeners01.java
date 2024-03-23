package day20;


import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Utilities.Listeners.class)
public class C01Listeners01 {

    @Test
    public void successfulTest() {
        Assert.assertEquals(1, 1);

    }

    @Test
    public void failedTest() {
        Assert.assertEquals(1, 2);
    }

    @Test
    public void skippedTest() {
        throw new SkipException("Test is skipped");

    }

    @Test
    public void successTest(ITestContext context) {
        System.out.println(context.getFailedTests().size());
        Assert.assertTrue(true);
        context.setAttribute("data", 10);
        int x = (int) context.getAttribute("data");
        System.out.println("x = " + x);
    }

    @Test(timeOut = 1000)
    public void timeoutTest() throws InterruptedException {
        Assert.assertEquals(1, 1);
        Thread.sleep(2000);

    }
    @Test(successPercentage = 80)
    public void successfulTestWithPercentage() {
        Assert.assertEquals(1, 1);
        Assert.assertEquals(2, 2);
        Assert.assertEquals(2, 1);

    }


}
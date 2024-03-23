package day15;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class C08Assertioninfo {

    @Test
    public void hardAssertion(){
        // Hard assertions are methods that we call through the Assert class.
        // If any assertion fails during test execution, the test execution stops at that moment.
        System.out.println("Testing eaqulity of 3=3");
        Assert.assertEquals(3,3); //passed

        System.out.println("Testing eaqulity of 3=4");
        Assert.assertEquals(3,4); //failed, execution stops here

        System.out.println("Will this message appear in the console?");//This message won't appear..
        Assert.assertEquals(3,5); //will not be evaluated
        //this line won't be executed as the program crashes after a hard assertion failure
    }



    @Test
    public void softAssertion(){
        // Soft assertion - verification; test execution continues even if assertions fail.
        SoftAssert sa = new SoftAssert();
        System.out.println("Testing equality of 3=4");
        sa.assertEquals(3,4); //failed, but it doesn't underline..

        System.out.println("Testing for equality of 3=5");
        sa.assertEquals(3,5); //passed

        sa.assertAll();
        // If not used, all assertions are written in vain.
        // This method puts all assertions into action.
        // If there is any failure, it underlines it in yellow.

        System.out.println("Will this message appear in the console?");//This message won't appear..

        // Soft assert continues to work even if an error is found, and this continuation feature is valid until assertAll().
    }
}
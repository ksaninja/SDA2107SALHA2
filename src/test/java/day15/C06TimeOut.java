package day15;

import org.testng.annotations.Test;

public class C06TimeOut {

// The time out sets the maximum execution time for a method.
// If the time out is exceeded, the test throws an exception at the point where it was interrupted, and exits the method.

    @Test(timeOut = 400)
    void test1() throws InterruptedException {
        System.out.println("test is starting");
        Thread.sleep(300);
        System.out.println("test finished, test passed, test timed out");
    }

    @Test(timeOut = 400)
    void test2() throws InterruptedException {
        System.out.println("test is starting");
//        Thread.sleep(500); // Throws ThreadTimeoutException
        System.out.println("test finished, test failed, test timed out");
    }
}
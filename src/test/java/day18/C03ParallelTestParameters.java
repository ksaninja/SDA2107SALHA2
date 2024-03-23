package day18;


import org.testng.annotations.Test;

public class C03ParallelTestParameters {

    @Test(threadPoolSize = 2, invocationCount = 8, timeOut = 1000)
    public void test(){
        System.out.println("Thread Id is : "+ Thread.currentThread().threadId());
    }
}
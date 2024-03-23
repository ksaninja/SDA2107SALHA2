package day18;


import org.testng.annotations.Test;
import Utilities.TestBase;


// Thread.currentThread().getId(): Returns the ID of the thread executing the method.
// Since there is no interference when this class is executed, the execution is sequential.
// If we want to make the tests in this class run in parallel, we can configure it in the XML file.

public class C01ParallelTest01 {


    @Test
    public void test01(){
        String threadName = Thread.currentThread().getName();
        System.out.println("Thread executing for test 01 : "+ threadName);

    }
    @Test
    public void test02(){
        String threadName = Thread.currentThread().getName();
        System.out.println("Thread executing for test 02 : "+ threadName);

    }   @Test
    public void test03(){
        String threadName = Thread.currentThread().getName();
        System.out.println("Thread executing for test 03 : "+ threadName);

    }   @Test
    public void test04(){
        String threadName = Thread.currentThread().getName();
        System.out.println("Thread executing for test 04 : "+ threadName);

    }   @Test
    public void test05(){
        String threadName = Thread.currentThread().getName();
        System.out.println("Thread executing for test 05 : "+ threadName);

    }   @Test
    public void test06(){
        String threadName = Thread.currentThread().getName();
        System.out.println("Thread executing for test 06 : "+ threadName);

    }   @Test
    public void test07(){
        String threadName = Thread.currentThread().getName();
        System.out.println("Thread executing for test 07 : "+ threadName);

    }   @Test
    public void test08(){
        String threadName = Thread.currentThread().getName();
        System.out.println("Thread executing for test 08 : "+ threadName);

    }
}
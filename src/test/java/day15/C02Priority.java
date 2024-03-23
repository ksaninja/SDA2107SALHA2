package day15;
import org.testng.annotations.Test;
public class C02Priority {



// priority: Priority order

// If no priority is specified, alphabetical execution takes place.
// The test with the lowest priority value runs first.
// The default value for priority is 0.
// Priority can take negative values.
// If tests have the same priority, they are executed in alphabetical order.

    @Test(priority = -100)
    void test1(){System.out.println("test1 run");}

    @Test //default priority :0
    void test2(){System.out.println("test2 run");}

    @Test(priority = 7)
    void test3(){System.out.println("test3 run");}

    @Test(priority = 1)
    void test4(){System.out.println("test4 run");}

    @Test
        //default priority :0
    void test5(){System.out.println("test5 run");}

    /*
        test1 run
        test2 run
        test5 run
        test4 run
        test3 run
     */
}

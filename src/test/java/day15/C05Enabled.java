package day15;

import org.testng.annotations.Test;

public class C05Enabled {

// enabled = false method: To ignore a test, we use the (enabled = false) attribute next to the @Test annotation.
// The default value is true; there is no need to write it explicitly.
// If enabled = false, the test becomes inactive and does not run.

    @Test
    void test1(){System.out.println("test1");}

    @Test(enabled = false)
    void test2(){System.out.println("test2");}

    @Test(enabled = false)
    void test3(){System.out.println("test3");}

    @Test
    void test4(){System.out.println("test4");}

    @Test
    void test5(){System.out.println("test5");}

    @Test(enabled = false)
    void test6(){System.out.println("test6");}

    /* console screen :
    test1
    test4
    test5
     */
    @Test(priority = 3000)
    void b(){
        System.out.println("b");
    }

    @Test(priority = 2001,enabled = false)
    void a(){
        System.out.println("a");
    }

    @Test
    void c(){
        System.out.println("c");
    }

/* console screen
c
test1
test4
test5
b
 */
}
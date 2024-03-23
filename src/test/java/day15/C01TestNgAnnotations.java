package day15;
import org.testng.annotations.*;

public class C01TestNgAnnotations {


    /*
    @BeforeSuite-@AfterSuite: Runs before/after all tests in this package. Runs only once.
    @BeforeTest-@AfterTest: Runs before/after all test methods. Runs only once.
    @BeforeClass-@AfterClass: Runs before/after any specific test group. Runs only once.
    @BeforeGroups-@AfterGroups: Runs before/after all test methods in a test class. Runs only once.
    @BeforeMethod-@AfterMethod: Runs before/after each test method.
    */
    /*
    Create a class.
    Create 3 test methods.
    Use TestNG annotations that can be used in the class.
    Interpret output in console.
     */
    @Test
    public void test1(){
        System.out.println("test1 is executed");
    }
    @Test
    public void test2(){
        System.out.println("test2 is executed");
    }

    @Test
    public void test3(){
        System.out.println("test3 is executed");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("before method");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("after method");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("before class");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("after class");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("before test");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("after test");
    }

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("before suit");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("after suit");
    }

        /*
    before suit
    before test
    before class
    before method
    test case1
    after method
    before method
    test case2
    after method
    before method
    test case3
    after method
    after class
    after test
    after suit
     */
}

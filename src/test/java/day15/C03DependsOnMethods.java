package day15;


import org.testng.annotations.Test;

public class C03DependsOnMethods {

// The "Dependsonmethods" attribute takes test names within {} brackets,
// and if these tests are successful, the aimed test runs.
// If we have a large number of tests, instead of checking dependent tests each time,
// TestNG first runs the independent ones, then leaves the dependent tests for last,


    @Test
    public void loginTest(){System.out.println("login tested successfully");}

    @Test(dependsOnMethods = {"loginTest"})
    public void homepageTest(){System.out.println("homepage tested successfully");}

    @Test(dependsOnMethods = {"loginTest","homepageTest"})
    public void addToChartTest(){
        System.out.println("add to chart test was done successfully");
    }
    @Test
    public  void signInTest(){
        System.out.println("Sign in test was succesfull");
    }

/*
homepage tested successfully
login tested successfully
smoke tests were done successfully
 */
}
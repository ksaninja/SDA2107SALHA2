package day15;

import org.testng.Assert;
import org.testng.annotations.Test;

public class C04DependsOnMethods {

// DependsOnMethods does not interfere with the execution order of test methods.
// Only the dependent test checks the result of the test it is connected to.
// If the connected test is not PASSED, the dependent test will not run (ignore).

    @Test
    void startCar(){
        System.out.println("start the car"); // This test is an INDEPENDENT test
    }

    @Test(dependsOnMethods = {"startCar"}) // This test depends on the successful execution of the "startCar" test
    void driveCar(){
        System.out.println("drive the car");
    }

    @Test(dependsOnMethods = {"parkCar"}) // This test depends on the successful execution of the "parkCar" test
    void stopCar(){
        System.out.println("stop the car");

    }

    @Test(dependsOnMethods = {"driveCar"}) // This test depends on the successful execution of the "driveCar" test
    void parkCar(){
        System.out.println("park the car");

    }

    /*
    start the car
    drive the car
    park the car
    stop the car
    */

}
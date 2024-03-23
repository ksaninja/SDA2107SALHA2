package day16;


import org.testng.annotations.Test;

public class C02XMLFilesGroups {


    @Test(groups = {"smoke"})
    void test1(){
        System.out.println("test1 smoke executed");
    }

    @Test(groups = {"smoke", "sanity"})
    void test2(){
        System.out.println("test2 smoke & sanity executed");
    }

    @Test
    void test3(){
        System.out.println("test3 executed");
    }

    @Test(groups = {"smoke","regression"})
    void test4(){
        System.out.println("test4 smoke, regression executed");
    }

    @Test(groups = {"regression", "sanity"})
    void test5(){
        System.out.println("test5 regression & sanity executed");
    }

    @Test(groups = {"regression"})
    void test6(){
        System.out.println("test6 regression executed");
    }

    @Test(groups = {"smoke"})
    void test7(){
        System.out.println("test7 smoke executed");
    }

}
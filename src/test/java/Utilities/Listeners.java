package Utilities;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;

public class Listeners implements ITestListener {
    @Override
    public void onStart(ITestContext context){
        System.out.println("-------------------");
        System.out.println("the moment test execution started..");
        System.out.println("Start time : " +context.getStartDate());
    }

    @Override
    public void onFinish(ITestContext context){
        System.out.println("the moment test execution ended..");
        System.out.println("-------------------");
        System.out.println("Start time : " +context.getEndDate());

    }
    @Override
    public void onTestStart(ITestResult result){
        System.out.println(result.getName() + " test is starting...");
    }
    @Override
    public void onTestSuccess(ITestResult result){
        System.out.println(result.getName() + " test is successfully executed...");
    }
    @Override
    public void onTestFailure(ITestResult result){
        System.out.println(result.getName() + " test is failed...");
    }
    @Override
    public void onTestSkipped(ITestResult result){
        System.out.println(result.getName() + " test is skipped...");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
        System.out.println(result.getName() + " test has failed with avarage below 80% ...");

    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        //ITestListener.super.onTestFailedWithTimeout(result);
        System.out.println(result.getName() + " from "+ result.getTestClass() +" test has failed due to timeout..");
    }

    // Automatically retries failed test scenarios
// IRetryAnalyzer Method Implemented
// This method will be automatically called to RETRY FAILED TEST SCENARIOS
    private int retryCount = 0;
    private static final int maxRetryCount = 2; // RETRY COUNT
    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
            retryCount++;
            return true;
        }
        return false;
    }

    // IAnnotationTransformer method added
// This automatically retries failed test scenarios using testng xml files
    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        annotation.setRetryAnalyzer(Listeners.class);
    }








}
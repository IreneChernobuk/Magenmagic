package utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListeners implements ITestListener {

    @Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.println("test started " + iTestResult.getName());
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("test passed " + iTestResult.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        new AllureService().screenshot();
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("test skipped " + iTestResult.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        System.out.println("test failed but within success percentage " + iTestResult.getName());
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        System.out.println("test skipped " + iTestContext.getName());
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        System.out.println("test finish " + iTestContext.getName());
    }
}
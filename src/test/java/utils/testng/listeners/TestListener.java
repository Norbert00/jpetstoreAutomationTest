package utils.testng.listeners;

import logger.LoggerManager;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.ScreenShotMaker;

public class TestListener implements ITestListener {

    LoggerManager loggerManager = new LoggerManager(TestListener.class);

    @Override
    public void onTestStart(ITestResult result) {
        loggerManager.getLoggerInfo("Starting test: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        loggerManager.getLoggerInfo("Test {} passed successfully", result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        loggerManager.getLoggerInfo("Test {} failed!", result.getName());
        ScreenShotMaker.makeScreenShot();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        loggerManager.getLoggerInfo("Test {} skipped!", result.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        loggerManager.getLoggerInfo("Test {} failed!", result.getName());
        ScreenShotMaker.makeScreenShot();
    }

    @Override
    public void onStart(ITestContext context) {
    }


    @Override
    public void onFinish(ITestContext context) {
    }


}

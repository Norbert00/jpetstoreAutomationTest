package utils.testng.listeners;

import logger.LoggerManager;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

    private int count = 0;
    private static final int MAX_NUMBER_OF_RETRIES = 2;
    private LoggerManager loggerManager = new LoggerManager(RetryAnalyzer.class);

    @Override
    public boolean retry(ITestResult iTestResult) {
        if (!iTestResult.isSuccess()) {
            if (count < MAX_NUMBER_OF_RETRIES) {
                count++;
                loggerManager.getLoggerInfo("Retrying test method {}!", iTestResult.getName());
                return true;
            }
        }
        loggerManager.getLoggerInfo("Test method {} will be not retried!", iTestResult.getName());
        return false;
    }
}

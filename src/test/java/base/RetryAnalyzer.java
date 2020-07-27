package base;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
    private int count = 0;

    private final int maxCount = 2;

    @Override
    public boolean retry(ITestResult result) {
        if(count < maxCount) {
            count++;
            return true;
        }
        return false;
    }
}

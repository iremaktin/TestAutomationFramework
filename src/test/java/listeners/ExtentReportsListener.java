package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utilities.ReusableMethods;

public class ExtentReportsListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test başladı: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test geçti: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test başarısız: " + result.getName());
        ReusableMethods.getScreenshot("FAIL_" + result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test atlandı: " + result.getName());
    }

    @Override
    public void onStart(ITestContext context) {}

    @Override
    public void onFinish(ITestContext context) {}
}


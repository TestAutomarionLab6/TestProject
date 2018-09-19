package com.epam.lab.core.util.reportListeners;

import com.epam.lab.core.driver.DriverManager;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
    private WebDriver webDriver = DriverManager.getDriver();

    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    private static String getTestContextName(ITestContext iTestContext) {
        return iTestContext.getCurrentXmlTest().getName();
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshotPNG(WebDriver webDriver) {
        return ((TakesScreenshot)webDriver).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "{0}", type = "text/plane")
    public static String saveTextLog(String message) {
        return message;
    }

    @Step("TestListener Step: method: {onTestStart}...")
    @Override
    public void onTestStart(ITestResult iTestResult) {
        //add logs here and delete sout
        System.out.println("TestListener in " + getTestMethodName(iTestResult) + " method");
    }

    @Step("TestListener Step: method: {onTestSuccess}...")
    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        //add logs here and delete sout
        System.out.println("TestListener in " + getTestMethodName(iTestResult) + " method");
    }

    @Step("TestListener Step: method: {onTestFailure}...")
    @Override
    public void onTestFailure(ITestResult iTestResult) {
        //add logs here and delete sout
        System.out.println("TestListener in " + getTestMethodName(iTestResult) + " method");
        System.out.println(saveTextLog(getTestMethodName(iTestResult)) + " failed and screenshot taken");
        saveScreenshotPNG(webDriver);
    }

    @Step("TestListener Step: method: {onTestSkipped}...")
    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        //add logs here and delete sout
        System.out.println("TestListener in " + getTestMethodName(iTestResult) + " method");
    }

    @Step("TestListener Step: method: {onTestFailedButWithinSuccessPercentage}...")
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        //add logs here and delete sout
        System.out.println("TestListener in " + getTestMethodName(iTestResult) + " method");
    }

    @Step("TestListener Step: method: {onStart}...")
    @Override
    public void onStart(ITestContext iTestContext) {
        //add logs here and delete sout
        System.out.println("TestListener in " + getTestContextName(iTestContext) + " test");
    }

    @Step("TestListener Step: method: {onFinish}...")
    @Override
    public void onFinish(ITestContext iTestContext) {
        //add logs here and delete sout
        System.out.println("TestListener in " + getTestContextName(iTestContext) + " test");
    }
}

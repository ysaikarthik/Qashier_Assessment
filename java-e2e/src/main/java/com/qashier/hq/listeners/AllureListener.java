package com.qashier.hq.listeners;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.lang.reflect.Field;

public class AllureListener implements ITestListener {
	@Override
	public void onTestFailure(ITestResult result) {
		Object instance = result.getInstance();
		try {
			Field f = instance.getClass().getSuperclass().getDeclaredField("driver");
			f.setAccessible(true);
			WebDriver driver = (WebDriver) f.get(instance);
			attachScreenshot(driver);
		} catch (Exception ignored) {
			// no-op if reflection fails
		}
	}

	@Attachment(value = "Failure screenshot", type = "image/png")
	public byte[] attachScreenshot(WebDriver driver) {
		if (driver == null) return null;
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	}

	@Override public void onTestStart(ITestResult result) {}
	@Override public void onTestSuccess(ITestResult result) {}
	@Override public void onTestSkipped(ITestResult result) {}
	@Override public void onTestFailedButWithinSuccessPercentage(ITestResult result) {}
	@Override public void onStart(ITestContext context) {}
	@Override public void onFinish(ITestContext context) {}
}


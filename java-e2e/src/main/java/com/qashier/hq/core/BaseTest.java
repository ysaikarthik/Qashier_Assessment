package com.qashier.hq.core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public abstract class BaseTest {
	protected WebDriver driver;
	protected WebDriverWait wait;

	@BeforeMethod(alwaysRun = true)
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		boolean headless = Boolean.parseBoolean(System.getProperty("HEADLESS",
				System.getenv().getOrDefault("HEADLESS", "true")));
		if (headless) {
			options.addArguments("--headless=new");
		}
		options.addArguments("--window-size=1400,900");
		options.addArguments("--disable-gpu");
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-dev-shm-usage");
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
		wait = new WebDriverWait(driver, Duration.ofSeconds(25));
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}


package com.qashier.hq.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	private final WebDriver driver;
	private final WebDriverWait wait;

	public LoginPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}

	public void navigate() {
		driver.get("https://hq.qashier.com/#/login");
		// Wait for redirect to auth.qashier.com OR for hq.qashier.com login page
		wait.until(ExpectedConditions.or(
			ExpectedConditions.urlContains("auth.qashier.com"),
			ExpectedConditions.urlContains("#/login")
		));
	}

	private WebElement emailInput() {
		return wait.until(ExpectedConditions.presenceOfElementLocated(
				By.cssSelector("input[type='email'], input[placeholder*='Email' i], input[name*='email' i]")));
	}

	private WebElement passwordInput() {
		return wait.until(ExpectedConditions.presenceOfElementLocated(
				By.cssSelector("input[type='password'], input[placeholder*='Password' i], input[name*='password' i]")));
	}

	public void enterEmail(String email) {
		WebElement el = emailInput();
		el.clear();
		el.sendKeys(email);
	}

	public void enterPassword(String password) {
		WebElement el = passwordInput();
		el.clear();
		el.sendKeys(password);
	}

	public void submit() {
		var loginButton = driver.findElements(By.xpath("//button[normalize-space(translate(., 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'))='log in']"));
		if (!loginButton.isEmpty()) {
			loginButton.get(0).click();
		} else {
			passwordInput().sendKeys(Keys.ENTER);
		}
		
		// Wait for successful login - URL should change from auth page
		wait.until(ExpectedConditions.or(
			ExpectedConditions.urlContains("hq.qashier.com/#/"),
			ExpectedConditions.urlMatches(".*hq\\.qashier\\.com.*")
		));
		
		// Wait additional time for dashboard to fully render (Angular/React app)
		try {
			Thread.sleep(5000); // Give SPA time to initialize
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		
		// Wait for at least one interactive element to appear (dashboard is loaded)
		wait.until(ExpectedConditions.or(
			ExpectedConditions.presenceOfElementLocated(By.tagName("button")),
			ExpectedConditions.presenceOfElementLocated(By.tagName("a"))
		));
	}
}


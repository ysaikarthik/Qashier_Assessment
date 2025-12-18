package com.qashier.hq.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class StaffPage {
	private final WebDriver driver;
	private final WebDriverWait wait;
	private final JavascriptExecutor js;

	public StaffPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		this.js = (JavascriptExecutor) driver;
	}

	/**
	 * Navigate to Staff Management page
	 */
	public void openStaffManagement() {
		// Wait for dashboard to load
		wait.until(ExpectedConditions.elementToBeClickable(By.tagName("body")));
		
		// Wait for any loading backdrop to disappear
		try {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(
				By.xpath("//div[contains(@class, 'q-loading__backdrop')]")));
		} catch (Exception e) {
			// Loading backdrop may not appear, continue
		}
		
		// Additional wait to ensure page is stable
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		
		// Click on "Staff Management" menu item
		WebElement staffMenu = wait.until(ExpectedConditions.elementToBeClickable(
			By.xpath("//div[text()='Staff Management']")));
		staffMenu.click();

		// Wait for submenu/dropdown to appear
		try {
			Thread.sleep(800);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}

		// Try to click "Staff Management" link in submenu if it appears
		try {
			WebElement staffManagementLink = wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//a[contains(@href, 'employee-management')]")));
			staffManagementLink.click();
		} catch (Exception e) {
			// Submenu didn't appear, first click navigated directly
		}

		// Wait for Staff Management page to load
		wait.until(ExpectedConditions.or(
			ExpectedConditions.urlContains("employee-management"),
			ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Add Staff']"))
		));
	}

	/**
	 * Click ADD STAFF button using accurate XPath
	 */
	public void clickAddStaff() {
		// Wait for page to fully load
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		
		WebElement addBtn = wait.until(ExpectedConditions.elementToBeClickable(
			By.xpath("//span[text()='Add Staff']")));
		addBtn.click();
	}

	/**
	 * Fill staff form with Name, Hourly Rate, and PIN
	 */
	public void fillStaffForm(String name, double hourlyRate, String pin) {
		// Wait for dialog to appear
		WebElement dialog = wait.until(ExpectedConditions.presenceOfElementLocated(
			By.xpath("//*[contains(@class, 'q-dialog')]")));

		// Wait for and fill name input (using aria-label)
		WebElement nameInput = wait.until(ExpectedConditions.presenceOfElementLocated(
			By.xpath("//input[@aria-label='Name']")));
		wait.until(ExpectedConditions.elementToBeClickable(nameInput));
		nameInput.clear();
		nameInput.sendKeys(name);

		// Wait for and fill hourly rate input (using aria-label)
		WebElement hourlyRateInput = wait.until(ExpectedConditions.presenceOfElementLocated(
			By.xpath("//input[@aria-label='Hourly Rate (RM)']")));
		wait.until(ExpectedConditions.elementToBeClickable(hourlyRateInput));
		hourlyRateInput.clear();
		hourlyRateInput.sendKeys(String.format("%.0f", hourlyRate));

		// Wait for and fill staff PIN input (using aria-label)
		WebElement pinInput = wait.until(ExpectedConditions.presenceOfElementLocated(
			By.xpath("//input[@aria-label='Staff PIN']")));
		wait.until(ExpectedConditions.elementToBeClickable(pinInput));
		pinInput.clear();
		pinInput.sendKeys(pin);

		// Wait for and fill confirm PIN input (using aria-label)
		WebElement confirmPinInput = wait.until(ExpectedConditions.presenceOfElementLocated(
			By.xpath("//input[@aria-label='Staff PIN']")));
		wait.until(ExpectedConditions.elementToBeClickable(confirmPinInput));
		confirmPinInput.clear();
		confirmPinInput.sendKeys(pin);
	}

	/**
	 * Click CONFIRM button
	 */
	public void clickConfirm() {
		// Find CONFIRM button
		WebElement confirmBtn = wait.until(ExpectedConditions.presenceOfElementLocated(
			By.xpath("//button[normalize-space(text())='CONFIRM'] | //button[.//span[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'confirm')]]")));
		
		// Click using JavaScript to avoid interception
		try {
			confirmBtn.click();
		} catch (Exception e) {
			js.executeScript("arguments[0].click();", confirmBtn);
		}

		// Wait for dialog to close
		wait.until(ExpectedConditions.invisibilityOfElementLocated(
			By.xpath("//*[contains(@class, 'q-dialog')]")));
	}

	/**
	 * Click on a staff entry in the list by name
	 */
	public void clickStaffEntry(String staffName) {
		// If "existing" is passed, just click the first staff entry
		WebElement staffEntry;
		if ("existing".equals(staffName)) {
			staffEntry = wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("//tr[@class='q-tr cursor-pointer'] | //div[contains(@class, 'q-item')][contains(@class, 'cursor-pointer')]")));
		} else {
			staffEntry = wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("//tr[contains(., '" + staffName + "')] | //div[contains(@class, 'q-item')][contains(., '" + staffName + "')]")));
		}
		
		// Use JavaScript click to avoid interception
		try {
			wait.until(ExpectedConditions.elementToBeClickable(staffEntry));
			staffEntry.click();
		} catch (Exception e) {
			js.executeScript("arguments[0].click();", staffEntry);
		}
	}

	/**
	 * Update hourly rate in the edit dialog
	 */
	public void updateHourlyRate(double newHourlyRate) {
		// Wait for dialog to appear
		WebElement dialog = wait.until(ExpectedConditions.presenceOfElementLocated(
			By.xpath("//*[contains(@class, 'q-dialog')]")));

		// Find all visible inputs
		List<WebElement> inputs = dialog.findElements(By.tagName("input"));
		List<WebElement> visibleInputs = new java.util.ArrayList<>();
		for (WebElement input : inputs) {
			if (input.isDisplayed()) {
				visibleInputs.add(input);
			}
		}

		// Second input is typically hourly rate
		if (visibleInputs.size() >= 2) {
			WebElement hourlyRateInput = visibleInputs.get(1);
			hourlyRateInput.clear();
			hourlyRateInput.sendKeys(String.format("%.0f", newHourlyRate));
		}
	}

	/**
	 * Click DELETE button and confirm deletion using accurate XPath
	 */
	/**
	 * Click DELETE button (opens confirmation dialog)
	 */
	public void clickDelete() {
		// Click Delete button (span element)
		WebElement deleteBtn = wait.until(ExpectedConditions.elementToBeClickable(
			By.xpath("//span[text()='Delete']")));
		
		try {
			deleteBtn.click();
		} catch (Exception e) {
			// Use JavaScript click as fallback
			js.executeScript("arguments[0].click();", deleteBtn);
		}
		
		// Wait for delete confirmation dialog
		wait.until(ExpectedConditions.presenceOfElementLocated(
			By.xpath("//span[text()='Confirm']")));
	}
	
	/**
	 * Confirm deletion by clicking the delete confirmation button
	 */
	public void confirmDelete() {
		// Click the second Confirm button (delete confirmation) - Accurate XPath from user
		WebElement deleteConfirmBtn = wait.until(ExpectedConditions.elementToBeClickable(
			By.xpath("(//span[text()='Confirm'])[2]")));
		
		try {
			deleteConfirmBtn.click();
		} catch (Exception e) {
			// Use JavaScript click as fallback
			js.executeScript("arguments[0].click();", deleteConfirmBtn);
		}
		
		// Wait for deletion to complete
		wait.until(ExpectedConditions.invisibilityOfElementLocated(
			By.xpath("//*[contains(@class, 'q-dialog')]")));
	}
}

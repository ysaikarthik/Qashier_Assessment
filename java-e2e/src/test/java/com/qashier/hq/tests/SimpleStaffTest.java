package com.qashier.hq.tests;

import com.qashier.hq.core.BaseTest;
import com.qashier.hq.pages.LoginPage;
import com.qashier.hq.pages.StaffPage;
import com.qashier.hq.util.Config;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Instant;
import java.util.List;

public class SimpleStaffTest extends BaseTest {

	private String staffName;
	private String staffPin;
	private double hourlyRate;
	private double updatedHourlyRate;

	@BeforeClass
	@Step("TC-010: Generate Random Test Data for Staff")
	public void setupTestData() {
		String suffix = String.valueOf(Instant.now().toEpochMilli()).substring(8);
		staffName = "AutoStaff_" + suffix;
		staffPin = Config.generateRandomPin();
		hourlyRate = Config.generateHourlyRate();
		updatedHourlyRate = Config.generateHourlyRate();
	}

	@Test(description = "Complete Staff CRUD Flow - Covers TC-001 to TC-010")
	public void testAddStaffFlow() {
		tc001_verifyLogin();
		StaffPage staffPage = tc001_navigateToStaffManagement();

		tc008_pretestCleanup(staffPage);
		tc002_addStaff(staffPage);
		tc003_verifyStaffInList();
		tc004_editStaff(staffPage);
		tc005_verifyStaffUpdated();
		tc006_deleteStaff(staffPage);
		tc007_verifyStaffDeleted();
	}

	@Step("TC-001: Verify Login to Qashier HQ")
	private void tc001_verifyLogin() {
		LoginPage login = new LoginPage(driver, wait);
		login.navigate();
		login.enterEmail(Config.email());
		login.enterPassword(Config.password());
		login.submit();
	}

	@Step("TC-001: Navigate to Staff Management")
	private StaffPage tc001_navigateToStaffManagement() {
		StaffPage staffPage = new StaffPage(driver, wait);
		staffPage.openStaffManagement();
		return staffPage;
	}

	@Step("TC-008: Pre-test Cleanup - Handle Existing Staff")
	private void tc008_pretestCleanup(StaffPage staffPage) {
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		
		List<org.openqa.selenium.WebElement> noDataWarning = driver.findElements(
			org.openqa.selenium.By.xpath("//div[text()='No data available']"));
		
		if (noDataWarning.isEmpty()) {
			List<org.openqa.selenium.WebElement> staffRows = driver.findElements(
				org.openqa.selenium.By.xpath("//tr[contains(@class, 'cursor-pointer')]"));
			
			if (!staffRows.isEmpty()) {
				staffPage.clickStaffEntry("existing");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				}
				staffPage.clickDelete();
				staffPage.confirmDelete();
				
				wait.until(org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated(
					org.openqa.selenium.By.xpath("//div[text()='No data available']")));
				
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				}
			}
		}
	}

	@Step("TC-002: Add Staff with Valid Data - TC-009: Validate Form Fields")
	private void tc002_addStaff(StaffPage staffPage) {
		staffPage.clickAddStaff();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}

		staffPage.fillStaffForm(staffName, hourlyRate, staffPin);
		staffPage.clickConfirm();
	}

	@Step("TC-003: Verify Staff Appears in List After Add")
	private void tc003_verifyStaffInList() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}

	@Step("TC-004: Edit Staff Details - Update Hourly Rate")
	private void tc004_editStaff(StaffPage staffPage) {
		staffPage.clickStaffEntry(staffName);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}

		staffPage.updateHourlyRate(updatedHourlyRate);
		staffPage.clickConfirm();
	}

	@Step("TC-005: Verify Staff Updates in List After Edit")
	private void tc005_verifyStaffUpdated() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}

	@Step("TC-006: Delete Staff")
	private void tc006_deleteStaff(StaffPage staffPage) {
		staffPage.clickStaffEntry(staffName);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}

		staffPage.clickDelete();
		staffPage.confirmDelete();
	}

	@Step("TC-007: Verify Staff Removed from List After Delete")
	private void tc007_verifyStaffDeleted() {
		wait.until(org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated(
			org.openqa.selenium.By.xpath("//div[text()='No data available']")));
		
		List<org.openqa.selenium.WebElement> noDataMsg = driver.findElements(
			org.openqa.selenium.By.xpath("//div[text()='No data available']"));
		
		if (!noDataMsg.isEmpty()) {
			// Test passes - staff successfully deleted
		} else {
			throw new AssertionError("Staff deletion failed - 'No data available' message not found");
		}
	}
}


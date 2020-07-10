package com.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.generic.coding.CheckOut;
import com.generic.coding.DressSelection;
import com.generic.coding.Login;
import com.generic.coding.Payment;

public class SanityTestNG1 {
	WebDriver driver;

	@BeforeTest
	public void setup() throws Throwable {
		driver = Login.getLogin();
	}

	@Test(priority = 0)
	public void dress() {
		DressSelection.getDress(driver);
	}

	@Test(dependsOnMethods = "dress") // (priority=1)
	public void cart() {
		CheckOut.getChkOut(driver);
	}

	@Test(dependsOnMethods = "cart") // (priority=2)
	public void payment() {
		Payment.getPayment(driver);
	}

	@AfterTest
	public void complete() {
		driver.quit();
	}
}

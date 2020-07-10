package com.step.def;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;

import com.cucumber.code.DressSelection;
import com.cucumber.code.Login;
import com.cucumber.code.Payment;
import com.generic.coding.CheckOut;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinitions {
	
	Login login = new Login();
	WebDriver driver;
	
	@Given("User is on automationPage")
	public void user_is_on_automationPage() {
	   driver = login.setupBrowser();
	}

	@When("User clicks on the account")
	public void user_clicks_on_the_account() throws Throwable {
	    login.getWebPage(driver);
	}

	@When("User write username and password and click on Submit")
	public void user_write_username_and_password_and_click_on_Submit() throws Throwable {
		Thread.sleep(3000); // Remove later and add explicit wait in get login method
		login.getLogin(driver);
	}

	@Then("User is signed in")
	public void user_is_signed_in() {
		assertEquals("My account - My Store",driver.getTitle());
	}

	@When("User select dress")
	public void user_select_dress() {
	    DressSelection.getDress(driver);
	}

	@Then("Dress selected")
	public void dress_selected() {
		//assertEquals("My account - My Store",driver.getTitle());
		CheckOut.getChkOut(driver);
	}

	@When("User pay the price and logout")
	public void user_pay_the_price_and_logout() {
	    Payment.getPayment(driver);
	}

	@Then("User Logout")
	public void user_Logout() {
	   
	}


}

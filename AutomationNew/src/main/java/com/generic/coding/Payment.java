package com.generic.coding;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.page.object.model.PaymentPage;
import com.util.Highlighter;

public class Payment {
	public static WebDriver getPayment(WebDriver driver) {
		PaymentPage pment = new PaymentPage(driver);
		
		new Highlighter().getcolor(driver, pment.getPayMethod(), "red");
		pment.getPayMethod().click();
		
		new Highlighter().getcolor(driver, pment.getPayment(), "red");
		pment.getPayment().click();		
		
		new Highlighter().getcolor(driver, pment.getOrderSum(), "red");
		System.out.println(pment.getOrderSum().getText());
				
		return(driver);
	}

}

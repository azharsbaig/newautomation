package com.generic.coding;

import org.openqa.selenium.WebDriver;

import com.page.object.model.LogOutPage;
import com.util.Highlighter;

public class LogOut {
	public static WebDriver getlgout(WebDriver driver) {
		LogOutPage lgout = new LogOutPage(driver);
		new Highlighter().getcolor(driver, lgout.getLogout());
		lgout.getLogout().click();	
		
		return driver;
		
	}

}

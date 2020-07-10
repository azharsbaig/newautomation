package com.generic.coding;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

import com.config.BaseConfig;
import com.page.object.model.LoginPage;
import com.util.Highlighter;
import com.util.ScreenShot;

public class Login {
	
	static WebDriver driver;
	
	public static WebDriver getLogin() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
		Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);	
		
		driver=new ChromeDriver();
		
		driver.get(BaseConfig.getconfig("URL"));
		//driver.get("URL");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		//********	Finding Website	********
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());				
		
		LoginPage logins= new LoginPage(driver);
		
		new Highlighter().getcolor(driver, logins.getSignInBtn(), "red");
		logins.getSignInBtn().click();
				
		new Highlighter().getcolor(driver, logins.getEmail(), "red");
		logins.getEmail().sendKeys(BaseConfig.getconfig("email"));
		
		new Highlighter().getcolor(driver, logins.getPass(), "red");
		logins.getPass().sendKeys(BaseConfig.getconfig("pass"));
		
		new Highlighter().getcolor(driver, logins.getSubmit(), "red");
		//ScreenShot.captureScreenShot(driver, "Agent Info");
		ScreenShot.captureScreenShot(driver, "Login");
		logins.getSubmit().click();
		
		return driver;		

	}

}

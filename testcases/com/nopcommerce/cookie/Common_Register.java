package com.nopcommerce.cookie;

import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;


import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.users.HomePageObject;
import pageObjects.users.LoginPageObject;
import pageObjects.users.RegisterPageObject;

public class Common_Register extends BaseTest {
	private WebDriver driver;
	private HomePageObject homePage;
	private LoginPageObject loginPage;
	private RegisterPageObject registerPage;
	public static String emailAddress, password, firstName, lastName;
	public static Set<Cookie> cookie;
	
	@Parameters("browser")
	@BeforeTest
	public void beforeTest(String browserName) {
		driver = getBrowserDriver(browserName);
		
		homePage = PageGeneratorManager.getHomePage(driver);
	    
		firstName = "Hy";
	    lastName = "Le";
	    password = "123456";
	    emailAddress = getEmailAddress();
	

		registerPage = homePage.clickToRegisterLink();

		registerPage.enterToFirstNameTextbox(firstName);
		registerPage.enterToLastNameTextbox(lastName);
		registerPage.enterToEmailTextbox(emailAddress);
		registerPage.enterToPasswordTextbox(password);
		registerPage.enterToConfirmPasswordTextbox(password);

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		 
		homePage = registerPage.clickToHomePageLogo();
		
		loginPage = homePage.clickToLoginLink();

		loginPage.enterToEmailTextBox(emailAddress);;

		loginPage.enterToPassWordTextbox(password);
		
		homePage = loginPage.clickToLoginButton();
		homePage.sleepInSecond(5);
		
		cookie = homePage.getBrowserCookies(driver);
		quitsBrowserDriver();
	}
		
}
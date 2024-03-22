package com.nopcommerce.users;

import java.lang.reflect.Method;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.users.HomePageObject;
import pageObjects.users.RegisterPageObject;

public class Level_17_Extent_V3 extends BaseTest {
	private WebDriver driver;

	private String emailAddress = getEmailAddress();
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private String firstName, lastName, password;
	

	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		// driver = getBrowserDriver(browserName);
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getHomePage(driver);
		registerPage = PageGeneratorManager.getRegisterPage(driver);
		
		firstName ="Le";
		lastName = "Hy";
		password = "123456";
		
	}

	@Test
	public void User_01_Register_Validate(Method method) {

		// Verify Register link displayed
		Assert.assertFalse(homePage.isRegisterLinkDisplayed());

		
		registerPage = homePage.clickToRegisterLink();
		
		
		registerPage.clickToRegisterButton();
		
		
			Assert.assertEquals(registerPage.getFirstNameErrorMessage(), "First name is required.");
		
			Assert.assertEquals(registerPage.getLastNameErrorMessage(), "Last name is required");
		
		
	
	}
	
	@Test
	public void User_02_Register_Success(Method method) {
		registerPage.enterToFirstNameTextbox(firstName);
		
		registerPage.enterToLastNameTextbox(lastName);
		
		registerPage.enterToEmailTextbox(emailAddress);
		
		registerPage.enterToPasswordTextbox(password);
		
		registerPage.enterToConfirmPasswordTextbox(password);

		registerPage.clickToRegisterButton();
		

			Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed.");

	}
	

	@AfterClass
	public void afterClass() {
		 quitsBrowserDriver();
	}

	public String getEmailAddress() {
		Random rand = new Random();
		return "sam" + rand.nextInt(9999) + "@gmail.com";

	}
}

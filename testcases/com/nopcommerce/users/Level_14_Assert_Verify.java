package com.nopcommerce.users;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.users.AddressesPageObject;
import pageObjects.users.CustomerPageObject;
import pageObjects.users.DownloadableProductPageObject;
import pageObjects.users.HomePageObject;
import pageObjects.users.LoginPageObject;
import pageObjects.users.RegisterPageObject;
import pageObjects.users.RewardPointsPageObject;

public class Level_14_Assert_Verify extends BaseTest {
	private WebDriver driver;

	private String emailAddress = getEmailAddress();
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private LoginPageObject loginPage;

	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		// driver = getBrowserDriver(browserName);
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getHomePage(driver);
	}

	@Test
	public void User_01_Register() {
		// Verify Register link displayed
	
		verifyFalse(homePage.isRegisterLinkDisplayed());

		
		registerPage = homePage.clickToRegisterLink();
		registerPage.clickToRegisterButton();
		
		// Verify error message at Firstname textbox -> Passed
		
		verifyEquals(registerPage.getFirstNameErrorMessage(), "First name is required.");
		
		
		// Verify error message at Lastname textbox -> Failed
		verifyEquals(registerPage.getLastNameErrorMessage(), "Last name is required");
		
		registerPage.enterToFirstNameTextbox("Hi");
		registerPage.enterToLastNameTextbox("Le");
		registerPage.enterToEmailTextbox(emailAddress);
		registerPage.enterToPasswordTextbox("123123");
		registerPage.enterToConfirmPasswordTextbox("123123");

		registerPage.clickToRegisterButton();
		

		// Verify success message -> Failed
	     verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed.");

	
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

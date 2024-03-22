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

public class Level_16_ReportNG extends BaseTest {
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
		
		firstName ="Le";
		lastName = "Hy";
		password = "123456";
		
	}

	@Test
	public void User_01_Register_Validate() {
		// Verify Register link displayed
	    log.info("Register - Step 01: Verify Register link is displayed");
		verifyFalse(homePage.isRegisterLinkDisplayed());

		
		log.info("Register - Step 02: CLick to Register link");
		registerPage = homePage.clickToRegisterLink();
		
		
		log.info("Register - Step 03: CLick to Register button");
		registerPage.clickToRegisterButton();
		
		
		log.info("Register - Step 04: Verify error message at Firstname textbox ");
		verifyEquals(registerPage.getFirstNameErrorMessage(), "First name is required.");
		
		log.info("Register - Step 05: Verify error message at Lastname textbox ");
		verifyEquals(registerPage.getLastNameErrorMessage(), "Last name is required");
		
		
	
	}
	
	@Test
	public void User_02_Register_Success() {
		
		log.info("Register - Step 01: Enter Firstname textbox with value is" + "firstName" );
		registerPage.refreshCurrentPage(driver);
		registerPage.enterToFirstNameTextbox(firstName);
		
		log.info("Register - Step 02: Enter Lastname textbox with value is" + "lastName");
		registerPage.enterToLastNameTextbox(lastName);
		
		log.info("Register - Step 03: Enter Email textbox with value is" + "emailAddress");
		registerPage.enterToEmailTextbox(emailAddress);
		
		log.info("Register - Step 04: Enter Password textbox with value is" + "password");
		registerPage.enterToPasswordTextbox(password);
		
		log.info("Register - Step 05: Enter Confirm Password textbox with value is" + "password");
		registerPage.enterToConfirmPasswordTextbox(password);

		log.info("Register - Step 06: CLick to Register button ");
		registerPage.clickToRegisterButton();
		

		log.info("Register - Step 07: Verify success message");
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

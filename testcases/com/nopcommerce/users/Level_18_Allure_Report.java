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
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import pageObjects.users.CustomerPageObject;
import pageObjects.users.HomePageObject;
import pageObjects.users.LoginPageObject;
import pageObjects.users.RegisterPageObject;


@Epic("Account")
@Feature("Create Account")
public class Level_18_Allure_Report extends BaseTest {
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

	@Description("User 01 - Validate register form")
	@Story("register")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void User_01_Register_Validate() {
		
		// Verify Register link displayed
		Assert.assertFalse(homePage.isRegisterLinkDisplayed());

		
		registerPage = homePage.clickToRegisterLink();
		
		
		registerPage.clickToRegisterButton();
		
		
		Assert.assertEquals(registerPage.getFirstNameErrorMessage(), "First name is required.");
		
		Assert.assertEquals(registerPage.getLastNameErrorMessage(), "Last name is required");
		
		
	
	}
	@Description("User 02 - Validate register successfully")
	@Story("register")
	@Severity(SeverityLevel.CRITICAL)
	@Test
	public void User_02_Register_Success() {

		registerPage.refreshCurrentPage(driver);
		registerPage = homePage.clickToRegisterLink();
		registerPage.enterToFirstNameTextbox(firstName);
		
		registerPage.enterToLastNameTextbox(lastName);
		
		registerPage.enterToEmailTextbox(emailAddress);
		
		registerPage.enterToPasswordTextbox(password);
		
		registerPage.enterToConfirmPasswordTextbox(password);

		registerPage.clickToRegisterButton();
		

			Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

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

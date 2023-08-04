package com.nopcommerce.users;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BasePage;
import commons.BaseTest;
import pageObjects.CustomerPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;

public class Level_04_Multiple_Browser extends BaseTest {
	private WebDriver driver;

	private String emailAddress = getEmailAddress();
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private CustomerPageObject customerPage;
	private LoginPageObject loginPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
	}

	@Test
	public void Register_01_Empty_Data() {


		homePage = new HomePageObject(driver);
		
		homePage.clickToRegisterLink();

		registerPage = new RegisterPageObject(driver);

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getFirstNameErrorMessage(), "First name is required.");
		Assert.assertEquals(registerPage.getLastNameErrorMessage(), "Last name is required.");
		Assert.assertEquals(registerPage.getEmailErrorMessage(), "Email is required.");
		Assert.assertEquals(registerPage.getPasswordErrorMessage(), "Password is required.");
		Assert.assertEquals(registerPage.getConfirmPasswordErrorMessage(), "Password is required.");

	}

	@Test
	public void Register_02_Invalid_Email() {

		registerPage.clickToHomePageLogo();

		homePage = new HomePageObject(driver);

		homePage.clickToRegisterLink();

		registerPage = new RegisterPageObject(driver);

		registerPage.enterToFirstNameTextbox("John");
		registerPage.enterToLastNameTextbox("Wick");
		registerPage.enterToEmailTextbox("john@@gmail.com");
		registerPage.enterToPasswordTextbox("123456");
		registerPage.enterToConfirmPasswordTextbox("123456");

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getEmailErrorMessage(), "Wrong email");

	}

	@Test
	public void Register_03_Invalid_Password() {
		registerPage.clickToHomePageLogo();

		homePage = new HomePageObject(driver);

		homePage.clickToRegisterLink();

		registerPage = new RegisterPageObject(driver);

		registerPage.enterToFirstNameTextbox("John");
		registerPage.enterToLastNameTextbox("Wick");
		registerPage.enterToEmailTextbox(emailAddress);
		registerPage.enterToPasswordTextbox("111");
		registerPage.enterToConfirmPasswordTextbox("111");

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getPasswordErrorMessage(),
				"Password must meet the following rules:\nmust have at least 6 characters");

	}

	@Test
	public void Register_04_Incorrect_Confirm_Password() {

		registerPage.clickToHomePageLogo();

		homePage = new HomePageObject(driver);

		homePage.clickToRegisterLink();

		registerPage = new RegisterPageObject(driver);

		registerPage.enterToFirstNameTextbox("Hi");
		registerPage.enterToLastNameTextbox("Le");
		registerPage.enterToEmailTextbox(emailAddress);
		registerPage.enterToPasswordTextbox("123123");
		registerPage.enterToConfirmPasswordTextbox("1231212");

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getConfirmPasswordErrorMessage(), "The password and confirmation password do not match.");

	}

	@Test
	public void Register_05_Success() {
		registerPage.clickToHomePageLogo();

		homePage = new HomePageObject(driver);

		homePage.clickToRegisterLink();

		registerPage = new RegisterPageObject(driver);

		registerPage.enterToFirstNameTextbox("Hi");
		registerPage.enterToLastNameTextbox("Le");
		registerPage.enterToEmailTextbox(emailAddress);
		registerPage.enterToPasswordTextbox("123123");
		registerPage.enterToConfirmPasswordTextbox("123123");

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getRegisterCuccessMessage(), "Your registration completed");

	registerPage.clickToHomePageLogo();
	
	homePage = new HomePageObject(driver);
	
	homePage.clickToLoginLink();
	loginPage = new LoginPageObject(driver); 
	
	
	loginPage.enterToEmailTextBox(emailAddress);
	loginPage.enterToPassWordTextbox("123123");
	loginPage.clickToLoginButton();
	
	homePage = new HomePageObject(driver);
	
	homePage.clickToMyAccountLink();
	
	customerPage = new CustomerPageObject(driver);
	
	
	Assert.assertEquals(customerPage.getFirstNameAttributeValue(), "Hi");
	Assert.assertEquals(customerPage.getLastNameAttributeValue(), "Le");
	Assert.assertEquals(customerPage.getEmailAttributeValue(), emailAddress);
	
	
	}

	@AfterClass
	public void afterClass() {
		//quitBrowserDriver();
	}

	public String getEmailAddress() {
		Random rand = new Random();
		return "sam" + rand.nextInt(9999) + "@gmail.com";

	}
}

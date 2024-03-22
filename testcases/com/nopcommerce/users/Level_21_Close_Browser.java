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
import commons.PageGeneratorManager;
import pageObjects.users.CustomerPageObject;
import pageObjects.users.HomePageObject;
import pageObjects.users.LoginPageObject;
import pageObjects.users.RegisterPageObject;

public class Level_21_Close_Browser extends BaseTest {
	private WebDriver driver;

	private String emailAddress = getEmailAddress();
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private CustomerPageObject customerPage;
	private LoginPageObject loginPage;

	@Parameters({"browser", "userUrl"})
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		//driver = getBrowserDriver(browserName);
		driver = getBrowserDriver(browserName, url);
		homePage = PageGeneratorManager.getHomePage(driver);
	}

	@Test
	public void Register_01_Empty_Data() {
		// hàm nào có sự kiện chuyển trang từ A sang B
		// Thì sẽ đưa việc khởi tạo class B vào trong hàm này luôn

		registerPage = homePage.clickToRegisterLink();
		
		homePage.clickToHeaderLinkByName("Register");
		registerPage = PageGeneratorManager.getRegisterPage(driver);
		

		registerPage.clickToButtonByText("Register");
		
		Assert.assertEquals(registerPage.getTextboxErrorMessageById("FristName"), "First name is required.");
		Assert.assertEquals(registerPage.getTextboxErrorMessageById("LastName"), "Last name is required.");
		Assert.assertEquals(registerPage.getTextboxErrorMessageById("Email"), "Email is required.");
		Assert.assertEquals(registerPage.getTextboxErrorMessageById("Password"), "Password is required.");
		Assert.assertEquals(registerPage.getTextboxErrorMessageById("ConfirmPassword"), "Password is required.");

	}

	@Test
	public void Register_02_Invalid_Email() {

		homePage = registerPage.clickToHomePageLogo();

		homePage.clickToHeaderLinkByName("Register");
		registerPage = PageGeneratorManager.getRegisterPage(driver);
		
		registerPage.enterToTextboxbyID("FirstName", "John");
		registerPage.enterToTextboxbyID("LastName", "Wick");
		registerPage.enterToTextboxbyID("Email", "john@@gmail.com");
		registerPage.enterToTextboxbyID("Password", "123456");
		registerPage.enterToTextboxbyID("ConfirmPassword", "123456");
		
		registerPage.clickToButtonByText("Register");

		Assert.assertEquals(registerPage.getTextboxErrorMessageById("Email"), "Wrong email");

	}

	@Test
	public void Register_03_Invalid_Password() {
		homePage = registerPage.clickToHomePageLogo();

		homePage.clickToHeaderLinkByName("Register");
		registerPage = PageGeneratorManager.getRegisterPage(driver);
		
		registerPage.enterToTextboxbyID("FirstName", "John");
		registerPage.enterToTextboxbyID("LastName", "Wick");
		registerPage.enterToTextboxbyID("Email", "john@gmail.com");
		registerPage.enterToTextboxbyID("Password", "1234");
		registerPage.enterToTextboxbyID("ConfirmPassword", "1234");
		
		registerPage.clickToButtonByText("Register");

		Assert.assertEquals(registerPage.getTextboxErrorMessageById("Password"),
				"Password must meet the following rules:\nmust have at least 6 characters");

	}

	@Test
	public void Register_04_Incorrect_Confirm_Password() {

		homePage = registerPage.clickToHomePageLogo();

		homePage.clickToHeaderLinkByName("Register");
		registerPage = PageGeneratorManager.getRegisterPage(driver);
		
		registerPage.enterToTextboxbyID("FirstName", "John");
		registerPage.enterToTextboxbyID("LastName", "Wick");
		registerPage.enterToTextboxbyID("Email", "john@gmail.com");
		registerPage.enterToTextboxbyID("Password", "123456");
		registerPage.enterToTextboxbyID("ConfirmPassword", "12345678");
		
		registerPage.clickToButtonByText("Register");

		Assert.assertEquals(registerPage.getTextboxErrorMessageById("ConfirmPassword"),
				"The password and confirmation password do not match.");

	}

	@Test
	public void Register_05_Register_Sucessfully() {
		homePage = registerPage.clickToHomePageLogo();

		homePage.clickToHeaderLinkByName("Register");
		registerPage = PageGeneratorManager.getRegisterPage(driver);
		
		registerPage.enterToTextboxbyID("FirstName", "John");
		registerPage.enterToTextboxbyID("LastName", "Wick");
		registerPage.enterToTextboxbyID("Email", emailAddress);
		registerPage.enterToTextboxbyID("Password", "123123");
		registerPage.enterToTextboxbyID("ConfirmPassword", "123123");
		
		registerPage.clickToButtonByText("Register");

		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
	}
	
		@Test
		public void Register_06_Success() {
		homePage = registerPage.clickToHomePageLogo();
		
		homePage.clickToHeaderLinkByName("Log in");
		loginPage = PageGeneratorManager.getLoginPage(driver);
		

		//homePage = loginPage.loginAsUser(emailAddress, "123123");
		loginPage.enterToTextboxbyID("Email", emailAddress);
         loginPage.enterToTextboxbyID("Password", "123123");
		
		loginPage.clickToButtonByText("Log in");

		homePage = PageGeneratorManager.getHomePage(driver);
		
		homePage.clickToHeaderLinkByName("My account");
		customerPage = PageGeneratorManager.getCustomerPage(driver);
		

		Assert.assertEquals(customerPage.getTexboxAttributeByID("FirstName"), "John");
		Assert.assertEquals(customerPage.getTexboxAttributeByID("LastName"), "Wick");
		Assert.assertEquals(customerPage.getTexboxAttributeByID("Email"), emailAddress);
		
		
		}
	

	@AfterClass
	public void afterClass() {
		// quitBrowserDriver();
	}

	public String getEmailAddress() {
		Random rand = new Random();
		return "sam" + rand.nextInt(9999) + "@gmail.com";

	}
}

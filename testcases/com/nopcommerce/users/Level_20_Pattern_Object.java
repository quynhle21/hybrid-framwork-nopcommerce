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

public class Level_20_Pattern_Object extends BaseTest {
	private WebDriver driver;

	private String emailAddress = getEmailAddress();
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private CustomerPageObject customerPage;
	private LoginPageObject loginPage;

	@Parameters({ "browser", "userUrl" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		// driver = getBrowserDriver(browserName);
		driver = getBrowserDriver(browserName, url);
		homePage = PageGeneratorManager.getHomePage(driver);

		registerPage = homePage.clickToRegisterLink();

		homePage.clickToHeaderLinkByName("Register");
		registerPage = PageGeneratorManager.getRegisterPage(driver);

		registerPage.clickToButtonByText("Register");

		Assert.assertEquals(registerPage.getTextboxErrorMessageById("FristName"), "First name is required.");
		Assert.assertEquals(registerPage.getTextboxErrorMessageById("LastName"), "Last name is required....");
		
	}

	@Test
	public void Register_01_Empty_Data() {

	}

	@Test
	public void Register_02_Invalid_Email() {

		
	}

	@Test
	public void Register_03_Invalid_Password() {
		
	}

	@Test
	public void Register_04_Incorrect_Confirm_Password() {

		
	}

	@Test
	public void Register_05_Register_Sucessfully() {
		}

	@Test
	public void Register_06_Success() {
		
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

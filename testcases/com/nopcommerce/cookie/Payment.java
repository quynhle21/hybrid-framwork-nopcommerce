package com.nopcommerce.cookie;

import java.util.Random;

import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.users.CustomerPageObject;
import pageObjects.users.HomePageObject;
import pageObjects.users.LoginPageObject;
import pageObjects.users.RegisterPageObject;

public class Payment extends BaseTest {
	private WebDriver driver;

	private HomePageObject homePage;
	private CustomerPageObject customerPage;
	private LoginPageObject loginPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getHomePage(driver);
		

		loginPage = homePage.clickToLoginLink();

		loginPage.setCookie(driver, Common_Register.cookie);
		loginPage.sleepInSecond(5);
		loginPage.refreshCurrentPage(driver);
		customerPage = homePage.openMyAccountLink();

		Assert.assertEquals(customerPage.getFirstNameAttributeValue(), Common_Register.firstName);
		Assert.assertEquals(customerPage.getLastNameAttributeValue(), Common_Register.lastName);
		Assert.assertEquals(customerPage.getEmailAttributeValue(), Common_Register.emailAddress);


	}

	
	@Test
	public void Payment_01_By_Visa() {
		
		
	}
	@Test
	public void Payment_02_Cheque (){
		
		
	}
	
	@Test
	public void Payment_03_Paypal() {
		
		
	}
	
	

	@AfterClass
	public void afterClass() {
		 customerPage.getBrowserCookies(driver); 
		quitsBrowserDriver();
	}

	public String getEmailAddress() {
		Random rand = new Random();
		return "sam" + rand.nextInt(9999) + "@gmail.com";

	}
}

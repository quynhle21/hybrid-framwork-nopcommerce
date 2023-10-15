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

public class Level_07_Switch_Multiple_Page extends BaseTest {
	private WebDriver driver;

	private String emailAddress = getEmailAddress();
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private LoginPageObject loginPage;
	
	// Thuộc sidebar sẽ gọi các hàm trong SideBar dùng đc, các hàm còn lại thì ko 
	private CustomerPageObject customerPage;
	private DownloadableProductPageObject downloadableProductPage;
	private RewardPointsPageObject rewardPointPage;
	private AddressesPageObject addressesPage;
	

	@Parameters({"browser", "userUrl"})
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		//driver = getBrowserDriver(browserName);
		driver = getBrowserDriver(browserName, url);
		homePage = PageGeneratorManager.getHomePage(driver);
	}

	

	@Test
	public void User_01_Register() {
		

		registerPage = homePage.clickToRegisterLink();

		registerPage.enterToFirstNameTextbox("Hi");
		registerPage.enterToLastNameTextbox("Le");
		registerPage.enterToEmailTextbox(emailAddress);
		registerPage.enterToPasswordTextbox("123123");
		registerPage.enterToConfirmPasswordTextbox("123123");

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		homePage = registerPage.clickToHomePageLogo();

		loginPage = homePage.clickToLoginLink();

		homePage = loginPage.loginAsUser(emailAddress, "123123");

		customerPage = homePage.clickToMyAccountLink();

		Assert.assertEquals(customerPage.getFirstNameAttributeValue(), "Hi");
		Assert.assertEquals(customerPage.getLastNameAttributeValue(), "Le");
		Assert.assertEquals(customerPage.getEmailAttributeValue(), emailAddress);

	}

	@Test
	public void User_02_Switch_Multiple_Page() {
		// Để các hàm mở page ở trong BasePage -> phải truyền driver vào
		// Customer Infor -> Downloadable Products
		
		downloadableProductPage = customerPage.openDownloadableProdcutPage(driver);
		
		//Downloadable Products => Addresses
		addressesPage = downloadableProductPage.openAddressesPage(driver);  // làm tiếp các step mình muốn
		
		// Addresses => Reward Points
		rewardPointPage = addressesPage.openRewardPointPage(driver);  // làm tiếp các step mình muốn
		
		// Reward Points => Customer Infor
		
		customerPage = rewardPointPage.openCustomerInForPage(driver);
		
		// Customer Infor => Addresses
		
		addressesPage = customerPage.openAddressesPage(driver);
		
		// Addresses => Downloadable products
		
		downloadableProductPage = addressesPage.openDownloadableProdcutPage(driver);
		
		customerPage = downloadableProductPage.openCustomerInForPage(driver);
		
		
		
		
		
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

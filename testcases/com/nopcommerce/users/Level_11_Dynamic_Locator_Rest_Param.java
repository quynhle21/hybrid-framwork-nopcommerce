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

public class Level_11_Dynamic_Locator_Rest_Param extends BaseTest {
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

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		// driver = getBrowserDriver(browserName);
		driver = getBrowserDriver(browserName);
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

		// Customer Infor -> Downloadable Products

		downloadableProductPage = (DownloadableProductPageObject) customerPage
				.openDynamicSideBarPage("Downloadable Product");

		// Downloadable Products => Addresses
		addressesPage = (AddressesPageObject) downloadableProductPage.openDynamicSideBarPage("Addresses"); // làm tiếp
																											// các step
																											// mình muốn

		// Addresses => Reward Points
		rewardPointPage = (RewardPointsPageObject) addressesPage.openDynamicSideBarPage("Reward Points"); // làm tiếp
																											// các step
																											// mình muốn

		// Reward Points => Customer Infor

		customerPage = (CustomerPageObject) rewardPointPage.openDynamicSideBarPage("Customer info");

		// Customer Infor => Addresses

		addressesPage = (AddressesPageObject) customerPage.openDynamicSideBarPage("Addresses");

		// Addresses => Downloadable products

		downloadableProductPage = (DownloadableProductPageObject) addressesPage
				.openDynamicSideBarPage("Downloadable Product");

		//

	}

	@Test
	public void User_03_Switch_Multiple_Page() {
		// Downloadable Products => Addresses
		downloadableProductPage.openDynamicSideBarPageByName("Customer info");
		addressesPage = PageGeneratorManager.getAddressesPage(driver);
		
		// Addresses => Reward Points
	 addressesPage.openDynamicSideBarPageByName("Reward Points"); 
	 rewardPointPage =  PageGeneratorManager.getRewardPointsPage(driver);
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

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
import pageObjects.admin.AdminDashboardPageObject;
import pageObjects.admin.AdminLoginPageObject;
import pageObjects.users.CustomerPageObject;
import pageObjects.users.HomePageObject;
import pageObjects.users.LoginPageObject;
import pageObjects.users.RegisterPageObject;

public class Level_09_Switch_Site_URL extends BaseTest {
	private WebDriver driver;

	private String emailAddress = getEmailAddress();
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private LoginPageObject loginPage;
	
	// Thuộc sidebar sẽ gọi các hàm trong SideBar dùng đc, các hàm còn lại thì ko 
	private CustomerPageObject customerPage;
	
	private AdminLoginPageObject adminLoginPage;
	private AdminDashboardPageObject adminDashboardPage;
	
	
	private String userUrl, adminUrl;
	
	
	@Parameters({"browser", "userUrl", "AdminUrl"})
	@BeforeClass
	public void beforeClass(String browserName, String userUrl, String adminUrl) {
		driver = getBrowserDriver(browserName, userUrl);
		homePage = PageGeneratorManager.getHomePage(driver);
		
		
		this.userUrl= userUrl;
		this.adminUrl= adminUrl;
		
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
	public void User_02_Switch_URL() {
		// Customer Page
		// ....
	
		// Logout ra từ trang user thì nó trả về trang Home
		
		homePage = customerPage.userAbleToLogout(driver);
		
		
		
		// User Qua trang admin
		
		homePage.openPageUrl(driver, adminUrl);
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
		
	
		
		// Login vào thành công 
		
		adminDashboardPage  = adminLoginPage.loginAsAdmin("", "");
		
		Assert.assertTrue(adminDashboardPage.isPageLoadedSuccess(driver));
		
		
		// Logout ra (từ trang admin) -> về lại trang login
		
		adminLoginPage = adminDashboardPage.adminAbleToLogout(driver);
		
		// từ login lại Qua trang User
		
		adminLoginPage.openPageUrl(driver, userUrl);
		homePage = PageGeneratorManager.getHomePage(driver);
		
		
		// Login vào
	 loginPage = homePage.clickToLoginLink();
	 homePage = loginPage.loginAsUser(emailAddress, "123456");
	 
		
		
		
		
		
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

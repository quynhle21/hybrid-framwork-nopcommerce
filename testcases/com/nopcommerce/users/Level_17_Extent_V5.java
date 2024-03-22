//package com.nopcommerce.users;
//
//import java.lang.reflect.Method;
//import java.util.Random;
//
//import org.openqa.selenium.WebDriver;
//import org.testng.Assert;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Parameters;
//import org.testng.annotations.Test;
//
//import com.aventstack.extentreports.Status;
//
//import commons.BaseTest;
//import commons.PageGeneratorManager;
//import pageObjects.users.AddressesPageObject;
//import pageObjects.users.CustomerPageObject;
//import pageObjects.users.DownloadableProductPageObject;
//import pageObjects.users.HomePageObject;
//import pageObjects.users.LoginPageObject;
//import pageObjects.users.RegisterPageObject;
//import pageObjects.users.RewardPointsPageObject;
//import reportConfig.ExtentManager;
//import reportConfig.ExtentTestManager;
//
//public class Level_17_Extent_V5 extends BaseTest {
//	private WebDriver driver;
//	private String browserName;
//
//	private String emailAddress = getEmailAddress();
//	private HomePageObject homePage;
//	private RegisterPageObject registerPage;
//	private String firstName, lastName, password;
//	
//
//	
//	@Parameters("browser")
//	@BeforeClass
//	public void beforeClass(String browserName) {
//		this.browserName = browserName;
//		// driver = getBrowserDriver(browserName);
//		driver = getBrowserDriver(browserName);
//		homePage = PageGeneratorManager.getHomePage(driver);
//		registerPage = PageGeneratorManager.getRegisterPage(driver);
//		
//		firstName ="Le";
//		lastName = "Hy";
//		password = "123456";
//		
//	}
//
//	@Test
//	public void User_01_Register_Validate(Method method) {
//		
//		ExtentTestManager.startTest(method.getName() + "- Run on" + browserName, "TC_01_Register_Validate");
//		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 01: Navigate to 'Register' page");
//		
//		// Verify Register link displayed
//	    	ExtentTestManager.getTest().log(Status.INFO, "Register - Step 01: Verify Register link is displayed");
//		Assert.assertFalse(homePage.isRegisterLinkDisplayed());
//
//		
//			ExtentTestManager.getTest().log(Status.INFO, "Register - Step 02: CLick to Register link");
//		registerPage = homePage.clickToRegisterLink();
//		
//		
//			ExtentTestManager.getTest().log(Status.INFO, "Register - Step 03: CLick to Register button");
//		registerPage.clickToRegisterButton();
//		
//		
//			ExtentTestManager.getTest().log(Status.INFO, "Register - Step 04: Verify error message at Firstname textbox ");
//			Assert.assertEquals(registerPage.getFirstNameErrorMessage(), "First name is required.");
//		
//			ExtentTestManager.getTest().log(Status.INFO, "Register - Step 05: Verify error message at Lastname textbox ");
//			Assert.assertEquals(registerPage.getLastNameErrorMessage(), "Last name is required");
//		
//		
//	
//	}
//	
//	@Test
//	public void User_02_Register_Success(Method method) {
//		ExtentTestManager.startTest(method.getName()+ "- Run on" + browserName, "User_02_Register_Success");
//
//			ExtentTestManager.getTest().log(Status.INFO, "Register - Step 01: Enter Firstname textbox with value is" + "firstName" );
//		registerPage.refreshCurrentPage(driver);
//		registerPage.enterToFirstNameTextbox(firstName);
//		
//			ExtentTestManager.getTest().log(Status.INFO, "Register - Step 02: Enter Lastname textbox with value is" + "lastName");
//		registerPage.enterToLastNameTextbox(lastName);
//		
//			ExtentTestManager.getTest().log(Status.INFO, "Register - Step 03: Enter Email textbox with value is" + "emailAddress");
//		registerPage.enterToEmailTextbox(emailAddress);
//		
//			ExtentTestManager.getTest().log(Status.INFO, "Register - Step 04: Enter Password textbox with value is" + "password");
//		registerPage.enterToPasswordTextbox(password);
//		
//			ExtentTestManager.getTest().log(Status.INFO, "Register - Step 05: Enter Confirm Password textbox with value is" + "password");
//		registerPage.enterToConfirmPasswordTextbox(password);
//
//			ExtentTestManager.getTest().log(Status.INFO, "Register - Step 06: CLick to Register button ");
//		registerPage.clickToRegisterButton();
//		
//
//			ExtentTestManager.getTest().log(Status.INFO, "Register - Step 07: Verify success message");
//			Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed.");
//
//	}
//	
//
//	@AfterClass
//	public void afterClass() {
//		 quitsBrowserDriver();
//	}
//
//	public String getEmailAddress() {
//		Random rand = new Random();
//		return "sam" + rand.nextInt(9999) + "@gmail.com";
//
//	}
//}

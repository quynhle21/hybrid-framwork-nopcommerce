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
//import com.relevantcodes.extentreports.LogStatus;
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
//
//public class Level_17_Extent_V2 extends BaseTest {
//	private WebDriver driver;
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
//		ExtentManager.startTest(method.getName(), "TC_01_Register_Validate");
//		ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 01: Verify Register link is displayed");
//
//		// Verify Register link displayed
//	    	ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 01: Verify Register link is displayed");
//		Assert.assertFalse(homePage.isRegisterLinkDisplayed());
//
//		
//			ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 02: CLick to Register link");
//		registerPage = homePage.clickToRegisterLink();
//		
//		
//			ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 03: CLick to Register button");
//		registerPage.clickToRegisterButton();
//		
//		
//			ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 04: Verify error message at Firstname textbox ");
//			Assert.assertEquals(registerPage.getFirstNameErrorMessage(), "First name is required.");
//		
//			ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 05: Verify error message at Lastname textbox ");
//			Assert.assertEquals(registerPage.getLastNameErrorMessage(), "Last name is required");
//		
//		
//	
//	}
//	
//	@Test
//	public void User_02_Register_Success(Method method) {
//		ExtentManager.startTest(method.getName(), "User_02_Register_Success");
//
//			ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 01: Enter Firstname textbox with value is" + "firstName" );
//		registerPage.refreshCurrentPage(driver);
//		registerPage.enterToFirstNameTextbox(firstName);
//		
//			ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 02: Enter Lastname textbox with value is" + "lastName");
//		registerPage.enterToLastNameTextbox(lastName);
//		
//			ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 03: Enter Email textbox with value is" + "emailAddress");
//		registerPage.enterToEmailTextbox(emailAddress);
//		
//			ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 04: Enter Password textbox with value is" + "password");
//		registerPage.enterToPasswordTextbox(password);
//		
//			ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 05: Enter Confirm Password textbox with value is" + "password");
//		registerPage.enterToConfirmPasswordTextbox(password);
//
//			ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 06: CLick to Register button ");
//		registerPage.clickToRegisterButton();
//		
//
//			ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 07: Verify success message");
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

package pageObjects.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.admin.LoginAdminPageUI;

public class AdminLoginPageObject extends BasePage  {
	 WebDriver driver;
	
	public AdminLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToEmailTextBox(String emailAddress) {
		waitForElementInvisible(driver, LoginAdminPageUI.EMAIL_TEXT_BOX);
		sendkeyToElement(driver, LoginAdminPageUI.EMAIL_TEXT_BOX, emailAddress);
		
	}

	public void inputToPasswordTextBox(String password) {
		waitForElementInvisible(driver, LoginAdminPageUI.PASSWORD_TEXT_BOX);
		sendkeyToElement(driver, LoginAdminPageUI.PASSWORD_TEXT_BOX, password);
		
		
	}

	public void clickToLoginButton() {
		waitForElementClickable(driver,LoginAdminPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginAdminPageUI.LOGIN_BUTTON);
	}
	

	public AdminDashboardPageObject loginAsAdmin(String emailAddress, String password) {
		inputToEmailTextBox(emailAddress);
		inputToPasswordTextBox(password);
		clickToLoginButton();
		return PageGeneratorManager.getAdminDashboardPage(driver);
		
		
		
		
	}
}

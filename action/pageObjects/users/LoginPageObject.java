package pageObjects.users;

import org.openqa.selenium.WebDriver;

import commons.BaseElement;
import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.users.UserLoginPageUI;

public class LoginPageObject extends BaseElement  {
	private WebDriver driver;
	
	public LoginPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	public HomePageObject loginAsUser(String emailAddress, String password) {
		enterToEmailTextBox(emailAddress);
		enterToPassWordTextbox(password);
		clickToLoginButton();
		return PageGeneratorManager.getHomePage(driver);
	}
	public void enterToEmailTextBox(String emailAddress) {
      waitForElementVisible(driver, UserLoginPageUI.EMAIL_TEXTBOX);
      sendkeyToElement(driver, UserLoginPageUI.EMAIL_TEXTBOX, emailAddress);
	}

	public void enterToPassWordTextbox(String password) {
		 waitForElementVisible(driver, UserLoginPageUI.PASSWORD_TEXTBOX);
	      sendkeyToElement(driver, UserLoginPageUI.PASSWORD_TEXTBOX, password);		
	}

	public HomePageObject clickToLoginButton() {
		 waitForElementClickable(driver, UserLoginPageUI.LOGIN_BUTTON);
	      clickToElement(driver, UserLoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getHomePage(driver);		
	}

}

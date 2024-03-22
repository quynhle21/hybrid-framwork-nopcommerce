package pageObjects.users;

import org.openqa.selenium.WebDriver;

import commons.BaseElement;
import commons.BasePage;
import commons.PageGeneratorManager;
import io.qameta.allure.Step;
import pageUIs.users.RegisterPageUI;

public class RegisterPageObject extends BaseElement {

	private WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

    @Step("Click to Register Button")
	public void clickToRegisterButton() {
		waitForElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);

	}

    @Step("get first name error message")
	public String getFirstNameErrorMessage() {
		waitForElementVisible(driver, RegisterPageUI.FIRST_NAME_ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.FIRST_NAME_ERROR_MESSAGE);
	}

	public String getLastNameErrorMessage() {
		waitForElementVisible(driver, RegisterPageUI.LAST_NAME_ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.LAST_NAME_ERROR_MESSAGE);
	}

	public String getEmailErrorMessage() {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.EMAIL_ERROR_MESSAGE);
	}

	public String getPasswordErrorMessage() {
		waitForElementVisible(driver, RegisterPageUI.PASSWORD_ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.PASSWORD_ERROR_MESSAGE);
	}

	public String getConfirmPasswordErrorMessage() {
		waitForElementVisible(driver, RegisterPageUI.CONFRIM_PASSWORD_ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.CONFRIM_PASSWORD_ERROR_MESSAGE);
	}

	

    @Step("Enter to First Name textbox with value is {0}")
	public void enterToFirstNameTextbox(String firstName) {

		waitForElementVisible(driver, RegisterPageUI.FRIST_NAME_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.FRIST_NAME_TEXTBOX, firstName);
	}
    @Step("Enter to last Name textbox with value is {0}")
 public void enterToLastNameTextbox(String lastName) {

		waitForElementVisible(driver, RegisterPageUI.LAST_NAME_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.LAST_NAME_TEXTBOX, lastName);
	}

    @Step("Enter to Email Address textbox with value is {0}")
   public void enterToEmailTextbox(String emailAddress) {

		waitForElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, emailAddress);
	}
    @Step("Enter to Password  textbox with value is {0}")

	public void enterToPasswordTextbox(String password) {

		waitForElementVisible(driver, RegisterPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX, password);
	}
    @Step("Enter to Confirm password textbox with value is {0}")

	public void enterToConfirmPasswordTextbox(String confirmPassword) {

		waitForElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, confirmPassword);
	}
    @Step("verify the register success message is displayed")

	public String getRegisterSuccessMessage() {
		waitForElementVisible(driver, RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
		return getElementText(driver, RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
		 
	}

	

	

	
}

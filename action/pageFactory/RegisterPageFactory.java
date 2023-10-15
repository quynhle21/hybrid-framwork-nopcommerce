package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class RegisterPageFactory extends BasePageFactory {

	private WebDriver driver;

	public RegisterPageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
    @CacheLookup
	@FindBy(xpath = "//button[@id='register-button']")
	WebElement registerButton;

	@FindBy(id="FirstName-error")
	WebElement firstNameErrorMessage;

	@FindBy(id="LastName-error")
	WebElement lastNameErrorMessage;
	
	@FindBy(id="Email-error")
	WebElement emailErrorMessage;
	
	@FindBy(id="Password-error")
	WebElement passwordErrorMessage;
	
	@FindBy(id="ConfirmPassword-error")
	WebElement confirmPasswordErrorMessage;

	@FindBy(xpath = "//div[@class='result']")
	WebElement registerSuccessMessage;

	@FindBy(id="FirstName")
	WebElement firstNameTextbox;
	
	@FindBy(id="LastName")
	WebElement lastNameTextbox;
	
	@FindBy(id="Email")
	WebElement emailTextbox;
	
	@FindBy(id="Password")
    WebElement passwordTextbox;
	
	@FindBy(id="ConfirmPassword")
	WebElement confirmPasswordTextbox;

	@FindBy(xpath="//div[@class='header-logo']//img")
	WebElement homePageLogoImage;
	
	
	public void clickToRegisterButton() {
		waitForElementClickable(driver, registerButton);
		clickToElement(driver, registerButton);

	}

	public String getFirstNameErrorMessage() {
		waitForElementVisible(driver, firstNameErrorMessage);
		return getElementText(driver, firstNameErrorMessage);
	}

	public String getLastNameErrorMessage() {
		waitForElementVisible(driver, lastNameErrorMessage);
		return getElementText(driver, lastNameErrorMessage);
	}

	public String getEmailErrorMessage() {
		waitForElementVisible(driver, emailErrorMessage);
		return getElementText(driver, emailErrorMessage);
	}

	public String getPasswordErrorMessage() {
		waitForElementVisible(driver, passwordErrorMessage);
		return getElementText(driver, passwordErrorMessage);
	}

	public String getConfirmPasswordErrorMessage() {
		waitForElementVisible(driver, confirmPasswordErrorMessage);
		return getElementText(driver, confirmPasswordErrorMessage);
	}

	public void enterToFirstNameTextbox(String firstName) {

		waitForElementVisible(driver, firstNameTextbox);
		sendkeyToElement(driver, firstNameTextbox, firstName);
	}

	public void enterToLastNameTextbox(String lastName) {

		waitForElementVisible(driver, lastNameTextbox);
		sendkeyToElement(driver, lastNameTextbox, lastName);
	}

	public void enterToEmailTextbox(String emailAddress) {

		waitForElementVisible(driver, emailTextbox);
		sendkeyToElement(driver, emailTextbox, emailAddress);
	}

	public void enterToPasswordTextbox(String password) {

		waitForElementVisible(driver, passwordTextbox);
		sendkeyToElement(driver, passwordTextbox, password);
	}

	public void enterToConfirmPasswordTextbox(String confirmPassword) {

		waitForElementVisible(driver, confirmPasswordTextbox);
		sendkeyToElement(driver, confirmPasswordTextbox, confirmPassword);
	}

	public String getRegisterSuccessMessage() {
		waitForElementVisible(driver, registerSuccessMessage);
		return getElementText(driver, registerSuccessMessage);

	}
	public void clickToHomePageLogo() {
		waitForElementClickable(driver, homePageLogoImage);
		clickToElement(driver, homePageLogoImage);
	}
}

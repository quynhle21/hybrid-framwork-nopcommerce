package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFactory extends BasePageFactory  {
	private WebDriver driver;
	
	public LoginPageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="Email")
	WebElement emailTextbox;
	@FindBy(xpath="//input[@id='Password']")
	WebElement passwordTextbox;
	@FindBy(css="button.login-button")
	WebElement loginButton;
	
	public void loginAsUser(String emailAddress, String password) {
		enterToEmailTextBox(emailAddress);
		enterToPassWordTextbox(password);
		clickToLoginButton();
		
	}
	
	public void enterToEmailTextBox(String emailAddress) {
      waitForElementVisible(driver, emailTextbox);
      sendkeyToElement(driver, emailTextbox, emailAddress);
	}

	public void enterToPassWordTextbox(String password) {
		 waitForElementVisible(driver, passwordTextbox);
	      sendkeyToElement(driver, passwordTextbox, password);		
	}

	public void clickToLoginButton() {
		 waitForElementClickable(driver, loginButton);
	      clickToElement(driver, loginButton);		
	}

}

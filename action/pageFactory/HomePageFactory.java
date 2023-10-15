package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePageFactory extends BasePageFactory {
// Chứa những actions của page đó: click/ select/ verify/ getText/ ....

	WebDriver driver;
	WebDriverWait explicitWait;


	public HomePageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[@class='ico-register']")
	WebElement registerLink;
	
	@FindBy(xpath="//a[@class='ico-login']")
	WebElement loginLink;
	
	@FindBy(xpath="//a[@class='ico-account']")
	WebElement myAccountLink;
	

	public void clickToRegisterLink() {
		waitForElementClickable(driver, registerLink);
		clickToElement(driver, registerLink);
	}

	public void clickToLoginLink() {
		waitForElementClickable(driver, loginLink);
		clickToElement(driver, loginLink);
	}

	public void clickToMyAccountLink() {
		waitForElementClickable(driver, myAccountLink);
		clickToElement(driver, myAccountLink);
	}
}

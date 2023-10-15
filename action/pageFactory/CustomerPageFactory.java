package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CustomerPageFactory extends BasePageFactory {
	WebDriver driver;

	// TestNG: @BeforeClass/ @BeforeTest/ @Test/ @Parametor
	
	// UI: Annotation của PageFactory
	// @FindBy/ @FindBys/ @FindAll/ @CacheLookup -> Chỉ gắn vào loại dữ liệu: WebElement
	
	public CustomerPageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//input[@id='FirstName']")
	WebElement firstNameTextbox;
	
	@FindBy(id="LastName")
	WebElement lastNameTextbox;
	
	@FindBy(css="input#Email")
	WebElement emailTextbox ;
	
	@FindBy(css="input#login")
	WebElement loginButton ;
	
	// Action: 
	
	public void clickToLoginButton() {
		clickToElement(driver, loginButton);
		
	}
	
	public String getFirstNameAttributeValue() {
		waitForElementVisible(driver, firstNameTextbox);
		return getElementAttribute(driver, firstNameTextbox, "value");
	}

	public String getLastNameAttributeValue() {
		waitForElementVisible(driver, lastNameTextbox);
		return getElementAttribute(driver, lastNameTextbox, "value");
	}

	public String getEmailAttributeValue() {
		waitForElementVisible(driver, emailTextbox);
		return getElementAttribute(driver, emailTextbox, "value");
	}

}

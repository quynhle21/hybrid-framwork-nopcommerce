package commons;

import org.openqa.selenium.WebDriver;

import pageObjects.users.HomePageObject;
import pageUIs.users.BaseElementUI;
import pageUIs.users.CustomerPageUI;

public class BaseElement extends BasePage {
	WebDriver driver;
	
	public BaseElement(WebDriver driver) {
		this.driver = driver;
	}
	
	// Hàm này theo business là bất kì page nào cũng nhìn thấy để thao tác lên nó đc
	public HomePageObject clickToHomePageLogo() {
		waitForElementClickable(driver, BaseElementUI.HOMEPAGE_LOGO_IMAGE);
		clickToElement(driver, BaseElementUI.HOMEPAGE_LOGO_IMAGE);
	 return PageGeneratorManager.getHomePage(driver);
	}

	// theo business thì page nào cũng gọi ra dùng đc
	public void clickToHeaderLinkByName(String pageName) {
		waitForElementClickable(driver, BaseElementUI.DYNAMIC_HEADER_LINK_BY_NAME, pageName);
    	clickToElement(driver, BaseElementUI.DYNAMIC_HEADER_LINK_BY_NAME, pageName);

	}

    /// Hàm để thao tác vs bất kì 1 button ở các page
	public void clickToButtonByText(String buttonText) {
		waitForElementClickable(driver, BaseElementUI.DYNAMIC_BUTTON_BY_TEXT, buttonText);
    	clickToElement(driver, BaseElementUI.DYNAMIC_BUTTON_BY_TEXT, buttonText);

	}
	
	// get all error message 
	public String getTextboxErrorMessageById(String errorMessageId) {
     waitForElementVisible(driver, BaseElementUI.DYNAMIC_ERROR_MESSAGE_BY_ID, errorMessageId);
		return getElementText(driver, BaseElementUI.DYNAMIC_ERROR_MESSAGE_BY_ID, errorMessageId);
	}
	
	// NHAP TEXTBOX BAT KY
	public void enterToTextboxbyID(String textboxID, String valueToSend) {
	waitForElementVisible(driver, BaseElementUI.DYNAMIC_TEXTBOX_BY_ID, textboxID);	
	sendkeyToElement(driver, BaseElementUI.DYNAMIC_TEXTBOX_BY_ID, valueToSend,textboxID);
	}
	
	// Get ra attrubute cua textbox
	public String getTexboxAttributeByID(String textboxID) {
		waitForElementVisible(driver, BaseElementUI.DYNAMIC_TEXTBOX_BY_ID, textboxID);
		return getElementAttribute(driver, BaseElementUI.DYNAMIC_TEXTBOX_BY_ID, "value", textboxID);
	
	}
	
	
	
}

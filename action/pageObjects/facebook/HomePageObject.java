package pageObjects.facebook;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.facebook.HomePageUI;

public class HomePageObject extends BasePage{
WebDriver driver;

public HomePageObject(WebDriver driver) {
	this.driver = driver;
}

public void clickToCreateNewAccoutButton() {
	waitForElementClickable(driver, HomePageUI.CREATE_NEW_ACCOUNT_BUTTON);
	clickToElement(driver, HomePageUI.CREATE_NEW_ACCOUNT_BUTTON);
}

public boolean isFirstNameTextboxDisplayed() {
	waitForElementVisible(driver, HomePageUI.FIRSTNAME_TEXTBOX);
	return isElementDisplayed(driver, HomePageUI.FIRSTNAME_TEXTBOX);
}

public boolean isSurNameTextboxDisplayed() {
	waitForElementVisible(driver, HomePageUI.LASTNAME_TEXTBOX);
	return isElementDisplayed(driver, HomePageUI.LASTNAME_TEXTBOX);

}

public boolean isEmailTextboxDisplayed() {
	waitForElementVisible(driver, HomePageUI.EMAIL_TEXTBOX);
	return isElementDisplayed(driver, HomePageUI.EMAIL_TEXTBOX);

}

public boolean isPasswordTextboxDisplayed() {
	waitForElementVisible(driver, HomePageUI.PASSWORD_TEXTBOX);
	return isElementDisplayed(driver, HomePageUI.PASSWORD_TEXTBOX);

}

public void enterToEmailTextbox(String emailAddress) {
	waitForElementVisible(driver, HomePageUI.EMAIL_TEXTBOX);
	sendkeyToElement(driver, HomePageUI.EMAIL_TEXTBOX, emailAddress);
}

public boolean isConfirmEmailTextboxDisplayed() {
	waitForElementVisible(driver, HomePageUI.CONFIRM_EMAIL_TEXTBOX);
	return isElementDisplayed(driver, HomePageUI.CONFIRM_EMAIL_TEXTBOX);

}

public void clickToCloseSignUpPopup() {
	waitForElementClickable(driver, HomePageUI.CLOSE_SIGNUP);
	clickToElement(driver, HomePageUI.CLOSE_SIGNUP);
}

public boolean isFirstNameTextboxUnDisplayed() {
	return isElementUnDisplayed(driver, HomePageUI.FIRSTNAME_TEXTBOX);

}

public boolean isSurNameTextboxUnDisplayed() {
	return isElementUnDisplayed(driver, HomePageUI.LASTNAME_TEXTBOX);

}

public boolean isEmailTextboxUnDisplayed() {
	return isElementUnDisplayed(driver, HomePageUI.EMAIL_TEXTBOX);

}

public boolean isPasswordTextboxUnDisplayed() {
	return isElementDisplayed(driver, HomePageUI.PASSWORD_TEXTBOX);

}


}

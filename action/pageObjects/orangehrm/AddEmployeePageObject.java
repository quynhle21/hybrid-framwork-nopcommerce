package pageObjects.orangehrm;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.orangehrm.AddEmployeePageUI;

public class AddEmployeePageObject extends BaseActions {
	private WebDriver driver;
	
	public AddEmployeePageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
		
	}

	public void enterToFirstNameTextbox(String firstName) {
		waitForElementVisible(driver, AddEmployeePageUI.FRISTNAME_TEXTBOX);
		sendkeyToElement(driver, AddEmployeePageUI.FRISTNAME_TEXTBOX,firstName);
	}

	public void enterToLastNameTextbox(String lastName) {
		waitForElementVisible(driver, AddEmployeePageUI.LASTNAME_TEXTBOX);
		sendkeyToElement(driver, AddEmployeePageUI.LASTNAME_TEXTBOX,lastName);
			
	}

	public String getEmployeeID() {
		waitForElementVisible(driver, AddEmployeePageUI.EMPLOYEE_ID);
		return getElementAttribute(driver, AddEmployeePageUI.EMPLOYEE_ID, "value");
	}

	public void clickSaveButton() {
		waitForElementClickable(driver, AddEmployeePageUI.SAVE_BUTTON);
		clickToElement(driver, AddEmployeePageUI.SAVE_BUTTON);
	
	}

	

	

}

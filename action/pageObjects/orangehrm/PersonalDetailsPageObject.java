package pageObjects.orangehrm;

import org.openqa.selenium.WebDriver;

import pageUIs.orangehrm.PersonalDetailsPageUI;


public class PersonalDetailsPageObject extends BaseActions {
	private WebDriver driver;
	
	public PersonalDetailsPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	
	}

	public String getFirstNameValue() {
		waitForElementVisible(driver, PersonalDetailsPageUI.FIRST_NAME_FIELD);
		return getElementAttribute(driver, PersonalDetailsPageUI.FIRST_NAME_FIELD,"value");
	}

	public String getLasttNameValue() {
		waitForElementVisible(driver, PersonalDetailsPageUI.LAST_NAME_FIELD);
		return getElementAttribute(driver, PersonalDetailsPageUI.LAST_NAME_FIELD,"value");
	}

	public String getEmployeeIDValue() {
		waitForElementVisible(driver, PersonalDetailsPageUI.EMPLOYEE_ID);
		return getElementAttribute(driver, PersonalDetailsPageUI.EMPLOYEE_ID,"value");
	}

	public EmployeeListPageObject clickToEmployeeListButton() {
		waitForElementClickable(driver, PersonalDetailsPageUI.EMPLOYEE_LIST_BUTTON);
		clickToElement(driver, PersonalDetailsPageUI.EMPLOYEE_LIST_BUTTON);
		waitForSpinnerIconInvisible();
		return PageGeneratorManager.getEmployeeListPage(driver);
	}

	public boolean isPersonalDetailsHeaderDisplay() {
		waitForElementVisible(driver, PersonalDetailsPageUI.PERSONAL_DETAIL_PAGE_HEADER);	
		return isElementDisplayed(driver, PersonalDetailsPageUI.PERSONAL_DETAIL_PAGE_HEADER);
	}

	public void enterToDriverLicenseNumberTextbox(String driverLicense) {
		waitForElementVisible(driver, PersonalDetailsPageUI.DRIVER_LICENSE_NUMBER_TEXTBOX);
		sendkeyToElement(driver, PersonalDetailsPageUI.DRIVER_LICENSE_NUMBER_TEXTBOX, driverLicense);
	}

	public void enterToLicenseExpiryDatePicker(String driverLiceseExpiryDate) {
		waitForElementVisible(driver, PersonalDetailsPageUI.LICENSE_EXPIRY_DATE_TEXTBOX);
		sendkeyToElement(driver, PersonalDetailsPageUI.LICENSE_EXPIRY_DATE_TEXTBOX, driverLiceseExpiryDate);
	
	}

	public void selectToNationalityDropdown(String nationalityName) {
		waitForElementClickable(driver, PersonalDetailsPageUI.NATIONALITY_DRORDOWN_PARENT);
		selectItemInCustomDropdown(driver, PersonalDetailsPageUI.NATIONALITY_DRORDOWN_PARENT, PersonalDetailsPageUI.NATIONALITY_DRORDOWN_CHILD_ITEM, nationalityName);
		
	}

	public void selectMaritalStatusDropdown(String maritalStatus) {
		waitForElementClickable(driver, PersonalDetailsPageUI.MARITAL_STATUS_DRORDOWN);
		selectItemInCustomDropdown(driver, PersonalDetailsPageUI.MARITAL_STATUS_DRORDOWN, PersonalDetailsPageUI.MARITAL_STATUS_CHILD_ITEM, maritalStatus);
		
	}

	public void DateOfBirthDatePicker(String dateOfBirth) {
		waitForElementVisible(driver, PersonalDetailsPageUI.DATE_OF_BIRTH_DATEPICKER);
		sendkeyToElement(driver, PersonalDetailsPageUI.DATE_OF_BIRTH_DATEPICKER, dateOfBirth);
	
	}
	
	public void clickSaveButtonAtPersonalDetailPart() {
		waitForElementClickable(driver, PersonalDetailsPageUI.SAVE_BUTTON_AT_PERSONAL_DETAIL);
		clickToElement(driver, PersonalDetailsPageUI.SAVE_BUTTON_AT_PERSONAL_DETAIL);
		
	}

	public String getNationalityDropdownSelectedText() {
		return getElementText(driver, PersonalDetailsPageUI.NATIONALITY_DRORDOWN_SELECTED_TEXT);
	}

	public String getMaritalStatusDropdownSelectedText() {
		return getElementText(driver, PersonalDetailsPageUI.MARITAL_STATUS_SELECTED_TEXT);
	}

	
	
	

	
	
	

}

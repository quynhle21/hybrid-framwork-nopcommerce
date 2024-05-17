package pageUIs.orangehrm;

public class PersonalDetailsPageUI {

	public static final String FIRST_NAME_FIELD = "css=input[name='firstName']";
	public static final String LAST_NAME_FIELD = "css=input[name='lastName']";
	public static final String EMPLOYEE_ID = "xpath=//label[text()='Employee Id']/parent::div/following-sibling::div/input";

	public static final String EMPLOYEE_LIST_BUTTON = "xpath=//a[text()='Employee List']";
	public static final String PERSONAL_DETAIL_PAGE_HEADER = "xpath=//h6[text()='Personal Details']";
	
	
	public static final String SAVE_BUTTON_AT_PERSONAL_DETAIL = "xpath =//div[contains(@class,'orangehrm-horizontal-padding')]//button[contains(string(),'Save')]";
	
	public static final String DRIVER_LICENSE_NUMBER_TEXTBOX = "xpath=//label[text()=\"Driver's License Number\"]/parent::div/following-sibling::div/input";
	
	public static final String LICENSE_EXPIRY_DATE_TEXTBOX = "xpath=//label[text()='License Expiry Date']/parent::div/following-sibling::div//input";
	
	public static final String NATIONALITY_DRORDOWN_PARENT="xpath=//label[text()='Nationality']/parent::div/following-sibling::div//i";
	public static final String NATIONALITY_DRORDOWN_CHILD_ITEM ="xpath=//label[text()='Nationality']/parent::div/following-sibling::div//div[@class='oxd-select-option']/span";
	public static final String NATIONALITY_DRORDOWN_SELECTED_TEXT ="xpath=//label[text()='Nationality']/parent::div/following-sibling::div//div[@class='oxd-select-text-input']";
	
	
	public static final String MARITAL_STATUS_DRORDOWN = "xpath=//label[text()='Marital Status']/parent::div/following-sibling::div//i";
	public static final String MARITAL_STATUS_CHILD_ITEM = "xpath=//label[text()='Marital Status']/parent::div/following-sibling::div//div[@class='oxd-select-option']/span";
	public static final String MARITAL_STATUS_SELECTED_TEXT = "xpath=//label[text()='Marital Status']/parent::div/following-sibling::div//div[@class='oxd-select-text-input']";
	
	
	public static final String DATE_OF_BIRTH_DATEPICKER = "xpath=//label[text()='Date of Birth']/parent::div/following-sibling::div//input";
	
	
	
}

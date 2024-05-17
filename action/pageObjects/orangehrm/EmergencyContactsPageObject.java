package pageObjects.orangehrm;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class EmergencyContactsPageObject extends BaseActions {
	private WebDriver driver;
	
	public EmergencyContactsPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	
	}

}

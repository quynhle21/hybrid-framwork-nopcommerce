package pageObjects.orangehrm;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class ContactDetailsPageObject extends BaseActions {
	private WebDriver driver;
	
	public ContactDetailsPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
}
}
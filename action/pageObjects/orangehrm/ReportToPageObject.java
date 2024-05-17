package pageObjects.orangehrm;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class ReportToPageObject extends BaseActions {
	private WebDriver driver;
	
	public ReportToPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	
	}

}

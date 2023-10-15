package commons;

import org.openqa.selenium.WebDriver;

import pageObjects.users.SideBarMyAccountPageObject;

public class OrdersPageObject extends SideBarMyAccountPageObject{
	WebDriver driver;

	public OrdersPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
}

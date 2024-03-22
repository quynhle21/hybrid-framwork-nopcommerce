package pageObjects.users;

import org.openqa.selenium.WebDriver;

import commons.BaseElement;
import commons.BasePage;
import commons.OrdersPageObject;
import commons.PageGeneratorManager;
import pageUIs.users.SideBarMyAccountPaseUI;

public class SideBarMyAccountPageObject extends BaseElement {
	WebDriver driver;
	
	public SideBarMyAccountPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public RewardPointsPageObject openRewardPointPage() {
		waitForElementClickable(driver, SideBarMyAccountPaseUI.REWARD_POINT_PAGE_LINK);
		clickToElement(driver, SideBarMyAccountPaseUI.REWARD_POINT_PAGE_LINK);
		return PageGeneratorManager.getRewardPointsPage(driver);
	}

	public DownloadableProductPageObject openDownloadableProdcutPage() {
		waitForElementClickable(driver, SideBarMyAccountPaseUI.DOWNLOADABLE_PRODUCT_PAGE_LINK);
		clickToElement(driver, SideBarMyAccountPaseUI.DOWNLOADABLE_PRODUCT_PAGE_LINK);
		return PageGeneratorManager.getDownloadableProductPage(driver);
	}
	public OrdersPageObject openOrderPage() {
		waitForElementClickable(driver, SideBarMyAccountPaseUI.ORDER_LINK_TEXT);
		clickToElement(driver, SideBarMyAccountPaseUI.ORDER_LINK_TEXT);
		return PageGeneratorManager.getOrdersPage(driver);
	}
	
	
	public AddressesPageObject openAddressesPage() {
		waitForElementClickable(driver, SideBarMyAccountPaseUI.ADDRESSES_PAGE_LINK);
		clickToElement(driver, SideBarMyAccountPaseUI.ADDRESSES_PAGE_LINK);
		return PageGeneratorManager.getAddressesPage(driver);
	}

	public CustomerPageObject openCustomerInForPage() {
		waitForElementClickable(driver, SideBarMyAccountPaseUI.INFOR_PAGE_LINK);
		clickToElement(driver, SideBarMyAccountPaseUI.INFOR_PAGE_LINK);
		return PageGeneratorManager.getCustomerPage(driver);
	}
	
	public SideBarMyAccountPageObject openDynamicSideBarPage(String PageName) {
		waitForElementClickable(driver, SideBarMyAccountPaseUI.DYNAMIC_SIDEBAR_LINK_TEXT, PageName);
		clickToElement(driver, SideBarMyAccountPaseUI.DYNAMIC_SIDEBAR_LINK_TEXT, PageName);
		
		switch (PageName) {
		case "Customer info":
		return	PageGeneratorManager.getCustomerPage(driver);
			
		case "Addresses":
			return	PageGeneratorManager.getAddressesPage(driver);
		case "Orders":
			return	PageGeneratorManager.getOrdersPage(driver);
		case "Reward Points":
			return PageGeneratorManager.getRewardPointsPage(driver);
		case "Downloadable Product":
			return 	PageGeneratorManager.getDownloadableProductPage(driver);
			default: 
				 new RuntimeException("Sidebar page name incorrect");
				 return null;
		}
		
	}
	public void openDynamicSideBarPageByName(String PageName) {
		waitForElementClickable(driver, SideBarMyAccountPaseUI.DYNAMIC_SIDEBAR_LINK_TEXT, PageName);
		clickToElement(driver, SideBarMyAccountPaseUI.DYNAMIC_SIDEBAR_LINK_TEXT, PageName);
	}
}

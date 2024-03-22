package pageObjects.users;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import commons.BaseElement;
import commons.PageGeneratorManager;
import io.qameta.allure.Step;
import pageUIs.users.UserHomePageUI;

public class HomePageObject extends BaseElement {
// Chứa những actions của page đó: click/ select/ verify/ getText/ ....

// Mỗi page object tương ứng vs 1 page UIs ở Interface
	WebDriver driver;
	WebDriverWait explicitWait;


	public HomePageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	// Hàm khởi tạo: Constructor method
	// Cùng tên với class
	// Ko có kiểu trả về
	// Chạy đầy tiên khi class được gọi tới
	// 1 Class nếu ko đc define hàm khởi tạo nào thì nó sẽ mặc định có 1 hàm khởi
	// tạo rỗng
	// Nếu đc define nó sẽ ưu tiên gọi tới hàm đc define đó
	// Có thể có 1 hoặc nhiều tham số hoặc 0 tham số
	// 1 Class có thể có nhiều hàm khởi tạo
	// Nếu class hiện tại đang kế thừa 1 class cha - thì khi tạo hàm khởi tạo nó sẽ có từ khóa "super"
	// super: dùng để gọi tới hàm khởi tạo của class cha
	// Nếu class hiện tại ko kế thừa class nào hết thì mặc định sẽ cho kế thừa class "Object"
	// Từ khóa this: 1 class có 2 biến trùng tên ( Global or Local)
	// Global: Phạm vi khai báo thuộc class
	// Local: phạm vi khai báo thuộc tham số/ trong hàm
	
	
	


    @Step("Click to Register Link")
	public RegisterPageObject clickToRegisterLink() {
		waitForElementClickable(driver, UserHomePageUI.REGISTER_LINK);
		clickToElement(driver, UserHomePageUI.REGISTER_LINK);
		return PageGeneratorManager.getRegisterPage(driver);
	}

    @Step("Click to Login Link")
	public LoginPageObject clickToLoginLink() {
		waitForElementClickable(driver, UserHomePageUI.LOGIN_LINK);
		clickToElement(driver, UserHomePageUI.LOGIN_LINK);
	return PageGeneratorManager.getLoginPage(driver); 
	}

    @Step("Click to Account Link")
    public CustomerPageObject clickToMyAccountLink() {
    	waitForElementClickable(driver, UserHomePageUI.MY_ACCOUNT_LINK);
    	clickToElement(driver, UserHomePageUI.MY_ACCOUNT_LINK);
    	return PageGeneratorManager.getCustomerPage(driver);
    }
	
    public CustomerPageObject openMyAccountLink() {
		String myAccountLink = getElementAttribute(driver, UserHomePageUI.MY_ACCOUNT_LINK, "href");
        openPageUrl(driver, myAccountLink);
		return PageGeneratorManager.getCustomerPage(driver);
	}
    
    
    
    

    @Step("Click to Logout Link")
    public void clickToLogoutLink() {
    	waitForElementClickable(driver, UserHomePageUI.USER_LOGOUT_LINK);
    	clickToElement(driver, UserHomePageUI.USER_LOGOUT_LINK);
    }

    @Step("Verify the register link is displayed")
	public boolean isRegisterLinkDisplayed() {
		waitForElementVisible(driver, UserHomePageUI.REGISTER_LINK);
	 return isElementDisplayed(driver, UserHomePageUI.REGISTER_LINK);
	 
	}

	
	
}

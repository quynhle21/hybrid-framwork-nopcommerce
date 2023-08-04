package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageUIs.HomePageUI;
import commons.BasePage;

public class HomePageObject extends BasePage {
// Chứa những actions của page đó: click/ select/ verify/ getText/ ....

// Mỗi page object tương ứng vs 1 page UIs ở Interface
	WebDriver driver;
	WebDriverWait explicitWait;


	public HomePageObject(WebDriver driver) {
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
	
	
	



	public void clickToRegisterLink() {
		waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
		clickToElement(driver, HomePageUI.REGISTER_LINK);
	}

	public void clickToLoginLink() {
		waitForElementClickable(driver, HomePageUI.LOGIN_LINK);
		clickToElement(driver, HomePageUI.LOGIN_LINK);
	}

	public void clickToMyAccountLink() {
		waitForElementClickable(driver, HomePageUI.MY_ACCOUNT_LINK);
		clickToElement(driver, HomePageUI.MY_ACCOUNT_LINK);
	}
}

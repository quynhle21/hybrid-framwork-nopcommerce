package pageUIs.users;

public class UserHomePageUI {
// chứa những cái locator/ element của page 
	
// Biến: Variable/ Property
	public static final String REGISTER_LINK = "Xpath=//a[@class='ico-register']";
	
	//public: Truy cập đc từ class bên ngoài package theo các thông thường
	// private: các class bên ngoài ko truy cập được
	// default: các class bên ngoài khác package cũng ko truy cập đc
	// protected: bắt buộc phải kế thừa mới truy cập được
	// static: có thể truy cập trực tiếp từ pham vi class - chứ ko cần phạm vi từ biến instance
	
// Instance	
	// final: Ko cho phép ghi đè lên biến này nữa (ngăn cản việc gán lại thành 1 element khác)
	// String: Các locator đều nhận tham số vào là String
	// Tên biến: kết hợp static + final ( nó sẽ mặc định đây là hằng số - Constant)
	// In nghiêng + In đậm
	// Bắt buộc phải viết hoa và phân tách bằng gạch _
	
// Convention java	
	// Giá trị: nằm trong dấu nháy đôi
	// Cú pháp xpath
	
	
	public static final String LOGIN_LINK = "Xpath=//a[@class='ico-login']";
	

	public static final String MY_ACCOUNT_LINK = "XPATH=//a[@class='ico-account']";
	public static final String USER_LOGOUT_LINK = "XPATH=//a[@class='ico-logout']";
	
	
	
	
}

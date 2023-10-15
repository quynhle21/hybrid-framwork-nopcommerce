package javaBasic;

import java.util.ArrayList;

import org.testng.annotations.Test;

public class Topic_04_Rest_Parameter {
	
	
	String addressLink = "//div[@class='side-2']//a[text()='Addresses']";
	String orderLink = "//div[@class='side-2']//a[text()='Orders']";
	String dynamicSideBarLink = "//div[@class='side-2']//a[text()='%s']";
	
	String dynamicLink = "//div[@class='%s']//a[text()='%s']";
	
	String dynamicMenuLink = "//div[@class='%s']/div[@id='%s']/a[text()='%s']";
			
	
@Test
public void TC_01_Rest_Param() {
	// Cố định
	clickToElement(addressLink);
	
	// 1 param
	clickToElement(dynamicSideBarLink, "Addresses");
	clickToElement(dynamicSideBarLink, "Orders");
	
	//2 param
	clickToElement(dynamicLink, "footer", "Blog");
	clickToElement(dynamicLink, "footer", "Orders");
	
	clickToElement(dynamicLink, "header", "Register");
	clickToElement(dynamicLink, "header", "Login");
	
	// 3 param
	clickToElement(dynamicMenuLink, "header", "computer", "Samsung");
	clickToElement(dynamicMenuLink, "header", "phone", "Samsung");
	
	ArrayList<String> countries = new ArrayList<String>();
	
	
	
	
	
}


//hàm để click vào hàm element cố định
public void clickToElement(String locatorValue) {
	System.out.println("Click to:" + locatorValue);
}


//hàm để click vào 1 element ko cố định (dynamic) vs 1 tham số
public void clickToElement(String locatorValue, String pageName) {
	
	locatorValue = String.format(locatorValue, pageName);
	System.out.println("Click to:" + locatorValue);
}

//hàm để click vào 1 element ko cố định (dynamic) vs 2 tham số
public void clickToElement(String locatorValue, String pageType, String pageName ) {
	
	locatorValue = String.format(locatorValue, pageType,pageName );
	System.out.println("Click to:" + locatorValue);
}
//hàm để click vào 1 element ko cố định (dynamic) vs 3 tham số
public void clickToElement(String locatorValue, String pageType, String categoryType, String pageName ) {
	
	locatorValue = String.format(locatorValue, pageType, categoryType,pageName );
	System.out.println("Click to:" + locatorValue);
}

// Var Arguments = Rest Parameter. hàm để click vào 1 element ko cố định (dynamic) vs bất kì tham số nào (1-n tham số)

public void clickToElement(String locatorValue, String... values) {
	
	locatorValue = String.format(locatorValue, (Object[]) values);
	System.out.println("Click to:" + locatorValue);
}




}

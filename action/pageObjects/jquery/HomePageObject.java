package pageObjects.jquery;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.jquery.HomePageUI;

public class HomePageObject extends BasePage {
WebDriver driver;

public HomePageObject(WebDriver driver) {
	this.driver = driver;
}

public void inputToColumnTextBoxByName(String ColumnName, String valueToSend) {
waitForElementVisible(driver, HomePageUI.COLUMN_TEXTBOX_BY_NAME, ColumnName);	
sendkeyToElement(driver, HomePageUI.COLUMN_TEXTBOX_BY_NAME, valueToSend, ColumnName);

}

public void clickToPageByNumber(String pageNumber) {
	waitForElementClickable(driver, HomePageUI.PAGING_LINK_BY_NUMBER, pageNumber);
	clickToElement(driver, HomePageUI.PAGING_LINK_BY_NUMBER, pageNumber);

}

public boolean isPageActiveByNumber(String pageNumber) {
	waitForElementVisible(driver, HomePageUI.PAGING_LINK_ACTIVE_BY_NUMBER, pageNumber);
    return isElementDisplayed(driver, HomePageUI.PAGING_LINK_ACTIVE_BY_NUMBER, pageNumber);
}

public boolean isRowValuesDisplay(String female, String country, String male, String total) {
	waitForElementVisible(driver, HomePageUI.DYNAMIC_ROW_VALUES, female, country, male, total);
	
	return isElementDisplayed(driver, HomePageUI.DYNAMIC_ROW_VALUES, female, country, male, total);
	
}

public void clickToRowActionByCountryName(String country, String rowAction) {

	
	waitForElementClickable(driver, HomePageUI.RAW_ACTION_BY_COUNTRY_NAME, country, rowAction);
	clickToElement(driver, HomePageUI.RAW_ACTION_BY_COUNTRY_NAME, country, rowAction);
	
}

// Get ra từ UI

public List<String> getAllPageValuesByColumnName(String columnName) {

	List<String> allValues = new ArrayList<String>();
	
//	 Bước 1: Lấy ra tất cả các page
	List<WebElement> allPageLinks = getListWebElement(driver, HomePageUI.ALL_PAGE_LINKS);
	
	int columnIndex = getListElementSize(driver, HomePageUI.COLUMN_INDEX_BY_COLUMN_NAME, columnName) + 1;
	
//   Bước 2: Duyệt qua từng page
	for (WebElement pageLink : allPageLinks) {
		pageLink.click();
		sleepInSecond(2);
	
	
//   Bước 3: Lấy ra tất cả các giá trị của 1 cột trong page đó -> Lưu nó vào List/Set/...
	
	List<WebElement> allRowValues = getListWebElement(driver, HomePageUI.ALL_VALUES_BY_COLUMN_INDEX,String.valueOf(columnIndex));
	
	for (WebElement rowValue : allRowValues) {
		allValues.add(rowValue.getText());
		
	}
		
}

 return allValues;
}

public List<String> getAllPageValuesByColumnNameInDB(String columnName) {

	List<String> allValues = new ArrayList<String>();
	
//	 Bước 1: Lấy ra tất cả các page
	List<WebElement> allPageLinks = getListWebElement(driver, HomePageUI.ALL_PAGE_LINKS);
	
	int columnIndex = getListElementSize(driver, HomePageUI.COLUMN_INDEX_BY_COLUMN_NAME, columnName) + 1;
	
//   Bước 2: Duyệt qua từng page
	for (WebElement pageLink : allPageLinks) {
		pageLink.click();
		sleepInSecond(2);
	
	
//   Bước 3: Lấy ra tất cả các giá trị của 1 cột trong page đó -> Lưu nó vào List/Set/...
	
	List<WebElement> allRowValues = getListWebElement(driver, HomePageUI.ALL_VALUES_BY_COLUMN_INDEX,String.valueOf(columnIndex));
	
	for (WebElement rowValue : allRowValues) {
		allValues.add(rowValue.getText());
		
	}
		
}
	return allValues;
}

public void enterToTextboxByColumnNameByIndex(String columnName, String rowIndex, String valueToSend) {
int columnIndex = getListElementSize(driver, HomePageUI.DYNAMIC_COLUMN_INDEX_BY_COLUMN_NAME, columnName) + 1;	
waitForElementVisible(driver, HomePageUI.DYNAMIC_TEXTBOX_BY_ROW_INDEX_COLUMN_INDEX, rowIndex, String.valueOf(columnIndex));
sendkeyToElement(driver, HomePageUI.DYNAMIC_TEXTBOX_BY_ROW_INDEX_COLUMN_INDEX, valueToSend, rowIndex, String.valueOf(columnIndex));
}

public void selectDropdownByColumnNameAndRowIndex(String columnName, String rowIndex, String dropdownItem) {

	int columnIndex = getListElementSize(driver, HomePageUI.DYNAMIC_DROPDOWN_BY_ROW_INDEX_COLUMN_INDEX, columnName) + 1;	
	waitForElementClickable(driver, HomePageUI.DYNAMIC_DROPDOWN_BY_ROW_INDEX_COLUMN_INDEX, rowIndex, String.valueOf(columnIndex));
selectItemInDefaultDropdown(driver, HomePageUI.DYNAMIC_DROPDOWN_BY_ROW_INDEX_COLUMN_INDEX, dropdownItem, rowIndex, String.valueOf(columnIndex));
}


public void clickToCheckboxByColumnNameAndRowIndex(String columnName, String rowIndex) {
	int columnIndex = getListElementSize(driver, HomePageUI.DYNAMIC_CHECKBOX_BY_ROW_INDEX_COLUMN_INDEX, columnName) + 1;	
	
	waitForElementClickable(driver, HomePageUI.DYNAMIC_CHECKBOX_BY_ROW_INDEX_COLUMN_INDEX, rowIndex, String.valueOf(columnIndex));
	checkToElement(driver, HomePageUI.DYNAMIC_CHECKBOX_BY_ROW_INDEX_COLUMN_INDEX, rowIndex, String.valueOf(columnIndex));
	
}




//Bước 4: Duyệt hết các page còn lại 


}

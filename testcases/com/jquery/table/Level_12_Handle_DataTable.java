package com.jquery.table;


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.jquery.HomePageObject;
import pageObjects.jquery.PageGeneratorManager;


public class Level_12_Handle_DataTable extends BaseTest {
	private WebDriver driver;

	HomePageObject homePage;
	
	List<String> allValuesUI = new ArrayList<String>();
	List<String> allValuesDB = new ArrayList<String>();

	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserDriver(browserName, url); // chuyển vào hàm có 2 tham số, url ko cố định
		
		homePage = PageGeneratorManager.getHomePage(driver);
	
		
	}

	
	public void TC_01() {
    // Search dữ liệu trong table (trên header)
		
		homePage.inputToColumnTextBoxByName("Females", "232821");
		homePage.inputToColumnTextBoxByName("Males", "25266");
		homePage.inputToColumnTextBoxByName("Country", "Afghanistan");
		
	homePage.inputToColumnTextBoxByName("Total", "49397");
		

	}

	
	public void TC_02_Paging() {

		homePage.clickToPageByNumber("10");
		homePage.sleepInSecond(2);
		
		Assert.assertTrue(homePage.isPageActiveByNumber("10"));
		
		homePage.clickToPageByNumber("4");
		homePage.sleepInSecond(2);
		
		Assert.assertTrue(homePage.isPageActiveByNumber("4"));
		
		homePage.clickToPageByNumber("23");
		homePage.sleepInSecond(2);
		
		Assert.assertTrue(homePage.isPageActiveByNumber("23"));

	}
	

	public void TC_03_Displayed() {
		homePage.inputToColumnTextBoxByName("Country", "Afghanistan");
		Assert.assertTrue(homePage.isRowValuesDisplay("384187", "Afghanistan", "407124", "791312"));
		
		homePage.inputToColumnTextBoxByName("Country", "Armenia");
		Assert.assertTrue(homePage.isRowValuesDisplay("15999", "Armenia", "16456", "32487"));
		
		homePage.inputToColumnTextBoxByName("Country", "Angola");

		Assert.assertTrue(homePage.isRowValuesDisplay("276880", "Angola", "276472", "553353"));
		
		
	}
	
	public void TC_04_Click_To_Icon_Button_Checkbox() {
		
	// Click vào bất kì cái icon/button/checkbox
	// phải tìm đc key duy nhất 
		
		homePage.clickToRowActionByCountryName("Afghanistan", "remove");
		homePage.clickToRowActionByCountryName("Algeria", "remove");
		homePage.clickToRowActionByCountryName("Argentina", "remove");
		homePage.clickToRowActionByCountryName("Aruba", "remove");
		homePage.refreshCurrentPage(driver);
		
		homePage.clickToRowActionByCountryName("Afghanistan", "edit");
		homePage.refreshCurrentPage(driver);
		
		homePage.clickToRowActionByCountryName("Algeria", "edit");
		homePage.refreshCurrentPage(driver);
		
	}
	
	
	public void TC_05_Get_All_Column_Values() {
		// Lấy từ UI
		allValuesUI = homePage.getAllPageValuesByColumnName("Country");
		
		
		allValuesDB = homePage.getAllPageValuesByColumnNameInDB("Country");
		
		Assert.assertEquals(allValuesUI, allValuesDB);
		
		homePage.getAllPageValuesByColumnName("Total");
		
		
		
		

	}
	@Test
	public void TC_06_Action_By_Index() {

		homePage.openPageUrl(driver, "https://www.jqueryscript.net/demo/jQuery-Dynamic-Data-Grid-Plugin-appendGrid/");
		
		// Nhập vào textbox tại cột Contact person dòng thứ 2
		homePage.enterToTextboxByColumnNameByIndex("Contact Person", "2", "Maya Lee");
		homePage.enterToTextboxByColumnNameByIndex("Company", "1", "Zen8labs");
		
		// Select dữ liệu tại cột Country dòng thứ 3
		
		homePage.selectDropdownByColumnNameAndRowIndex("Country", "3", "Taiwan");
		homePage.selectDropdownByColumnNameAndRowIndex("Country", "1", "Japan");
		
		// Click vào checkbox tại cột NPO dòng thứ 1
		homePage.clickToCheckboxByColumnNameAndRowIndex("NPO?", "2");
		homePage.clickToCheckboxByColumnNameAndRowIndex("NPO?", "3");
		homePage.clickToCheckboxByColumnNameAndRowIndex("NPO?", "4");
		
		
		
		
	}

	@AfterClass
	public void afterClass() {
		quitsBrowserDriver();
	}

	


}

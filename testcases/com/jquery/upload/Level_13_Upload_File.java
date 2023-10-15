package com.jquery.upload;



import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.jquery.PageGeneratorManager;
import pageObjects.jquery.UploadPageObject;


public class Level_13_Upload_File extends BaseTest {
	WebDriver driver;
	UploadPageObject uploadPage;
	String hagiangCity= "hagiang.jpg";
	String halongCity= "halong.jpg";
	String hanoiCity = "hanoi.jpg";
	
	String[] fileNames = {hagiangCity, halongCity, hanoiCity};
	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserDriver(browserName, url); // chuyển vào hàm có 2 tham số, url ko cố định
		
		uploadPage = PageGeneratorManager.getUploadPage(driver);
		
	}


	@Test
	public void TC_01_Upload_Single_File() {

		uploadPage.uploadMultipleFiles(driver, hagiangCity);
		uploadPage.sleepInSecond(2);
		
		uploadPage.uploadMultipleFiles(driver, hanoiCity);
		uploadPage.sleepInSecond(2);
		
		uploadPage.uploadMultipleFiles(driver, halongCity);
		uploadPage.sleepInSecond(2);
		
		Assert.assertTrue(uploadPage.isFileLoadedSuccess(hagiangCity));
		Assert.assertTrue(uploadPage.isFileLoadedSuccess(hanoiCity));
		Assert.assertTrue(uploadPage.isFileLoadedSuccess(halongCity));
	
	 uploadPage.clickStartButtonOnEachFile();
	 
	 Assert.assertTrue(uploadPage.isFileUpLoadedSuccess(halongCity));
	 Assert.assertTrue(uploadPage.isFileUpLoadedSuccess(halongCity));	 
	 Assert.assertTrue(uploadPage.isFileUpLoadedSuccess(hanoiCity));
	}
	@Test
	public void TC_02_Upload_Multiple_File() {
		uploadPage.refreshCurrentPage(driver);
		uploadPage.uploadMultipleFiles(driver, fileNames);
		Assert.assertTrue(uploadPage.isFileLoadedSuccess(hagiangCity));
		Assert.assertTrue(uploadPage.isFileLoadedSuccess(hanoiCity));
		Assert.assertTrue(uploadPage.isFileLoadedSuccess(halongCity));
	
	 uploadPage.clickStartButtonOnEachFile();
	 
	 Assert.assertTrue(uploadPage.isFileUpLoadedSuccess(halongCity));
	 Assert.assertTrue(uploadPage.isFileUpLoadedSuccess(halongCity));	 
	 Assert.assertTrue(uploadPage.isFileUpLoadedSuccess(hanoiCity));
		
		
	}
	@Test
	public void TC_03_Upload_Gofile_Page() {
		uploadPage.openPageUrl(driver, "https://gofile.io/uploadFiles");
		
		Assert.assertTrue(uploadPage.isLoadingIconAtMainContentDisappear());
		uploadPage.uploadMultipleFiles(driver, fileNames);
		
		Assert.assertTrue(uploadPage.isLoadingIconAtMianUploadDisappear());
		Assert.assertTrue(uploadPage.isMultipleProcessBarIconDisappear());
		
		Assert.assertTrue(uploadPage.isSuccessMessageDisplayed("Your files have been successfully uploaded"));
		
		uploadPage.clickToSuccessLink();
		
		Assert.assertTrue(uploadPage.isContentTableDisplayed());
		
		Assert.assertTrue(uploadPage.isDownloadButtonDisplayed(hagiangCity));
		Assert.assertTrue(uploadPage.isDownloadButtonDisplayed(halongCity));
		Assert.assertTrue(uploadPage.isDownloadButtonDisplayed(hanoiCity));
		
		
		Assert.assertTrue(uploadPage.isPlayButtonDisplayed(hagiangCity));
		Assert.assertTrue(uploadPage.isPlayButtonDisplayed(halongCity));
		Assert.assertTrue(uploadPage.isPlayButtonDisplayed(hanoiCity));
		
		
		
		
		
	}
	@AfterClass
	public void afterClass() {
		quitsBrowserDriver();
	}

	


}

package pageObjects.jquery;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.jquery.UploadPageUI;

public class UploadPageObject extends BasePage {
	WebDriver driver;

	public UploadPageObject(WebDriver driver) {
		this.driver = driver;
}


	public boolean isFileLoadedSuccess(String fileName) {
    waitForElementVisible(driver, UploadPageUI.FILE_LOADED_BY_NAME, fileName);
    return isElementDisplayed(driver, UploadPageUI.FILE_LOADED_BY_NAME, fileName);
	}

	public void clickStartButtonOnEachFile() {
	List<WebElement> startButtons = getListWebElement(driver, UploadPageUI.MULTIPLE_START_BUTTON);
	for (WebElement button : startButtons) {
		waitForElementClickable(driver, button);
		clickToElement(driver, button);
		sleepInSecond(2);
	
	}
	}


	public boolean isFileUpLoadedSuccess(String fileName) {
		waitForElementVisible(driver, UploadPageUI.FILE_UPLOADED_BY_NAME, fileName);
	    return isElementDisplayed(driver, UploadPageUI.FILE_UPLOADED_BY_NAME, fileName);
		}


	public boolean isLoadingIconAtMainContentDisappear() {
		return waitForElementInvisible(driver, UploadPageUI.SPIN_BORDER_ICON_AT_MAIN_CONTENT);
		 
	}


	public boolean isLoadingIconAtMianUploadDisappear() {
		return waitForElementInvisible(driver, UploadPageUI.SPIN_BORDER_ICON_AT_MAINUPLOAD);
		 
	}


	public boolean isMultipleProcessBarIconDisappear() {
		return waitForListElementInvisible(driver, UploadPageUI.MULTIPLE_PROCESS_BAR_ICON);
	}


	public boolean isSuccessMessageDisplayed(String successMessage) {
		waitForElementVisible(driver, UploadPageUI.UPLOAD_SUCCESS_MESSAGE);
		return isElementDisplayed(driver, UploadPageUI.UPLOAD_SUCCESS_MESSAGE, successMessage);
	}


	public void clickToSuccessLink() {
		waitForElementClickable(driver, UploadPageUI.UPLOAD_SUCCESS_LINK);
        clickToElement(driver, UploadPageUI.UPLOAD_SUCCESS_LINK);  	
	}


	public boolean isContentTableDisplayed() {
		waitForElementVisible(driver, UploadPageUI.CONTENT_TABLE);
		return isElementDisplayed(driver, UploadPageUI.CONTENT_TABLE);
	
	}


	public boolean isDownloadButtonDisplayed(String fileNames) {
		waitForElementVisible(driver, UploadPageUI.DOWLOAD_BUTTON_BY_FILENAME, fileNames);
		return isElementDisplayed(driver, UploadPageUI.DOWLOAD_BUTTON_BY_FILENAME, fileNames);
	

	}


	public boolean isPlayButtonDisplayed(String fileNames) {
		waitForElementVisible(driver, UploadPageUI.PLAY_BUTTON_BY_FILENAME, fileNames);
		return isElementDisplayed(driver, UploadPageUI.PLAY_BUTTON_BY_FILENAME, fileNames);
	
	}
	}

package pageObjects.orangehrm;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.orangehrm.BaseActionsUI;

public class BaseActions extends BasePage {
   WebDriver driver;

  public BaseActions(WebDriver driver) {
	  this.driver = driver;
  }
  
  public void waitForSpinnerIconInvisible() {
	  waitForListElementInvisible(driver, BaseActionsUI.SPINNER_ICON_LOADING);
	  
  }
  
  public boolean isSuccessMessageDisplayed(String messageContent) {
		waitForElementVisible(driver, BaseActionsUI.DYNAMIC_SUCESS_MESSAGE_TOAST,messageContent);
		return isElementDisplayed(driver, BaseActionsUI.DYNAMIC_SUCESS_MESSAGE_TOAST,messageContent);
	}
  public boolean isValueDisplayedAtColumnName(String columnName, String rowIndex, String rowValue) {
		int columnIndex = getListElementSize(driver, BaseActionsUI.DYNAMIC_INDEX_BY_COLUMN_NAME, columnName) + 1;
		return isElementDisplayed(driver, BaseActionsUI.DYNAMIC_ROW_VALUE_BY_COLUMN_INDEX_ROW_INDEX, rowIndex, String.valueOf(columnIndex), rowValue);
	}
  
  public void clickToRadioByLabelName(String radioLabelName) {
	  clickToElementByJS(driver, BaseActionsUI.DYNAMIC_RADIO_BUTTON_BY_LABEL_NAME,radioLabelName);
  }

	
//	public void ClickToCheckboxByLabelName(String checkboxLabelName) {
//		if(!isElementSelected(driver, BaseActionsUI.DYNAMIC_CHECKBOX_BY_LABEL_NAME,checkboxLabelName)) {
//			clickToElementByJS(driver, BaseActionsUI.DYNAMIC_CHECKBOX_BY_LABEL_NAME,checkboxLabelName);
//
//		}	
//	}
//	
	public boolean isRadioButtonSelectedByLabelName(String radioLabelName) {
		return isElementSelected(driver, BaseActionsUI.DYNAMIC_RADIO_BUTTON_BY_LABEL_NAME,radioLabelName);
	}
	
//	public boolean isCheckboxSelectedByLabelName(String checkboxLabelName) {
//		return isElementSelected(driver, BaseActionsUI.DYNAMIC_CHECKBOX_BY_LABEL_NAME,checkboxLabelName);
//	}

	
	
}

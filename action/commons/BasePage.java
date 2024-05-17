package commons;

import java.io.File;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.admin.AdminLoginPageObject;
import pageObjects.users.AddressesPageObject;
import pageObjects.users.CustomerPageObject;
import pageObjects.users.DownloadableProductPageObject;
import pageObjects.users.HomePageObject;
import pageObjects.users.RewardPointsPageObject;
import pageUIs.admin.AdminDashboardPageUI;
import pageUIs.users.BaseElementUI;
import pageUIs.users.SideBarMyAccountPaseUI;
import pageUIs.users.UserHomePageUI;

public class BasePage {
//	/// chứa những hàm dùng chung cho cả layer page objects
//	
//	// Action: click/ sendkey/ select/.. thì dùng hàm void
//	
//	public void clickToElement() {}
//	
//	// Return data: getText/getAttribute/ getCss/ getSize/ getLocation/ getPosition thì sẽ là nhưng kiểu dữ liệu lưu trữ dữ liệu ( int, string, boolean, webElement. List<WebElement>,..
//	public String getTextElement() {
//		return null;
//	}

	public static BasePage getBasePage() {
		return new BasePage();
		
	}
	
	public void openPageUrl(WebDriver driver, String url) {
		driver.get(url);
	}
	
	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}
	
	public String getPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}
	
	public String getPageSource(WebDriver driver) {
		return driver.getPageSource();
		
	}
	
	public void backToPage(WebDriver driver) {
		driver.navigate().back();
	}
	
	public void refreshCurrentPage(WebDriver driver) {
		driver.navigate().refresh();
	}
	
	public void forwardToPage(WebDriver driver) {
		driver.navigate().forward();
	}
	
	public void acceptToAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	public void cancelToAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	public String getAlertText(WebDriver driver) {
		return driver.switchTo().alert().getText();
	}
	
	public void sendkeyToAlert(WebDriver driver, String valueToSendkey) {
		driver.switchTo().alert().sendKeys(valueToSendkey);
	}
	
	public Alert waitForAlertPresence(WebDriver driver) {
		//return new WebDriverWait(driver, 30).until(ExpectedConditions.alertIsPresent());
		return new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.alertIsPresent());
	}
	
	public void switchToWindowByID(WebDriver driver, String windowID) {
		Set<String> allIDs = driver.getWindowHandles();
		
		for (String id : allIDs) {
			if (!id.equals(windowID)) {
				driver.switchTo().window(id);
				sleepInSecond(2);
				break;
			}
			
		}
		
	}
	
	public void switchToWindowByTitle(WebDriver driver, String expectedTitle) {
		Set<String> allIDs = driver.getWindowHandles();
		
		for (String id : allIDs) {
			driver.switchTo().window(id);
			String actualTitle = driver.getTitle();
			if (actualTitle.equals(expectedTitle)) {
				break;
			}
		}
		
	}
	
	/// Xóa tất cả các tab ngoại trừ 1 tab muốn để lại
	public void closeAllWindowWithoutExpectedID(WebDriver driver, String expectedID) {
		Set<String> allIDs = driver.getWindowHandles();
		
		for (String id : allIDs) {
			if (!id.equals(expectedID)) {
				driver.switchTo().window(id);
				driver.close();
			}
		}
		driver.switchTo().window(expectedID);
		
	}
	
	public void sleepInSecond(long timeoutInSeconds) {
		try {
			Thread.sleep(timeoutInSeconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public By getByLocator(String locatorValue) {

		By by = null;

		if (locatorValue.startsWith("xpath=") || locatorValue.startsWith("XPath") || locatorValue.startsWith("XPATH")
				|| locatorValue.startsWith("Xpath")) {
			by = By.xpath(locatorValue.substring(6));
		} else if (locatorValue.startsWith("css=") || locatorValue.startsWith("Css")
				|| locatorValue.startsWith("CSS")) {
			by = By.cssSelector(locatorValue.substring(4));
		} else if (locatorValue.startsWith("id=") || locatorValue.startsWith("Id") || locatorValue.startsWith("ID")) {
			by = By.id(locatorValue.substring(3));
		} else if (locatorValue.startsWith("name=") || locatorValue.startsWith("Name") || locatorValue.startsWith("NAME")) {
			by = By.name(locatorValue.substring(5));
		} else if (locatorValue.startsWith("class=") || locatorValue.startsWith("Class") || locatorValue.startsWith("CLASS")) {
			by = By.className(locatorValue.substring(6));
		} else if (locatorValue.startsWith("tagname=") || locatorValue.startsWith("Tagname") || locatorValue.startsWith("TAGNAME")) {
			by = By.tagName(locatorValue.substring(8));
		} else {
			throw new RuntimeException("Locator type is not valid");
			
		}
		return by;

	}

	public By getByXpath(String xpathExpression) {
		return By.xpath(xpathExpression);
	}
	
	
	public String getDynamicLocator(String locator, String...restParams) {
		return locator = String.format(locator, (Object[]) restParams);
	}
	
	

	public WebElement getWebElement(WebDriver driver, String locator) {
		return driver.findElement(getByLocator(locator));
	}

	public List<WebElement> getListWebElement(WebDriver driver, String locator) {
		
		return driver.findElements(getByLocator(locator));
	}
	public List<WebElement> getListWebElement(WebDriver driver, String locator, String...restParams) {

		return driver.findElements(getByLocator(getDynamicLocator(locator, restParams)));
	}

	public void clickToElement(WebDriver driver, String locator) {
		getWebElement(driver, locator).click();
	}
	public void clickToElement(WebDriver driver, WebElement element) {
		element.click();
	}

	public void clickToElement(WebDriver driver, String locator, String...restParams) {
		getWebElement(driver, getDynamicLocator(locator, restParams)).click();
	}
	
	
	public void sendkeyToElement(WebDriver driver, String locator, String valueToSend) {
		
		getWebElement(driver, locator).clear();
		getWebElement(driver, locator).sendKeys(valueToSend);
	}
	public void sendkeyToElement(WebDriver driver, String locator, String valueToSend, String...restParams) {

		getWebElement(driver, getDynamicLocator(locator, restParams)).clear();
		getWebElement(driver, getDynamicLocator(locator, restParams)).sendKeys(valueToSend);
	}

	public String getElementText(WebDriver driver, String locator) {
		return getWebElement(driver, locator).getText();
	}
	
	public String getElementText(WebDriver driver, String locator, String...restParams ) {
		return getWebElement(driver, getDynamicLocator(locator, restParams)).getText();
	}

	public void selectItemInDefaultDropdown(WebDriver driver, String locator, String itemText) {
		
		new Select(getWebElement(driver, locator)).selectByVisibleText(itemText);
	}
	public void selectItemInDefaultDropdown(WebDriver driver, String locator, String itemText, String...restParams) {

		new Select(getWebElement(driver, getDynamicLocator(locator, restParams))).selectByVisibleText(itemText);
	}

	public String getFirstSelectedOption(WebDriver driver, String xpathExpression) {
		return new Select(getWebElement(driver, xpathExpression)).getFirstSelectedOption().getText();

	}

	public boolean isDropdownMultiple(WebDriver driver, String xpathExpression) {
		return new Select(getWebElement(driver, xpathExpression)).isMultiple();
	}

	
	
	public void selectItemInCustomDropdown(WebDriver driver, String ParentLocator, String ChildLocator,

			String expectedText) {

		getWebElement(driver, ParentLocator).click();
		sleepInSecond(1);

		List<WebElement> allItems = new WebDriverWait(driver, Duration.ofSeconds(longTimeout))
				.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(ChildLocator)));

		for (WebElement tempElement : allItems) {

			if (tempElement.getText().equals(expectedText)) {

				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", tempElement);
				sleepInSecond(1);

				tempElement.click();
				sleepInSecond(1);
				break;
			}
		}

	}

	public String getElementAttribute(WebDriver driver, String locator, String attributeName) {
		return getWebElement(driver, locator).getAttribute(attributeName);
	}
	public String getElementAttribute(WebDriver driver, String locator, String attributeName, String...restParams ) {
		return getWebElement(driver, getDynamicLocator(locator, restParams)).getAttribute(attributeName);
	}

	public String getElementCssValue(WebDriver driver, String locator, String propertyName) {
		return getWebElement(driver, locator).getCssValue(propertyName);

	}

	public String getHexaColor(String rgbaColor) {
		return Color.fromString(rgbaColor).asHex().toUpperCase();
	}

	public int getListElementSize(WebDriver driver, String locator) {
		
		return getListWebElement(driver, locator).size();
		
	}
	
	public int getListElementSize(WebDriver driver, String locator, String...restParams) {

		return getListWebElement(driver, getDynamicLocator(locator, restParams)).size();

	}

	public void checkToCheckboxRadio(WebDriver driver, String locator) {

		if (!getWebElement(driver, locator).isSelected()) {
			getWebElement(driver, locator).click();
		}
	}
	
	//Default Checkbox or Radio
	public void checkToElement(WebDriver driver, String locator) {
		if (!getWebElement(driver, locator).isSelected()) {
			getWebElement(driver, locator).click();
		}
	}
	
	//Default Checkbox or Radio
	public void checkToElement(WebDriver driver, String locator, String...restParams) {
		if (!getWebElement(driver, getDynamicLocator(locator, restParams)).isSelected()) {
			getWebElement(driver, getDynamicLocator(locator, restParams)).click();
		}
	}
	
	//Default Checkbox
	public void uncheckToElement(WebDriver driver, String locator) {
		if (getWebElement(driver, locator).isSelected()) {
			getWebElement(driver, locator).click();
		}
	}

	 // case 1: Element có hiển thị trên Ui và có trong HTML: isDisplayed trả về true
	// case 2: Element ko hiển thị trên Ui và vẫn có trong HTML: isDisplayed trả về false
	
	public boolean isElementDisplayed(WebDriver driver, String locator) {
	return getWebElement(driver, locator).isDisplayed();
	}
	
	public void setImplicitWait(WebDriver driver, long timeout) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));
	}
	
	
	// case 3: Element ko hiển thị trên Ui và ko trong HTML: tự gán bằng false
	public boolean isElementUnDisplayed(WebDriver driver, String locator) {
		// trc khi find elemnet thi set thoi gian ngan
		setImplicitWait(driver, shortTimeout);
		List<WebElement> element = getListWebElement( driver, locator);
		
		//tra lai timeout mac dinh cho cac step con lai
		setImplicitWait(driver, longTimeout);
		if (element.size() == 0) {  // Element ko co tren UI va ko co Dom -> check co undisplayed ko -> Co
			return true;
		} else if (element.size() > 0  && !element.get(0).isDisplayed()) { // Element ko tren UI va co Dom -> check co undisplayed ko -> Co
			return true;
		} else { // element co tren UI va co DOM
			return false;
		}
	}
	
	public boolean isElementDisplayed(WebDriver driver, String locator, String... restParams) {
		return getWebElement(driver, getDynamicLocator(locator, restParams)).isDisplayed();
	}

	public boolean isElementSelected(WebDriver driver, String locator) {
		return getWebElement(driver, locator).isSelected();
	}

	public boolean isElementSelected(WebDriver driver, String locator, String...restParams) {
		return getWebElement(driver, getDynamicLocator(locator, restParams)).isSelected();
	}

	
	public boolean isElementEnable(WebDriver driver, String locator) {
		return getWebElement(driver, locator).isEnabled();
	}

	public void switchToFrame(WebDriver driver, String locator) {
		new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(getByLocator(locator)));
	}

	public void switchToDefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	public void hoverToElement(WebDriver driver, String locator) {
		Actions action = new Actions(driver);
		action.moveToElement(getWebElement(driver, locator)).perform();

	}

	public void doubleClickToElement(WebDriver driver, String locator) {
		new Actions(driver).doubleClick(getWebElement(driver, locator)).perform();
	}

	public void rightClickToElement(WebDriver driver, String locator) {
		new Actions(driver).contextClick(getWebElement(driver, locator)).perform();
	}

	public void dragAndDropToElement(WebDriver driver, String sourceXpath, String targetXpath) {
		new Actions(driver).dragAndDrop(getWebElement(driver, sourceXpath), getWebElement(driver, targetXpath)).perform();
	}

	public void sendKeyBoardToElement(WebDriver driver, String locator, Keys key) {
		new Actions(driver).sendKeys(getWebElement(driver, locator), key).perform();
	}

	public Object executeForBrowser(WebDriver driver, String javaScript) {
		return ((JavascriptExecutor) driver).executeScript(javaScript);
	}

	public String getInnerText(WebDriver driver) {
		return (String) ((JavascriptExecutor) driver).executeScript("return document.documentElement.innerText;");
	}

	public boolean areExpectedTextInInnerText(WebDriver driver, String textExpected) {
		String textActual = (String) ((JavascriptExecutor) driver)
				.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0];");
		return textActual.equals(textExpected);
	}

	public void scrollToBottomPage(WebDriver driver) {
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void navigateToUrlByJS(WebDriver driver, String url) {
		((JavascriptExecutor) driver).executeScript("window.location = '" + url + "'");
		sleepInSecond(3);
	}

	public void hightlightElement(WebDriver driver, String locator) {
		WebElement element = getWebElement(driver, locator);
		String originalStyle = element.getAttribute("style");
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', arguments[1])", element,
				"border: 2px solid red; border-style: dashed;");
		sleepInSecond(2);
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', arguments[1])", element,
				originalStyle);
	}

	public void clickToElementByJS(WebDriver driver, String locator) {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", getWebElement(driver, locator));
		sleepInSecond(3);
	}

	public void clickToElementByJS(WebDriver driver, String locator, String...restParams) {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", getWebElement(driver, getDynamicLocator(locator, restParams)));
		sleepInSecond(3);
	}
	public void scrollToElementOnTop(WebDriver driver, String locator) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				getWebElement(driver, locator));
	}

	public void scrollToElementOnDown(WebDriver driver, String locator) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);",
				getWebElement(driver, locator));
	}

	public void setAttributeInDOM(WebDriver driver, String locator, String attributeName,
			String attributeValue) {
		((JavascriptExecutor) driver).executeScript(
				"arguments[0].setAttribute('" + attributeName + "', '" + attributeValue + "');",
				getWebElement(driver, locator));
	}

	public void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove) {
		((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('" + attributeRemove + "');",
				getWebElement(driver, locator));
	}

	public void sendKeyToElementByJS(WebDriver driver, String locator, String value) {
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('value', '" + value + "')",
				getWebElement(driver, locator));
	}

	public String getAttributeInDOM(WebDriver driver, String locator, String attributeName) {

		return (String) ((JavascriptExecutor) driver).executeScript(
				"return arguments[0].getAttribute('" + attributeName + "');", getWebElement(driver, locator));
	}

	public String getElementValidationMessage(WebDriver driver, String locator) {

		return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].validationMessage;",
				getWebElement(driver, locator));
	}

	public boolean isImageLoaded(WebDriver driver, String locator) {


		return (boolean) ((JavascriptExecutor) driver).executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0",
				getWebElement(driver, locator));
	}

	public boolean isPageLoadedSuccess(WebDriver driver) {

		WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(longTimeout));
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
	
		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {

			@Override
			public Boolean apply(WebDriver driver) {

				return (Boolean) jsExecutor.executeScript("return (window.jQuery != null) && (jQuery.active === 0);");
			}
		};

		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {

			@Override
			public Boolean apply(WebDriver driver) {

				return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
			}
		};
		return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
	}
	
	public void waitForElementVisible(WebDriver driver, String locator) {
		new WebDriverWait(driver, Duration.ofSeconds(longTimeout))
		.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locator)));
	}
	public void waitForElementVisible(WebDriver driver, String locator, String...restParams) {
		new WebDriverWait(driver, Duration.ofSeconds(longTimeout))
				.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(getDynamicLocator(locator, restParams))));
	}

	public void waitForListElementVisible(WebDriver driver, String locator) {
		new WebDriverWait(driver, Duration.ofSeconds(longTimeout))
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(locator)));

	}

	public void waitForElementClickable(WebDriver driver, String locator) {
		
		new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.elementToBeClickable(getWebElement(driver,locator)));
	}
	public void waitForElementClickable(WebDriver driver, WebElement element) {
		
		new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void waitForElementClickable(WebDriver driver, String locator, String...restParams) {

		new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.elementToBeClickable(getWebElement(driver,getDynamicLocator(locator, restParams))));
	}

	public boolean waitForElementInvisible(WebDriver driver, String locator) {
		return new WebDriverWait(driver, Duration.ofSeconds(longTimeout))
				.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locator)));
	}
	public boolean waitForListElementInvisible(WebDriver driver, String locator) {
		return new WebDriverWait(driver, Duration.ofSeconds(longTimeout))
				.until(ExpectedConditions.invisibilityOfAllElements(getListWebElement(driver, locator)));
	}

	public Set<Cookie> getBrowserCookies(WebDriver driver){
		return driver.manage().getCookies();
		}
	
	public void setCookie(WebDriver driver, Set<Cookie> cookies) {
		for (Cookie cookie : cookies) {
			driver.manage().addCookie(cookie);
		}
	}
	
	
	
	
	public void waitForListElementClickable(WebDriver driver, String locator, String...restParams) {

		new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.elementToBeClickable(getWebElement(driver,getDynamicLocator(locator, restParams))));
	}
	
	public RewardPointsPageObject openRewardPointPage(WebDriver driver) {
		waitForElementClickable(driver, SideBarMyAccountPaseUI.REWARD_POINT_PAGE_LINK);
		clickToElement(driver, SideBarMyAccountPaseUI.REWARD_POINT_PAGE_LINK);
		return PageGeneratorManager.getRewardPointsPage(driver);
	}

	public DownloadableProductPageObject openDownloadableProdcutPage(WebDriver driver) {
		waitForElementClickable(driver, SideBarMyAccountPaseUI.DOWNLOADABLE_PRODUCT_PAGE_LINK);
		clickToElement(driver, SideBarMyAccountPaseUI.DOWNLOADABLE_PRODUCT_PAGE_LINK);
		return PageGeneratorManager.getDownloadableProductPage(driver);
	}
	
	public AddressesPageObject openAddressesPage(WebDriver driver) {
		waitForElementClickable(driver, SideBarMyAccountPaseUI.ADDRESSES_PAGE_LINK);
		clickToElement(driver, SideBarMyAccountPaseUI.ADDRESSES_PAGE_LINK);
		return PageGeneratorManager.getAddressesPage(driver);
	}

	public CustomerPageObject openCustomerInForPage(WebDriver driver) {

		waitForElementClickable(driver, SideBarMyAccountPaseUI.INFOR_PAGE_LINK);
		clickToElement(driver, SideBarMyAccountPaseUI.INFOR_PAGE_LINK);
		return PageGeneratorManager.getCustomerPage(driver);
	}

	
	public HomePageObject userAbleToLogout(WebDriver driver) {
		waitForElementClickable(driver, UserHomePageUI.USER_LOGOUT_LINK);
		clickToElement(driver, UserHomePageUI.USER_LOGOUT_LINK);
		return PageGeneratorManager.getHomePage(driver);
	}
	
	public AdminLoginPageObject adminAbleToLogout(WebDriver driver) {
		waitForElementClickable(driver, AdminDashboardPageUI.LOGOUT_LINK);
		clickToElement(driver, AdminDashboardPageUI.LOGOUT_LINK);
		return PageGeneratorManager.getAdminLoginPage(driver);
	}
	
	public void uploadMultipleFiles(WebDriver driver, String...fileNames) {

		     String filePath = GlobalConstants.UPLOAD_PATH;
		     
		     String fullFileName = "";
		     for (String file : fileNames) {
				  fullFileName = fullFileName + filePath + file + "\n";
			}
		     fullFileName = fullFileName.trim();
		     getWebElement(driver, BaseElementUI.UPLOAD_FILE_TYPE ).sendKeys(fullFileName);
	
	}
	
	
	private long shortTimeout = GlobalConstants.SHORT_TIMEOUT;
	private long longTimeout = GlobalConstants.LONG_TIMEOUT;
	
	
}

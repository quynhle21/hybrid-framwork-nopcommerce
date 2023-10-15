package javaBasic;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Topic_03_By {
	public static void main(String[] args) {
		// đầu vào là xpath/ css/ id/ name/ class/ tagname/ linkText/ partialLinkText
		// đầu ra nó sẽ lấy đúng loại By tương ứng

		// xpath= // input[@id='name'] -> By.xpath
		// css = input[id='name'] -> By.cssSelector
		// id= ABC -> By.id
		// name = email -> By.name

		String locatorValue = "xpath=//input[@id='name']";
		System.out.println(locatorValue);

	}

	@Test
	public void TC_01_Locator_Lower_Case() {
		String locatorValue = "xpath=//input[@id='name']";

		Assert.assertEquals(getByLocator(locatorValue), By.xpath("xpath=//input[@id='name']"));

	}

	@Test
	public void TC_02_Locator_Camel_Case() {
		String locatorValue = "Xpath=//input[@id='name']";

		Assert.assertEquals(getByLocator(locatorValue), By.xpath("xpath=//input[@id='name']"));

	}

	@Test
	public void TC_03_Locator_Upper_Case() {
		String locatorValue = "XPATH=//input[@id='name']";

		Assert.assertEquals(getByLocator(locatorValue), By.xpath("xpath=//input[@id='name']"));

	}

	@Test
	public void TC_04_Locator_Invalid_Case() {
		String locatorValue = "classname=email";

		Assert.assertEquals(getByLocator(locatorValue), By.className("email"));

	}
	public By getByLocator(String locatorValue) {

		By by = null;

		if (locatorValue.startsWith("xpath=") || locatorValue.startsWith("XPath") || locatorValue.startsWith("XPATH")
				|| locatorValue.startsWith("xpath")) {
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

}

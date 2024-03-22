package com.facebook.home;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Sleeper;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.facebook.HomePageObject;
import pageObjects.facebook.PageGeneratorManager;

public class Level_19_Element_Undisplayed extends BaseTest {
	 WebDriver driver;
	 HomePageObject homePage;

	
	
	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);
		
		homePage = PageGeneratorManager.getHomePage(driver);
	}

	@Test
	public void Home_01_Element_Displayed() {
	 homePage.clickToCreateNewAccoutButton();
	 
	 verifyTrue(homePage.isFirstNameTextboxDisplayed());
	 verifyTrue(homePage.isSurNameTextboxDisplayed());
	 verifyTrue(homePage.isEmailTextboxDisplayed());
	verifyTrue(homePage.isPasswordTextboxDisplayed());
	
	homePage.enterToEmailTextbox("quynh@gmail.com");
	log.info("Verrify confirm email textbox is displayed");
	verifyTrue(homePage.isConfirmEmailTextboxDisplayed());
	
	
	}
	
	@Test
	public void Home_02_Element_Undisplayed_In_HTML() {
		
		homePage.enterToEmailTextbox("");
		homePage.sleepInSecond(2);
		
		log.info("Verrify confirm email textbox is undisplayed");
		verifyFalse(homePage.isConfirmEmailTextboxDisplayed());
		
		
		
	}
	@Test
	public void Home_03_Element_Undisplayed_Not_In_HTML_C1() {
		
		homePage.clickToCloseSignUpPopup();
		
		log.info("Verrify First Name textbox is undisplayed");
		verifyFalse(homePage.isFirstNameTextboxDisplayed());
		
		log.info("Verrify SurName textbox is undisplayed");
		verifyFalse(homePage.isSurNameTextboxDisplayed());
		
		log.info("Verrify  email textbox is undisplayed");
		verifyFalse(homePage.isEmailTextboxDisplayed());
		
		log.info("Verrify Password textbox is undisplayed");
		verifyFalse(homePage.isPasswordTextboxDisplayed());
		
		
	}
	@Test
	public void Home_03_Element_Undisplayed_Not_In_HTML_C2() {
		
		homePage.clickToCloseSignUpPopup();
		
		log.info("Verrify First Name textbox is undisplayed");
		verifyTrue(homePage.isFirstNameTextboxUnDisplayed());
		
		log.info("Verrify SurName textbox is undisplayed");
		verifyTrue(homePage.isSurNameTextboxUnDisplayed());
		 
		log.info("Verrify  email textbox is undisplayed");
		verifyTrue(homePage.isEmailTextboxUnDisplayed());
		
		log.info("Verrify Password textbox is undisplayed");
		verifyTrue(homePage.isPasswordTextboxUnDisplayed());
		
		
	}
	

	@AfterClass
	public void afterClass() {
		 quitsBrowserDriver();
	}

	public String getEmailAddress() {
		Random rand = new Random();
		return "sam" + rand.nextInt(9999) + "@gmail.com";

	}
}

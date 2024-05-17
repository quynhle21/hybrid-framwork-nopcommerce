package com.orangehrm.pim;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import commons.BaseTest;
import commons.GlobalConstants;
import pageObjects.orangehrm.AddEmployeePageObject;
import pageObjects.orangehrm.DashboardPageObject;
import pageObjects.orangehrm.EmployeeListPageObject;
import pageObjects.orangehrm.LoginPageObject;
import pageObjects.orangehrm.PageGeneratorManager;
import pageObjects.orangehrm.PersonalDetailsPageObject;
import pageUIs.orangehrm.PersonalDetailsPageUI;
import reportConfig.ExtentTestManager;

public class PIM_01_Employee extends BaseTest {
	private WebDriver driver;
	private String browserName, employeeID, firstName, lastName;
	private String driverLicenseNumber, licenseExpiryDate, nationality, maritalStatus;
	private String dateOfBirth, genderStatus, smokerStatus;
	private LoginPageObject loginPage;
	private DashboardPageObject dashboardPage;
	private EmployeeListPageObject employeeListPage;
	private AddEmployeePageObject addEmployeePage;
	private PersonalDetailsPageObject personalDetailsPage;

	@Parameters({ "url", "browser" })
	@BeforeClass
	public void beforeClass(String url, String browserName) {
		driver = getBrowserDriver(browserName, url);
		this.browserName = browserName;
		firstName = "Meiu";
		lastName = "Lee";

		driverLicenseNumber = "D0689258";
		licenseExpiryDate = "2023-03-03";
		nationality = "Vietnam";
		maritalStatus = "Married";

		dateOfBirth = "1999-21-11";
		genderStatus = "Female";
		smokerStatus = "Yes";

		loginPage = PageGeneratorManager.getLoginPage(driver);

		loginPage.enterToUserNameTexthox(GlobalConstants.ADMIN_ORANGE_HRM_USERNAME);

		loginPage.enterToPasswordTexthox(GlobalConstants.ADMIN_ORANGE_HRM_PASSWORD);

		dashboardPage = loginPage.clickToLoginButton();

		employeeListPage = dashboardPage.openPIMModule();

	}

	@Test
	public void Employee_01_Add_New(Method method) {
		ExtentTestManager.startTest(method.getName() + "- Run on" + browserName, "Employee_01_Add_New");

		addEmployeePage = employeeListPage.clickToAddEmployeeButton();

		addEmployeePage.enterToFirstNameTextbox(firstName);
		addEmployeePage.enterToLastNameTextbox(lastName);
		employeeID = addEmployeePage.getEmployeeID();

		addEmployeePage.clickSaveButton();

		Assert.assertTrue(addEmployeePage.isSuccessMessageDisplayed("Successfully Saved"));
		addEmployeePage.waitForSpinnerIconInvisible();

		personalDetailsPage = PageGeneratorManager.getPersonalDetailsPage(driver);

		Assert.assertTrue(personalDetailsPage.isPersonalDetailsHeaderDisplay());
		personalDetailsPage.waitForSpinnerIconInvisible();

		Assert.assertEquals(personalDetailsPage.getFirstNameValue(), firstName);
		Assert.assertEquals(personalDetailsPage.getLasttNameValue(), lastName);
		Assert.assertEquals(personalDetailsPage.getEmployeeIDValue(), employeeID);

		employeeListPage = personalDetailsPage.clickToEmployeeListButton();

		employeeListPage.enterToEmployeeIDTextbox(employeeID);
		employeeListPage.clickToSearchButton();

		Assert.assertTrue(employeeListPage.isValueDisplayedAtColumnName("Id", "1", employeeID));
		Assert.assertTrue(employeeListPage.isValueDisplayedAtColumnName("First (& Middle) Name", "1", firstName));
		Assert.assertTrue(employeeListPage.isValueDisplayedAtColumnName("Last Name", "1", lastName));

	}

	@Test
	public void Employee_02_Personal_Details(Method method) {
		ExtentTestManager.startTest(method.getName() + "- Run on" + browserName.toUpperCase(),
				"Employee_02_Personal_Details");

		personalDetailsPage = employeeListPage.clickToEditIconByEachEmployee(employeeID);

		Assert.assertTrue(personalDetailsPage.isPersonalDetailsHeaderDisplay());

		Assert.assertEquals(personalDetailsPage.getFirstNameValue(), firstName);
		Assert.assertEquals(personalDetailsPage.getLasttNameValue(), lastName);
		Assert.assertEquals(personalDetailsPage.getEmployeeIDValue(), employeeID);

		personalDetailsPage.enterToDriverLicenseNumberTextbox(driverLicenseNumber);

		personalDetailsPage.enterToLicenseExpiryDatePicker(licenseExpiryDate);

		personalDetailsPage.selectToNationalityDropdown(nationality);

		personalDetailsPage.selectMaritalStatusDropdown(maritalStatus);

		personalDetailsPage.DateOfBirthDatePicker(dateOfBirth);

		personalDetailsPage.clickToRadioByLabelName(genderStatus);

	//	personalDetailsPage.clickToCheckboxByLabelName(smokerStatus);

		personalDetailsPage.clickSaveButtonAtPersonalDetailPart();

		Assert.assertTrue(personalDetailsPage.isSuccessMessageDisplayed("Successfully Updated"));
		personalDetailsPage.waitForSpinnerIconInvisible();
		
		Assert.assertEquals(personalDetailsPage.getNationalityDropdownSelectedText(),nationality);
		Assert.assertEquals(personalDetailsPage.getMaritalStatusDropdownSelectedText(),maritalStatus);
        
		Assert.assertTrue(personalDetailsPage.isRadioButtonSelectedByLabelName(genderStatus));
	//  Assert.assertTrue(personalDetailsPage.isCheckboxSelectedByLabelName(smokerStatus));
	
	}

	@Test
	public void Employee_03_Contact_Details(Method method) {
		ExtentTestManager.startTest(method.getName() + "- Run on" + browserName.toUpperCase(),
				"Employee_03_Contact_Details");

	}

	@Test
	public void Employee_04_Emergency_Contact(Method method) {
		ExtentTestManager.startTest(method.getName() + "- Run on" + browserName.toUpperCase(),
				"Employee_04_Emergency_Contact");

	}

	@Test
	public void Employee_05_Dependents(Method method) {
		ExtentTestManager.startTest(method.getName() + "- Run on" + browserName.toUpperCase(),
				"Employee_05_Dependents");

	}

	@Test
	public void Employee_06_Immigration(Method method) {
		ExtentTestManager.startTest(method.getName() + "- Run on" + browserName.toUpperCase(),
				"Employee_06_Immigration");

	}

	@Test
	public void Employee_07_Job(Method method) {
		ExtentTestManager.startTest(method.getName() + "- Run on" + browserName.toUpperCase(), "Employee_07_Job");

	}

	@Test
	public void Employee_08_Salary(Method method) {
		ExtentTestManager.startTest(method.getName() + "- Run on" + browserName.toUpperCase(), "Employee_08_Salary");

	}

	@Test
	public void Employee_09_Report_To(Method method) {
		ExtentTestManager.startTest(method.getName() + "- Run on" + browserName.toUpperCase(), "Employee_09_Report_To");

	}

	@Test
	public void Employee_10_Qualifications(Method method) {
		ExtentTestManager.startTest(method.getName() + "- Run on" + browserName.toUpperCase(),
				"Employee_10_Qualifications");

	}

	@AfterClass
	public void afterClass() {
		quitsBrowserDriver();

	}

}

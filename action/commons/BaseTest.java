
package commons;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeSuite;


public class BaseTest {
	

/// chứa những hàm dùng chung cho cả layer testcase

	protected final Logger log;
	private WebDriver driver;

	public WebDriver getDriver() {

		return driver;
	}

	public BaseTest() {

		log = LogManager.getLogger(getClass());
		
	}
	
	protected WebDriver getBrowserDriver(String browserName) {
       BrowserList browser = BrowserList.valueOf(browserName.toUpperCase());
		switch (browser) {
		case CHROME:
//			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
//			driver = new ChromeDriver();
			
			//driver = WebDriverManager.chromedriver().create(); // tự tải chromedriver tương ứng với chrome browser + khởi tạo driver lên
			
	
			driver= new ChromeDriver(); 
			break;
		case FIREFOX:
//			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
//			driver = new FirefoxDriver();
			
			//driver = WebDriverManager.firefoxdriver().create(); 
			driver= new FirefoxDriver();
			break;
		case EDGE:
//			System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver.exe");
//			driver = new EdgeDriver();
			//driver = WebDriverManager.edgedriver().create(); 
			
			driver= new EdgeDriver();
			break;

		default:
			throw new RuntimeException("Browser name is not support");
			}
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
		return driver;
			
		}
		
		protected WebDriver getBrowserDriver(String browserName, String url) {
		       BrowserList browser = BrowserList.valueOf(browserName.toUpperCase());
				switch (browser) {
				case CHROME:
//					System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
//					driver = new ChromeDriver();
					
					//driver = WebDriverManager.chromedriver().create(); // tự tải chromedriver tương ứng với chrome browser + khởi tạo driver lên
					
					driver= new ChromeDriver();
					break;
				case FIREFOX:
//					System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
//					driver = new FirefoxDriver();
					
					//driver = WebDriverManager.firefoxdriver().create(); 
					driver= new FirefoxDriver();
					break;
				case EDGE:
//					System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver.exe");
//					driver = new EdgeDriver();
					//driver = WebDriverManager.edgedriver().create(); 
					
					driver= new EdgeDriver();
					break;

				default:
					throw new RuntimeException("Browser name is not support");
					
				}
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
        driver.get(url);
		return driver;
        
	}
	
	protected String getEmailAddress() {
		Random rand = new Random();
		return "john" + rand.nextInt(9999) + "@gmail.com";
	}
	
	protected void quitsBrowserDriver() {
		// tạo biến command line
		String cmd = null;
		try {
			String osName = GlobalConstants.OS_NAME.toLowerCase();
			log.info("OS name = " + osName);

			String driverInstanceName = driver.toString().toLowerCase();
			log.info("Driver instance name = " + driverInstanceName);

			String browserDriverName = null;

			if (driverInstanceName.contains("chrome")) {
				browserDriverName = "chromedriver";
			} else if (driverInstanceName.contains("internetexplorer")) {
				browserDriverName = "IEDriverServer";
			} else if (driverInstanceName.contains("firefox")) {
				browserDriverName = "geckodriver";
			} else if (driverInstanceName.contains("edge")) {
				browserDriverName = "msedgedriver";
			} else if (driverInstanceName.contains("opera")) {
				browserDriverName = "operadriver";
			} else {
				browserDriverName = "safaridriver";
			}

			if (osName.contains("window")) {
				cmd = "taskkill /F /FI \'IMAGENAME eq " + browserDriverName + "*\'";
			} else {
				cmd = "pkill " + browserDriverName;
			}

			// Đóng browser
			if (driver != null) {
				driver.manage().deleteAllCookies();
				driver.quit();
			}
		} catch (Exception e) {
			log.info(e.getMessage());
		} finally {
			// Đóng ở trong bảng Manager task
			try {
				Process process = Runtime.getRuntime().exec(cmd);
				process.waitFor();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
	
	protected boolean verifyTrue(boolean condition) {

		boolean pass = true;
		try {
			Assert.assertTrue(condition);
	 		log.info("------ PASSED------");
		} catch (Throwable e) {
			
			log.info("------ FAILED-------");
			pass = false;

			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}
	
	protected boolean verifyFalse(boolean condition) {

		boolean pass = true;
		try {
			Assert.assertFalse(condition);
			log.info("------ PASSED------");

		} catch (Throwable e) {
			log.info("------ FAILED------");

			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}
	
protected boolean verifyEquals(Object actual, Object expected) {

		boolean pass = true;
		try {
			Assert.assertEquals(actual, expected);
			log.info("------ PASSED-------");

		} catch (Throwable e) {
			log.info("------ FAILED-------");

			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

@BeforeSuite
public void deleteFileInReport() {

	// Remove all file in ReportNG screenshot (image)
	deleteAllFileInFolder("reportNGImage");

	// Remove all file in Allure attachment (json file)
	deleteAllFileInFolder("allure-json");
}

public void deleteAllFileInFolder(String folderName) {
	try {
		String pathFolderDownload = GlobalConstants.REPORTNG_IMAGE_PATH;
		File file = new File(pathFolderDownload);
		File[] listOfFiles = file.listFiles();
		if (listOfFiles.length != 0) {
			for (int i = 0; i < listOfFiles.length; i++) {
				if (listOfFiles[i].isFile() && !listOfFiles[i].getName().equals("environment.properties")) {
					new File(listOfFiles[i].toString()).delete();
				}
			}
		}
	} catch (Exception e) {
		System.out.print(e.getMessage());
	}
}



}



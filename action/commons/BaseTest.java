package commons;

import java.time.Duration;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class BaseTest {
/// chứa những hàm dùng chung cho cả layer testcase
	private WebDriver driver;

	protected WebDriver getBrowserDriver(String browserName) {
       BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());
		switch (browserList) {
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
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		return driver;
        
	}
	
	protected String getEmailAddress() {
		Random rand = new Random();
		return "john" + rand.nextInt(9999) + "@gmail.com";
	}
	
	protected void quitsBrowserDriver() {
		if (driver != null) {
			driver.quit();	
		}
	}
	
	
	
}

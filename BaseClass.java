package week6.day3;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public RemoteWebDriver driver;
	public String fileName;
	
	@DataProvider
	public String[][] testData() throws IOException {
		String[][] array = ReadExcelData.readExcel(fileName);
		return array;
	}
	
	@Parameters({"browser","URL"})
	@BeforeMethod
	public void launchBrowser(String browser, String URL) {
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}else if(browser.equals("firefox")) {
			FirefoxOptions options = new FirefoxOptions();
			options.setBinary("E:\\Mozilla Firefox\\firefox.exe");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver(options);
			driver.manage().window().maximize();
		}
		
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}
	
}

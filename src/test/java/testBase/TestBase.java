package testBase;

import java.util.HashMap;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import actions.TestDataExcelRead;

public class TestBase {
	final static Logger logger = LoggerFactory.getLogger(TestBase.class);
	public static WebDriver driver;
	public static HashMap<String, HashMap<String, HashMap<String, String>>> sheetMap = new HashMap<String, HashMap<String, HashMap<String, String>>>();

	public static void intializeTestData() {
		try {
			sheetMap = TestDataExcelRead.initializeTestData();
		} catch (Exception ex) {
			ex.printStackTrace();

		}
	}

	public void intialize() {
		setBrowser();
		launchUrl();
	}

	public static void setBrowser() {
		private static String OS = System.getProperty("os.name").toLowerCase();
		String browser = sheetMap.get("LoginDetails").get("user").get("browser");
		logger.info("Selected Browser name " + browser);

		switch (browser) {
		case "chrome":
			if (isWindows()) {
				System.setProperty("webdriver.chrome.driver", "c:\\windrivers\\chromedriver.exe");
	        } else if (isMac()) {
	        	System.setProperty("webdriver.chrome.driver", "c:\\macdrivers\\chromedriver.exe");
	        } 
			

			ChromeOptions chromeOption = new ChromeOptions();
			driver = new ChromeDriver(chromeOption);
			break;
		case "firefox":
			if (isWindows()) {
				System.setProperty("webdriver.gecko.driver", "c:\\windrivers\\GeckoDriver.exe");
	        } else if (isMac()) {
	        	System.setProperty("webdriver.gecko.driver", "c:\\macdrivers\\GeckoDriver.exe");
	        } 
			
			DesiredCapabilities capabilities = DesiredCapabilities.firefox();
			capabilities.setCapability("marionette", true);
			driver = new FirefoxDriver(capabilities);
			break;
		case "ie":
			System.setProperty("webdriver.ie.driver", "c:\\drivers\\IEDriverServer.exe");
			DesiredCapabilities capability = DesiredCapabilities.internetExplorer();

			driver = new InternetExplorerDriver(capability);
			break;

		}

		driver.manage().deleteAllCookies();

	}
	    
	    private static boolean isWindows() {
	        return (OS.indexOf("win") >= 0);
	    }

	    private static boolean isMac() {
	        return (OS.indexOf("mac") >= 0);
	    }


	public void closeBrowser() {
		driver.close();
		driver.quit();

	}

	public static void launchUrl() {

		String url = sheetMap.get("LoginDetails").get("user").get("url");
		driver.get(url);
		logger.info("Launching application URL : " + sheetMap.get("LoginDetails").get("user").get("url"));

		driver.manage().window().maximize();
		logger.info("Browser Window Maximized");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);

	}

}
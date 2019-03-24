package actions;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cucumber.listener.Reporter;
import com.google.common.base.Function;

import testBase.TestBase;

public class ActionLib extends TestBase {
	private final static Logger logger = LoggerFactory.getLogger(ActionLib.class);
	private static JavascriptExecutor js;
	static String pageLoadStatus = null;

	public boolean isElementPresent(By element) {

		boolean flag = false;
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOfElementLocated(element));
			flag = true;

		} catch (ElementNotVisibleException ex) {
			flag = false;
		} catch (Exception ex) {
			flag = false;
		}
		return flag;
	}

	public void isElementClickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 180);
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}

	public void waitForElementToBePresent(By element) {
		WebDriverWait wait = new WebDriverWait(driver, 180);
		wait.until(ExpectedConditions.presenceOfElementLocated(element));

	}

	public boolean isElementNotPresent(By element) {
		boolean notPresentFlag = ExpectedConditions.not(ExpectedConditions.presenceOfElementLocated(element))
				.apply(driver);
		return notPresentFlag;

	}

	public void highlightElement(WebElement element) {
		try {
			for (int i = 0; i < 1; i++) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element,
						"color: red; border: 2px solid red;");
				js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "");
				Thread.sleep(1000);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void waitForBusyWindowNotPresent() {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		wait.pollingEvery(50, TimeUnit.MILLISECONDS);
		wait.withTimeout(120, TimeUnit.SECONDS);
		Function<WebDriver, Boolean> predicate = new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver arg) {
				driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
				try {
					driver.findElement(By.xpath("//i[contains(@class,'spinner')]"));

					return false;
				} catch (Exception e) {

					return true;
				} finally {
					driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
				}
			}

		};

		wait.until(predicate);
	}

	public void waitForPageToLoad() {
		do {
			js = (JavascriptExecutor) driver;
			pageLoadStatus = (String) js.executeScript("return document.readyState");

		} while (!pageLoadStatus.equals("complete"));
		logger.info("Page has loaded successfully");
	}

}

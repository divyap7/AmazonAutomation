package pages;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cucumber.listener.Reporter;

import actions.ActionLib;
import actions.ExtentReporterClass;
import cucumber.api.DataTable;

public class SearchPage extends ActionLib {
	final static Logger logger = LoggerFactory.getLogger(SearchPage.class);
	ExtentReporterClass objExtentReports = new ExtentReporterClass();

	public SearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='twotabsearchtextbox']")
	WebElement enterSearch;

	@FindBy(xpath = "//input[@value='Go']")
	WebElement clickAndGo;

	public void navigateToHomePage() {
		try {

			waitForPageToLoad();
			logger.info("Navigating to search recording page");
			Assert.assertTrue("Validating navigation to Amazon home page",
					driver.getCurrentUrl().equals("https://www.amazon.com/"));
			logger.info("Navigated to home page");
			// capture screenshot
			objExtentReports.reportStep("Home Page", "PASS");

		} catch (Exception ex) {

			logger.error("Exception occured while navigating to navigateToHomePage  due to :  " + ex.getMessage());
			Assert.fail("Exception occured while navigating to navigateToHomePage due to :  " + ex.getMessage());
		}

	}

	public void selectFromDropDown(DataTable input) {
		try {
			// read the data from sheet
			List<Map<String, String>> data = input.asMaps(String.class, String.class);
			String nameOfCategory = sheetMap.get("Search").get(data.get(0).get("TestScenarioName")).get("category");
			// To check if the string is not empty
			Assert.assertNotNull("Fetched category", nameOfCategory);
			// selecting category from dropdown
			Select category = new Select(driver.findElement(By.id("searchDropdownBox")));
			category.selectByVisibleText(nameOfCategory);
			logger.info("Selected category " + nameOfCategory);

		} catch (Exception ex) {
			logger.error("Exception occured while navigating to selectFromDropDown  due to :  " + ex.getMessage());
			Assert.fail("Exception occured while navigating to selectFromDropDown due to :  " + ex.getMessage());
		}
	}

	public void enterSearch(DataTable input) {
		try {
			// read the data from sheet
			List<Map<String, String>> data = input.asMaps(String.class, String.class);
			String item = sheetMap.get("Search").get(data.get(0).get("TestScenarioName")).get("item");
			// To check if the string is not empty
			Assert.assertNotNull("Fetched category", item);
			// wait until the element is present
			waitForElementToBePresent(By.xpath("//input[@id='twotabsearchtextbox']"));

			enterSearch.clear();
			enterSearch.click();
			logger.info("Clicked on search text box");
			// Types the item to search in text box
			enterSearch.sendKeys(item);
			logger.info("Item to be searched :" + item);
			// Capture screenshot
			objExtentReports.reportStep("Before Search", "PASS");

		} catch (Exception ex) {
			logger.error("Exception occured while navigating to enterSearch  due to :  " + ex.getMessage());
			Assert.fail("Exception occured while navigating to enterSearch due to :  " + ex.getMessage());
		}
	}

	public void selectFromSuggestions(DataTable input) {
		try {
			List<Map<String, String>> data = input.asMaps(String.class, String.class);
			// Calling the method to enter item name in search textbox
			this.enterSearch(input);

			waitForElementToBePresent(By.xpath("//div[@id='suggestions']//div"));
			// fetch the count for list of suggestions displayed
			int noOfSuggestions = driver.findElements(By.xpath("//div[@id='suggestions']//div")).size();

			String searchedItem = sheetMap.get("Search").get(data.get(0).get("TestScenarioName")).get("item");
			// To check if the string is not empty
			Assert.assertNotNull("Fetched category", searchedItem);
			// Iterates through the list and clicks the one that matched with the input
			for (int i = 0; i <= noOfSuggestions; i++) {
				String itemInSuggestions = driver
						.findElement(By.xpath("//div[@id='suggestions']//div[@id='issDiv" + i + "']"))
						.getAttribute("data-keyword");
				// To check if the string is not empty
				Assert.assertNotNull("Fetched category", itemInSuggestions);
				if (itemInSuggestions.equalsIgnoreCase(searchedItem)) {
					driver.findElement(By.xpath("//div[@id='suggestions']//div[@id='issDiv" + i + "']")).click();
					logger.info("Selected: " + itemInSuggestions);
					break;
				} else {
					continue;
				}
			}

		} catch (Exception ex) {
			logger.error("Exception occured while navigating to selectFromSuggestions  due to :  " + ex.getMessage());
			Assert.fail("Exception occured while navigating to selectFromSuggestions due to :  " + ex.getMessage());
		}
	}

	public void clickOnSearch(DataTable input) {
		try {
			List<Map<String, String>> data = input.asMaps(String.class, String.class);
			String itemSearched = sheetMap.get("Search").get(data.get(0).get("TestScenarioName")).get("item");
			// To check if the string is not empty
			Assert.assertNotNull("Fetched category", itemSearched);
			waitForElementToBePresent(By.xpath("//input[@value='Go']"));

			clickAndGo.click();
			logger.info("Clicked on search");
			//fetch the name of the item that is displayed
			String itemDisplayed = driver.findElement(By.xpath("(//div[@id='search']//div//span)[3]")).getText()
					.replaceAll("\"", "");
			// To check if the results are based on search
			Assert.assertTrue("Results are based on search", StringUtils.containsIgnoreCase(itemSearched, itemDisplayed));

		} catch (Exception ex) {
			logger.error("Exception occured while navigating to clickOnSearch  due to :  " + ex.getMessage());
			Assert.fail("Exception occured while navigating to clickOnSearch due to :  " + ex.getMessage());
		}
	}

	public void fetchResults(DataTable input) {
		try {

			List<Map<String, String>> data = input.asMaps(String.class, String.class);
			ArrayList<String> authorNames = new ArrayList<String>();
			
			// Gets the number of the result for whic the informations has to be extracted
			String bookToPick = sheetMap.get("Search").get(data.get(0).get("TestScenarioName")).get("booktopick");

			// fetch name of the book

			String nameOfTheBook = driver.findElement(By.xpath("//div[@data-index='" + bookToPick
					+ "']//div[@class='sg-row']//h5/a[contains(@class,'text-normal')]/span")).getText();
			this.writeDataToExcel(1, 0, nameOfTheBook);
			
			// fetch its authors

			int noOfAuthors = driver.findElements(By.xpath("//div[@data-index='" + bookToPick
					+ "']//div[@class='sg-row']//span[contains(text(),'by')]//following-sibling::a")).size();

			for (int i = 1; i <= noOfAuthors; i++) {
				String author = driver.findElement(By.xpath("(//div[@data-index='" + bookToPick
						+ "']//div[@class='sg-row']//span[contains(text(),'by')]//following-sibling::a)[" + i + "]"))
						.getText();
				authorNames.add(author);
			}
			// Store the data in excel
			this.writeDataToExcel(1, 1, authorNames.toString());

			// fetch its type and price
			int types = driver.findElements(By.xpath(
					"//div[@data-index='" + bookToPick + "']//div[@class='sg-row']//a[contains(@class,'text-bold')]"))
					.size();
			// in case of multiple types , iterate and fetch all the details
			for (int i = 1; i <= types; i++) {
				String type = driver.findElement(By.xpath("(//div[@data-index='" + bookToPick
						+ "']//div[@class='sg-row']//a[contains(@class,'text-bold')])[" + i + "]")).getText();
				String price = driver.findElement(By.xpath("(//div[@data-index='" + bookToPick
						+ "']//div[@class='sg-row']//span[@class='a-price' and @data-a-size='l']//span[@class='a-price-whole'])["
						+ i + "]")).getText();
				String fraction = driver.findElement(By.xpath("(//div[@data-index='" + bookToPick
						+ "']//div[@class='sg-row']//span[@class='a-price' and @data-a-size='l']//span[@class='a-price-fraction'])["
						+ i + "]")).getText();
				String wholePrice = price + "." + fraction;
				this.writeDataToExcel(i, 2, type);
				this.writeDataToExcel(i, 3, wholePrice);
			}
			//capture screenshot
			objExtentReports.reportStep("After search", "PASS");

		} catch (Exception ex) {
			logger.error("Exception occured while navigating to fetchResults  due to :  " + ex.getMessage());
			Assert.fail("Exception occured while navigating to fetchResults due to :  " + ex.getMessage());
		}
	}

	public void writeDataToExcel(int rowcount, int columncount, String value) {
		try {
			FileInputStream input = new FileInputStream("DataCatalogInformation.xlsx");
			XSSFWorkbook workBook = new XSSFWorkbook(input);
			XSSFSheet sheet = workBook.getSheet("DataCatalog");
			XSSFRow row = sheet.getRow(rowcount);
			FileOutputStream storeResult = new FileOutputStream("DataCatalogInformation.xlsx");
			row.createCell(columncount).setCellValue(value);
			workBook.write(storeResult);

		} catch (Exception ex) {
			logger.error("Exception occured while navigating to writeDataFromExcel  due to :  " + ex.getMessage());
			Assert.fail("Exception occured while navigating to writeDataFromExcel due to :  " + ex.getMessage());
		}
	}

}

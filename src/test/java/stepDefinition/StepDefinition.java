package stepDefinition;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cucumber.listener.Reporter;
import org.openqa.selenium.WebDriver;

import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import managers.PageObjectManager;

import pages.SearchPage;
import testBase.TestBase;

public class StepDefinition extends TestBase {

	SearchPage objSearchPage;

	PageObjectManager pageObjectManager = new PageObjectManager();
	final static Logger logger = LoggerFactory.getLogger(StepDefinition.class);
	TestBase objtestbase = new TestBase();

	@Before
	public void intializeTest() {
		objtestbase.intialize();
	}

	@After
	public void closeAllBrowser(Scenario scenario) throws IOException {
		try {

			if (scenario.isFailed()) {
				logger.info(scenario.getName() + "is Failed");
				final byte[] screenshot = ((TakesScreenshot) TestBase.driver).getScreenshotAs(OutputType.BYTES);
				scenario.embed(screenshot, "image/png");
			}

			scenario.write("Current Page URL is " + TestBase.driver.getCurrentUrl());

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		objtestbase.closeBrowser();

	}

	@Given("^User has launched the application$")
	public void user_has_launched_the_application() throws Throwable {
		objSearchPage = pageObjectManager.getSearchPage();

	}

	@Then("^Validate the user has navigated to home page$")
	public void validate_the_user_has_navigated_to_home_page() throws Throwable {
		objSearchPage.navigateToHomePage();
	}

	@Then("^Select the category from dropdown$")
	public void select_the_category_from_dropdown(DataTable arg1) throws Throwable {
		objSearchPage.selectFromDropDown(arg1);
	}

	@Then("^Enter item to search in text box$")
	public void enter_item_to_search_in_text_box(DataTable arg1) throws Throwable {
		objSearchPage.enterSearch(arg1);
	}

	@Then("^Click on search$")
	public void click_on_search() throws Throwable {

	}

	@Then("^Validate the search results$")
	public void validate_the_search_results(DataTable arg1) throws Throwable {
		objSearchPage.clickOnSearch(arg1);
	}

	@Then("^Fetch and store the results$")
	public void fetch_and_store_the_results(DataTable arg1) throws Throwable {
		objSearchPage.fetchResults(arg1);
	}
	
	@Then("^Select item from suggestions$")
	public void select_item_from_suggestions(DataTable arg1) throws Throwable {
	    objSearchPage.selectFromSuggestions(arg1);
	}

	
}

package junitCucumber;


import java.io.File;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cucumber.listener.ExtentProperties;
import com.cucumber.listener.Reporter;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import testBase.TestBase;


@RunWith(Cucumber.class)
@CucumberOptions(
        dryRun = false,
        strict = true,
        features = "src/test/resources/testFeature",
        glue = "stepDefinition",
       
       tags ={"@SearchItem"},
        monochrome = false,
        plugin = {
        		"com.cucumber.listener.ExtentCucumberFormatter:output/report.html",
                "pretty",
                "html:target/cucumber",
                "json:results/cucumber.json",
                "junit:results/cucumber.xml"
        }
)

public class RunCucumberTest {
	final static Logger logger = LoggerFactory.getLogger(RunCucumberTest.class);
	
	@AfterClass
    public static void teardown() {
        Reporter.loadXMLConfig(new File("src/test/resources/resources/extent-config.xml"));
        Reporter.setSystemInfo("user", System.getProperty("user.name")+" : Divya");   
        logger.info("Test automation run");
    }
	
	
	@BeforeClass
	public static void setup() {
	    ExtentProperties extentProperties = ExtentProperties.INSTANCE;
	    extentProperties.setReportPath("output/myreport.html");
	    try {
			TestBase.intializeTestData();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
package actions;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.cucumber.listener.Reporter;
import testBase.TestBase;

public class ExtentReporterClass extends TestBase {
	public ExtentTest test;
	ExtentReports extent = new ExtentReports();
	ExtentHtmlReporter htmlreporter;

	
	public void reportStep(String desc, String status, boolean bSnap) throws IOException {

		if(bSnap && !status.equalsIgnoreCase("INFO")){
			long snapNumber = 100000l;
			
			try {
				snapNumber= takeSnap();
			File f=new File("target\\cucumber-reports\\images\\"+snapNumber+".png");
			
			Reporter.addScreenCaptureFromPath(f.getAbsolutePath(), "Login");
			
			} catch (Exception e) {
				e.printStackTrace();
			}
	
		}
	
	}
	
	public void reportStep(String desc, String status) throws IOException {
		reportStep(desc, status, true);
	}

	public long takeSnap(){
		long number = (long) Math.floor(Math.random() * 900000000L) + 10000000L; 
		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
		    File source = ts.getScreenshotAs(OutputType.FILE);
		    FileUtils.copyFile(source, new File("target\\cucumber-reports\\images\\"+number+".png"));
		} catch (WebDriverException e) {
			System.out.println("The browser has been closed.");
		} catch (IOException e) {
			System.out.println("The snapshot could not be taken");
		}
		return number;
	}

	public void endResult(){		
		extent.flush();
	}

	

	
}
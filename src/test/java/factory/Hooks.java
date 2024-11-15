package factory;

import java.io.ByteArrayInputStream;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;

import io.qameta.allure.Allure;

public class Hooks extends BaseClass{
	
	@BeforeMethod
	@Parameters ("browser")
	public void setup(String browser) throws Throwable
	{
		BaseClass.initializeBrowser(browser);
		
   	}
	
	@AfterMethod
	public void tearDown(ITestResult itestResult) 
	{
		if (itestResult.getStatus()==ITestResult.FAILURE) {
		Allure.addAttachment("Screenshot", new ByteArrayInputStream(((TakesScreenshot) BaseClass.getDriver()).getScreenshotAs(OutputType.BYTES)));
		}
		BaseClass.getDriver().quit();
    	
	} 
	
	
	
	

}
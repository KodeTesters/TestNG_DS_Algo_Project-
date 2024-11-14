package testCases;

import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import factory.BaseClass;
import factory.Hooks;
import pageObject.GetStartedPage;
import pageObject.HomePage;

public class GetStartedPageTest extends Hooks{
	


	Logger logger = BaseClass.getLogger();

	//changes
	@Test (priority=1, groups={"smoke","regression"})
	public void TestGetStartedButton()  {
		logger.info("Clicking the GetStarted Button.............");
		GetStartedPage sp = new GetStartedPage(BaseClass.getDriver());
		HomePage hp = new HomePage(BaseClass.getDriver());
		sp.clickGetStartedSP();
		boolean status = hp.NumpyNinjaLinkDisplay();
		Assert.assertEquals(status, true ,"Home page is not displayed");	
		logger.info("Home page is displayed");
		}
	 
	
	@Test(priority=2, groups="smoke")
	public void CopyrightNumpyNinja2021Display(){
		GetStartedPage sp = new GetStartedPage(BaseClass.getDriver());
		logger.info("Check the display of Copyright@NumpyNinja2021............");
		sp = new GetStartedPage(BaseClass.getDriver());
		boolean status = sp.copyrightDisplay();
		Assert.assertTrue(status); 
		logger.info("Copyright@NumpyNinja2021 is displayed");
	}

}
package testCases;

import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import factory.BaseClass;
import factory.Hooks;
import pageObject.DataStructurePage;
import pageObject.HomePage;
import pageObject.LinkedListPage;
import pageObject.SignInPage;
import pageObject.StackPage;

public class StackPageTests extends Hooks{
Logger logger=BaseClass.getLogger();
	
	public void checkValidAndInvalidLoginTest(String user, String pwd) {
		SignInPage sp= new SignInPage(BaseClass.getDriver());
		logger.info("Enter the username at login page.............");
		 sp.enterUsername(user);
		 sp.enterpassword(pwd);
		 sp.clickLogin();
		 
	}
	
	@Test(priority=0,groups="regression")
	public void check_StackHomePage()
	{
		HomePage Hp = new HomePage(BaseClass.getDriver());	
			Hp.Login_HomePage();
		StackPage stp=new StackPage(BaseClass.getDriver());
		stp.click_StGetStarted();
		 boolean status = stp.check_StHomePage();
		 Assert.assertEquals(status, true);
		 logger.info("HomePage is displayed");
			 
	
	}
	
	@Test(priority=1,groups="regression")
	public void check_StackOperationspage()
	{
		HomePage Hp = new HomePage(BaseClass.getDriver());
		Hp.Login_HomePage();
		StackPage stp=new StackPage(BaseClass.getDriver());
		stp.click_StGetStarted();
		stp.click_Operations();
		 boolean status=stp.check_StOperationsPage();
		 Assert.assertEquals(status, true);
		 logger.info("Stack operations page is displayed.......");
		
	}
		
	@Test(priority=2,groups="regression")
	public void check_OperationsTryHereBtn()
	{
		HomePage Hp = new HomePage(BaseClass.getDriver());
		Hp.Login_HomePage();
		 StackPage stp=new StackPage(BaseClass.getDriver());
		 stp.click_StGetStarted();
		 stp.click_Operations();
		 stp.click_TryHereBtn();
		 logger.info("Tryhere button is clicked...........");
		 LinkedListPage lp=new LinkedListPage(BaseClass.getDriver());
		 boolean status=lp.check_TryEditorPage();
		 Assert.assertEquals(status, true);
		 logger.info("python editor page is displayed..........");
	}
	
	@Test(priority=3,groups="regression")
	public void check_OperationsPythonEditorValidInput()
	{

		 HomePage Hp = new HomePage(BaseClass.getDriver());
		 Hp.Login_HomePage();

		 StackPage stp=new StackPage(BaseClass.getDriver());
		 stp.click_StGetStarted();
		 stp.click_Operations();
		 stp.click_TryHereBtn();
		 logger.info("Tryhere button is clicked...........");
		  logger.info("Entering valid python code..........");
		  DataStructurePage ds = new DataStructurePage(BaseClass.getDriver());	  		  
		  ds.Click_DS_PythonEditor_Runbtn_ValidCodes();
		  ds.click_DS_PythonEditor_RunBtn();  
		  ds.validate_Console_Output();        
		  logger.info("Console output.......     " +ds.ConsoleOutput_text+ ds.PYEditor_Code);
		  Assert.assertEquals(true,ds.PYEditor_Code.contains(ds.ConsoleOutput_text) );

	}
	
	 @Test(priority=4,groups="regression")
	 public void check_OperationsPythonEditorInvalidInput()
	 {

		     HomePage Hp = new HomePage(BaseClass.getDriver());
			 Hp.Login_HomePage();

			 StackPage stp=new StackPage(BaseClass.getDriver());
			 stp.click_StGetStarted();
		     stp.click_Operations();
			 stp.click_TryHereBtn();
			 logger.info("Tryhere button is clicked...........");
			 logger.info("User Entering invalid pythod code on the editor ..... ");
			 DataStructurePage ds = new DataStructurePage(BaseClass.getDriver());  
			 ds.Click_DS_PythonEditor_Runbtn_InValidCodes();
			 ds.Validate_OutputConsole_InvalidCodes();
			 logger.info("Alert Message in Python Editor " + ds.Alertmesg);		
		     Assert.assertEquals(true, ds.Alertmesg.contains("bad input on line 1"));
	        
	 }
	 
	 @Test(priority=5,groups="regression")
	 public void check_OperationsPythonEditorNoInput()
	 {
		 HomePage Hp = new HomePage(BaseClass.getDriver());

		 Hp.Login_HomePage();
		 StackPage stp=new StackPage(BaseClass.getDriver());
		 stp.click_StGetStarted();

		 stp.click_Operations();
		 stp.click_TryHereBtn();
		 logger.info("Tryhere button is clicked...........");
		 DataStructurePage ds = new DataStructurePage(BaseClass.getDriver());	  		  
		 ds.Click_DS_PythonEditor_Runbtn_WithoutCodes();
		 String crntURL = BaseClass.getDriver().getCurrentUrl();
		 Assert.assertEquals(true, crntURL.contains("tryEditor"));
	
	 }
	
	
	@Test(priority=6,groups="regression")
	public void check_StackImplementationspage()
	{
		HomePage Hp = new HomePage(BaseClass.getDriver());
		Hp.Login_HomePage();
		 StackPage stp=new StackPage(BaseClass.getDriver());
		 stp.click_StGetStarted();
		 stp.click_Implementations();
		 boolean status=stp.check_StImplementationsPage();
		 Assert.assertEquals(status, true);
		 logger.info("Stack implementation page is displayed.......");
		
	}
	
	@Test(priority=7,groups="regression")
	public void check_ImplementationTryHereBtn()
	{

		 HomePage Hp = new HomePage(BaseClass.getDriver());
		 Hp.Login_HomePage();

		 StackPage stp=new StackPage(BaseClass.getDriver());
		 stp.click_StGetStarted();
		 stp.click_Implementations();
		 stp.click_TryHereBtn();
		 logger.info("Tryhere button is clicked...........");
		 LinkedListPage lp=new LinkedListPage(BaseClass.getDriver());
		 boolean status=lp.check_TryEditorPage();
		 Assert.assertEquals(status, true);
		 logger.info("python editor page is displayed..........");
	}
	
	@Test(priority=8,groups="regression")
	public void check_ImplementationsPythonEditorValidInput()
	{

		 HomePage Hp = new HomePage(BaseClass.getDriver());
		 Hp.Login_HomePage();

		 StackPage stp=new StackPage(BaseClass.getDriver());
		 stp.click_StGetStarted();
		 stp.click_Implementations();
		 stp.click_TryHereBtn();
		 logger.info("Tryhere button is clicked...........");
		  logger.info("Entering valid python code..........");
		  DataStructurePage ds = new DataStructurePage(BaseClass.getDriver());	  		  
		  ds.Click_DS_PythonEditor_Runbtn_ValidCodes();
		  ds.click_DS_PythonEditor_RunBtn();  
		  ds.validate_Console_Output();        
		  logger.info("Console output.......     " +ds.ConsoleOutput_text+ ds.PYEditor_Code);
		  Assert.assertEquals(true,ds.PYEditor_Code.contains(ds.ConsoleOutput_text) );

	}
	
	 @Test(priority=9,groups="regression")
	 public void check_ImplementationsPythonEditorInvalidInput()
	 {

		     HomePage Hp = new HomePage(BaseClass.getDriver());
			 Hp.Login_HomePage();

			 StackPage stp=new StackPage(BaseClass.getDriver());
			 stp.click_StGetStarted();
			 stp.click_Implementations();
			 stp.click_TryHereBtn();
			 logger.info("Tryhere button is clicked...........");
			 logger.info("User Entering invalid pythod code on the editor ..... ");
			 DataStructurePage ds = new DataStructurePage(BaseClass.getDriver());  
			 ds.Click_DS_PythonEditor_Runbtn_InValidCodes();
			 ds.Validate_OutputConsole_InvalidCodes();
			 logger.info("Alert Message in Python Editor " + ds.Alertmesg);		
		     Assert.assertEquals(true, ds.Alertmesg.contains("bad input on line 1"));
	        
	 }
	 
	 @Test(priority=10,groups="regression")
	 public void check_ImplementationsPythonEditorNoInput()
	 {
		 HomePage Hp = new HomePage(BaseClass.getDriver());

		 Hp.Login_HomePage();
		 StackPage stp=new StackPage(BaseClass.getDriver());
		 stp.click_StGetStarted();
		 stp.click_Implementations();
		 stp.click_TryHereBtn();
		 logger.info("Tryhere button is clicked...........");
		 DataStructurePage ds = new DataStructurePage(BaseClass.getDriver());	  		  
		 ds.Click_DS_PythonEditor_Runbtn_WithoutCodes();
		 String crntURL = BaseClass.getDriver().getCurrentUrl();
		 Assert.assertEquals(true, crntURL.contains("tryEditor"));
	
	 }
	
	
	@Test(priority=11,groups="regression")
	public void check_StackApplicationspage()
	{
		HomePage Hp = new HomePage(BaseClass.getDriver());		

		Hp.Login_HomePage();		

		 StackPage stp=new StackPage(BaseClass.getDriver());
		 stp.click_StGetStarted();
		 stp.click_Applications();
		 boolean status=stp.check_StApplicationsPage();
		 Assert.assertEquals(status, true);
		 logger.info("Stack application page is displayed.......");
		
	}
	
	@Test(priority=12,groups="regression")
	public void check_ApplicationTryHereBtn()
	{

		 HomePage Hp = new HomePage(BaseClass.getDriver());		
		 Hp.Login_HomePage();		

		 StackPage stp=new StackPage(BaseClass.getDriver());
		 stp.click_StGetStarted();
		 stp.click_Applications();
		 stp.click_TryHereBtn();
		 logger.info("Tryhere button is clicked...........");
		 LinkedListPage lp=new LinkedListPage(BaseClass.getDriver());
		 boolean status=lp.check_TryEditorPage();
		 Assert.assertEquals(status, true);
		 logger.info("python editor page is displayed..........");
	}
	
	@Test(priority=13,groups="regression")
	public void check_ApplicationsPythonEditorValidInput()
	{

		 HomePage Hp = new HomePage(BaseClass.getDriver());
		 Hp.Login_HomePage();

		 StackPage stp=new StackPage(BaseClass.getDriver());
		 stp.click_StGetStarted();
		 stp.click_Applications();
		 stp.click_TryHereBtn();
		 logger.info("Tryhere button is clicked...........");
		  logger.info("Entering valid python code..........");
		  DataStructurePage ds = new DataStructurePage(BaseClass.getDriver());	  		  
		  ds.Click_DS_PythonEditor_Runbtn_ValidCodes();
		  ds.click_DS_PythonEditor_RunBtn();  
		  ds.validate_Console_Output();        
		  logger.info("Console output.......     " +ds.ConsoleOutput_text+ ds.PYEditor_Code);
		  Assert.assertEquals(true,ds.PYEditor_Code.contains(ds.ConsoleOutput_text) );

	}
	
	 @Test(priority=14,groups="regression")
	 public void check_ApplicationsPythonEditorInvalidInput()
	 {

		     HomePage Hp = new HomePage(BaseClass.getDriver());
			 Hp.Login_HomePage();

			 StackPage stp=new StackPage(BaseClass.getDriver());
			 stp.click_StGetStarted();
			 stp.click_Applications();
			 stp.click_TryHereBtn();
			 logger.info("Tryhere button is clicked...........");
			 logger.info("User Entering invalid pythod code on the editor ..... ");
			 DataStructurePage ds = new DataStructurePage(BaseClass.getDriver());  
			 ds.Click_DS_PythonEditor_Runbtn_InValidCodes();
			 ds.Validate_OutputConsole_InvalidCodes();
			 logger.info("Alert Message in Python Editor " + ds.Alertmesg);		
		     Assert.assertEquals(true, ds.Alertmesg.contains("bad input on line 1"));
	        
	 }
	 
	 @Test(priority=15,groups="regression")
	 public void check_ApplicationsPythonEditorNoInput()
	 {
		 HomePage Hp = new HomePage(BaseClass.getDriver());

		 Hp.Login_HomePage();
		 StackPage stp=new StackPage(BaseClass.getDriver());
		 stp.click_StGetStarted();
		 stp.click_Applications();
		 stp.click_TryHereBtn();
		 logger.info("Tryhere button is clicked...........");
		 DataStructurePage ds = new DataStructurePage(BaseClass.getDriver());	  		  
		 ds.Click_DS_PythonEditor_Runbtn_WithoutCodes();
		 String crntURL = BaseClass.getDriver().getCurrentUrl();
		 Assert.assertEquals(true, crntURL.contains("tryEditor"));
	
	 }
	
	
	
		 @Test(priority=16,groups="regression")
	 public void check_StPracticeQns()
	 {

		 HomePage Hp = new HomePage(BaseClass.getDriver());
			
				Hp.Login_HomePage();
			
			StackPage stp=new StackPage(BaseClass.getDriver());
			stp.click_StGetStarted();
			stp.click_Operations();
		 stp.click_StPracticeQns();
		boolean status=stp.check_StPracticeQnsPage();
		Assert.assertEquals(status, true);
		logger.info("redirected to practice qn page............");
			
		 

	 }
}


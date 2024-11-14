package testCases;

import java.io.IOException;

import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import factory.BaseClass;
import factory.Hooks;
import pageObject.GetStartedPage;
import pageObject.HomePage;
import pageObject.RegisterPage;
//import pageObject.RegisterPage;
import pageObject.SignInPage;
import utilities.DataProviders;

public class SignInPagetest extends Hooks{

	Logger logger = BaseClass.getLogger();		

	@Test (dataProvider="LoginData", dataProviderClass=DataProviders.class, priority=1, groups="regression")
	public void checkValidAndInvalidLoginTest(String user, String pwd, String result ) {
		 logger.info("Enter the login details and click Login at login page using DDT.............");
	     GetStartedPage gsp = new GetStartedPage(BaseClass.getDriver());
		 gsp.clickGetStartedSP();
	     HomePage hp = new HomePage(BaseClass.getDriver());
		 hp.clickSigIn();
		 SignInPage sp = new SignInPage(BaseClass.getDriver());	
		 sp.enterUsername(user);
		 sp.enterpassword(pwd);
		 sp.clickLogin();
		 
	  	 if (result.equalsIgnoreCase("Valid")){
			     boolean display = hp.YouAreLoggedInMsg();
					if (display==true) {
						Assert.assertTrue(true);
						logger.info("Test Passed");
					  }
					else{
						Assert.fail();
						logger.error("Test Failed");
					  }
			    }
			
			if (result.equalsIgnoreCase ("Invalid")){
				boolean display = sp.InvalidUsrNamePwdErrorMsg();
					if (display==true){
						Assert.assertTrue(true);
						logger.info("Test Passed");
					   }
					else {
						Assert.assertTrue(false);
						logger.error("Test Failed");
					   }
		        	}
	   }
	
	

	@Test(dataProvider="EmptyUserOrPwdLoginData", dataProviderClass=DataProviders.class, groups="regression", priority=2)
	public void testLoginWithoutUsername(String user, String pwd) {
		 logger.info("Check display of warning message when we login without username or Password........");
		 GetStartedPage gsp = new GetStartedPage(BaseClass.getDriver());
		 gsp.clickGetStartedSP();
	     HomePage hp = new HomePage(BaseClass.getDriver());
		 hp.clickSigIn();
		 SignInPage sp = new SignInPage(BaseClass.getDriver());	
		 sp.enterUsername(user);
		 sp.enterpassword(pwd);
		 sp.clickLogin();
		 
		 String ExpValidationMsg = "Please fill out this field.";
		 String ActValidationMsg = sp.checkValidationMsgRegisterPg(user, pwd);
		   if (ActValidationMsg.equalsIgnoreCase(ExpValidationMsg)) {
				  Assert.assertTrue(true);
			  }
		   else{
			  Assert.assertTrue(false);
			  System.out.println("The Validation message is not displayed..");
		     }
    	}
	
	
	@Test (priority=3)
	public void checkUsernameDisplayAfterLogin() throws IOException {
		 logger.info("Check username display at home pafe after login...........");
		 HomePage hp = new HomePage(BaseClass.getDriver());
		 hp.Login_HomePage();
		 
		 String NameDisplayed = hp.getUsernameAtLinkHomepage();
			  if(NameDisplayed.equalsIgnoreCase(BaseClass.getProperties().getProperty("username"))) {
					  Assert.assertTrue(true);
					  System.out.println("Username displayed");
				  }
			  else {
				  Assert.assertTrue(false);
				  System.out.println("Username NOT displayed");
			   }		 
		 
	    }
	
	
	@Test (groups={"smoke","regression"},priority=4)
	public void checkMovingToRegisterPageFromLoginPage() throws InterruptedException {
	    logger.info("Check moving to Register Page from Login Page........");
		GetStartedPage gsp = new GetStartedPage(BaseClass.getDriver());
		gsp.clickGetStartedSP();
	    HomePage hp = new HomePage(BaseClass.getDriver());
		hp.clickSigIn();
		SignInPage sp = new SignInPage(BaseClass.getDriver());	
		sp.clickRegister();
		RegisterPage rp = new RegisterPage(BaseClass.getDriver());
		  boolean display = rp.RegisterBtnDisplay();
		  Assert.assertTrue(display);		
	    }
	
	
		 
		
	
				
			
}
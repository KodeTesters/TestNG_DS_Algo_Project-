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
import utilities.DataProviders;
import pageObject.SignInPage;

public class RegisterPageTest extends Hooks {

	
Logger logger = BaseClass.getLogger();
	
@Test (priority =1, groups ={"smoke","regression"})
public void RegisterNewAccount() {
	 logger.info("Register a new user with Valid Details.............");
	 RegisterPage rp = new RegisterPage(BaseClass.getDriver());
	 rp.registerValidNewUser();
	 HomePage hp = new HomePage(BaseClass.getDriver());
	 logger.info("Check 'New Account Created' message at home page....");
	 boolean status = hp.checkNewAccCreatedMsg();
	 Assert.assertTrue(status);
  }


@Test (priority=2)
public void checkUsernameLinkDisplayAtHomePageAfterRegister() {
	logger.info("Verify the Username Link display at Home page after Registering a new user.............");
	RegisterPage rp = new RegisterPage(BaseClass.getDriver());
    HomePage hp = new HomePage(BaseClass.getDriver());
    String RegUser =  rp.registerValidNewUser();
    String NameDisplayed = hp.getUsernameAtLinkHomepage();
	  if(NameDisplayed.equalsIgnoreCase(RegUser)){
				  Assert.assertTrue(true);
			  }
		  else {
			  Assert.assertTrue(false);
		  }		
	    
	}

@Test (priority=3)
public void RegisterNewUserWithExistingPwd() {
	  logger.info("Register a new user with Valid Details.............");
	  GetStartedPage sp = new GetStartedPage(BaseClass.getDriver());
	  sp.clickGetStartedSP();
	  HomePage hp = new HomePage(BaseClass.getDriver());
	  hp.clickRegisterLink();
	  RegisterPage rp = new RegisterPage(BaseClass.getDriver());
	  String user = BaseClass.randomeString();
	  rp.enterUsername(user);
	  try {
		rp.enterPassword(BaseClass.getProperties().getProperty("password"));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  try {
		rp.enterPasswordConfirm(BaseClass.getProperties().getProperty("password"));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  rp.clickRegister();
	  logger.info("Check 'New Account Created' message at home page....");
	  boolean status = hp.checkNewAccCreatedMsg();
	  Assert.assertTrue(status);  
  }

@Test (priority=4, groups="regression")
public void checkMovingToLoginPageFromRegisterPage() {
	  logger.info("Login and move to Register page...."); 
	  GetStartedPage gsp = new GetStartedPage(BaseClass.getDriver());
	  gsp.clickGetStartedSP();
	  HomePage hp = new HomePage(BaseClass.getDriver());
	  hp.clickRegisterLink();
	  logger.info("User clicks the Login link at the bottom of Register page...."); 
	  RegisterPage rp = new RegisterPage(BaseClass.getDriver());
	  rp.clickLoginLinkRP();	
	  SignInPage sp = new SignInPage(BaseClass.getDriver());
	  boolean display = sp.loginBtnDisplay();
	  Assert.assertTrue(display);
  }


@Test (dataProvider="RegisterWithInvalidData", dataProviderClass=DataProviders.class, priority=5, groups={"regression","Register"})
public void checkRegisterWithImproperPassword(String user, String pwd, String pwdConfirm, String ErrMsg) {
	logger.info("Verify the Error message thrown while registering new user with improper username OR passwords............");
	GetStartedPage gsp = new GetStartedPage(BaseClass.getDriver());
	gsp.clickGetStartedSP();
	HomePage hp = new HomePage(BaseClass.getDriver());
	hp.clickRegisterLink();
	RegisterPage rp = new RegisterPage(BaseClass.getDriver());
    rp.enterUsername(user);
    rp.enterPassword(pwd);
	rp.enterPasswordConfirm(pwdConfirm);	
	System.out.println("Register data :"+user+" "+pwd+" "+pwdConfirm);
	rp.clickRegister();
	
	logger.info("Verify the Error message displayed............");
	String ErrorMessage = rp.getTextPwdMismatchErrMsg();
	System.out.println("Displayed Error message is: "+ErrorMessage);
	if (ErrMsg.equalsIgnoreCase("pwdMismatch")) {
		boolean status = rp.pwdMismatchErrMsgDisplay();
		if(status==true) { Assert.assertTrue(true); logger.info("Proper Error Message displayed");}
		else { Assert.assertTrue(false); logger.info("Error Message displayed is INCORRECT...");}
	    }
	if (ErrMsg.equalsIgnoreCase("NotpwdMismatch")) {
		boolean status = rp.pwdMismatchErrMsgDisplay();
		if(status==false) { Assert.assertTrue(true); logger.info("Proper Error Message displayed");}
		else { Assert.assertTrue(false); logger.info("Error Message displayed is INCORRECT...");}
	    }
	
	
 }



}
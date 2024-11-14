package pageObject;
import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import factory.BaseClass;


public class RegisterPage extends BasePage {

	
	public RegisterPage(WebDriver driver) {
		super(driver);
}

	
	//-------------WebElements----------------
		@FindBy(xpath="//input[@id='id_username']")
		private WebElement username;
		
		@FindBy(xpath="//input[@id='id_password1']")
		private WebElement password;
		
		@FindBy(xpath="//input[@id='id_password2']")
		private WebElement passwordConfirm;	
		
		@FindBy(xpath="//input[@value='Register']")
		private WebElement RegisterButton;
		
		@FindBy(xpath="//a[contains(text(),'Login')]")
		private WebElement LoginLinkRP;
		
		@FindBy (xpath="//div[contains(text(),'password_mismatch:The two password fields didn’t match')]")
		private WebElement passwordMismatchErrMsg;
		
		
		//---------------Methods---------------
		public void enterUsername(String user) {
			username.sendKeys(user);
		}
		
		public void enterPassword(String pwd) {
			password.sendKeys(pwd);
		}
		
		public void enterPasswordConfirm(String pwd) {
			passwordConfirm.sendKeys(pwd);
		}
		
		public void clickRegister() {
			RegisterButton.click();
		}
		
		public void clickLoginLinkRP() {
			LoginLinkRP.click();
		}
		
		public boolean pwdMismatchErrMsgDisplay() {
			boolean display = passwordMismatchErrMsg.isDisplayed();
			return display;
		}
		
		public boolean RegisterBtnDisplay() {
			boolean display = RegisterButton.isDisplayed();
			return display;
		}
		
		public String registerValidNewUser() {
			GetStartedPage sp = new GetStartedPage(BaseClass.getDriver());
			sp.clickGetStartedSP();
			HomePage hp = new HomePage(BaseClass.getDriver());
			hp.clickRegisterLink();
			RegisterPage rp = new RegisterPage(BaseClass.getDriver());
		   String user = BaseClass.randomeString();
		   rp.enterUsername(user);
		   String pwd = BaseClass.randomAlphaNumeric();
		   rp.enterPassword(pwd);
		   rp.enterPasswordConfirm(pwd);
		   rp.clickRegister();
		   return user;
		}
		

		public String getTextPwdMismatchErrMsg() {
			String msg = passwordMismatchErrMsg.getText();
			return msg;
		}
		
		public String validationMsgAtUsername() {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			String validationMessage = (String) js.executeScript("return arguments[0].validationMessage;", username);
			return validationMessage;
		}
		
		public String validationMsgAtPassword() {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			String validationMessage = (String) js.executeScript("return arguments[0].validationMessage;", password);
			return validationMessage;
		}
		
		public String validationMsgAtPasswordConfirm() {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			String validationMessage = (String) js.executeScript("return arguments[0].validationMessage;", passwordConfirm);
			return validationMessage;
		}	
		
		public String checkValidationMsgRegisterPg(String user, String pwd, String pwd1) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			String validationMessage = null;
				
			if(user.isEmpty())
				{
				  System.out.println("Case: When username is not given during Register");
				  validationMessage = (String) js.executeScript("return arguments[0].validationMessage;", username);
				 }
			else if (pwd.isEmpty())
				{
				  System.out.println("Case: When password is not given during Register");
				  validationMessage = (String) js.executeScript("return arguments[0].validationMessage;", password);
				 }
			else if (pwd1.isEmpty())
				{
				  System.out.println("Case: When password confirmation is not given during Register");
				  validationMessage = (String) js.executeScript("return arguments[0].validationMessage;", passwordConfirm);
				  }
			return validationMessage;
			
		}
		
		

	}
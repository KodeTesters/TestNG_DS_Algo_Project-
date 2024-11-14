package pageObject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;

public class SignInPage extends BasePage{

	

public SignInPage(WebDriver driver) {
	super(driver);
	}


//--------------WebElements------------

@FindBy(xpath="//input[@id='id_username']")
private WebElement username;

@FindBy(xpath="//input[@id='id_password']")
private WebElement password;

@FindBy(xpath="//input[@value='Login']")
private WebElement LoginButton;

@FindBy(xpath="//a[normalize-space()='Register!']")
private WebElement RegisterLink;
		
@FindBy(xpath="//div[contains(text(),'Invalid Username and Password')]")
private WebElement InvalidUsernameOrPwdErrMsg;


@FindBy (xpath="[@name='csrfmiddlewaretoken']")
private WebElement plsFillTheFieldWarningMsg;


//--------------Methods----------------

public void enterUsername(String userName) {
	username.sendKeys(userName);
}

public void enterpassword(String pwd) {
	password.sendKeys(pwd);
}

public void clickLogin() {
	LoginButton.click();
}

public void clickRegister() {
	RegisterLink.click();
}

public boolean loginBtnDisplay() {
	boolean display = LoginButton.isDisplayed();
	return display;
}

public boolean InvalidUsrNamePwdErrorMsg() {
	boolean display = InvalidUsernameOrPwdErrMsg.isDisplayed();
	return display;
}

public String getWarningMsgText() {
	String warMsg = plsFillTheFieldWarningMsg.getText();
	return warMsg;
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

public String checkValidationMsgRegisterPg(String user, String pwd) {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	String validationMessage = null;
		
	if(user.isEmpty())
		{
		  validationMessage = (String) js.executeScript("return arguments[0].validationMessage;", username);
		 }
	else if (pwd.isEmpty())
		{
		  validationMessage = (String) js.executeScript("return arguments[0].validationMessage;", password);
		 }
	
	return validationMessage;		

}
}


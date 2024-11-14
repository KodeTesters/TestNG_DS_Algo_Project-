package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import factory.BaseClass;


public class StackPage extends BasePage{
	public StackPage(WebDriver driver) {
		super(driver);
		}

	//--------------------Web Elements--------------------------
	
	@FindBy(xpath="//a[@href=\'stack\']")
	private WebElement GetStartedStackBtn;
	
	@FindBy(xpath="//a[@href='operations-in-stack']")
	private WebElement StackOperationsBtn;
	
	@FindBy(xpath="//a[@href='implementation']")
	private WebElement StackImplementationBtn;
	
	@FindBy(xpath="//a[@href='stack-applications']")
	private WebElement StackApplicationBtn;
	
	@FindBy(xpath="//a[@href=\"/stack/practice\"]")
	private WebElement StackPracticeQnsBtn;
	
	@FindBy(xpath="//a[@href='/tryEditor']")
	private WebElement TryHereBtn;
	
	//----------------Variables-------------------
	
	String Stack_Homepage_URL="https://dsportalapp.herokuapp.com/stack/";
	String Stack_Operations_URL="https://dsportalapp.herokuapp.com/stack/operations-in-stack/";
	String Stack_Implementations_URL="https://dsportalapp.herokuapp.com/stack/implementation/";
	String Stack_Applications_URL="https://dsportalapp.herokuapp.com/stack/stack-applications/";
	String Stack_PracticeQns_URL="https://dsportalapp.herokuapp.com/stack/practice";
	
	//--------------Methods-----------------------
	
	public void click_StGetStarted()
	{
		GetStartedStackBtn.click();
	}
	public boolean check_StHomePage() {
		
		String CurrentLL_URL=BaseClass.getDriver().getCurrentUrl();
			 boolean CheckLL_URL = Stack_Homepage_URL.equals(CurrentLL_URL);	
			 return CheckLL_URL;
	}

	public void click_Operations() {
		StackOperationsBtn.click();
	}
	
	public boolean check_StOperationsPage()
	{
		String Current_URL=BaseClass.getDriver().getCurrentUrl();
			 boolean Check_URL = Stack_Operations_URL.equals(Current_URL);	
			 return Check_URL;
	}
	
	public void click_TryHereBtn() {
			TryHereBtn.click();
}
//	public boolean check_TryEditorPage() {
//		String Current_URL=BaseClass.getDriver().getCurrentUrl();
//		 boolean Check_URL = Online_Editor_Console_URL.equals(Current_URL);	
//		 return Check_URL;
//	}
	public void click_Implementations() {
		StackImplementationBtn.click();
	}
	
	public boolean check_StImplementationsPage()
	{
		String Current_URL=BaseClass.getDriver().getCurrentUrl();
			 boolean Check_URL = Stack_Implementations_URL.equals(Current_URL);	
			 return Check_URL;
	}
	
	public void click_Applications() {
		StackApplicationBtn.click();
	}
	
	public boolean check_StApplicationsPage()
	{
		String Current_URL=BaseClass.getDriver().getCurrentUrl();
			 boolean Check_URL = Stack_Applications_URL.equals(Current_URL);	
			 return Check_URL;
	}
	
	public void click_StPracticeQns() {
		StackPracticeQnsBtn.click();
	}
	
	public boolean check_StPracticeQnsPage()
	{
		String Current_URL=BaseClass.getDriver().getCurrentUrl();
			 boolean Check_URL = Stack_PracticeQns_URL.equals(Current_URL);	
			 return Check_URL;
	}
}

package pageObject;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import factory.BaseClass;


public class DataStructurePage extends BasePage  {
	
	public DataStructurePage(WebDriver driver) {
		super(driver);
		
	}


	WebDriver driver;
	public String PYEditor_Code = "'Numpy Ninja'";	
	public String ConsoleOutput_text="";
	public String Alertmesg ="";
		
	
	//-------------WebElements--------------
	
	@FindBy (xpath="//*[text()='Data Structures-Introduction']//following::a[1]")
	private WebElement DS_Introduction_GetStartedBtn;

	@FindBy (xpath="//*[@class='list-group-item']") 
	public WebElement TimeComplexityBtn;
	
	@FindBy(xpath="//*[@class='list-group-item list-group-item-light ']")
	private WebElement DS_TimeComplexity_LeftPanel;
	
	
	@FindBy(linkText="Practice Questions") 
	private WebElement PracticeQuestionsBtn;
	
	
	@FindBy (xpath="//*[@class='btn btn-info']")
	private WebElement TryHereBtn;	
	
	
	@FindBy (xpath = "//*[text()='Run']")
	private WebElement RunBtn;	
	
	@FindBy (xpath="//*[text()='Sign out']")
	private WebElement DS_Intro_SignOut;
	
	
	@FindBy (xpath="//div[@role='alert']")
	public WebElement DS_LogoutMessage;	
	
	@FindBy(xpath="//*[@value='Submit']")
	public WebElement PythonEditor_submit_Btn;
		
	@FindBy(css=".CodeMirror-scroll")
	WebElement TextareaScroll_1;
	
	@FindBy(css="div:nth-child(1) > textarea")
	WebElement Textarea_Type2;
	
	@FindBy(css="button")
	WebElement Textarea_button3;
	
	@FindBy (id = "output")
	WebElement ConsoleOutPut;
	
	//-----------Methods---------
		
	
	public void click_GetStartedBtn_DSIroduction()
	{
		DS_Introduction_GetStartedBtn.click();
	}
	
	public void click_TimeComplexityBtn()
	{
		JavascriptExecutor jse = (JavascriptExecutor)BaseClass.getDriver();
		jse.executeScript("window.scrollBy(0,1000)"); 
		TimeComplexityBtn.click();
	}
	
	public void click_DS_PracticeQuestionsBtn()
	{
		PracticeQuestionsBtn.click();
	}
	
	
	public void click_DS_TimeComplexity_TryhereBtn()
	{
		JavascriptExecutor jse = (JavascriptExecutor)BaseClass.getDriver();
		jse.executeScript("window.scrollBy(0,700)"); 		
		TryHereBtn.click();		
	}
		
	public void click_DS_PythonEditor_RunBtn()
	{		
		Actions action= new Actions(BaseClass.getDriver());
		
		action.moveToElement(RunBtn).click().perform();		
	
	}
	
		
	// Python Editor ->  Without Codes
	public void Click_DS_PythonEditor_Runbtn_WithoutCodes()
	{
		
		   TextareaScroll_1.click();			
	        JavascriptExecutor js=(JavascriptExecutor) BaseClass.getDriver();
	        js.executeScript("window.scrollTo(0,0)");	    
	        Textarea_Type2.sendKeys("");	        
	        Textarea_button3.click();  
	}
	
	
	  // Python Editor -> Entering Valid Codes 
	public void Click_DS_PythonEditor_Runbtn_ValidCodes()		
	
	{	  		
		     TextareaScroll_1.click();			
	        JavascriptExecutor js=(JavascriptExecutor) BaseClass.getDriver();
	        js.executeScript("window.scrollTo(0,0)");	    
	        Textarea_Type2.sendKeys("print "+PYEditor_Code);	        
	        Textarea_button3.click(); 	
	        
	}
	
	
	
	 // Python Editor -> Entering In-Valid Codes 
	public void Click_DS_PythonEditor_Runbtn_InValidCodes()
	{
		
		     TextareaScroll_1.click();			
	        JavascriptExecutor js=(JavascriptExecutor) BaseClass.getDriver();
	        js.executeScript("window.scrollTo(0,0)");	    
	        Textarea_Type2.sendKeys("Print "+PYEditor_Code);	        
	        Textarea_button3.click(); 			 
		
	}
	
	
	// Python Editor -> Console OUTPUT -> For Valid Codes
	
	public void validate_Console_Output()
	{				
		//WebElement result=BaseClass.getDriver().findElement(By.xpath("//*[@id='output']"));		
		
         ConsoleOutput_text=ConsoleOutPut.getText();  
        
	}
	
	// Python Editor -> Invalid Codes Validation (Alert Message)
	public void Validate_OutputConsole_InvalidCodes()
	{
		Alert alert = BaseClass.getDriver().switchTo().alert();		
		Alertmesg = alert.getText();
			
	}
	
	
	public void click_DS_TimeComplexity_LeftPanel()
	{
		DS_TimeComplexity_LeftPanel.click();
	}
	
	// Navigating to the PY_Editor Page
	
	public void DS_Pyhton_Editor_Page()
	{
		click_GetStartedBtn_DSIroduction();
		click_TimeComplexityBtn();
		click_DS_TimeComplexity_TryhereBtn();
	}
	
	
	// Clicking Sign out Button
	
	public void click_Signout_Btn()
	{
		DS_Intro_SignOut.click();
	}
	
	public Boolean SignOutErrorMessgae()
	{
				
		boolean status = DS_LogoutMessage.isDisplayed();
		return status;
	}
	
}
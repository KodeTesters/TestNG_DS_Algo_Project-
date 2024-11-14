package pageObject;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import factory.BaseClass;



public class HomePage extends BasePage{
	
		   
		public static  Properties p;

		
		public HomePage(WebDriver driver) {
			super(driver);
		}
		
		@FindBy (xpath="//a[normalize-space()='NumpyNinja']")
		private WebElement NumpyNinjaLink;
		
		@FindBy(xpath="//a[normalize-space()='Sign in']")
		private WebElement SignInLink;
		
		@FindBy(xpath="//a[normalize-space()='Register']")
		private WebElement RegisterLink;
		
		@FindBy(xpath="//ul/a[@href='#']/following-sibling::a[1]")
		private WebElement UsernameLink;
		
		@FindBy(xpath="//a[@data-toggle='dropdown']")
		private WebElement DataStructureDropDown;
		
		@FindBy(xpath="//a[normalize-space()='Arrays']")
		private WebElement DS_Arrays_dropdown;
		
		@FindBy(xpath="//a[normalize-space()='Linked List']")
		private WebElement DS_LinkedList_dropdown;
		
		@FindBy(xpath="//a[normalize-space()='Stack']")
		private WebElement DS_Stack_dropdown;
		
		@FindBy(xpath="//a[normalize-space()='Queue']")
		private WebElement DS_Queue_dropdown;
		
		@FindBy(xpath="//a[normalize-space()='Tree']")
		private WebElement DS_Tree_dropdown;
		
		@FindBy(xpath="//a[normalize-space()='Graph']")
		private WebElement DS_Graph_dropdown;
		
		@FindBy (xpath="//a[contains(text(),'Get Started')]")
		private List<WebElement> HomepageGetStartedBtnList;
		
		@FindBy (xpath="//a[@href='data-structures-introduction']")
		private WebElement DataStructureGetStartedBtn;
		
		@FindBy (xpath="//a[@href='array']")
		private WebElement ArrayGetStartedBtn;
		
		@FindBy (xpath="//a[@href='linked-list']")
		private WebElement LinkedListGetStartedBtn;
		
		@FindBy (xpath="//a[@href='stack']")
		private WebElement StackGetStartedBtn;
		
		@FindBy (xpath="//a[@href='queue']")
		private WebElement QueueGetStartedBtn;
		
		@FindBy (xpath="//a[@href='tree']")
		private WebElement TreeGetStartedBtn;
		
		@FindBy (xpath="//a[@href='graph']")
		private WebElement GraphGetStartedBtn;
		
		@FindBy(xpath="//div[contains(text(),'You are logged in')]")
		private WebElement YouAreLoggedInMsg;  //-----Message after SignIn with Valid credentials
			
		@FindBy (xpath ="//div[contains(text(),'You are not logged in')]")
		private WebElement NotLoggedInErrMsg;  //-----clicking Get started without signing in
		
		@FindBy (xpath="//div[contains(text(),'New Account Created.')]")
		private WebElement NewAccCreatedMsg;   //----after Registering a new user
		
		
		@FindBy(xpath="//h4[normalize-space()='Data Structures-Introduction']")
		private WebElement DS_Intro_Page;
		
		@FindBy(xpath="//h4[normalize-space()='Array']")
		private WebElement ArrayPage;
		
		@FindBy(xpath="//h4[normalize-space()='Linked List']")
		private WebElement LinkedListPage;
		
		@FindBy(xpath="//h4[normalize-space()='Stack']")
		private WebElement StackPage;
		
		@FindBy(xpath="//h4[normalize-space()='Queue']")
		private WebElement QueuePage;
		
		@FindBy(xpath="//h4[normalize-space()='Tree']")
		private WebElement TreePage;
		
		@FindBy(xpath="//h4[normalize-space()='Graph']")
		private WebElement GraphPage;
		
		//------------------Methods---------------		
			
		
		public void Login_HomePage() 
		{
			SignInPage sp = new SignInPage(BaseClass.getDriver());	
			GetStartedPage Gp = new GetStartedPage(BaseClass.getDriver());
			Gp.clickGetStartedSP();
			clickSigIn();

			try {
				sp.enterUsername(BaseClass.getProperties().getProperty("username"));
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			try {
				sp.enterpassword(BaseClass.getProperties().getProperty("password"));
			} catch (IOException e) {
				
				e.printStackTrace();
			}		

			 sp.clickLogin();	 


		}
		
		public boolean NumpyNinjaLinkDisplay() {
			boolean display = NumpyNinjaLink.isDisplayed();
			return display;
		}
		
		public void clickNumpyNinjaLink() {
			 NumpyNinjaLink.click();
		}
		
		public void clickSigIn() {
			SignInLink.click();
		}
		
		public boolean YouAreLoggedInMsg() {
			boolean status =  YouAreLoggedInMsg.isDisplayed();
			return status;
		}
		
		
		public boolean NotLoggedInErrorMsg() {
			boolean status = NotLoggedInErrMsg.isDisplayed();
			return status;
		}
		
		public void clickRegisterLink() {
			RegisterLink.click();
		}
		
		public boolean checkNewAccCreatedMsg() {
			boolean display = NewAccCreatedMsg.isDisplayed();
			return display;
		}
		
		public String getUsernameAtLinkHomepage() {
			String name = UsernameLink.getText();
			return name;
		}
		
		public boolean checkUsernameLinkDisplay() {
			boolean status = UsernameLink.isDisplayed();
			return status;
		}
		
		public void clickDataStrucGetStarted() {
			DataStructureGetStartedBtn.click();
		}
		
		public void clickArrayGetStarted()  {
			ArrayGetStartedBtn.click();
		}
		
		public void clickLinkedListGetStarted() {
			LinkedListGetStartedBtn.click();
		}
		
		public void clickStackGetStarted(){
			StackGetStartedBtn.click();
		}
		
		public void clickQueueGetStarted() {
			QueueGetStartedBtn.click();
			}
		
		public void clickTreeGetStarted() {
			TreeGetStartedBtn.click();
		}
		
		public void clickGraphGetStarted(){
			GraphGetStartedBtn.click();
		}
		
		public void clickArrayDropdown() throws InterruptedException   {
			DataStructureDropDown.click();
			DS_Arrays_dropdown.click();
			}
		
		public void clickLinkedListDropdown() {
			DataStructureDropDown.click();
			DS_LinkedList_dropdown.click();
		}
		
		public void clickStackDropdown(){
			DataStructureDropDown.click();
			DS_Stack_dropdown.click();
		}
		
		public void clickQueueDropdown() {
			DataStructureDropDown.click();
			DS_Queue_dropdown.click();
			}
		
		public void clickTreeDropdown() {
			DataStructureDropDown.click();
			DS_Tree_dropdown.click();
		}
		
		public void clickGraphDropdown(){
			DataStructureDropDown.click();
			DS_Graph_dropdown.click();
		}
		
		
		public boolean checkDS_Intro_PageDisplay() {
			boolean display = DS_Intro_Page.isDisplayed();
			return display;
		}
		
		public boolean checkLinkedListPageDisplay() {
			boolean display = LinkedListPage.isDisplayed();
			return display;
		}
		
		public boolean checkStackPageDisplay() {
			boolean display = StackPage.isDisplayed();
			return display;
		}
		
		public boolean checkArrayPageDisplay() {
			boolean display = ArrayPage.isDisplayed();
			return display;
		}
		
		public boolean checkQueuePageDisplay() {
			boolean display = QueuePage.isDisplayed();
			return display;
		}
		
		public boolean checkTreePageDisplay() {
			boolean display = TreePage.isDisplayed();
			return display;
		}
		
		public boolean checkGraphPageDisplay() {
			boolean display = GraphPage.isDisplayed();
		    return display;
		}
		
		public void clickAnyGetStarted(String topic) {
			switch (topic)
			{
			case "DataStructure": clickDataStrucGetStarted();break;
			case "Array":clickArrayGetStarted();break;
			case"LinkedList": clickLinkedListGetStarted();break;
			case "Stack":clickStackGetStarted();break;
			case "Queue":clickQueueGetStarted();break;
			case "Tree":clickTreeGetStarted();break;
			case "Graph":clickGraphGetStarted();break;
			default: System.out.println("Unable to find this topic....");break;		
			}
		}
		
		public boolean displayTopicPageOnGetStartedClick(String topic) {
			boolean status = false;
			switch (topic)
			{
			case "DataStructure":status= checkDS_Intro_PageDisplay();break;
			case "Array":status = checkArrayPageDisplay();break; 
			case"LinkedList": status = checkLinkedListPageDisplay();break;
			case "Stack":status = checkStackPageDisplay();break;
			case "Queue":status = checkQueuePageDisplay();break;
			case "Tree":status = checkTreePageDisplay();break;
			case "Graph":status = checkGraphPageDisplay();break;
			default: System.out.println("Unable to find the page....");break;
			}		
			return status;
		}
		
		public void selectDropdownTopic(String topic) {
		switch(topic) {
			case "Array":try {
				clickArrayDropdown();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}break;
			case"LinkedList": clickLinkedListDropdown();break;
			case "Stack":clickStackDropdown();break;
			case "Queue":clickQueueDropdown();break;
			case "Tree":clickTreeDropdown();break;
			case "Graph":clickGraphDropdown();break;
			default: System.out.println("Improper selection....");break;
		    }
	   }
		

	}
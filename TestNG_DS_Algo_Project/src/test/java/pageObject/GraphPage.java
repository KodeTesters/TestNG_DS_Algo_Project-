package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import factory.BaseClass;

public class GraphPage extends BasePage {

	public GraphPage(WebDriver driver) {
		super(driver);
		}

	//--------------WebElements----------------
	
	
	@FindBy(xpath="//a[@href='graph']")
	private WebElement GraphGetStrdBtn;
	
	@FindBy(xpath="//a[@href='graph']")
	private WebElement GraphBtn;
	
	@FindBy(xpath="//a[@href='/tryEditor']")
	private WebElement TryHereBtn;
	
	@FindBy(xpath="//a[normalize-space()='Graph Representations']")
	private WebElement GraphRepresentationBtn;

	
	String Graph_HomePage_URL="https://dsportalapp.herokuapp.com/graph/";
	
	String Graph_Page_URL="https://dsportalapp.herokuapp.com/graph/graph/";

	String GraphRepersentations_Page_URL="https://dsportalapp.herokuapp.com/graph/graph-representations/"	;
	String Online_Editor_Console_URL="https://dsportalapp.herokuapp.com/tryEditor";
	
	
	//----------Methods--------------

	public void click_Getstarted()
	{
		GraphGetStrdBtn.click();
	}
	
	public boolean check_GraphHomePage()
	{
		String Current_URL=BaseClass.getDriver().getCurrentUrl();
		 boolean Check_URL = Graph_HomePage_URL.equals(Current_URL);	
		 return Check_URL;
	}
	
	public void click_GraphLink()
	{
		GraphBtn.click();
	}

	public void clickTryHereBtn() {
		TryHereBtn.click();
	}
	public boolean check_TryEditorPage() {
		String Current_URL=BaseClass.getDriver().getCurrentUrl();
		 boolean Check_URL = Online_Editor_Console_URL.equals(Current_URL);	
		 return Check_URL;
	}
	public boolean check_GraphPage()
	{
		String Current_URL=BaseClass.getDriver().getCurrentUrl();
		 boolean Check_URL = Graph_Page_URL.equals(Current_URL);	
		 return Check_URL;
	}

	public void click_GraphRepresentationsLink() {
		GraphRepresentationBtn.click();
	}

	public boolean check_GraphRepresentationsLink() {

		String Current_URL=BaseClass.getDriver().getCurrentUrl();
		 boolean Check_URL = GraphRepersentations_Page_URL.equals(Current_URL);	
		 return Check_URL;
  }	
}

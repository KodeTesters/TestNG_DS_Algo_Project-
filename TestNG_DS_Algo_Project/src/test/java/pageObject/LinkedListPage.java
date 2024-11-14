package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import factory.BaseClass;

public class LinkedListPage extends BasePage {

    public LinkedListPage(WebDriver driver) {
        super(driver);
    }

    //-------------WebElements--------------
    @FindBy(xpath="//a[@href='linked-list']")
    private WebElement LLGetStarted;

    @FindBy (linkText="Introduction")
    private WebElement IntroductionBtn;

    @FindBy (linkText="Creating Linked LIst")
    private WebElement CreatingLinkedListBtn;

    @FindBy (linkText="Types of Linked List")
    private WebElement TypesOfLinkedListBtn;

    @FindBy (linkText="Implement Linked List in Python")
    private WebElement ImplementLinkedListBtn;

    @FindBy (linkText="Traversal")
    private WebElement TraversalBtn;

    @FindBy (linkText="Insertion")
    private WebElement InsertionBtn;

    @FindBy (linkText="Deletion")
    private WebElement DeletionBtn;

    @FindBy (linkText="Practice Questions")
    private WebElement PracticeQns;

    @FindBy (xpath="//a[@href='/tryEditor']")
    private WebElement TryhereBtn;

    @FindBy(xpath="//*[@id=\"answer_form\"]/div/div/div[6]/div[1]/div/div/div/div[4]")
    private WebElement OnlineEditorConsole;

    @FindBy (xpath="//*[@id=\"answer_form\"]/button")
    private WebElement RunBtn;

    @FindBy (xpath="//*[@id='output']")
    private WebElement ConsoleOutput;

    ///html/body/div[2]/div/div[2]/a-- button
    ///html/body/div[2]/div/div[2]/a
    ////span[@role='presentation']--try editor console

    //-------------Variables--------------------


    String LL_HomePage_URL="https://dsportalapp.herokuapp.com/linked-list/";
    String LL_Introduction_Page_URL="https://dsportalapp.herokuapp.com/linked-list/introduction/";
    String LL_CreatingLinkedList_URL="https://dsportalapp.herokuapp.com/linked-list/creating-linked-list/";
    String LL_TypesofLinkedList_URL="https://dsportalapp.herokuapp.com/linked-list/types-of-linked-list/";
    String LL_ImplementingLinkedList_URL="https://dsportalapp.herokuapp.com/linked-list/implement-linked-list-in-python/";
    String LL_Traversal_URL="https://dsportalapp.herokuapp.com/linked-list/traversal/";
    String LL_Insertion_URL="https://dsportalapp.herokuapp.com/linked-list/insertion-in-linked-list/";
    String LL_Deletion_URL="https://dsportalapp.herokuapp.com/linked-list/deletion-in-linked-list/";
    String LL_PracticeQns_URL="https://dsportalapp.herokuapp.com/linked-list/practice";
    String Online_Editor_Console_URL="https://dsportalapp.herokuapp.com/tryEditor";
    //String code="hello";
    //creating ll,types of ll,implement ll in python,traversal,insertion,deletion,practice qns



    //-----------Methods---------

    public void click_LLGetStarted()
    {
        LLGetStarted.click();
    }
    public boolean check_LLHomePage() {

        String CurrentLL_URL=BaseClass.getDriver().getCurrentUrl();
        boolean CheckLL_URL = LL_HomePage_URL.equals(CurrentLL_URL);
        return CheckLL_URL;
    }

    public void click_Introduction() {
        IntroductionBtn.click();
    }

    public boolean check_IntroductionPage()
    {
        String Current_URL=BaseClass.getDriver().getCurrentUrl();
        boolean Check_URL = LL_Introduction_Page_URL.equals(Current_URL);
        return Check_URL;
    }

    public void click_TryHereBtn() {
        TryhereBtn.click();
    }
    public boolean check_TryEditorPage() {
        String Current_URL=BaseClass.getDriver().getCurrentUrl();
        boolean Check_URL = Online_Editor_Console_URL.equals(Current_URL);
        return Check_URL;
    }
    public void click_creatingLinkedList()
    {
        CreatingLinkedListBtn.click();
    }
    public boolean check_CreatingLinkedListPage()
    {
        String Current_URL=BaseClass.getDriver().getCurrentUrl();
        boolean Check_URL = LL_CreatingLinkedList_URL.equals(Current_URL);
        return Check_URL;

    }
    public void click_TypesOfLinkedList()
    {
        TypesOfLinkedListBtn.click();
    }
    public boolean check_TypesOfLinkedListPage()
    {
        String Current_URL=BaseClass.getDriver().getCurrentUrl();
        boolean Check_URL = LL_TypesofLinkedList_URL.equals(Current_URL);
        return Check_URL;

    }

    public void click_ImplementingLinkedList()
    {
        ImplementLinkedListBtn.click();
    }
    public boolean check_ImplementingLinkedListPage()
    {
        String Current_URL=BaseClass.getDriver().getCurrentUrl();
        boolean Check_URL = LL_ImplementingLinkedList_URL.equals(Current_URL);
        return Check_URL;

    }
    public void click_Traversal()
    {
        TraversalBtn.click();
    }
    public boolean check_Traversal()
    {
        String Current_URL=BaseClass.getDriver().getCurrentUrl();
        boolean Check_URL = LL_Traversal_URL.equals(Current_URL);
        return Check_URL;

    }

    public void click_Insertion()
    {
        InsertionBtn.click();
    }
    public boolean check_Insertion()
    {
        String Current_URL=BaseClass.getDriver().getCurrentUrl();
        boolean Check_URL = LL_Insertion_URL.equals(Current_URL);
        return Check_URL;

    }
    public void click_Deletion()
    {
        DeletionBtn.click();
    }
    public boolean check_Deletion()
    {
        String Current_URL=BaseClass.getDriver().getCurrentUrl();
        boolean Check_URL = LL_Deletion_URL.equals(Current_URL);
        return Check_URL;

    }

    public void click_PracticeQns()
    {
        PracticeQns.click();
    }
    public boolean check_LLPracticeQns()
    {
        String Current_URL=BaseClass.getDriver().getCurrentUrl();
        boolean Check_URL = LL_PracticeQns_URL.equals(Current_URL);
        return Check_URL;

    }

}

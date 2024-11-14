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

public class LinkedListPageTests extends Hooks {

    Logger logger=BaseClass.getLogger();

    public void checkValidAndInvalidLoginTest(String user, String pwd) {
        SignInPage sp= new SignInPage(BaseClass.getDriver());
        logger.info("Enter the username at login page.............");
        sp.enterUsername(user);
        sp.enterpassword(pwd);
        sp.clickLogin();
    }
    @Test(priority=0,groups="regression")
    public void check_LinkedListHomePage()
    {
        HomePage Hp = new HomePage(BaseClass.getDriver());
        Hp.Login_HomePage();
        LinkedListPage lp=new LinkedListPage(BaseClass.getDriver());
        lp.click_LLGetStarted();
        boolean status = lp.check_LLHomePage();
        Assert.assertEquals(status, true);
        logger.info("HomePage is displayed");

    }

    @Test(priority=1,groups="regression")
    public void check_IntoductionTab()
    {
        HomePage Hp = new HomePage(BaseClass.getDriver());
        Hp.Login_HomePage();
        LinkedListPage lp=new LinkedListPage(BaseClass.getDriver());
        lp.click_LLGetStarted();
        lp.click_Introduction();
        boolean status=lp.check_IntroductionPage();
        Assert.assertEquals(status, true);
        logger.info("Introduction page is displayed");
    }

    @Test(priority=2,groups="regression")
    public void check_IntroductionTryHereButton()
    {
        HomePage Hp = new HomePage(BaseClass.getDriver());
        Hp.Login_HomePage();
        LinkedListPage lp=new LinkedListPage(BaseClass.getDriver());
        lp.click_LLGetStarted();
        lp.click_Introduction();
        lp.click_TryHereBtn();
        boolean status=lp.check_TryEditorPage();
        Assert.assertEquals(status, true);
        logger.info("TryEditor page is displayed");

    }

    @Test(priority=3,groups="regression")
    public void check_IntroductionPythonEditorValidInput()
    {
        HomePage Hp = new HomePage(BaseClass.getDriver());
        Hp.Login_HomePage();
        LinkedListPage lp=new LinkedListPage(BaseClass.getDriver());
        DataStructurePage ds = new DataStructurePage(BaseClass.getDriver());
        lp.click_LLGetStarted();
        lp.click_Introduction();
        lp.click_TryHereBtn();
        logger.info("Entering valid python code..........");
        ds.Click_DS_PythonEditor_Runbtn_ValidCodes();
        ds.click_DS_PythonEditor_RunBtn();
        ds.validate_Console_Output();
        logger.info("Console output.......     " +ds.ConsoleOutput_text + ds.PYEditor_Code);
        Assert.assertEquals(true,ds.PYEditor_Code.contains(ds.ConsoleOutput_text) );

    }

    @Test(priority=4,groups="regression")
    public void check_IntroductionPythonEditorInvalidInput()
    {
        HomePage Hp = new HomePage(BaseClass.getDriver());
        Hp.Login_HomePage();
        LinkedListPage lp=new LinkedListPage(BaseClass.getDriver());
        DataStructurePage ds = new DataStructurePage(BaseClass.getDriver());
        lp.click_LLGetStarted();
        lp.click_Introduction();
        lp.click_TryHereBtn();
        logger.info("User Entering invalid pythod code on the editor ..... ");
        ds.Click_DS_PythonEditor_Runbtn_InValidCodes();
        ds.Validate_OutputConsole_InvalidCodes();
        logger.info("Alert Message in Python Editor " + ds.Alertmesg);
        Assert.assertEquals(true, ds.Alertmesg.contains("bad input on line 1"));

    }

    @Test(priority=5,groups="regression")
    public void check_IntroductionPythonEditorNoInput()
    {
        HomePage Hp = new HomePage(BaseClass.getDriver());
        Hp.Login_HomePage();
        LinkedListPage lp=new LinkedListPage(BaseClass.getDriver());
        DataStructurePage ds = new DataStructurePage(BaseClass.getDriver());
        lp.click_LLGetStarted();
        lp.click_Introduction();
        lp.click_TryHereBtn();
        ds.Click_DS_PythonEditor_Runbtn_WithoutCodes();
        String crntURL = BaseClass.getDriver().getCurrentUrl();
        Assert.assertEquals(true, crntURL.contains("tryEditor"));

    }

    @Test(priority=6,groups="regression")
    public void check_CreatingLinkedListTab()
    {
        HomePage Hp = new HomePage(BaseClass.getDriver());
        Hp.Login_HomePage();
        LinkedListPage lp=new LinkedListPage(BaseClass.getDriver());
        lp.click_LLGetStarted();
        logger.info("Clicking the Creating Linked List page link.....");
        lp.click_creatingLinkedList();
        logger.info("Redirecting to CreatingLinkedListPage..............");
        boolean check_URL=lp.check_CreatingLinkedListPage();
        Assert.assertEquals(check_URL, true);
        logger.info("Creating linked list page displayed......");

    }

    @Test(priority=7,groups="regression")
    public void check_CreatingLLTryHereButton()
    {
        HomePage Hp = new HomePage(BaseClass.getDriver());
        Hp.Login_HomePage();
        LinkedListPage lp=new LinkedListPage(BaseClass.getDriver());
        lp.click_LLGetStarted();
        lp.click_creatingLinkedList();
        lp.click_TryHereBtn();
        boolean status=lp.check_TryEditorPage();
        Assert.assertEquals(status, true);
        logger.info("TryEditor page is displayed");

    }

    @Test(priority=8,groups="regression")
    public void check_CreatingLLPythonEditorValidInput()
    {
        HomePage Hp = new HomePage(BaseClass.getDriver());
        Hp.Login_HomePage();
        LinkedListPage lp=new LinkedListPage(BaseClass.getDriver());
        DataStructurePage ds = new DataStructurePage(BaseClass.getDriver());
        lp.click_LLGetStarted();
        lp.click_creatingLinkedList();
        logger.info("Redirecting to CreatingLinkedListPage..............");
        lp.click_TryHereBtn();
        logger.info("Entering valid python code..........");
        ds.Click_DS_PythonEditor_Runbtn_ValidCodes();
        ds.click_DS_PythonEditor_RunBtn();
        ds.validate_Console_Output();
        logger.info("Console output.......     " +ds.ConsoleOutput_text + ds.PYEditor_Code);
        Assert.assertEquals(true,ds.PYEditor_Code.contains(ds.ConsoleOutput_text) );

    }

    @Test(priority=9,groups="regression")
    public void check_CreatingLLPythonEditorInvalidInput()
    {
        HomePage Hp = new HomePage(BaseClass.getDriver());
        Hp.Login_HomePage();
        LinkedListPage lp=new LinkedListPage(BaseClass.getDriver());
        DataStructurePage ds = new DataStructurePage(BaseClass.getDriver());
        lp.click_LLGetStarted();
        lp.click_creatingLinkedList();
        logger.info("Redirecting to CreatingLinkedListPage..............");
        lp.click_TryHereBtn();
        logger.info("User Entering invalid pythod code on the editor ..... ");
        ds.Click_DS_PythonEditor_Runbtn_InValidCodes();
        ds.Validate_OutputConsole_InvalidCodes();
        logger.info("Alert Message in Python Editor " + ds.Alertmesg);
        Assert.assertEquals(true, ds.Alertmesg.contains("bad input on line 1"));

    }

    @Test(priority=10,groups="regression")
    public void check_CreatingLLPythonEditorNoInput()
    {
        HomePage Hp = new HomePage(BaseClass.getDriver());
        Hp.Login_HomePage();
        LinkedListPage lp=new LinkedListPage(BaseClass.getDriver());
        DataStructurePage ds = new DataStructurePage(BaseClass.getDriver());
        lp.click_LLGetStarted();
        lp.click_creatingLinkedList();
        logger.info("Redirecting to CreatingLinkedListPage..............");
        lp.click_TryHereBtn();
        ds.Click_DS_PythonEditor_Runbtn_WithoutCodes();
        String crntURL = BaseClass.getDriver().getCurrentUrl();
        Assert.assertEquals(true, crntURL.contains("tryEditor"));

    }



    @Test(priority=11,groups="regression")
    public void check_TypesOfLinkedListTab()
    {
        HomePage Hp = new HomePage(BaseClass.getDriver());
        Hp.Login_HomePage();
        LinkedListPage lp=new LinkedListPage(BaseClass.getDriver());
        lp.click_LLGetStarted();
        logger.info("user clicked types of linkd list link.........");
        lp.click_TypesOfLinkedList();
        logger.info("Redirecting to typesoflinkedlist page..............");
        boolean check_URL=lp.check_TypesOfLinkedListPage();
        Assert.assertEquals(check_URL, true);
        logger.info("Typesoflinkedlist page displayed......");

    }

    @Test(priority=12,groups="regression")
    public void check_TypesOfLLTryHereButton()
    {
        HomePage Hp = new HomePage(BaseClass.getDriver());
        Hp.Login_HomePage();
        LinkedListPage lp=new LinkedListPage(BaseClass.getDriver());
        lp.click_LLGetStarted();
        lp.click_TypesOfLinkedList();
        lp.click_TryHereBtn();
        boolean status=lp.check_TryEditorPage();
        Assert.assertEquals(status, true);
        logger.info("TryEditor page is displayed");

    }


    @Test(priority=13,groups="regression")
    public void check_TypesOfLLPythonEditorValidInput()
    {
        HomePage Hp = new HomePage(BaseClass.getDriver());
        Hp.Login_HomePage();
        LinkedListPage lp=new LinkedListPage(BaseClass.getDriver());
        DataStructurePage ds = new DataStructurePage(BaseClass.getDriver());
        lp.click_LLGetStarted();
        lp.click_TypesOfLinkedList();
        logger.info("Redirecting to CreatingLinkedListPage..............");
        lp.click_TryHereBtn();
        logger.info("Entering valid python code..........");
        ds.Click_DS_PythonEditor_Runbtn_ValidCodes();
        ds.click_DS_PythonEditor_RunBtn();
        ds.validate_Console_Output();
        logger.info("Console output.......     " +ds.ConsoleOutput_text + ds.PYEditor_Code);
        Assert.assertEquals(true,ds.PYEditor_Code.contains(ds.ConsoleOutput_text) );


    }

    @Test(priority=14,groups="regression")
    public void check_TypesOfLLPythonEditorInvalidInput()
    {
        HomePage Hp = new HomePage(BaseClass.getDriver());
        Hp.Login_HomePage();
        LinkedListPage lp=new LinkedListPage(BaseClass.getDriver());
        DataStructurePage ds = new DataStructurePage(BaseClass.getDriver());
        lp.click_LLGetStarted();
        lp.click_TypesOfLinkedList();
        logger.info("Redirecting to CreatingLinkedListPage..............");
        lp.click_TryHereBtn();
        logger.info("User Entering invalid pythod code on the editor ..... ");
        ds.Click_DS_PythonEditor_Runbtn_InValidCodes();
        ds.Validate_OutputConsole_InvalidCodes();
        logger.info("Alert Message in Python Editor " + ds.Alertmesg);
        Assert.assertEquals(true, ds.Alertmesg.contains("bad input on line 1"));

    }

    @Test(priority=15,groups="regression")
    public void check_TypesOfLLPythonEditorNoInput()
    {
        HomePage Hp = new HomePage(BaseClass.getDriver());
        Hp.Login_HomePage();
        LinkedListPage lp=new LinkedListPage(BaseClass.getDriver());
        DataStructurePage ds = new DataStructurePage(BaseClass.getDriver());
        lp.click_LLGetStarted();
        lp.click_TypesOfLinkedList();
        logger.info("Redirecting to CreatingLinkedListPage..............");
        lp.click_TryHereBtn();
        ds.Click_DS_PythonEditor_Runbtn_WithoutCodes();
        String crntURL = BaseClass.getDriver().getCurrentUrl();
        Assert.assertEquals(true, crntURL.contains("tryEditor"));

    }


    @Test(priority=16,groups="regression")
    public void check_ImplementingLinkedListTab()
    {
        HomePage Hp = new HomePage(BaseClass.getDriver());
        Hp.Login_HomePage();
        LinkedListPage lp=new LinkedListPage(BaseClass.getDriver());
        lp.click_LLGetStarted();
        logger.info("user clicked Implementinglinkedlist link.........");
        lp.click_ImplementingLinkedList();
        logger.info("Redirecting to Implementinglinkedlist page..............");
        boolean check_URL=lp.check_ImplementingLinkedListPage();
        Assert.assertEquals(check_URL, true);
        logger.info("Implementinglinkedlist page displayed......");

    }

    @Test(priority=17,groups="regression")
    public void check_ImplementingLLTryHereButton()
    {
        HomePage Hp = new HomePage(BaseClass.getDriver());
        Hp.Login_HomePage();
        LinkedListPage lp=new LinkedListPage(BaseClass.getDriver());
        lp.click_LLGetStarted();
        lp.click_ImplementingLinkedList();
        lp.click_TryHereBtn();
        boolean status=lp.check_TryEditorPage();
        Assert.assertEquals(status, true);
        logger.info("TryEditor page is displayed");

    }


    @Test(priority=18,groups="regression")
    public void check_ImplementingLLPythonEditorValidInput()
    {
        HomePage Hp = new HomePage(BaseClass.getDriver());
        Hp.Login_HomePage();
        LinkedListPage lp=new LinkedListPage(BaseClass.getDriver());
        DataStructurePage ds = new DataStructurePage(BaseClass.getDriver());
        lp.click_LLGetStarted();
        lp.click_ImplementingLinkedList();
        lp.click_TryHereBtn();
        logger.info("Entering valid python code..........");
        ds.Click_DS_PythonEditor_Runbtn_ValidCodes();
        ds.click_DS_PythonEditor_RunBtn();
        ds.validate_Console_Output();
        logger.info("Console output.......     " +ds.ConsoleOutput_text + ds.PYEditor_Code);
        Assert.assertEquals(true,ds.PYEditor_Code.contains(ds.ConsoleOutput_text) );

    }

    @Test(priority=19,groups="regression")
    public void check_ImplementingLLPythonEditorInvalidInput()
    {
        HomePage Hp = new HomePage(BaseClass.getDriver());
        Hp.Login_HomePage();
        LinkedListPage lp=new LinkedListPage(BaseClass.getDriver());
        DataStructurePage ds = new DataStructurePage(BaseClass.getDriver());
        lp.click_LLGetStarted();
        lp.click_ImplementingLinkedList();
        lp.click_TryHereBtn();
        logger.info("User Entering invalid pythod code on the editor ..... ");
        ds.Click_DS_PythonEditor_Runbtn_InValidCodes();
        ds.Validate_OutputConsole_InvalidCodes();
        logger.info("Alert Message in Python Editor " + ds.Alertmesg);
        Assert.assertEquals(true, ds.Alertmesg.contains("bad input on line 1"));

    }

    @Test(priority=20,groups="regression")
    public void check_ImplementingLLPythonEditorNoInput()
    {
        HomePage Hp = new HomePage(BaseClass.getDriver());
        Hp.Login_HomePage();
        LinkedListPage lp=new LinkedListPage(BaseClass.getDriver());
        DataStructurePage ds = new DataStructurePage(BaseClass.getDriver());
        lp.click_LLGetStarted();
        lp.click_ImplementingLinkedList();
        lp.click_TryHereBtn();
        ds.Click_DS_PythonEditor_Runbtn_WithoutCodes();
        logger.info("User not entering any code on the editor ..... ");
        String crntURL = BaseClass.getDriver().getCurrentUrl();
        Assert.assertEquals(true, crntURL.contains("tryEditor"));

    }


    @Test(priority=21,groups="regression")
    public void check_Traversal()
    {
        HomePage Hp = new HomePage(BaseClass.getDriver());
        Hp.Login_HomePage();
        LinkedListPage lp=new LinkedListPage(BaseClass.getDriver());
        lp.click_LLGetStarted();
        logger.info("user clicked Traversal link.........");
        lp.click_Traversal();
        logger.info("Redirecting to Traversal page..............");
        boolean check_URL=lp.check_Traversal();
        Assert.assertEquals(check_URL, true);
        logger.info("Traversal page displayed......");

    }

    @Test(priority=22,groups="regression")
    public void check_TraversalTryHereButton()
    {
        HomePage Hp = new HomePage(BaseClass.getDriver());
        Hp.Login_HomePage();
        LinkedListPage lp=new LinkedListPage(BaseClass.getDriver());
        lp.click_LLGetStarted();
        lp.click_Traversal();
        lp.click_TryHereBtn();
        boolean status=lp.check_TryEditorPage();
        Assert.assertEquals(status, true);
        logger.info("TryEditor page is displayed");

    }

    @Test(priority=23,groups="regression")
    public void check_TraversalPythonEditorValidInput()
    {
        HomePage Hp = new HomePage(BaseClass.getDriver());
        Hp.Login_HomePage();
        LinkedListPage lp=new LinkedListPage(BaseClass.getDriver());
        DataStructurePage ds = new DataStructurePage(BaseClass.getDriver());
        lp.click_LLGetStarted();
        lp.click_Traversal();
        lp.click_TryHereBtn();
        logger.info("Entering valid python code..........");
        ds.Click_DS_PythonEditor_Runbtn_ValidCodes();
        ds.click_DS_PythonEditor_RunBtn();
        ds.validate_Console_Output();
        logger.info("Console output.......     " +ds.ConsoleOutput_text + ds.PYEditor_Code);
        Assert.assertEquals(true,ds.PYEditor_Code.contains(ds.ConsoleOutput_text) );

    }

    @Test(priority=24,groups="regression")
    public void check_TraversalPythonEditorInvalidInput()
    {
        HomePage Hp = new HomePage(BaseClass.getDriver());
        Hp.Login_HomePage();
        LinkedListPage lp=new LinkedListPage(BaseClass.getDriver());
        DataStructurePage ds = new DataStructurePage(BaseClass.getDriver());
        lp.click_LLGetStarted();
        lp.click_Traversal();
        lp.click_TryHereBtn();
        logger.info("User Entering invalid pythod code on the editor ..... ");
        ds.Click_DS_PythonEditor_Runbtn_InValidCodes();
        ds.Validate_OutputConsole_InvalidCodes();
        logger.info("Alert Message in Python Editor " + ds.Alertmesg);
        Assert.assertEquals(true, ds.Alertmesg.contains("bad input on line 1"));

    }

    @Test(priority=25,groups="regression")
    public void check_TraversalPythonEditorNoInput()
    {
        HomePage Hp = new HomePage(BaseClass.getDriver());
        Hp.Login_HomePage();
        LinkedListPage lp=new LinkedListPage(BaseClass.getDriver());
        DataStructurePage ds = new DataStructurePage(BaseClass.getDriver());
        lp.click_LLGetStarted();
        lp.click_Traversal();
        lp.click_TryHereBtn();
        ds.Click_DS_PythonEditor_Runbtn_WithoutCodes();
        logger.info("User not entering any code on the editor ..... ");
        String crntURL = BaseClass.getDriver().getCurrentUrl();
        Assert.assertEquals(true, crntURL.contains("tryEditor"));

    }

    @Test(priority=26,groups="regression")
    public void check_Insertion()
    {
        HomePage Hp = new HomePage(BaseClass.getDriver());
        Hp.Login_HomePage();
        LinkedListPage lp=new LinkedListPage(BaseClass.getDriver());
        lp.click_LLGetStarted();
        logger.info("user clicked Insertion link.........");
        lp.click_Insertion();
        logger.info("Redirecting to Insertion page..............");
        boolean check_URL=lp.check_Insertion();
        Assert.assertEquals(check_URL, true);
        logger.info("Insertion page displayed......");

    }

    @Test(priority=27,groups="regression")
    public void check_InsertionTryHereButton()
    {
        HomePage Hp = new HomePage(BaseClass.getDriver());
        Hp.Login_HomePage();
        LinkedListPage lp=new LinkedListPage(BaseClass.getDriver());
        lp.click_LLGetStarted();
        lp.click_Insertion();
        lp.click_TryHereBtn();
        boolean status=lp.check_TryEditorPage();
        Assert.assertEquals(status, true);
        logger.info("TryEditor page is displayed");

    }

    @Test(priority=28,groups="regression")
    public void check_InsertionPythonEditorValidInput()
    {
        HomePage Hp = new HomePage(BaseClass.getDriver());
        Hp.Login_HomePage();
        LinkedListPage lp=new LinkedListPage(BaseClass.getDriver());
        DataStructurePage ds = new DataStructurePage(BaseClass.getDriver());
        lp.click_LLGetStarted();
        lp.click_Insertion();
        lp.click_TryHereBtn();
        logger.info("Entering valid python code..........");
        ds.Click_DS_PythonEditor_Runbtn_ValidCodes();
        ds.click_DS_PythonEditor_RunBtn();
        ds.validate_Console_Output();
        logger.info("Console output.......     " +ds.ConsoleOutput_text + ds.PYEditor_Code);
        Assert.assertEquals(true,ds.PYEditor_Code.contains(ds.ConsoleOutput_text) );


    }

    @Test(priority=29,groups="regression")
    public void check_InsertionPythonEditorInvalidInput()
    {
        HomePage Hp = new HomePage(BaseClass.getDriver());
        Hp.Login_HomePage();
        LinkedListPage lp=new LinkedListPage(BaseClass.getDriver());
        DataStructurePage ds = new DataStructurePage(BaseClass.getDriver());
        lp.click_LLGetStarted();
        lp.click_Insertion();
        lp.click_TryHereBtn();
        logger.info("User Entering invalid pythod code on the editor ..... ");
        ds.Click_DS_PythonEditor_Runbtn_InValidCodes();
        ds.Validate_OutputConsole_InvalidCodes();
        logger.info("Alert Message in Python Editor " + ds.Alertmesg);
        Assert.assertEquals(true, ds.Alertmesg.contains("bad input on line 1"));

    }

    @Test(priority=30,groups="regression")
    public void check_InsertionPythonEditorNoInput()
    {
        HomePage Hp = new HomePage(BaseClass.getDriver());
        Hp.Login_HomePage();
        LinkedListPage lp=new LinkedListPage(BaseClass.getDriver());
        DataStructurePage ds = new DataStructurePage(BaseClass.getDriver());
        lp.click_LLGetStarted();
        lp.click_Insertion();
        lp.click_TryHereBtn();
        ds.Click_DS_PythonEditor_Runbtn_WithoutCodes();
        logger.info("User not entering any code on the editor ..... ");
        String crntURL = BaseClass.getDriver().getCurrentUrl();
        Assert.assertEquals(true, crntURL.contains("tryEditor"));

    }

    @Test(priority=31,groups="regression")
    public void check_Deletion()
    {
        HomePage Hp = new HomePage(BaseClass.getDriver());
        Hp.Login_HomePage();
        LinkedListPage lp=new LinkedListPage(BaseClass.getDriver());
        lp.click_LLGetStarted();
        logger.info("user clicked Deletion link.........");
        lp.click_Deletion();
        logger.info("Redirecting to Deletion page..............");
        boolean check_URL=lp.check_Deletion();
        Assert.assertEquals(check_URL, true);
        logger.info("Deletion page displayed......");

    }

    @Test(priority=32,groups="regression")
    public void check_DeletionTryHereButton()
    {
        HomePage Hp = new HomePage(BaseClass.getDriver());
        Hp.Login_HomePage();
        LinkedListPage lp=new LinkedListPage(BaseClass.getDriver());
        lp.click_LLGetStarted();
        lp.click_Deletion();
        lp.click_TryHereBtn();
        boolean status=lp.check_TryEditorPage();
        Assert.assertEquals(status, true);
        logger.info("TryEditor page is displayed");

    }

    @Test(priority=33,groups="regression")
    public void check_DeletionPythonEditorValidInput()
    {
        HomePage Hp = new HomePage(BaseClass.getDriver());
        Hp.Login_HomePage();
        LinkedListPage lp=new LinkedListPage(BaseClass.getDriver());
        DataStructurePage ds = new DataStructurePage(BaseClass.getDriver());
        lp.click_LLGetStarted();
        lp.click_Deletion();
        lp.click_TryHereBtn();
        logger.info("Entering valid python code..........");
        ds.Click_DS_PythonEditor_Runbtn_ValidCodes();
        ds.click_DS_PythonEditor_RunBtn();
        ds.validate_Console_Output();
        logger.info("Console output.......     " +ds.ConsoleOutput_text + ds.PYEditor_Code);
        Assert.assertEquals(true,ds.PYEditor_Code.contains(ds.ConsoleOutput_text) );

    }

    @Test(priority=34,groups="regression")
    public void check_DeletionPythonEditorInvalidInput()
    {
        HomePage Hp = new HomePage(BaseClass.getDriver());
        Hp.Login_HomePage();
        LinkedListPage lp=new LinkedListPage(BaseClass.getDriver());
        DataStructurePage ds = new DataStructurePage(BaseClass.getDriver());
        lp.click_LLGetStarted();
        lp.click_Deletion();
        lp.click_TryHereBtn();
        logger.info("User Entering invalid pythod code on the editor ..... ");
        ds.Click_DS_PythonEditor_Runbtn_InValidCodes();
        ds.Validate_OutputConsole_InvalidCodes();
        logger.info("Alert Message in Python Editor " + ds.Alertmesg);
        Assert.assertEquals(true, ds.Alertmesg.contains("bad input on line 1"));

    }

    @Test(priority=35,groups="regression")
    public void check_DeletionPythonEditorNoInput()
    {
        HomePage Hp = new HomePage(BaseClass.getDriver());
        Hp.Login_HomePage();
        LinkedListPage lp=new LinkedListPage(BaseClass.getDriver());
        DataStructurePage ds = new DataStructurePage(BaseClass.getDriver());
        lp.click_LLGetStarted();
        lp.click_Deletion();
        lp.click_TryHereBtn();
        ds.Click_DS_PythonEditor_Runbtn_WithoutCodes();
        logger.info("User not entering any code on the editor ..... ");
        String crntURL = BaseClass.getDriver().getCurrentUrl();
        Assert.assertEquals(true, crntURL.contains("tryEditor"));

    }



    @Test(priority=36,groups="regression")
    public void check_LLPracticeQns()
    {
        HomePage Hp = new HomePage(BaseClass.getDriver());
        Hp.Login_HomePage();
        LinkedListPage lp=new LinkedListPage(BaseClass.getDriver());
        lp.click_LLGetStarted();
        lp.click_Introduction();
        lp.click_PracticeQns();
        boolean status=lp.check_LLPracticeQns();
        Assert.assertEquals(status, true);
        logger.info("redirected to practice qn page............");


    }

}

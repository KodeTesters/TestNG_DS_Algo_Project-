package testCases;

import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import factory.BaseClass;
import factory.Hooks;
import pageObject.DataStructurePage;
import pageObject.HomePage;
import pageObject.SignInPage;
import pageObject.TreePage;

public class TreePageTests extends Hooks{

    Logger logger = BaseClass.getLogger();
    public void checkValidAndInvalidLoginTest(String user, String pwd) {
        SignInPage sp= new SignInPage(BaseClass.getDriver());
        logger.info("Enter the username at login page.............");
        sp.enterUsername(user);
        sp.enterpassword(pwd);
        sp.clickLogin();
    }
    //TreeGetStarted

    @Test(priority=1,groups="regression")
    public void check_TreeHomePagelink()
    {

        HomePage Hp = new HomePage(BaseClass.getDriver());
        Hp.Login_HomePage();
        Hp.clickTreeGetStarted();
        TreePage Tp = new TreePage (BaseClass.getDriver());
        Tp.check_TreeHomePagelink();
        boolean status = Tp.check_TreeHomePagelink();
        Assert.assertEquals(status, true);
        logger.info("treeHomePage is displayed");

    }

    //OverviewofTree
    @Test(priority=2,groups="regression")
    public void check_Overview_of_TreePage()
    {
        HomePage Hp = new HomePage(BaseClass.getDriver());
        Hp.Login_HomePage();
        TreePage Tp = new TreePage (BaseClass.getDriver());
        Tp.click_TreeGetstarted();
        Tp.click_OverviewofTreeLink();
        logger.info("Overviewoftrees is displayed");
        Tp.check_Overview_of_TreePage();
        logger.info("Redirecting to OverviewofTreeLink page..............");
        boolean status = Tp.check_Overview_of_TreePage();
        Assert.assertEquals(status, true);
        logger.info("Overviewoftrees is displayed");
    }

    //TryHereButton
    @Test(priority=3,groups="regression")
    public void check_TryHereButton()
    {
        HomePage Hp = new HomePage(BaseClass.getDriver());
        Hp.Login_HomePage();
        TreePage Tp = new TreePage (BaseClass.getDriver());
        DataStructurePage ds = new DataStructurePage(BaseClass.getDriver());
        Tp.click_TreeGetstarted();
        Tp.click_OverviewofTreeLink();
        Tp.check_Overview_of_TreePage();
        Tp.clickTryHerebutton();
        boolean status=Tp.check_TryEditorPage();
        Assert.assertEquals(status, true);
        logger.info("TryEditor page is displayed");
    }
    //PythonEditorValidInput

    @Test(groups="regression")

    public void check_PythonEditorValidInput()
    {
        HomePage Hp = new HomePage(BaseClass.getDriver());
        Hp.Login_HomePage();
        TreePage Tp = new TreePage (BaseClass.getDriver());
        DataStructurePage ds = new DataStructurePage(BaseClass.getDriver());
        Tp.click_TreeGetstarted();
        Tp.click_OverviewofTreeLink();
        Tp.check_Overview_of_TreePage();
        Tp.clickTryHerebutton();
        logger.info("Entering valid python code..........");
        ds.Click_DS_PythonEditor_Runbtn_ValidCodes();
        ds.click_DS_PythonEditor_RunBtn();
        ds.validate_Console_Output();
        logger.info("Console output.......     " +ds.ConsoleOutput_text + ds.PYEditor_Code);
        Assert.assertEquals(true,ds.PYEditor_Code.contains(ds.ConsoleOutput_text) );

    }

    //PythonEditorInvalidInput
    @Test(priority=5,groups="regression")
    public void check_PythonEditorInvalidInput()
    {
        HomePage Hp = new HomePage(BaseClass.getDriver());
        Hp.Login_HomePage();
        TreePage Tp = new TreePage (BaseClass.getDriver());
        DataStructurePage ds = new DataStructurePage(BaseClass.getDriver());
        Tp.click_TreeGetstarted();
        Tp.click_OverviewofTreeLink();
        Tp.check_Overview_of_TreePage();
        Tp.clickTryHerebutton();
        logger.info("User Entering invalid pythod code on the editor ..... ");
        ds.Click_DS_PythonEditor_Runbtn_InValidCodes();
        ds.Validate_OutputConsole_InvalidCodes();
        logger.info("Alert Message in Python Editor " + ds.Alertmesg);
        Assert.assertEquals(true, ds.Alertmesg.contains("bad input on line 1"));

    }
    // PythonEditorNoInput

    @Test(priority=6,groups="regression")
    public void check_PythonEditorNoInput()
    {
        HomePage Hp = new HomePage(BaseClass.getDriver());
        Hp.Login_HomePage();
        TreePage Tp = new TreePage (BaseClass.getDriver());
        DataStructurePage ds = new DataStructurePage(BaseClass.getDriver());
        Tp.click_TreeGetstarted();
        Tp.click_OverviewofTreeLink();
        logger.info("user clicked OverviewofTreeLink link.........");
        Tp.check_Overview_of_TreePage();
        logger.info("Redirecting to OverviewofTreeLink page..............");
        Tp.clickTryHerebutton();
        ds.Click_DS_PythonEditor_Runbtn_WithoutCodes();
        String Current_URL = BaseClass.getDriver().getCurrentUrl();
        Assert.assertEquals(true, Current_URL.contains("tryEditor"));

    }

    //terminologies

    @Test(priority=7,groups="regression")
    public void check_terminologiesPage()
    {
        HomePage Hp = new HomePage(BaseClass.getDriver());
        Hp.Login_HomePage();
        TreePage Tp = new TreePage (BaseClass.getDriver());
        Tp.click_TreeGetstarted();
        Tp.click_terminologiesLink();
        logger.info("user clicked  Terminologies link.........");
        Tp.check_terminologiesPage();
        logger.info("Redirecting to Terminologies page..............");
        boolean Check_URL=Tp. check_terminologiesPage();
        Assert.assertEquals(Check_URL, true);
        logger.info("Terminologies page displayed......"); }
    //TryHereButton
    @Test(priority=8,groups="regression")
    public void check_TryHereButton1()
    {
        HomePage Hp = new HomePage(BaseClass.getDriver());
        Hp.Login_HomePage();
        TreePage Tp = new TreePage (BaseClass.getDriver());
        DataStructurePage ds = new DataStructurePage(BaseClass.getDriver());
        Tp.click_TreeGetstarted();
        Tp.click_terminologiesLink();
        Tp.check_terminologiesPage();
        Tp.clickTryHerebutton();
        boolean status=Tp.check_TryEditorPage();
        Assert.assertEquals(status, true);
        logger.info("TryEditor page is displayed");
    }
    //PythonEditorValidInput
    @Test(priority=9,groups="regression")
    public void check_PythonEditorValidInput1()
    {
        HomePage Hp = new HomePage(BaseClass.getDriver());
        Hp.Login_HomePage();
        TreePage Tp = new TreePage (BaseClass.getDriver());
        DataStructurePage ds = new DataStructurePage(BaseClass.getDriver());
        Tp.click_TreeGetstarted();
        Tp.click_terminologiesLink();
        Tp.check_terminologiesPage();
        Tp.clickTryHerebutton();
        logger.info("Entering valid python code..........");
        ds.Click_DS_PythonEditor_Runbtn_ValidCodes();
        ds.click_DS_PythonEditor_RunBtn();
        ds.validate_Console_Output();

        logger.info("Console output.......     " +ds.ConsoleOutput_text + ds.PYEditor_Code);
        Assert.assertEquals(true,ds.PYEditor_Code.contains(ds.ConsoleOutput_text) );

    }
    //PythonEditorInvalidInput
    @Test(priority=10,groups="regression")
    public void check_PythonEditorInvalidInput1()
    {
        HomePage Hp = new HomePage(BaseClass.getDriver());
        Hp.Login_HomePage();
        TreePage Tp = new TreePage (BaseClass.getDriver());
        DataStructurePage ds = new DataStructurePage(BaseClass.getDriver());
        Tp.click_TreeGetstarted();
        Tp.click_terminologiesLink();
        Tp.check_terminologiesPage();			    Tp.clickTryHerebutton();
        logger.info("User Entering invalid pythod code on the editor ..... ");
        ds.Click_DS_PythonEditor_Runbtn_InValidCodes();
        ds.Validate_OutputConsole_InvalidCodes();
        logger.info("Alert Message in Python Editor " + ds.Alertmesg);
        Assert.assertEquals(true, ds.Alertmesg.contains("bad input on line 1"));

    }
    // PythonEditorNoInput
    @Test(priority=11,groups="regression")
    public void check_PythonEditorNoInput1()
    {
        HomePage Hp = new HomePage(BaseClass.getDriver());
        Hp.Login_HomePage();
        TreePage Tp = new TreePage (BaseClass.getDriver());
        DataStructurePage ds = new DataStructurePage(BaseClass.getDriver());
        Tp.click_TreeGetstarted();
        Tp.click_terminologiesLink();
        logger.info("user clicked terminologies link.........");
        Tp.check_terminologiesPage();
        logger.info("Redirecting to terminologies page..............");
        Tp.clickTryHerebutton();
        ds.Click_DS_PythonEditor_Runbtn_WithoutCodes();
        String Current_URL = BaseClass.getDriver().getCurrentUrl();
        Assert.assertEquals(true, Current_URL.contains("tryEditor"));

    }


    //types_of_trees
    @Test(priority=12,groups="regression")
    public void check_types_of_treesPage(){
        HomePage Hp = new HomePage(BaseClass.getDriver());
        Hp.Login_HomePage();
        TreePage Tp = new TreePage (BaseClass.getDriver());
        Tp.click_TreeGetstarted();
        Tp.click_types_of_treesLink();

        logger.info("user clicked  Typesoftree link.........");
        Tp.check_types_of_treesPage();
        logger.info("Redirecting to Typesoftree page..............");
        boolean Check_URL=Tp.check_types_of_treesPage();
        Assert.assertEquals(Check_URL, true);
        logger.info("Typesoftree page displayed......");

    } //TryHereButton
    @Test(priority=13,groups="regression")
    public void check_TryHereButton2()
    {
        HomePage Hp = new HomePage(BaseClass.getDriver());
        Hp.Login_HomePage();
        TreePage Tp = new TreePage (BaseClass.getDriver());
        DataStructurePage ds = new DataStructurePage(BaseClass.getDriver());
        Tp.click_TreeGetstarted();
        Tp.click_types_of_treesLink();
        Tp.check_types_of_treesPage();
        Tp.clickTryHerebutton();
        boolean status=Tp.check_TryEditorPage();
        Assert.assertEquals(status, true);
        logger.info("TryEditor page is displayed");
    }
    //PythonEditorValidInput
    @Test(priority=14,groups="regression")
    public void check_PythonEditorValidInput2()
    {
        HomePage Hp = new HomePage(BaseClass.getDriver());
        Hp.Login_HomePage();
        TreePage Tp = new TreePage (BaseClass.getDriver());
        DataStructurePage ds = new DataStructurePage(BaseClass.getDriver());
        Tp.click_TreeGetstarted();
        Tp.click_types_of_treesLink();
        Tp.check_types_of_treesPage();

        Tp.clickTryHerebutton();
        logger.info("Entering valid python code..........");
        ds.Click_DS_PythonEditor_Runbtn_ValidCodes();
        ds.click_DS_PythonEditor_RunBtn();
        ds.validate_Console_Output();

        logger.info("Console output.......     " +ds.ConsoleOutput_text + ds.PYEditor_Code);
        Assert.assertEquals(true,ds.PYEditor_Code.contains(ds.ConsoleOutput_text) );

    }
    //PythonEditorInvalidInput
    @Test(priority=15,groups="regression")
    public void check_PythonEditorInvalidInput2()
    {
        HomePage Hp = new HomePage(BaseClass.getDriver());
        Hp.Login_HomePage();
        TreePage Tp = new TreePage (BaseClass.getDriver());
        DataStructurePage ds = new DataStructurePage(BaseClass.getDriver());
        Tp.click_TreeGetstarted();
        Tp.click_types_of_treesLink();
        Tp.check_types_of_treesPage();
        Tp.clickTryHerebutton();
        logger.info("User Entering invalid python code on the editor ..... ");
        ds.Click_DS_PythonEditor_Runbtn_InValidCodes();
        ds.Validate_OutputConsole_InvalidCodes();
        logger.info("Alert Message in Python Editor " + ds.Alertmesg);
        Assert.assertEquals(true, ds.Alertmesg.contains("bad input on line 1"));

    }
    // PythonEditorNoInput
    @Test(priority=16,groups="regression")
    public void check_PythonEditorNoInput2()
    {
        HomePage Hp = new HomePage(BaseClass.getDriver());
        Hp.Login_HomePage();
        TreePage Tp = new TreePage (BaseClass.getDriver());
        DataStructurePage ds = new DataStructurePage(BaseClass.getDriver());
        Tp.click_TreeGetstarted();
        Tp.click_types_of_treesLink();
        logger.info("user clicked types_of_trees link.........");
        Tp.check_types_of_treesPage();
        logger.info("Redirecting to types_of_trees page..............");
        Tp.clickTryHerebutton();
        ds.Click_DS_PythonEditor_Runbtn_WithoutCodes();
        String Current_URL = BaseClass.getDriver().getCurrentUrl();
        Assert.assertEquals(true, Current_URL.contains("tryEditor"));

    }

    //tree-traversals

    @Test(priority=17,groups="regression")
    public void click_tree_traversalsLink(){
        HomePage Hp = new HomePage(BaseClass.getDriver());
        Hp.Login_HomePage();
        TreePage Tp = new TreePage (BaseClass.getDriver());
        Tp.click_TreeGetstarted();
        Tp.click_tree_traversalsLink();;

        logger.info("user clicked  treetraversals Link .........");
        Tp.check_tree_traversalsPage();
        logger.info("Redirecting to treetraversals page..............");
        boolean Check_URL=Tp.check_tree_traversalsPage();
        Assert.assertEquals(Check_URL, true);
        logger.info("treetraversals page displayed......");

    }  //TryHereButton
    @Test(priority=18,groups="regression")
    public void check_TryHereButton3()
    {
        HomePage Hp = new HomePage(BaseClass.getDriver());
        Hp.Login_HomePage();
        TreePage Tp = new TreePage (BaseClass.getDriver());
        DataStructurePage ds = new DataStructurePage(BaseClass.getDriver());
        Tp.click_TreeGetstarted();
        Tp.click_tree_traversalsLink();
        Tp.check_tree_traversalsPage();
        Tp.clickTryHerebutton();
        boolean status=Tp.check_TryEditorPage();
        Assert.assertEquals(status, true);
        logger.info("TryEditor page is displayed");
    }
    //PythonEditorValidInput
    @Test(priority=19,groups="regression")
    public void check_PythonEditorValidInput3()
    {
        HomePage Hp = new HomePage(BaseClass.getDriver());
        Hp.Login_HomePage();
        TreePage Tp = new TreePage (BaseClass.getDriver());
        DataStructurePage ds = new DataStructurePage(BaseClass.getDriver());
        Tp.click_TreeGetstarted();
        Tp.click_tree_traversalsLink();
        Tp.check_tree_traversalsPage();


        Tp.clickTryHerebutton();
        logger.info("Entering valid python code..........");
        ds.Click_DS_PythonEditor_Runbtn_ValidCodes();
        ds.click_DS_PythonEditor_RunBtn();
        ds.validate_Console_Output();

        logger.info("Console output.......     " +ds.ConsoleOutput_text + ds.PYEditor_Code);
        Assert.assertEquals(true,ds.PYEditor_Code.contains(ds.ConsoleOutput_text) );

    }
    //PythonEditorInvalidInput
    @Test(priority=20,groups="regression")
    public void check_PythonEditorInvalidInput3()
    {
        HomePage Hp = new HomePage(BaseClass.getDriver());
        Hp.Login_HomePage();
        TreePage Tp = new TreePage (BaseClass.getDriver());
        DataStructurePage ds = new DataStructurePage(BaseClass.getDriver());
        Tp.click_TreeGetstarted();
        Tp.click_tree_traversalsLink();
        Tp.check_tree_traversalsPage();

        Tp.clickTryHerebutton();
        logger.info("User Entering invalid python code on the editor ..... ");
        ds.Click_DS_PythonEditor_Runbtn_InValidCodes();
        ds.Validate_OutputConsole_InvalidCodes();
        logger.info("Alert Message in Python Editor " + ds.Alertmesg);
        Assert.assertEquals(true, ds.Alertmesg.contains("bad input on line 1"));

    }
    // PythonEditorNoInput
    @Test(priority=21,groups="regression")
    public void check_PythonEditorNoInput3()
    {
        HomePage Hp = new HomePage(BaseClass.getDriver());
        Hp.Login_HomePage();
        TreePage Tp = new TreePage (BaseClass.getDriver());
        DataStructurePage ds = new DataStructurePage(BaseClass.getDriver());
        Tp.click_TreeGetstarted();
        Tp.click_tree_traversalsLink();
        logger.info("user clicked tree-traversals link.........");
        Tp.check_tree_traversalsPage();
        logger.info("Redirecting to tree-traversals page..............");
        Tp.clickTryHerebutton();
        ds.Click_DS_PythonEditor_Runbtn_WithoutCodes();
        String Current_URL = BaseClass.getDriver().getCurrentUrl();
        Assert.assertEquals(true, Current_URL.contains("tryEditor"));

    }

    //traversals-illustration
    @Test(priority=22,groups="regression")
    public void click_traversals_illustrationLink(){
        HomePage Hp = new HomePage(BaseClass.getDriver());
        Hp.Login_HomePage();
        TreePage Tp = new TreePage (BaseClass.getDriver());
        Tp.click_TreeGetstarted();
        Tp.click_traversals_illustrationLink();;

        logger.info("user clicked  traversals_illustrations Link .........");
        Tp.check_traversals_illustrationPage();
        logger.info("Redirecting to traversals_illustration page..............");
        boolean Check_URL=Tp.check_traversals_illustrationPage();
        Assert.assertEquals(Check_URL, true);
        logger.info("traversals_illustration page displayed......");

    }  //TryHereButton
    @Test(priority=23,groups="regression")
    public void check_TryHereButton4()
    {
        HomePage Hp = new HomePage(BaseClass.getDriver());
        Hp.Login_HomePage();
        TreePage Tp = new TreePage (BaseClass.getDriver());
        DataStructurePage ds = new DataStructurePage(BaseClass.getDriver());
        Tp.click_TreeGetstarted();
        Tp.click_traversals_illustrationLink();
        Tp.check_traversals_illustrationPage();
        Tp.clickTryHerebutton();
        boolean status=Tp.check_TryEditorPage();
        Assert.assertEquals(status, true);
        logger.info("TryEditor page is displayed");
    }
    //PythonEditorValidInput
    @Test(priority=24,groups="regression")
    public void check_PythonEditorValidInput4()
    {
        HomePage Hp = new HomePage(BaseClass.getDriver());
        Hp.Login_HomePage();
        TreePage Tp = new TreePage (BaseClass.getDriver());
        DataStructurePage ds = new DataStructurePage(BaseClass.getDriver());
        Tp.click_TreeGetstarted();
        Tp.click_traversals_illustrationLink();
        Tp.check_traversals_illustrationPage();
        Tp.clickTryHerebutton();
        logger.info("Entering valid python code..........");
        ds.Click_DS_PythonEditor_Runbtn_ValidCodes();
        ds.click_DS_PythonEditor_RunBtn();
        ds.validate_Console_Output();

        logger.info("Console output.......     " +ds.ConsoleOutput_text + ds.PYEditor_Code);
        Assert.assertEquals(true,ds.PYEditor_Code.contains(ds.ConsoleOutput_text) );

    }
    //PythonEditorInvalidInput
    @Test(priority=25,groups="regression")
    public void check_PythonEditorInvalidInput4()
    {
        HomePage Hp = new HomePage(BaseClass.getDriver());
        Hp.Login_HomePage();
        TreePage Tp = new TreePage (BaseClass.getDriver());
        DataStructurePage ds = new DataStructurePage(BaseClass.getDriver());
        Tp.click_TreeGetstarted();
        Tp.click_traversals_illustrationLink();
        Tp.check_traversals_illustrationPage();

        Tp.clickTryHerebutton();
        logger.info("User Entering invalid python code on the editor ..... ");
        ds.Click_DS_PythonEditor_Runbtn_InValidCodes();
        ds.Validate_OutputConsole_InvalidCodes();
        logger.info("Alert Message in Python Editor " + ds.Alertmesg);
        Assert.assertEquals(true, ds.Alertmesg.contains("bad input on line 1"));

    }
    // PythonEditorNoInput
    @Test(priority=26,groups="regression")
    public void check_PythonEditorNoInput4()
    {
        HomePage Hp = new HomePage(BaseClass.getDriver());
        Hp.Login_HomePage();
        TreePage Tp = new TreePage (BaseClass.getDriver());
        DataStructurePage ds = new DataStructurePage(BaseClass.getDriver());
        Tp.click_TreeGetstarted();
        Tp.click_traversals_illustrationLink();

        logger.info("user clicked traversals-illustration link.........");
        Tp.check_traversals_illustrationPage();
        logger.info("Redirecting to traversals-illustration page..............");
        Tp.clickTryHerebutton();
        ds.Click_DS_PythonEditor_Runbtn_WithoutCodes();
        String Current_URL = BaseClass.getDriver().getCurrentUrl();
        Assert.assertEquals(true, Current_URL.contains("tryEditor"));

    }

    //binary-trees

    @Test(priority=27,groups="regression")
    public void click_binary_treesLink(){
        HomePage Hp = new HomePage(BaseClass.getDriver());
        Hp.Login_HomePage();
        TreePage Tp = new TreePage (BaseClass.getDriver());
        Tp.click_TreeGetstarted();
        Tp.click_binary_treesLink();
        logger.info("user clicked  binary-trees  Link .........");
        Tp.check_binary_treesPage();
        logger.info("Redirecting to binary-trees  page..............");
        boolean Check_URL=Tp.check_binary_treesPage();
        Assert.assertEquals(Check_URL, true);
        logger.info("binary-trees  page displayed......");


    } //TryHereButton
    @Test(priority=28,groups="regression")
    public void check_TryHereButton5()
    {
        HomePage Hp = new HomePage(BaseClass.getDriver());
        Hp.Login_HomePage();
        TreePage Tp = new TreePage (BaseClass.getDriver());
        DataStructurePage ds = new DataStructurePage(BaseClass.getDriver());
        Tp.click_TreeGetstarted();
        Tp.click_binary_treesLink();
        Tp.check_binary_treesPage();
        Tp.clickTryHerebutton();
        boolean status=Tp.check_TryEditorPage();
        Assert.assertEquals(status, true);
        logger.info("TryEditor page is displayed");
    }
    //PythonEditorValidInput
    @Test(priority=29,groups="regression")
    public void check_PythonEditorValidInput5()
    {

    }

    //types-of-binary-trees
    @Test(groups="regression")
    public void click_types_of_binary_treesLink_BT() {
        HomePage Hp = new HomePage(BaseClass.getDriver());
        Hp.Login_HomePage();
        TreePage Tp = new TreePage (BaseClass.getDriver());
        Tp.click_TreeGetstarted();
        Tp.click_types_of_binary_treesLink();
        logger.info("user clicked  types-of-binary-trees Link .........");
        Tp.check_types_of_binary_treesPage();
        logger.info("Redirecting to types-of-binary-trees  page..............");
        boolean Check_URL=Tp.check_types_of_binary_treesPage();
        Assert.assertEquals(Check_URL, true);
        logger.info("types-of-binary-trees  page displayed......");

    }

    //implementation-in-python

    @Test(groups="regression")

    public void click_implementation_in_pythonLink(){

        HomePage Hp = new HomePage(BaseClass.getDriver());
        Hp.Login_HomePage();
        TreePage Tp = new TreePage (BaseClass.getDriver());
        DataStructurePage ds = new DataStructurePage(BaseClass.getDriver());
        Tp.click_TreeGetstarted();
        Tp.click_binary_treesLink();
        Tp.check_binary_treesPage();
        Tp.clickTryHerebutton();
        logger.info("Entering valid python code..........");
        ds.Click_DS_PythonEditor_Runbtn_ValidCodes();
        ds.click_DS_PythonEditor_RunBtn();
        ds.validate_Console_Output();

        logger.info("Console output.......     " +ds.ConsoleOutput_text + ds.PYEditor_Code);
        Assert.assertEquals(true,ds.PYEditor_Code.contains(ds.ConsoleOutput_text) );

    }
    //PythonEditorInvalidInput
    @Test(priority=30,groups="regression")
    public void check_PythonEditorInvalidInput5()
    {
        HomePage Hp = new HomePage(BaseClass.getDriver());
        Hp.Login_HomePage();
        TreePage Tp = new TreePage (BaseClass.getDriver());
        DataStructurePage ds = new DataStructurePage(BaseClass.getDriver());
        Tp.click_TreeGetstarted();
        Tp.click_binary_treesLink();
        Tp.check_binary_treesPage();

        Tp.clickTryHerebutton();
        logger.info("User Entering invalid python code on the editor ..... ");
        ds.Click_DS_PythonEditor_Runbtn_InValidCodes();
        ds.Validate_OutputConsole_InvalidCodes();
        logger.info("Alert Message in Python Editor " + ds.Alertmesg);
        Assert.assertEquals(true, ds.Alertmesg.contains("bad input on line 1"));

    }
    // PythonEditorNoInput
    @Test(priority=35,groups="regression")
    public void check_PythonEditorNoInput5()
    {
        HomePage Hp = new HomePage(BaseClass.getDriver());
        Hp.Login_HomePage();
        TreePage Tp = new TreePage (BaseClass.getDriver());
        DataStructurePage ds = new DataStructurePage(BaseClass.getDriver());
        Tp.click_TreeGetstarted();
        Tp.click_binary_treesLink();
        logger.info("user clicked binary-trees  link.........");
        Tp.check_binary_treesPage();
        logger.info("Redirecting to binary-trees page..............");
        Tp.clickTryHerebutton();
        ds.Click_DS_PythonEditor_Runbtn_WithoutCodes();
        String Current_URL = BaseClass.getDriver().getCurrentUrl();
        Assert.assertEquals(true, Current_URL.contains("tryEditor"));

    }

    //types-of-binary-trees
    @Test(priority=36,groups="regression")
    public void click_types_of_binary_treesLink() {
        HomePage Hp = new HomePage(BaseClass.getDriver());
        Hp.Login_HomePage();
        TreePage Tp = new TreePage (BaseClass.getDriver());
        Tp.click_TreeGetstarted();
        Tp.click_types_of_binary_treesLink();
        logger.info("user clicked  types-of-binary-trees Link .........");
        Tp.check_types_of_binary_treesPage();
        logger.info("Redirecting to types-of-binary-trees  page..............");
        boolean Check_URL=Tp.check_types_of_binary_treesPage();
        Assert.assertEquals(Check_URL, true);
        logger.info("types-of-binary-trees  page displayed......");

    } //TryHereButton
    @Test(priority=37,groups="regression")
    public void check_TryHereButton6()
    {
        HomePage Hp = new HomePage(BaseClass.getDriver());
        Hp.Login_HomePage();
        TreePage Tp = new TreePage (BaseClass.getDriver());
        DataStructurePage ds = new DataStructurePage(BaseClass.getDriver());
        Tp.click_TreeGetstarted();
        Tp.click_types_of_binary_treesLink();
        Tp.check_types_of_binary_treesPage();
        Tp.clickTryHerebutton();
        boolean status=Tp.check_TryEditorPage();
        Assert.assertEquals(status, true);
        logger.info("TryEditor page is displayed");
    }
    //PythonEditorValidInput
    @Test(priority=36,groups="regression")
    public void check_PythonEditorValidInput6()
    {
        HomePage Hp = new HomePage(BaseClass.getDriver());
        Hp.Login_HomePage();
        TreePage Tp = new TreePage (BaseClass.getDriver());
        DataStructurePage ds = new DataStructurePage(BaseClass.getDriver());
        Tp.click_TreeGetstarted();
        Tp.click_types_of_binary_treesLink();
        Tp.check_types_of_binary_treesPage();
        Tp.clickTryHerebutton();
        logger.info("Entering valid python code..........");
        ds.Click_DS_PythonEditor_Runbtn_ValidCodes();
        ds.click_DS_PythonEditor_RunBtn();
        ds.validate_Console_Output();

        logger.info("Console output.......     " +ds.ConsoleOutput_text + ds.PYEditor_Code);
        Assert.assertEquals(true,ds.PYEditor_Code.contains(ds.ConsoleOutput_text) );

    }
    //PythonEditorInvalidInput
    @Test(priority=37,groups="regression")
    public void check_PythonEditorInvalidInput6()
    {
        HomePage Hp = new HomePage(BaseClass.getDriver());
        Hp.Login_HomePage();
        TreePage Tp = new TreePage (BaseClass.getDriver());
        DataStructurePage ds = new DataStructurePage(BaseClass.getDriver());
        Tp.click_TreeGetstarted();
        Tp.click_types_of_binary_treesLink();
        Tp.check_types_of_binary_treesPage();

        Tp.clickTryHerebutton();
        logger.info("User Entering invalid python code on the editor ..... ");
        ds.Click_DS_PythonEditor_Runbtn_InValidCodes();
        ds.Validate_OutputConsole_InvalidCodes();
        logger.info("Alert Message in Python Editor " + ds.Alertmesg);
        Assert.assertEquals(true, ds.Alertmesg.contains("bad input on line 1"));

    }
    // PythonEditorNoInput
    @Test(priority=38,groups="regression")
    public void check_PythonEditorNoInput6()
    {
        HomePage Hp = new HomePage(BaseClass.getDriver());
        Hp.Login_HomePage();
        TreePage Tp = new TreePage (BaseClass.getDriver());
        DataStructurePage ds = new DataStructurePage(BaseClass.getDriver());
        Tp.click_TreeGetstarted();
        Tp.click_types_of_binary_treesLink();
        logger.info("user clicked types-of-binary-trees  link.........");
        Tp. check_types_of_binary_treesPage();
        logger.info("Redirecting to types-of-binary-trees page..............");
        Tp.clickTryHerebutton();
        ds.Click_DS_PythonEditor_Runbtn_WithoutCodes();
        String Current_URL = BaseClass.getDriver().getCurrentUrl();
        Assert.assertEquals(true, Current_URL.contains("tryEditor"));

    }

    //implementation-in-python
    @Test(priority=39,groups="regression")
    public void click_implementation_in_pythonLink_IIP(){
        HomePage Hp = new HomePage(BaseClass.getDriver());
        Hp.Login_HomePage();
        TreePage Tp = new TreePage (BaseClass.getDriver());
        Tp.click_TreeGetstarted();
        Tp.click_implementation_in_pythonLink();
        logger.info("user clicked  implementation-in-python Link .........");
        Tp.check_implementation_in_pythonPage();
        logger.info("Redirecting to implementation-in-python  page..............");
        boolean Check_URL=Tp.check_implementation_in_pythonPage();
        Assert.assertEquals(Check_URL, true);
        logger.info("implementation-in-python  page displayed......");

    } //TryHereButton
    @Test(priority=40,groups="regression")
    public void check_TryHereButton7()
    {
        HomePage Hp = new HomePage(BaseClass.getDriver());
        Hp.Login_HomePage();
        TreePage Tp = new TreePage (BaseClass.getDriver());
        DataStructurePage ds = new DataStructurePage(BaseClass.getDriver());
        Tp.click_TreeGetstarted();
        Tp.click_implementation_in_pythonLink();
        Tp.check_implementation_in_pythonPage();
        Tp.clickTryHerebutton();
        boolean status=Tp.check_TryEditorPage();
        Assert.assertEquals(status, true);
        logger.info("TryEditor page is displayed");
    }
    //PythonEditorValidInput
    @Test(priority=41,groups="regression")
    public void check_PythonEditorValidInput7()
    {
        HomePage Hp = new HomePage(BaseClass.getDriver());
        Hp.Login_HomePage();
        TreePage Tp = new TreePage (BaseClass.getDriver());
        DataStructurePage ds = new DataStructurePage(BaseClass.getDriver());
        Tp.click_TreeGetstarted();
        Tp.click_implementation_in_pythonLink();
        Tp.check_implementation_in_pythonPage();
        Tp.clickTryHerebutton();
        logger.info("Entering valid python code..........");
        ds.Click_DS_PythonEditor_Runbtn_ValidCodes();
        ds.click_DS_PythonEditor_RunBtn();
        ds.validate_Console_Output();

        logger.info("Console output.......     " +ds.ConsoleOutput_text + ds.PYEditor_Code);
        Assert.assertEquals(true,ds.PYEditor_Code.contains(ds.ConsoleOutput_text) );

    }
    //PythonEditorInvalidInput
    @Test(priority=42,groups="regression")
    public void check_PythonEditorInvalidInput7()
    {
        HomePage Hp = new HomePage(BaseClass.getDriver());
        Hp.Login_HomePage();
        TreePage Tp = new TreePage (BaseClass.getDriver());
        DataStructurePage ds = new DataStructurePage(BaseClass.getDriver());
        Tp.click_TreeGetstarted();
        Tp.click_implementation_in_pythonLink();
        Tp.check_implementation_in_pythonPage();

        Tp.clickTryHerebutton();
        logger.info("User Entering invalid python code on the editor ..... ");
        ds.Click_DS_PythonEditor_Runbtn_InValidCodes();
        ds.Validate_OutputConsole_InvalidCodes();
        logger.info("Alert Message in Python Editor " + ds.Alertmesg);
        Assert.assertEquals(true, ds.Alertmesg.contains("bad input on line 1"));

    }
    // PythonEditorNoInput
    @Test(priority=43,groups="regression")
    public void check_PythonEditorNoInput7()
    {
        HomePage Hp = new HomePage(BaseClass.getDriver());
        Hp.Login_HomePage();
        TreePage Tp = new TreePage (BaseClass.getDriver());
        DataStructurePage ds = new DataStructurePage(BaseClass.getDriver());
        Tp.click_TreeGetstarted();
        Tp.click_implementation_in_pythonLink();
        logger.info("user clicked implementation-in-python  link.........");
        Tp. check_implementation_in_pythonPage();
        logger.info("Redirecting to implementation-in-python page..............");
        Tp.clickTryHerebutton();
        ds.Click_DS_PythonEditor_Runbtn_WithoutCodes();
        String Current_URL = BaseClass.getDriver().getCurrentUrl();
        Assert.assertEquals(true, Current_URL.contains("tryEditor"));

    }

    //Binary Tree Traversals

    @Test(priority=44,groups="regression")
    public void click_BinaryTreeTraversalsLink(){
        HomePage Hp = new HomePage(BaseClass.getDriver());
        Hp.Login_HomePage();
        TreePage Tp = new TreePage (BaseClass.getDriver());
        Tp.click_TreeGetstarted();
        Tp.click_BinaryTreeTraversalsLink();
        logger.info("user clicked  Binary Tree Traversals Link .........");
        Tp.check_BinaryTreeTraversalsPage();
        logger.info("Redirecting to Binary Tree Traversals  page..............");
        boolean Check_URL=Tp.check_BinaryTreeTraversalsPage();
        Assert.assertEquals(Check_URL, true);
        logger.info("Binary Tree Traversals page displayed......");

    } //TryHereButton
    @Test(priority=45,groups="regression")
    public void check_TryHereButton8()
    {
        HomePage Hp = new HomePage(BaseClass.getDriver());
        Hp.Login_HomePage();
        TreePage Tp = new TreePage (BaseClass.getDriver());
        DataStructurePage ds = new DataStructurePage(BaseClass.getDriver());
        Tp.click_TreeGetstarted();
        Tp.click_BinaryTreeTraversalsLink();
        Tp.check_BinaryTreeTraversalsPage();
        Tp.clickTryHerebutton();
        boolean status=Tp.check_TryEditorPage();
        Assert.assertEquals(status, true);
        logger.info("TryEditor page is displayed");
    }
    //PythonEditorValidInput
    @Test(priority=46,groups="regression")
    public void check_PythonEditorValidInput8()
    {
        HomePage Hp = new HomePage(BaseClass.getDriver());
        Hp.Login_HomePage();
        TreePage Tp = new TreePage (BaseClass.getDriver());
        DataStructurePage ds = new DataStructurePage(BaseClass.getDriver());
        Tp.click_TreeGetstarted();
        Tp.click_BinaryTreeTraversalsLink();
        Tp.check_BinaryTreeTraversalsPage();
        Tp.clickTryHerebutton();
        logger.info("Entering valid python code..........");
        ds.Click_DS_PythonEditor_Runbtn_ValidCodes();
        ds.click_DS_PythonEditor_RunBtn();
        ds.validate_Console_Output();

        logger.info("Console output.......     " +ds.ConsoleOutput_text + ds.PYEditor_Code);
        Assert.assertEquals(true,ds.PYEditor_Code.contains(ds.ConsoleOutput_text) );

    }
    //PythonEditorInvalidInput
    @Test(priority=47,groups="regression")
    public void check_PythonEditorInvalidInput8()
    {
        HomePage Hp = new HomePage(BaseClass.getDriver());
        Hp.Login_HomePage();
        TreePage Tp = new TreePage (BaseClass.getDriver());
        DataStructurePage ds = new DataStructurePage(BaseClass.getDriver());
        Tp.click_TreeGetstarted();
        Tp.click_BinaryTreeTraversalsLink();
        Tp.check_BinaryTreeTraversalsPage();

        Tp.clickTryHerebutton();
        logger.info("User Entering invalid python code on the editor ..... ");
        ds.Click_DS_PythonEditor_Runbtn_InValidCodes();
        ds.Validate_OutputConsole_InvalidCodes();
        logger.info("Alert Message in Python Editor " + ds.Alertmesg);
        Assert.assertEquals(true, ds.Alertmesg.contains("bad input on line 1"));

    }
    // PythonEditorNoInput
    @Test(priority=48,groups="regression")
    public void check_PythonEditorNoInput8()
    {
        HomePage Hp = new HomePage(BaseClass.getDriver());
        Hp.Login_HomePage();
        TreePage Tp = new TreePage (BaseClass.getDriver());
        DataStructurePage ds = new DataStructurePage(BaseClass.getDriver());
        Tp.click_TreeGetstarted();
        Tp.click_BinaryTreeTraversalsLink();
        logger.info("user clicked Binary Tree Traversals link.........");
        Tp. check_BinaryTreeTraversalsPage();
        logger.info("Redirecting to Binary Tree Traversals page..............");
        Tp.clickTryHerebutton();
        ds.Click_DS_PythonEditor_Runbtn_WithoutCodes();
        String Current_URL = BaseClass.getDriver().getCurrentUrl();
        Assert.assertEquals(true, Current_URL.contains("tryEditor"));

    }

    //Implementation of Binary Trees

    @Test(priority=49,groups="regression")
    public void click_ImplementationofBinaryTreesLink(){
        HomePage Hp = new HomePage(BaseClass.getDriver());
        Hp.Login_HomePage();
        TreePage Tp = new TreePage (BaseClass.getDriver());
        Tp.click_TreeGetstarted();
        Tp.click_ImplementationofBinaryTreesLink();
        logger.info("user clicked Implementation of Binary Trees Link .........");
        Tp.check_ImplementationofBinaryTreesPage();
        boolean Check_URL= Tp.check_ImplementationofBinaryTreesPage();
        Assert.assertEquals(Check_URL, true);
        logger.info("Implementation of Binary Trees page displayed......");

    } //TryHereButton
    @Test(priority=50,groups="regression")
    public void check_TryHereButton9()
    {
        HomePage Hp = new HomePage(BaseClass.getDriver());
        Hp.Login_HomePage();
        TreePage Tp = new TreePage (BaseClass.getDriver());
        DataStructurePage ds = new DataStructurePage(BaseClass.getDriver());
        Tp.click_TreeGetstarted();
        Tp.click_ImplementationofBinaryTreesLink();
        Tp.check_ImplementationofBinaryTreesPage();
        Tp.clickTryHerebutton();
        boolean status=Tp.check_TryEditorPage();
        Assert.assertEquals(status, true);
        logger.info("TryEditor page is displayed");
    }
    //PythonEditorValidInput
    @Test(priority=51,groups="regression")
    public void check_PythonEditorValidInput9()
    {
        HomePage Hp = new HomePage(BaseClass.getDriver());
        Hp.Login_HomePage();
        TreePage Tp = new TreePage (BaseClass.getDriver());
        DataStructurePage ds = new DataStructurePage(BaseClass.getDriver());
        Tp.click_TreeGetstarted();
        Tp.click_ImplementationofBinaryTreesLink();
        Tp.check_ImplementationofBinaryTreesPage();
        Tp.clickTryHerebutton();
        logger.info("Entering valid python code..........");
        ds.Click_DS_PythonEditor_Runbtn_ValidCodes();
        ds.click_DS_PythonEditor_RunBtn();
        ds.validate_Console_Output();

        logger.info("Console output.......     " +ds.ConsoleOutput_text + ds.PYEditor_Code);
        Assert.assertEquals(true,ds.PYEditor_Code.contains(ds.ConsoleOutput_text) );

    }
    //PythonEditorInvalidInput
    @Test(priority=52,groups="regression")
    public void check_PythonEditorInvalidInput9()
    {
        HomePage Hp = new HomePage(BaseClass.getDriver());
        Hp.Login_HomePage();
        TreePage Tp = new TreePage (BaseClass.getDriver());
        DataStructurePage ds = new DataStructurePage(BaseClass.getDriver());
        Tp.click_TreeGetstarted();
        Tp.click_ImplementationofBinaryTreesLink();
        Tp.check_ImplementationofBinaryTreesPage();

        Tp.clickTryHerebutton();
        logger.info("User Entering invalid python code on the editor ..... ");
        ds.Click_DS_PythonEditor_Runbtn_InValidCodes();
        ds.Validate_OutputConsole_InvalidCodes();
        logger.info("Alert Message in Python Editor " + ds.Alertmesg);
        Assert.assertEquals(true, ds.Alertmesg.contains("bad input on line 1"));

    }
    // PythonEditorNoInput
    @Test(priority=53,groups="regression")
    public void check_PythonEditorNoInput9()
    {
        HomePage Hp = new HomePage(BaseClass.getDriver());
        Hp.Login_HomePage();
        TreePage Tp = new TreePage (BaseClass.getDriver());
        DataStructurePage ds = new DataStructurePage(BaseClass.getDriver());
        Tp.click_TreeGetstarted();
        Tp.click_ImplementationofBinaryTreesLink();
        logger.info("user clicked Implementation of Binary Trees link.........");
        Tp. check_ImplementationofBinaryTreesPage();
        logger.info("Redirecting to Implementation of Binary Treespage..............");
        Tp.clickTryHerebutton();
        ds.Click_DS_PythonEditor_Runbtn_WithoutCodes();
        String Current_URL = BaseClass.getDriver().getCurrentUrl();
        Assert.assertEquals(true, Current_URL.contains("tryEditor"));

    }

    //Applications of Binary trees

    @Test(priority=54,groups="regression")
    public void click_ApplicationsofBinarytreesLink(){
        HomePage Hp = new HomePage(BaseClass.getDriver());
        Hp.Login_HomePage();
        TreePage Tp = new TreePage (BaseClass.getDriver());
        Tp.click_TreeGetstarted();
        Tp.click_ApplicationsofBinarytreesLink();
        logger.info("user clicked Applications of Binary trees Link .........");
        Tp.check_ApplicationsofBinarytreesPage();
        boolean Check_URL=   Tp.check_ApplicationsofBinarytreesPage();
        Assert.assertEquals(Check_URL, true);
        logger.info("Applications of Binary trees page displayed......");

    }  //TryHereButton
    @Test(priority=55,groups="regression")
    public void check_TryHereButton10()
    {
        HomePage Hp = new HomePage(BaseClass.getDriver());
        Hp.Login_HomePage();
        TreePage Tp = new TreePage (BaseClass.getDriver());
        DataStructurePage ds = new DataStructurePage(BaseClass.getDriver());
        Tp.click_TreeGetstarted();
        Tp.click_ApplicationsofBinarytreesLink();
        Tp.check_ApplicationsofBinarytreesPage();
        Tp.clickTryHerebutton();
        boolean status=Tp.check_TryEditorPage();
        Assert.assertEquals(status, true);
        logger.info("TryEditor page is displayed");
    }
    //PythonEditorValidInput
    @Test(priority=56,groups="regression")
    public void check_PythonEditorValidInput10()
    {
        HomePage Hp = new HomePage(BaseClass.getDriver());
        Hp.Login_HomePage();
        TreePage Tp = new TreePage (BaseClass.getDriver());
        DataStructurePage ds = new DataStructurePage(BaseClass.getDriver());
        Tp.click_TreeGetstarted();
        Tp.click_ApplicationsofBinarytreesLink();
        Tp.check_ApplicationsofBinarytreesPage();
        Tp.clickTryHerebutton();
        logger.info("Entering valid python code..........");
        ds.Click_DS_PythonEditor_Runbtn_ValidCodes();
        ds.click_DS_PythonEditor_RunBtn();
        ds.validate_Console_Output();

        logger.info("Console output.......     " +ds.ConsoleOutput_text + ds.PYEditor_Code);
        Assert.assertEquals(true,ds.PYEditor_Code.contains(ds.ConsoleOutput_text) );

    }
    //PythonEditorInvalidInput
    @Test(priority=57,groups="regression")
    public void check_PythonEditorInvalidInput10()
    {
        HomePage Hp = new HomePage(BaseClass.getDriver());
        Hp.Login_HomePage();
        TreePage Tp = new TreePage (BaseClass.getDriver());
        DataStructurePage ds = new DataStructurePage(BaseClass.getDriver());
        Tp.click_TreeGetstarted();
        Tp.click_ApplicationsofBinarytreesLink();
        Tp.check_ApplicationsofBinarytreesPage();

        Tp.clickTryHerebutton();
        logger.info("User Entering invalid python code on the editor ..... ");
        ds.Click_DS_PythonEditor_Runbtn_InValidCodes();
        ds.Validate_OutputConsole_InvalidCodes();
        logger.info("Alert Message in Python Editor " + ds.Alertmesg);
        Assert.assertEquals(true, ds.Alertmesg.contains("bad input on line 1"));

    }
    // PythonEditorNoInput
    @Test(priority=58,groups="regression")
    public void check_PythonEditorNoInput10()
    {
        HomePage Hp = new HomePage(BaseClass.getDriver());
        Hp.Login_HomePage();
        TreePage Tp = new TreePage (BaseClass.getDriver());
        DataStructurePage ds = new DataStructurePage(BaseClass.getDriver());
        Tp.click_TreeGetstarted();
        Tp.click_ApplicationsofBinarytreesLink();
        logger.info("user clicked Applications of Binary treeslink.........");
        Tp. check_ApplicationsofBinarytreesPage();
        logger.info("Redirecting to Applications of Binary treesTreespage..............");
        Tp.clickTryHerebutton();
        ds.Click_DS_PythonEditor_Runbtn_WithoutCodes();
        String Current_URL = BaseClass.getDriver().getCurrentUrl();
        Assert.assertEquals(true, Current_URL.contains("tryEditor"));

    }

    //Binary Search Trees

    @Test(priority=59,groups="regression")
    public void click_BinarySearchTreesLink(){
        HomePage Hp = new HomePage(BaseClass.getDriver());
        Hp.Login_HomePage();
        TreePage Tp = new TreePage (BaseClass.getDriver());
        Tp.click_TreeGetstarted();
        Tp.click_BinarySearchTreesLink();
        logger.info("user clicked Binary Search Trees Link .........");
        Tp.check_BinarySearchTreesPage();
        boolean Check_URL=   Tp.check_BinarySearchTreesPage();
        Assert.assertEquals(Check_URL, true);
        logger.info("Binary Search Trees page displayed......");

    } //TryHereButton
    @Test(priority=60,groups="regression")
    public void check_TryHereButton11()
    {
        HomePage Hp = new HomePage(BaseClass.getDriver());
        Hp.Login_HomePage();
        TreePage Tp = new TreePage (BaseClass.getDriver());
        DataStructurePage ds = new DataStructurePage(BaseClass.getDriver());
        Tp.click_TreeGetstarted();
        Tp.click_BinarySearchTreesLink();
        Tp.check_BinarySearchTreesPage();
        Tp.clickTryHerebutton();
        boolean status=Tp.check_TryEditorPage();
        Assert.assertEquals(status, true);
        logger.info("TryEditor page is displayed");
    }
    //PythonEditorValidInput
    @Test(priority=61,groups="regression")
    public void check_PythonEditorValidInput11()
    {
        HomePage Hp = new HomePage(BaseClass.getDriver());
        Hp.Login_HomePage();
        TreePage Tp = new TreePage (BaseClass.getDriver());
        DataStructurePage ds = new DataStructurePage(BaseClass.getDriver());
        Tp.click_TreeGetstarted();
        Tp.click_BinarySearchTreesLink();
        Tp.check_BinarySearchTreesPage();
        Tp.clickTryHerebutton();
        logger.info("Entering valid python code..........");
        ds.Click_DS_PythonEditor_Runbtn_ValidCodes();
        ds.click_DS_PythonEditor_RunBtn();
        ds.validate_Console_Output();

        logger.info("Console output.......     " +ds.ConsoleOutput_text + ds.PYEditor_Code);
        Assert.assertEquals(true,ds.PYEditor_Code.contains(ds.ConsoleOutput_text) );

    }
    //PythonEditorInvalidInput
    @Test(priority=62,groups="regression")
    public void check_PythonEditorInvalidInput11()
    {
        HomePage Hp = new HomePage(BaseClass.getDriver());
        Hp.Login_HomePage();
        TreePage Tp = new TreePage (BaseClass.getDriver());
        DataStructurePage ds = new DataStructurePage(BaseClass.getDriver());
        Tp.click_TreeGetstarted();
        Tp.click_BinarySearchTreesLink();
        Tp.check_BinarySearchTreesPage();

        Tp.clickTryHerebutton();
        logger.info("User Entering invalid python code on the editor ..... ");
        ds.Click_DS_PythonEditor_Runbtn_InValidCodes();
        ds.Validate_OutputConsole_InvalidCodes();
        logger.info("Alert Message in Python Editor " + ds.Alertmesg);
        Assert.assertEquals(true, ds.Alertmesg.contains("bad input on line 1"));}


    // PythonEditorNoInput
    @Test(priority=63,groups="regression")
    public void check_PythonEditorNoInput11()
    {
        HomePage Hp = new HomePage(BaseClass.getDriver());
        Hp.Login_HomePage();
        TreePage Tp = new TreePage (BaseClass.getDriver());
        DataStructurePage ds = new DataStructurePage(BaseClass.getDriver());
        Tp.click_TreeGetstarted();
        Tp.click_BinarySearchTreesLink();
        logger.info("user clicked Binary Search Trees link.........");
        Tp. check_BinarySearchTreesPage();
        logger.info("Redirecting to Binary Search trees Treespage..............");
        Tp.clickTryHerebutton();
        ds.Click_DS_PythonEditor_Runbtn_WithoutCodes();
        String Current_URL = BaseClass.getDriver().getCurrentUrl();
        Assert.assertEquals(true, Current_URL.contains("tryEditor"));

    }

    //ImplementationOfBST


    @Test(priority=64,groups="regression")
    public void click_ImplementationOfBSTLink() {
        HomePage Hp = new HomePage(BaseClass.getDriver());
        Hp.Login_HomePage();
        TreePage Tp = new TreePage (BaseClass.getDriver());
        Tp.click_TreeGetstarted();
        Tp.click_ImplementationOfBSTLink();
        logger.info("user clicked ImplementationOfBST Link .........");
        Tp.check_ImplementationOfBSTPage();
        boolean Check_URL= Tp.check_ImplementationOfBSTPage();
        Assert.assertEquals(Check_URL, true);
        logger.info("ImplementationOfBST page displayed......");

    }//TryHereButton
    @Test(priority=65,groups="regression")
    public void check_TryHereButton12()
    {
        HomePage Hp = new HomePage(BaseClass.getDriver());
        Hp.Login_HomePage();
        TreePage Tp = new TreePage (BaseClass.getDriver());
        DataStructurePage ds = new DataStructurePage(BaseClass.getDriver());
        Tp.click_TreeGetstarted();
        Tp.click_ImplementationOfBSTLink();
        Tp.check_ImplementationOfBSTPage();
        Tp.clickTryHerebutton();
        boolean status=Tp.check_TryEditorPage();
        Assert.assertEquals(status, true);
        logger.info("TryEditor page is displayed");
    }
    //PythonEditorValidInput
    @Test(priority=66,groups="regression")
    public void check_PythonEditorValidInput12()
    {
        HomePage Hp = new HomePage(BaseClass.getDriver());
        Hp.Login_HomePage();
        TreePage Tp = new TreePage (BaseClass.getDriver());
        DataStructurePage ds = new DataStructurePage(BaseClass.getDriver());
        Tp.click_TreeGetstarted();
        Tp.click_ImplementationOfBSTLink();
        Tp.check_ImplementationOfBSTPage();
        Tp.clickTryHerebutton();
        logger.info("Entering valid python code..........");
        ds.Click_DS_PythonEditor_Runbtn_ValidCodes();
        ds.click_DS_PythonEditor_RunBtn();
        ds.validate_Console_Output();

        logger.info("Console output.......     " +ds.ConsoleOutput_text + ds.PYEditor_Code);
        Assert.assertEquals(true,ds.PYEditor_Code.contains(ds.ConsoleOutput_text) );

    }
    //PythonEditorInvalidInput
    @Test(priority=67,groups="regression")
    public void check_PythonEditorInvalidInput12()
    {
        HomePage Hp = new HomePage(BaseClass.getDriver());
        Hp.Login_HomePage();
        TreePage Tp = new TreePage (BaseClass.getDriver());
        DataStructurePage ds = new DataStructurePage(BaseClass.getDriver());
        Tp.click_TreeGetstarted();
        Tp.click_ImplementationOfBSTLink();
        Tp.check_ImplementationOfBSTPage();

        Tp.clickTryHerebutton();
        logger.info("User Entering invalid python code on the editor ..... ");
        ds.Click_DS_PythonEditor_Runbtn_InValidCodes();
        ds.Validate_OutputConsole_InvalidCodes();
        logger.info("Alert Message in Python Editor " + ds.Alertmesg);
        Assert.assertEquals(true, ds.Alertmesg.contains("bad input on line 1"));}


    // PythonEditorNoInput
    @Test(priority=68,groups="regression")
    public void check_PythonEditorNoInput12()
    {
        HomePage Hp = new HomePage(BaseClass.getDriver());
        Hp.Login_HomePage();
        TreePage Tp = new TreePage (BaseClass.getDriver());
        DataStructurePage ds = new DataStructurePage(BaseClass.getDriver());
        Tp.click_TreeGetstarted();
        Tp.click_ImplementationOfBSTLink();
        logger.info("user clicked ImplementationOfBST link.........");
        Tp. check_ImplementationOfBSTPage();
        logger.info("Redirecting to ImplementationOfBST Treespage..............");
        Tp.clickTryHerebutton();
        ds.Click_DS_PythonEditor_Runbtn_WithoutCodes();
        String Current_URL = BaseClass.getDriver().getCurrentUrl();
        Assert.assertEquals(true, Current_URL.contains("tryEditor"));

    }

    //PracticeQns

    @Test(priority=69,groups="regression")
    public void click_PracticeQnsLink()
    {
        HomePage Hp = new HomePage(BaseClass.getDriver());
        Hp.Login_HomePage();

        TreePage Tp = new TreePage (BaseClass.getDriver());
        Tp.click_TreeGetstarted();
        Tp.click_ImplementationOfBSTLink();

        Tp.click_PracticeQnsLink();
        logger.info("user clicked PracticeQns Link .........");
        Tp.check_PracticeQnsPage();
        boolean status = Tp.check_PracticeQnsPage();
        Assert.assertEquals(status, true);
        logger.info("redirected to practice qn page............");


    }

}


package testCases;

import factory.Hooks;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.Assert;
import java.util.HashMap;
import java.util.List;
import org.apache.logging.log4j.Logger;
import factory.BaseClass;
import pageObject.ArrayPage;
import pageObject.DataStructurePage;
import pageObject.HomePage;
import utilities.DataReader;

public class ArrayPageTests extends Hooks {

    Logger logger = BaseClass.getLogger();
    String AlertMessage = "";

    List<HashMap<String, String>> datamap = DataReader.data(".\\testData\\Python_Editor_Data.xlsx", "Sheet1");;

    @Test(priority = 0)
    public void Test_ArraysInPython() {
        HomePage Hp = new HomePage(BaseClass.getDriver());

        Hp.Login_HomePage();

        Hp.clickArrayGetStarted();
        ArrayPage Ap = new ArrayPage(BaseClass.getDriver());
        Ap.Click_ArraysInPython_Btn();

        String CurrentURL = BaseClass.getDriver().getCurrentUrl();

        Assert.assertEquals(CurrentURL, CurrentURL.contains("python"));


    }

    @Test(priority = 1)
    public void Test_ArraysUsingList() {

        HomePage Hp = new HomePage(BaseClass.getDriver());
        Hp.Login_HomePage();
        Hp.clickArrayGetStarted();
        ArrayPage Ap = new ArrayPage(BaseClass.getDriver());
        Ap.Click_ArraysUsingList_Btn();


        String CurrentURL = BaseClass.getDriver().getCurrentUrl();
        Assert.assertEquals(true, CurrentURL.contains("using"));

    }

    @Test(priority = 2)
    public void Test_BasicOpeartions() {

        HomePage Hp = new HomePage(BaseClass.getDriver());
        Hp.Login_HomePage();
        Hp.clickArrayGetStarted();
        ArrayPage Ap = new ArrayPage(BaseClass.getDriver());
        Ap.Click_BasicOperations_Btn();
        String CurrentURL = BaseClass.getDriver().getCurrentUrl();


        Assert.assertEquals(true, CurrentURL.contains("operations"));

    }

    @Test(priority = 3)
    public void Test_ApplicationsOfArray() {

        HomePage Hp = new HomePage(BaseClass.getDriver());
        Hp.Login_HomePage();
        Hp.clickArrayGetStarted();
        ArrayPage Ap = new ArrayPage(BaseClass.getDriver());
        Ap.Click_ApplicationsOfArray_Btn();
        String CurrentURL = BaseClass.getDriver().getCurrentUrl();
        Assert.assertEquals(true, CurrentURL.contains("applications"));


    }


    @Test(priority =4 )
    public void Test_TryHere_arraysUsingList() {
        HomePage Hp = new HomePage(BaseClass.getDriver());
        Hp.Login_HomePage();
        Hp.clickArrayGetStarted();
        ArrayPage Ap = new ArrayPage(BaseClass.getDriver());
        Ap.Click_ArraysUsingList_Btn();
        Ap.Click_TryhereBtn();
        String CurURL = BaseClass.getDriver().getCurrentUrl();

        Assert.assertEquals(true, CurURL.contains("tryEditor"));


    }
    // Basic Operations Page Scenarios

    @Test(priority = 5)
    public void Test_TryHere_basicOpeartions() {
        HomePage Hp = new HomePage(BaseClass.getDriver());
        Hp.Login_HomePage();
        Hp.clickArrayGetStarted();
        ArrayPage Ap = new ArrayPage(BaseClass.getDriver());
        Ap.Click_BasicOperations_Btn();
        Ap.Click_TryhereBtn();
        String CurURL = BaseClass.getDriver().getCurrentUrl();

        Assert.assertEquals(true, CurURL.contains("tryEditor"));


    }

    @Test(priority = 6)
    public void Test_basicOpeartions_EditorPage_ValidCodes() {

        HomePage Hp = new HomePage(BaseClass.getDriver());
        Hp.Login_HomePage();
        Hp.clickArrayGetStarted();
        ArrayPage Ap = new ArrayPage(BaseClass.getDriver());
        Ap.Click_BasicOperations_Btn();
        DataStructurePage Dp = new DataStructurePage(BaseClass.getDriver());
        Ap.Click_TryhereBtn();
        Dp.Click_DS_PythonEditor_Runbtn_ValidCodes();
        Dp.click_DS_PythonEditor_RunBtn();
        Dp.validate_Console_Output();

        logger.info("Console output.......     " + Dp.ConsoleOutput_text + Dp.PYEditor_Code);


        Assert.assertEquals(true, Dp.PYEditor_Code.contains(Dp.ConsoleOutput_text));

    }

    @Test(priority = 7)
    public void Test_basicOpeartions_EditorPage_InValidCodes() {
        HomePage Hp = new HomePage(BaseClass.getDriver());
        Hp.Login_HomePage();
        Hp.clickArrayGetStarted();
        ArrayPage Ap = new ArrayPage(BaseClass.getDriver());
        Ap.Click_BasicOperations_Btn();
        Ap.Click_TryhereBtn();
        DataStructurePage Dp = new DataStructurePage(BaseClass.getDriver());
        Dp.Click_DS_PythonEditor_Runbtn_InValidCodes();
        Dp.Validate_OutputConsole_InvalidCodes();
        logger.info("Alert Message in Python Editor " + Dp.Alertmesg);

        Assert.assertEquals(true, Dp.Alertmesg.contains("bad input on line 1"));


    }

    @Test(priority = 8)
    public void Test_basicOpeations_EditorPage_WithoutCodes() {
        HomePage Hp = new HomePage(BaseClass.getDriver());
        Hp.Login_HomePage();
        Hp.clickArrayGetStarted();
        ArrayPage Ap = new ArrayPage(BaseClass.getDriver());
        Ap.Click_BasicOperations_Btn();
        DataStructurePage Dp = new DataStructurePage(BaseClass.getDriver());
        Ap.Click_TryhereBtn();
        Dp.Click_DS_PythonEditor_Runbtn_WithoutCodes();
        String crntURL = BaseClass.getDriver().getCurrentUrl();
        Assert.assertEquals(true, crntURL.contains("tryEditor"));
    }

    // Applications of array Page Scenarios

    @Test(priority = 9)
    public void Test_TryHere_applicationsOfArray() {
        HomePage Hp = new HomePage(BaseClass.getDriver());
        Hp.Login_HomePage();
        Hp.clickArrayGetStarted();
        ArrayPage Ap = new ArrayPage(BaseClass.getDriver());
        Ap.Click_ApplicationsOfArray_Btn();
        Ap.Click_TryhereBtn();
        String CurURL = BaseClass.getDriver().getCurrentUrl();

        Assert.assertEquals(true, CurURL.contains("tryEditor"));

    }

    @Test(priority = 10)
    public void Test_applicationsOfarray_EditorPage_InValidCodes() {
        HomePage Hp = new HomePage(BaseClass.getDriver());
        Hp.Login_HomePage();
        Hp.clickArrayGetStarted();
        ArrayPage Ap = new ArrayPage(BaseClass.getDriver());
        Ap.Click_ApplicationsOfArray_Btn();
        Ap.Click_TryhereBtn();
        DataStructurePage Dp = new DataStructurePage(BaseClass.getDriver());
        Dp.Click_DS_PythonEditor_Runbtn_InValidCodes();
        Dp.Validate_OutputConsole_InvalidCodes();
        logger.info("Alert Message in Python Editor " + Dp.Alertmesg);

        Assert.assertEquals(true, Dp.Alertmesg.contains("bad input on line 1"));

    }


    @Test(priority = 11)
    public void Test_LeftPanel_ArraysInPython() {
        HomePage Hp = new HomePage(BaseClass.getDriver());
        Hp.Login_HomePage();
        Hp.clickArrayGetStarted();
        ArrayPage Ap = new ArrayPage(BaseClass.getDriver());
        Ap.Click_ArraysInPython_Btn();
        Ap.Click_LeftPanel_ArraysInPyhton_Btn();
        String CurrentURL = BaseClass.getDriver().getCurrentUrl();

        Assert.assertEquals(true, CurrentURL.contains("python"));


    }

    @Test(priority = 12)
    public void Test_LeftPanel_ArraysUsingList() {
        HomePage Hp = new HomePage(BaseClass.getDriver());
        Hp.Login_HomePage();
        Hp.clickArrayGetStarted();
        ArrayPage Ap = new ArrayPage(BaseClass.getDriver());
        Ap.Click_ArraysInPython_Btn();
        Ap.Click_LeftPanel_ArraysUsingList_Btn();
        String CurrentURL = BaseClass.getDriver().getCurrentUrl();

        Assert.assertEquals(true, CurrentURL.contains("using"));

    }

    @Test(priority = 13)
    public void Test_LeftPanel_BasicOperations() {
        HomePage Hp = new HomePage(BaseClass.getDriver());
        Hp.Login_HomePage();
        Hp.clickArrayGetStarted();
        ArrayPage Ap = new ArrayPage(BaseClass.getDriver());
        Ap.Click_ArraysInPython_Btn();
        Ap.Click_LeftPanel_BasicOpeartionsInList_Btn();
        String CurrentURL = BaseClass.getDriver().getCurrentUrl();

        Assert.assertEquals(true, CurrentURL.contains("operations"));

    }

    @Test(priority = 14)
    public void Test_LeftPanel_ApplicationsOfArray() {
        HomePage Hp = new HomePage(BaseClass.getDriver());
        Hp.Login_HomePage();
        Hp.clickArrayGetStarted();
        ArrayPage Ap = new ArrayPage(BaseClass.getDriver());
        Ap.Click_ArraysInPython_Btn();
        Ap.Click_LeftPanel_ApplicationsOFArray_Btn();
        String CurrentURL = BaseClass.getDriver().getCurrentUrl();

        Assert.assertEquals(true, CurrentURL.contains("applications"));

    }

    @Test(priority = 15)
    public void Test_LeftPanel_PracticeQuestions() {
        HomePage Hp = new HomePage(BaseClass.getDriver());
        Hp.Login_HomePage();
        Hp.clickArrayGetStarted();
        ArrayPage Ap = new ArrayPage(BaseClass.getDriver());
        Ap.Click_ArraysInPython_Btn();
        Ap.Click_PracticeQuestion_Btn();
        String CurrentURL = BaseClass.getDriver().getCurrentUrl();

        Assert.assertEquals(true, CurrentURL.contains("practice"));

    }



}

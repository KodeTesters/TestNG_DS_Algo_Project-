package testCases;

import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import factory.BaseClass;
import factory.Hooks;
import pageObject.DataStructurePage;
import pageObject.HomePage;
import pageObject.QueuePage;

public class QueuePageTests extends Hooks{
    Logger logger = BaseClass.getLogger();



    @Test   (priority=0)
    void Test_Queue_GetStarted()
    {
        HomePage Hp = new HomePage(BaseClass.getDriver());
        Hp.Login_HomePage();
        Hp.clickQueueGetStarted();
        String CurntURL= BaseClass.getDriver().getCurrentUrl();
        Assert.assertEquals(true,CurntURL.contains("queue"));
        logger.info("Queue Page URL --->" + CurntURL);
    }


    @Test  (priority=1)
    void Test_ImplementationOf_Queue_InPython()
    {

        QueuePage Qp = new QueuePage (BaseClass.getDriver());
        Qp.Click_Getstarted_homePage_Queue();
        Qp.Click_ImplementaionOfQueue();

        String CrtURL = BaseClass.getDriver().getCurrentUrl();
        Assert.assertEquals(true, CrtURL.contains("lists"));
    }


    @Test  (priority=2)
    void Test_Implementation_UsingCollections_Queue()
    {
        QueuePage Qp = new QueuePage (BaseClass.getDriver());
        Qp.Click_Getstarted_homePage_Queue();
        Qp.Click_ImplemenUsingCollectionOfQueue();
        String CurrentURL = BaseClass.getDriver().getCurrentUrl();
        Assert.assertEquals(true, CurrentURL.contains("collections"));
    }


    @Test  (priority=3)
    void Test_ImplementationUsing_Array()
    {
        logger.info("The user clicks the Implementation using Array link ........" );
        QueuePage Qp = new QueuePage (BaseClass.getDriver());
        Qp.Click_Getstarted_homePage_Queue();
        Qp.Click_ImplemenUsingArry();
        String CurrentURL = BaseClass.getDriver().getCurrentUrl();
        Assert.assertEquals(true, CurrentURL.contains("array"));
        logger.info("Implementation using Array link Current URL " + CurrentURL);
    }

    @Test  (priority=4)
    void Test_QueueOperations()
    {

        QueuePage Qp = new QueuePage (BaseClass.getDriver());
        Qp.Click_Getstarted_homePage_Queue();
        Qp.Click_QueueOperation();
        String CurrentURL = BaseClass.getDriver().getCurrentUrl();
        logger.info("After clicking Queue Operations link URL ... " +CurrentURL );
        Assert.assertEquals(true, CurrentURL.contains("QueueOp"));

    }

    @Test  (priority=5)
    void Test_LEFTPanel_ImplementationOf_Queue_InPython()
    {
        QueuePage Qp = new QueuePage (BaseClass.getDriver());
        Qp.Click_Getstarted_homePage_Queue();
        Qp.Click_ImplementaionOfQueue();
        Qp.Click_ImplementaionOfQueue();
        String CurrentURL = BaseClass.getDriver().getCurrentUrl();
        Assert.assertEquals(true, CurrentURL.contains("lists"));

    }


    @Test  (priority=6)
    void Test_LEFTPanel_Implementation_UsingCollections_Queue()
    {

        QueuePage Qp = new QueuePage (BaseClass.getDriver());
        Qp.Click_Getstarted_homePage_Queue();
        Qp.Click_ImplementaionOfQueue();
        logger.info("Clicking the Implementation using collections.queue  from the left panel links........ ");
        Qp.Click_ImplemenUsingCollectionOfQueue();
        String CurrentURL = BaseClass.getDriver().getCurrentUrl();
        Assert.assertEquals(true, CurrentURL.contains("collections"));

    }

    @Test  (priority=7)
    void Test_LEFTPanel_ImplementaionUsing_Array()
    {
        QueuePage Qp = new QueuePage (BaseClass.getDriver());
        Qp.Click_Getstarted_homePage_Queue();
        Qp.Click_ImplementaionOfQueue();
        Qp.Click_ImplemenUsingArry();
        String CurrentURL = BaseClass.getDriver().getCurrentUrl();
        Assert.assertEquals(true, CurrentURL.contains("array"));
        logger.info("Implementation using Array link Current URL " + CurrentURL);

    }

    @Test  (priority=8)
    void Test_LEFTPanel_QueueOperations()
    {
        QueuePage Qp = new QueuePage (BaseClass.getDriver());
        Qp.Click_Getstarted_homePage_Queue();
        Qp.Click_ImplementaionOfQueue();
        Qp.Click_QueueOperation();
        String CurrentURL = BaseClass.getDriver().getCurrentUrl();
        logger.info("After clicking Queue Operations link URL ... " +CurrentURL );
        Assert.assertEquals(true, CurrentURL.contains("QueueOp"));


    }

    @Test  (priority=9)
    void Test_LEFTPanel_PracticeQuestions()
    {
        logger.info("Clicking the Practice Questions  from the left panel links........ ");
        QueuePage Qp = new QueuePage (BaseClass.getDriver());
        Qp.Click_Getstarted_homePage_Queue();
        Qp.Click_ImplementaionOfQueue();
        Qp.click_PracticeQuestions();
        String CurrentURL = BaseClass.getDriver().getCurrentUrl();
        Assert.assertEquals(true, CurrentURL.contains("practice"));

    }

    @Test  (priority=10)
    void Test_TryHere_ImplementationOf_Queue_InPython()
    {
        QueuePage Qp = new QueuePage (BaseClass.getDriver());
        Qp.Click_Getstarted_homePage_Queue();
        Qp.Click_ImplementaionOfQueue();
        DataStructurePage dp = new DataStructurePage(BaseClass.getDriver());
        dp.click_DS_TimeComplexity_TryhereBtn();
        String CurURL= BaseClass.getDriver().getCurrentUrl();
        Assert.assertEquals(true, CurURL.contains("tryEditor"));
    }

    @Test  (priority=11)
    void Test_PythonEditor_ImplementationOf_Queue_InPython_ValidCodes()
    {
        QueuePage Qp = new QueuePage (BaseClass.getDriver());
        Qp.Click_Getstarted_homePage_Queue();
        Qp.Click_ImplementaionOfQueue();
        Qp.Click_Tryhere();
        DataStructurePage Dp = new DataStructurePage(BaseClass.getDriver());
        Dp.Click_DS_PythonEditor_Runbtn_ValidCodes();
        Dp.click_DS_PythonEditor_RunBtn();
        Dp.validate_Console_Output();
        logger.info("Console output.......     " +Dp.ConsoleOutput_text + Dp.PYEditor_Code);
        Assert.assertEquals(true,Dp.PYEditor_Code.contains(Dp.ConsoleOutput_text) );

    }

    @Test  (priority=12)
    void Test_PythonEditor_ImplementationOf_Queue_InPython_InValidCodes()
    {

        QueuePage Qp = new QueuePage (BaseClass.getDriver());
        Qp.Click_Getstarted_homePage_Queue();
        Qp.Click_ImplementaionOfQueue();
        Qp.Click_Tryhere();
        DataStructurePage dp = new DataStructurePage(BaseClass.getDriver());
        logger.info("User Entering invalid pythod code on the editor ..... ");
        dp.Click_DS_PythonEditor_Runbtn_InValidCodes();
        dp.Validate_OutputConsole_InvalidCodes();
        logger.info("Alert Message in Python Editor " + dp.Alertmesg);
        Assert.assertEquals(true, dp.Alertmesg.contains("bad input on line 1"));

    }

    @Test  (priority=13)
    void Test_PythonEditor_ImplementationOf_Queue_InPython_withOutCodes()
    {

        QueuePage Qp = new QueuePage (BaseClass.getDriver());
        Qp.Click_Getstarted_homePage_Queue();
        Qp.Click_ImplementaionOfQueue();
        Qp.Click_Tryhere();
        DataStructurePage dp = new DataStructurePage(BaseClass.getDriver());
        dp.Click_DS_PythonEditor_Runbtn_WithoutCodes();
        String crntURL = BaseClass.getDriver().getCurrentUrl();
        Assert.assertEquals(true, crntURL.contains("tryEditor"));

    }


    @Test  (priority=14)
    void Test_TryHere_Implementation_UsingCollections_Queue()
    {

        QueuePage Qp = new QueuePage (BaseClass.getDriver());
        Qp.Click_Getstarted_homePage_Queue();
        Qp.Click_ImplemenUsingCollectionOfQueue();
        Qp.Click_Tryhere();
        String crntURL = BaseClass.getDriver().getCurrentUrl();
        Assert.assertEquals(true, crntURL.contains("tryEditor"));

    }

    @Test  (priority=15)
    void Test_PythonEditor_Implementation_UsingCollections_Queue_ValidCodes()
    {

        QueuePage Qp = new QueuePage (BaseClass.getDriver());
        Qp.Click_Getstarted_homePage_Queue();
        Qp.Click_ImplemenUsingCollectionOfQueue();
        DataStructurePage dp = new DataStructurePage(BaseClass.getDriver());
        Qp.Click_Tryhere();
        DataStructurePage Dp = new DataStructurePage(BaseClass.getDriver());
        Dp.Click_DS_PythonEditor_Runbtn_ValidCodes();
        Dp.click_DS_PythonEditor_RunBtn();
        Dp.validate_Console_Output();
        logger.info("Console output.......     " +Dp.ConsoleOutput_text + Dp.PYEditor_Code);
        Assert.assertEquals(true,Dp.PYEditor_Code.contains(Dp.ConsoleOutput_text) );
    }


    @Test  (priority=16)
    void Test_PythonEditor_Implementation_UsingCollections_Queue_InValidCodes()
    {

        QueuePage Qp = new QueuePage (BaseClass.getDriver());
        Qp.Click_Getstarted_homePage_Queue();
        Qp.Click_ImplemenUsingCollectionOfQueue();
        Qp.Click_Tryhere();
        DataStructurePage dp = new DataStructurePage(BaseClass.getDriver());
        logger.info("User Entering invalid pythod code on the editor ..... ");
        dp.Click_DS_PythonEditor_Runbtn_InValidCodes();
        dp.Validate_OutputConsole_InvalidCodes();
        logger.info("Alert Message in Python Editor " + dp.Alertmesg);
        Assert.assertEquals(true, dp.Alertmesg.contains("bad input on line 1"));

    }

    @Test   (priority=17)
    void Test_PythonEditor_Implementation_UsingCollections_Queue_WithOutCodes()
    {
        QueuePage Qp = new QueuePage (BaseClass.getDriver());
        Qp.Click_Getstarted_homePage_Queue();
        Qp.Click_ImplemenUsingCollectionOfQueue();
        Qp.Click_Tryhere();
        DataStructurePage dp = new DataStructurePage(BaseClass.getDriver());
        dp.Click_DS_PythonEditor_Runbtn_WithoutCodes();
        String crntURL = BaseClass.getDriver().getCurrentUrl();
        Assert.assertEquals(true, crntURL.contains("tryEditor"));

    }

    @Test  (priority=18)
    void Test_TryHere_Test_ImplementationUsing_Array()
    {
        QueuePage Qp = new QueuePage (BaseClass.getDriver());
        Qp.Click_Getstarted_homePage_Queue();
        Qp.Click_ImplemenUsingArry();
        Qp.Click_Tryhere();
        String crntURL = BaseClass.getDriver().getCurrentUrl();
        Assert.assertEquals(true, crntURL.contains("tryEditor"));
    }


    @Test  (priority=19)
    void Test_PythonEditor_ImplementationUsing_Array_ValidCodes()
    {

        QueuePage Qp = new QueuePage (BaseClass.getDriver());
        Qp.Click_Getstarted_homePage_Queue();
        Qp.Click_ImplemenUsingArry();
        Qp.Click_Tryhere();
        DataStructurePage Dp = new DataStructurePage(BaseClass.getDriver());
        Dp.Click_DS_PythonEditor_Runbtn_ValidCodes();
        Dp.click_DS_PythonEditor_RunBtn();
        Dp.validate_Console_Output();
        logger.info("Console output.......     " +Dp.ConsoleOutput_text + Dp.PYEditor_Code);
        Assert.assertEquals(true,Dp.PYEditor_Code.contains(Dp.ConsoleOutput_text) );

    }

    @Test  (priority=20)
    void Test_PythonEditor_ImplementationUsing_Array_InValidCodes()
    {
        QueuePage Qp = new QueuePage (BaseClass.getDriver());
        Qp.Click_Getstarted_homePage_Queue();
        Qp.Click_ImplemenUsingArry();
        Qp.Click_Tryhere();
        DataStructurePage dp = new DataStructurePage(BaseClass.getDriver());
        logger.info("User Entering invalid pythod code on the editor ..... ");
        dp.Click_DS_PythonEditor_Runbtn_InValidCodes();
        dp.Validate_OutputConsole_InvalidCodes();
        logger.info("Alert Message in Python Editor " + dp.Alertmesg);
        Assert.assertEquals(true, dp.Alertmesg.contains("bad input on line 1"));
    }


    @Test  (priority=21)
    void Test_PythonEditor_ImplementationUsing_Array_WithOutCodes()
    {
        QueuePage Qp = new QueuePage (BaseClass.getDriver());
        Qp.Click_Getstarted_homePage_Queue();
        Qp.Click_ImplemenUsingArry();
        Qp.Click_Tryhere();
        DataStructurePage dp = new DataStructurePage(BaseClass.getDriver());
        dp.Click_DS_PythonEditor_Runbtn_WithoutCodes();
        String crntURL = BaseClass.getDriver().getCurrentUrl();
        Assert.assertEquals(true, crntURL.contains("tryEditor"));
    }

    @Test (priority=22)
    void Test_TryHere_QueueOperations()
    {
        QueuePage Qp = new QueuePage (BaseClass.getDriver());
        Qp.Click_Getstarted_homePage_Queue();
        Qp.Click_QueueOperation();
        Qp.Click_Tryhere();
        String crntURL = BaseClass.getDriver().getCurrentUrl();
        Assert.assertEquals(true, crntURL.contains("tryEditor"));
    }


    @Test (priority=23)
    void Test_PythonEditor_QueueOperations_ValidCodes()
    {

        QueuePage Qp = new QueuePage (BaseClass.getDriver());
        Qp.Click_Getstarted_homePage_Queue();
        Qp.Click_QueueOperation();
        Qp.Click_Tryhere();
        DataStructurePage Dp = new DataStructurePage(BaseClass.getDriver());
        Dp.Click_DS_PythonEditor_Runbtn_ValidCodes();
        Dp.click_DS_PythonEditor_RunBtn();
        Dp.validate_Console_Output();
        logger.info("Console output.......     " +Dp.ConsoleOutput_text + Dp.PYEditor_Code);
        Assert.assertEquals(true,Dp.PYEditor_Code.contains(Dp.ConsoleOutput_text) );
    }

    @Test (priority=24)
    void Test_PythonEditor_QueueOperations_InValidCodes()
    {
        QueuePage Qp = new QueuePage (BaseClass.getDriver());
        Qp.Click_Getstarted_homePage_Queue();
        Qp.Click_QueueOperation();
        Qp.Click_Tryhere();
        DataStructurePage dp = new DataStructurePage(BaseClass.getDriver());
        logger.info("User Entering invalid pythod code on the editor ..... ");
        dp.Click_DS_PythonEditor_Runbtn_InValidCodes();
        dp.Validate_OutputConsole_InvalidCodes();
        logger.info("Alert Message in Python Editor " + dp.Alertmesg);
        Assert.assertEquals(true, dp.Alertmesg.contains("bad input on line 1"));

    }

    @Test (priority=25)
    void Test_PythonEditor_QueueOperations_WithOutCodes()
    {
        QueuePage Qp = new QueuePage (BaseClass.getDriver());
        Qp.Click_Getstarted_homePage_Queue();
        Qp.Click_QueueOperation();
        Qp.Click_Tryhere();
        DataStructurePage dp = new DataStructurePage(BaseClass.getDriver());
        dp.Click_DS_PythonEditor_Runbtn_WithoutCodes();
        String crntURL = BaseClass.getDriver().getCurrentUrl();
        Assert.assertEquals(true, crntURL.contains("tryEditor"));
    }
}

package pageObject;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import factory.BaseClass;

public class QueuePage extends BasePage {

    Logger logger = BaseClass.getLogger();

    public QueuePage(WebDriver driver) {
        super(driver);

    }

    public DataStructurePage dp = new	  DataStructurePage(BaseClass.getDriver());


    // Page Objects

    @FindBy (xpath = "//*[text()='Data Structures-Introduction']//following::a[5]")
    WebElement Queue_GetStartedBtn;

    // Queue Page Objects

    @FindBy (xpath = "//a[contains(text(),'Implementation of Queue in Python')]")
    WebElement ImpofQueue_Btn;

    @FindBy (xpath = "//a[contains(text(),'Implementation using collections.deque')]")
    WebElement ImpusingcollectionQueue_Btn;


    @FindBy (xpath = "//a[contains(text(),'Implementation using array')]")
    WebElement ImpUsingArray_Btn;


    @FindBy (xpath = "//a[contains(text(),'Queue Operations')]")
    WebElement QueueOperation_Btn;


    // Implementation of Queue Page Objects


    @FindBy (xpath = "//a[contains(text(),'Practice Questions')]")
    WebElement LeftPanel_PracticeQuestion_Btn;




    public void Click_ImplementaionOfQueue()
    {
        JavascriptExecutor jse = (JavascriptExecutor)BaseClass.getDriver();
        jse.executeScript("window.scrollBy(0,1000)");
        ImpofQueue_Btn.click();
    }

    public void Click_ImplemenUsingCollectionOfQueue()
    {
        ImpusingcollectionQueue_Btn.click();
    }


    public void Click_ImplemenUsingArry()
    {
        ImpUsingArray_Btn.click();
    }

    public void Click_QueueOperation()
    {
        QueueOperation_Btn.click();
    }


    public void click_PracticeQuestions()
    {
        LeftPanel_PracticeQuestion_Btn.click();
    }



    public void Click_Tryhere()
    {
        DataStructurePage dp = new DataStructurePage(BaseClass.getDriver());
        dp.click_DS_TimeComplexity_TryhereBtn();
    }



    public void Click_Getstarted_homePage_Queue()
    {
        HomePage Hp = new HomePage(BaseClass.getDriver());

        Hp.Login_HomePage();

        Hp.clickQueueGetStarted();
    }
}

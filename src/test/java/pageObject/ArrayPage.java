package pageObject;


import java.util.HashMap;
import java.util.List;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import factory.BaseClass;
import utilities.DataReader;


public class ArrayPage extends BasePage {

    public ArrayPage(WebDriver driver) {
        super(driver);

    }

    public String AlertMessage = "";
    public String ValidCode = "";

    Logger logger = BaseClass.getLogger();

    List<HashMap<String, String>> datamap;

    @FindBy(xpath = "//a[@href='arrays-in-python']")
    WebElement ArraysInPython_Btn;

    @FindBy(xpath = "//a[@href='arrays-using-list']")
    WebElement ArraysUsingList_Btn;

    @FindBy(xpath = "//a[@href='basic-operations-in-lists']")
    WebElement BasicOpeartionsInList_Btn;

    @FindBy(xpath = "//a[@href='applications-of-array']")
    WebElement ApplicationsOFArray_Btn;

    @FindBy(xpath = "//a[@href='/array/practice']")
    WebElement PracticeQuestion_Btn;

    @FindBy(xpath = "//a[@href='/array/arrays-in-python/']")
    WebElement LeftPanel_ArraysInPyhton_Btn;

    @FindBy(xpath = "//a[@href='/array/arrays-using-list/']")
    WebElement LeftPanel_ArraysUsingList_Btn;

    @FindBy(xpath = "//a[@href='/array/basic-operations-in-lists/']")
    WebElement LeftPanel_BasicOpeartionsInList_Btn;

    @FindBy(xpath = "//a[@href='/array/applications-of-array/']")
    WebElement LeftPanel_ApplicationsOFArray_Btn;

    @FindBy(xpath = "//a[@href='/question/1']")
    WebElement SearchTheArray_Btn;

    @FindBy(xpath = "//a[@href='/question/2']")
    WebElement MaxConsecutive_Btn;

    @FindBy(xpath = "//a[@href='/question/3']")
    WebElement EvenNum_Question_Btn;

    @FindBy(xpath = "//a[@href='/question/4']")
    WebElement sortedSquaresarray__Btn;

    @FindBy(xpath = "//*[@id='output']")
    public WebElement ConsoleOutput;

    @FindBy(xpath = "//*[@value='Submit']")
    public WebElement PythonEditor_submit_Btn;

    @FindBy(css = ".CodeMirror-scroll")
    WebElement TextareaScroll_1;

    @FindBy(css = "div:nth-child(1) > textarea")
    WebElement Textarea_Type2;

    @FindBy(css = "button")
    WebElement Textarea_button3;

    public void Click_ArraysInPython_Btn() {
        ArraysInPython_Btn.click();
    }

    public void Click_ArraysUsingList_Btn() {
        ArraysUsingList_Btn.click();
    }

    public void Click_BasicOperations_Btn() {
        BasicOpeartionsInList_Btn.click();
    }

    public void Click_ApplicationsOfArray_Btn() {
        ApplicationsOFArray_Btn.click();
    }

    public void Click_PracticeQuestion_Btn() {
        PracticeQuestion_Btn.click();
    }

    public void Click_LeftPanel_BasicOpeartionsInList_Btn() {
        LeftPanel_BasicOpeartionsInList_Btn.click();
    }

    public void Click_LeftPanel_ApplicationsOFArray_Btn() {
        LeftPanel_ApplicationsOFArray_Btn.click();
    }

    public void Click_LeftPanel_ArraysUsingList_Btn() {
        LeftPanel_ArraysUsingList_Btn.click();
    }

    public void Click_LeftPanel_ArraysInPyhton_Btn() {
        LeftPanel_ArraysInPyhton_Btn.click();
    }

    public void Click_SearchTheArray_Btn() {
        SearchTheArray_Btn.click();
    }

    public void Click_TryhereBtn() {
        DataStructurePage Dp = new DataStructurePage(BaseClass.getDriver());
        Dp.click_DS_TimeComplexity_TryhereBtn();
    }

    public void Click_MaxConsecutive_Btn() {
        MaxConsecutive_Btn.click();
    }

    public void Click_EvenNumberQuestion_Btn() {
        EvenNum_Question_Btn.click();
    }

    public void Click_SortedSquared_Ctn() {
        sortedSquaresarray__Btn.click();
    }


    public void ExcelData_PythonEditor(String rownumber) {
        int index = Integer.parseInt(rownumber) - 1;

        datamap = DataReader.data(System.getProperty("user.dir") + "\\testData\\Python_Editor_Data.xlsx", "Sheet1");

        String ValidCode = datamap.get(index).get("PythonCode");

        String Output = datamap.get(index).get("Result");

        TextareaScroll_1.click();

        JavascriptExecutor js = (JavascriptExecutor) BaseClass.getDriver();

        js.executeScript("window.scrollTo(0,0)");

        enterCodePractice(ValidCode, Textarea_Type2);

        Textarea_button3.click();

    }

    public void enterCodePractice(String code, WebElement element) {

        new Actions(driver).keyDown(Keys.CONTROL).sendKeys("a").sendKeys(Keys.DELETE).keyUp(Keys.CONTROL).perform();

        String[] str1 = code.split("\n");
        for (int i = 0; i < str1.length; i++) {
            if (str1[i].equalsIgnoreCase("\\b")) {
                element.sendKeys(Keys.BACK_SPACE);
            } else {
                element.sendKeys(str1[i]);
                element.sendKeys(Keys.RETURN);
            }
        }
    }

    public void Click_Submit_Btn_ExcelData_ValidCodes(String Rownumber) {

        int index = Integer.parseInt(Rownumber) - 1;

        datamap = DataReader.data(System.getProperty("user.dir") + "\\testData\\Python_Editor_Data.xlsx", "Sheet1");

        String ValidCode = datamap.get(index).get("PythonCode");

        String Output = datamap.get(index).get("Result");

        TextareaScroll_1.click();

        enterCodePractice(ValidCode, Textarea_Type2);

        PythonEditor_submit_Btn.click();

    }


}

package pageObject;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import factory.BaseClass;

public class TreePage extends BasePage{

    public TreePage(WebDriver driver) {
        super(driver);

    }

    //----------------------------WebElements----------------------------

    @FindBy(xpath="//a[@href='tree']")
    private WebElement TreeGetStrdBtn;

    @FindBy(xpath="//a[normalize-space()='Overview of Trees']")
    private WebElement OverviewoftreeBtn;

    @FindBy(xpath="//a[normalize-space()='Terminologies']")
    private WebElement terminologiesBtn;

    @FindBy(xpath="//a[normalize-space()='Types of Trees']")
    private WebElement types_of_treesBtn;

    @FindBy(xpath="//a[normalize-space()='Tree Traversals']")
    private WebElement tree_traversalsBtn;

    @FindBy(xpath="//a[normalize-space()='Traversals-Illustration']")
    private WebElement traversals_illustrationBtn;

    @FindBy(xpath="//a[normalize-space()='Binary Trees']")
    private WebElement binary_treesBtn;

    @FindBy(xpath="//a[normalize-space()='Types of Binary Trees']")
    private WebElement types_of_binary_treesBtn;

    @FindBy(xpath="//a[normalize-space()='Implementation in Python']")
    private WebElement implementation_in_pythonBtn;

    @FindBy(xpath="//a[normalize-space()='Binary Tree Traversals']")
    private WebElement BinaryTreeTraversalsBtn;

    @FindBy(xpath="//a[normalize-space()='Implementation of Binary Trees']")
    private WebElement ImplementationofBinaryTreesBtn;

    @FindBy(xpath="//a[normalize-space()='Applications of Binary trees']")
    private WebElement ApplicationsofBinarytreesBtn;

    @FindBy(xpath="//a[normalize-space()='Binary Search Trees']")
    private WebElement BinarySearchTreesBtn;

    @FindBy(xpath="//a[normalize-space()='Implementation Of BST']")
    private WebElement ImplementationOfBSTBtn;

    @FindBy(xpath="//a[@href='/tryEditor']")
    private WebElement TryHereBtn;

    @FindBy(xpath="//li[@class='list-group-item list-group-item-light ']/a")
    private List<WebElement> TreeMenuLinks;

    @FindBy(xpath="//a[normalize-space()='Practice Questions']")
    private WebElement PracticeQnsBtn;

    String Tree_link_URL="https://dsportalapp.herokuapp.com/tree/";
    String Tree_HomePage_URL="https://dsportalapp.herokuapp.com/tree/";
    String Overview_of_Trees_URL="https://dsportalapp.herokuapp.com/tree/overview-of-trees/";
    String terminologies_URL="https://dsportalapp.herokuapp.com/tree/terminologies/";
    String types_of_trees_URL="https://dsportalapp.herokuapp.com/tree/types-of-trees/";
    String tree_traversals_URL="https://dsportalapp.herokuapp.com/tree/tree-traversals/";
    String traversals_illustration_URL="https://dsportalapp.herokuapp.com/tree/traversals-illustration/";
    String binary_trees_URL="https://dsportalapp.herokuapp.com/tree/binary-trees/";
    String types_of_binary_trees_URL="https://dsportalapp.herokuapp.com/tree/types-of-binary-trees/";
    String implementation_in_python_URL="https://dsportalapp.herokuapp.com/tree/implementation-in-python/";
    String BinaryTreeTraversals_URL="https://dsportalapp.herokuapp.com/tree/binary-tree-traversals/";
    String ImplementationofBinaryTrees_URL="https://dsportalapp.herokuapp.com/tree/implementation-of-binary-trees/";
    String ApplicationsofBinarytrees_URL="https://dsportalapp.herokuapp.com/tree/applications-of-binary-trees/";
    String BinarySearchTrees_URL="https://dsportalapp.herokuapp.com/tree/binary-search-trees/";
    String ImplementationOfBST_URL="https://dsportalapp.herokuapp.com/tree/implementation-of-bst/";
    String TreePracticeQns_URL="https://dsportalapp.herokuapp.com/tree/practice";
    String Online_Editor_Console_URL="https://dsportalapp.herokuapp.com/tryEditor";
    //----------------------------------------Methods------------------------

    public void click_TreeGetstarted() {
        TreeGetStrdBtn.click();
    }
    public boolean check_TreeHomePagelink() {
        String Current_URL=BaseClass.getDriver().getCurrentUrl();
        boolean Check_URL = Tree_HomePage_URL.equals(Current_URL);
        return Check_URL;
    }

    public void clickTryHerebutton() {
        TryHereBtn.click();
    }
    public boolean check_TryEditorPage() {
        String Current_URL=BaseClass.getDriver().getCurrentUrl();
        boolean Check_URL = Online_Editor_Console_URL.equals(Current_URL);
        return Check_URL;
    }

    public void click_OverviewofTreeLink() {
        OverviewoftreeBtn.click();

    }

    public boolean check_Overview_of_TreePage() {
        String Current_URL=BaseClass.getDriver().getCurrentUrl();
        boolean Check_URL = Overview_of_Trees_URL.equals(Current_URL);
        return Check_URL;
    }

    public void click_terminologiesLink() {
        terminologiesBtn.click();
    }

    public boolean check_terminologiesPage() {
        String Current_URL=BaseClass.getDriver().getCurrentUrl();
        boolean Check_URL = terminologies_URL.equals(Current_URL);
        return Check_URL;
    }

    //types_of_trees
    public void click_types_of_treesLink() {
        types_of_treesBtn.click();
    }

    public boolean check_types_of_treesPage(){
        String Current_URL=BaseClass.getDriver().getCurrentUrl();
        boolean Check_URL = types_of_trees_URL.equals(Current_URL);
        return Check_URL;
    }

    //tree-traversals
    public void click_tree_traversalsLink() {
        tree_traversalsBtn.click();
    }

    public boolean check_tree_traversalsPage(){
        String Current_URL=BaseClass.getDriver().getCurrentUrl();
        boolean Check_URL = tree_traversals_URL.equals(Current_URL);
        return Check_URL;
    }

    //traversals-illustration
    public void click_traversals_illustrationLink() {
        traversals_illustrationBtn.click();
    }

    public boolean check_traversals_illustrationPage() {
        String Current_URL=BaseClass.getDriver().getCurrentUrl();
        boolean Check_URL = traversals_illustration_URL.equals(Current_URL);
        return Check_URL;
    }

    //binary-trees
    public void click_binary_treesLink() {
        binary_treesBtn.click();
    }

    public boolean check_binary_treesPage() {
        String Current_URL=BaseClass.getDriver().getCurrentUrl();
        boolean Check_URL = binary_trees_URL.equals(Current_URL);
        return Check_URL;
    }

    //types-of-binary-trees
    public void click_types_of_binary_treesLink() {
        types_of_binary_treesBtn.click();
    }

    public boolean check_types_of_binary_treesPage() {
        String Current_URL=BaseClass.getDriver().getCurrentUrl();
        boolean Check_URL = types_of_binary_trees_URL.equals(Current_URL);
        return Check_URL;
    }

    //implementation-in-python
    public void click_implementation_in_pythonLink() {
        implementation_in_pythonBtn.click();
    }

    public boolean check_implementation_in_pythonPage() {
        String Current_URL=BaseClass.getDriver().getCurrentUrl();
        boolean Check_URL = implementation_in_python_URL.equals(Current_URL);
        return Check_URL;
    }

    //Binary Tree Traversals
    public void click_BinaryTreeTraversalsLink() {
        BinaryTreeTraversalsBtn.click();
    }

    public boolean check_BinaryTreeTraversalsPage() {
        String Current_URL=BaseClass.getDriver().getCurrentUrl();
        boolean Check_URL = BinaryTreeTraversals_URL.equals(Current_URL);
        return Check_URL;
    }

    //Implementation of Binary Trees
    public void click_ImplementationofBinaryTreesLink() {
        ImplementationofBinaryTreesBtn.click();
    }

    public boolean check_ImplementationofBinaryTreesPage() {
        String Current_URL=BaseClass.getDriver().getCurrentUrl();
        boolean Check_URL = ImplementationofBinaryTrees_URL.equals(Current_URL);
        return Check_URL;
    }

    //Applications of Binary trees
    public void click_ApplicationsofBinarytreesLink() {
        ApplicationsofBinarytreesBtn.click();
    }

    public boolean check_ApplicationsofBinarytreesPage() {
        String Current_URL=BaseClass.getDriver().getCurrentUrl();
        boolean Check_URL = ApplicationsofBinarytrees_URL.equals(Current_URL);
        return Check_URL;
    }

    //Binary Search Trees
    public void click_BinarySearchTreesLink() {
        // TODO Auto-generated method stub
        BinarySearchTreesBtn.click();
    }

    public boolean check_BinarySearchTreesPage() {
        String Current_URL=BaseClass.getDriver().getCurrentUrl();
        boolean Check_URL = BinarySearchTrees_URL.equals(Current_URL);
        return Check_URL;
    }

    //ImplementationOfBST
    public void click_ImplementationOfBSTLink() {
        // TODO Auto-generated method stub
        ImplementationOfBSTBtn.click();
    }

    public boolean check_ImplementationOfBSTPage() {
        String Current_URL=BaseClass.getDriver().getCurrentUrl();
        boolean Check_URL = ImplementationOfBST_URL.equals(Current_URL);
        return Check_URL;
    }

    //PracticeQns
    public void click_PracticeQnsLink() {
        // TODO Auto-generated method stub
        PracticeQnsBtn.click();
    }

    public boolean check_PracticeQnsPage() {
        String Current_URL=BaseClass.getDriver().getCurrentUrl();
        boolean Check_URL = TreePracticeQns_URL.equals(Current_URL);
        return Check_URL;
    }

}

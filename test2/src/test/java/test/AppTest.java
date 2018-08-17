package test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static junit.framework.TestCase.assertTrue;

public class AppTest
{
    @FindBy(id = "location_inputfileddiv")
    WebElement loc2;
    WebDriver driver;
    ExtentReports report;
    ExtentTest test;
    String url;
    @Before
    public void setup(){
        report = new ExtentReports(Constants.loc,true);
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\JackB\\Desktop\\JavaExtra\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Given("^the login page$")
    public void the_login_page() {
        test = report.startTest("Test 1");
        driver.get("https://qa-trials641.orangehrmlive.com/auth/login");
        url = driver.getCurrentUrl();
    }

    @When("^I login$")
    public void i_login() {
        test.log(LogStatus.INFO,"Attempting to Login");
        Login log = PageFactory.initElements(driver,Login.class);
        log.login();
        url=driver.getCurrentUrl();

    }

    @When("^I click the PIM tab$")
    public void i_click_the_PIM_tab() throws InterruptedException {
        test.log(LogStatus.INFO,"Attempting to click pim tab");
        Thread.sleep(1000);
        Home dashboard = PageFactory.initElements(driver,Home.class);
        dashboard.pimclick();
    }

    @When("^then the Add Employee Tab$")
    public void then_the_Add_Employee_Tab() throws InterruptedException{
        Thread.sleep(1000);
        test.log(LogStatus.INFO,"Attempting to click add employee");
        Home dashboard = PageFactory.initElements(driver,Home.class);
        dashboard.addclick();
    }

    @When("^I fill out the Add Employee Details correctly$")
    public void i_fill_out_the_Add_Employee_Details_correctly(){
        test.log(LogStatus.INFO,"Attempting to fill out form");
        Form f= PageFactory.initElements(driver,Form.class);
        WebDriverWait wait=new WebDriverWait(driver, 20);
        WebElement hold;
        hold= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstName")));
        hold.click();
        f.fillin();
       }


    @When("^I choose to create Login Details by clicking the appropriate button$")
    public void i_choose_to_create_Login_Details_by_clicking_the_appropriate_button() throws InterruptedException{
        Thread.sleep(2000);
        test.log(LogStatus.INFO,"Attempting to tick box");
        Form f= PageFactory.initElements(driver,Form.class);
        f.tick();
    }

    @When("^I fill out the Login Details correctly$")
    public void i_fill_out_the_Login_Details_correctly() {
        test.log(LogStatus.INFO,"Attempting to fill out login details");
        Form f= PageFactory.initElements(driver,Form.class);
        f.logfill();
    }

    @When("^I click the Save button$")
    public void i_click_the_Save_button() throws InterruptedException {
        Thread.sleep(5000);
        test.log(LogStatus.INFO,"Attempting to click save");
        Form f= PageFactory.initElements(driver,Form.class);
        f.save();
        url = driver.getCurrentUrl();
    }

    @Then("^I can search for the Employee I have just created$")
    public void i_can_search_for_the_Employee_I_have_just_created() {
        test.log(LogStatus.INFO,"Attempting to search for new employee");
        personal per = PageFactory.initElements(driver,personal.class);
        per.navtosearch();
        Employeelist em = PageFactory.initElements(driver,Employeelist.class);
        em.searchemployee();
        url = driver.getCurrentUrl();
        assertTrue(true);
    }

    @Then("^select them for inspection$")
    public void select_them_for_inspection() {
        test.log(LogStatus.INFO,"Attempting to inspect new employee");
        Employeelist em = PageFactory.initElements(driver,Employeelist.class);
        em.click();
        assertTrue(true);
        report.endTest(test);
    }
    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
        driver.quit();
        report.flush();
    }
}

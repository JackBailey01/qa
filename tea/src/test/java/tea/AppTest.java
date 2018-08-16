package tea;

import static org.junit.Assert.assertTrue;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;


public class AppTest 
{
    ExtentReports report;
    ExtentTest test;
    ExtentTest test2;
    String url;
    WebDriver driver;
    @Before
    public void setup(){
        report = new ExtentReports(constants.loc,true);
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\JackB\\Desktop\\JavaExtra\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }


    @Given("^the correct web address$")
    public void the_correct_web_address() {
        test = report.startTest("menu Test");
        test2 = report.startTest("Checkout Test");
        driver.get("http://www.practiceselenium.com/welcome.html");
        url=driver.getCurrentUrl();
    }

    @When("^I navigate to the 'Menu' page$")
    public void i_navigate_to_the_Menu_page(){
        test.log(LogStatus.INFO,"Navigating to Menu");
        HomePage page = PageFactory.initElements(driver,HomePage.class);
        page.menu();
        url=driver.getCurrentUrl();
    }

    @Then("^I can browse a list of the available products\\.$")
    public void i_can_browse_a_list_of_the_available_products(){
        Boolean cond = url.equals("http://www.practiceselenium.com/menu.html");
        if (cond == true){
            test.log(LogStatus.PASS,"Navigating to menu worked");
        }
        else {
            test.log(LogStatus.FAIL,"Navigating to menu failed");
        }
        report.endTest(test);
        assertTrue(cond);
    }

    @When("^I click the checkout button$")
    public void i_click_the_checkout_button() {
        test2.log(LogStatus.INFO,"Navigating to Checkout");
        HomePage page = PageFactory.initElements(driver,HomePage.class);
        Menu page2 = PageFactory.initElements(driver,Menu.class);
        page.menu();
        page2.checkout();
        url=driver.getCurrentUrl();
    }

    @Then("^I am taken to the checkout page$")
    public void i_am_taken_to_the_checkout_page() {
        Boolean cond = url.equals("http://www.practiceselenium.com/check-out.html");
        if (cond == true){
            test2.log(LogStatus.PASS,"Navigating to checkout worked");
        }
        else {
            test2.log(LogStatus.FAIL,"Navigating to checkout failed");
        }
        report.endTest(test2);
        assertTrue(cond);
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
        driver.quit();
        report.flush();
    }
}

package test;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Form {
    @FindBy(id = "firstName")
    WebElement first;
    @FindBy(id = "middleName")
    WebElement middle;
    @FindBy(id = "lastName")
    WebElement last;
    @FindBy(id = "systemUserSaveBtn")
    WebElement savebtn;
    @FindBy(id = "location_inputfileddiv")
    WebElement loc2;
    @FindBy(xpath = "//*[@id=\"pimAddEmployeeForm\"]/div[1]/div/materializecss-decorator[3]/div/sf-decorator/div/label")
    WebElement logtick;
    @FindBy(id = "username")
    WebElement username;
    @FindBy(id = "password")
    WebElement password;
    @FindBy(id = "confirmPassword")
    WebElement confirm;

    public void fillin() {
        first.sendKeys("Jack");
        middle.sendKeys("Richard");
        last.sendKeys("Bailey");
        loc2.click();
        loc2.sendKeys(Keys.DOWN);
        loc2.sendKeys(Keys.DOWN);
        loc2.sendKeys(Keys.DOWN);
        loc2.sendKeys(Keys.ENTER);


    }

    public void save() {
        savebtn.click();
    }

    public void tick() {
        logtick.click();
    }

    public void logfill() {
        username.sendKeys("JackBailey01");
        password.sendKeys("password");
        confirm.sendKeys("password");
    }
}



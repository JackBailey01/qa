package test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login {
    @FindBy(id = "txtUsername")
    WebElement user;
    @FindBy(id="txtPassword")
    WebElement pass;
    @FindBy(id="frmLogin")
    WebElement form;


    public void login(){
        user.sendKeys("Admin");
        pass.sendKeys("AdminAdmin");
        form.submit();
    }
}

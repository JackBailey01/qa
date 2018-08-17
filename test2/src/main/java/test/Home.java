package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.Key;

public class Home {
    @FindBy(xpath = "//*[@id=\"menu_pim_viewPimModule\"]/a/span[1]")
    WebElement pim;
    @FindBy(xpath = "//*[@id=\"menu_pim_addEmployee\"]/span[2]")
    WebElement add;


    public void pimclick(){
        pim.click();
    }
    public void addclick(){
        add.click();
    }

}

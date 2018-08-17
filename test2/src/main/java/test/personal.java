package test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class personal {
    @FindBy(xpath = "//*[@id=\"menu_pim_viewEmployeeList\"]/span[2]")
    WebElement list;
    public void navtosearch(){
        list.click();
    }
}

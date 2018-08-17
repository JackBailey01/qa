package test;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Employeelist {
    @FindBy(xpath = "employee_name_quick_filter_employee_list_value")
    WebElement search;
    @FindBy(xpath="//*[@id=\"employeeListTable\"]/tbody/tr/td[3]")
    WebElement name;

    public void searchemployee(){
        search.sendKeys(Keys.chord("Jack",Keys.ENTER));
    }
    public void click(){
        name.click();
    }


}

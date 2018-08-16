package tea;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Menu {
    @FindBy(xpath = "//*[@id=\"wsb-button-00000000-0000-0000-0000-000451955160\"]")
    static WebElement check;
    public static void checkout(){
        check.click();
    }

}

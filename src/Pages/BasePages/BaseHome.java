package Pages.BasePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Marcelo Ferrufino on 8/22/2015.
 */
public abstract class BaseHome {
    protected WebDriver driver;
    protected WebDriverWait wait;


    @FindBy (css = "input[name='new']")
    @CacheLookup
    protected WebElement newBtn;

    protected abstract Object clickNewBtn();
}

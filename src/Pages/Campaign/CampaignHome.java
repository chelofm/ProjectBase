package Pages.Campaign;

import Framework.WebDriverManager;
import Pages.BasePages.BaseHome;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by Marcelo Ferrufino on 8/22/2015.
 */
public class CampaignHome extends BaseHome {

    public CampaignHome(WebDriver driver){
        super.driver = driver;
        super.wait = WebDriverManager.getInstance().getWait();
        PageFactory.initElements(driver, this);
    }

    @Override
    public CampaignForm clickNewBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(newBtn));
        newBtn.click();
        return new CampaignForm(driver);
    }

    public CampaignDetails selectRecentCpn(String cpnName){
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText(cpnName)));
        WebElement cpnLnk = driver.findElement(By.linkText(cpnName));
        cpnLnk.click();
        return new CampaignDetails(driver);
    }
}

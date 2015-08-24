package Test.CampaingTests;

import Framework.WebDriverManager;
import Pages.Campaign.CampaignDetails;
import Pages.Campaign.CampaignForm;
import Pages.Campaign.CampaignHome;
import Pages.Login;
import Pages.MainApp;
import Pages.NavigationTab;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by Marcelo Ferrufino on 8/22/2015.
 */
public class TestCreateCampaign {
    private MainApp mainApp;

    private final String cpnName = "CampaignName01";
    private final String type = "Partners";
    private final String status = "Completed";
    private final String startDate = "08/24/2015";
    private final String endDate = "08/28/2015";
    private final String expectedRevenue = "expected 01";
    private final String budgetedCost = "budgetedCost 01";
    private final String actualCost = "actual cost 01";
    private final String expectedResponse = "10";
    private final String numSet = "100";
    private final String description = "description of new " + cpnName;

    @BeforeClass
    public void setUp(){
        Login login = new Login()
                            .setUserName()
                            .setPassword();
        mainApp = login.clickLoginBtn();
    }

    @Test
    public void createCampaign(){
        NavigationTab navigationTab = mainApp.goToNavigationTab();
        CampaignHome campaignHome = navigationTab.goToCampaignHome();
        CampaignForm campaignForm = campaignHome.clickNewBtn();
        CampaignDetails campaignDetails = campaignForm.setCpnName(cpnName)
                .checkActive()
                .selectType(type)
                .selectStatus(status)
                .setStartDate(startDate)
                .setEndDate(endDate)
                .setExpectedRevenue(expectedRevenue)
                .setBudgetedCost(budgetedCost)
                .setActualCost(actualCost)
                .setExpectedResponse(expectedResponse)
                .setNumSet(numSet)
                .setDescription(description)
                .clickSaveBtn();
    }

    @AfterClass
    public void tearDown(){
        WebDriverManager.getInstance().getDriver().close();
    }
}

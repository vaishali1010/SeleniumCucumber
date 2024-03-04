package stepDefinitions;

import Hooks.ApplicationHooks;
import com.pages.LoginPage;
import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WindowType;
import org.testng.Assert;


public class LoginPageSteps {

    private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());

    @Given("^user opens a new page in the browser$")
    public void userOpensANewPageInTheBrowser() {
        DriverFactory.getDriver().switchTo().newWindow(WindowType.TAB);

    }

    @And("navigate to {string}")
    public void navigateTo(String Url){
        loginPage.navigateToUrl(Url);
    }


    @When("user fills in the account details")
    public void userFillsInTheAccountDetails() {
        loginPage.enterUserName();
        loginPage.enterPassword();
    }

    @And("click on Login button")
    public void clickOnLoginButton() throws InterruptedException {
        loginPage.clickOnLogin();
    }

    @Then("dashboard screen should be displayed in the admin panel")
    public void dashboardScreenShouldBeDisplayedInTheAdminPanel() {
        String url= DriverFactory.getDriver().getCurrentUrl();
        Assert.assertTrue(url.contains("dashboard"));
    }
}

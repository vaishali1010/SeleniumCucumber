package stepDefinitions;

import Hooks.ApplicationHooks;
import com.pages.LogOutPage;
import factory.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LogOutSteps {
    private LogOutPage logOutPage = new LogOutPage(DriverFactory.getDriver());

    @When("user clicks on Logout button under top right dropdown of Profile")
    public void userClicksOnLogoutButtonUnderTopRightDropdownOfProfile() {
        logOutPage.setLogOut();
    }

    @Then("Login page would be shown")
    public void loginPageWouldBeShown() {
        logOutPage.verifySuccessfulLogOut();
    }
}

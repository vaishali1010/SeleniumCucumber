package stepDefinitions;

import Hooks.ApplicationHooks;
import com.pages.MyInfoPage;
import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class MyInfoPageSteps {
    private MyInfoPage myInfoPage = new MyInfoPage(DriverFactory.getDriver());

    @Given("user is already logged into admin panel")
    public void userIsAlreadyLoggedIntoAdminPanel() {
        myInfoPage.alreadyLogin();
    }

        @And("click on MyInfo page")
    public void clickOnMyInfopage(){
        myInfoPage.clickOnMyInfo();
    }

    @And("verify already filled Date of Birth")
    public void verifyAlreadyFilledDateOfBirth() {
        Assert.assertNotNull(myInfoPage.verifyDate());
    }

    @When("user updates the date to another date successfully")
    public void userUpdatesTheDateToAnotherDateSuccessfully() {
        myInfoPage.changeToNewDate();
    }

    @Then("page should be updated with changes date")
    public void pageShouldBeUpdatedWithChangesDate() {
        Assert.assertEquals(myInfoPage.verifyDate(),myInfoPage.currentDate());
    }
}

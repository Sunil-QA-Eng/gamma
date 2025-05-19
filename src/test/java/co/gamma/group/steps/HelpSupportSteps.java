package co.gamma.group.steps;

import co.gamma.group.pages.HelpSupportPage;
import co.gamma.group.pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

/**
 * Created by Sunil Suhagiya
 */
public class HelpSupportSteps {

    @Given("I click on help and support link")
    public void iClickOnHelpAndSupportLink() {
        new HomePage().helpAndSupport();
    }

    @Then("The url title should contain {string}")
    public void theUrlTitleShouldContain(String url) {
        Assert.assertTrue(new HelpSupportPage().getUrl().contains(url), "User was not navigted to company page");
    }

    @And("The page sub title should have {string}")
    public void thePageSubTitleShouldHave(String title) {
        Assert.assertEquals(new HelpSupportPage().getSubTitleText(), title, "help & support sub title did not match");
    }
}

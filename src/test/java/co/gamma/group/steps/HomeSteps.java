package co.gamma.group.steps;

import co.gamma.group.pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import io.cucumber.datatable.DataTable;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Sunil Suhagiya
 */
public class HomeSteps {
    List<String> actualMenuItems;

    @Given("I am on home page")
    public void iAmOnHomePage() {
        new HomePage().clickOnAcceptCookiesButton();
    }

    @Then("The page title should contain {string}")
    public void thePageTitleShouldContain(String title) {
        Assert.assertEquals(new HomePage().getPageTitle(), title, "page title does not match");
    }

    @Then("I should see the mission statement text as {string}")
    public void iShouldSeeTheMissionStatementTextAs(String missionStatement) {
        Assert.assertEquals(new HomePage().getMissionStatement(), missionStatement, "Mission statmenet did not match");
    }

    @When("I fetch the top navigation menu items")
    public void iFetchTheTopNavigationMenuItems() {
        actualMenuItems = new ArrayList<>();
        for (WebElement item : new HomePage().getMenuItems()) {
            actualMenuItems.add(item.getText().trim());
        }
    }

    @Then("I should see the following menu items:")
    public void iShouldSeeTheFollowingMenuItems(DataTable dataTable) {
        List<String> expectedMenuItems = dataTable.asList();
        System.out.println("Expected Menu Items:");
        expectedMenuItems.forEach(item -> System.out.println(" - " + item));

        System.out.println("Actual Menu Items:");
        actualMenuItems.forEach(item -> System.out.println(" - " + item));
        Assert.assertEquals(expectedMenuItems, actualMenuItems, "Menu items do not match");
    }

    @When("I click on product portfolio from top menu")
    public void iClickOnProductPortfolioFromTopMenu() {
        new HomePage().clickOnProductPortfolio();
    }

    @Then("I should see the following submenu items:")
    public void iShouldSeeTheFollowingSubmenuItems(DataTable dataTable) {
        List<String> expectedSubmenuItems = dataTable.asList();

        List<WebElement> submenuElements = new HomePage().getSubmenuItems();
        List<String> actualSubmenuTexts = new ArrayList<>();

        for (WebElement elem : submenuElements) {
            actualSubmenuTexts.add(elem.getText().trim());
        }
        System.out.println("Expected Submenu Items:");
        expectedSubmenuItems.forEach(item -> System.out.println(" - " + item));

        System.out.println("Actual Submenu Items:");
        actualSubmenuTexts.forEach(item -> System.out.println(" - " + item));
        Assert.assertEquals(actualSubmenuTexts, expectedSubmenuItems, "Submenu items do not match!");
    }
}

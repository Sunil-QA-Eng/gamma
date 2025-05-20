package co.gamma.group.pages;

import co.gamma.group.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class HomePage extends Utility {

    private static final Logger log = LogManager.getLogger(HomePage.class);

    @CacheLookup
    @FindBy(id = "CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll")
    WebElement acceptCookies;

    @FindBy(css = "#menu-primary-menu-top-header > li.menu-item")
    List<WebElement> menuItems;

    @CacheLookup
    @FindBy(xpath = "//a[@class='main-nav-item'][normalize-space()='Product Portfolio']")
    WebElement productPortfolio;

    @CacheLookup
    @FindBy(xpath = "(//ul[@class='nav nav-pills nav-pills-main'])[3]/li")
    List<WebElement> productPortfolioSubMenu;

    @CacheLookup
    @FindBy(xpath = "//div[@class='gmm-section-title']//p[1]")
    WebElement missionText;

    @CacheLookup
    @FindBy(xpath = "//ul[@id='menu-secondary-menu-top-right']/li[2]/a[1]")
    WebElement helpSupportButton;


    public void clickOnAcceptCookiesButton() {
        clickOnElement(acceptCookies);
        log.info("Click on Accept Cookies Button");
    }

    public String getPageTitle() {
        log.info("Retrieving page title");
        return driver.getTitle();
    }

    public void clickOnProductPortfolio() {
        log.info("click product portfolio");
        waitUntilVisibilityOfElementLocated(productPortfolio, 10);
        clickOnElement(productPortfolio);
    }

    public String getMissionStatement() {
        log.info("Retrieving mission statement");
        return getTextFromElement(missionText);
    }

    public void helpAndSupport() {
        clickOnElement(helpSupportButton);
        log.info("Click on Help & Support");
    }

    public List<WebElement> getMenuItems() {
        return menuItems;
    }

    public List<WebElement> getSubmenuItems() {
        return productPortfolioSubMenu;
    }
}
package co.gamma.group.pages;

import co.gamma.group.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;


public class HelpSupportPage extends Utility {

    private static final Logger log = LogManager.getLogger(HelpSupportPage.class);

    @CacheLookup
    @FindBy(xpath = "//div[@class='gmm-section-title']//p[1]")
    WebElement subTitle;

    @CacheLookup
    @FindBy(xpath = "a[class='btn btn-primary btn-lg']")
    WebElement communityPortalLink;

    public String getUrl() {
        log.info("Retrieving page title");
        return driver.getCurrentUrl();
    }

    public String getSubTitleText() {
        log.info("Retrieving sub title");
        return getTextFromElement(subTitle);
    }
}
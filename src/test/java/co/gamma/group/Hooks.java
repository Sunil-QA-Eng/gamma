package co.gamma.group;

import co.gamma.group.propertyreader.PropertyReader;
import co.gamma.group.utility.Utility;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends Utility {

    @Before
    public void setUp() {
        selectBrowser(PropertyReader.getInstance().getProperty("browser"));
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            try {
                byte[] screenshot = getScreenShot(); // Ensure this returns PNG byte[]
                scenario.attach(screenshot, "image/png", "Failure Screenshot: " + scenario.getName());
            } catch (Exception e) {
                System.err.println("Failed to capture screenshot: " + e.getMessage());
            }
        }

        closeBrowser();
    }
}
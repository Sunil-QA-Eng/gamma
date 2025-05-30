package co.gamma.group.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class ParkingCostTest {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        try {
            driver.manage().window().maximize();
            driver.get("https://shino.de/parkcalc/");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            driver.findElement(By.name("StartingDate")).clear();
            driver.findElement(By.name("StartingDate")).sendKeys("5/30/2025");

            driver.findElement(By.name("StartingTime")).clear();
            driver.findElement(By.name("StartingTime")).sendKeys("12:00");

            driver.findElement(By.name("LeavingDate")).clear();
            driver.findElement(By.name("LeavingDate")).sendKeys("5/31/2025");

            driver.findElement(By.name("LeavingTime")).clear();
            driver.findElement(By.name("LeavingTime")).sendKeys("12:00");

            driver.findElement(By.xpath("//input[@type='submit']")).click();

            String actualCost = driver.findElement(By.xpath("//span[@class='SubHead']//b")).getText().trim();
            actualCost = actualCost.replace("$ ", "$");

            String perDayText = getPerDayText(driver);

            if (perDayText != null) {
                System.out.println("Found text: " + perDayText);

                String actualCostNumber = actualCost.replaceAll("[^\\d.]", "");
                String perDayNumber = perDayText.replaceAll("[^\\d.]", "");

                System.out.println("Actual cost number: " + actualCostNumber);
                System.out.println("Per day number: " + perDayNumber);

                double actual = Double.parseDouble(actualCostNumber);
                double expected = Double.parseDouble(perDayNumber);

                Assert.assertEquals(actual, expected, 0.01, "Cost values do not match!");
            } else {
                System.out.println("No matching 'per day' text found.");
                Assert.fail("Expected per day text not found on page");
            }
        } finally {
            driver.quit();
        }
    }

    public static String getPerDayText(WebDriver driver) {
        List<WebElement> para = driver.findElements(By.className("BodyCopy"));
        for (WebElement element : para) {
            String text = element.getText();
            String[] lines = text.split("\\r?\\n");
            for (String line : lines) {
                if (line.contains("per day")) {
                    return line.trim();
                }
            }
        }
        return null;
    }
}

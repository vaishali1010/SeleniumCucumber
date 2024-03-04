package Hooks;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.ConfigReader;

import java.time.Duration;

public class ApplicationHooks {
    private WebDriver driver;
    WebDriverWait wait;

    @Before(order = 0)
    public void launchBrowser() {
        String browserName = ConfigReader.getBrowser();
       driver = DriverFactory.init_driver(browserName);
    }

    @Before(order  = 1)
    public void waitBefore() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(webDriver -> "complete".equals(((JavascriptExecutor) webDriver)
                .executeScript("return document.readyState")));

    }

    @BeforeStep
    public void waitBeforeStep(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
    }

    @After(order = 0)
    public void quitBrowser() {
        driver.quit();
    }

   @After(order = 1)
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            // take screenshot:
            String screenshotName = scenario.getName().replaceAll(" ", "_");
            byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(sourcePath, "image/png", screenshotName);

        }
    }
}

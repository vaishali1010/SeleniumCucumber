package factory;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class DriverFactory {
    public static WebDriver driver;

    public static WebDriver init_driver(String browser) {

        System.out.println("browser value is: " + browser);
        try {
            switch (browser) {
                case "chrome":
                    ChromeOptions options = new ChromeOptions();
                    options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                    driver = new ChromeDriver(options);
                    break;
                case "firefox":
                    driver = new FirefoxDriver();
                    break;
                case "Edge":
                    driver = new EdgeDriver();
                    break;

                default:
                    System.out.println("Please pass the correct browser value: " + browser);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
        return driver;
    }

    public static synchronized WebDriver getDriver() {
        return driver;
    }
}

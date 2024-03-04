package util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class ConfigReader {
    private static String browser;
    private static String username;
    private static String password;
    private static String url;

    private static WebDriverWait wait;

    static  {
        try {
            Properties prop = new Properties();
            FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources"
                    + "/config.properties");
            prop.load(ip);
            browser = prop.getProperty("browser");
            username = prop.getProperty("Username");
            password = prop.getProperty("Password");
            url= prop.getProperty("Url");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getBrowser(){
        return browser;
    }

    public static String getUsername(){
        return username;
    }

    public static String getPassword(){
        return password;
    }

    public static String getUrl(){
        return url;
    }

    public static void waitBeforeElementClickable(WebDriver driver, By locator){
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(locator));

    }
}

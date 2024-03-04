package com.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.ConfigReader;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;

    private By emailId=By.name("username");
    private By password=By.name("password");
    private By login=By.cssSelector("button");
    public LoginPage(WebDriver driver){
        this.driver=driver;
    }

    public void enterUserName() {
        ConfigReader.waitBeforeElementClickable(driver,emailId);
        driver.findElement(emailId).sendKeys(ConfigReader.getUsername());
    }

    public void enterPassword() {
        driver.findElement(password).sendKeys(ConfigReader.getPassword());
    }

    public void clickOnLogin() {
        driver.findElement(login).click();
    }

    public void navigateToUrl(String url) {
        driver.navigate().to(url);

    }

}

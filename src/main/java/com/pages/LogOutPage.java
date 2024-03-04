package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.ConfigReader;

public class LogOutPage {

    private WebDriver driver;

    private By profileDropDown= By.className("oxd-userdropdown-name");

    private By logOut= By.xpath("//*[text()='Logout']");

    public LogOutPage(WebDriver driver){
        this.driver=driver;
    }

    public void setLogOut(){
        driver.findElement(profileDropDown).click();
        ConfigReader.waitBeforeElementClickable(driver,logOut);
        driver.findElement(logOut).click();
    }

    public void verifySuccessfulLogOut(){
        driver.getCurrentUrl().contains(ConfigReader.getUrl());
    }
}

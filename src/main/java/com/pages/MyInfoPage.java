package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import util.ConfigReader;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class MyInfoPage  extends LoginPage{

    private WebDriver driver;

    private String date;

    private By myInfo=By.xpath("//*[text()='My Info']");

    private By dates= By.className("oxd-date-input");

    private By oldDate = By.xpath("//input[@placeholder='yyyy-mm-dd']");

    private By calendar = By.className("oxd-date-input-calendar");

    private By save = By.xpath("//button[@type='submit']");

    private By newDate = By.xpath("//*[text()='Today']");

    public MyInfoPage(WebDriver driver){
        super(driver);
        this.driver=driver;
    }

    public WebElement dateOfBirth(){
        List<WebElement> dateList = driver.findElements(dates).get(1).findElements(oldDate);
        return dateList.get(1);
    }

    public void todayDate(){
        ConfigReader.waitBeforeElementClickable(driver,calendar);
        driver.findElement(calendar).click();
        ConfigReader.waitBeforeElementClickable(driver,newDate);
        driver.findElement(newDate).click();
    }

    public void alreadyLogin() {
        navigateToUrl(ConfigReader.getUrl());
        enterUserName();
        enterPassword();
        clickOnLogin();
    }
    public void clickOnMyInfo() {
        ConfigReader.waitBeforeElementClickable(driver,myInfo);
        driver.findElement(myInfo).click();
    }

    public String verifyDate(){
        String existingDate= dateOfBirth().getAttribute("value");
        return existingDate;
    }

    public void changeToNewDate(){
        dateOfBirth().click();
        todayDate();
        ConfigReader.waitBeforeElementClickable(driver, save);
        driver.findElement(save).click();
    }

    public String currentDate(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String date1= dateFormat.format(date);
        return date1;
    }
}

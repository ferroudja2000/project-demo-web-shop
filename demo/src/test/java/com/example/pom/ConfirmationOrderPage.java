package com.example.pom;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ConfirmationOrderPage {
    WebDriver driver;
    By confirmation = By.className("order-completed-continue-button");

    public ConfirmationOrderPage(WebDriver driver){
        this.driver =driver;
    }

    public void Clickconfirmation(){
        WebDriverWait Wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        Wait.until(ExpectedConditions.urlToBe("https://demowebshop.tricentis.com/checkout/completed/"));       
        driver.findElement(confirmation).click();
    }
}



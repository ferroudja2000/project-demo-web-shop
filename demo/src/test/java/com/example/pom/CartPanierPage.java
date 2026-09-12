package com.example.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPanierPage {
    WebDriver driver;

    By agree = By.id("termsofservice");
    By bouton_checkout = By.id("checkout");

    public CartPanierPage(WebDriver driver){
        this.driver = driver;
    }
    public void clickboutonagree(){
        driver.findElement(agree).click();
    }
    public void clickcheckout(){
        driver.findElement(bouton_checkout).click();
    }

}

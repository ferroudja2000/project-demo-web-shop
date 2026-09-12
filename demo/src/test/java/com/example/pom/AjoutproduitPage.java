package com.example.pom;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AjoutproduitPage {
    WebDriver driver;
    By nameproduit = By.className("product-name");
    By recipName =  By.id("giftcard_2_RecipientName");
    By recipEmail = By.id("giftcard_2_RecipientEmail");
    By Btn_ajouter = By.id("add-to-cart-button-2");
    By alert = By.className("content");
    By shoppingcart = By.cssSelector("[href=\'/cart\']");

    


    public AjoutproduitPage(WebDriver driver){
        this.driver = driver;
    }

    public String VerifierName(){
       return  driver.findElement(nameproduit).getText();
    }
    public void Ajoutcart(String n, String s){
        //explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("https://demowebshop.tricentis.com/25-virtual-gift-card"));
        driver.findElement(recipName).sendKeys(n);
        driver.findElement(recipEmail).sendKeys(s);
        driver.findElement(Btn_ajouter).click();
    }

    public boolean getAlert(){
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    return wait.until(ExpectedConditions.visibilityOfElementLocated(alert)).isDisplayed();
    }

    public void clickboutonshopping(){
        driver.findElement(shoppingcart).click();
    }

}

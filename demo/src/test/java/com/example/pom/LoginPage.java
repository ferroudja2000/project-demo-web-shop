package com.example.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;
    By nameOfcount = By.className("account");
    By BTN_logout = By.className("ico-logout");
    By BTN_login = By.className("ico-login");
    By email = By.id("Email");
    By password = By.id("Password");
    By remembercheck = By.id("RememberMe");
    By btn_login = By.className("login-button");
    By addToCart = By.className("product-box-add-to-cart-button");



public LoginPage (WebDriver driver){
    this.driver = driver;
}

public String verifierlogin(){
   return driver.findElement(nameOfcount).getText();
}
public void clickboutonlogout(){
    driver.findElement(BTN_logout).click();
}
public void Clickboutonlogin(){
    driver.findElement(BTN_login).click();
}
public void Saisiremail(String s){
    driver.findElement(email).sendKeys(s);
}
public void Saisirpassword(String m){
    driver.findElement(password).sendKeys(m);
}
public void clickboutonremember(){
    driver.findElement(remembercheck).click();
}
public void Clickboutonlogincnx(){
    driver.findElement(btn_login).click();
}

public void cnx(String s, String m){
    Saisiremail(s);  
    Saisirpassword(m);
    clickboutonremember();
}

public void clickaddtocart(){
        driver.findElement(addToCart).click();
    }


}
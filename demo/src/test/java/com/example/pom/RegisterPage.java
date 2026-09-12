package com.example.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
    WebDriver driver;
    By register = By.className("ico-register");
    By firstname = By.id("FirstName");
    By lastname = By.id("LastName");
    By email = By.id("Email");
    By password1 = By.id("Password");
    By passwor_confirmation = By.id("ConfirmPassword");
    By bouton_register = By.id("register-button");
    By bouton_continue = By.className("register-continue-button");

    public RegisterPage(WebDriver driver){
    this.driver =driver;
}
    public void clickregister(){
    driver.findElement(register).click();
}

    public void saisirfirstnam(String name){
    driver.findElement(firstname).sendKeys(name);
}
  public void saisirlastname(String lname){
    driver.findElement(lastname).sendKeys(lname);
}
  public void saisiremail(String mail){
    driver.findElement(email).sendKeys(mail);
}
 public void saisipassword(String pass){
    driver.findElement(password1).sendKeys(pass);
}
 public void saisirpassconfirmation(String passconf){
    driver.findElement(passwor_confirmation).sendKeys(passconf);
}
public void clickboutonregister(){
    driver.findElement(bouton_register).click();
}

public void clickboutoncontinue(){
    driver.findElement(bouton_continue).click();
}

public void Register(String name, String lname, String mail, String pass, String passconf){
    
    saisirfirstnam(name);
    saisirlastname(lname);
    saisiremail(mail);
    saisipassword(pass);
    saisirpassconfirmation(passconf);  
}

}





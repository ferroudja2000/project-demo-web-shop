package com.example.pom;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {
    WebDriver driver;
    By company = By.id("BillingNewAddress_Company");
    By country = By.id("BillingNewAddress_CountryId");
    By state = By.id("BillingNewAddress_StateProvinceId");
    By city = By.id("BillingNewAddress_City");
    By adresse1 = By.id("BillingNewAddress_Address1");
    By adresse2 = By.id("BillingNewAddress_Address2");
    By codePostal = By.id("BillingNewAddress_ZipPostalCode");
    By phone = By.id("BillingNewAddress_PhoneNumber");
    By fax = By.id("BillingNewAddress_FaxNumber");
    By continue_btn = By.className("new-address-next-step-button");
    By paiement_method = By.id("paymentmethod_2");
    By continue_btn2 = By.className("payment-method-next-step-button");
    By cardholder_name = By.id("CardholderName");
    By card_number = By.id("CardNumber");
    By card_code = By.id("CardCode");
    By continue_btn3 = By.className("payment-info-next-step-button");
    By confirm_btn = By.className("confirm-order-next-step-button");
    By confirm_msg = By.className("title");


    public  CheckoutPage(WebDriver driver){
        this.driver = driver;
    }

    public void fillCompany(String c){
        driver.findElement(company).sendKeys(c);
    }

    public void selectCountry(String c) {
        Select select = new Select(driver.findElement(country));
        select.selectByVisibleText(c);
    }

    public void selectState(String s) {
        //explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("states-loading-progress")));

        Select select = new Select(driver.findElement(state));
        select.selectByVisibleText(s);
    }

     public void fillCity(String c){
        driver.findElement(city).sendKeys(c);
    }

     public void fillAddresse1(String a){
        driver.findElement(adresse1).sendKeys(a);
    }

     public void fillAddresse2(String a){
        driver.findElement(adresse2).sendKeys(a);
    }

     public void fillCodePostal(String c){
        driver.findElement(codePostal).sendKeys(c);
    }

     public void fillPhone(String n){
        driver.findElement(phone).sendKeys(n);
    }

    public void fillfax(String n){
        driver.findElement(fax).sendKeys(n);
    }

    public void clickContinue(){
        driver.findElement(continue_btn).click();
    }

    public void clickPaiementMethodVisa(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(paiement_method)).click();
    }

    public void clickContinue2(){
        driver.findElement(continue_btn2).click();
    }

    public void fillCardholderName(String n) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(cardholder_name));
        driver.findElement(cardholder_name).sendKeys(n);
    }

    public void fillCardNumber(String n) {
        driver.findElement(card_number).sendKeys(n);
    }

    public void fillCardCode(String c) {
        driver.findElement(card_code).sendKeys(c);
    }

    public void clickContinue3() {
        driver.findElement(continue_btn3).click();
    }

    public void clickConfirmbtn() {
         //explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(confirm_btn));
        driver.findElement(confirm_btn).click();
    }



    public boolean getConfirmMsg(){
        return driver.findElement(confirm_msg).isDisplayed();
    }

    public void checkout(String c, String h, String f,String z, String e,String r,String t,String m ){
        fillCompany(c);
        selectCountry(m);
        fillCity(h);
        fillAddresse1(f);
        fillAddresse2(z);
        fillCodePostal(e);
        fillPhone(r);
        fillfax(t);
        clickContinue();

    }

    public void payment(){
        clickPaiementMethodVisa();
        clickContinue2();
        
    }

    public void payementInfo (String p, String l, String m){
        fillCardholderName(p);
        fillCardNumber(l);
        fillCardCode(m);
        clickContinue3();
    }
}

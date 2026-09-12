package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.example.pom.AjoutproduitPage;
import com.example.pom.CartPanierPage;
import com.example.pom.CheckoutPage;
import com.example.pom.ConfirmationOrderPage;
import com.example.pom.LoginPage;
import com.example.pom.RegisterPage;
import com.github.javafaker.Faker;

public class E2EDemoshopTest {
    WebDriver driver;
    RegisterPage rp;
    LoginPage lp;
    AjoutproduitPage ap;
    CartPanierPage cp;
    CheckoutPage mm;
    ConfirmationOrderPage co;


    Faker faker = new Faker();
    String firstname = faker.name().firstName();
    String lastname = faker.name().lastName();
    String email = faker.internet().emailAddress();
    String password = "123456789!";
    String company = faker.company().name();
    String city = faker.address().city();
    String address = faker.address().fullAddress();
    String postalCode = faker.address().zipCode();
    String phoneNumber = faker.phoneNumber().phoneNumber();
    String faxNumber = faker.phoneNumber().phoneNumber();


    @BeforeEach 
    public void Setup(){
        //driver = new ChromeDriver();
            URL gridUrl = null;

         try {
        gridUrl = new URL("http://127.0.0.1:4444");
         } catch (MalformedURLException e) {
        e.printStackTrace();
        }

    ChromeOptions cr = new ChromeOptions();

    driver = new RemoteWebDriver(gridUrl, cr);
    driver.get("https://demowebshop.tricentis.com/");

        rp = new RegisterPage(driver);
        lp = new LoginPage(driver);
        ap = new AjoutproduitPage(driver);
        cp = new CartPanierPage(driver);
        mm = new CheckoutPage(driver);
        co = new ConfirmationOrderPage(driver);   
        }
 @AfterEach 
    public void TearDown(){
           if(driver != null){
            driver.quit();
            driver = null;
        }
    }


    @Test 
    public void Register(){

// inscription

    rp.clickregister();
    assertEquals("https://demowebshop.tricentis.com/register", driver.getCurrentUrl());
    rp.Register(firstname,lastname,email,password,password);
    rp.clickboutonregister();
    assertEquals("https://demowebshop.tricentis.com/registerresult/1", driver.getCurrentUrl());
    rp.clickboutoncontinue();
    assertEquals("https://demowebshop.tricentis.com/",driver.getCurrentUrl());
       
 //se connecter
    
        lp.clickboutonlogout();
        lp.Clickboutonlogin();
        assertEquals("https://demowebshop.tricentis.com/login",driver.getCurrentUrl());
        lp.cnx(email,password);
        lp.Clickboutonlogincnx();
        assertEquals(email,lp.verifierlogin());
        lp.clickaddtocart();

//Ajout produit
       // assertEquals("$25 Virtual Gift Card",ap.VerifierName());
        ap.Ajoutcart(lastname, email);
        assertTrue(ap.getAlert());
        ap.clickboutonshopping();
        assertEquals("https://demowebshop.tricentis.com/cart", driver.getCurrentUrl());
    
//valider le painier 
    cp.clickboutonagree();
    cp.clickcheckout();
    assertEquals("https://demowebshop.tricentis.com/onepagecheckout", driver.getCurrentUrl());

//remplir le formulaire checkout
        mm.checkout(company, city, address, address, postalCode, phoneNumber, faxNumber, "France");
        mm.payment();
        mm.payementInfo(lastname, "4634511634511630", "685");
        mm.clickConfirmbtn();
        assertTrue(mm.getConfirmMsg());
        //assertEquals("https://demowebshop.tricentis.com/checkout/completed/", driver.getCurrentUrl());

//confirmation order
        co.Clickconfirmation();
        assertEquals("https://demowebshop.tricentis.com/", driver.getCurrentUrl());

    }
}
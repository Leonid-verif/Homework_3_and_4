package test.java.lesson8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.*;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class amazon_1 {


    By searchInputBy = By.id("nav-link-accountList");
    By signIn2 = By.xpath("//span[@class=\"nav-action-inner\"]");
    By createAcc = By.id("createAccountSubmit");
    By getCreateAcc2 = By.id("continue");
    By yourName = By.id("ap_customer_name");
    By email = By.id("ap_email");
    By pass = By.id("ap_password");
    By enterYourName = By.xpath("//div[@id=\"auth-customerName-missing-alert\"]//div//div");
    By enterYourEmail = By.xpath("//div[@id=\"auth-email-missing-alert\"]//div//div");
    By enterYourPass = By.xpath("//div[@id=\"auth-password-missing-alert\"]//div//div");
    WebDriver driver;
    WebDriverWait wait;


    @BeforeMethod
    public void initializeBrowser() {
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver,10,500);
    }

    @Test
    public  void test1() throws InterruptedException {
        driver.get("https://www.amazon.com/");
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement signIn = driver.findElement(searchInputBy);
        Actions actions = new Actions(driver);
        actions
                .moveToElement(signIn)
                .build().perform();
        wait.until(ExpectedConditions.elementToBeClickable(signIn));
//        Thread.sleep(1000);
        actions.moveToElement(signIn);
        wait.until(ExpectedConditions.elementToBeClickable(signIn2));
        driver.findElement(signIn2).click();

        wait.until(ExpectedConditions.elementToBeClickable(createAcc));
        driver.findElement(createAcc).click();

        wait.until(ExpectedConditions.elementToBeClickable(getCreateAcc2));
        driver.findElement(getCreateAcc2).click();


        wait.until(ExpectedConditions.elementToBeClickable(yourName));
        driver.findElement(yourName);
        String expectedColor = "rgb(221, 0, 0)";
        String actualColor = driver.findElement(yourName).getCssValue("border-color");
        assertEquals(actualColor,expectedColor);

        wait.until(ExpectedConditions.elementToBeClickable(email));
        driver.findElement(email);
        String actualColor2 = driver.findElement(email).getCssValue("border-color");
        assertEquals(actualColor2,expectedColor);
        wait.until(ExpectedConditions.elementToBeClickable(pass));
        driver.findElement(pass);
        String actualColor3 = driver.findElement(pass).getCssValue("border-color");
        assertEquals(actualColor3,expectedColor);


        wait.until(ExpectedConditions.elementToBeClickable(enterYourName));
        driver.findElement(enterYourName);
        String actualName = driver.findElement(enterYourName).getText();
        String expectedName = "Enter your name";
        assertEquals(actualName,expectedName);

        wait.until(ExpectedConditions.elementToBeClickable(enterYourEmail));

        driver.findElement(enterYourEmail);
        String actualEmail = driver.findElement(enterYourEmail).getText();
        String expectedEmail = "Enter your email";
        assertEquals(actualEmail,expectedEmail);

        wait.until(ExpectedConditions.elementToBeClickable(enterYourPass));
        driver.findElement(enterYourPass);
        String actualPass = driver.findElement(enterYourPass).getText();
        String expectedPass = "Enter your password";
        assertEquals(actualPass,expectedPass);




    }
    @AfterMethod
    public void finalizeBrowser(){
        driver.quit();
    }


}


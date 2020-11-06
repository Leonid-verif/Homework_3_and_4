package test.java.lesson8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class amazon_2 {
    WebDriver driver;
    By helloSignIn = By.id("nav-link-accountList");
    By signIn2 = By.xpath("//span[@class=\"nav-action-inner\"]");
    By createAcc = By.id("createAccountSubmit");
    By inputYourName = By.id("ap_customer_name");
    By inputYourEmail = By.id("ap_email");
    By inputYourPass = By.id("ap_password");
    By getCreateAcc2 = By.id("continue");

    By yourName = By.id("ap_customer_name");
    By email = By.id("ap_email");
    By pass = By.id("ap_password");

    By rePass = By.id("ap_password_check");
    WebDriverWait wait;

    @BeforeMethod
    public void initializeBrowser() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver,10,500);
    }



    @Test
    public void test1 () throws InterruptedException {
        driver.get("https://www.amazon.com/");

        WebElement signIn = driver.findElement(helloSignIn);
        Actions actions = new Actions(driver);
        actions
                .moveToElement(signIn)
                .build().perform();


        wait.until(ExpectedConditions.elementToBeClickable(signIn));
        actions.moveToElement(signIn);
        wait.until(ExpectedConditions.elementToBeClickable(signIn2));
        driver.findElement(signIn2).click();

        wait.until(ExpectedConditions.elementToBeClickable(createAcc));
        driver.findElement(createAcc).click();


        wait.until(ExpectedConditions.elementToBeClickable(inputYourName));

        driver.findElement(inputYourName).sendKeys("Leonid");
        driver.findElement(inputYourEmail).sendKeys("leonid.minfin@gmail.com");
        driver.findElement(inputYourPass).sendKeys("qwerty123");
        driver.findElement(getCreateAcc2).click();
//        Thread.sleep(3000);

        wait.until(ExpectedConditions.elementToBeClickable(yourName));

        driver.findElement(yourName);
        String expectedColor = "rgb(148, 148, 148) rgb(166, 166, 166) rgb(166, 166, 166)";
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
        wait.until(ExpectedConditions.elementToBeClickable(rePass));
        driver.findElement(rePass);
        String expectedColorRed = "rgb(221, 0, 0)";
        String actualColorRed = driver.findElement(rePass).getCssValue("border-color");
        assertEquals(actualColor,expectedColor);




    }

    @AfterMethod
    public void finalizeBrowser () {
        driver.quit();
    }
}

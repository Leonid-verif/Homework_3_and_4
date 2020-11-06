package test.java.lesson8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class amazon_price {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        WebDriver driver = new ChromeDriver(chromeOptions);
        WebDriverWait wait = new WebDriverWait(driver, 10,500);
        driver.get("https://www.amazon.com/");




        By byBestSeller = By.xpath("//a[@href=\"/international-sales-offers/b/?ie=UTF8&node=15529609011&ref_=nav_cs_gb_intl\"]");

        WebElement bestSellersBtn = driver.findElement(byBestSeller);
        wait.until(ExpectedConditions.elementToBeClickable(byBestSeller));
        bestSellersBtn.click();



        WebElement firstProduct = driver.findElement(By.xpath("//div[@id=\"100_dealView_0\"]//div[2]//a"));
        wait.until(ExpectedConditions.elementToBeClickable(firstProduct));
        firstProduct.click();
//     Thread.sleep(3000);

//        WebElement prdct = driver.findElement(By.xpath("//a[@class=\"a-link-normal\"]"));
//        wait.until(ExpectedConditions.elementToBeClickable(prdct));



        WebElement best = driver.findElement(By.xpath("//div[@class=\"a-row octopus-dlp-price\"]/span/span/span[2]"));
        wait.until(ExpectedConditions.visibilityOfAllElements(best));
        wait.until(ExpectedConditions.elementToBeClickable(best));
        String titleBest =  best.getText();
        WebElement best1 = driver.findElement(By.xpath("//div[@class=\"a-row octopus-dlp-price\"]/span/span/span[3]"));
        wait.until(ExpectedConditions.visibilityOfAllElements(best1));
        wait.until(ExpectedConditions.elementToBeClickable(best1));
        String titleBest1 =  best1.getText();
        WebElement best2 = driver.findElement(By.xpath("//div[@class=\"a-row octopus-dlp-price\"]/span[2]/span[2]"));
        wait.until(ExpectedConditions.visibilityOfAllElements(best2));
        wait.until(ExpectedConditions.elementToBeClickable(best2));
        String titleBest2 =  best2.getText();


        System.out.println("New price: " + titleBest + "." + titleBest1 + " Old price: " +  titleBest2.replace("$",""));
        driver.close();
    }
}


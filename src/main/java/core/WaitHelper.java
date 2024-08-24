package core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitHelper {
    private static WebDriver driver;

    public WaitHelper(WebDriver driver) {
        this.driver = driver;
    }

    public static void waitUntilVisibility(WebElement element, int sec){
        new WebDriverWait(driver, Duration.ofSeconds(sec))
                .until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitUntilVisibility(WebElement element){
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitUntilClickable(WebElement element, int sec){
        new WebDriverWait(driver, Duration.ofSeconds(sec))
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitUntilClickable(WebElement element){
        new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitUntilVisibility(By locator, int sec){
        new WebDriverWait(driver, Duration.ofSeconds(sec))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void waitUntilVisibility(By locator){
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void pause(int sec) throws InterruptedException {
        Thread.sleep(sec * 1000);
    }
}

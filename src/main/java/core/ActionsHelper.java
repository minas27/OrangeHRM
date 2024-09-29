package core;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static core.WaitHelper.waitUntilClickable;
import static core.WaitHelper.waitUntilVisibility;

public class ActionsHelper {
    private static Select select;

    public static void selectByVisibleText(WebElement element, String visibleText){
        select = new Select(element);
        select.selectByVisibleText(visibleText);
    }

    public static void selectByValue(WebElement element, String value){
        select = new Select(element);
        select.selectByValue(value);
    }

    public static boolean isDisplayed(WebElement element){
        try{
            waitUntilVisibility(element);
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public static void scrollDown(WebDriver driver, int pixel){
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript(String.format("window.scrollBy(0, %s)", pixel));
    }

    public static void scrollIntoView(WebElement driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void click(WebElement element) {
        waitUntilClickable(element);
        element.click();
    }

    public static void insertData(WebElement element, String data) {
        waitUntilVisibility(element);
        element.sendKeys(data);
    }

}

package demoProject;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UiElements {	
	public static void clickElement(WebDriver driver,By locator) {
		driver.findElement(locator).click();
	}
	
	public static void enterText(WebDriver driver,By locator,String text) {
		driver.findElement(locator).clear();
		driver.findElement(locator).sendKeys(text);
	}
	
	public static boolean waitForElementVisisble(WebDriver driver,By locator) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return element.isDisplayed();
		
	}
	
	//Important
	public static void slideToElement(WebDriver driver,By locator) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(locator));
	}
	
	
	

}

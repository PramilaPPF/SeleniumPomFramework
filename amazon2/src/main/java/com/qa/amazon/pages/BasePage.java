package com.qa.amazon.pages;

import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.qa.amazon.abstraction.Page;
import io.appium.java_client.android.AndroidDriver;

/**
 * Created by Pramila Fulari on 9/23/2019.
 */
public class BasePage implements Page {

	public AndroidDriver driver;
	public WebDriverWait wait;
	public Logger log = Logger.getLogger(Logger.class.getName());

	public BasePage(AndroidDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}

	public String getElementText(By locator) {
		return driver.findElement(locator).getText();
	}

	public WebElement getElement(By locator) {
		WebElement element = null;
		try {
			driver.findElement(locator);
			return element;
		} catch (Exception e) {
			log.info("error occured in getting an element" + locator.toString());
		}
		return element;
	}

	public void waitForPageElementPresent(By locator) {
		try {
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
		} catch (Exception e) {
			log.info("error occured in waiting an element" + locator.toString());
		}
	}

	public void waitAndClick(By locator) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(locator));
			driver.findElement(locator).click();
		} catch (Exception e) {
			log.info("error occured in Clicking on element" + locator.toString());
		}

	}

	public void presenceOfElement(By locator) {
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	// method with Java Generic and return a new page
	public <TPage> TPage getInstance(Class<TPage> pageClass) {
		try {
			return pageClass.getDeclaredConstructor(AndroidDriver.class, WebDriverWait.class).newInstance(this.driver,
					this.wait);
		} catch (Exception e) {
			log.info("Error occured in instantiating page and returning null");
			return null;
		}
	}

}

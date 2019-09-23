package com.qa.amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import io.appium.java_client.android.AndroidDriver;
/**
 * Created by Pramila Fulari on 9/23/2019.
 */

public class CategorySelectionPage extends BasePage {

	public CategorySelectionPage(AndroidDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}

	// page locators:

	private By electronics = By.xpath("//android.view.View[contains(@text, 'TV, Appliances, Electronics')]");

	private By kindle = By.xpath("//android.view.View[contains(@text, 'Kindle E-Readers & eBooks')]");

	private By kindleEreader = By.xpath("//android.view.View[contains(@text, 'Kindle E-Readers ')]");

	/*
	 * 
	 *  To simulate error when element(kindleEreader) does not exist on expected page
	 */ 
	 // By nonexistingElement = By.xpath("//android.view.View[contains(@text,'nonexistingElement')]");
	

	public WebElement getElectronics() {
		waitForPageElementPresent(electronics);
		return getElement(electronics);
	}

	public WebElement getKindle() {
		waitForPageElementPresent(kindle);
		return getElement(kindle);
	}

	public WebElement getKindleEreader() {
		waitForPageElementPresent(kindleEreader);
		return getElement(kindleEreader);
	}

	public void clickElectronincs() {
		waitForPageElementPresent(electronics);
		waitAndClick(electronics);
	}
	
	public void clickKindle() {
		waitForPageElementPresent(kindle);
		waitAndClick(kindle);
	}
	
	
	public void verifyKindleElement()  {
		waitAndClick(electronics);
		Assert.assertEquals(getElementText(electronics), "TV, Appliances, Electronics");
		waitAndClick(kindle);
		Assert.assertEquals(getElementText(kindle), "Kindle E-Readers & eBooks");
		presenceOfElement(kindleEreader);
		Assert.assertEquals(getElementText(kindle), "Kindle E-Readers & eBooks");
		
	}
	
	



}

package com.qa.amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.android.AndroidDriver;
/**
 * Created by Pramila Fulari on 9/23/2019.
 */

public class LandingPage extends BasePage {

	public LandingPage(AndroidDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}

	// page locators:
	private By shopByCatgory = By.xpath("//android.widget.TextView[contains(@text, 'Shop by Category')]");
	private By header = By.xpath("//android.widget.TextView[contains(starts-with(@text,'Shop')]");
	private By hamburger = By.xpath(
			"//android.widget.ImageView[@resource-id='in.amazon.mShop.android.shopping:id/action_bar_burger_icon']");


	
	public WebElement getHamburger() {
		waitForPageElementPresent(hamburger);
		return getElement(hamburger);		
	}

	public WebElement getShopByCategory() {
		waitForPageElementPresent(shopByCatgory);
		return getElement(shopByCatgory);
	}

	public WebElement getHeader() {
		waitForPageElementPresent(header);
		return getElement(header);
	}
	
	
	public void clickHamburger() {
		waitForPageElementPresent(hamburger);
		waitAndClick(hamburger);
	}

	public CategorySelectionPage selectShopByCategory() {
		waitAndClick(shopByCatgory);		
		return getInstance(CategorySelectionPage.class);
	}

}

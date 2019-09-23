package com.qa.amazon.abstraction;

import org.openqa.selenium.By;
/**
 * Created by Pramila Fulari on 9/23/2019.
 */
public interface Page {
	
	public void waitForPageElementPresent(By locator);
	public <TPage> TPage getInstance(Class<TPage> pageClass);
}

package com.qa.amazon.tests;

import org.testng.Reporter;
import org.testng.annotations.Test;
import com.qa.amazon.pages.LandingPage;
import com.qa.amazon.pages.CategorySelectionPage;
/**
 * Created by Pramila Fulari on 9/23/2019.
 */

public class VerifyKindleTest extends BaseTest {
	

	@Test(priority = 1)
	public void shopByCategoryclickTest() {
		page.getInstance(LandingPage.class).clickHamburger();
		log.info("Hamburger clicked Successfully");
		Reporter.log("Hamburger button Clicked");
	}

	@Test(priority = 2)
	public void verifyKindleTest() throws Exception {
		CategorySelectionPage loginpage=page.getInstance(LandingPage.class).selectShopByCategory();
		log.info("ShopByCategory Tapped Successfully");
		Reporter.log("ShopByCategory Tapped Clicked");
		page.getInstance(CategorySelectionPage.class).verifyKindleElement();		
		Reporter.log("Kindle E-Readers element is verification done");
	}
	
}

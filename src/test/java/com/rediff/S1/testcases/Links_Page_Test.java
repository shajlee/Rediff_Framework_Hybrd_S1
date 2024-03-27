package com.rediff.S1.testcases;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.rediff.S1.pages.S1_LinksPage;
import com.rediff.S1.testbase.Rediff_S1_TestBase;

public class Links_Page_Test extends Rediff_S1_TestBase {

	public Links_Page_Test() throws Exception {
		super();

	}

	public static SoftAssert softAssert = new SoftAssert();

	@BeforeMethod
	public void setUp() {
		driver = launchBrowserAndStartApplication(configProp.getProperty("browserName1"));
	}

	@Test
	public void linkTests() {
		S1_LinksPage links = new S1_LinksPage(driver);
		links.clickOnRediffMail();
        WebElement rediffMailLogo = links.rediffMailLogo();
		softAssert.assertTrue(rediffMailLogo.isDisplayed(), "rediffMailLogo is not displayed");
		softAssert.assertAll();
		System.out.println("RediffMail is functional");
		driver.navigate().back();

		links.clickOnRediffMoney();
        WebElement rediffMoneyLogo = links.rediffMoneyLogo();
		softAssert.assertTrue(rediffMoneyLogo.isDisplayed(), "rediffMoneyLogo is not displayed");
		softAssert.assertAll();
		System.out.println("RediffMoney is functional");
		driver.navigate().back();

		links.clickOnRediffBusinessMail();
        WebElement businessMailLogo = links.rediffBusinessMailLogo();
		softAssert.assertTrue(businessMailLogo.isDisplayed(), "businessMailLogo is not displayed");
		softAssert.assertAll();
		System.out.println("businessMail is functional");
		driver.navigate().back();

		links.clickOnRediffVideosLink();
        WebElement videos = links.rediffVideosLogo();
		softAssert.assertTrue(videos.isDisplayed(), "videos is not displayed");
		softAssert.assertAll();
		System.out.println("videos is functional");
		driver.navigate().back();

		links.clickOnRediffShoppingLink();
        WebElement shopping = links.rediffShoppingLogo();
		softAssert.assertTrue(shopping.isDisplayed(), "shopping is not displayed");
		softAssert.assertAll();
		System.out.println("shopping is functional");
		driver.navigate().back();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}

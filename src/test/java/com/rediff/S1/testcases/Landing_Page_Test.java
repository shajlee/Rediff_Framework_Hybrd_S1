package com.rediff.S1.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.rediff.S1.pages.S1_LandingPage;
import com.rediff.S1.testbase.Rediff_S1_TestBase;

public class Landing_Page_Test extends Rediff_S1_TestBase {

	public Landing_Page_Test() throws Exception {
		super();

	}

	public static SoftAssert softAssert = new SoftAssert();

	@BeforeMethod
	public void setUp() {
		driver = launchBrowserAndStartApplication(configProp.getProperty("browserName1"));

	}

	@Test(priority = 1)
	public void validateCurrentUrlAndTile() {
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());

		String actualCurrentUrl = configProp.getProperty("actualUrl");
		String expectedCurrentUrl = driver.getCurrentUrl();

		String actualTitle = configProp.getProperty("actualTitle");
		String expectedTitle = driver.getTitle();

		if (actualCurrentUrl.equals(expectedCurrentUrl) && actualTitle.equals(expectedTitle)) {
			System.out.println("The Landing Page is valid and functional");
		} else {
			System.out.println("The Landing Page is invalid and non-functional");
		}
	}

	@Test(priority = 2)
	public void signInButtonIsDisplayedAndEnabled() {
		S1_LandingPage landingPage = new S1_LandingPage(driver);
		landingPage.SignInButton();
        softAssert.assertTrue(landingPage.SignInButtonIsDisplayed(), "signInButton is not displayed and enabled");
		softAssert.assertAll();

	}

	@Test(priority = 3)
	public void rediffLogoIsDisplayed() {
		S1_LandingPage landingPage = new S1_LandingPage(driver);
		landingPage.RediffLogo();
		softAssert.assertTrue(landingPage.RediffLogoIsDisplayed(), "rediffLogo is not displayed");
		softAssert.assertAll();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}

package com.rediff.S1.testcases;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.rediff.S1.pages.S1_LogoutPage;
import com.rediff.S1.testbase.Rediff_S1_TestBase;

public class Logout_Page_Test extends Rediff_S1_TestBase {

	public Logout_Page_Test() throws Exception {
		super();

	}

	public static SoftAssert softAssert = new SoftAssert();

	@BeforeMethod
	public void setUp() throws Exception {
		driver = launchBrowserAndStartApplication(configProp.getProperty("browserName1"));
		S1_LogoutPage logOutPage = new S1_LogoutPage(driver);
		logOutPage.clickOnSignInLink();
		logOutPage.enterUsername(configProp.getProperty("validUsername"));
		logOutPage.enterPassword(configProp.getProperty("validPassword"));
		logOutPage.clickOnSignInButton();
		Thread.sleep(1000);
	}

	@Test
	public void signOutMessageIsDisplayed() {
		S1_LogoutPage logOutPage = new S1_LogoutPage(driver);
		logOutPage.clickOnLogOutButton();
		WebElement logoutMessage = logOutPage.logOutMessage();
		softAssert.assertTrue(logOutPage.logOutMessageIsDisplayed(), "logoutMessage is not displayed");
		softAssert.assertAll();

		if (logoutMessage.isDisplayed()) {
			System.out.println("Logout is functional");
		} else {

			System.out.println("Logout is not functional");
		}
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}

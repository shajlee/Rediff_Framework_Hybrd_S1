package com.rediff.S1.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.rediff.S1.pages.S1_SignInLinkPage;
import com.rediff.S1.testbase.Rediff_S1_TestBase;

public class Sign_In_Link_Page_Test extends Rediff_S1_TestBase {
	
	public Sign_In_Link_Page_Test() throws Exception {
		super();
		
	}
	public static SoftAssert softAssert = new SoftAssert();
	
	@BeforeMethod
	public void setUp() {
		driver = launchBrowserAndStartApplication(configProp.getProperty("browserName1"));
	}
	
	@Test
	public void signInLinkButtonIsDisplayed() {
		S1_SignInLinkPage signInLink = new S1_SignInLinkPage(driver);
		signInLink.SignInButton();
		softAssert.assertTrue(signInLink.SignInButtonIsDisplayed(), "signInButton is not displayed.");
		softAssert.assertAll();
		System.out.println("Sign In Link Display is Functional");
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
		
		
	}

}

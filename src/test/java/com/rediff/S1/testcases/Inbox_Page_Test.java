package com.rediff.S1.testcases;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.rediff.S1.pages.S1_InboxPage;
import com.rediff.S1.testbase.Rediff_S1_TestBase;

public class Inbox_Page_Test extends Rediff_S1_TestBase {
	public Inbox_Page_Test() throws Exception {
		super();
		
	}
	public static SoftAssert softAssert = new SoftAssert();
	
	@BeforeMethod
	public void setUp() throws Exception {
		driver = launchBrowserAndStartApplication(configProp.getProperty("browserName1"));
		S1_InboxPage inboxPage = new S1_InboxPage(driver);
		inboxPage.clickOnSignInLink();
		inboxPage.enterUsername(configProp.getProperty("validUsername"));
		inboxPage.enterPassword(configProp.getProperty("validPassword"));
		inboxPage.clickOnSignInButton();
		Thread.sleep(1000);
	}
	@Test(priority = 1)
	public void presenceOfInboxButton() {
		S1_InboxPage inboxPage = new S1_InboxPage(driver);
		WebElement inboxButton = inboxPage.inboxLogo(); 
		softAssert.assertTrue(inboxPage.inboxLogoIsDisplayed(), "inboxButton is not displayed");
		softAssert.assertAll();
		
		if(inboxButton.isDisplayed()) {
			System.out.println("Inbox Test is Functional");
		}else {
			System.out.println("Inbox Test is not Functional");
		}
		
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
		
		
		
		
		
		
	}

}

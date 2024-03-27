package com.rediff.S1.testcases;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.rediff.S1.pages.S1_HomePage;
import com.rediff.S1.testbase.Rediff_S1_TestBase;

public class Rediff_Home_Button_Page_Test extends Rediff_S1_TestBase {
	
	public Rediff_Home_Button_Page_Test() throws Exception {
		super();
		
	}
	public static SoftAssert softAssert = new SoftAssert();
	
	@BeforeMethod
	public void setUp() throws Exception {
		driver = launchBrowserAndStartApplication(configProp.getProperty("browserName1"));
		S1_HomePage homeButton = new S1_HomePage(driver);
		homeButton.clickOnSignInLink();
		homeButton.enterUsername(configProp.getProperty("validUsername"));
		homeButton.enterPassword(configProp.getProperty("validPassword"));
		homeButton.clickOnSignInButton();
		
		Thread.sleep(1000);
	}
	@Test
	public void presenceOfRediffLogo() {
		S1_HomePage homeButton = new S1_HomePage(driver);
		homeButton.clickOnLogOutButton();
		homeButton.clickOnRediffHomeButton();
		WebElement rediffLogo = homeButton.rediffLogo();
		softAssert.assertTrue(homeButton.rediffLogoIsDisplayed(), "rediffLogo is not displayed");
		softAssert.assertAll();
		
		if(rediffLogo.isDisplayed()) {
			System.out.println("Rediff Home Button is Functional");
		}else {
			System.out.println("Rediff Home Button is not Functional");
		}
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
		
		
	}

}

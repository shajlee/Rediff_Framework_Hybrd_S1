package com.rediff.S1.testcases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.rediff.S1.pages.S1_LoginPage;
import com.rediff.S1.testbase.Rediff_S1_TestBase;
import com.rediff.S1.testdata.Supply_TestData;
import com.rediff.S1.utilities.S1_Utilities;

public class Login_Page_Test extends Rediff_S1_TestBase {

	public Login_Page_Test() throws Exception {
		super();

	}

	public static SoftAssert softAssert = new SoftAssert();

	@BeforeMethod
	public void setUp() {
		driver = launchBrowserAndStartApplication(configProp.getProperty("browserName1"));
		S1_LoginPage loginPage = new S1_LoginPage(driver);
		loginPage.clickOnSignInLink();

	}

	@Test(priority = 1, dataProvider = "RediffS1DataProviderSupply", dataProviderClass = Supply_TestData.class)
	public void loginWithValidCredentials(String userName, String passWord) throws Exception {
		S1_LoginPage loginPage = new S1_LoginPage(driver);
		loginPage.enterUsername(userName);
        loginPage.enterPassword(passWord);
        loginPage.clickOnSignInButton();
        Thread.sleep(1000);
		WebElement profileName = loginPage.profileName(); 
		softAssert.assertTrue(loginPage.profileNameIsDisplayed(), "profileName is not displayed");
		softAssert.assertAll();

		if (profileName.isDisplayed()) {
			System.out.println("Login with valid credentials is functional");
		} else {
			System.out.println("Login with valid credentials is not functional");
		}
	}

	@Test(priority = 2, dataProvider = "RediffExcelDataWithDataProvider", dataProviderClass = Supply_TestData.class)
	public void loginWithValidCredentialsUsingDataProviderExcelSheet(String userName, String passWord) throws Exception {
		S1_LoginPage loginPage = new S1_LoginPage(driver);
		loginPage.enterUsername(userName);
		loginPage.enterPassword(passWord);
		loginPage.clickOnSignInButton();;
		Thread.sleep(1000);
		WebElement profileName = loginPage.profileName(); 
		softAssert.assertTrue(loginPage.profileNameIsDisplayed(), "profileName is not displayed");
		softAssert.assertAll();

		if (profileName.isDisplayed()) {
			System.out.println("Login with valid credentials is functional");
		} else {
			System.out.println("Login with valid credentials is not functional");
		}

	}

	@Test(priority = 3)
	public void loginWithInvalidCredetials() throws Exception {
		S1_LoginPage loginPage = new S1_LoginPage(driver);
		loginPage.enterUsername(S1_Utilities.GenerateEmailWithTimeStamp());
		loginPage.enterPassword(S1_Utilities.GeneratePasswordWithTimeStamp());
		loginPage.clickOnSignInButton();;
		Thread.sleep(1000);
		WebElement wrongCredentialsMessage = loginPage.wrongCredentialsMessage(); 
		softAssert.assertTrue(loginPage.wrongCredentialsMessageIsDisplayed(), "wrongCredentialsMessage is not displayed");
		softAssert.assertAll();
		
		if (wrongCredentialsMessage.isDisplayed()) {
			System.out.println("Log in with invalid credentials is functional");
		}else {
			System.out.println("Log in with invalid credentials is not functional");
		}
	}

	@Test(priority = 4)
	public void loginWithValidUsernameInvalidPassword() throws Exception {
		S1_LoginPage loginPage = new S1_LoginPage(driver);
		loginPage.enterUsername(configProp.getProperty("validUsername"));
		loginPage.enterPassword(S1_Utilities.GeneratePasswordWithTimeStamp());
		loginPage.clickOnSignInButton();;
		Thread.sleep(1000);
		WebElement wrongCredentialsMessage = loginPage.wrongCredentialsMessage(); 
		softAssert.assertTrue(loginPage.wrongCredentialsMessageIsDisplayed(), "wrongCredentialsMessage is not displayed");
		softAssert.assertAll();
		
		if (wrongCredentialsMessage.isDisplayed()) {
			System.out.println("Log in with valid username invalid password is functional");
		}else {
			System.out.println("Log in with valid username invalid password is not functional");
		}
	}

	@Test(priority = 5)
	public void loginWithInValidUsernameValidPassword() throws Exception {
		S1_LoginPage loginPage = new S1_LoginPage(driver);
		loginPage.enterUsername(S1_Utilities.GenerateEmailWithTimeStamp());
		loginPage.enterPassword(configProp.getProperty("validPassword"));
		loginPage.clickOnSignInButton();
		Thread.sleep(1000);
		WebElement tempIssueMessage =  loginPage.temporaryIssueMessage(); 
		softAssert.assertTrue(loginPage.temporaryIssueMessageIsDisplayed(), "tempIssueMessage is not displayed");
		softAssert.assertAll();
		
		if (tempIssueMessage.isDisplayed()) {
			System.out.println("Log in with invalid username valid password is functional");
		}else {
			System.out.println("Log in with invalid username valid password is not functional");
		}
	}

	@Test(priority = 6)
	public void loginWithNoCredentials() throws Exception {
		S1_LoginPage loginPage = new S1_LoginPage(driver);
		loginPage.enterUsername("");
		loginPage.enterPassword("");
		loginPage.clickOnSignInButton();;
		Thread.sleep(1000);

		Alert alert = driver.switchTo().alert();
		String actualAlertText = configProp.getProperty("actualAlertText");
		String expectedAlertText = alert.getText();

		softAssert.assertEquals(actualAlertText, expectedAlertText);
		if (actualAlertText.equals(expectedAlertText)) {
			alert.accept();
			System.out.println("Log in with no credentials is behaving as expected");
		} else {
			System.out.println("Log in with no credentials is not behaving as expected");
		}
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();

	}

}

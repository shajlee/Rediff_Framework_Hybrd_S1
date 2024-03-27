package com.rediff.S1.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class S1_HomePage {
	public WebDriver driver;
	
	@FindBy(linkText = "Sign in")
	private WebElement signinLink;
	
	@FindBy(css = "input#login1")
	private WebElement usernameTextBox;
	
	@FindBy(css = "input#password")
	private WebElement passwordTextBox;
	
	@FindBy(css = "input.signinbtn")
	private WebElement signinButton;
	
	@FindBy(css = "a.rd_logout")
	private WebElement logoutButton;
	
	@FindBy(css = "div.header div a+span a+a b")
	private WebElement rediffHomeButton;
	
	@FindBy(css = "span.hmsprite.logo")
	private WebElement rediffLogo;
	
	public S1_HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void clickOnSignInLink() {
		signinLink.click();
	}
	public void enterUsername(String usernameText) {
		usernameTextBox.sendKeys(usernameText);
	}
	public void enterPassword(CharSequence passwordText) {
		passwordTextBox.sendKeys(passwordText);
	}
	public void clickOnSignInButton() {
		signinButton.click();
	}
	public void clickOnLogOutButton() {
		 logoutButton.click();
	}
	public void clickOnRediffHomeButton() {
		rediffHomeButton.click();
	}
	public WebElement rediffLogo() {
		return rediffLogo;
	}
	public boolean rediffLogoIsDisplayed() {
		boolean displayStatus = rediffLogo.isDisplayed();
		return displayStatus;
	}

}

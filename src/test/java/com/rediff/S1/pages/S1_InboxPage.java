package com.rediff.S1.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class S1_InboxPage {
	public WebDriver driver;
	
	@FindBy(linkText = "Sign in")
	private WebElement signinLink;
	
	@FindBy(css = "input#login1")
	private WebElement usernameTextBox;
	
	@FindBy(css = "input#password")
	private WebElement passwordTextBox;
	
	@FindBy(css = "input.signinbtn")
	private WebElement signinButton;
	
	@FindBy(css = "a.rd_active")
	private WebElement inboxLogo;
	
	public S1_InboxPage(WebDriver driver) {
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
	public WebElement inboxLogo() {
		return inboxLogo;
	}
	public boolean inboxLogoIsDisplayed() {
		boolean displayStatus = inboxLogo.isDisplayed();
		return displayStatus;
		
		
		
	
	}
	
	
	

}

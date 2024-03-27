package com.rediff.S1.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class S1_LoginPage {
	public WebDriver driver;
	
	@FindBy(linkText = "Sign in")
	private WebElement signinLink;
	
	@FindBy(css = "input#login1")
	private WebElement usernameTextBox;
	
	@FindBy(css = "input#password")
	private WebElement passwordTextBox;
	
	@FindBy(css = "input.signinbtn")
	private WebElement signinButton;
	
	@FindBy(css = "span.rd_tp-rgt")
	private WebElement profileName;
	
	@FindBy(css = "div#div_login_error b")
	private WebElement wrongCredentialsMessage;
	
	@FindBy(css = "div#div_login_error b")
	private WebElement temporaryIssueMessage;
	
	public S1_LoginPage(WebDriver driver) {
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
	public WebElement profileName() {
		return profileName;
	}
	public boolean profileNameIsDisplayed() {
		boolean displayStatus = profileName.isDisplayed();
		return displayStatus;
	}
	public WebElement wrongCredentialsMessage() {
		return wrongCredentialsMessage;
	}
	public boolean wrongCredentialsMessageIsDisplayed() {
		boolean displayStatus = wrongCredentialsMessage.isDisplayed();
		return displayStatus;
	}
	public WebElement temporaryIssueMessage() {
		return temporaryIssueMessage;
	}
	public boolean temporaryIssueMessageIsDisplayed() {
		boolean displayStatus = temporaryIssueMessage.isDisplayed();
		return displayStatus;
		
	}
	
	}
	



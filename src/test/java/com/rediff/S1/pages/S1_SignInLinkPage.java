package com.rediff.S1.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class S1_SignInLinkPage {
	public WebDriver driver;
	
	@FindBy(linkText = "Sign in")
	private WebElement signInButton;
	
	public S1_SignInLinkPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement SignInButton() {
		return signInButton;
	}
	public boolean SignInButtonIsDisplayed() {
		boolean displayStatus = signInButton.isDisplayed();
		return displayStatus;
	}

}

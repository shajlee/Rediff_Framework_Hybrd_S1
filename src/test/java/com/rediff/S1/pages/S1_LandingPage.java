package com.rediff.S1.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class S1_LandingPage {
	public WebDriver driver;
	
	@FindBy(linkText = "Sign in")
	private WebElement SignInButton;
	
	@FindBy(css = "span.hmsprite.logo")
	private WebElement RediffLogo;
	
	public S1_LandingPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	public boolean SignInButtonIsDisplayed() {
		boolean displayStatus = SignInButton.isDisplayed();
		return displayStatus;
	}
	public boolean RediffLogoIsDisplayed() {
		boolean displayStatus = RediffLogo.isDisplayed();
		return displayStatus;
	}
	public WebElement SignInButton() {
		return SignInButton;
	}
	public WebElement RediffLogo() {
		return RediffLogo;
	}
		
	
		
		
	
	
	

}


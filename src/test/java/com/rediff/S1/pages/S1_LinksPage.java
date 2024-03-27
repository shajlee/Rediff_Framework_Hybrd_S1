package com.rediff.S1.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class S1_LinksPage {
	public WebDriver driver;
	
	@FindBy(css = "a.mailicon")
	private WebElement rediffMailLink;
	
	@FindBy(css = "div.logtext")
	private WebElement rediffMailLogo;
	
	@FindBy(css = "a.moneyicon.relative")
	private WebElement rediffMoneyLink;
	
	@FindBy(css = "span.block.msprite.moneywizlogo.negative.curhand")
	private WebElement rediffMoneyLogo;
	
	@FindBy(css = "a.bmailicon.relative")
	private WebElement rediffBusinessMailLink;
	
	@FindBy(css = "a.logo img")
	private WebElement rediffBusinessMailLogo;
	
	@FindBy(css = "a.vdicon")
	private WebElement rediffVideosLink;
	
	@FindBy(css = "div.logo-wrapper a+span+a")
	private WebElement rediffVieosLogo;
	
	@FindBy(css = "a.shopicon.relative")
	private WebElement rediffShoppingLink;
	
	@FindBy(css = "div.DesktopHeader__logoHolder")
	private WebElement rediffShoppingLogo;
	
	public S1_LinksPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void clickOnRediffMail() {
		rediffMailLink.click();
	}
	public WebElement rediffMailLogo() {
		return rediffMailLogo;
	}
	public void clickOnRediffMoney() {
		rediffMoneyLink.click();
	}
	public WebElement rediffMoneyLogo() {
		return rediffMoneyLogo;
	}
	public void clickOnRediffBusinessMail() {
		rediffBusinessMailLink.click();
	}
	public WebElement rediffBusinessMailLogo() {
		return rediffBusinessMailLogo;
	}
	public void clickOnRediffVideosLink() {
		rediffVideosLink.click();
	}
	public WebElement rediffVideosLogo() {
		return rediffVieosLogo;
	}
	public void clickOnRediffShoppingLink() {
		rediffShoppingLink.click();
	}
	public WebElement rediffShoppingLogo() {
		return rediffShoppingLogo;
		
		
		
		
		
	}
	
	
	
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	



















































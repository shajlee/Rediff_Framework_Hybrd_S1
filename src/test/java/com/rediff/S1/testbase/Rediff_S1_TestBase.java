package com.rediff.S1.testbase;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.asserts.SoftAssert;

import com.rediff.S1.utilities.S1_Utilities;

public class Rediff_S1_TestBase {
	
	public static WebDriver driver;
	public static ChromeOptions optionsC;
	public static FirefoxOptions optionsF;
	public static EdgeOptions optionsE;
	public static SoftAssert softAssert = new SoftAssert();
	public Properties configProp;
	public FileInputStream ip;
	
	public Rediff_S1_TestBase() throws Exception {
		configProp = new Properties();
		ip = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\com\\rediff\\S1\\config\\rediff_S1_configurations.properties");
		configProp.load(ip);
	}
	
	public WebDriver launchBrowserAndStartApplication(String browserName) {
		if(browserName.equalsIgnoreCase(configProp.getProperty("browserName1"))) {
			optionsC = new ChromeOptions();
			optionsC.addArguments("--incognito");
			optionsC.setPageLoadStrategy(PageLoadStrategy.EAGER);
			driver = new ChromeDriver(optionsC);
		} else if(browserName.equalsIgnoreCase(configProp.getProperty("browserName2"))){
			optionsF = new FirefoxOptions();
			optionsF.addArguments("--incognito");
			optionsF.setPageLoadStrategy(PageLoadStrategy.EAGER);
			driver = new FirefoxDriver(optionsF);
		} else if(browserName.equalsIgnoreCase(configProp.getProperty("browserName3"))) {
			optionsE = new EdgeOptions();
			optionsE.addArguments("--incognito");
			optionsE.setPageLoadStrategy(PageLoadStrategy.EAGER);
			driver = new EdgeDriver(optionsE);
		}
		
		driver.manage().window().maximize();
		driver.get(configProp.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(S1_Utilities.IMPLICIT_WAIT_TIME));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(S1_Utilities.PAGELOAD_TIME));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(S1_Utilities.SCRIPT_TIME_OUT));
		driver.manage().deleteAllCookies();
		return driver;
		
			
		}
		}
		
		
		
		
	



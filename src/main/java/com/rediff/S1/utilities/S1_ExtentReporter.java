package com.rediff.S1.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class S1_ExtentReporter {
	
	public static ExtentReports generateExtentReport() throws Exception {
		ExtentReports extentReport = new ExtentReports();
		
		File extentReportFile = new File(System.getProperty("user.dir") + "\\test-output\\ExtentReports\\extentReport.html");
		
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportFile);
		
		sparkReporter.config().setTheme(Theme.STANDARD);
		sparkReporter.config().setReportName("Rediff Hybrid_Practice Framewrok Results");
		sparkReporter.config().setDocumentTitle("Rediff Hybrid Automation Practice Test");
		sparkReporter.config().setTimeStampFormat("mm/dd/yyy hh:mm:ss");
		
		extentReport.attachReporter(sparkReporter); 
		
		Properties configProp = new Properties();
		FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\com\\rediff\\S1\\config\\rediff_S1_configurations.properties");
		configProp.load(ip);
		
		extentReport.setSystemInfo("Application URL", configProp.getProperty("url"));
		extentReport.setSystemInfo("Project Browser", configProp.getProperty("browserName1"));
		extentReport.setSystemInfo("Valid Email", configProp.getProperty("validUsername"));
		extentReport.setSystemInfo("Valid Password", configProp.getProperty("validPassword"));
		extentReport.setSystemInfo("Operating System",System.getProperty("os.name"));
		extentReport.setSystemInfo("Operating System Version", System.getProperty("os.version"));
		extentReport.setSystemInfo("Java Version", System.getProperty("java.runtime.version"));
		extentReport.setSystemInfo("QA Tester Name", System.getProperty("user.name"));
		extentReport.setSystemInfo("QA Tester Country", System.getProperty("user.country"));
		extentReport.setSystemInfo("QA Tester Language", System.getProperty("user.language"));
		
		return extentReport;
	}

}

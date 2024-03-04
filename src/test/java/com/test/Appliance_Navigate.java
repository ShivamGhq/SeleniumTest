package com.test;

import java.io.FileReader;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


import Pages.Appliance_Navigate_Page;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;




public class Appliance_Navigate {
	public static String browser;
	static WebDriver Driver;
	public static WebElement element ;
	static ExtentHtmlReporter htmlReporter;
	static ExtentReports extent;
	static Logger Log = LogManager.getLogger(Appliance_Navigate.class);
	

	@BeforeSuite

	public  void setUp(){
		htmlReporter = new ExtentHtmlReporter("extent.html");

		// create ExtentReports and attach reporter(s)
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

	}


	@BeforeTest


	public static void setBrowser() throws Exception {



		String projectPath = System.getProperty("user.dir");

		FileReader reader=new FileReader(projectPath+"\\src\\test\\java\\com\\test\\config\\config.properties"); 

		Properties p=new Properties();  
		p.load(reader);


		Assert.assertEquals(p.getProperty("URL"), "https://www.flipkart.com/");


		System.out.println(p.getProperty("URL"));  



		browser = (p.getProperty("browser"));

	}
	@Test



	public static void setBrowserconfig() throws Exception {





		if(browser.contains("Chrome")){
			String projectPath = System.getProperty("user.dir");

			System.setProperty("WebDriver.chrome.driver",projectPath+ "\\SeleniumTest1\\driver\\chromedriver.exe");

			ChromeOptions options = new ChromeOptions();
//			options.addArguments("--headless=true");
			options.addArguments("--headless");
			//options.setHeadless(true);
			Driver = new ChromeDriver(options);


			//Driver = new ChromeDriver();
			Driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			runTest();

		}


		String projectPath = System.getProperty("user.dir");
		if(browser.contains("Edge")) {	

			System.setProperty("WebDriver.edge.driver", projectPath+ "\\SeleniumTest1\\driver\\msedgedriver.exe");

			//Driver = new EdgeDriver();
			
			EdgeOptions options=new EdgeOptions();
			options.addArguments("--headless");
			Driver=new EdgeDriver(options);
			runTest();
		}


		if(browser.contains("Firefox")) {	
			String projectPath1 = System.getProperty("user.dir");


			System.setProperty("WebDriver.gecko.driver", projectPath1+"\\SeleniumTest1\\driver\\geckodriver.exe");
			//Driver = new FirefoxDriver();
			FirefoxOptions options = new FirefoxOptions ();
			options.addArguments("--headless");

		      Driver = new FirefoxDriver(options);
			runTest();
		}

	}


	public static void runTest() throws Exception {
		Appliance_Navigate_Page login;
		

		// creates a toggle for the given test, adds all log events under it    
		ExtentTest test = extent.createTest("Flipkart Search Test", "Sample description");

		// CASE:1-->>Launch Browser
		Log.info("Launching the Flipkart Browser ");

		Driver.get("https://www.flipkart.com/");

		//Maximize Browser
		Driver.manage().window().maximize();
		System.out.println("Title is: " +Driver.getTitle());



		// log(Status, details)
		test.log(Status.INFO, "Launching the Flipkart Website");



		// log with snapshot
		test.pass("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());

		// test with snapshot
		test.addScreenCaptureFromPath("screenshot.png");


		login = new Appliance_Navigate_Page(Driver);

		// info(details)
		test.info("Click on the Appliance Tab ");
		Log.info("Clicking on the Appliance tab ");
		login.clickAppliance();
		
//		login.CartDisplayed();











	}








	@AfterTest
	public void close() {

		//Driver.close();

	}
	@AfterSuite
	public void teardown() {
		extent.flush();
		Log.info("extent report created successfully");
	}

}


package com.test;

import java.io.FileReader;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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

import com.test.*;
import Pages.CheckRegistered_With_Blank_MobileNumber_Page;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



public class CheckRegistered_With_Empty_MobileNumber {
	public static String browser;
	static WebDriver Driver;
	public static WebElement element ;
	static ExtentHtmlReporter htmlReporter;
	static ExtentReports extent;
	static Logger Log = LogManager.getLogger(CheckRegistered_With_Empty_MobileNumber.class);

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

			options.addArguments("--headless");
			
			//Driver = new ChromeDriver(options);

			Driver = new ChromeDriver();
			Driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			runTest();

		}


		String projectPath = System.getProperty("user.dir");
		if(browser.contains("Edge")) {	

			System.setProperty("WebDriver.edge.driver", projectPath+ "\\SeleniumTest1\\driver\\msedgedriver.exe");

			Driver = new EdgeDriver();
			
			EdgeOptions options=new EdgeOptions();
			options.addArguments("--headless");
			//Driver=new EdgeDriver(options);
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
		CheckRegistered_With_Blank_MobileNumber_Page login;


		// creates a toggle for the given test, adds all log events under it    
		ExtentTest test = extent.createTest("Flipkart Search Test", "Sample description");

		
		// log(Status, details)
		test.log(Status.INFO, "Launching the Flipkart Website");
		Log.info("Launching the Flipkart Browser");
		Driver.get("https://www.flipkart.com/");
		
		//Maximize Browser
		Driver.manage().window().maximize();
		System.out.println("Title is: " +Driver.getTitle());



		

		

		// log with snapshot
		test.pass("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());

		// test with snapshot
		test.addScreenCaptureFromPath("screenshot.png");


		login = new CheckRegistered_With_Blank_MobileNumber_Page(Driver);
		// info(details)
		test.info("Click on the Login Tab ");
		Log.info("Click on login tab");
		
		login.clicklogin();
		
		Driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		
		// info(details)
		test.info("Click on the Account Tab ");
		Log.info("Click on Account Tab");
		login.clickAcount();
		Driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		
		// info(details)
		test.info("Enter the Mobile Number ");
		Log.info("Leave the field enter mobile Number ");
		login.enterMobileNumber();
		Driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		
		// info(details)
		test.info("Click on the Continue Button ");
		Log.info("Click on continue Button");
		
		login.clickContunue();
		//login.txt_ISDisplayed();
		
		


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


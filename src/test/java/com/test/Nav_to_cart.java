package com.test;

import java.io.FileReader;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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

import Pages.Navigate_to_cart_page;




public class Nav_to_cart {
	public static String browser;
	static WebDriver Driver;
	public static WebElement element ;
	static ExtentHtmlReporter htmlReporter;
	static ExtentReports extent;
	static Logger Log = LogManager.getLogger(Nav_to_cart.class);

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

			//Driver = new EdgeDriver();
			
			EdgeOptions options=new EdgeOptions();
			options.addArguments("--headless");
			Driver=new EdgeDriver(options);
			runTest();
		}


		if(browser.contains("Firefox")) {	
			String projectPath1 = System.getProperty("user.dir");


			System.setProperty("WebDriver.gecko.driver", projectPath1+"\\SeleniumTest1\\driver\\geckodriver.exe");



			Driver = new FirefoxDriver();
			
			
			FirefoxOptions options = new FirefoxOptions ();
			options.addArguments("--headless");
            // Driver = new FirefoxDriver(options);
			runTest();
		}

	}


	public static void runTest() throws Exception {
		Navigate_to_cart_page login;
		//		WebDriver driver=null;

		// creates a toggle for the given test, adds all log events under it    
		ExtentTest test = extent.createTest("Flipkart Search Test", "Sample description");

        Log.info("Opening Flipkart website");
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


		login = new Navigate_to_cart_page(Driver);
		// info(details)
		test.info("Checking the cart is Empty ?");

		// info(details)	

		test.info("click on the cart Menu to check the cart ");
		Log.info("Hit on Cart Button to Check the cart");

		login.HitCartButton();
	}




	@AfterTest
	public void close() {

		Driver.quit();

	}
	@AfterSuite
	public void teardown() {
		Log.info("extent report created successfully");
		extent.flush();
	}

}


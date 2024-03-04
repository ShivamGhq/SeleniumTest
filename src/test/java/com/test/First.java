package com.test;

import java.io.FileNotFoundException;
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
import com.sun.tools.sjavac.Log;
import com.test.*;

import Pages.SearchProduct;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



public class First {
	public static String browser;
	 public static WebDriver driver;
	public static WebElement element ;
	static ExtentHtmlReporter htmlReporter;
	static ExtentReports extent;
	static Logger Log = LogManager.getLogger(First.class);

	
@BeforeTest(groups = {"smoke"})
	public  void setUp() throws Exception{
		htmlReporter = new ExtentHtmlReporter("extent.html");

		// create ExtentReports and attach reporter(s)
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		
		
		String projectPath = System.getProperty("user.dir");

		FileReader reader=new FileReader(projectPath+"\\src\\test\\java\\com\\test\\config\\config.properties"); 

		Properties p=new Properties();  
		p.load(reader);



		
		Assert.assertEquals(p.getProperty("URL"), "https://www.flipkart.com/"); 


		System.out.println(p.getProperty("URL"));  

		

		browser = (p.getProperty("browser"));
		
		if(browser.contains("Chrome")){
		 projectPath = System.getProperty("user.dir");
//
			System.setProperty("WebDriver.chrome.driver",projectPath+ "\\SeleniumTest1\\driver\\chromedriver.exe");
//
			ChromeOptions options = new ChromeOptions();

			options.addArguments("--headless");
			//options.setHeadless(true);
			driver = new ChromeDriver(options);
			
			
			
			


			//driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		

		}


		 projectPath = System.getProperty("user.dir");
		if(browser.contains("Edge")) {	

			System.setProperty("WebDriver.edge.driver", projectPath+ "\\SeleniumTest1\\driver\\msedgedriver.exe");
			
//			EdgeOptions options = new EdgeOptions();
////			(() options).addArguments("--headless=true");
//			options.addArguments("--headless=new");
////			((ChromeOptions) options).setHeadless(true);
		 driver = new EdgeDriver();
			
			EdgeOptions options=new EdgeOptions();
			options.addArguments("--headless");
			driver=new EdgeDriver(options);

		}


		if(browser.contains("Firefox")) {	
			String projectPath1 = System.getProperty("user.dir");
			

			System.setProperty("WebDriver.gecko.driver", projectPath1+"\\SeleniumTest1\\driver\\geckodriver.exe");

			FirefoxOptions options = new FirefoxOptions ();
			options.addArguments("--headless");

		      driver = new FirefoxDriver(options);


			//driver = new FirefoxDriver();
		}


}







	@Test(groups = {"smoke"},priority = 1,enabled = true)
	public static void runTest() throws Exception {
		SearchProduct login;

		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		Log.info("Opening Flipkart");
		driver.get("https://www.flipkart.com/");
		


		//creates a toggle for the given test, adds all log events under it    
		ExtentTest test = extent.createTest("Flipkart Search Test", "Sample description");

		// log(Status, details)
				
		test.log(Status.INFO, "Launching the Flipkart Website");

		//driver.get("https://www.flipkart.com/");
		
		//Maximize Browser
		driver.manage().window().maximize();
		System.out.println("Title is: " +driver.getTitle());



		

		

		// log with snapshot
		test.pass("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());

		// test with snapshot
		test.addScreenCaptureFromPath("screenshot.png");


		login = new SearchProduct(driver);
		
				
		test.info("Enter the Search Product Name");
		Log.info("Enter the product name ");
		
		login.enterProduct();

		test.pass("Entering Product Name in the search box");

		// info(details)
		test.pass("Click on search Button");	
		Log.info("Click on Search Button");
		login.HitSearchButton();
		test.pass("Search Result is Visible");
		
//		login.showProduct();
		
		
		
		

	}
	@Test(groups = {"sanity"},priority = 2,enabled = true)
	public static void runTest1() throws Exception {
		
		
		System.out.println("NewTest");
		SearchProduct login;
		login = new SearchProduct(driver);
       
	


		// creates a toggle for the given test, adds all log events under it    
		ExtentTest test = extent.createTest("Flipkart Search Test", "Sample description");

		// log(Status, details)
				
         test.log(Status.INFO, "Launching the Flipkart Website");

 		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//driver.get("https://www.flipkart.com/");
 		
 		test.pass("Opening Login page ");
 		Log.info("Opening Login Page");
		login.AnotherSearch();
		
		
		
	}
	
	
	








	@AfterTest
	public void close() {

		driver.quit();
		
		

	}
	@AfterSuite
	public void teardown() {
		extent.flush();
Log.info("extent report created successfully");
	}

}


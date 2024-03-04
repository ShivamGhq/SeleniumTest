package com.test;

import java.io.FileNotFoundException;
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

import Pages.Mobile_Navigate_Page;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;




public class Mobile_Navigate {
	public static String browser;
	static WebDriver Driver;
	public static WebElement element ;
	static ExtentHtmlReporter htmlReporter;
	static ExtentReports extent;
	static Logger Log = LogManager.getLogger(Mobile_Navigate.class);

	@BeforeTest(groups = {"smoke","sanity"})

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

			System.setProperty("WebDriver.chrome.driver",projectPath+ "\\SeleniumTest1\\driver\\chromedriver.exe");

			ChromeOptions options = new ChromeOptions();

			options.addArguments("--headless");
			
			//Driver = new ChromeDriver(options);


			Driver = new ChromeDriver();
			Driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			

		}


		 projectPath = System.getProperty("user.dir");
		if(browser.contains("Edge")) {	

			System.setProperty("WebDriver.edge.driver", projectPath+ "\\SeleniumTest1\\driver\\msedgedriver.exe");

			//Driver = new EdgeDriver();
			
			EdgeOptions options=new EdgeOptions();
			options.addArguments("--headless");
			Driver=new EdgeDriver(options);
		
		}


		if(browser.contains("Firefox")) {	
			String projectPath1 = System.getProperty("user.dir");


			System.setProperty("WebDriver.gecko.driver", projectPath1+"\\SeleniumTest1\\driver\\geckodriver.exe");



			Driver = new FirefoxDriver();
			
			FirefoxOptions options = new FirefoxOptions ();
			options.addArguments("--headless");
            // Driver = new FirefoxDriver(options);
			
		}

	}



@Test(groups = {"smoke"},priority = 1,enabled = true)
	public static void runTest() throws Exception {
		Mobile_Navigate_Page login;
	  
		ExtentTest test = extent.createTest("Flipkart Search Test", "Sample description");

        Log.info("Flipkart is opening");
		Driver.get("https://www.flipkart.com/");

		//Maximize Browser
		Driver.manage().window().maximize();
		System.out.println("Title is: " +Driver.getTitle());



		// log(Status, details)
		test.log(Status.INFO, "Launching the Flipkart Website");

		// info(details)
		test.info("Enter the Search Product Name");

		// log with snapshot
		test.pass("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());

		// test with snapshot
		test.addScreenCaptureFromPath("screenshot.png");


		login = new Mobile_Navigate_Page(Driver);

		// info(details)
		test.info("Click on the Mobile Tab ");
		
		Log.info("Click on the Mobile Tab ");
		// info(details)
		test.info("It Display the Latest Mobile Available ");
		login.clickMoblie();
		
		login.ChecktxtDisplayed();

	}


@Test(groups = {"sanity"},priority = 2,enabled = true)
public static void runTest2() throws Exception {
	

	Log.info("Again Loading Flipkart to check Groups Method");
	Driver.get(" https://www.flipkart.com/");
	
	
	
}




	@AfterTest
	public void close() {

		//Driver.close();
		Driver.quit();

	}
	@AfterSuite
	public void teardown() {
		extent.flush();
		Log.info("extent report created successfully");
	}
	

}


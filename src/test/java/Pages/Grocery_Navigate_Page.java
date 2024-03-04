package Pages;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Keys;


public class Grocery_Navigate_Page {

	protected WebDriver driver;



//	private By txt_username = By.id("ap_email");
//
//	private By btn_continue = By.className("a-button-input");
//
//	private By txt_password = By.id("ap_password");
//
//
	private By btn_Grocery = By.xpath("//*[@id=\"container\"]/div/div[1]/div/div/div/div/div[1]/div/div/div/div[2]/div[1]/div/div[1]/div/div/div/div/div[1]/a[1]/div/div/span/span");
	
	private By txt_pincode = By.xpath("//*[@id=\"container\"]/div/div[1]/div[1]/div[2]/div[3]/div[2]/div/div[2]/div[2]/div/div/div[1]/form/div/button/svg/g");

	
	private By btn_CartDisplayed = By.xpath("//*[@id=\\\"container\\\"]/div/div[1]/div/div/div/div/div[1]/div/div[1]/div/div[1]/div[1]/header/div[2]/div[3]/div/a[1];");
	
	
	public Grocery_Navigate_Page(WebDriver driver) {
		this.driver= driver;
	}


	public void clickGrocery() {
		driver.findElement(btn_Grocery).click();
	}
	
	public void enterpincode() throws Exception {
		String projectPath = System.getProperty("user.dir");

		FileReader reader=new FileReader(projectPath+"\\src\\test\\java\\com\\test\\config\\config.properties"); 

		Properties p=new Properties();  
		p.load(reader);
		driver.findElement(txt_pincode).click();

	
	}
	
	public void CheckCartIsDisplayed() {
		
		driver.findElement(btn_CartDisplayed).isDisplayed();
	}
	
	

	
	public void loginValidUser() {
////		driver.findElement(txt_username).sendKeys(username);
		driver.findElement(btn_Grocery).click();

		driver.findElement(btn_CartDisplayed).isDisplayed();

	}}
//	
//}

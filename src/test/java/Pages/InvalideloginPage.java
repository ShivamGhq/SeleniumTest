package Pages;


import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Keys;


public class InvalideloginPage {

	protected WebDriver driver;



//	private By txt_username = By.id("ap_email");
//
//	private By btn_continue = By.className("a-button-input");
//
//	private By txt_password = By.id("ap_password");
//
//
	private By btn_login = By.xpath("//*[@id=\"container\"]/div/div[1]/div/div/div/div/div[1]/div/div[1]/div/div[1]/div[1]/header/div[2]/div[2]/div/div/div/div/a/span");
	
	private By txt_mobilenumber = By.xpath("//*[@id=\"container\"]/div/div[3]/div/div[2]/div/form/div[1]/input");
	
	private By btn_enter_otp = By.xpath("//*[@id=\"container\"]/div/div[3]/div/div[2]/div/form/div[3]/button");
	
	private By txt_display = By.xpath("//*[@id=\"container\"]/div/div[3]/div/div[1]/span/span");
	
//	private By txt_product = By.name("field-keywords");
	
//	private By btn_SearchButton = By.id("nav-search-submit-button");
	
//	private By btn_logoutCheck = By.id("nav-link-accountList");
	
	
	public InvalideloginPage(WebDriver driver) {
		this.driver= driver;
	}


//	public void enterUsername(String username) {
//
//		driver.findElement(txt_username).sendKeys(username);
//
//	}
//
//
//	public void clickcontinue() {
//		driver.findElement(btn_continue).click();
//	}
//
//
//	public void enterPassword(String password) {
//
//		driver.findElement(txt_password).sendKeys(password);
//	}
	public void clicklogin() {
		driver.findElement(btn_login).click();
	}
//	
//	public void ChecklogoutIsDisplayed() {
//		
//		driver.findElement(btn_logout).isDisplayed();
//	}
	
	
	public void enterNumber() throws Exception {
		String projectPath = System.getProperty("user.dir");
		FileReader reader=new FileReader(projectPath+"\\src\\test\\java\\com\\test\\config\\config.properties"); 

		Properties p=new Properties();  
		p.load(reader);
		
		driver.findElement(txt_mobilenumber).sendKeys(p.getProperty("invalidenumber"));
	}
	
	
	public void enterotp() {
		driver.findElement(btn_enter_otp).click();
	}
      public void IsDisplayed() {
		
		driver.findElement(txt_display).isDisplayed();
	}	

	

	
	public void loginValidUser() {

		driver.findElement(txt_display).isDisplayed();
	
	}
	
}

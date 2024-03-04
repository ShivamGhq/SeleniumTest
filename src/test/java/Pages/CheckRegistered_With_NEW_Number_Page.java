package Pages;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Keys;


public class CheckRegistered_With_NEW_Number_Page {

	protected WebDriver driver;



//	private By txt_username = By.id("ap_email");
//
//	private By btn_continue = By.className("a-button-input");
//
//	private By txt_password = By.id("ap_password");
//
//
	private By btn_login = By.xpath("//*[@id=\"container\"]/div/div[1]/div/div/div/div/div[1]/div/div[1]/div/div[1]/div[1]/header/div[2]/div[2]/div/div/div/div/a/span");
	
	private By btn_Account =  By.xpath("//*[@id=\"container\"]/div/div[3]/div/div[2]/div/form/div[4]/a");
	
	private By txt_mobilenumber = By.xpath("//*[@id=\"container\"]/div/div[3]/div/div[2]/div/form/div[1]/input");
	
	private By btn_Continue = By.xpath("//*[@id=\"container\"]/div/div[3]/div/div[2]/div/form/div[3]/button/span");
	
	

	
	private By btn_SignupCheck = By.xpath("//*[@id=\"container\"]/div/div[3]/div/div[2]/div/form/div[4]/button[1]");
	
	
	public CheckRegistered_With_NEW_Number_Page(WebDriver driver) {
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
	public void clickAcount () {
		driver.findElement(btn_Account).click();
	}
	public void enterMobileNumber() throws Exception {
		String projectPath = System.getProperty("user.dir");

		FileReader reader=new FileReader(projectPath+"\\src\\test\\java\\com\\test\\config\\config.properties"); 

		Properties p=new Properties();  
		p.load(reader);
		
		
		
		driver.findElement(txt_mobilenumber).sendKeys(p.getProperty("NewNumber"));
	}
	
	
	public void clickContunue() {
		driver.findElement(btn_Continue).click();
		
	}

	public void CheckSignUpIsDisplayed() {
		
		driver.findElement(btn_SignupCheck).isDisplayed();
	}
	
	
}	
	
//	
//	public void HitSearchButton() {
//		
//		driver.findElement(btn_SearchButton).sendKeys(Keys.RETURN);
//	}
//	
//	
//	public void CheckElement() {
//		driver.findElement(btn_logoutCheck).isDisplayed();
//	}
	
//	public void loginValidUser(String username , String password) {
////		driver.findElement(txt_username).sendKeys(username);
////		driver.findElement(btn_continue).click();
////		
////		driver.findElement(txt_password).sendKeys(password);
//		driver.findElement(btn_login).click();
//		
//		
//		driver.findElement( txt_mobilenumber).sendKeys("8210489053");
		
//		driver.findElement(btn_enter_otp).click();
//		driver.findElement(btn_SearchButton).sendKeys(Keys.RETURN);
////		driver.findElement(btn_logoutCheck).isDisplayed();
////	
//	}
//	
//}

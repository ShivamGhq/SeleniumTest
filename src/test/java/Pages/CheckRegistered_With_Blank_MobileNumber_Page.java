package Pages;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Keys;


public class CheckRegistered_With_Blank_MobileNumber_Page {

	protected WebDriver driver;




	private By btn_login = By.xpath("//*[@id=\"container\"]/div/div[1]/div/div/div/div/div[1]/div/div[1]/div/div[1]/div[1]/header/div[2]/div[2]/div/div/div/div/a/span");
	
	private By btn_Account =  By.xpath("//*[@id=\"container\"]/div/div[3]/div/div[2]/div/form/div[4]/a");
	
	private By txt_mobilenumber = By.xpath("//*[@id=\"container\"]/div/div[3]/div/div[2]/div/form/div[1]/input");
	
	private By btn_Continue = By.xpath("//*[@id=\"container\"]/div/div[3]/div/div[2]/div/form/div[3]/button/span");
	
	

	
	
	public CheckRegistered_With_Blank_MobileNumber_Page(WebDriver driver) {
		this.driver= driver;
	}

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
		
		
		
		driver.findElement(txt_mobilenumber).click();
	}
	
	
	public void clickContunue() {
		driver.findElement(btn_Continue).click();
		
	}
	
//	public void txt_ISDisplayed() {
//		driver.findElement(txt_isDisplayed);
//	}
}


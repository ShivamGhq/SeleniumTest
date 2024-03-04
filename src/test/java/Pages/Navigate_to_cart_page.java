package Pages;


import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Keys;


public class Navigate_to_cart_page {

	protected WebDriver driver;
	
	




	
	

	
	private By btn_NavToCart = By.xpath("//*[@id=\"container\"]/div/div[1]/div/div/div/div/div[1]/div/div[1]/div/div[1]/div[1]/header/div[2]/div[3]/div/a[1]");
	

	
	
	public Navigate_to_cart_page(WebDriver driver) {
		this.driver= driver;
	}



	
	
	public void enterProduct() throws Exception {
		String projectPath = System.getProperty("user.dir");
		FileReader reader=new FileReader(projectPath+"\\src\\test\\java\\com\\test\\config\\config.properties"); 

		Properties p=new Properties();  
		p.load(reader);
		

	}
	
	
	public void HitCartButton() {
	
	driver.findElement(btn_NavToCart).sendKeys(Keys.RETURN);
	
	}
	

	
	
	public void loginValidUser() {
	
	driver.findElement(btn_NavToCart).click();
	
	
		//driver.findElement(btn_logoutCheck).isDisplayed();
	
	}}
	



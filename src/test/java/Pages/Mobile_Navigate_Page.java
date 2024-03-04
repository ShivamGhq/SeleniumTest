package Pages;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Keys;


public class Mobile_Navigate_Page {

	protected WebDriver driver;




	private By btn_Mobile = By.xpath("//*[@id=\"container\"]/div/div[1]/div/div/div/div/div[1]/div/div[1]/div/div[2]/div[1]/div/div[1]/div/div/div/div/div[1]/a[2]/div/div/span/span");
	

	
	private By txt_Displayed = By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/h1");
	private By btn_NavToCart = By.xpath("//*[@id=\"container\"]/div/div[1]/div[1]/div[2]/div[6]/div/div/a/svg/path");
	
	
	
	public Mobile_Navigate_Page(WebDriver driver) {
		this.driver= driver;
	}



	public void clickMoblie() {
		driver.findElement(btn_Mobile).click();
	}
	

	

	public void ChecktxtDisplayed() {
		
		driver.findElement(txt_Displayed).isDisplayed();


}
	}
	


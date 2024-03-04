package Pages;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Keys;


public class Appliance_Navigate_Page {

	protected WebDriver driver;


	private By btn_Appliance = By.xpath("//*[@id=\"container\"]/div/div[1]/div/div/div/div/div[1]/div/div[1]/div/div[2]/div[1]/div/div[1]/div/div/div/div/div[1]/a[3]");
	
   private By btn_cartDisplayed = By.xpath("//*[@id=\\\"container\\\"]/div/div[1]/div/div/div/div/div[1]/div/div[1]/div/div[1]/div[1]/header/div[2]/div[3]/div/a[1]");
	
	public Appliance_Navigate_Page(WebDriver driver) {
		this.driver= driver;
	}


	public void clickAppliance() {
	driver.findElement(btn_Appliance).click();
	
	
	
	}
	public void CartDisplayed() {
		driver.findElement(btn_cartDisplayed);
	}
}
	


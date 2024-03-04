package Pages;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Keys;


public class Travel_Navigate_Page {

	protected WebDriver driver;

	private By btn_Travel = By.xpath("//*[@id=\"container\"]/div/div[1]/div/div/div/div/div[1]/div/div[1]/div/div[2]/div[1]/div/div[1]/div/div/div/div/div[1]/a[4]/div/div/span/span");
	
	private By btn_Check = By.xpath("//*[@id=\"container\"]/div/div[2]/div[1]/div/div[2]/div/div[1]/div/div/label[1]/div[2]/div");
	

	
	
	public Travel_Navigate_Page(WebDriver driver) {
		this.driver= driver;
	}


	public void clickTravel() {
		driver.findElement(btn_Travel).click();
	}
	
	public void CheckElement() {
		driver.findElement(btn_Check).isDisplayed();
	}
}
	


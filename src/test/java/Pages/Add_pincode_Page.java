package Pages;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Keys;


public class Add_pincode_Page {

	protected WebDriver driver;



	private By btn_Grocery = By.xpath("//*[@id=\"container\"]/div/div[1]/div/div/div/div/div[1]/div/div[1]/div/div[2]/div[1]/div/div[1]/div/div/div/div/div[1]/a[1]/div/div/span/span");

	private By txt_pincode = By.xpath("//*[@id=\"container\"]/div/div[1]/div[1]/div[2]/div[3]/div[2]/div/div[2]/div[2]/div/div/div[1]/form/input");

    private By txt_displayed = By.xpath("//*[@id=\"container\"]/div/div[1]/div[1]/div[2]/div[3]/div[2]/div/div[2]/div[2]/div/div/div[1]/div[1]");

	public Add_pincode_Page(WebDriver driver) {
		this.driver= driver;
	}


	public void Grocery() {
		driver.findElement(btn_Grocery).click();
	}
	
	
	public void txt_Displayed() {
		driver.findElement(txt_displayed).isDisplayed();
	}

	public void enterpincode() throws Exception {
		String projectPath = System.getProperty("user.dir");

		FileReader reader=new FileReader(projectPath+"\\src\\test\\java\\com\\test\\config\\config.properties"); 

		Properties p=new Properties();  
		p.load(reader);
		driver.findElement(txt_pincode).sendKeys(p.getProperty("pincode"));

	}

	public void loginValidUser() throws Exception {

		String projectPath = System.getProperty("user.dir");

		FileReader reader=new FileReader(projectPath+"\\src\\test\\java\\com\\test\\config\\config.properties"); 

		Properties p=new Properties();  
		p.load(reader);


		driver.findElement(btn_Grocery).click();
		driver.findElement(txt_pincode).sendKeys(p.getProperty("pincode"));

	}}


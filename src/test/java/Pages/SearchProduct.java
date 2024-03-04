package Pages;


import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Keys;


public class SearchProduct {

	protected WebDriver driver;
	
	



//	private By txt_username = By.id("ap_email");
//
//	private By btn_continue = By.className("a-button-input");
//
//	private By txt_password = By.id("ap_password");
//
//
//	private By btn_login = By.id("signInSubmit");
//	
//	private By btn_logout = By.id("nav-hamburger-menu");
	
	
	private By txt_product = By.xpath("//*[@id=\"container\"]/div/div[1]/div/div/div/div/div[1]/div/div[1]/div/div[1]/div[1]/header/div[1]/div[2]/form/div/div/input");
	
	private By btn_SearchButton = By.xpath("//*[@id=\"container\"]/div/div[1]/div/div/div/div/div[1]/div/div[1]/div/div[1]/div[1]/header/div[1]/div[2]/form/div/button");
	
	private By show_product = By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[2]/div/div/div/a/div[2]/div[1]/div[1]");
	
    private By txt_search = By.xpath("//*[@id=\"container\"]/div/div[1]/div[1]/div[2]/div[3]/div/div/div/a");
	
	public SearchProduct(WebDriver driver) {
		this.driver= driver;
	}


	
	
	public void enterProduct() throws Exception {
		String projectPath = System.getProperty("user.dir");
		FileReader reader=new FileReader(projectPath+"\\src\\test\\java\\com\\test\\config\\config.properties"); 

		Properties p=new Properties();  
		p.load(reader);
		
		driver.findElement(txt_product ).sendKeys((p.getProperty("product")));
	}
	
	
	public void HitSearchButton() {
	
	driver.findElement(btn_SearchButton).sendKeys(Keys.RETURN);
	}
	
	public void showProduct() {
		driver.findElement(show_product).click();
	}
	
	public void AnotherSearch() {
		
		driver.findElement(txt_search).click();
	}
//	
//	
//	public void CheckElement() {
//		driver.findElement(btn_logoutCheck).isDisplayed();
//	}
	
	public void loginValidUser() {

		
		driver.findElement(txt_product).sendKeys("mobile");
		driver.findElement(btn_SearchButton).sendKeys(Keys.RETURN);
		driver.findElement(txt_search).click();
//		driver.findElement(btn_logoutCheck).isDisplayed();
	
	}
	
}

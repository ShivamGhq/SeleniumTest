package Pages;


import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Keys;


public class Navigate_to_Seller_Page {

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
	
	
//	private By txt_product = By.xpath("//*[@id=\"container\"]/div/div[1]/div/div/div/div/div[1]/div/div[1]/div/div[1]/div[1]/header/div[1]/div[2]/form/div/div/input");
	
	private By btn_NavToSeller = By.xpath("//*[@id=\"container\"]/div/div[1]/div/div/div/div/div[1]/div/div[1]/div/div[1]/div[1]/header/div[2]/div[4]/div/a[1]");
	
	private By txt_Check = By.xpath("//*[@id=\"app\"]/div/div[3]/div/div/div[2]/h1/span");
	
//	private By show_product = By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[2]/div/div/div/a/div[2]/div[1]/div[1]");
	
//	private By add_to_cart = By.linkText("Add to cart");
//	
//	private By btn_logoutCheck = By.id("nav-link-accountList");
	
	
	public Navigate_to_Seller_Page(WebDriver driver) {
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
//	public void clicklogin() {
//		driver.findElement(btn_login).click();
//	}
//	
//	public void ChecklogoutIsDisplayed() {
//		
//		driver.findElement(btn_logout).isDisplayed();
//	}
	
	
	public void enterProduct() throws Exception {
		String projectPath = System.getProperty("user.dir");
		FileReader reader=new FileReader(projectPath+"\\src\\test\\java\\com\\test\\config\\config.properties"); 

		Properties p=new Properties();  
		p.load(reader);
		
//		driver.findElement(txt_product ).sendKeys((p.getProperty("product")));
	}
	
	
	public void HitSellerButton() {
	
	driver.findElement(btn_NavToSeller).sendKeys(Keys.RETURN);
	
	}
	
	public void CheckText() {
		driver.findElement(txt_Check).isDisplayed();
	}
	
//	public void showProduct() {
//		driver.findElement(show_product).click();
//	}
//	
//	public void addtocart() {
//		driver.findElement(add_to_cart).sendKeys(Keys.RETURN);
//	}
//	
//	
//	public void CheckElement() {
//		driver.findElement(btn_logoutCheck).isDisplayed();
//	}
	
	public void loginValidUser() {
////		driver.findElement(txt_username).sendKeys(username);
////		driver.findElement(btn_continue).click();
////		
////		driver.findElement(txt_password).sendKeys(password);
	driver.findElement(btn_NavToSeller).click();
	
//		
//		
//		driver.findElement(txt_product).sendKeys("iphone");
//		driver.findElement(btn_SearchButton).sendKeys(Keys.RETURN);
//		driver.findElement(add_to_cart).sendKeys(Keys.RETURN);
//		driver.findElement(btn_logoutCheck).isDisplayed();
	
	}}
	



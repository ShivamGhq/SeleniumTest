package Pages;


import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Keys;


public class CreateAccountPage {

	protected WebDriver driver;




	private By btn_login = By.xpath("//*[@id=\"container\"]/div/div[1]/div/div/div/div/div[1]/div/div[1]/div/div[1]/div[1]/header/div[2]/div[2]/div/div/div/div/a/span");
	
	private By btn_Account =  By.xpath("//*[@id=\"container\"]/div/div[3]/div/div[2]/div/form/div[4]/a");
	
    private By btn_Continue = By.xpath("//*[@id=\"container\"]/div/div[3]/div/div[2]/div/form/div[3]/button");
	
	
	public CreateAccountPage(WebDriver driver) {
		this.driver= driver;
	}


	public void clicklogin() {
		driver.findElement(btn_login).click();
	}
	public void clickAcount () {
		driver.findElement(btn_Account).click();
	}
   public void CheckContinueIsDisplayed() {
		
		driver.findElement(btn_Continue).isDisplayed();
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

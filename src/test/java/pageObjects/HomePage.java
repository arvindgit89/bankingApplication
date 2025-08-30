package pageObjects;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public void clickregisterLink() {
		WebElement registerClick = driver.findElement(By.xpath("//a[normalize-space()='Register']"));
		registerClick.click();
	}
	
	

}

package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class TransferFundsPage extends BasePage{

	public TransferFundsPage(WebDriver driver)
	{
		super(driver);
	}
	
	public void transferFunds()
	{
		driver.findElement(By.xpath("//a[normalize-space()='Transfer Funds']")).click();
		WebElement amount = driver.findElement(By.id("amount"));
		amount.sendKeys("200");
		
		//from account
		WebElement dropdown = driver.findElement(By.id("fromAccountId"));
		Select fromAccount = new Select(dropdown);
		fromAccount.selectByIndex(2);
		
		//To account
		WebElement dropdown1 =driver.findElement(By.id("toAccountId"));
		Select toAccount = new Select(dropdown1);
		toAccount.selectByIndex(1);
		driver.findElement(By.xpath("//input[@value='Transfer']")).click();
		
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement messageElement = wait.until(
		    ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='showResult']//p[1]"))
		);

		String transferMessage = messageElement.getText().trim();
		System.out.println("Transfer successfully12: " + transferMessage);

	}

}

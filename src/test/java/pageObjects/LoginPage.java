package pageObjects;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.fasterxml.jackson.databind.ObjectMapper;

import utilities.LoginData;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public void customerLogin() throws Exception {
		// Load JSON file and map to Java object
		ObjectMapper mapper = new ObjectMapper();
		LoginData data = mapper.readValue(new File("src/test/resources/loginData.json"), LoginData.class);

		// Use data from JSON
		WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
		username.sendKeys(data.getUsername());

		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		password.sendKeys(data.getPassword());

		WebElement submit = driver.findElement(By.xpath("//input[@value='Log In']"));
		submit.click();
	}

	public void isAccountOverviewExist() {

		WebElement accountOverview = driver.findElement(By.xpath("//h1[normalize-space()='Accounts Overview']"));
		String actualText = accountOverview.getText();
		System.out.println(actualText);
		String expectedText = "Accounts Overview";
		assertEquals(actualText, expectedText, "Text does not match the expected value");

	}

}

package pageObjects;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.fasterxml.jackson.databind.ObjectMapper;

import utilities.RegistrationData;

public class AccountRegistrationPage extends BasePage {

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);

	}

	public void registration() throws Exception {
		// Load JSON data
		ObjectMapper mapper = new ObjectMapper();
		RegistrationData data = mapper.readValue(new File("src/test/resources/registrationData.json"),RegistrationData.class);

		// Fill form using JSON data
		driver.findElement(By.id("customer.firstName")).sendKeys(data.getFirstName());
		driver.findElement(By.id("customer.lastName")).sendKeys(data.getLastName());
		driver.findElement(By.xpath("//input[@id='customer.address.street']")).sendKeys(data.getAddress());
		driver.findElement(By.id("customer.address.city")).sendKeys(data.getCity());
		driver.findElement(By.id("customer.address.state")).sendKeys(data.getState());
		driver.findElement(By.id("customer.address.zipCode")).sendKeys(data.getZipCode());
		driver.findElement(By.id("customer.phoneNumber")).sendKeys(data.getPhone());
		driver.findElement(By.id("customer.ssn")).sendKeys(data.getSsn());

		// To make USERNAME unique
		String uniqueUsername = data.getUsername() + new Random().nextInt(1000);
		driver.findElement(By.id("customer.username")).sendKeys(uniqueUsername);

		driver.findElement(By.id("customer.password")).sendKeys(data.getPassword());
		driver.findElement(By.id("repeatedPassword")).sendKeys(data.getPassword());

		WebElement submit = driver.findElement(By.xpath("//input[@value='Register']"));
		submit.click();

		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		String expectedTitle = "ParaBank | Customer Created";
		assertEquals(actualTitle, expectedTitle, "Page title does not match the expected value");

	}

	public void accountLogout() {

		WebElement logout = driver.findElement(By.xpath("//a[normalize-space()='Log Out']"));
		logout.click();
	}

}

package pageObjects;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OpenNewAccountPage extends BasePage {

	public OpenNewAccountPage(WebDriver driver) {
		super(driver);

	}

	public void clickOpenNewAccountLink() {
		driver.findElement(By.xpath("//a[normalize-space()='Open New Account']")).click();

	}

	public void openNewAccount() {

		WebElement dropdown = driver.findElement(By.id("type"));
		Select accountType = new Select(dropdown);
		accountType.selectByVisibleText("SAVINGS");

		WebElement dropdown2 = driver.findElement(By.id("fromAccountId"));
		Select existingaccount = new Select(dropdown2);
		existingaccount.selectByIndex(0);

		driver.findElement(By.xpath("//input[@value='Open New Account']")).click();
	}

	public void verifyOpenAccountExist() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement newAccountElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("newAccountId")));

		String newAccount = newAccountElement.getText();
		if (newAccount == null) {
			throw new AssertionError("New account ID is empty or not found.");
		} else {
			System.out.println("My New Account ID: " + newAccount);
		}

	}

	public void accountDetails() {
		// Click the new account link
		driver.findElement(By.id("newAccountId")).click();

		// Locate the table
		WebElement table = driver.findElement(By.xpath("//div[@id='accountDetails']//table"));

		// Get all rows
		List<WebElement> rows = table.findElements(By.tagName("tr"));

		for (WebElement row : rows) {
			// Get all columns in the current row
			List<WebElement> cells = row.findElements(By.tagName("td"));

			for (WebElement cell : cells) {

				System.out.print(cell.getText() + " | "); // print each td value
				System.out.println(table.getText());
				

			}
			System.out.println(); // move to next line after each row
		}
	}

	public void accountActivity() {
		// Select month
		WebElement dropdown = driver.findElement(By.id("month"));
		Select activityPeriod = new Select(dropdown);
		activityPeriod.selectByVisibleText("August");

		// Select transaction type
		WebElement dropdown2 = driver.findElement(By.id("transactionType"));
		Select type = new Select(dropdown2);
		type.selectByIndex(0);

		// Click submit
		driver.findElement(By.xpath("//input[@type='submit']")).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Wait for table rows to load (at least one row with data)
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//table[@id='transactionTable']//tbody/tr/td[normalize-space()]")));

		// Locate the table again after wait
		WebElement table = driver.findElement(By.id("transactionTable"));

		// Get table header
		List<WebElement> headers = table.findElements(By.tagName("th"));
		for (WebElement header : headers) {
			System.out.print(header.getText() + " | ");
		}
		System.out.println();

		// Get table rows from tbody
		List<WebElement> rows = table.findElements(By.xpath(".//tbody/tr"));
		for (WebElement row : rows) {
			List<WebElement> columns = row.findElements(By.tagName("td"));
			for (WebElement cell : columns) {
				System.out.print(cell.getText().trim() + " | ");
			}
			System.out.println();
		}
	}

}

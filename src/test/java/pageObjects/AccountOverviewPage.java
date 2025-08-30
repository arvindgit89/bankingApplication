package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountOverviewPage extends BasePage {

	public AccountOverviewPage(WebDriver driver) {
		super(driver);

	}
	
	public void accountOverview() {

		WebElement table = driver.findElement(By.id("accountTable"));

		// Get table headers
		List<WebElement> headers = table.findElements(By.tagName("th"));
		for (WebElement header : headers) {
			System.out.print(header.getText() + " | ");
		}
		System.out.println();

		// Get table rows from tbody
		List<WebElement> rows = table.findElements(By.xpath(".//tbody/tr"));
		for (WebElement row : rows) 
		{
			List<WebElement> columns = row.findElements(By.tagName("td"));
			for (WebElement cell : columns) 
			{
				System.out.print(cell.getText() + " | ");
			}
			System.out.println();
		}

	}

	/*public void accountOverview() {

	    // Get all rows of the table
	    List<WebElement> rows = driver.findElements(By.xpath("//*[@id='accountTable']/tbody/tr"));
	    System.out.println("No. of rows: " + rows.size());

	    // Get all column headers
	    List<WebElement> headers = driver.findElements(By.xpath("//*[@id='accountTable']/thead/tr/th"));
	    System.out.println("No. of columns: " + headers.size());

	    // Print headers
	    for (WebElement header : headers) {
	        System.out.print(header.getText() + " | ");
	    }
	    System.out.println();

	    // print table data
	    for (int r = 1; r <= rows.size(); r++) {
	        for (int c = 1; c <= headers.size(); c++) {
	            String cellXPath = "//*[@id='accountTable']/tbody/tr[" + r + "]/td[" + c + "]";
	            String data = driver.findElement(By.xpath(cellXPath)).getText();
	            System.out.print(data + " | ");
	        }
	        System.out.println();
	    }
	}*/
	

}
	
	


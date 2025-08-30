package testBase;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BaseClass {
	public static WebDriver driver;
	public Properties p;

	@BeforeTest
	@Parameters({ "browser" })

	public void launchBrowser(String br) throws IOException {

		FileReader file = new FileReader("./src//test//resources/config.properties");
		p = new Properties();
		p.load(file);

		switch (br.toLowerCase()) {
		case "chrome":
			System.out.println("Launch Chrome browser...");
			driver = new ChromeDriver();
			break;
		case "firefox":
			System.out.println("Launch Firefox browser...");
			driver = new FirefoxDriver();
			break;
		case "edge":
			System.out.println("Launch Edge browser...");
			driver = new EdgeDriver();
			break;
		default:
			System.out.println("Invalid browser name provided: " + br);
			return;
		}

		driver.get(p.getProperty("appURL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
	}

	@AfterTest
	public void tearDown() {

		// driver.quit();

	}
}

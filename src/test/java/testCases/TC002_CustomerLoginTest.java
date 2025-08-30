package testCases;

import org.testng.annotations.Test;
import pageObjects.LoginPage;
import testBase.BaseClass;
public class TC002_CustomerLoginTest extends BaseClass {
	@Test
	public void verify_customer_login() throws Exception 
	{
	
		LoginPage lp = new LoginPage(driver);
		lp.customerLogin();
		lp.isAccountOverviewExist();
		
	}
}
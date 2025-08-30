package testCases;

import org.testng.annotations.Test;

import pageObjects.AccountOverviewPage;
import testBase.BaseClass;

public class TC003_AccountOverviewTest extends BaseClass{
	@Test
	public void verify_account_overview()
	{
		AccountOverviewPage accountdetail = new AccountOverviewPage(driver);
		accountdetail.accountOverview();
	}

}

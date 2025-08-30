package testCases;

import org.testng.annotations.Test;

import pageObjects.OpenNewAccountPage;
import testBase.BaseClass;

public class TC004_OpenNewAccountTest extends BaseClass {
	@Test
	public void verify_openNewAccount()
	{
		OpenNewAccountPage openNewAccount = new OpenNewAccountPage(driver);
		openNewAccount.clickOpenNewAccountLink();
		openNewAccount.openNewAccount();
		openNewAccount.verifyOpenAccountExist();
		openNewAccount.accountDetails();
		openNewAccount.accountActivity();
	}

}

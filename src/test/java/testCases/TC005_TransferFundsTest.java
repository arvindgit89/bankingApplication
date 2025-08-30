package testCases;

import org.testng.annotations.Test;

import pageObjects.TransferFundsPage;
import testBase.BaseClass;

public class TC005_TransferFundsTest extends BaseClass{
	@Test
	public void verify_transferFunds()
	{
		TransferFundsPage ft = new TransferFundsPage(driver);
		ft.transferFunds();
	}

}

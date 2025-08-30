package testCases;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;
public class TC001_AccountRegistrationTest extends BaseClass {

    @Test
    public void verify_account_registration() throws Exception {
        HomePage hp = new HomePage(driver);
        hp.clickregisterLink();
        AccountRegistrationPage arp = new AccountRegistrationPage(driver);
        arp.registration();
        arp.accountLogout();
        
    }

}

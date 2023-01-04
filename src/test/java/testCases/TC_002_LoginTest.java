package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass
{
	@Test(groups={"Sanity","Master"})//step no 8 groups added
	public void test_Login()
	{
		logger.info("****Starting TC_002_LoginTest****");
		
		try
		{
		//HomePage-->MyAccount-->Login
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		//LoginPage-->Email & Password then click
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		//lp.setPassword(p.getProperty("xyz"));
		lp.clickLogin();
		
		//Check MyAccount label is present
		MyAccountPage macc=new MyAccountPage(driver);
		boolean targetpage=macc.isMyAccountPageExists();
		
		Assert.assertEquals(targetpage,true);
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("*****Finished TC_002_LoginTest*****");
	}

}

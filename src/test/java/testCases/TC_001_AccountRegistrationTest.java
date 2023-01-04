package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass{
	@Test(groups={"Sanity","Master"})
	public void test_account_Registration()
	{
		
		logger.info("Starting TC_001_AccountRegistrationTest");
		logger.trace("Capturing trace logs");
		logger.debug("Capturind debug logs");
		try
		{
		HomePage hp=new HomePage(driver);
		logger.info("click on MyAccount link");
		hp.clickMyAccount();
		
		logger.info("Click on Registration link");
		hp.clickRegister();
		
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		
		
		logger.info("Providing customer details");
		regpage.setFirstName(randomString().toUpperCase());
		regpage.setLastname(randomString().toUpperCase());
		regpage.setEmail(randomString()+"@gmail.com");// randomly generated the email
		regpage.setTelephone(randomNumber());
		
		String password=randomAlphaNumeric();
		regpage.setPassword(password);
		regpage.setConfirmPassword(password);
		
		regpage.setPrivacypolicy();
		
		logger.info("Click on continue button");
		regpage.clickContinue();
		
		String confmsg=regpage.getConformationMsg();
		
		
		logger.info("Verify customer registration");
		
		if(confmsg.equals("Your Account Has Been Created!"))
		{
			logger.info("Test passed");
			Assert.assertTrue(true);
		}
		else
		{
			logger.warn("Customer registration is not successful");
			logger.error("Test failed");
			Assert.assertTrue(false);
		}
		
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("finished TC_001_AccountRegistrationTest");
	}
	
		
}
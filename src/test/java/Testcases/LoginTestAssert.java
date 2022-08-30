package Testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.FrameWork.Login.POM.*;



public class LoginTestAssert extends Baseclass {
	@Test
	public void loginTest() throws IOException {
     
       
		logger.info("URL is Opened");
		LoginPage lp = new LoginPage(driver);
	

		lp.giveUserName(username);
		logger.info("Enter User Name");

		lp.giveUserpassword(password);
		logger.info("Enter your Password");

		lp.clickLoginBTN();
		logger.info("Clicking on SignIn Button");
		String title=driver.getTitle();

		if (driver.getTitle().equals(title)) {
			Assert.assertTrue(true);
			logger.info("LogIn test Passed");
		} else {
			captureScreen(driver, "loginTest");
			Assert.assertFalse(false);
			logger.info("LogIn test Failed");
		}
		
	
	}
	
	    
	     
	   

}

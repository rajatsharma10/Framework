package Testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.*;
import com.FrameWork.Login.POM.LoginPage;
import com.FrameWork.Login.POM.NewCustomer;
import com.mongodb.diagnostics.logging.Logger;

import Testcases.LoginTest;
import utilities.Xlutiles;
public class testNewCustomer extends Baseclass {

	
	
    @Test(priority = 1)
	public void newcustomer() throws InterruptedException {
		NewCustomer Cust=new NewCustomer(driver);
		LoginPage lp = new LoginPage(driver);
		
		lp.giveUserName(username);
		logger.info("Enter User Name");

		lp.giveUserpassword(password);
		logger.info("Enter your Password");

		lp.clickLoginBTN();
		logger.info("Clicking on SignIn Button");
		
	
		Thread.sleep(5000);
		logger.info("Clicking newcustomer Button");
		Thread.sleep(10000);
	
	}
    @Test(dataProvider = "TestData",priority = 2)
    public void NewCustomerFields(String Firstname,String Address,String city,String State,
    		String pin,String MobileNo,String Email,String PassWord) throws InterruptedException {
         	NewCustomer set=new NewCustomer(driver);
         	set.clickNewCustomer();
         	set.GiveFirstname(Firstname);
        	logger.info("Enter first name");
        	set.Date();
        	logger.info("enter the Date !");
        	
         	set.GiveAddress(Address);
        	logger.info("Enter the Adress");
            set.GiveCity(city);
        	logger.info("Enter the city");
            set.GiveState(State);
        	logger.info("Enter the state");
            set.GivePin(pin);
        	logger.info("Enter the pin");
            set.GivePhoneNUM(MobileNo);
        	logger.info("Enter the Mobilenumber");
            set.GiveEmail(Email);
        	logger.info("Enter the email");
            set.GivePassword(PassWord);
        	logger.info("Enter the password");
        	set.Submit();
        	logger.info("Sumbit the form");
        	if (LoginTest.isAlertPresent() == true) {
    			driver.switchTo().alert().accept();// close alert
    			driver.switchTo().defaultContent();
    			logger.info("form Submitted Successfully !");
    			
    		} else {
    			Assert.assertTrue(false);
    			logger.info("Submit Failed");
    		

    		}
        	
        	
        	
    	
	}
	
   
	@DataProvider(name = "TestData")
	String[][] getData() throws IOException {
		String path = System.getProperty("user.dir") + "/src/test/java/TestDataXlsx/Book2.xlsx";

		int rownum = Xlutiles.getRowCount(path, "Sheet1");
		int colcount = Xlutiles.getCellCount(path, "Sheet1", 1);

		String logindata[][] = new String[rownum][colcount];

		for (int i = 1; i <= rownum; i++) {
			for (int j = 0; j < colcount; j++) {
				logindata[i - 1][j] = Xlutiles.getCellData(path, "Sheet1", i, j);// 1 0
			}

		}
		return logindata;
}
    }

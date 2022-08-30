package Testcases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.FrameWork.Login.POM.LoginPage;

import utilities.Xlutiles;



public class LoginTest extends Baseclass{

	@Test(dataProvider = "LoginData")
	public void loginDDT(String user, String pwd) throws InterruptedException {
		LoginPage lp = new LoginPage(driver);
		lp.giveUserName(user);
		logger.info("user name provided");
		lp.giveUserpassword(pwd);
		logger.info("password provided");
		lp.clickLoginBTN();

		Thread.sleep(3000);

		if (isAlertPresent() == true) {
			driver.switchTo().alert().accept();// close alert
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("Login failed");
		} else {
			Assert.assertTrue(true);
			logger.info("Login passed");
			lp.userLogOutBTN();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();// close logout alert
			driver.switchTo().defaultContent();

		}

	}

	public static boolean isAlertPresent() // user defined method created to check alert is presetn or not
	{
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}

	}

	@DataProvider(name = "LoginData")
	String[][] getData() throws IOException {
		String path = System.getProperty("user.dir") + "/src/test/java/TestDataXlsx/LoginData.xlsx";

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

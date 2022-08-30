package com.FrameWork.Login.POM;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.dockerjava.api.model.Driver;

public class NewCustomer {

	public NewCustomer(WebDriver rdriver) {
		WebDriver driver;
		 driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
		

		// TODO Auto-generated constructor stub
	          
			  @FindBy(xpath = "//a[text()='New Customer']")
			  @CacheLookup
			  WebElement NewCustomer;
			  @FindBy(name  = "name")
			  @CacheLookup
			  WebElement FirstName;
			  @FindBy(xpath = "//input[@id='dob']")
			  @CacheLookup
			  WebElement Date;
			  @FindBy(xpath = "//textarea[@onblur='validateAddress();']")
			  @CacheLookup
			  WebElement Address;
			  @FindBy(xpath = "//input[@name='city']")
			  @CacheLookup
			   WebElement city;
			  @FindBy(xpath = "//input[@name='state']")
			  @CacheLookup
			   WebElement state;
			  @FindBy(xpath = "//input[@name='pinno']")
			  @CacheLookup
			   WebElement pin;
			  @FindBy(xpath = "//input[@name='telephoneno']")
			  @CacheLookup
			   WebElement PhoneNum;
			  @FindBy(xpath = "//input[@name='emailid']")
			  @CacheLookup
			  WebElement Email;
			  @FindBy(xpath = "//input[@name='password']")
			  @CacheLookup
			   WebElement Pass;
			  @FindBy(xpath = "//input[@type='submit']")
			  @CacheLookup
			   WebElement clicknewcustomer;
			  
		
	
			  
	public void clickNewCustomer() {
		NewCustomer.click();
	}
	public void GiveFirstname(String FIRSTNAME) {
		
		FirstName.sendKeys(FIRSTNAME);
	}
	public void Date() {
		Date.sendKeys("0222022");
	}
	public void GiveAddress(String ADDRESS) {
		Address.sendKeys(ADDRESS);
	}
	public void GiveCity(String CITY) {
		city.sendKeys(CITY);
	}
	public void GiveState(String STATE) {
		state.sendKeys(STATE);
	}
	public void GivePin(String PIN) {
		pin.sendKeys(PIN);
	}
	public void GivePhoneNUM(String PHONENUMBER) {
		PhoneNum.sendKeys(PHONENUMBER);
	}
	public void GiveEmail(String EMAIL) {
		Email.sendKeys(EMAIL);
	}
	public void GivePassword(String PASSWORD) {
		Pass.sendKeys(PASSWORD);
	}
	
	
	 
	
	public void Submit() {
		clicknewcustomer.click();
	}
	

}

package com.cucumber.pom.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.cucumber.pom.commonfunctions.CommonFunctions;
import com.cucumber.pom.util.Base;

public class LoginPage {
	
	WebDriver driver;
	By txt_username = By.id("useremail");
	By txt_password = By.id("userpass");
    By btn_submit = By.id("loginsubmit");
    By link_logout = By.xpath("//*[@id='signin_info']/a");
    By error_message = By.xpath("//*[@id='message_shows']/div");
    WebDriverWait wait;
    CommonFunctions commonFunction;
    
    public LoginPage(WebDriver driver) {
    	this.driver = driver;
    }
        
	public void enterUsername(String username) {
		try {
			driver.findElement(txt_username).sendKeys(username);
			Base.test.log(Status.INFO, "Username entered successfully...");
		} catch (Exception e) {
			Base.test.log(Status.FAIL, "Unable to enter Username..." + e.getMessage());
			Assert.fail("Unable to enter Username..." + e.getMessage());
		}
	}
    
    public void enterPassword(String password){
    	try {
			driver.findElement(txt_password).sendKeys(password);
			Base.test.log(Status.INFO, "Password entered successfully...");
			String screenshotPath = Base.getScreenhot(driver, new Exception().getStackTrace()[0].getMethodName());
			Base.test.log(Status.INFO, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		} catch (Exception e) {
			Base.test.log(Status.FAIL, "Unable to enter Password..." + e.getMessage());
			Assert.fail("Unable to enter Password..." + e.getMessage());
		}
    }
    
    public void clickSubmitButton(){
    	try {
    		driver.findElement(btn_submit).click();
			Base.test.log(Status.INFO, "Submit button clicked successfully...");
		} catch (Exception e) {
			Base.test.log(Status.FAIL, "Unable to click Submit button..." + e.getMessage());
			Assert.fail("Unable to click Submit button..." + e.getMessage());
		}
    	   	
    }
    
	public boolean verifySignIn() {
		try {
			commonFunction = new CommonFunctions(driver);
			//Thread.sleep(10000);
			commonFunction.waitTillElementRefreshed(link_logout);
			if (driver.findElement(link_logout).isDisplayed() == true) {
				commonFunction.waitTillElementRefreshed(link_logout);
				String screenshotPath = Base.getScreenhot(driver, new Exception().getStackTrace()[0].getMethodName());
				Base.test.log(Status.INFO, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
				return true;		
		  	 }
		} catch (Exception e) {
			Base.test.log(Status.FAIL, "Unable to verify signin..." + e.getMessage());
			Assert.fail("Unable to verify signin..." + e.getMessage());
		}
		return false;
	}
    
    public boolean verifySignInFail() {
		if(driver.findElement(error_message).isDisplayed()==true)
    	  return true;
    	else return false;
    }
    
}

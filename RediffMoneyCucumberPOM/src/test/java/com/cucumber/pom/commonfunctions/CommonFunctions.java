package com.cucumber.pom.commonfunctions;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonFunctions {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public CommonFunctions(WebDriver driver) {
    	this.driver = driver;
    }
	
	public void waitTillVisibilityOfElementLocated(By locator) {
		wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public void waitTillElementRefreshed(By locator) {
		wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator)));
	}

	public void waitTillElementClickable(By locator) {
		wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	public void waitTillTextToBePresentInElement(By locator, String text) {
		wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
		
	}
	
	public void waitTillVisibilityOfAllElementsLocated(By locator) {
		wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}
	
	public void waitTillInvisibilityOfAllElementsLocated(By locator) {
		wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}
	
	public void waitTillpresenceOfAllElementsLocated(By locator) {
		wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
	}
	
	public void waitTillAlertIsPresent() {
		wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.alertIsPresent());
	}
		
	
	public boolean checkPresenceOfElement(By locator) {
		boolean flag = false;
		try {
			WebElement element = driver.findElement(locator);
			if (element.isDisplayed() || element.isEnabled()) {
				flag = true;
			}

		} catch (NoSuchElementException e) {
			flag = false;
		}
		return flag;
	}
	
	public void takeScreenShot(String filePath, String fileName) {
		//Take the screenshot
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        
        //Copy the file to a location and use try catch block to handle exception
        try {
            FileUtils.copyFile(screenshot, new File(filePath+fileName));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
	}
	
	

}

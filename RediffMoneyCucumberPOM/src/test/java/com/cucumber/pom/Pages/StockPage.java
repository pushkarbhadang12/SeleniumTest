package com.cucumber.pom.Pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.cucumber.pom.commonfunctions.CommonFunctions;
import com.cucumber.pom.util.Base;

public class StockPage {
	
	WebDriver driver;
	By tbl_dataTable = By.id("stock");
	By link_logout = By.xpath("//*[@id='signin_info']/a");
	By btn_AddStock = By.xpath("//*[@id='addStock']");
	By txt_StockName = By.id("addstockname");
	By date_StockDate = By.id("stockAddDate");
	By txt_AddStockQuantity = By.id("addstockqty");
	By txt_AddStockPrice = By.id("addstockprice");
	By span_Exchange = By.xpath("//*[@id='exchange_tab']/span/label");
	By btn_SubmitAddStock = By.id("addStockButton");
	By link_companyIdList = By.xpath("//table[@id='stock']/tbody/tr/td[1]");
	By link_CompanyNameList = By.xpath("//span[starts-with(@id,'companyname')]/a");
	By btn_DeleteButtonList = By.xpath("//input[@name='Delete' and @class='deleteEquity']");
	By link_SignOut = By.xpath("//a[text()='Sign Out']");
	
	WebDriverWait wait;
	CommonFunctions commonFunction;
	
	public StockPage(WebDriver driver) {
		this.driver = driver;
	}
			
	public void scrollDownTillStockSectionVisible() {
		try {
			WebElement addStock = driver.findElement(btn_AddStock);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", addStock);
			Base.test.log(Status.INFO, "Scrolled down to Stock section...");
			String screenshotPath = Base.getScreenhot(driver, new Exception().getStackTrace()[0].getMethodName());
			Base.test.log(Status.INFO, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		} catch (Exception e) {
			Base.test.log(Status.FAIL, "Unable to scroll down to Stock section..." + e.getMessage());
			Assert.fail("Unable to scroll down to Stock section..." + e.getMessage());
		}
	}

	public void clickAddStock() {
		try {
			driver.findElement(btn_AddStock).click();
			Base.test.log(Status.INFO, "Clicked on Add stock button...");
		} catch (Exception e) {
			Base.test.log(Status.FAIL, "Unable to click on Add stock button..." + e.getMessage());
			Assert.fail("Unable to click on Add stock button..." + e.getMessage());
		}
	}
	
//	public void clickLogOutLink() {
//		try {
//			commonFunction = new CommonFunctions(driver);
//			commonFunction.waitTillVisibilityOfElementLocated(link_SignOut);
//			driver.findElement(link_SignOut).click();
//			Base.test.log(Status.INFO, "Clicked on LogOut link...");
//		} catch (Exception e) {
//			Base.test.log(Status.FAIL, "Unable to click on LogOut link..." + e.getMessage());
//			Assert.fail("Unable to click on LogOut link..." + e.getMessage());
//		}
//		
//	}
	
	public void enterStockName(String stockName) {
		try {
			//commonFunction = new CommonFunctions(driver);
			driver.findElement(txt_StockName).sendKeys(stockName);
			Thread.sleep(1000);
			driver.findElement(txt_StockName).sendKeys(Keys.TAB);
			//commonFunction.waitTillVisibilityOfElementLocated(date_StockDate);
			Base.test.log(Status.INFO, "Entered stock name "+stockName);
		} catch (Exception e) {
			Base.test.log(Status.FAIL, "Unable to enter stock name..." + e.getMessage());
			Assert.fail("Unable to enter stock name..." + e.getMessage());
		}
	}
	
	public void enterStockDate(String stockDate) {
		try {
			driver.findElement(date_StockDate).sendKeys(stockDate);
			Base.test.log(Status.INFO, "Entered stock date "+stockDate);
		} catch (Exception e) {
			Base.test.log(Status.FAIL, "Unable to enter stock date..." + e.getMessage());
			Assert.fail("Unable to enter stock date..." + e.getMessage());
		}
	}
	
	public void enterStockQuantity(String stockQuantity) {
	try {
			driver.findElement(txt_AddStockQuantity).sendKeys(stockQuantity);
			Base.test.log(Status.INFO, "Entered stock quantity "+stockQuantity);
		} catch (Exception e) {
			Base.test.log(Status.FAIL, "Unable to enter stock quantity..." + e.getMessage());
			Assert.fail("Unable to enter stock quantity..." + e.getMessage());
		}
	}
	
	public void enterStockPrice(String stockPrice) {
	try {
			driver.findElement(txt_AddStockPrice).sendKeys(stockPrice);
			Base.test.log(Status.INFO, "Entered stock price "+stockPrice);
		} catch (Exception e) {
			Base.test.log(Status.FAIL, "Unable to enter stock price..." + e.getMessage());
			Assert.fail("Unable to enter stock price..." + e.getMessage());
		}
	}
	
	public void selectExchange(String exchange) {
		try {
			List<WebElement> exchangelist = driver.findElements(span_Exchange);
			for (int i = 0; i < exchangelist.size(); i++) {
				if (exchangelist.get(i).getText().equalsIgnoreCase(exchange)) {
					exchangelist.get(i).click();
					Base.test.log(Status.INFO, "Selected exchange " + exchange);
					break;
				}
			}
			String screenshotPath = Base.getScreenhot(driver, new Exception().getStackTrace()[0].getMethodName());
			Base.test.log(Status.INFO, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		} catch (Exception e) {
			Base.test.log(Status.FAIL, "Unable to select exchange..." + e.getMessage());
			Assert.fail("Unable to select exchange..." + e.getMessage());
		}
	}
    
    public void clickSubmitAddStock() {
		try {
			driver.findElement(btn_SubmitAddStock).click();
			Base.test.log(Status.INFO, "Clicked on submit add stock button...");
		} catch (Exception e) {
			Base.test.log(Status.FAIL, "Unable to clicked on submit add stock button..." + e.getMessage());
			Assert.fail("Unable to clicked on submit add stock button..." + e.getMessage());
		}
	}
    
	public boolean verifyStock(String stockName) {
		boolean flag = false;
		try {			
			//Thread.sleep(20000);
			commonFunction = new CommonFunctions(driver);
			commonFunction.waitTillInvisibilityOfAllElementsLocated(btn_SubmitAddStock);
			String screenshotPath = Base.getScreenhot(driver, new Exception().getStackTrace()[0].getMethodName());
			Base.test.log(Status.INFO, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			List<WebElement> stocklist = driver.findElements(link_CompanyNameList);
			for (int i = 0; i < stocklist.size(); i++) {
				if (stockName.contains(stocklist.get(i).getText())) {
					flag = true;
					break;
				}
			}
		} catch (Exception e) {
			Base.test.log(Status.FAIL, "Unable to verify addition of stock..." + e.getMessage());
			Assert.fail("Unable to verify addition of stock.." + e.getMessage());
		}

		if (flag == true)
			return true;
		else
			return false;
	}
    
	public boolean verifyPresenceOfStock(String stockName) {
		boolean flag = false;
		try {
			List<WebElement> companyNameList = driver.findElements(link_CompanyNameList);
			for (int i = 0; i < companyNameList.size(); i++) {
				if (stockName.contains(companyNameList.get(i).getText())) {
					flag = true;
					break;
				} else
					flag = false;
			}
		} catch (Exception e) {
			Base.test.log(Status.FAIL, "Unable to verify presence of stock..." + e.getMessage());
			Assert.fail("Unable to verify presence of stock..." + e.getMessage());
		}
		if (flag == true)
			return true;
		else
			return false;
	}
    
	public void selectStockandClickDelete(String stockName) {
		try {
			
			List<WebElement> companyIdList = driver.findElements(link_companyIdList);
			List<WebElement> companyNameList = driver.findElements(link_CompanyNameList);
			List<WebElement> deletebuttonList = driver.findElements(btn_DeleteButtonList);
			commonFunction = new CommonFunctions(driver);
			for (int i = 0; i < companyNameList.size(); i++) {
				if (stockName.contains(companyNameList.get(i).getText())) {
					companyIdList.get(i).click();
					Base.test.log(Status.INFO, "Selected stock to be deleted..." + stockName);
					Base.test.log(Status.INFO, "Deleting stock..." + stockName);
					deletebuttonList.get(i).click();
					break;
				}
			}
			commonFunction.waitTillAlertIsPresent();
			Base.test.log(Status.INFO, "Accepting Stock deletion alert...");
			driver.switchTo().alert().accept();
			Base.test.log(Status.INFO, "Stock deletion alert accepted...");
			Base.test.log(Status.INFO, "Stock deleted..."+stockName);
			String screenshotPath = Base.getScreenhot(driver, new Exception().getStackTrace()[0].getMethodName());
			Base.test.log(Status.INFO, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		} catch (Exception e) {
			Base.test.log(Status.FAIL, "Unable to select/delete stock..." + e.getMessage());
			Assert.fail("Unable to select/delete stock..." + e.getMessage());
		}
	}
	
	public boolean verifyDeleteStock(String stockName) {
		boolean flag = false;
		try {
			//Thread.sleep(20000);
			commonFunction = new CommonFunctions(driver);
			commonFunction.waitTillElementRefreshed(link_CompanyNameList);
			String screenshotPath = Base.getScreenhot(driver, new Exception().getStackTrace()[0].getMethodName());
			Base.test.log(Status.INFO, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			List<WebElement> stocklist = driver.findElements(link_CompanyNameList);
			for (int i = 0; i < stocklist.size(); i++) {
				if (stockName.contains(stocklist.get(i).getText())) {
					flag = true;
					break;
				}
			}
		} catch (Exception e) {
			Base.test.log(Status.FAIL, "Unable to verify addition/deletion of stock..." + e.getMessage());
			Assert.fail("Unable to verify addition/deletion of stock.." + e.getMessage());
		}

		if (flag == true)
			return true;
		else
			return false;
	}
}

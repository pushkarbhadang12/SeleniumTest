package com.cucumber.pom.Pages;

import java.util.Iterator;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.cucumber.pom.commonfunctions.CommonFunctions;
import com.cucumber.pom.util.Base;

public class MyPortfolioPage {

	WebDriver driver;

	By btn_Create = By.id("createPortfolio");
	By txt_MyPortfolio = By.id("create");
	By btn_createPortfolio = By.id("createPortfolioButton");
	By portfolioId = By.id("portfolioid");
	By portfolioIds = By.xpath("//*[@id='portfolioid']/option");
	By txt_portfolioAddError = By.xpath("//*[@id='portfolioAddError']/div/div");
	By btn_portfolioAddClose = By.id("portfolioAddClose");
	By btn_deletePortfolio = By.id("deletePortfolio");
	By btn_rename = By.id("renamePortfolio");
	By txt_rename = By.id("rename");
	By btn_renamePortfolio = By.xpath("//*[@id='renamePortfolioButton']");
	By btn_AddStock = By.xpath("//*[@id='addStock']");
	By link_SignOut = By.xpath("//a[text()='Sign Out']");
	WebDriverWait wait;
	CommonFunctions commonFunction;

	public MyPortfolioPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickLogOutLink() {
		try {
			commonFunction = new CommonFunctions(driver);
			commonFunction.waitTillVisibilityOfElementLocated(link_SignOut);
			Base.test.log(Status.INFO, "Clicked on LogOut link...");
			driver.findElement(link_SignOut).click();
			Base.test.log(Status.INFO, "Loged Out successfully...");
		} catch (Exception e) {
			Base.test.log(Status.FAIL, "Unable to click on LogOut link..." + e.getMessage());
			Assert.fail("Unable to click on LogOut link..." + e.getMessage());
		}
		
	}

	public void clickCreateButton() {
		try {
			commonFunction = new CommonFunctions(driver);
			commonFunction.waitTillVisibilityOfElementLocated(btn_Create);
			driver.findElement(btn_Create).click();
			Base.test.log(Status.INFO, "Clicked on create button...");
		} catch (Exception e) {
			Base.test.log(Status.FAIL, "Unable to click on Create button..." + e.getMessage());
			Assert.fail("Unable to click on Create button..." + e.getMessage());
		}
	}

	public void enterPortfolio(String portfolioName) {
		try {
			commonFunction = new CommonFunctions(driver);
			commonFunction.waitTillVisibilityOfElementLocated(txt_MyPortfolio);
			driver.findElement(txt_MyPortfolio).clear();
			driver.findElement(txt_MyPortfolio).sendKeys(portfolioName);
			Base.test.log(Status.INFO, "Entered Portfolio name..." + portfolioName);
			String screenshotPath = Base.getScreenhot(driver, new Exception().getStackTrace()[0].getMethodName());
			Base.test.log(Status.INFO, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		} catch (Exception e) {
			Base.test.log(Status.FAIL, "Unable to enter Portfolio name..." + e.getMessage());
			Assert.fail("Unable to enter Portfolio name..." + e.getMessage());
		}
	}

	public void clickCreatePortfolioButton() {
		try {
			commonFunction = new CommonFunctions(driver);
			commonFunction.waitTillVisibilityOfElementLocated(btn_createPortfolio);
			driver.findElement(btn_createPortfolio).click();
			Base.test.log(Status.INFO, "Clicked on Create Portfolio button...");
		} catch (Exception e) {
			Base.test.log(Status.FAIL, "Unable to click on Create Portfolio button..." + e.getMessage());
			Assert.fail("Unable to click on Create Portfolio button..." + e.getMessage());
		}
	}

	public void verifyPortfolio(String portfolioName) {
		try {
			Base.test.log(Status.INFO, "Verifying if Portfolio name is non existing...");
			commonFunction = new CommonFunctions(driver);
			if (commonFunction.checkPresenceOfElement(txt_portfolioAddError) == true) {
				Base.test.log(Status.FAIL, portfolioName + " already exits...");
				Assert.fail(portfolioName + " already exits...");
				String screenshotPath = Base.getScreenhot(driver, new Exception().getStackTrace()[0].getMethodName());
				Base.test.log(Status.INFO, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			} else {
				Base.test.log(Status.INFO, portfolioName + " can be created...");
				verifyPortfolioCreation(portfolioName);
			}
		} catch (Exception e) {
			Base.test.log(Status.FAIL, "Unable to verify Portfolio..." + e.getMessage());
			Assert.fail("Unable to verify Portfolio..." + e.getMessage());
		}
	}

	public void verifyPortfolioCreation(String portfolioName) {
		try {
			Base.test.log(Status.INFO, "Creating Portfolio " + portfolioName + "...");
			commonFunction = new CommonFunctions(driver);
			commonFunction.waitTillElementRefreshed(portfolioIds);

			List<WebElement> listPortfolioIds = driver.findElements(portfolioIds);
			Iterator<WebElement> iterator = listPortfolioIds.iterator();
			while (iterator.hasNext()) {
				if (iterator.next().getText().equals(portfolioName)) {
					String screenshotPath = Base.getScreenhot(driver, new Exception().getStackTrace()[0].getMethodName());
					Base.test.log(Status.INFO, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
					Base.test.log(Status.PASS, portfolioName + " created successfully");
					break;
				}
			}
		} catch (Exception e) {
			Base.test.log(Status.FAIL, "Unable to create Portfolio..." + e.getMessage());
			Assert.fail("Unable to create Portfolio..." + e.getMessage());
		}
	}

	public void selectPortfolio(String portfolioName) {
		try {
			Base.test.log(Status.INFO, "Selecting Portfolio name " + portfolioName + " ...");
			driver.findElement(portfolioId).click();
			commonFunction = new CommonFunctions(driver);
			commonFunction.waitTillElementRefreshed(portfolioIds);
			List<WebElement> listPortfolioIds = driver.findElements(portfolioIds);
			for (int i = 0; i < listPortfolioIds.size(); i++) {
				if (listPortfolioIds.get(i).getText().equals(portfolioName)) {
					listPortfolioIds.get(i).click();
					Base.test.log(Status.INFO, portfolioName + " selected successfully...");
					String screenshotPath = Base.getScreenhot(driver, new Exception().getStackTrace()[0].getMethodName());
					Base.test.log(Status.INFO, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
					break;
				}
			}
		} catch (Exception e) {
			Base.test.log(Status.FAIL, "Unable to select Portfolio..." + e.getMessage());
			Assert.fail("Unable to select Portfolio..." + e.getMessage());
		}
	}

	public void clickDeletePortfolioButton() {
		try {
			Base.test.log(Status.INFO, " Clicking on Delete Portfolio button...");
			commonFunction = new CommonFunctions(driver);
			commonFunction.waitTillElementRefreshed(portfolioIds);
			commonFunction.waitTillVisibilityOfElementLocated(btn_deletePortfolio);
			driver.findElement(btn_deletePortfolio).click();
			Base.test.log(Status.INFO, " Clicked on Delete Portfolio button...");
		} catch (Exception e) {
			Base.test.log(Status.FAIL, "Unable to click on Delete Portfolio button..." + e.getMessage());
			Assert.fail("Unable to click on Delete Portfolio button..." + e.getMessage());
		}
	}

	public void clickOkDeletePortfolioButton() {
		try {
			Base.test.log(Status.INFO, "Accepting Alert...");
			driver.switchTo().alert().accept();
			//String screenshotPath = Base.getScreenhot(driver, new Exception().getStackTrace()[0].getMethodName());
			//Base.test.log(Status.INFO, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			Base.test.log(Status.INFO, "Alert accepted by clicking on Ok button...");
		} catch (Exception e) {
			Base.test.log(Status.FAIL, "Unable to Accept Alert..." + e.getMessage());
			Assert.fail("Unable to Accept Alert..." + e.getMessage());
		}
	}

	public void verifyPortfolioDeletion(String portfolioName) {
		try {
			Base.test.log(Status.INFO, "Verifying Portfolio deletion...");
			commonFunction = new CommonFunctions(driver);
			commonFunction.waitTillElementRefreshed(portfolioIds);
			driver.findElement(portfolioId).click();
			String screenshotPath = Base.getScreenhot(driver, new Exception().getStackTrace()[0].getMethodName());
			Base.test.log(Status.INFO, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			driver.findElement(portfolioId).click();
			
			List<WebElement> listPortfolioIds = driver.findElements(portfolioIds);
			Iterator<WebElement> iterator = listPortfolioIds.iterator();
			while (iterator.hasNext()) {
				if (!iterator.next().getText().equals(portfolioName)) {
					Base.test.log(Status.PASS, portfolioName + " deleted successfully");
					break;
				}

			}
		} catch (Exception e) {
			Base.test.log(Status.FAIL,
					"Unable to delete Portfolio..." + portfolioName + " Exception occured..." + e.getMessage());
			Assert.fail("Unable to delete Portfolio..." + e.getMessage());
		}
	}

	public void clickRenameButton() {
		try {
			commonFunction = new CommonFunctions(driver);
			commonFunction.waitTillVisibilityOfElementLocated(btn_rename);
			driver.findElement(btn_rename).click();
			Base.test.log(Status.INFO, "Clicked on Rename button...");
		} catch (Exception e) {
			Base.test.log(Status.FAIL, "Unable to clicked on Rename button..." + e.getMessage());
			Assert.fail("Unable to clicked on Rename button..." + e.getMessage());
		}
	}

	public void enterNewPortfolioName(String newPortfolioName) {
		try {
			driver.findElement(txt_rename).clear();
			driver.findElement(txt_rename).sendKeys(newPortfolioName);
			String screenshotPath = Base.getScreenhot(driver, new Exception().getStackTrace()[0].getMethodName());
			Base.test.log(Status.INFO, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			Base.test.log(Status.INFO, "Entered new portfolio..."+newPortfolioName);
		} catch (Exception e) {
			Base.test.log(Status.FAIL, "Unable to enter new portfolio..." + e.getMessage());
			Assert.fail("Unable to enter new portfolio..." + e.getMessage());
		}
	}

	public void clickRenamePortfolioButton() {
		try {
			commonFunction = new CommonFunctions(driver);
			commonFunction.waitTillElementClickable(btn_renamePortfolio);
			driver.findElement(btn_renamePortfolio).click();
			Base.test.log(Status.INFO, "Clicked on Rename Portfolio button...");
		} catch (Exception e) {
			Base.test.log(Status.FAIL, "Unable to clicked on Rename Portfolio button..." + e.getMessage());
			Assert.fail("Unable to clicked on Rename Portfolio button..." + e.getMessage());
		}
	}

	public void verifyRenamePortfolio(String portfolioName, String newPortfolioName) {
		try {
			Base.test.log(Status.INFO, "Verifying Rename Portfolio " + portfolioName + "...");
			commonFunction = new CommonFunctions(driver);
			//commonFunction.waitTillElementRefreshed(portfolioIds);
			Thread.sleep(5000);
			List<WebElement> listPortfolioIds = driver.findElements(portfolioIds);
			Iterator<WebElement> iterator = listPortfolioIds.iterator();
			while (iterator.hasNext()) {
				if (iterator.next().getText().equals(newPortfolioName)) {
					String screenshotPath = Base.getScreenhot(driver, new Exception().getStackTrace()[0].getMethodName());
					Base.test.log(Status.INFO, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
					Base.test.log(Status.PASS, portfolioName + " renamed successfully as "+newPortfolioName);
					break;
				}
			}
		} catch (Exception e) {
			Base.test.log(Status.FAIL, "Unable to rename Portfolio..." + e.getMessage());
			Assert.fail("Unable to rename Portfolio..." + e.getMessage());
		}
	}
}

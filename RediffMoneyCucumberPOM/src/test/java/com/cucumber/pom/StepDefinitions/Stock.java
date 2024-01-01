package com.cucumber.pom.StepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.cucumber.pom.Pages.MyPortfolioPage;
import com.cucumber.pom.Pages.StockPage;
import com.cucumber.pom.util.Base;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Stock {

	WebDriver driver;
	public Stock(Login login) {
		driver = login.driver;
	}

	@And("User scrolls down till Stock section")
	public void scrollDowntillStockSection() {
		StockPage myStockPage = new StockPage(driver);
		//System.out.println("Stock Driver: " + driver);
		myStockPage.scrollDownTillStockSectionVisible();
	}
	
//	@Then("User clicks on LogOut link")
//	public void clickLogOut() {
//		StockPage myStockPage = new StockPage(driver);
//		myStockPage.clickLogOutLink();
//	}

	@And("User clicks on Add Stock button")
	public void clickAddStock() {
		StockPage myStockPage = new StockPage(driver);
		myStockPage.clickAddStock();
	}
	
	@And("User enters Stock Name{string}")
	public void enterStockName(String stockName) {
		StockPage myStockPage = new StockPage(driver);
		myStockPage.enterStockName(stockName);
	}
	
	@And("User enters Stock Date{string}")
	public void enterStockDate(String stockDate) {
		StockPage myStockPage = new StockPage(driver);
		myStockPage.enterStockDate(stockDate);
	}
	
	@And("User enters Stock Quantity{string}")
	public void enterStockQuantity(String stockQuantity) {
		StockPage myStockPage = new StockPage(driver);
		myStockPage.enterStockQuantity(stockQuantity);
	}
	
	@And("User enters Stock Price{string}")
	public void enterStockPrice(String stockPrice) {
		StockPage myStockPage = new StockPage(driver);
		myStockPage.enterStockPrice(stockPrice);
	}
	
	@And("User selects Exchange{string}")
	public void selectExchange(String exchange) {
		StockPage myStockPage = new StockPage(driver);
		myStockPage.selectExchange(exchange);
	}
	
	@When("User clicks on Submit Add Stock button")
	public void clickSubmitAddStock() {
		StockPage myStockPage = new StockPage(driver);
		myStockPage.clickSubmitAddStock();
	}
	
	@Then("User verify adding stock is successful{string}")
	public void verifyAddStock(String stockName) {
		Base.test.log(Status.INFO, "Verifying stock addition...");
		StockPage myStockPage = new StockPage(driver);
		if(myStockPage.verifyStock(stockName)==true) {
			Base.test.log(Status.PASS, stockName+" added successfully.....");
			Assert.assertTrue(true,stockName+" added successfully.....");
		} else {
			Base.test.log(Status.FAIL, "Unable to add "+stockName);
			Assert.fail("Unable to add "+stockName);
		}
	}
	
	@And("User verifies if stock to be deleted is present in stock list{string}")
	public void verifyPresenceOfStock(String stockName) {
		Base.test.log(Status.INFO, "Verifying presence of stock...");
		StockPage myStockPage = new StockPage(driver);
		if(myStockPage.verifyPresenceOfStock(stockName)==true) {
			Base.test.log(Status.INFO, stockName+" is present in the stock list.....");
		} else {
			Base.test.log(Status.FAIL, stockName+" is not present in the stock list. So unable to delete stock...");
		    Assert.fail(stockName+" is not present in the stock list. So unable to delete stock...");
		}
	}
	
	@When("User clicks on stock to be deleted and click on Delete button{string}")
	public void deleteStock(String stockName) {
		Base.test.log(Status.INFO, "Selecting stock to be deleted "+stockName+" and clicking on Delete stock...");
		StockPage myStockPage = new StockPage(driver);
		myStockPage.selectStockandClickDelete(stockName);
		
	}
	
	@Then("User verify if stock is deleted successfully{string}") 
	public void verifyDeleteStock(String stockName) {
		Base.test.log(Status.INFO,"Verifying if stock deleted successfully..."+stockName);
		StockPage myStockPage = new StockPage(driver);
		if(myStockPage.verifyDeleteStock(stockName)==false) {
			Base.test.log(Status.PASS,stockName+" deleted successfully....");	
			Assert.assertTrue(true, stockName+" deleted successfully....");
		} else {
			Base.test.log(Status.FAIL,"Unable to delete stock "+stockName+"....");
			Assert.fail("Unable to delete stock "+stockName+"....");
		}
	}
}

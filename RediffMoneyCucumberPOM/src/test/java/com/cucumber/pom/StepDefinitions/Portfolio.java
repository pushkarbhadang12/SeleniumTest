package com.cucumber.pom.StepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.aventstack.extentreports.Status;
import com.cucumber.pom.Pages.LoginPage;
import com.cucumber.pom.Pages.MyPortfolioPage;
import com.cucumber.pom.util.Base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Portfolio {
	
    public WebDriver driver;
	
	public Portfolio(Login login) {
		driver = login.driver;
	}
		
	@Given("User logged in to Rediff Money Portal")
	public void loggedInSuccessful() {
		LoginPage loginPage = new LoginPage(driver);
		Base.test.log(Status.INFO, "Verifying if user is logged in to Rediff Money Portal...");
		
		if (loginPage.verifySignIn() == true) {
			Base.test.log(Status.PASS, "User is logged in to Rediff Money Portal...");
			Assert.assertTrue(true, "User is logged in to Rediff Money Portal...");
		} else {
			Base.test.log(Status.FAIL, "User is not logged in to Rediff Money Portal...");
			Assert.fail("User is not logged in to Rediff Money Portal...");
		}
	}
	
	@And("User clicks on Create button")
	public void clickCreate() {
		MyPortfolioPage myPortfolioPage = new MyPortfolioPage(driver);
		myPortfolioPage.clickCreateButton();
	}
	
	@And("User clicks on LogOut link")
	public void clickLogOut() {
		MyPortfolioPage myPortfolioPage = new MyPortfolioPage(driver);
		myPortfolioPage.clickLogOutLink();
	}
	
	@And("User enters Portfolio Name{string}")
	public void enterPortfolioName(String portfolioName) {
		MyPortfolioPage myPortfolioPage = new MyPortfolioPage(driver);
		myPortfolioPage.enterPortfolio(portfolioName);
	}
	
	@When("User clicks on Create Portfolio button")
	public void clickCreatePortfolio() {
		MyPortfolioPage myPortfolioPage = new MyPortfolioPage(driver);
		myPortfolioPage.clickCreatePortfolioButton();
	}
	
	@Then("User verify if Portfolio is created successfully{string}")
	public void verifyDuplicatePortfolio(String portfolioName) {
		MyPortfolioPage myPortfolioPage = new MyPortfolioPage(driver);
		myPortfolioPage.verifyPortfolio(portfolioName);
	}
	
	@And("User selects portfolio from Portfolio list{string}")
	public void selectPortfolio(String portfolioName) {
		MyPortfolioPage myPortfolioPage = new MyPortfolioPage(driver);
		myPortfolioPage.selectPortfolio(portfolioName);
	}
		
	@And("User clicks on Delete Portfolio button")
	public void clickDeletePortfolio() {
		
		MyPortfolioPage myPortfolioPage = new MyPortfolioPage(driver);
		myPortfolioPage.clickDeletePortfolioButton();
	}
	
	@When("User clicks on Ok button")
	public void clickOkDeletePortfolio() {
		
		MyPortfolioPage myPortfolioPage = new MyPortfolioPage(driver);
		myPortfolioPage.clickOkDeletePortfolioButton();
	}
	
	@Then("User verify if Portfolio is deleted successfully{string}")
	public void verifyPortfolioDeletion(String portfolioName) {
		
		MyPortfolioPage myPortfolioPage = new MyPortfolioPage(driver);
		myPortfolioPage.verifyPortfolioDeletion(portfolioName);
	}
	
	@And("User clicks on Rename button")
	public void clickRenameButton() {
		MyPortfolioPage myPortfolioPage = new MyPortfolioPage(driver);
		myPortfolioPage.clickRenameButton();
	}
	
	@When("User enters new Portfolio Name{string}")
	public void enterNewPortfolioName(String newPortfolioName) {
		MyPortfolioPage myPortfolioPage = new MyPortfolioPage(driver);
		myPortfolioPage.enterNewPortfolioName(newPortfolioName);
	}
	
	@And("User clicks on Rename Portfolio button")
	public void clickRenamePortfolioButton() {
		MyPortfolioPage myPortfolioPage = new MyPortfolioPage(driver);
		myPortfolioPage.clickRenamePortfolioButton();
	}
	
	@Then("User verify if Portfolio is renamed successfully from{string}to{string}")
	public void verifyRenamePortfolio(String portfolioName, String newPortfolioName) {
		MyPortfolioPage myPortfolioPage = new MyPortfolioPage(driver);
		myPortfolioPage.verifyRenamePortfolio(portfolioName, newPortfolioName);
	}
	
}

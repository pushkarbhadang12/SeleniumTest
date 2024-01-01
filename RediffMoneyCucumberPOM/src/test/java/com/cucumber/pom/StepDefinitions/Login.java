package com.cucumber.pom.StepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.aventstack.extentreports.Status;
import com.cucumber.pom.Pages.LoginPage;
import com.cucumber.pom.commonfunctions.CommonFunctions;
import com.cucumber.pom.util.Base;
import com.cucumber.pom.util.PropertiesOperations;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login {

	public WebDriver driver;
	Base base;
	Scenario scenario;
	CommonFunctions commonFunction;
	
	public Login(Base base) {
		this.base = base;
		driver = base.setDriver();
	}
	
	@Before
    public void before(Scenario scenario) {
        this.scenario = scenario;
    }
	
	@After
	public void after() {
		driver.close();
		//driver.quit();
		//JOptionPane.showMessageDialog(null, "Project execution completed...");
		
	}

	@Given("User opens Rediff Money portal")
	public void openRediffPortal() {
		Base.test = Base.report.createTest(scenario.getName());
		Base.test.log(Status.INFO, "Opening Rediff Money Portal...");		
		try {
			driver.get(PropertiesOperations.getPropertyValueByKey("URL"));
			Base.test.log(Status.INFO, "URL: "+PropertiesOperations.getPropertyValueByKey("URL"));
			Base.test.log(Status.INFO, "Rediff Money Portal opened successfully...");
		} catch (Exception e) {
			Base.test.log(Status.FAIL, "Unable to open Rediff Money Portal..." + e.getMessage());
			Assert.fail("Unable to open Rediff Money Portal..." + e.getMessage());
		}
	}

	@And("User enter Email Id and Password")
	public void enterCredentials() {
		Base.test.log(Status.INFO, "Entering Username and Password...");
		String emailId = PropertiesOperations.getPropertyValueByKey("username");
		String password = PropertiesOperations.getPropertyValueByKey("password");
		Base.test.log(Status.INFO, "Username: "+emailId+" Password: "+password);
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsername(emailId);
		loginPage.enterPassword(password);
	}

	@When("User clicks on Submit button")
	public void clickSubmit() {
		Base.test.log(Status.INFO, "Clicking on Submit button...");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.clickSubmitButton();
	}

	@Then("User verify if login is successful")
	public void verifyLogin() {
		Base.test.log(Status.INFO, "Verifying if login is successful...");
		LoginPage loginPage = new LoginPage(driver);
		if (loginPage.verifySignIn() == true) {
			Base.test.log(Status.PASS, "Login is successful...");
			Assert.assertTrue(true, "Login is successful...");
		} else {
			Base.test.log(Status.FAIL, "Login is failed...");
			Assert.fail("Login is failed...");
		}
		
	}

	@Then("User verify if login is failed")
	public void loggedInFail() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.verifySignInFail();
	}
}

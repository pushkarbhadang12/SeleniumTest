package com.cucumber.pom.Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/resources/Features"}, 
                 glue = {"com.cucumber.pom.StepDefinitions"}, tags = "not @exclude"
                )
public class TestRunner extends AbstractTestNGCucumberTests{

	
}

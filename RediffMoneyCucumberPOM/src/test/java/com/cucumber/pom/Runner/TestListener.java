package com.cucumber.pom.Runner;

import org.testng.ISuite;
import org.testng.ISuiteListener;

import com.cucumber.pom.util.Base;

public class TestListener extends Base implements ISuiteListener{
	
	public void onStart(ISuite suite) {
	     report = setUpExtentReport();
	  }
	
	public void onFinish(ISuite suite) {
	    report.flush();
	  }

}

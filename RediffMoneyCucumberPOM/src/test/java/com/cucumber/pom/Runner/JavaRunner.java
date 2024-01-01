package com.cucumber.pom.Runner;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.testng.TestNG;

public class JavaRunner {

	public static void main(String[] args) {
		try {
			//JOptionPane.showMessageDialog(null, "Project execution started...");
			TestNG testng = new TestNG();
			List<String> suites = new ArrayList<String>();
			suites.add(System.getProperty("user.dir") + "/testNG.xml");
			testng.setTestSuites(suites);
			testng.run();
			//JOptionPane.showMessageDialog(null, "Project execution completed...");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
}

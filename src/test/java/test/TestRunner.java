package test;

import java.io.File;
import java.io.IOException;

import org.junit.runner.RunWith;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;


@RunWith(Cucumber.class)
@CucumberOptions(features="feature_files", glue= "stepdefinition",
format=
{"pretty",
"html:target/cucumber-reports/cucumber-pretty",
"json:target/cucumber-reports/CucumberTestReport.json"})

public class TestRunner {
	
	private TestNGCucumberRunner testNGCucumberRunner;
	
	
	@BeforeSuite()
	public void openBrowser() {
		
	}
	
	@BeforeClass(alwaysRun = true)
	public void setUpClass() throws Exception {
	testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
	
	}

	@Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "features")
	public void feature(CucumberFeatureWrapper cucumberFeature) {
	testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
	}

	@DataProvider
	public Object[][] features() {
	return testNGCucumberRunner.provideFeatures();
	}

	@AfterClass(alwaysRun = true)
	public void tearDownClass() throws Exception {
		
	testNGCucumberRunner.finish();
	}
	
	
	
	@AfterMethod
	public void getScrenResult(ITestResult result) throws IOException {
		
		
	}

	

}

package com.runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith; 
import com.reports.Reporting;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features =  "src\\test\\resources\\Features", glue = "com.stepdefenition", plugin = { "pretty",
		"json:target\\BeforeRerun\\rerunOutput.json" , "rerun:target\\failed.txt"}, dryRun = false)


public class TestRunner { 
	

	@AfterClass 
	public static void report() {

		Reporting.generateReport("C:\\Users\\ADMIN\\eclipse-workspace\\OmrBranchHotelAutomation\\target\\BeforeRerun\\rerunOutput.json");
	}

} 

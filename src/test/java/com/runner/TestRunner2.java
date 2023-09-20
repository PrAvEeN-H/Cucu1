package com.runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.reports.Reporting;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "@target\\failed.txt", glue = "com.stepdefenition", plugin = { "pretty",
		"json:target\\Final\\finalOutput.json"}, dryRun = false)


public class TestRunner2 {

	@AfterClass 
	public static void report() {

		Reporting.generateReport2("C:\\Users\\ADMIN\\eclipse-workspace\\OmrBranchHotelAutomation\\target\\Final\\finalOutput.json");
	}
	
	
}

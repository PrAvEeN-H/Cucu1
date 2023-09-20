
package com.reports;

import java.io.File;
import java.util.LinkedList;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class Reporting {
public static void generateReport(String jas) {
		
		File f = new File("C:\\Users\\ADMIN\\eclipse-workspace\\OmrBranchHotelAutomation\\target\\BeforeRerun");
		
		Configuration con = new Configuration(f, "OMRBranch Hotel Automation");
		con.addClassifications("browser ", "chrome");

		LinkedList jason = new LinkedList();
		jason.add(jas);
		ReportBuilder builder = new ReportBuilder(jason, con);
		builder.generateReports();
		
	}

public static void generateReport2(String jas) {
	
	File f = new File("C:\\Users\\ADMIN\\eclipse-workspace\\OmrBranchHotelAutomation\\target\\Final");
	
	Configuration con = new Configuration(f, "OMRBranch Hotel Automation");
	con.addClassifications("browser ", "chrome");

	LinkedList jason = new LinkedList();
	jason.add(jas);
	ReportBuilder builder = new ReportBuilder(jason, con);
	builder.generateReports();
	
}
}

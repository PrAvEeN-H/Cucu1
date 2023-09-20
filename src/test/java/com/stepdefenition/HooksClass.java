
package com.stepdefenition;

import java.io.IOException;

import com.base.BaseClass;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class HooksClass extends BaseClass {

	
	@Before
	public void beforeScenario() {
		browserSteup();
		
	}
	
	@After
	public void afterScenario(Scenario sc) throws IOException, InterruptedException {
		
		Boolean b = sc.isFailed();
		if(b) {
		sc.attach(takeScreenShot(), "images/png", sc.getName());
		}
		
		//CloseWindow();
	}
	
	
	
	
	
}


package com.stepdefenition;

import org.junit.Assert;

import com.base.BaseClass;
import com.pagemanager.PageObjectManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class CommonSteps extends BaseClass {

	PageObjectManager pom = new PageObjectManager();

	
	@Given("User is on OMRBranch hotel page")
	public void user_is_on_omr_branch_hotel_page() {

		launchUrl("https://omrbranch.com/");

	}
	
	@Then("User should verify success message after login {string}")
	public void user_should_verify_success_message_after_login(String actualSuccessMsg) {
		Assert.assertEquals(actualSuccessMsg, pom.getExplore().getTxtSucessMsg().getText());

	}
	
	
	
	
}

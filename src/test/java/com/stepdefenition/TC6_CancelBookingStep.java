package com.stepdefenition;

import org.junit.Assert;

import com.pagemanager.PageObjectManager;

import io.cucumber.java.en.*;

public class TC6_CancelBookingStep {
PageObjectManager pom = new PageObjectManager();
	
	@When("User cancel the booking")
	public void user_cancel_the_booking() {
		
	pom.getMybook().cancellBooking();	
	}

	@Then("User should verify after cancel success message {string}")
	public void user_should_verify_after_cancel_success_message(String string) throws InterruptedException {
		Assert.assertEquals(string,pom.getMybook().expectedCancellSuccessMsg());
	}

	@When("user cancel the first available booking")
	public void user_cancel_the_first_available_booking() {
		pom.getMybook().cancellBooking();	

	}

}

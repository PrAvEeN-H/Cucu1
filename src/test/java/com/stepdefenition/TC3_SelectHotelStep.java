package com.stepdefenition;

import org.junit.Assert;

import com.pagemanager.PageObjectManager;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC3_SelectHotelStep {

	PageObjectManager pom = new PageObjectManager();

	
	@When("User select first hotel and save the hotel name and price")
	public void user_select_first_hotel_and_save_the_hotel_name_and_price() {
		
		pom.getSelect().selectFirstHotel();
	}

	@When("user accept the alert message")
	public void user_accept_the_alert_message() {
		pom.getSelect().acceptAlert();
	}

	@Then("User should verify after accepting the alert success message {string}")
	public void user_should_verify_after_accepting_the_alert_success_message(String string) {
		Assert.assertEquals("verify book hotel success msg", pom.getBook().getSuccessMsgBookHotel(), string);
	}

	@When("user dismiss the alert message")
	public void user_dismiss_the_alert_message() {
		pom.getSelect().dismissAlert();
	}

	@When("User select Price low to high button in sort by option")
	public void user_select_price_low_to_high_button_in_sort_by_option() {

		pom.getSelect().clickPriceLowToHigh();
	}

	@Then("User should verify all hotels prices are from low to high")
	public void user_should_verify_all_hotels_prices_are_from_low_to_high() throws InterruptedException {
	
		Assert.assertTrue(pom.getSelect().sortPriceLowToHigh());
	}

	@When("User select Price high to low button in sort by option")
	public void user_select_price_high_to_low_button_in_sort_by_option() {
		pom.getSelect().clickPriceHighToLow();
	}

	@Then("User should verify all hotels prices are from high to low")
	public void user_should_verify_all_hotels_prices_are_from_high_to_low() throws InterruptedException {
	
	Assert.assertTrue(pom.getSelect().sortPriceHighToLow());
	}

	@Then("User should verify all hotles name ends with given {string} filter")
	public void user_should_verify_all_hotles_name_ends_with_given_filter(String string) {
	
		Assert.assertTrue(pom.getSelect().sameRoomTypeFilterNameCheck());
	}

}

package com.stepdefenition;

import java.awt.AWTException;

import org.junit.Assert;

import com.pagemanager.PageObjectManager;
import com.pages.BookingConformPage;
import com.pages.SelectHotelPage;

import io.cucumber.java.en.*;

public class TC5_ChangeBookingStep {

	PageObjectManager pom = new PageObjectManager();

	@When("User navigates to my booking page")
	public void user_navigates_to_my_booking_page() {
		pom.getConform().navigateToMyBookingFromConformPage();
	}

	@When("User navigates to my booking page after login")
	public void user_navigates_to_my_booking_page_after_login() throws InterruptedException {
		pom.getConform().navigateToMyBookingFromExplore();
	}

	@Then("User should verify after navigating success message {string}")
	public void user_should_verify_after_navigating_success_message(String string) {
		Assert.assertEquals(string, pom.getConform().expectedSuccessMsgBookings());
	}

	@When("User enter the generated order id")
	public void user_enter_the_generated_order_id() throws AWTException, InterruptedException {

		pom.getConform().enterGeneratedOrderId();
	}

	@Then("User should verify same order id is displayed")
	public void user_should_verify_same_order_id_is_displayed() throws InterruptedException {
		Assert.assertEquals(BookingConformPage.orderId, pom.getConform().expectedOrderIdAfterSearch());
	}

	@Then("User should verify same hotel name is displayed")
	public void user_should_verify_same_hotel_name_is_displayed() throws InterruptedException {
		Assert.assertEquals(SelectHotelPage.selectedHotelName, pom.getConform().expectedHotelNameAfterSearch());

	}

	@Then("User should verify same prize is displayed")
	public void user_should_verify_same_prize_is_displayed() throws InterruptedException {
		Assert.assertEquals(SelectHotelPage.hotelPrice.replace("$", "").trim(), pom.getConform().expectedPriceAfterSearch().replace("Rs", "").trim());

	}

	@When("User edit the paticular booking details {string}")
	public void user_edit_the_paticular_booking_details(String string) throws InterruptedException {
		pom.getConform().editDate(string);

	}

	@When("User enter the existing order id {string}")
	public void user_enter_the_existing_order_id(String string) {
		pom.getConform().searchOrderId(string);
	}

	@Then("User should verify same existing order id is displayed {string}")
	public void user_should_verify_same_existing_order_id_is_displayed(String string) throws InterruptedException {
		Assert.assertEquals(string, pom.getConform().expectedExistingOrderIdAfterSearch());

	}

	@When("User edit the first available booking {string}")
	public void user_edit_the_first_available_booking(String string) throws InterruptedException {

		pom.getConform().editDate(string);
	}

	@Then("user should verify after edit success message {string}")
	public void user_should_verify_after_edit_success_message(String string) throws InterruptedException {
		pom.getConform().expectedUpdateSuccessMsg();
	}

}

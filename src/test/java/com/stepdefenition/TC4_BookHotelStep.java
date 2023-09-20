package com.stepdefenition;

import org.junit.Assert;

import com.pagemanager.PageObjectManager;
import com.pages.SelectHotelPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC4_BookHotelStep {

	PageObjectManager pom = new PageObjectManager();

	@When("User accept the alert message")
	public void user_accept_the_alert_message() {
		pom.getSelect().acceptAlert();
	}

	@When("User add all guest details {string},{string},{string},{string} and {string}")
	public void user_add_all_guest_details_and(String string, String string2, String string3, String string4,
			String string5) throws InterruptedException {
		pom.getBook().addAllGuestDetails(string, string2, string3, string4, string5);

	}

	@When("user proceed payment {string}")
	public void user_proceed_payment(String string, io.cucumber.datatable.DataTable dataTable) {
		pom.getBook().makePayment(string, dataTable);
	}

	@Then("User should verify success message after booking with card details {string} and saves the order id")
	public void user_should_verify_success_message_after_booking_with_card_details_and_saves_the_order_id(
			String string) {
		Assert.assertEquals(string, pom.getConform().txtExpectedSuccessMsgBookingIsConformed());

	}

	@Then("User should verify same selected hotel is booked")
	public void user_should_verify_same_selected_hotel_is_booked() {
		Assert.assertEquals(SelectHotelPage.selectedHotelName.replace("Studio", "").replace("Deluxe", "").replace("Suite", "").replace("Luxury", "").replace("Standard", "").trim(), pom.getConform().bookedHotelName());
	}

	@When("User book hotel without entering any feilds")
	public void user_book_hotel_without_entering_any_feilds() {

		pom.getBook().bookWithoutAnyField();
	}

	@Then("User should verify error message after booking {string},{string},{string},{string},{string} and {string}")
	public void user_should_verify_error_message_after_booking_and(String string, String string2, String string3,
			String string4, String string5, String string6) {

		Assert.assertEquals(string, pom.getBook().getGetTxtErrorMyself().getText());
		Assert.assertEquals(string2, pom.getBook().getGetTxtErrorSalutation().getText());
		Assert.assertEquals(string3, pom.getBook().getGetTxtErrorFirstName().getText());
		Assert.assertEquals(string4, pom.getBook().getGetTxtErrorLastName().getText());
		Assert.assertEquals(string5, pom.getBook().getGetTxtErrorMob().getText());
		Assert.assertEquals(string6, pom.getBook().getGetTxtErrorEmail().getText());



	}

	@When("User giving  special request {string}")
	public void user_giving_special_request(String string) throws InterruptedException {
		pom.getBook().givingSpecialRequest(string);

	}
	@When("User giving  special request without gst {string}")
	public void user_giving_special_request_without_gst(String string) throws InterruptedException {
		pom.getBook().givingSpecialRequestWithoutgst(string);

	}




	@When("User add gst details {string},{string} and {string}")
	public void user_add_gst_details_and(String string, String string2, String string3) {
		pom.getBook().addGstDetails(string, string2, string3);
	}

	@When("user give without special request")
	public void user_give_without_special_request() {
		pom.getBook().withoutSpecialRequest();
	}
	@When("User add without special request with gst")
	public void user_add_without_special_request_with_gst() {
	pom.getBook().withoutSpecialRequestWithgst();
	
	}

}

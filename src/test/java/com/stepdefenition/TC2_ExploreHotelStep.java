package com.stepdefenition;

import java.awt.AWTException;
import org.junit.Assert;
import com.base.BaseClass;
import com.pagemanager.PageObjectManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC2_ExploreHotelStep extends BaseClass {



	PageObjectManager pom = new PageObjectManager();

	@When("User search hotels {string},{string},{string},{string},{string},{string},{string} and {string}")
	public void user_search_hotels_and(String stateName, String cityName, String roomType, String checkInDate,
			String checkOutDate, String noOfRoom, String noOfAdult, String noOfChild) throws AWTException, InterruptedException
			 {
		
		pom.getExplore().exploreHotel(stateName, cityName, roomType, checkInDate, checkOutDate, noOfRoom, noOfAdult, noOfChild);
	
	}
	

	@Then("User should verify after search hotel success message {string}")
	public void user_should_verify_after_search_hotel_success_message(String actualSuccessMsg) {

		Assert.assertEquals(actualSuccessMsg, pom.getSelect().successMsgSelectHotel());
	}

	@When("User search hotels {string},{string},{string},{string},{string} and {string}")
	public void user_search_hotels_and(String stateName, String cityName, String checkInDate, String checkOutDate,
			String noOfRoom, String noOfAdult) throws AWTException, InterruptedException {
		pom.getExplore().exploreHotel(stateName, cityName, checkInDate, checkOutDate, noOfRoom, noOfAdult);
		

	}

	@When("User search hotel without entering any feild")
	public void user_search_hotel_without_entering_any_feild() throws InterruptedException {
		
	pom.getExplore().exploreHotel();
	}

	@Then("User should verify after search hotel error message {string},{string},{string},{string},{string}, and {string}")
	public void user_should_verify_after_search_hotel_error_message_and(String errorState, String error2, String error3,
			String error4, String error5, String error6) {
		Assert.assertEquals(pom.getExplore().expectedErrorMsgState(), errorState);
		Assert.assertEquals(pom.getExplore().expectedErrorMsgCity(), error2);
		Assert.assertEquals(pom.getExplore().expectedErrorMsgChkInDate(), error3);
		Assert.assertEquals(pom.getExplore().expectedErrorMsgChkOutDate(), error4);
		Assert.assertEquals(pom.getExplore().expectedErrorMsgNoOfRoom(), error5);
		Assert.assertEquals(pom.getExplore().expectedErrorMsgNoOfAdult(), error6);

		
		
	}

	@Then("User should verify same selected {string} filter is present")
	public void user_should_verify_same_selected_filter_is_present(String string) {

		Assert.assertTrue(pom.getSelect().sameRoomTypeFilterNameCheck());
		
	}

}

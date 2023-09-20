
package com.stepdefenition;

import java.awt.AWTException;

import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.base.BaseClass;
import com.pagemanager.PageObjectManager;
import com.pages.ExploreHotelPage;
import com.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC1_LoginStep extends BaseClass {

	PageObjectManager pom = new PageObjectManager();

	

	@When("User enter {string} and {string}")
	public void user_enter_and(String userName, String password) throws InterruptedException {

		pom.getLogin().login(userName, password);
	}

	

	@When("User enter {string} and {string} using Enter key")
	public void user_enter_and_using_enter_key(String email, String password)
			throws AWTException, InterruptedException {
		pom.getLogin().loginWithEnterKey(email, password);
	}

	@Then("User should verify error message after login {string}")
	public void user_should_verify_error_message_after_login(String actualErrorMsg) {
		Assert.assertTrue((pom.getLogin().getErrorMsg().getText().contains(actualErrorMsg)));
	}

}

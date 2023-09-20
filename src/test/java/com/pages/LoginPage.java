package com.pages;

import java.awt.AWTException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;


/**
 * @author Akash
 * @see Purpose of this class is used to capture locators of Login page and following POM designpatter
 * @since 13-05-2023 
 */
public class LoginPage extends BaseClass {

	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "email")
	private WebElement txtEmail;

	@FindBy(id = "pass")
	private WebElement txtPassword;

	@FindBy(xpath = "//*[@id=\"userLogin\"]/div[5]/button")
	private WebElement btnLogin;

	@FindBy(xpath = "//b[@style=\"color: #dc3545;\"]")
	private WebElement errorMsg;

	@FindBy(xpath = "//*[@id=\"wrapper\"]/header/div/div/div/div[2]/div/ul/li[2]/a")
	private WebElement txtSucessMsg;

	public WebElement getTxtSucessMsg() {
		return txtSucessMsg;
	}

	public WebElement getTxtEmail() {
		return txtEmail;
	}

	public WebElement getTxtPassword() {
		return txtPassword;
	}

	public WebElement getBtnLogin() {
		return btnLogin;
	}

	public WebElement getErrorMsg() {
		
		return errorMsg;
	}

	/**
	 * @author Akash
	 * @see This method is used to perform login functionality
	 * @param First Param - email (String) and Second param - Pass (String)
	 * @throws InterruptedException - 
	 * @since 13-05-2023
	 * 
	 */
	public void login(String email, String pass) throws InterruptedException {
		passTxt(getTxtEmail(), email);
		passTxt(getTxtPassword(), pass);
		getBtnLogin().click();
		Thread.sleep(2000);
	}

	/**
	 * @author Akash
	 * @return which will return error message as string
	 */
	public String expectedErrorMsgLogin() {
		String s = getErrorMsg().getText();
		return s;
	}

	
	/**
	 * @author Akash
	 * @see - this method is used to perform login with Enter Key
	 * @since 
	 * @param email
	 * @param pass
	 * @throws AWTException
	 * @throws InterruptedException
	 */
	public void loginWithEnterKey(String email, String pass) throws AWTException, InterruptedException {
		passTxt(getTxtEmail(), email);
		passTxt(getTxtPassword(), pass);
		enterKey();
		Thread.sleep(2000);
	}

	
}

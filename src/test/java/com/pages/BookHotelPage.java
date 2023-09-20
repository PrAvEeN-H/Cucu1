package com.pages;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

import io.cucumber.datatable.DataTable;

/**
 * @author Akash
 * @see Purpose of this class is used to capture locators of Book Hotel Page and following POM designpatter
 * @since 13-05-2023 
 */
public class BookHotelPage extends BaseClass {


	public BookHotelPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id=\"own\"]")
	private WebElement rdoBtnMyself;

	@FindBy(xpath = "//select[@class=\"form-control\"]")
	private WebElement ddnSalutation;

	@FindBy(xpath = "//*[@id=\"first_name\"]")
	private WebElement txtFirstName;

	@FindBy(xpath = "//*[@id=\"last_name\"]")
	private WebElement txtLastName;

	@FindBy(xpath = "//*[@id=\"user_phone\"]")
	private WebElement txtMobileNo;

	@FindBy(xpath = "//*[@id=\"user_email\"]")
	private WebElement txtEmail;

	@FindBy(xpath = "//input[@placeholder=\"Enter Registration No. *\"]")
	private WebElement txtRegNum;

	@FindBy(xpath = "//input[@id=\"gst\"]")
	private WebElement chkGst;

	@FindBy(xpath = "//input[@placeholder=\"Enter Company Name *\"]")
	private WebElement txtCompanyName;

	@FindBy(xpath = "//input[@placeholder=\"Enter Company Address *\"]")
	private WebElement txtCompanyAddress;

	@FindBy(xpath = "//*[@id=\"step1next\"]")
	private WebElement btnNextSplReq;

	@FindBy(xpath = "(//div[@class='invalid-feedback animated fadeInDown'])[1]")
	private WebElement getTxtErrorMyself;

	@FindBy(xpath = "(//div[@class='invalid-feedback animated fadeInDown'])[2]")
	private WebElement getTxtErrorSalutation;
	@FindBy(xpath = "(//div[@class='invalid-feedback animated fadeInDown'])[3]")
	private WebElement getTxtErrorFirstName;
	@FindBy(xpath = "(//div[@class='invalid-feedback animated fadeInDown'])[4]")
	private WebElement getTxtErrorLastName;
	@FindBy(xpath = "(//div[@class='invalid-feedback animated fadeInDown'])[5]")
	private WebElement getTxtErrorMob;
	@FindBy(xpath = "(//div[@class='invalid-feedback animated fadeInDown'])[6]")
	private WebElement getTxtErrorEmail;
	
	@FindBy(xpath = "//*[@id=\"page-wrapper\"]/section[1]/div/div/div/div/div/h2")
	private WebElement txtSuccessMsgBookHotel;

	@FindBy(xpath = "//*[@id=\"smoking\"]")
	private WebElement btnRequest;

	@FindBy(xpath = "//*[@id=\"other_request\"]")
	private WebElement txtSpecialRequest;

	@FindBy(xpath = "//*[@id=\"step2next\"]")
	private WebElement btnNextPayment;

	@FindBy(xpath = "//div[@class=\"credit-card pm\"]")
	private WebElement btnPaymentOption;

	@FindBy(xpath = "//*[@id=\"payment_type\"]")
	private WebElement ddnPaymentType;

	@FindBy(xpath = "//*[@id=\"card_type\"]")
	private WebElement ddnCardTtye;

	@FindBy(xpath = "//*[@id=\"card_no\"]")
	private WebElement txtCardNumber;

	@FindBy(xpath = "//*[@id=\"card_name\"]")
	private WebElement txtCardName;

	@FindBy(xpath = "//*[@id=\"card_month\"]")
	private WebElement ddnExpiryMonth;

	@FindBy(xpath = "//*[@id=\"card_year\"]")
	private WebElement ddnEpiryYear;
	@FindBy(xpath = "//*[@id=\"cvv\"]")
	private WebElement txtCvv;

	@FindBy(xpath = "//*[@id=\"submitBtn\"]")
	private WebElement btnSubmit;

	
	
	
	public WebElement getGetTxtErrorMyself() {
		return getTxtErrorMyself;
	}

	public WebElement getGetTxtErrorSalutation() {
		return getTxtErrorSalutation;
	}

	public WebElement getGetTxtErrorFirstName() {
		return getTxtErrorFirstName;
	}

	public WebElement getGetTxtErrorLastName() {
		return getTxtErrorLastName;
	}

	public WebElement getGetTxtErrorMob() {
		return getTxtErrorMob;
	}

	public WebElement getGetTxtErrorEmail() {
		return getTxtErrorEmail;
	}

	public WebElement getTxtSuccessMsgBookHotel() {
		return txtSuccessMsgBookHotel;
	}

	public WebElement getRdoBtnMyself() {
		return rdoBtnMyself;
	}

	public WebElement getDdnSalutation() {
		return ddnSalutation;
	}

	public WebElement getTxtFirstName() {
		return txtFirstName;
	}

	public WebElement getTxtLastName() {
		return txtLastName;
	}

	public WebElement getTxtMobileNo() {
		return txtMobileNo;
	}

	public WebElement getTxtEmail() {
		return txtEmail;
	}

	public WebElement getTxtRegNum() {
		return txtRegNum;
	}

	public WebElement getChkGst() {
		return chkGst;
	}

	public WebElement getTxtCompanyName() {
		return txtCompanyName;
	}

	public WebElement getTxtCompanyAddress() {
		return txtCompanyAddress;
	}




	public WebElement getDdnEpiryYear() {
		return ddnEpiryYear;
	}

	public WebElement getBtnNextSplReq() {
		return btnNextSplReq;
	}

	public WebElement getBtnRequest() {
		return btnRequest;
	}

	public WebElement getTxtSpecialRequest() {
		return txtSpecialRequest;
	}

	public WebElement getBtnNextPayment() {
		return btnNextPayment;
	}

	public WebElement getBtnPaymentOption() {
		return btnPaymentOption;
	}

	public WebElement getDdnPaymentType() {
		return ddnPaymentType;
	}

	public WebElement getDdnCardTtye() {
		return ddnCardTtye;
	}

	public WebElement getTxtCardNumber() {
		return txtCardNumber;
	}

	public WebElement getTxtCardName() {
		return txtCardName;
	}

	public WebElement getDdnExpiryMonth() {
		return ddnExpiryMonth;
	}

	public WebElement getTxtCvv() {
		return txtCvv;
	}

	public WebElement getBtnSubmit() {
		return btnSubmit;
	}


	/**
	 * @author Akash
	 * @see - this method is used to return success message
	 * @return - success message as string
	 * @since - 13-05-2023
	 */
	public String getSuccessMsgBookHotel() {

		String bookhotel = getTxtSuccessMsgBookHotel().getText();
		return bookhotel.substring(0, 10);
	}

	/**
	 * @author Akash
	 * @throws InterruptedException 
	 * @see - this method is used to add all guest details
	 * @since - 13-05-2023
	 */
	public void addAllGuestDetails(String Salutation, String firstName, String lastName, String mobileNumber,
			String email) throws InterruptedException {

		Thread.sleep(1000);
		getRdoBtnMyself().click();
		Thread.sleep(1000);
		ddnSelectByTxt(getDdnSalutation(), Salutation);
		passTxt(getTxtFirstName(), firstName);
		passTxt(getTxtLastName(), lastName);
		passTxt(getTxtMobileNo(), mobileNumber);
		passTxt(getTxtEmail(), email);
		
	}
	/**
	 * @author Akash
	 * @see - this method is used to add all gst details
	 * @since - 13-05-2023
	 */
	public void addGstDetails(String getRegNumber, String getRegName, String getRegAddress) {

		getChkGst().click();
		passTxt(getTxtRegNum(), getRegNumber);
		passTxt(getTxtCompanyName(), getRegName);
		passTxt(getTxtCompanyAddress(), getRegAddress);
		getBtnNextSplReq().click();
	}
	
	

	
	/**
	 * @author Akash
	 * @see - this method is used to give special request
	 * @return - success message as string
	 * @throws InterruptedException 
	 * @since - 13-05-2023
	 */
	public void givingSpecialRequest(String message) throws InterruptedException {
		Thread.sleep(2000);
		getBtnRequest().click();
		passTxt(getTxtSpecialRequest(), message);
		getBtnNextPayment().click();

	}
	
	public void givingSpecialRequestWithoutgst(String message) throws InterruptedException {
		
		Thread.sleep(2000);
		getBtnNextSplReq().click();
		passTxt(getTxtSpecialRequest(), message);
		getBtnNextPayment().click();

	}

	/**
	 * @author Akash
	 * @see - this method is used to make payment
	 * @since - 13-05-2023
	 */
	public void makePayment(String cardType, DataTable cardTable) {
		
	
		getBtnPaymentOption().click();
		
		
		switch (cardType) {

		case "Debit Card":

			ddnSelectByTxt(getDdnPaymentType(), cardType);
			List<Map<String, String>> cardDetails = cardTable.asMaps();
						
			Map<String, String> s = cardDetails.get(0);
			ddnSelectByTxt(getDdnPaymentType(), cardType);
			ddnSelectByTxt(getDdnCardTtye(), s.get("SelecrtCard").substring(6));
			passTxt(getTxtCardNumber(), s.get("CardNumber"));
			passTxt(getTxtCardName(), s.get("NameOnCard"));
			ddnSelectByTxt(getDdnExpiryMonth(), s.get("SelectMonth"));
			ddnSelectByTxt(getDdnEpiryYear(), s.get("SelectYear"));
			passTxt(getTxtCvv(), s.get("Cvv"));
			getBtnSubmit().click();
			break;

		case "Credit Card":

			ddnSelectByTxt(getDdnPaymentType(), cardType);
			List<Map<String, String>> cardDetails1 = cardTable.asMaps();

			Map<String, String> s1 = cardDetails1.get(4);
			ddnSelectByTxt(getDdnPaymentType(), cardType);
			ddnSelectByTxt(getDdnCardTtye(), s1.get("SelecrtCard").substring(6));
			passTxt(getTxtCardNumber(), s1.get("CardNumber"));
			passTxt(getTxtCardName(), s1.get("NameOnCard"));
			ddnSelectByTxt(getDdnExpiryMonth(), s1.get("SelectMonth"));
			ddnSelectByTxt(getDdnEpiryYear(), s1.get("SelectYear"));
			passTxt(getTxtCvv(), s1.get("Cvv"));
			getBtnSubmit().click();
			break;

		}
	}
	
	public void bookWithoutAnyField() {
		
		getBtnNextSplReq().click();

		
		
	}
	public void withoutSpecialRequest() {
		
		getBtnNextSplReq().click();
		getBtnNextPayment().click();


		
	}
	
	
public void withoutSpecialRequestWithgst() {
		
		getBtnNextPayment().click();
	}
	
	
	
	
	
	
	
	
	

}

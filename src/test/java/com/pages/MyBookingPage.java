package com.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

/**
 * @author Akash
 * @see Purpose of this class is used to capture locators of My Booking  Page and following POM designpatter
 * @since 13-05-2023 
 */ public class MyBookingPage extends BaseClass {


	public MyBookingPage() {

		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//input[@name=\"search\"]")
	private WebElement txtSearchBox;

	@FindBy(xpath="//div[@class=\"row listingProdGrid hotel-filter-details\"]//h5")
	private List<WebElement> txtexpectedHotelName;

	@FindBy(xpath = "//div[@class=\"fliter_box_inner mb-4\"]//div[@class=\"room-code\"]")
	private List<WebElement> txtExpectedSuccesMsgOrderId;

	@FindBy(xpath = "//strong[@class=\"total-prize\"]")
	private List<WebElement> txtExpextedPrice;

	@FindBy(xpath = "//button[@class=\"edit btn filter_btn\"]")
	private List<WebElement> btnEdit;

	@FindBy(xpath = "//a[@class=\"cancle btn filter_btn\"]")
	private List<WebElement> btnCancell;

	@FindBy(xpath = "class=\"form-control from hasDatepicker valid\"")
	private WebElement updateChkInDateBox;

	@FindBy(xpath = "//a[@class=\"ui-state-default\"]")
	private List<WebElement> updateChkInDateTable;

	@FindBy(xpath = "//button[@class=\"edit btn filter_btn\"]")
	private WebElement btnConform;
	
	@FindBy(xpath="//li[@class=\"alertMsg\"]")
	private WebElement txtUpdatedSuccessMsg;
	
	@FindBy(xpath="//*[@id=\"page-wrapper\"]/section/div/div/div[2]/div[1]/ul/li")
	private WebElement txtcancellSuccessMsg;
	
	@FindBy(xpath="//a[@data-testid=\"username\"]")
	private WebElement ddnMyAccount;
	
	@FindBy(xpath="//a[@class=\"dropdown-item padding_manage acc_anchor border-bottom pro_rel\"]")
	private WebElement btnMyAcct;
	
	
	
	
	
	public List<WebElement> getTxtexpectedHotelName() {
		return txtexpectedHotelName;
	}

	public WebElement getTxtUpdatedSuccessMsg() {
		return txtUpdatedSuccessMsg;
	}


	public WebElement getTxtcancellSuccessMsg() {
		return txtcancellSuccessMsg;
	}


	public WebElement getTxtSearchBox() {
		return txtSearchBox;
	}


	

	public List<WebElement> getTxtExpectedSuccesMsgOrderId() {
		return txtExpectedSuccesMsgOrderId;
	}


	public List<WebElement> getTxtExpextedPrice() {
		return txtExpextedPrice;
	}


	public List<WebElement> getBtnEdit() {
		return btnEdit;
	}


	public List<WebElement> getBtnCancell() {
		return btnCancell;
	}


	public WebElement getUpdateChkInDateBox() {
		return updateChkInDateBox;
	}


	public List<WebElement>  getUpdateChkInDateTable() {
		return updateChkInDateTable;
	}


	public WebElement getBtnConform() {
		return btnConform;
	}

	public WebElement getDdnMyAccount() {
		return ddnMyAccount;
	}


	public WebElement getBtnMyAcct() {
		return btnMyAcct;
	}
	


	/**
	 * @author Akash
	 * @see - this method is used to return price after searching with order id
	 * @return - success message as string
	 * @since - 13-05-2023
	 */
	
	public String expectedPriceAfterSearch() {
		
		return getTxtExpextedPrice().get(0).getText();
		
	}
	
	/**
	 * @author Akash
	 * @see - this method is used to cancell booking
	 * @since - 13-05-2023
	 */
	public void cancellBooking() {
		
		getBtnCancell().get(0).click();
		acceptAlert();
		
	}
	
	/**
	 * @author Akash
	 * @see - this method is used to return cancell success message 
	 * @return - Cancell success message as string
	 * @throws InterruptedException 
	 * @since - 13-05-2023
	 */
	public String expectedCancellSuccessMsg() throws InterruptedException {
		Thread.sleep(2000);
		return getTxtcancellSuccessMsg().getText();
	}
	
	
	/**
	 * @author Akash
	 * @see - this method is used to navigate from explore page to booking page
	 * @return - Cancell success message as string
	 * @since - 13-05-2023
	 */
	public void navigateToMyBookingFromExplore() {
		
		getDdnMyAccount().click();
		getBtnMyAcct().click();
		
	}


	

}

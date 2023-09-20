package com.pages;

import java.awt.AWTException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

/**
 * @author Akash
 * @see Purpose of this class is used to capture locators of Booking Conform
 *      Page page and following POM designpatter
 * @since 13-05-2023
 */
public class BookingConformPage extends BaseClass {

	public static String orderId;

	public BookingConformPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//strong)[1]")
	private WebElement txtId;
	@FindBy(xpath = "(//strong)[2]")
	private WebElement txtSelectedHotelName;
	@FindBy(xpath = "//h2[@class=\"couppon-code\"]")
	private WebElement txtBookingConfonformMsg;
	@FindBy(xpath = "//button[text()='My Booking']")
	private WebElement btnMyBooking;

	@FindBy(xpath = "//a[@class=\"ui-state-default\"]")
	private List<WebElement> updateChkInDateTable;
	@FindBy(xpath = "//*[@class=\"form-control to hasDatepicker\"]")
	private WebElement updateChkInDateBox;

	@FindBy(xpath = "//input[@name=\"search\"]")
	private WebElement txtSearchBox;

	@FindBy(xpath = "//div[@class=\"row listingProdGrid hotel-filter-details\"]//h4")
	private WebElement txtSuccessMsgBookings;

	@FindBy(xpath = "//div[@class=\"row listingProdGrid hotel-filter-details\"]//h5")
	private List<WebElement> txtexpectedHotelName;

	@FindBy(xpath = "//div[@class=\"fliter_box_inner mb-4\"]//div[@class=\"room-code\"]")
	private List<WebElement> txtExpectedSuccesMsgOrderId;

	@FindBy(xpath = "//strong[@class=\"total-prize\"]")
	private List<WebElement> txtExpextedPrice;

	@FindBy(xpath = "//button[@class=\"edit btn filter_btn\"]")
	private List<WebElement> btnEdit;

	@FindBy(xpath = "//button[@class=\"edit btn filter_btn\"]")
	private WebElement btnConform;

	@FindBy(xpath = "//li[@class=\"alertMsg\"]")
	private WebElement txtUpdatedSuccessMsg;

	public List<WebElement> getTxtexpectedHotelName() {
		return txtexpectedHotelName;
	}

	public WebElement getTxtSearchBox() {
		return txtSearchBox;
	}

	public WebElement getTxtSuccessMsgBookings() {
		return txtSuccessMsgBookings;
	}

	public List<WebElement> getTxtExpectedSuccesMsgOrderId() {
		return txtExpectedSuccesMsgOrderId;
	}

	public List<WebElement> getTxtExpextedPrice() {
		return txtExpextedPrice;
	}

	public WebElement getTxtUpdatedSuccessMsg() {
		return txtUpdatedSuccessMsg;
	}

	public WebElement getBtnConform() {
		return btnConform;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public List<WebElement> getBtnEdit() {
		return btnEdit;
	}

	public WebElement getUpdateChkInDateBox() {
		return updateChkInDateBox;
	}

	public List<WebElement> getUpdateChkInDateTable() {
		return updateChkInDateTable;
	}

	public WebElement getTxtId() {
		return txtId;
	}

	public WebElement getTxtSelectedHotelName() {
		return txtSelectedHotelName;
	}

	public WebElement getTxtBookingConfonformMsg() {
		return txtBookingConfonformMsg;
	}

	public WebElement getBtnMyBooking() {
		return btnMyBooking;
	}

	@FindBy(xpath = "//a[@data-testid=\"username\"]")
	private WebElement ddnMyAccount;

	@FindBy(xpath = "//*[@id=\"wrapper\"]/header/div/div/div/div[2]/div/ul/li[3]/div/a[1]")
	private WebElement btnMyAcct;

	public String txtExpectedSuccessMsgBookingIsConformed() {

		saveOrderId();
		return getTxtBookingConfonformMsg().getText().substring(12);
	}

	public void saveOrderId() {
		orderId = getTxtId().getText();
	}

	public String bookedHotelName() {

		return getTxtSelectedHotelName().getText();
	}

	public String expectedSuccessMsgBookings() {
		return getTxtSuccessMsgBookings().getText().substring(0, 8);
	}

	public String expectedOrderIdAfterSearch() throws InterruptedException {
Thread.sleep(3000);

		return getTxtExpectedSuccesMsgOrderId().get(0).getText();

	}

	public String expectedExistingOrderIdAfterSearch() throws InterruptedException {
		Thread.sleep(2000);
		return getTxtExpectedSuccesMsgOrderId().get(0).getText().substring(1);

	}

	public String expectedHotelNameAfterSearch() throws InterruptedException {
		Thread.sleep(2000);

		return getTxtexpectedHotelName().get(0).getText();

	}

	public String expectedPriceAfterSearch() throws InterruptedException {
		Thread.sleep(2000);

		return getTxtExpextedPrice().get(0).getText();

	}

	public WebElement getDdnMyAccount() {
		return ddnMyAccount;
	}

	public WebElement getBtnMyAcct() {
		return btnMyAcct;
	}

	/**
	 * @author Akash
	 * @see - this method is used to navigate from conform page to my booking page
	 * @since - 13-05-2023
	 */
	public void navigateToMyBookingFromConformPage() {
		getBtnMyBooking().click();
	}

	@FindBy(xpath = "//*[@id=\"page-wrapper\"]/section/div/div[2]/div[2]/div")
	private WebElement hotelbooking;

	public WebElement getHotelbooking() {
		return hotelbooking;
	}

	public void navigateToMyBookingFromExplore() throws InterruptedException {
		getHotelbooking().click();
		Thread.sleep(3000);
		getDdnMyAccount().click();
		getBtnMyAcct().click();

	}

	/**
	 * @author Akash
	 * @see - this method is used to search order id
	 * @since - 13-05-2023
	 */
	public void searchOrderId(String orderId) {

		passTxt(getTxtSearchBox(), orderId);
	}

	/**
	 * @author Akash
	 * @throws AWTException
	 * @throws InterruptedException 
	 * @see - this method is used to search generated order id
	 * @since - 13-05-2023
	 */
	public void enterGeneratedOrderId() throws AWTException, InterruptedException {

		passTxt(getTxtSearchBox(), BookingConformPage.orderId.replace("#", ""));
		enterKey();
		Thread.sleep(2000);
	}

	/**
	 * @author Akash
	 * @throws InterruptedException
	 * @see - this method is used to update or edit date function
	 * @since - 13-05-2023
	 */
	public void editDate(String dateChange) throws InterruptedException {
	Thread.sleep(2000);
		getBtnEdit().get(0).click();
		Thread.sleep(2000);
		getUpdateChkInDateBox().click();
		selectdate(dateChange);
		getBtnConform().click();
	}

	/**
	 * @author Akash
	 * @see - this method is used to return success message
	 * @return - success updated message as string
	 * @throws InterruptedException 
	 * @since - 13-05-2023
	 */
	public String expectedUpdateSuccessMsg() throws InterruptedException {
Thread.sleep(2000);
		return getTxtUpdatedSuccessMsg().getText();
	}

	/**
	 * @author Akash
	 * @see - this method is used to select date functionality
	 * @return - success message as string
	 * @throws InterruptedException
	 * @since - 13-05-2023
	 */
	public void selectdate(String dateChange) throws InterruptedException {
		String[] split = dateChange.split("-");
		String date = split[2];
		List<WebElement> dateTable2 = getUpdateChkInDateTable();
		Thread.sleep(1000);
		for (int i = 0; i < dateTable2.size(); i++) {
			if (dateTable2.get(i).getText().equals(date)) {
				dateTable2.get(i).click();
			}

		}

	}

}

 package com.pages;

import java.awt.AWTException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

/**
 * @author Akash
 * @see Purpose of this class is used to capture locators of Explore Hotel page and following POM design pattern
 * @since 13-05-2023
 */
public class ExploreHotelPage extends BaseClass {

	public ExploreHotelPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id=\"state\"]")
	private WebElement ddnState;

	@FindBy(xpath="//*[@id=\"page-wrapper\"]/section/div/div[2]/div[2]/div")
	private WebElement hotelbooking;
	
	@FindBy(xpath = "//*[@id=\"city\"]")
	private WebElement ddnCity;

	@FindBy(xpath = "//*[@id=\"searchform\"]/div/div[1]/div[3]/div/span[2]/span[1]/span/span/textarea")
	private WebElement roomType;
	@FindBy(xpath = "//a[@class=\"ui-state-default\"]")
	private List<WebElement> dateTable;
	
	
	@FindBy(xpath="//*[@id=\"ui-datepicker-div\"]/div/a[2]/span")
	private WebElement dateNextBtn;
	
	
	@FindBy(xpath = "//input[@placeholder=\"Check-In --/--/-- *\"]")
	private WebElement dtpCheckIn;

	@FindBy(xpath = "//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[3]/td[4]/a")
	private WebElement inDateClick;

	@FindBy(xpath = "//input[@class=\"form-control to hasDatepicker\"]")
	private WebElement dtpCheckOut;

	@FindBy(xpath = "//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[4]/td[6]/a")
	private WebElement outDateClick;

	@FindBy(xpath = "//*[@id=\"no_rooms\"]")
	private WebElement ddnRoomCount;

	@FindBy(xpath = "//*[@id=\"no_adults\"]")
	private WebElement ddnAdultCount;

	@FindBy(xpath = "//*[@id=\"no_child\"]")
	private WebElement txtChildCount;

	@FindBy(xpath = "//*[@id=\"wrapper\"]/header/div/div/div/div[2]/div/ul/li[3]/a")
	private WebElement txtSucessMsg;

	@FindBy(xpath = "//select[@data-placeholder=\"Select Room Type\"]")
	private WebElement ddnRoomType;

	
	public WebElement getDateNextBtn() {
		return dateNextBtn;
	}

	public List<WebElement> getDateTable() {
		return dateTable;
	}

	public WebElement getDdnRoomType() {
		return ddnRoomType;
	}

	public WebElement getTxtChildCount() {
		return txtChildCount;
	}

	@FindBy(xpath = "//iframe[@id=\"hotelsearch_iframe\"]")
	private WebElement frameSearch;

	@FindBy(xpath = "//*[@id=\"searchBtn\"]")
	private WebElement btnSearch;

	@FindBy(xpath = ("(//div[@class=\"invalid-feedback animated fadeInDown\"])[1]"))
	private WebElement txtErrorMsgState;

	@FindBy(xpath = ("(//div[@class=\"invalid-feedback animated fadeInDown\"])[2]"))
	private WebElement txtErrorMsgCity;

	@FindBy(xpath = ("(//div[@class=\"invalid-feedback animated fadeInDown\"])[3]"))
	private WebElement txtErrorMsgChkDate;

	@FindBy(xpath = ("(//div[@class=\"invalid-feedback animated fadeInDown\"])[4]"))
	private WebElement txtErrorMsgChkOutDate;

	@FindBy(xpath = ("(//div[@class=\"invalid-feedback animated fadeInDown\"])[5]"))
	private WebElement txtErrorMsgRoom;

	@FindBy(xpath = ("(//div[@class=\"invalid-feedback animated fadeInDown\"])[6]"))
	private WebElement txtErrorMsgAdult;

	public WebElement getTxtSucessMsg() {
		return txtSucessMsg;
	}

	public WebElement getTxtErrorMsgState() {
		return txtErrorMsgState;
	}

	public WebElement getTxtErrorMsgCity() {
		return txtErrorMsgCity;
	}

	public WebElement getTxtErrorMsgChkDate() {
		return txtErrorMsgChkDate;
	}

	public WebElement getTxtErrorMsgChkOutDate() {
		return txtErrorMsgChkOutDate;
	}

	public WebElement getTxtErrorMsgRoom() {
		return txtErrorMsgRoom;
	}

	public WebElement getTxtErrorMsgAdult() {
		return txtErrorMsgAdult;
	}

	public WebElement getDdnState() {
		return ddnState;
	}

	public WebElement getDdnCity() {
		return ddnCity;
	}

	public WebElement getRoomType() {
		return roomType;
	}

	public WebElement getDtpCheckIn() {
		return dtpCheckIn;
	}

	public WebElement getInDateClick() {
		return inDateClick;
	}

	public WebElement getDtpCheckOut() {
		return dtpCheckOut;
	}

	public WebElement getOutDateClick() {
		return outDateClick;
	}

	public WebElement getDdnRoomCount() {
		return ddnRoomCount;
	}

	public WebElement getDdnAdultCount() {
		return ddnAdultCount;
	}

	public WebElement getFrameSearch() {
		return frameSearch;
	}

	public WebElement getBtnSearch() {
		return btnSearch;
	}

	public String expectedErrorMsgState() {
		return getTxtErrorMsgState().getText();
	}

	public String expectedErrorMsgCity() {
		return getTxtErrorMsgCity().getText();
	}

	public String expectedErrorMsgChkInDate() {
		return getTxtErrorMsgChkDate().getText();
	}

	public String expectedErrorMsgChkOutDate() {
		return getTxtErrorMsgChkOutDate().getText();
	}

	public String expectedErrorMsgNoOfRoom() {
		return getTxtErrorMsgRoom().getText();
	}

	public String expectedErrorMsgNoOfAdult() {
		return getTxtErrorMsgAdult().getText();
	}

	
	/**
	 * @author Akash
	 * @return - Expected login success message as string
	 * @since - 13-05-2023
	 */
	public String expectedLoginSuccessMsg() {

		return getText(getTxtSucessMsg());
	}
	
	public WebElement getHotelbooking() {
		return hotelbooking;
	}

	/**
	 * @author Akash
	 * @see - this method is used to perform Search Hotel with all details
	 * @since - 13-05-2023 as string
	 * @param - stateName as string
	 * @param - cityName as string 
	 * @param - roomType as string 
	 * @param -checkInDate as string 
	 * @param - checkOutDate as string 
	 * @param - noOfRoom as string
	 * @param -noOfAdult as string
	 * @param -noOfChild as string
	 */
	public void exploreHotel(String stateName, String cityName, String roomType, String checkInDate,
			String checkOutDate, String noOfRoom, String noOfAdult, String noOfChild)
			throws  InterruptedException {
		
		getHotelbooking().click();
		Thread.sleep(2000);

		ddnSelectByTxt(getDdnState(), stateName);
		Thread.sleep(1000);
		ddnSelectByTxt(getDdnCity(), cityName);
		Thread.sleep(1000);
		selectRoomType(roomType);
		Thread.sleep(1000);
		getDtpCheckIn().click();
		selectdate(checkInDate);
		Thread.sleep(2000);
		getDtpCheckOut().click();
		selectdate(checkOutDate);
		ddnSelectByTxt(getDdnRoomCount(), noOfRoom);
		ddnSelectByTxt(getDdnAdultCount(), noOfAdult);
		passTxt(getTxtChildCount(), noOfChild);
		switchToFrame(getFrameSearch());
		Thread.sleep(1000);
		getBtnSearch().click();
		switchToDefaultContent();
	}

	
	/**
	 * @author Akash
	 * @see - this method is used to perform Search Hotel with only mandatory details
	 * @since - 13-05-2023
	  * @param - stateName as string
	 * @param - cityName as string 
	 * @param - roomType as string 
	 * @param -checkInDate as string 
	 * @param - checkOutDate as string 
	 * @param - noOfRoom as string
	 * @param -noOfAdult as string
	 * @param -noOfChild as string
	 */
	public void exploreHotel(String stateName, String cityName, String checkInDate, String checkOutDate,
			String noOfRoom, String noOfAdult) throws AWTException, InterruptedException {

		getHotelbooking().click();
		Thread.sleep(2000);
		ddnSelectByTxt(getDdnState(), stateName);
		Thread.sleep(1000);
		ddnSelectByTxt(getDdnCity(), cityName);
		Thread.sleep(1000);
		getDtpCheckIn().click();
		selectdate(checkInDate);
		getDtpCheckOut().click();
		selectdate(checkOutDate);
		ddnSelectByTxt(getDdnRoomCount(), noOfRoom);
		ddnSelectByTxt(getDdnAdultCount(), noOfAdult);
		switchToFrame(getFrameSearch());
		Thread.sleep(1000);
		getBtnSearch().click();
		switchToDefaultContent();
	}

	
	/**
	 * @author Akash
	 * @see - this method is used to perform Search Hotel without entering any feild
	 * @since - 13-05-2023
	 * @throws - InterruptedException
	 */
	public void exploreHotel() throws InterruptedException {
	
		getHotelbooking().click();
		Thread.sleep(2000);
		switchToFrame(getFrameSearch());
		getBtnSearch().click();
		switchToDefaultContent();
	}

	
	
	
	/**
	 * @author Akash
	 * @see - this method is used to select specific room type
	 * @since - 13-05-2023
	 * @param - roomType
	 */
	public void selectRoomType(String roomType) {

		String[] split = roomType.split("/");

		int length = split.length;
		if (length != 1) {

			for (int i = 0; i < split.length; i++) {
				ddnSelectByTxt(getDdnRoomType(), split[i]);
			}
		} else {
			ddnSelectByTxt(getDdnRoomType(), roomType);
		}

	}

	public void selectdate(String checkInDate) throws InterruptedException {
		String[] split = checkInDate.split("-");
		String date = split[2];
		List<WebElement> dateTable2 = getDateTable();

		for (int i = 0; i < dateTable2.size(); i++) {
			if (dateTable2.get(i).getText().equals(date)) {
				Thread.sleep(1000);
				dateTable2.get(i).click();
				break;
			}

		}

	}

}

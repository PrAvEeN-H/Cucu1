package com.pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

/**
 * @author Akash
 * @see Purpose of this class is used to capture locators of Select Hotel page and following POM designpatter
 * @since 13-05-2023 
 */
public class SelectHotelPage extends BaseClass {

	public static String selectedHotelName;
	public static String hotelPrice;

	public SelectHotelPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h5[text()='Select Hotel']")
	private WebElement txtSuccessMsgSelectHotel;

	@FindBy(xpath = "//*[@id=\"hotellist\"]/div[1]/div/div[3]/div/a")
	private WebElement btnContinue;

	@FindBy(xpath = "//label[text()='Price low to high']")
	private WebElement rdoBtnLowToHigh;

	@FindBy(xpath = "//label[text()='Price High to low']")
	private WebElement rdoBtnHighToLow;

	@FindBy(xpath = "//a[@id=\"room_type\"]")
	private WebElement chkRoomFilter;

	@FindBy(xpath = "//strong[text()='$ 5,192']")
	private WebElement price;

	@FindBy(xpath = "//strong[@class=\"total-prize\"]")
	private List<WebElement> pricelist;

	@FindBy(xpath = "//div[@class=\"fliter_box_inner mb-4\"]//a")
	private List<WebElement> listOfHotelContinue;

	public List<WebElement> getListOfHotelContinue() {
		return listOfHotelContinue;
	}

	public List<WebElement> getPricelist() {
		return pricelist;
	}

	@FindBy(xpath = "//div[@id=\"hotellist\"]//div[@class=\"fliter_box_inner mb-4\"]//h5")
	private List<WebElement> hotelNamee;

	public List<WebElement> getHotelName() {
		return hotelNamee;
	}

	public WebElement getBtnContinue() {
		return btnContinue;
	}

	public WebElement getRdoBtnLowToHigh() {
		return rdoBtnLowToHigh;
	}

	public WebElement getRdoBtnHighToLow() {
		return rdoBtnHighToLow;
	}

	public WebElement getTxtSuccessMsgSelectHotel() {
		return txtSuccessMsgSelectHotel;
	}

	public WebElement getChkRoomFilter() {
		return chkRoomFilter;
	}

	public String expectedRoomFilterMessage() {

		return getChkRoomFilter().getText();
	}

	public String successMsgSelectHotel() {
		
		String text = getText(getTxtSuccessMsgSelectHotel());
		return text;
		
		
		
	}

	/**
	 * @author Akash
	 * @see - this method is used to select first hotel and saves hotel name and price
	 * @since - 13-05-2023
	 */
	public void selectFirstHotel() {

		selectedHotelName = getHotelName().get(0).getText();
		System.out.println(selectedHotelName);
		hotelPrice = getPricelist().get(0).getText();
		System.out.println(hotelPrice);
		
		List<WebElement> listOfHotelContinue2 = getListOfHotelContinue();
		listOfHotelContinue2.get(0).click();

	}

	/**
	 * @author Akash
	 * @see - this method is used to accept alert
	 * @since - 13-05-2023
	 */
	public void acceptAlertMsg() {
		acceptAlert();
		List<WebElement> listOfHotelContinue2 = getListOfHotelContinue();
		listOfHotelContinue2.get(0).click();
		
	}

	/**
	 * @author Akash
	 * @see - this method is used to dimiss alert
	 * @since - 13-05-2023
	 */
	public void dissmissAlertMsg() {
		List<WebElement> listOfHotelContinue2 = getListOfHotelContinue();
		listOfHotelContinue2.get(0).click();
		dismissAlert();

	}

	/**
	 * @author Akash
	 * @see - this method is used to click sort button
	 * @since - 13-05-2023
	 */
	public void clickPriceLowToHigh() {

		getRdoBtnLowToHigh().click();
	}

	/**
	 * @author Akash
	 * @see - this method is used to click sort button
	 * @since - 13-05-2023
	 */
	public void clickPriceHighToLow() {

		getRdoBtnHighToLow().click();
	}

	public static int intConversion(String d) {

		String s11 = d.replace("$", " ");
		String j = s11.replace("a", " ");
		String g = j.replace(",", " ");
		String v = g.replaceAll(" ", "");
		int p = Integer.parseInt(v);
		return p;
	}

	/**
	 * @author Akash
	 * @see - this method is used to check sorting functionality
	 * @return - Price sorting working or not as boolean
	 * @throws InterruptedException 
	 * @since - 13-05-2023
	 */
	public boolean sortPriceLowToHigh() throws InterruptedException {

		List<Integer> PresentOrder = new LinkedList<Integer>();
		Thread.sleep(2000);
		List<WebElement> PrizeOrder = getPricelist();

		for (int i = 0; i < PrizeOrder.size(); i++) {
			PresentOrder.add(SelectHotelPage.intConversion(PrizeOrder.get(i).getText()));
		}

		List<Integer> ActualOrder = new LinkedList<Integer>();

		ActualOrder.addAll(PresentOrder);
		Collections.sort(ActualOrder);

		if (ActualOrder.equals(PresentOrder)) {
			return true;
		} else {
			return false;
		}
	}


	/**
	 * @author Akash
	 * @see - this method is used to check sorting functionality
	 * @return - Price sorting working or not as boolean
	 * @throws InterruptedException 
	 * @since - 13-05-2023
	 */

	public boolean sortPriceHighToLow() throws InterruptedException {

		List<Integer> PresentOrder = new LinkedList<Integer>();
		Thread.sleep(2000);
		List<WebElement> PrizeOrder = getPricelist();

		for (int i = 0; i < PrizeOrder.size(); i++) {
			PresentOrder.add(SelectHotelPage.intConversion(PrizeOrder.get(i).getText()));
		}

		List<Integer> ActualOrder = new LinkedList<Integer>();

		ActualOrder.addAll(PresentOrder);
		Collections.sort(ActualOrder);
		Collections.reverse(ActualOrder);

		if (ActualOrder.equals(PresentOrder)) {
			return true;
		} else {
			return false;
		}

	}


	/**
	 * @author Akash
	 * @see - this method is used to check hotel name ends with  same room type filter selected 
	 * @return - room filter working or not as boolean
	 * @since - 13-05-2023
	 */

	public boolean sameRoomTypeFilterNameCheck() {

		String[] split = getChkRoomFilter().getText().split("/");
		List<String> nameCheck = new ArrayList<String>();
		int length = split.length;

		List<WebElement> hotelName = getHotelName();
		for (int i = 0; i < hotelName.size(); i++) {

			switch (length) {

			case 1:
				if (getHotelName().get(i).getText().endsWith(split[0])) {
					nameCheck.add("true");
				} else {
					nameCheck.add("false");
				}
			case 2:
				if (getHotelName().get(i).getText().endsWith(split[0])
						|| getHotelName().get(i).getText().endsWith(split[1])) {
					nameCheck.add("true");
				} else {
					nameCheck.add("false");
				}
			case 3:
				if (getHotelName().get(i).getText().endsWith(split[0])
						|| getHotelName().get(i).getText().endsWith(split[1])
						|| getHotelName().get(i).getText().endsWith(split[2])) {
					nameCheck.add("true");
				} else {
					nameCheck.add("false");
				}
			case 4:
				if (getHotelName().get(i).getText().endsWith(split[0])
						|| getHotelName().get(i).getText().endsWith(split[1])
						|| getHotelName().get(i).getText().endsWith(split[2])
						|| getHotelName().get(i).getText().endsWith(split[3])) {
					nameCheck.add("true");
				} else {
					nameCheck.add("false");
				}
			case 5:
				if (getHotelName().get(i).getText().endsWith(split[0])
						|| getHotelName().get(i).getText().endsWith(split[1])
						|| getHotelName().get(i).getText().endsWith(split[2])
						|| getHotelName().get(i).getText().endsWith(split[3])
						|| getHotelName().get(i).getText().endsWith(split[4])) {
					nameCheck.add("true");
				} else {
					nameCheck.add("false");
				}

			}

		}
		if (nameCheck.contains("false")) {
			return false;
		} else {
			return true;
		}
	
	}

}

package com.pagemanager;

import com.pages.BookHotelPage;
import com.pages.BookingConformPage;
import com.pages.ExploreHotelPage;
import com.pages.LoginPage;
import com.pages.MyBookingPage;
import com.pages.SelectHotelPage;

public class PageObjectManager {

	private LoginPage login;
	private ExploreHotelPage explore;
	private SelectHotelPage select;
	private BookHotelPage book;
	private BookingConformPage conform;
	private MyBookingPage mybook;
	
	

	
	
	public LoginPage getLogin() {
		return (login == null)?login= new LoginPage(): login;
	}
	public ExploreHotelPage getExplore() {
		return (explore == null)?explore= new ExploreHotelPage(): explore;
	}
	public SelectHotelPage getSelect() {
		return (select == null)?select= new SelectHotelPage(): select;
	}
	public BookHotelPage getBook() {
		return (book == null)?book= new BookHotelPage(): book;
	}
	public BookingConformPage getConform() {
		return (conform == null)?conform= new BookingConformPage(): conform;
	}
	public MyBookingPage getMybook() {
		return (mybook == null)?mybook= new MyBookingPage(): mybook;
	}
	
	
	
	
	
	
}

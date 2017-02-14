package com.tcs.ilp.Model;

import java.sql.SQLException;
import java.util.ArrayList;

import com.tcs.ilp.Bean.BookingBean;
import com.tcs.ilp.DAO.BookingImpl;

public class BookingModel {

	BookingImpl bImpl=new BookingImpl();
	
	public BookingBean bookTicket(int classId, int showId, String emailId, int price, int s, String s2) throws SQLException
	{
		return bImpl.ticketbook(classId, showId, emailId, price, s, s2);
	}

	public ArrayList<BookingBean> getBookingList() throws SQLException {
		// TODO Auto-generated method stub
		return bImpl.getBookingList();
	}
	
	public ArrayList<BookingBean> getBookingList(String user) throws SQLException {
		// TODO Auto-generated method stub
		return bImpl.getBookingList(user);
	}
}

package com.tcs.ilp.DAO;

import java.sql.SQLException;
import java.util.ArrayList;

import com.tcs.ilp.Bean.BookingBean;

public interface bookingDAO {
	
	public BookingBean ticketbook(int classId, int showId, String emailId, int price, int seatsBooked, String seatNumber) throws SQLException;
	public ArrayList<BookingBean> getBookingList() throws SQLException;
	public ArrayList<BookingBean> getBookingList(String user) throws SQLException;
}

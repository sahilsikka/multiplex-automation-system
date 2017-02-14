package com.tcs.ilp.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.tcs.ilp.Bean.BookingBean;
import com.tcs.ilp.Bean.ClassBean;
import com.tcs.ilp.util.DatabaseUtil;

public class BookingImpl implements bookingDAO{

	Connection con=null;
	PreparedStatement ps=null;
	int rowsAffected=0;
	ResultSet resultSet=null;
	BookingBean bookingBean=new BookingBean();
	
	public BookingBean ticketbook(int classId, int showId, String emailId,
			int price, int s, String seatNumber) throws SQLException {
		// TODO Auto-generated method stub
		con=DatabaseUtil.getConnection();
		ps=con.prepareStatement("insert into booking_team5 values(booking_seq.nextVal,?,?,?,?,?,?)");
		
		ps.setInt(1, s);
		ps.setInt(2, price);
		ps.setString(3, emailId);
		ps.setInt(4, showId);
		ps.setInt(5,classId);
		ps.setString(6, seatNumber);
		
		rowsAffected=ps.executeUpdate();
		
		if(rowsAffected>0)
		{
			ps=con.prepareStatement("select bookingid from booking_team5 where classId=? and emailid=? and showid=? and seatnumber=? and seatsbooked=?");
			ps.setInt(1, classId);
			ps.setString(2, emailId);
			ps.setInt(3, showId);
			ps.setString(4, seatNumber);
			ps.setInt(5, s);			
			resultSet=ps.executeQuery();
			
			resultSet.next();
			bookingBean.setBookingId(resultSet.getInt(1));
			bookingBean.setPrice(price);
			bookingBean.setClassId(classId);
			bookingBean.setEmailId(emailId);
			bookingBean.setShowId(showId);
			bookingBean.setSeatsBooked(s);
			bookingBean.setSeatNumber(seatNumber);
		}
		DatabaseUtil.closeStatement(ps);
		DatabaseUtil.closeConnection(con);
			return bookingBean;
	}

	public ArrayList<BookingBean> getBookingList() throws SQLException {
		// TODO Auto-generated method stub
		con=DatabaseUtil.getConnection();
		ps=con.prepareStatement("select * from booking_team5");
		resultSet=ps.executeQuery();
		BookingBean bookingBean; 
		ArrayList<BookingBean> bookingList=new ArrayList<>();
		while(resultSet.next())
		{
			bookingBean=new BookingBean();
			bookingBean.setBookingId(resultSet.getInt(1));
			bookingBean.setSeatsBooked(resultSet.getInt(2));
			bookingBean.setPrice(resultSet.getInt(3));
			bookingBean.setEmailId(resultSet.getString(4));
			bookingBean.setShowId(resultSet.getInt(5));
			bookingBean.setClassId(resultSet.getInt(6));
			bookingBean.setSeatNumber(resultSet.getString(7));
			bookingList.add(bookingBean);			
		}
		
		DatabaseUtil.closeStatement(ps);
		DatabaseUtil.closeConnection(con);
		return bookingList;
	}

	@Override
	public ArrayList<BookingBean> getBookingList(String user)
			throws SQLException {
		// TODO Auto-generated method stub
		con=DatabaseUtil.getConnection();
		ps=con.prepareStatement("select * from booking_team5 where emailid=?");
		ps.setString(1, user);
		resultSet=ps.executeQuery();
		BookingBean bookingBean; 
		ArrayList<BookingBean> bookingList=new ArrayList<>();
		while(resultSet.next())
		{
			bookingBean=new BookingBean();
			bookingBean.setBookingId(resultSet.getInt(1));
			bookingBean.setSeatsBooked(resultSet.getInt(2));
			bookingBean.setPrice(resultSet.getInt(3));
			bookingBean.setEmailId(resultSet.getString(4));
			bookingBean.setShowId(resultSet.getInt(5));
			bookingBean.setClassId(resultSet.getInt(6));
			bookingBean.setSeatNumber(resultSet.getString(7));
			bookingList.add(bookingBean);			
		}
		System.out.println("booking list is "+bookingList.size());
		DatabaseUtil.closeStatement(ps);
		DatabaseUtil.closeConnection(con);
		return bookingList;
		
	}

}

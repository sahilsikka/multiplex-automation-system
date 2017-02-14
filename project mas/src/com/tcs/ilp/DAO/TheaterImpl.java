package com.tcs.ilp.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.tcs.ilp.Bean.TheaterBean;
import com.tcs.ilp.util.DatabaseUtil;

public class TheaterImpl {

	Connection con=null;
	PreparedStatement ps=null;
	int rowsAffected=0;
	ResultSet resultSet;
	
	public ArrayList<TheaterBean> getTheaterList(int locationId) throws SQLException {
		// TODO Auto-generated method stub
		ArrayList<TheaterBean> tList=new ArrayList<TheaterBean>();
		TheaterBean tBean;
		con=DatabaseUtil.getConnection();
		System.out.println("location id is "+locationId);
		ps=con.prepareStatement("select * from theater_team5 where locationid=?");
		ps.setLong(1, locationId);
		resultSet=ps.executeQuery();
		
		while(resultSet.next())
		{
			System.out.println("value mili re mili");
			tBean=new TheaterBean();
			tBean.setLocationId(locationId);
			tBean.setNoOfScreen(resultSet.getInt(3));
			tBean.setTheaterId(resultSet.getInt(1));
			tBean.setTheaterName(resultSet.getString(2));
			tList.add(tBean);
		}
		DatabaseUtil.closeStatement(ps);
		DatabaseUtil.closeConnection(con);
		return tList;
	}

	 
}

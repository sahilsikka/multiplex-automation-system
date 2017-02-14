package com.tcs.ilp.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.tcs.ilp.Bean.MovieBean;
import com.tcs.ilp.Bean.ScreenBean;
import com.tcs.ilp.util.DatabaseUtil;

public class ScreenImpl implements ScreenDAO {
	Connection con=null;
	PreparedStatement ps=null;
	int rowsAffected=0;
	ResultSet resultSet;
	public ArrayList<ScreenBean> getScreenList() throws SQLException {
		// TODO Auto-generated method stub
		
		ScreenBean screenBean;
		ArrayList<ScreenBean> screenList=new ArrayList<ScreenBean>();
		System.out.println("before select");
		con=DatabaseUtil.getConnection();
		PreparedStatement ps1=con.prepareStatement("select * from screen_team5");
System.out.println("after select");
		
		resultSet=ps1.executeQuery();
		
		while(resultSet.next())
		{
			System.out.println("added");
			screenBean=new ScreenBean();
			screenBean.setScreenId(resultSet.getInt(1));
			screenBean.setTheaterId(resultSet.getInt(3));
			screenBean.setTotalSeats(resultSet.getInt(2));
			screenList.add(screenBean);
		}
		DatabaseUtil.closeStatement(ps);
		DatabaseUtil.closeConnection(con);
		if(!screenList.isEmpty())
			{
			System.out.println("not empty");
			return screenList;
			}
		else
			return null;
	}
	public ScreenBean getScreenById(Long id) throws SQLException {
		// TODO Auto-generated method stub
		
		con=DatabaseUtil.getConnection();
		ps=con.prepareStatement("select * from screen_team5 where screenid=?");
		ps.setLong(1, id);
		resultSet=ps.executeQuery();
		resultSet.next();
		
		ScreenBean screenBean=new ScreenBean();
		screenBean.setScreenId(resultSet.getInt(1));
		screenBean.setTotalSeats(resultSet.getInt(2));
		screenBean.setTheaterId(resultSet.getInt(3));
		
		DatabaseUtil.closeStatement(ps);
		DatabaseUtil.closeConnection(con);
		return screenBean;
	}

}

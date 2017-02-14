package com.tcs.ilp.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.tcs.ilp.Bean.LocationBean;
import com.tcs.ilp.util.DatabaseUtil;

public class LocationImpl implements LocationDAO{
	
	Connection con=null;
	PreparedStatement ps=null;
	int rowsAffected=0;
	ResultSet resultSet;
	
	public ArrayList<LocationBean> getLocationList() throws SQLException {
		// TODO Auto-generated method stub
		LocationBean lBean;
		ArrayList<LocationBean> locationList=new ArrayList<LocationBean>();
		con=DatabaseUtil.getConnection();
		ps=con.prepareStatement("select * from location_team5");
		resultSet=ps.executeQuery();
		
		while(resultSet.next())
		{
			lBean=new LocationBean();
			lBean.setLocationId(resultSet.getInt(1));
			lBean.setLocationName(resultSet.getString(2));
			locationList.add(lBean);
		}
		
		DatabaseUtil.closeStatement(ps);
		DatabaseUtil.closeConnection(con);
		return locationList;
	}
	

}

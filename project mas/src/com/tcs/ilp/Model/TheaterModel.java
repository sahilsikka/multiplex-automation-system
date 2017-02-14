package com.tcs.ilp.Model;

import java.sql.SQLException;
import java.util.ArrayList;

import com.tcs.ilp.Bean.TheaterBean;
import com.tcs.ilp.DAO.TheaterImpl;

public class TheaterModel {
	
	TheaterImpl tImpl=new TheaterImpl();
	public ArrayList<TheaterBean> getTheaterList(int locationId) throws SQLException
	{
		return tImpl.getTheaterList(locationId);
	}
}

package com.tcs.ilp.Model;

import java.sql.SQLException;
import java.util.ArrayList;

import com.tcs.ilp.Bean.LocationBean;
import com.tcs.ilp.DAO.LocationImpl;

public class LocationModel {

	LocationImpl lImpl=new LocationImpl();
	public ArrayList<LocationBean> getLocationList() throws SQLException {
		// TODO Auto-generated method stub
		return lImpl.getLocationList();
	}

}

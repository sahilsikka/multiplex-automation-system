package com.tcs.ilp.DAO;

import java.sql.SQLException;
import java.util.ArrayList;

import com.tcs.ilp.Bean.LocationBean;

public interface LocationDAO {
	
	public ArrayList<LocationBean> getLocationList() throws SQLException;

}

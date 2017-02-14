package com.tcs.ilp.Model;

import java.sql.SQLException;
import java.util.ArrayList;

import com.tcs.ilp.Bean.MovieBean;
import com.tcs.ilp.Bean.ScreenBean;
import com.tcs.ilp.DAO.ScreenImpl;

public class ScreenModel {
	ScreenImpl screenimpl= new ScreenImpl();
	
	public ArrayList<ScreenBean> getScreenList() throws SQLException {
		// TODO Auto-generated method stub
		return screenimpl.getScreenList();
	}

	public ScreenBean getScreenById(Long id) throws SQLException {
		// TODO Auto-generated method stub
		
		return screenimpl.getScreenById(id);
	}

}

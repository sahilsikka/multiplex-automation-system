package com.tcs.ilp.DAO;

import java.sql.SQLException;
import java.util.ArrayList;

import com.tcs.ilp.Bean.MovieBean;
import com.tcs.ilp.Bean.ScreenBean;

public interface ScreenDAO {
	public ArrayList<ScreenBean> getScreenList() throws SQLException;
	public ScreenBean getScreenById(Long id) throws SQLException;
}

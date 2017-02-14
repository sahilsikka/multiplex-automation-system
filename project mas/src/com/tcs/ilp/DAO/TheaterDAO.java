package com.tcs.ilp.DAO;

import java.util.ArrayList;

import com.tcs.ilp.Bean.TheaterBean;

public interface TheaterDAO {

	public ArrayList<TheaterBean> getTheaterList(int locationId);
}

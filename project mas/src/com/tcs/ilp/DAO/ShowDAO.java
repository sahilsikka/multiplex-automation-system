package com.tcs.ilp.DAO;

import java.sql.SQLException;
import java.util.ArrayList;

import com.tcs.ilp.Bean.MovieBean;
import com.tcs.ilp.Bean.ShowBean;

public interface ShowDAO {
	public ShowBean showMovie(Long screenId, int movieId, String startDate, String showSlot)throws SQLException;
	public boolean removeShow(int showId) throws SQLException;
	public ArrayList<ShowBean> getShowList() throws SQLException;
	public boolean updateShow(ShowBean sb)throws SQLException;
	public ShowBean viewbyShowId(int showId) throws SQLException;
	public ShowBean updatebyShowId(int showId, int screenid, String showslot,String showdate) throws SQLException;
	public ArrayList<ShowBean> getShowDateListByMovie(int movieId) throws SQLException;
	public ArrayList<ShowBean> getShowSlotListByMovieDate(int movieId,String showDate) throws SQLException;
	//--------------------------------search-------------------
	
		public ArrayList<ShowBean> searchShowByShowDate(String date) throws SQLException;
		public ArrayList<ShowBean> searchShowByShowTime(String time) throws SQLException;
}

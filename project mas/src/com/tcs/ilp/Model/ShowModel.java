package com.tcs.ilp.Model;

import java.sql.SQLException;
import java.util.ArrayList;

import com.tcs.ilp.Bean.MovieBean;
import com.tcs.ilp.Bean.ShowBean;
import com.tcs.ilp.DAO.ShowImpl;

public class ShowModel {
	ShowImpl sImpl=  new ShowImpl();
	
	public ShowBean showMovie(Long screenId, int movieId, String startDate, String showSlot) throws SQLException
	{
		
		return sImpl.showMovie(screenId, movieId, startDate, showSlot);
		
	}

	
	
	public boolean removeShow(int showId) throws SQLException
	{
		return sImpl.removeShow(showId);
		
	}
	
	public boolean updateShow(ShowBean sb) throws SQLException
	{
		return sImpl.updateShow(sb);
		
	}

	public ShowBean viewbyShowId(int sid) throws SQLException {
		// TODO Auto-generated method stub
		return sImpl.viewbyShowId(sid);	}
	
	public ShowBean updatebyShowId(int showId, int screenid, String showslot, String showdate) throws SQLException
	{
		return sImpl.updatebyShowId(showId, screenid, showslot, showdate);
	}

	public boolean showExists(Long screenId, int movieId,
			String startdateFormat, String showslot) throws SQLException {
		// TODO Auto-generated method stub
		return sImpl.showExists(screenId, movieId,startdateFormat,showslot);
	}

	public ArrayList<ShowBean> getShowList()throws SQLException {
		// TODO Auto-generated method stub
		return sImpl.getShowList();
	}

	public ArrayList<ShowBean> getShowDateListByMovie(int movieId) throws SQLException {
		// TODO Auto-generated method stub
		return sImpl.getShowDateListByMovie(movieId);
	}

	public ArrayList<ShowBean> getShowSlotListByMovieDate(int movieId,String showDate) throws SQLException {
		// TODO Auto-generated method stub
		return sImpl.getShowSlotListByMovieDate(movieId,showDate);
	}
	public ArrayList<ShowBean> searchShowByShowDate(String date) throws SQLException
	{
		return sImpl.searchShowByShowDate(date);
	}
	public ArrayList<ShowBean> searchShowByShowTime(String time) throws SQLException
	{
		return sImpl.searchShowByShowTime(time);
	}

}

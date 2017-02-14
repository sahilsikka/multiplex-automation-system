package com.tcs.ilp.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.tcs.ilp.Bean.MovieBean;
import com.tcs.ilp.Bean.ShowBean;
import com.tcs.ilp.util.DatabaseUtil;

public class ShowImpl implements ShowDAO {
	Connection con=null;
	PreparedStatement ps=null;
	int rowsAffected=0;
	ResultSet resultSet = null;
	public ShowBean showMovie(Long screenId, int movieId, String startDate, String showSlot) throws SQLException {
		// TODO Auto-generated method stub
		ShowBean sBean= new ShowBean();
		ResultSet resultSet = null;
		con=DatabaseUtil.getConnection();
		ps=con.prepareStatement("insert into show_team5 values (show_seq.nextVal,TO_DATE(?, 'DD/MM/YYYY'),?,?,?,'active')");
		ps.setLong(4, screenId);
		ps.setInt(2, movieId);
		ps.setString(1, startDate);
		ps.setString(3, showSlot);
				
		rowsAffected=ps.executeUpdate();	
		if(rowsAffected>0)
		{
			ps=con.prepareStatement("select * from show_team5 where screenid=? and movieid=? and showdate=TO_DATE(?, 'DD/MM/YYYY') and showslot=?");
			ps.setLong(1, screenId);
			ps.setInt(2, movieId);
			ps.setString(3, startDate);
			ps.setString(4, showSlot);
			//ps.setString(5, "status");
			resultSet=ps.executeQuery();
			resultSet.next();
			
			sBean.setShowId(resultSet.getInt(1));			
			sBean.setMovieId(movieId);			
			sBean.setShowDate(startDate);
			sBean.setStartTime(showSlot);		
			DatabaseUtil.closeStatement(ps);
			DatabaseUtil.closeConnection(con);
			
			return sBean;
			
		}
		
		DatabaseUtil.closeStatement(ps);
		DatabaseUtil.closeConnection(con);		
		return null;
	}


	public ArrayList<ShowBean> getShowList() throws SQLException {
		// TODO Auto-generated method stub
		con=DatabaseUtil.getConnection();
		ps=con.prepareStatement("select * from show_team5 where status='active'");
		
		ResultSet resultSet=ps.executeQuery();
		
		ShowBean showBean;
		ArrayList<ShowBean> showList=new ArrayList<ShowBean>();
		
		while(resultSet.next())
		{
			showBean=new ShowBean();
			showBean.setShowId(resultSet.getInt(1));
			showBean.setShowDate(resultSet.getString(2).substring(0, 11));

			showBean.setMovieId(resultSet.getInt(3));
			showBean.setStartTime(resultSet.getString(4));
			showBean.setScreenId(resultSet.getInt(5));
			showBean.setStatus(resultSet.getString(6));
			showList.add(showBean);			
		}
		DatabaseUtil.closeStatement(ps);
		DatabaseUtil.closeConnection(con);
		return showList;
	}


	public boolean removeShow(int showId) throws SQLException {
		// TODO Auto-generated method stub
		
		ShowBean sBean=new ShowBean();
		con=DatabaseUtil.getConnection();
		ps=con.prepareStatement("update show_team5 set status='deactivate' where showid=?");
		ps.setInt(1, showId);
		
		rowsAffected=ps.executeUpdate();

		if(rowsAffected>0)
		{
			DatabaseUtil.closeStatement(ps);
			DatabaseUtil.closeConnection(con);
			return Boolean.TRUE;

		}

		DatabaseUtil.closeStatement(ps);
		DatabaseUtil.closeConnection(con);
		return Boolean.FALSE;
		
		
	}


	public boolean updateShow(ShowBean sb) throws SQLException {
		// TODO Auto-generated method stub
		
		con=DatabaseUtil.getConnection();
		ps=con.prepareStatement("update show_team5 set movieid=? and screenid=? and showdate=? and showslot=?  where showid=?");

		ps.setInt(1, sb.getMovieId());
		ps.setInt(2, sb.getScreenId());
		ps.setString(3, sb.getShowDate());
		ps.setString(4, sb.getStartTime());
		ps.setInt(5, sb.getShowId());

		rowsAffected=ps.executeUpdate();
		if(rowsAffected>0)
		{
			DatabaseUtil.closeStatement(ps);
			DatabaseUtil.closeConnection(con);
			return Boolean.TRUE;
		}		
		return false;
	}


	@Override
	public ShowBean viewbyShowId(int showId) throws SQLException {
		ShowBean sBean=null;
		con=DatabaseUtil.getConnection();
		ps=con.prepareStatement("select * from show_team5 where showid=? and status='active'");
		ps.setInt(1, showId);
		ResultSet result=ps.executeQuery();
		if(result.next())
		{
			sBean=new ShowBean();
			sBean.setShowId(result.getInt(1));
			sBean.setShowDate(result.getString(2));
			sBean.setMovieId(result.getInt(3));
			sBean.setStartTime(result.getString(4));
			sBean.setScreenId(result.getInt(5));
			sBean.setStatus(result.getString(6));
		}
		DatabaseUtil.closeStatement(ps);
		DatabaseUtil.closeConnection(con);
		return sBean;

	}


	@Override
	public ShowBean updatebyShowId(int showId, int screenid, String showslot,String showdate) throws SQLException {
		
		// TODO Auto-generated method stub
				ShowBean sBean=new ShowBean();
				System.out.println("hi");
				con=DatabaseUtil.getConnection();
				ps=con.prepareStatement("update show_team5 set showdate=TO_DATE(?, 'DD/MM/YYYY'), showslot=? ,screenid=? where showid=?");
				ps.setString(1, showdate);
				ps.setString(2, showslot);
				ps.setInt(3, screenid);
				ps.setInt(4, showId);
				rowsAffected=ps.executeUpdate();
					if(rowsAffected>0)	
					{
					
						DatabaseUtil.closeStatement(ps);
						DatabaseUtil.closeConnection(con);
						return sBean;
					}
					
				
				DatabaseUtil.closeStatement(ps);
				DatabaseUtil.closeConnection(con);
				return sBean;
	}


	public boolean showExists(Long screenId, int movieId,
			String startdateFormat, String showslot) throws SQLException {
		// TODO Auto-generated method stub
		con=DatabaseUtil.getConnection();
		ps=con.prepareStatement("select * from show_team5 where screenid=? and movieid=? and showslot=? and showdate=TO_DATE(?,'DD/MM/YYYY')");
		ps.setLong(1, screenId);
		ps.setInt(2, movieId);
		ps.setString(3, showslot);
		ps.setString(4, startdateFormat);
		ResultSet resultSet=ps.executeQuery();
		if(resultSet.next())
			return true;
		else
			return false;
	}

	

public ArrayList<ShowBean> getShowDateListByMovie(int movieId) throws SQLException {
	// TODO Auto-generated method stub
	ShowBean showBean;
	ArrayList<ShowBean> showList=new ArrayList<ShowBean>();
	
	con=DatabaseUtil.getConnection();
	ps=con.prepareStatement("select * from show_team5 where movieid=? and status='active'");
	ps.setInt(1, movieId);
	resultSet=ps.executeQuery();
	
	while(resultSet.next())
	{
		showBean=new ShowBean();
		showBean.setShowId(resultSet.getInt(1));
		showBean.setShowDate(resultSet.getString(2));

		showBean.setMovieId(resultSet.getInt(3));
		showBean.setStartTime(resultSet.getString(4));
		showBean.setScreenId(resultSet.getInt(5));
		showList.add(showBean);			

	}
	DatabaseUtil.closeStatement(ps);
	DatabaseUtil.closeConnection(con);
	return showList;
}


public ArrayList<ShowBean> getShowSlotListByMovieDate(int movieId,String showDate) throws SQLException {
	// TODO Auto-generated method stub
	
	ArrayList<ShowBean> showslotList=new ArrayList<ShowBean>();
	ShowBean showBean;System.out.println("resultset is "+showDate);
	con=DatabaseUtil.getConnection();
	String startdateFormat=showDate.substring(8, 10)+"/"+showDate.substring(5, 7)+"/"+showDate.substring(0 ,4);
	ps=con.prepareStatement("select * from show_team5 where movieid=? and showdate=TO_DATE(?, 'DD/MM/YYYY') and status='active'");
	ps.setInt(1, movieId);
	ps.setString(2, startdateFormat);
	resultSet=ps.executeQuery();
	
	while(resultSet.next())
	{
		showBean=new ShowBean();
		showBean.setShowId(resultSet.getInt(1));
		showBean.setShowDate(resultSet.getString(2));

		showBean.setMovieId(resultSet.getInt(3));
		showBean.setStartTime(resultSet.getString(4));
		showBean.setScreenId(resultSet.getInt(5));
		showslotList.add(showBean);			

	}
	
	DatabaseUtil.closeStatement(ps);
	DatabaseUtil.closeConnection(con);
	return showslotList;
}

public ArrayList<ShowBean> searchShowByShowDate(String date) throws SQLException {
	// TODO Auto-generated method stub
	con=DatabaseUtil.getConnection();
	ShowBean showBean=null;
	ArrayList<ShowBean> showList=new ArrayList<ShowBean>();
	ps=con.prepareStatement("select * from show_team5 where showdate like ? ");
	ps.setString(1, "%" + date + "%");
	System.out.println(date);
	ResultSet resultSet=ps.executeQuery();
	while(resultSet.next())
	{			
		showBean=new ShowBean();
		showBean.setShowId(resultSet.getInt(1));
		showBean.setShowDate(resultSet.getString(2));

		showBean.setMovieId(resultSet.getInt(3));
		showBean.setStartTime(resultSet.getString(4));
		showBean.setScreenId(resultSet.getInt(5));
		showBean.setStatus(resultSet.getString(6));
		showList.add(showBean);
		
	}
	DatabaseUtil.closeStatement(ps);
	DatabaseUtil.closeConnection(con);
	return showList;
}


@Override
public ArrayList<ShowBean> searchShowByShowTime(String time) throws SQLException {
	// TODO Auto-generated method stub
	con=DatabaseUtil.getConnection();
	ShowBean showBean=null;
	ArrayList<ShowBean> showList=new ArrayList<ShowBean>();
	ps=con.prepareStatement("select * from show_team5 where showslot like ? ");
	ps.setString(1, "%" + time + "%");
	System.out.println(time);
	ResultSet resultSet=ps.executeQuery();
	while(resultSet.next())
	{			
		showBean=new ShowBean();
		showBean.setShowId(resultSet.getInt(1));
		showBean.setShowDate(resultSet.getString(2));

		showBean.setMovieId(resultSet.getInt(3));
		showBean.setStartTime(resultSet.getString(4));
		showBean.setScreenId(resultSet.getInt(5));
		showBean.setStatus(resultSet.getString(6));
		showList.add(showBean);
		
	}
	DatabaseUtil.closeStatement(ps);
	DatabaseUtil.closeConnection(con);
	return showList;
}

}
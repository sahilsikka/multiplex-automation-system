package com.tcs.ilp.DAO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

import javax.management.MBeanAttributeInfo;

import com.tcs.ilp.Bean.MovieBean;
import com.tcs.ilp.util.DatabaseUtil;

public class MovieImpl implements MovieDAO {
	Connection con=null;
	PreparedStatement ps=null;
	int rowsAffected=0;
	ResultSet resultSet;

	public MovieBean addMovie(String movieName, String Language,String startDate,String endDate, String category, int theaterId, String photo) throws SQLException, FileNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("not entering rowsaffected");
		MovieBean mBean=new MovieBean();
		
		photo = "C:\\Users\\833992\\Desktop\\MAS_TEAM5\\WebContent\\images\\" + photo;
        File file = new File(photo);
        
		con=DatabaseUtil.getConnection();
		ps=con.prepareStatement("insert into movie_team5 values (movieid_seq.nextVal,?,?,TO_DATE(?, 'DD/MM/YYYY'),TO_DATE(?, 'DD/MM/YYYY'),?,?,'active',?)");

		ps.setString(1, movieName);
		ps.setString(2, Language);
		ps.setString(3, startDate);
		ps.setString(4, endDate);
		ps.setString(5, category);
		ps.setInt(6, theaterId);
		
		FileInputStream fis = new FileInputStream(file);
		InputStream inputStream = new FileInputStream(new File(photo));
		ps.setBinaryStream(7, (InputStream)fis, (int)(file.length()));

		rowsAffected=ps.executeUpdate();	
		System.out.println(rowsAffected);

		if(rowsAffected>0)
		{
			System.out.println("entering rowsaffected");
			ps=con.prepareStatement("select * from movie_team5 where moviename=? and language=?");
			ps.setString(1, movieName);
			ps.setString(2, Language);

			resultSet=ps.executeQuery();
			resultSet.next();
			System.out.println(resultSet.getString(2));

			mBean.setMovieId(resultSet.getLong(1));
			mBean.setMovieName(resultSet.getString(2));
			mBean.setLanguage(resultSet.getString(3));
			mBean.setStartDate(resultSet.getDate(4));
			mBean.setEndDate(resultSet.getDate(5));
			mBean.setCategory(resultSet.getString(6));
			mBean.setTheaterId(resultSet.getInt(7));
			mBean.setPoster(resultSet.getBinaryStream(8));

			DatabaseUtil.closeStatement(ps);
			DatabaseUtil.closeConnection(con);
			return mBean;

		}
		else{
			DatabaseUtil.closeStatement(ps);
			DatabaseUtil.closeConnection(con);
			return null;
		}
	}

	public ArrayList<MovieBean> getTheaterById() {
		

		return null;
	}

	public ArrayList<MovieBean> getMovieList() throws SQLException {
		// TODO Auto-generated method stub
		MovieBean mBean;
		ArrayList<MovieBean> movieList=new ArrayList<MovieBean>();
		System.out.println("before select");
		con=DatabaseUtil.getConnection();
		PreparedStatement ps1=con.prepareStatement("select * from movie_team5");

		System.out.println("after select");

		resultSet=ps1.executeQuery();

		while(resultSet.next())
		{
			System.out.println("added");
			mBean=new MovieBean();
			mBean.setMovieId(resultSet.getLong(1));
			mBean.setMovieName(resultSet.getString(2));
			mBean.setLanguage(resultSet.getString(3));
			mBean.setStartDate(resultSet.getDate(4));
			mBean.setEndDate(resultSet.getDate(5));
			mBean.setCategory(resultSet.getString(6));
			mBean.setTheaterId(resultSet.getInt(7));
			mBean.setStatus(resultSet.getString(8));
			movieList.add(mBean);
		}
		DatabaseUtil.closeStatement(ps);
		DatabaseUtil.closeConnection(con);

		if(!movieList.isEmpty())
		{
			System.out.println("not empty");
			return movieList;
		}
		else
			return null;
	}
	
	public ArrayList<MovieBean> getMovieListByTheater(int theaterId) throws SQLException {
		// TODO Auto-generated method stub
		ArrayList<MovieBean> movieList=new ArrayList<MovieBean>();
		MovieBean mBean;
		con=DatabaseUtil.getConnection();
		ps=con.prepareStatement("select * from movie_team5 where theaterid=? and status='active'");
		ps.setInt(1, theaterId);
		
		resultSet=ps.executeQuery();
		
		while(resultSet.next())
		{
			System.out.println("value is "+resultSet.getString(2));
			mBean=new MovieBean();
			mBean.setMovieId(resultSet.getLong(1));
			mBean.setMovieName(resultSet.getString(2));
			mBean.setLanguage(resultSet.getString(3));
			mBean.setStartDate(resultSet.getDate(4));
			mBean.setEndDate(resultSet.getDate(5));
			mBean.setCategory(resultSet.getString(6));
			mBean.setTheaterId(resultSet.getInt(7));
			movieList.add(mBean);
		}
		DatabaseUtil.closeStatement(ps);
		DatabaseUtil.closeConnection(con);
		return movieList;
	}


	public boolean removeMovie(String movieName, String language) throws SQLException {
		// TODO Auto-generated method stub

		MovieBean mBean=new MovieBean();
		con=DatabaseUtil.getConnection();
		ps=con.prepareStatement("update movie_team5 set status='deactivate' where moviename=? and language=?");
		ps.setString(1, movieName);
		ps.setString(2, language);
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

	

	public boolean updatemovie(MovieBean mb) throws SQLException {
		// TODO Auto-generated method stub
		con=DatabaseUtil.getConnection();
		ps=con.prepareStatement("update movie_team5 set category=? where movieid=?");

		ps.setString(1, mb.getCategory());
		ps.setLong(2, mb.getMovieId());

		rowsAffected=ps.executeUpdate();
		if(rowsAffected>0)
		{
			DatabaseUtil.closeStatement(ps);
			DatabaseUtil.closeConnection(con);
			return Boolean.TRUE;
		}		
		return false;
	}

	public MovieBean viewMovieById(int movieId) throws SQLException {
		// TODO Auto-generated method stub
		
		MovieBean mBean=null;
		con=DatabaseUtil.getConnection();
		ps=con.prepareStatement("select * from movie_team5 where movieid=?");
		System.out.println("movie id in impl is "+movieId);
		
		ps.setInt(1, movieId);
		ResultSet result=ps.executeQuery();
		while(result.next())
		{
			mBean=new MovieBean();
			mBean.setMovieId(result.getInt(1));
			mBean.setMovieName(result.getString(2));
			mBean.setLanguage(result.getString(3));
			mBean.setStartDate(result.getDate(4));
			mBean.setEndDate(result.getDate(5));
			mBean.setCategory(result.getString(6));
			mBean.setTheaterId(result.getInt(7));
			mBean.setStatus(result.getString(8));	
			System.out.println("sgfsdfsjgfsbfsjgfsdjkfsjgf");
		}
		DatabaseUtil.closeStatement(ps);
		DatabaseUtil.closeConnection(con);
		return mBean;
		
	}

	public int search(String moviename, String language) throws SQLException {
		// TODO Auto-generated method stub
		int movieid=0;
		con = DatabaseUtil.getConnection();
		ps = con.prepareStatement("select movieid from movie_team5 where moviename=? and language=?");
		ps.setString(1, moviename);
		ps.setString(2, language);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next())
		{
			movieid = rs.getInt(1);
		
		}
		
		return movieid;
		
	}
	

//-----------------------------selecting movie list to display as drop down----------------------------
	
	public ArrayList<String> search() throws SQLException
	{
		con = DatabaseUtil.getConnection();
		String moviename;
		ArrayList<String> mlist = new ArrayList<String>();
		ps = con.prepareStatement("select moviename from movie_team5");
		
		
		ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
			moviename = rs.getString(1);
			mlist.add(moviename);
			Collections.sort(mlist);
			
		}
		return mlist;
	}
	
//------------------------------viewMovieById-----------------------------------------------------
	
	
	public MovieBean viewMovieByIdForMovie(int movieid) throws SQLException {
		
		// TODO Auto-generated method stub
		 MovieBean mbean = new MovieBean();
		 con = DatabaseUtil.getConnection();
		 ps = con.prepareStatement("select startdate,enddate,category from movie_team5 where movieid =? ");
		 ps.setInt(1,movieid);
		 
		ResultSet rs =  ps.executeQuery();
		
		while(rs.next())
		{
		mbean.setStartDate(rs.getDate(1));
		mbean.setEndDate(rs.getDate(2));
		mbean.setCategory(rs.getString(3));
		}
		return mbean;
		
	}

//----------------------------------------display category in drop down------------------------------------

	
	public ArrayList<String> category() throws SQLException
	{
		ArrayList<String> clist = new ArrayList<String>();
		con = DatabaseUtil.getConnection();
		ps = con.prepareStatement("select distinct category from movie_team5");
		
		ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
			String catgory = rs.getString(1);
			clist.add(catgory);
		}
		Collections.sort(clist);
		return clist;
	}
	
	
//----------------------------------UpdateMovieById----------------------------------------------------------
	
	@Override
	public boolean updateMovieById(String startdate,String enddate, String category, int movieid) throws SQLException {
		// TODO Auto-generated method stub
		con = DatabaseUtil.getConnection();
		int rowsaffected = 0;
		ps = con.prepareStatement("update movie_team5 set startdate=TO_DATE(?,'DD/MM/YYYY'), enddate=TO_DATE(?,'DD/MM/YYYY'),category=? where movieid=?");
		
		ps.setString(1,startdate);
		ps.setString(2, enddate);
		ps.setString(3,category);
		ps.setInt(4,movieid);
		
		rowsaffected = ps.executeUpdate();
		
		if(rowsaffected>0)
		{
			
			DatabaseUtil.closeConnection(con);
			DatabaseUtil.closeStatement(ps);
			return Boolean.TRUE;
		}
		
		DatabaseUtil.closeConnection(con);
		DatabaseUtil.closeStatement(ps);
		return Boolean.FALSE;
	}

	public ArrayList<String> viewMovieByName() throws SQLException {
		// TODO Auto-generated method stub
		ArrayList<String> movieList=new ArrayList<String>();
		con=DatabaseUtil.getConnection();
		ps=con.prepareStatement("select moviename from movie_team5");
		
		ResultSet result=ps.executeQuery();
		while(result.next())
		{
			movieList.add(result.getString(1));
			System.out.println(result.getString(1));
		}
		DatabaseUtil.closeStatement(ps);
		DatabaseUtil.closeConnection(con);
		if(!movieList.isEmpty())
		{
			return movieList;
		}
		else
			return null;
	}

	@Override
	public ArrayList<String> viewMovieByLanguage()
			throws SQLException {
		// TODO Auto-generated method stub
		ArrayList<String> movieList=new ArrayList<String>();
		con=DatabaseUtil.getConnection();
		ps=con.prepareStatement("select language from movie_team5 ");
		
		ResultSet result=ps.executeQuery();
		while(result.next())
		{
			
			movieList.add(result.getString(1));
		}
		DatabaseUtil.closeStatement(ps);
		DatabaseUtil.closeConnection(con);
		if(!movieList.isEmpty())
		{
			
			return movieList;
		}
		else
			return null;
	}

	@Override
	public ArrayList<String> viewMovieByCategory()throws SQLException {
		// TODO Auto-generated method stub
		ArrayList<String> movieList=new ArrayList<String>();
		MovieBean mBean=null;
		con=DatabaseUtil.getConnection();
		ps=con.prepareStatement("select category from movie_team5");
		
		ResultSet result=ps.executeQuery();
		if(result.next())
		{
			
			movieList.add(result.getString(1));
		}
		DatabaseUtil.closeStatement(ps);
		DatabaseUtil.closeConnection(con);
		if(!movieList.isEmpty())
		{
			System.out.println("not empty");
			return movieList;
		}
		else
			return null;
	}
	
	//------------------------------search----------------------------------------
	
		@Override
		public ArrayList<MovieBean> searchMovieByName(String name)
				throws SQLException {
			// TODO Auto-generated method stub
			con=DatabaseUtil.getConnection();
			MovieBean mBean=null;
			ArrayList<MovieBean> movieList=new ArrayList<MovieBean>();
			ps=con.prepareStatement("select * from movie_team5 where moviename like ? ");
			ps.setString(1, "%" + name + "%");
			System.out.println(name);
			ResultSet result=ps.executeQuery();
			while(result.next())
			{			
				mBean=new MovieBean();
				mBean.setMovieId(result.getLong(1));
				mBean.setMovieName(result.getString(2));
				mBean.setLanguage(result.getString(3));
				mBean.setStartDate(result.getDate(4));
				mBean.setEndDate(result.getDate(5));
				mBean.setCategory(result.getString(6));
				mBean.setTheaterId(result.getInt(7));
				mBean.setStatus(result.getString(8));
				movieList.add(mBean);
				
			}
			DatabaseUtil.closeStatement(ps);
			DatabaseUtil.closeConnection(con);
			return movieList;
		}

		@Override
		public ArrayList<MovieBean> searchMovieByLanguage(String language)
				throws SQLException {
			// TODO Auto-generated method stub
			con=DatabaseUtil.getConnection();
			MovieBean mBean=null;
			ArrayList<MovieBean> movieList=new ArrayList<MovieBean>();
			ps=con.prepareStatement("select * from movie_team5 where language like ? ");
			ps.setString(1, "%" + language + "%");
			System.out.println(language);
			ResultSet resultSet=ps.executeQuery();
			while(resultSet.next())
			{
				
				mBean=new MovieBean();
				mBean.setMovieId(resultSet.getLong(1));
				mBean.setMovieName(resultSet.getString(2));
				mBean.setLanguage(resultSet.getString(3));
				mBean.setStartDate(resultSet.getDate(4));
				mBean.setEndDate(resultSet.getDate(5));
				mBean.setCategory(resultSet.getString(6));
				mBean.setTheaterId(resultSet.getInt(7));
				mBean.setStatus(resultSet.getString(8));
				movieList.add(mBean);
				
			}
			DatabaseUtil.closeStatement(ps);
			DatabaseUtil.closeConnection(con);
			return movieList;
		}

		@Override
		public ArrayList<MovieBean> searchMovieByCategory(String category)
				throws SQLException {
			// TODO Auto-generated method stub
			con=DatabaseUtil.getConnection();
			MovieBean mBean=null;
			ArrayList<MovieBean> movieList=new ArrayList<MovieBean>();
			ps=con.prepareStatement("select * from movie_team5 where category like ? ");
			ps.setString(1, "%" + category + "%");
			System.out.println(category);
			ResultSet resultSet=ps.executeQuery();
			while(resultSet.next())
			{
				
				mBean=new MovieBean();
				mBean.setMovieId(resultSet.getLong(1));
				mBean.setMovieName(resultSet.getString(2));
				mBean.setLanguage(resultSet.getString(3));
				mBean.setStartDate(resultSet.getDate(4));
				mBean.setEndDate(resultSet.getDate(5));
				mBean.setCategory(resultSet.getString(6));
				mBean.setTheaterId(resultSet.getInt(7));
				mBean.setStatus(resultSet.getString(8));
				movieList.add(mBean);
				
			}
			DatabaseUtil.closeStatement(ps);
			DatabaseUtil.closeConnection(con);
			return movieList;
		}

}

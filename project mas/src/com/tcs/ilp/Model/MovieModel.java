package com.tcs.ilp.Model;

import java.io.FileNotFoundException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import com.tcs.ilp.Bean.MovieBean;
import com.tcs.ilp.DAO.MovieImpl;

public class MovieModel {
	MovieImpl mImpl=new MovieImpl(); 
	
	public MovieBean addMovie(String movieName, String Language,String startDate,String endDate, String category, int theaterId,String photo) throws SQLException, FileNotFoundException
	{		
		return mImpl.addMovie(movieName, Language, startDate, endDate, category, theaterId, photo);
	}
	public ArrayList<MovieBean> getTheaterById() {
		return mImpl.getTheaterById();
		// TODO Auto-generated method stub		
	
	}
	public ArrayList<MovieBean> getMovieList() throws SQLException {
		// TODO Auto-generated method stub
		return mImpl.getMovieList();
		
	}
	
	public boolean removeMovie(String movieName, String language) throws SQLException
	{
		return mImpl.removeMovie(movieName, language);
		
	}
	
	public boolean updateMovie(MovieBean mb) throws SQLException,
	ClassNotFoundException
	{
		return mImpl.updatemovie(mb);
		
	}
	public MovieBean viewMovieById(int movieId) throws SQLException
	{
		return mImpl.viewMovieById(movieId);
	}

	
	public int search(String mname, String language) throws SQLException {
		// TODO Auto-generated method stub
		MovieImpl mImpl = new MovieImpl();
		return mImpl.search(mname,language);
	}
	
	public ArrayList<String> search() throws SQLException
	{
		MovieImpl mImpl = new MovieImpl();
		return mImpl.search();
	}
	
	public MovieBean viewMovieByIdForMovie(int movieid) throws SQLException
	{
		MovieImpl mImpl = new MovieImpl();
		return mImpl.viewMovieById(movieid);
		
	}

	public ArrayList<String> category() throws SQLException
	{
		MovieImpl mImpl = new MovieImpl();
		return mImpl.category();
	}
	
	public boolean updateMovieById(String startdate, String enddate, String category,int movieid) throws SQLException
	{
		MovieImpl mImpl = new MovieImpl();
		return mImpl.updateMovieById(startdate, enddate, category, movieid);
	}
	

	public ArrayList<MovieBean> getMovieListByTheater(int theaterId) throws SQLException {
		// TODO Auto-generated method stub
		return mImpl.getMovieListByTheater(theaterId);
		
	}
	
	public ArrayList<String> viewMovieByName() throws SQLException
	{
		return mImpl.viewMovieByName();
			
	}
	
	public ArrayList<String> viewMovieByLanguage()throws SQLException
	{
		return mImpl.viewMovieByLanguage();
	}
	public ArrayList<String> viewMovieByCategory()throws SQLException
	{
		return mImpl.viewMovieByCategory();
	}
	
	public ArrayList<MovieBean> searchMovieByName(String name) throws SQLException
	{
		return mImpl.searchMovieByName(name);
	}
	
	
	public ArrayList<MovieBean> searchMovieByLanguage(String language) throws SQLException
	{
		return mImpl.searchMovieByLanguage(language);
	}
	
	
	public ArrayList<MovieBean> searchMovieByCategory(String category) throws SQLException
	{
		return mImpl.searchMovieByCategory(category);
	}
	
}

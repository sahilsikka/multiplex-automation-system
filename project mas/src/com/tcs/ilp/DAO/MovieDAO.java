package com.tcs.ilp.DAO;

import java.io.FileNotFoundException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import com.tcs.ilp.Bean.MovieBean;

public interface MovieDAO {
	public MovieBean addMovie(String movieName, String Language,String startDate,String endDate, String category, int theaterId,String poster) throws SQLException, FileNotFoundException;
	public boolean removeMovie(String movieName, String language) throws SQLException;
	public ArrayList<MovieBean> getMovieList() throws SQLException;
	public boolean updatemovie(MovieBean mb) throws SQLException;
	public MovieBean viewMovieById(int movieId)throws SQLException;
	public int search(String moviename,String language) throws SQLException;
	public MovieBean viewMovieByIdForMovie(int mid) throws SQLException;
	public ArrayList<String> category() throws SQLException;
	public ArrayList<String> search() throws SQLException;
	public boolean updateMovieById(String startdate, String enddate, String category ,int movieid) throws SQLException;
	public ArrayList<MovieBean> getMovieListByTheater(int theaterId) throws SQLException;
	public ArrayList<String> viewMovieByName()throws SQLException;
	public ArrayList<String> viewMovieByLanguage()throws SQLException;
	public ArrayList<String> viewMovieByCategory()throws SQLException;
	
	//--------------------------search----------------------------
		public ArrayList<MovieBean> searchMovieByName(String name) throws SQLException;
		public ArrayList<MovieBean> searchMovieByLanguage(String language) throws SQLException;
		public ArrayList<MovieBean> searchMovieByCategory(String category) throws SQLException;

}





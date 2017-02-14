package com.tcs.ilp.Bean;

import java.io.InputStream;
import java.sql.Date;

public class MovieBean {

		private long movieId;
		private String movieName;
		private String Language;
		private String category;
		private int theaterId;
		private Date startDate;
		private Date endDate;
		private String status;
		private InputStream poster;
		
		public InputStream getPoster() {
			return poster;
		}
		public void setPoster(InputStream poster) {
			this.poster = poster;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public long getMovieId() {
			return movieId;
		}
		public void setMovieId(long movieId) {
			this.movieId = movieId;
		}
		public String getMovieName() {
			return movieName;
		}
		public void setMovieName(String movieName) {
			this.movieName = movieName;
		}
		public String getLanguage() {
			return Language;
		}
		public void setLanguage(String language) {
			Language = language;
		}
		public String getCategory() {
			return category;
		}
		public void setCategory(String category) {
			this.category = category;
		}
		public int getTheaterId() {
			return theaterId;
		}
		public void setTheaterId(int theaterId) {
			this.theaterId = theaterId;
		}
		public Date getStartDate() {
			return startDate;
		}
		public void setStartDate(Date startDate) {
			this.startDate = startDate;
		}
		public Date getEndDate() {
			return endDate;
		}
		public void setEndDate(Date endDate) {
			this.endDate = endDate;
		}
}

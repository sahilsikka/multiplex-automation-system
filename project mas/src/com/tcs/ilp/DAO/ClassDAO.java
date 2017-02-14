package com.tcs.ilp.DAO;

import java.sql.SQLException;

import com.tcs.ilp.Bean.ClassBean;

public interface ClassDAO {
	public ClassBean addClassSilver(Long screenId,int price,int totalseats, int showid) throws SQLException;
	public ClassBean addClassGold(Long screenId,int price,int totalseats,int showid) throws SQLException;
	public boolean updateSilverClass(int classId, int showId) throws SQLException;
	public int getPriceByClassId(int classId,int showid) throws SQLException;
	public int getSeatsByClassId(int classId,int showid) throws SQLException;
	public boolean updateRemainingSeats(int seatsBooked,int classId, int showId) throws SQLException;
	public int getRemainingSeatsById(int classId, int showId) throws SQLException;
	public int getTotalSeatsById(int classId, int showId) throws SQLException;
	public Boolean updateGoldClass(int classId, int showId) throws SQLException;
}

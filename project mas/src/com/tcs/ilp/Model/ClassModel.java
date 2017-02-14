package com.tcs.ilp.Model;

import java.sql.SQLException;
import java.util.ArrayList;

import com.tcs.ilp.Bean.ClassBean;
import com.tcs.ilp.DAO.ClassImpl;

public class ClassModel {
	ClassImpl cImpl=new ClassImpl();
	
	public ClassBean addClassSilver(Long screenId, int i,int totalseats,int showid) throws SQLException {
		// TODO Auto-generated method stub
		return cImpl.addClassSilver(screenId,i,totalseats,showid);
	}
	
	public ClassBean addClassGold(Long screenId, int i,int totalseats, int showid) throws SQLException {
		// TODO Auto-generated method stub
		return cImpl.addClassGold(screenId,i,totalseats,showid);
	}

	public Boolean updateSilverClass(int classId, int showId) throws SQLException {
		// TODO Auto-generated method stub
		return cImpl.updateSilverClass(classId,showId);
	}
	
	public Boolean updateGoldClass(int classId, int showId) throws SQLException {
		// TODO Auto-generated method stub
		return cImpl.updateGoldClass(classId,showId);
	}

	public ArrayList<ClassBean> getClassByShow(int showId) throws SQLException {
		// TODO Auto-generated method stub
		return cImpl.getClassByShow(showId);
	}
	
	public int getPriceByClassId(int classId, int showId) throws SQLException
	{
		return cImpl.getPriceByClassId(classId,showId);
	}

	public int getSeatsByClassId(int classId, int showId) throws SQLException {
		// TODO Auto-generated method stub
		return cImpl.getSeatsByClassId(classId,showId);
		
	}

	public boolean updateRemainingSeats(int seatsBooked,int classId, int showId) throws SQLException {
		// TODO Auto-generated method stub
		return cImpl.updateRemainingSeats(seatsBooked, classId,showId);
		
	}

	public int getTotalSeatsById(int classId, int showId) throws SQLException {
		// TODO Auto-generated method stub
		return cImpl.getTotalSeatsById(classId, showId);
	}

	public int getReainingSeatsById(int classId, int showId) throws SQLException {
		// TODO Auto-generated method stub
		return cImpl.getRemainingSeatsById(classId, showId);
	}
}

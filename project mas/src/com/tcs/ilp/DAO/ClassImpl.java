package com.tcs.ilp.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.tcs.ilp.Bean.ClassBean;
import com.tcs.ilp.util.DatabaseUtil;

public class ClassImpl implements ClassDAO {

	Connection con=null;
	PreparedStatement ps=null;
	int rowsAffected=0;
	ResultSet resultSet=null;
	ClassBean cBean=null;

	public ClassBean addClassSilver(Long screenId, int price,int totalseats,int showid) throws SQLException {
		// TODO Auto-generated method stub
		con=DatabaseUtil.getConnection();
		ps=con.prepareStatement("insert into class_team5 values(classid_seq.nextVal,'silver',?,?,?,?,?)");

		ps.setLong(1, screenId);
		ps.setLong(2,price);
		ps.setInt(4, totalseats);
		ps.setInt(3, showid);
		ps.setInt(5, totalseats);


		rowsAffected=ps.executeUpdate();
		if(rowsAffected>0)
		{
			ps=con.prepareStatement("select * from class_team5 where screenid=? and price=? and totalseats=? and showid=? and classname='silver'");
			ps.setLong(1, screenId);
			ps.setLong(2,price);
			ps.setInt(3, totalseats);
			ps.setInt(4, showid);
			
			ResultSet rs=ps.executeQuery();

			while(rs.next())
			{
				cBean= new ClassBean();
				cBean.setClassId(rs.getInt(1));
				cBean.setClassName(rs.getString(2));
				cBean.setScreenId(rs.getInt(3));
				cBean.setPrice(rs.getInt(4));		

				DatabaseUtil.closeStatement(ps);
				DatabaseUtil.closeConnection(con);
				return cBean;				
			}			
		}

		return null;


	}

	public ClassBean addClassGold(Long screenId,int price,int totalseats,int showid) throws SQLException {
		// TODO Auto-generated method stub
		con=DatabaseUtil.getConnection();
		ps=con.prepareStatement("insert into class_team5 values(classid_seq.nextVal,'gold',?,?,?,?,?)");

		ps.setLong(1, screenId);
		ps.setLong(2, price);
		ps.setInt(4, totalseats);
		ps.setInt(3, showid);
		ps.setInt(5, totalseats);
		
		rowsAffected=ps.executeUpdate();
		if(rowsAffected>0)
		{
			ps=con.prepareStatement("select * from class_team5 where screenid=? and price=? and totalseats=? and showid=? and classname='gold'");
			ps.setLong(1, screenId);
			ps.setLong(2,price);
			ps.setInt(3, totalseats);
			ps.setInt(4, showid);
			ResultSet rs=ps.executeQuery();

			while(rs.next())
			{
				cBean= new ClassBean();
				cBean.setClassId(rs.getInt(1));
				cBean.setClassName(rs.getString(2));
				cBean.setScreenId(rs.getInt(3));

				DatabaseUtil.closeStatement(ps);
				DatabaseUtil.closeConnection(con);
				return cBean;				
			}			
		}

		return null;

	}

	public boolean updateSilverClass(int classId, int showId) throws SQLException {
		// TODO Auto-generated method stub
		con=DatabaseUtil.getConnection();
		System.out.println("clasid and showid"+classId+" "+showId);
		ps=con.prepareStatement("update class_team5 set showid=? where classid=?");
		
		ps.setInt(1,showId);
		ps.setInt(2, classId);
		System.out.println("");
		rowsAffected=ps.executeUpdate();
		
		DatabaseUtil.closeStatement(ps);
		DatabaseUtil.closeConnection(con);
		
		if(rowsAffected>0)		
			return true;
		else
			return false;
	}

	public Boolean updateGoldClass(int classId, int showId) throws SQLException {
		// TODO Auto-generated method stub
		con=DatabaseUtil.getConnection();
		ps=con.prepareStatement("update class_team5 set showid=? where classid=?");
		
		ps.setInt(1,showId);
		ps.setInt(2, classId);
		
		rowsAffected=ps.executeUpdate();
		
		DatabaseUtil.closeStatement(ps);
		DatabaseUtil.closeConnection(con);
		
		if(rowsAffected>0)		
			return true;
		else
			return false;
	}

	public ArrayList<ClassBean> getClassByShow(int showId) throws SQLException {
		// TODO Auto-generated method stub
		ClassBean cBean=new ClassBean();
		ArrayList<ClassBean> cList=new ArrayList<ClassBean>();
		
		con=DatabaseUtil.getConnection();
		ps=con.prepareStatement("select * from class_team5 where showid=?");
		
		ps.setInt(1, showId);	
		resultSet=ps.executeQuery();
		
		
		while(resultSet.next())
		{
			cBean= new ClassBean();
			cBean.setClassId(resultSet.getInt(1));
			cBean.setClassName(resultSet.getString(2));
			cBean.setScreenId(resultSet.getInt(3));
			cBean.setPrice(resultSet.getInt(4));
			cList.add(cBean);
		}
		
		DatabaseUtil.closeStatement(ps);
		DatabaseUtil.closeConnection(con);
		return cList;
	}

	public int getPriceByClassId(int classId, int showId) throws SQLException {
		// TODO Auto-generated method stub
		con=DatabaseUtil.getConnection();
		ps=con.prepareStatement("select price from class_team5 where classid=? and showid=?");
		ps.setInt(1, classId);
		ps.setInt(2, showId);
		resultSet=ps.executeQuery();
		
		resultSet.next();int val=resultSet.getInt(1);
		System.out.println("resultset "+resultSet.getInt(1));
		DatabaseUtil.closeStatement(ps);
		DatabaseUtil.closeConnection(con);

		return val;
	}

	public int getSeatsByClassId(int classId, int showId) throws SQLException {
		// TODO Auto-generated method stub
		con=DatabaseUtil.getConnection();
		ps=con.prepareStatement("select remainingseats from class_team5 where classid=? and showid=?");
		ps.setInt(1, classId);
		ps.setInt(2, showId);
		resultSet=ps.executeQuery();
		resultSet.next();
		int val=resultSet.getInt(1);
		DatabaseUtil.closeStatement(ps);
		DatabaseUtil.closeConnection(con);

		return val;

	}

	public boolean updateRemainingSeats(int seatsBooked,int classId, int showId) throws SQLException {
		// TODO Auto-generated method stub
		con=DatabaseUtil.getConnection();
		ps=con.prepareStatement("update class_team5 set remainingseats=remainingseats-? where classid=? and showid=?");
		ps.setInt(1, seatsBooked);
		ps.setInt(2, classId);
		ps.setInt(3, showId);
		rowsAffected=ps.executeUpdate();
		
		DatabaseUtil.closeStatement(ps);
		DatabaseUtil.closeConnection(con);
		
		if(rowsAffected>0)
			return true;
		else
			return false;
		
	}

	public int getTotalSeatsById(int classId, int showId) throws SQLException {
		// TODO Auto-generated method stub
		con=DatabaseUtil.getConnection();
		ps=con.prepareStatement("select totalseats from class_team5 where classid=? and showid=?");
		ps.setInt(1, classId);
		ps.setInt(2, showId);
		resultSet=ps.executeQuery();
		resultSet.next();
		int totalseats=resultSet.getInt(1);
		
		DatabaseUtil.closeStatement(ps);
		DatabaseUtil.closeConnection(con);
		return totalseats;
		
	}

	public int getRemainingSeatsById(int classId, int showId) throws SQLException {
		// TODO Auto-generated method stub
		con=DatabaseUtil.getConnection();
		ps=con.prepareStatement("select remainingseats from class_team5 where classid=? and showid=?");
		ps.setInt(1, classId);
		ps.setInt(2, showId);
		resultSet=ps.executeQuery();
		resultSet.next();
		int remainingseats=resultSet.getInt(1);
		
		DatabaseUtil.closeStatement(ps);
		DatabaseUtil.closeConnection(con);
		return remainingseats;
	}

	
}



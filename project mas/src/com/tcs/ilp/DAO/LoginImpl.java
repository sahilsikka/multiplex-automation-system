package com.tcs.ilp.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tcs.ilp.Bean.LoginBean;
import com.tcs.ilp.util.DatabaseUtil;

public class LoginImpl {
	public boolean authenticateLogin(LoginBean l) {

		Connection con= null;
		PreparedStatement ps= null;
		ResultSet result=null;
		try {
			con = DatabaseUtil.getConnection();
			ps=con.prepareStatement("select * from Login_Team5 where loginid=? and password=? and Status='active'");
			ps.setString(1, l.getEmailId());
			ps.setString(2, l.getPassword());

			result=ps.executeQuery();

			if(result.next())
			{
				System.out.println("in resultset");
				com.tcs.ilp.util.DatabaseUtil.closeStatement(ps);
				com.tcs.ilp.util.DatabaseUtil.closeConnection(con);
				return Boolean.TRUE;
			}

		}
		catch(Exception e){}
		finally
		{

		}
		return Boolean.FALSE;
	}

	public String getRoleById(LoginBean l) throws SQLException {

		Connection con= null;
		PreparedStatement ps= null;
		ResultSet result=null;
		String role=null;
		con=DatabaseUtil.getConnection();
		ps=con.prepareStatement("select usertype from Login_Team5 where loginid=? and password=? and Status='active'");
		System.out.println(l.getEmailId());
		ps.setString(1, l.getEmailId());
		ps.setString(2, l.getPassword());
		
		result=ps.executeQuery();
		while(result.next())
		{
		System.out.println(result.getString(1));
		
		 role=result.getString(1);		
		}
		if(role!=null)
		{
			DatabaseUtil.closeStatement(ps);
			DatabaseUtil.closeConnection(con);
			
		}
		return role;
	}
}
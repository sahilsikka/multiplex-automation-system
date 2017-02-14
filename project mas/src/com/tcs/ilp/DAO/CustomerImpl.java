package com.tcs.ilp.DAO;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.tcs.ilp.Bean.CustomerBean;
import com.tcs.ilp.util.DatabaseUtil;

public class CustomerImpl implements CustomerDAO {

	Connection con=null;
	PreparedStatement ps=null;
	int rowsAffected=0;
	ResultSet resultSet;
	public boolean registerCustomer(CustomerBean bean) throws SQLException {
		con=DatabaseUtil.getConnection();
		System.out.println("bean is "+bean.getEmailId());
		ps=con.prepareStatement("insert into reg_841975 values(?,?,?,?,?,?,?,?,?,customerId_seq.NEXTVAL,'active')");
		
		ps.setString(1,bean.getFirstName());
		ps.setString(2,bean.getLastName());
		ps.setString(3,bean.getDob());
		ps.setString(4,bean.getGender());
		ps.setString(5,bean.getPhone());
		ps.setString(6,bean.getCity());
		ps.setString(7,bean.getLocation());
		ps.setString(8,bean.getEmailId());
		ps.setString(9,bean.getPassword());
		rowsAffected=ps.executeUpdate();
		
		if(rowsAffected>0)
		{
			ps=con.prepareStatement("insert into LOGIN_TEAM5  values(?,?,'user','active')");
			
			ps.setString(1, bean.getEmailId() );
			ps.setString(2, bean.getPassword() );
		
				rowsAffected=ps.executeUpdate();
				
				if(rowsAffected>0){
			DatabaseUtil.closeStatement(ps);
			DatabaseUtil.closeConnection(con);
			return true;
		}
	}
		DatabaseUtil.closeStatement(ps);
		DatabaseUtil.closeConnection(con);
	
		return false;
	}

	
	public ArrayList<CustomerBean> viewAll() throws SQLException {
		ArrayList<CustomerBean> cList=new ArrayList<>();
		CustomerBean cBean=null;
		con=DatabaseUtil.getConnection();
		ps=con.prepareStatement("select * from reg_841975");
		ResultSet result=ps.executeQuery();
		
		while(result.next())
		{
			cBean=new CustomerBean();
		cBean.setFirstName(result.getString(1));
			cBean.setLastName(result.getString(2));
			cBean.setDob(result.getString(3));
			cBean.setGender(result.getString(4));
			cBean.setPhone(result.getString(5));
			cBean.setCity(result.getString(6));
			cBean.setLocation(result.getString(7));
			cBean.setEmailId(result.getString(8));
			cBean.setPassword(result.getString(9));
			cList.add(cBean);
		}
		
		DatabaseUtil.closeStatement(ps);
		DatabaseUtil.closeConnection(con);
		return cList;	
	}
	public CustomerBean viewbyCustomerByEmail(String emailid)
			throws SQLException {
		CustomerBean cBean=null;
		con=DatabaseUtil.getConnection();
		ps=con.prepareStatement("select * from reg_841975 where emailid=?");
		ps.setString(1, emailid);
		ResultSet result=ps.executeQuery();
		if(result.next())
		{
			cBean=new CustomerBean();
			
			cBean.setFirstName(result.getString(1));
			cBean.setLastName(result.getString(2));
			cBean.setDob(result.getString(3));
			cBean.setGender(result.getString(4));
			cBean.setPhone(result.getString(5));
			cBean.setCity(result.getString(6));
			cBean.setLocation(result.getString(7));
		
		}
		DatabaseUtil.closeStatement(ps);
		DatabaseUtil.closeConnection(con);
		return cBean;
	}
	
	public boolean DeleteUser(String emailid) throws SQLException {
		con=DatabaseUtil.getConnection();
		ps=con.prepareStatement("update reg_841975 set Status=? where emailid=?");
		ps.setString(1,"deactivate");
	//	ps.setString(2,reason);
		ps.setString(2, emailid);		
		rowsAffected=ps.executeUpdate();
		if(rowsAffected>0)
		{

			ps=con.prepareStatement("update LOGIN_TEAM5 set Status=? where loginid=?");

			ps.setString(1,"deactivate");		
			ps.setString(2, emailid);	
			rowsAffected=ps.executeUpdate();

			if(rowsAffected>0){
				DatabaseUtil.closeStatement(ps);
				DatabaseUtil.closeConnection(con);
				return Boolean.TRUE;
			}		

		}
		return false;
	}


	@Override
	public boolean  updateUser(CustomerBean cBean,String emailid) throws SQLException {

		con=DatabaseUtil.getConnection();
		System.out.println("hjgj "+emailid);

		ps=con.prepareStatement("update reg_841975 set firstname=?,lastname=?,dob=?,gender=?,phone=?,city=?,location=?,status=? where emailid=?");
		ps.setString(1,cBean.getFirstName());		
		ps.setString(2,cBean.getLastName());	
		ps.setString(3,cBean.getDob());	
		ps.setString(4,cBean.getGender());	
		ps.setString(5,cBean.getPhone());
		ps.setString(6,cBean.getCity());
		ps.setString(7,cBean.getLocation());
		/*ps.setString(8,cBean.getPassword());*/
		ps.setString(8,"active");	
		ps.setString(9, emailid);	
		rowsAffected=ps.executeUpdate();

	
		//			
		//	ps=con.prepareStatement("update LOGIN_TEAM5 set password=? where loginid=?");
		//		
		//	ps.setString(1,cBean.getPassword());		
		//	ps.setString(2, emailid);	
		//	rowsAffected=ps.executeUpdate();

		if(rowsAffected>0){
			DatabaseUtil.closeStatement(ps);
			DatabaseUtil.closeConnection(con);
			return Boolean.TRUE;
		}		

		return Boolean.FALSE;
	}
	//----------------------------admin part---------------------------
	public ArrayList<CustomerBean> viewAllCustomer() throws SQLException {
		// TODO Auto-generated method stub
		
		CustomerBean cBean;
		ArrayList<CustomerBean> cList=new ArrayList<CustomerBean>();
		System.out.println("before select");
		con=DatabaseUtil.getConnection();
		PreparedStatement ps1=con.prepareStatement("select * from reg_841975");

		System.out.println("after select");

		resultSet=ps1.executeQuery();

		while(resultSet.next())
		{
			System.out.println("added");
			cBean=new CustomerBean();
			System.out.println("added...");
			//cBean.setCustomerId(resultSet.getInt(10));
			cBean.setEmailId(resultSet.getString(8));
			cBean.setPhone(resultSet.getString(5));
			cBean.setFirstName(resultSet.getString(1));
			cBean.setLastName(resultSet.getString(2));
			cBean.setDob(resultSet.getString(3));
			cBean.setPassword(resultSet.getString(9));
			cBean.setGender(resultSet.getString(4));
			cBean.setCity(resultSet.getString(6));
			cBean.setLocation(resultSet.getString(7));
			cBean.setDeactivation(resultSet.getString(11));
			cList.add(cBean);
			System.out.println("hello");
		}
		DatabaseUtil.closeStatement(ps);
		DatabaseUtil.closeConnection(con);

		if(!cList.isEmpty())
		{
			System.out.println("not empty");
			return cList;
		}
		else
			return null;
	}

	@Override
	public CustomerBean deactivateCustomer(String emailid, String status) throws SQLException {
		// TODO Auto-generated method stub
		
		CustomerBean cBean=new CustomerBean();
		System.out.println("hi");
		con=DatabaseUtil.getConnection();
		ps=con.prepareStatement("update reg_841975 set status=? where emailid=? ");
		ps.setString(1, status);
		ps.setString(2, emailid);
		
		
		cBean.setDeactivation(status);
		cBean.setEmailId(emailid);
		
		rowsAffected=ps.executeUpdate();
			if(rowsAffected>0)	
			{
				ps=con.prepareStatement("update LOGIN_TEAM5 set Status=? where loginid=?");

				ps.setString(1,status);		
				ps.setString(2, emailid);	
				rowsAffected=ps.executeUpdate();
				if(rowsAffected>0){
					DatabaseUtil.closeStatement(ps);
					DatabaseUtil.closeConnection(con);
					return cBean;
				}		
				
				
			}
			
		
		DatabaseUtil.closeStatement(ps);
		DatabaseUtil.closeConnection(con);
		return cBean;
	}

	@Override
	public CustomerBean viewbyemailId(String emailId) throws SQLException {
		// TODO Auto-generated method stubShowBean sBean=null;
		con=DatabaseUtil.getConnection();
		CustomerBean cBean=null;
		ps=con.prepareStatement("select * from reg_841975 where emailid=?");
		System.out.println(emailId);
		ps.setString(1, emailId);
		ResultSet result=ps.executeQuery();
		while(result.next())
		{
			 cBean=new CustomerBean();
			cBean.setEmailId(result.getString(8));
			cBean.setPhone(result.getString(5));
			cBean.setFirstName(result.getString(1));
			cBean.setLastName(result.getString(2));
			cBean.setDob(result.getString(3));
			cBean.setPassword(result.getString(9));
			cBean.setGender(result.getString(4));
			cBean.setCity(result.getString(6));
			cBean.setLocation(result.getString(7));
			cBean.setDeactivation(result.getString(11));
			
		}
		DatabaseUtil.closeStatement(ps);
		DatabaseUtil.closeConnection(con);
		return cBean;
	}

	public ArrayList<CustomerBean> viewCustomerByName(String name) throws SQLException {
		// TODO Auto-generated method stub
		con=DatabaseUtil.getConnection();
		CustomerBean cBean=null;
		ArrayList<CustomerBean> cList=new ArrayList<CustomerBean>();
		ps=con.prepareStatement("select * from reg_841975 where firstname like ? ");
		ps.setString(1, "%" + name + "%");
		System.out.println(name);
		ResultSet result=ps.executeQuery();
		while(result.next())
		{
			cBean=new CustomerBean();
			cBean.setEmailId(result.getString(8));
			cBean.setPhone(result.getString(5));
			cBean.setFirstName(result.getString(1));
			cBean.setLastName(result.getString(2));
			cBean.setDob(result.getString(3));
			cBean.setPassword(result.getString(9));
			cBean.setGender(result.getString(4));
			cBean.setCity(result.getString(6));
			cBean.setLocation(result.getString(7));
			cBean.setDeactivation(result.getString(11));
			cList.add(cBean);
			
		}
		DatabaseUtil.closeStatement(ps);
		DatabaseUtil.closeConnection(con);
		return cList;
	}
	
	public ArrayList<CustomerBean> viewCustomerBycity(String city)
			throws SQLException {
		// TODO Auto-generated method stub
		con=DatabaseUtil.getConnection();
		CustomerBean cBean=null;
		ArrayList<CustomerBean> cList=new ArrayList<CustomerBean>();
		ps=con.prepareStatement("select * from reg_841975 where city like ? ");
		ps.setString(1, "%" + city + "%");
		System.out.println(city);
		ResultSet result=ps.executeQuery();
		while(result.next())
		{
			cBean=new CustomerBean();
			cBean.setEmailId(result.getString(8));
			cBean.setPhone(result.getString(5));
			cBean.setFirstName(result.getString(1));
			cBean.setLastName(result.getString(2));
			cBean.setDob(result.getString(3));
			cBean.setPassword(result.getString(9));
			cBean.setGender(result.getString(4));
			cBean.setCity(result.getString(6));
			cBean.setLocation(result.getString(7));
			cBean.setDeactivation(result.getString(11));
			cList.add(cBean);
			
		}
		DatabaseUtil.closeStatement(ps);
		DatabaseUtil.closeConnection(con);
		return cList;
	}


	@Override
	public ArrayList<CustomerBean> viewCustomerByGender(String Gender)
			throws SQLException {
		// TODO Auto-generated method stub
		con=DatabaseUtil.getConnection();
		CustomerBean cBean=null;
		ArrayList<CustomerBean> cList=new ArrayList<CustomerBean>();
		ps=con.prepareStatement("select * from reg_841975 where gender like ? ");
		ps.setString(1, "%" + Gender + "%");
		System.out.println(Gender);
		ResultSet result=ps.executeQuery();
		while(result.next())
		{
			cBean=new CustomerBean();
			cBean.setEmailId(result.getString(8));
			cBean.setPhone(result.getString(5));
			cBean.setFirstName(result.getString(1));
			cBean.setLastName(result.getString(2));
			cBean.setDob(result.getString(3));
			cBean.setPassword(result.getString(9));
			cBean.setGender(result.getString(4));
			cBean.setCity(result.getString(6));
			cBean.setLocation(result.getString(7));
			cBean.setDeactivation(result.getString(11));
			cList.add(cBean);
			
		}
		DatabaseUtil.closeStatement(ps);
		DatabaseUtil.closeConnection(con);
		return cList;
	}


	@Override
	public ArrayList<CustomerBean> viewCustomerByPhn(String phn)
			throws SQLException {
		// TODO Auto-generated method stub
		con=DatabaseUtil.getConnection();
		CustomerBean cBean=null;
		ArrayList<CustomerBean> cList=new ArrayList<CustomerBean>();
		ps=con.prepareStatement("select * from reg_841975 where phone like ? ");
		ps.setString(1, "%" + phn + "%");
		System.out.println(phn);
		ResultSet result=ps.executeQuery();
		while(result.next())
		{
			cBean=new CustomerBean();
			cBean.setEmailId(result.getString(8));
			cBean.setPhone(result.getString(5));
			cBean.setFirstName(result.getString(1));
			cBean.setLastName(result.getString(2));
			cBean.setDob(result.getString(3));
			cBean.setPassword(result.getString(9));
			cBean.setGender(result.getString(4));
			cBean.setCity(result.getString(6));
			cBean.setLocation(result.getString(7));
			cBean.setDeactivation(result.getString(11));
			cList.add(cBean);
			
		}
		DatabaseUtil.closeStatement(ps);
		DatabaseUtil.closeConnection(con);
		return cList;
	}


	@Override
	public ArrayList<CustomerBean> viewCustomerByEmail(String email)
			throws SQLException {
		// TODO Auto-generated method stub
		con=DatabaseUtil.getConnection();
		CustomerBean cBean=null;
		ArrayList<CustomerBean> cList=new ArrayList<CustomerBean>();
		ps=con.prepareStatement("select * from reg_841975 where emailid like ? ");
		ps.setString(1, "%" + email + "%");
		System.out.println(email);
		ResultSet result=ps.executeQuery();
		while(result.next())
		{
			cBean=new CustomerBean();
			cBean.setEmailId(result.getString(8));
			cBean.setPhone(result.getString(5));
			cBean.setFirstName(result.getString(1));
			cBean.setLastName(result.getString(2));
			cBean.setDob(result.getString(3));
			cBean.setPassword(result.getString(9));
			cBean.setGender(result.getString(4));
			cBean.setCity(result.getString(6));
			cBean.setLocation(result.getString(7));
			cBean.setDeactivation(result.getString(11));
			cList.add(cBean);
			
		}
		DatabaseUtil.closeStatement(ps);
		DatabaseUtil.closeConnection(con);
		return cList;
	}


	@Override
	public ArrayList<CustomerBean> viewCustomerByStatus(String status)
			throws SQLException {
		// TODO Auto-generated method stub
		con=DatabaseUtil.getConnection();
		CustomerBean cBean=null;
		ArrayList<CustomerBean> cList=new ArrayList<CustomerBean>();
		ps=con.prepareStatement("select * from reg_841975 where status like ? ");
		ps.setString(1, "%" + status + "%");
		System.out.println(status);
		ResultSet result=ps.executeQuery();
		while(result.next())
		{
			cBean=new CustomerBean();
			cBean.setEmailId(result.getString(8));
			cBean.setPhone(result.getString(5));
			cBean.setFirstName(result.getString(1));
			cBean.setLastName(result.getString(2));
			cBean.setDob(result.getString(3));
			cBean.setPassword(result.getString(9));
			cBean.setGender(result.getString(4));
			cBean.setCity(result.getString(6));
			cBean.setLocation(result.getString(7));
			cBean.setDeactivation(result.getString(11));
			cList.add(cBean);
			
		}
		DatabaseUtil.closeStatement(ps);
		DatabaseUtil.closeConnection(con);
		return cList;
	}


	@Override
	public ArrayList<CustomerBean> viewCustomerByDob(String dob)
			throws SQLException {
		// TODO Auto-generated method stub
		con=DatabaseUtil.getConnection();
		CustomerBean cBean=null;
		ArrayList<CustomerBean> cList=new ArrayList<CustomerBean>();
		ps=con.prepareStatement("select * from reg_841975 where dob like ? ");
		ps.setString(1, "%" + dob + "%");
		System.out.println(dob);
		ResultSet result=ps.executeQuery();
		while(result.next())
		{
			cBean=new CustomerBean();
			cBean.setEmailId(result.getString(8));
			cBean.setPhone(result.getString(5));
			cBean.setFirstName(result.getString(1));
			cBean.setLastName(result.getString(2));
			cBean.setDob(result.getString(3));
			cBean.setPassword(result.getString(9));
			cBean.setGender(result.getString(4));
			cBean.setCity(result.getString(6));
			cBean.setLocation(result.getString(7));
			cBean.setDeactivation(result.getString(11));
			cList.add(cBean);
			
		}
		DatabaseUtil.closeStatement(ps);
		DatabaseUtil.closeConnection(con);
		return cList;
	}
	
	}



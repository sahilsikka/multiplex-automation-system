package com.tcs.ilp.Model;

import java.sql.SQLException;
import java.util.ArrayList;

import com.tcs.ilp.Bean.CustomerBean;

import com.tcs.ilp.DAO.CustomerImpl;

public class CustomerModel {
	 CustomerImpl impl=new  CustomerImpl ();
	 public boolean registerCustomer(CustomerBean bean) throws SQLException{
		return impl.registerCustomer(bean);
		 }
	 public ArrayList<CustomerBean> viewAll() throws SQLException{
			return impl.viewAll();
	 }
	 public CustomerBean viewbyCustomerByEmail(String emailid)throws SQLException 
		{
		return impl.viewbyCustomerByEmail(emailid);
		}
	
	 public boolean DeleteUser(String emailid) throws ClassNotFoundException,
		SQLException {
			return impl.DeleteUser(emailid);
		}
	 public boolean updateUser(CustomerBean cBean,String emailid) throws ClassNotFoundException,
		SQLException {
			return impl.updateUser(cBean, emailid);
		}
	 public ArrayList<CustomerBean> viewAllCustomer() throws SQLException
		{
			return impl.viewAllCustomer();
		}
		public CustomerBean deactivateCustomer(String emailid, String status) throws SQLException 
		{
			return impl.deactivateCustomer(emailid, status);
		}
		
		public CustomerBean viewbyemailId(String emailId) throws SQLException 
		{
			return impl.viewbyemailId(emailId);
		}
		
		
		public ArrayList<CustomerBean> viewCustomerByName(String name) throws SQLException {
			return impl.viewCustomerByName(name);
		}
		
		public ArrayList<CustomerBean> viewCustomerBycity(String city)
				throws SQLException {
			return impl.viewCustomerBycity(city);
		}
		
		public ArrayList<CustomerBean> viewCustomerByGender(String Gender) throws SQLException
		{
			return impl.viewCustomerByGender(Gender);
		}
		public ArrayList<CustomerBean> viewCustomerByPhn(String phn) throws SQLException
		{
			return impl.viewCustomerByPhn(phn);
		}
		public ArrayList<CustomerBean> viewCustomerByEmail(String email) throws SQLException
		{
			return impl.viewCustomerByEmail(email);
		}
		public ArrayList<CustomerBean> viewCustomerByStatus(String status) throws SQLException
		{
			return impl.viewCustomerByStatus(status);
		}
		public ArrayList<CustomerBean> viewCustomerByDob(String dob) throws SQLException
		{
			return impl.viewCustomerByDob(dob);
		}

}

package com.tcs.ilp.DAO;


import java.sql.SQLException;

import java.util.ArrayList;

import com.tcs.ilp.Bean.CustomerBean;

public interface CustomerDAO {
	
	public boolean registerCustomer(CustomerBean bean) throws SQLException;
	public ArrayList<CustomerBean> viewAll() throws SQLException;
	public CustomerBean viewbyCustomerByEmail(String emailid)throws SQLException;
	public boolean DeleteUser(String emailid) throws SQLException;
	public boolean updateUser(CustomerBean cBean,String emailid) throws SQLException;
	
	//----------------------admin part-----------------------------
	public ArrayList<CustomerBean> viewAllCustomer() throws SQLException;
	public CustomerBean deactivateCustomer(String emailid,String status) throws SQLException;
	public CustomerBean viewbyemailId(String emailId)throws SQLException;
	public ArrayList<CustomerBean> viewCustomerByName(String name) throws SQLException;
	public ArrayList<CustomerBean> viewCustomerBycity(String city) throws SQLException;
	public ArrayList<CustomerBean> viewCustomerByGender(String Gender) throws SQLException;
	public ArrayList<CustomerBean> viewCustomerByPhn(String phn) throws SQLException;
	public ArrayList<CustomerBean> viewCustomerByEmail(String email) throws SQLException;
	public ArrayList<CustomerBean> viewCustomerByStatus(String status) throws SQLException;
	public ArrayList<CustomerBean> viewCustomerByDob(String dob) throws SQLException;

	
}

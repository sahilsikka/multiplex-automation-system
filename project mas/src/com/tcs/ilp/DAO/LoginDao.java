package com.tcs.ilp.DAO;

import java.sql.SQLException;

import com.tcs.ilp.Bean.LoginBean;

public interface LoginDao {
	public boolean authenticateLogin(LoginBean l) throws SQLException;

}

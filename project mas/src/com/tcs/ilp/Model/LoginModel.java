package com.tcs.ilp.Model;

import java.sql.SQLException;

import com.tcs.ilp.Bean.LoginBean;
import com.tcs.ilp.DAO.LoginImpl;

public class LoginModel {

	LoginImpl lImpl= new LoginImpl();
	
	public boolean authenticateLogin(LoginBean l)throws SQLException
	{
        return lImpl.authenticateLogin(l);
    }

	public String getRoleById(LoginBean lBean) throws SQLException {
		// TODO Auto-generated method stub
		return lImpl.getRoleById(lBean);
	}
}

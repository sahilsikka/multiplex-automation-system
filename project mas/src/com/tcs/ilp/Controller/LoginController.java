package com.tcs.ilp.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tcs.ilp.Bean.LoginBean;
import com.tcs.ilp.Model.LoginModel;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String requestSource=request.getParameter("source");
		if(requestSource.equals("login")){
			RequestDispatcher rd = request.getRequestDispatcher("JSP/login.jsp");
			rd.forward(request, response);}
		if(requestSource.equals("logout")){
			
	        //invalidate the session if exists
	        HttpSession session = request.getSession(false);
	        System.out.println("Role="+session.getAttribute("role"));
	        if(session != null){
	        	
	            session.invalidate();
	        }
	        
	        //no encoding because we have invalidated the session
	        
	      RequestDispatcher  disp = request.getRequestDispatcher("JSP/login.jsp");
	        disp.forward(request, response);
	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String requestSource=request.getParameter("source");
		RequestDispatcher redip=null;
		PrintWriter out=response.getWriter();
		LoginBean lBean=new LoginBean();
		
	LoginModel lModel=new LoginModel();
	if(requestSource.equals("loginac"))
	{	
	boolean flag;
	try {
		
		String emailId=request.getParameter("id");
		String Password=request.getParameter("password");
		

		lBean.setEmailId(emailId);
		lBean.setPassword(Password);
	
		
		flag = lModel.authenticateLogin(lBean);
		String role =lModel.getRoleById(lBean); 
		
		System.out.println("flag is"+flag);
			if(flag)
			{ 				
				 HttpSession session = request.getSession();
				  session.setAttribute("user",emailId);
				  session.setAttribute("role", role);							         
				 //setting session to expiry in 30 mins
				 session.setMaxInactiveInterval(30*60);
				/* Cookie userName = new Cookie("user",emailId);
				 userName.setMaxAge(30*60);
				    response.addCookie(userName);	*/
				if(role.equalsIgnoreCase("user"))
				  {redip=request.getRequestDispatcher("JSP/loginsuccess.jsp");
				redip.forward(request, response);}
				else if(role.equalsIgnoreCase("admin"))
				{
					redip=request.getRequestDispatcher("JSP/adminDashBoard.jsp");				
					redip.forward(request, response);
				}				
			}
			else
			{
			/*	response.setContentType("text/html");
			*/	
			//
				
				request.setAttribute("msg", "Login Failed... user id or password is incorrect");
				//out.println("Login Failed... user id or password is incorrect");
				redip=request.getRequestDispatcher("JSP/login.jsp");
				redip.include(request, response);
				
			}
			
			
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
		/*if(status)
		{
		    HttpSession session = request.getSession(true);	    
	          session.setAttribute("userId",lBean);      
			 redip=request.getRequestDispatcher("JSP/index.jsp");
			 redip.forward(request, response);
	 
		}
		
		 if(requestSource.equals("logout"))
		 {
			 redip=request.getRequestDispatcher("JSP/logout.jsp");
			 redip.forward(request, response);
			 
		 }
		*/	
	} }
}

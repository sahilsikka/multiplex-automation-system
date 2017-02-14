package com.tcs.ilp.Controller;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tcs.ilp.Bean.CustomerBean;
import com.tcs.ilp.Model.CustomerModel;

/**
 * Servlet implementation class CustomerContrller
 */
public class CustomerContrller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerContrller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String requestSource=request.getParameter("source");
		PrintWriter out=response.getWriter();
		RequestDispatcher rd=null;
		
		CustomerModel model=new CustomerModel();
		CustomerBean cBean=new CustomerBean();
		if(requestSource.equals("register"))
		{
			response.sendRedirect("JSP/Registration.jsp");
		}
		else if(requestSource.equals("registercustomer"))
		{
		System.out.println("hi");
		String firstname=(request.getParameter("firstname"));
		String lastname=(request.getParameter("lastname"));
			String gender=(request.getParameter("gender"));
			String dob=(request.getParameter("dob"));
			String eid=(request.getParameter("eid"));
			String phone=(request.getParameter("phone"));
			String city=(request.getParameter("city"));
			String loc=(request.getParameter("loc"));
			String password=(request.getParameter("password"));
	
			
			cBean.setFirstName(firstname);
			cBean.setLastName(lastname);
			cBean.setGender(gender);
			cBean.setEmailId(eid);
			cBean.setDob(dob);
			cBean.setPhone(phone);
			cBean.setCity(city);
			cBean.setLocation(loc);
			cBean.setPassword(password);
			System.out.println("bean in contrler "+cBean.getPassword());
			CustomerBean c1=new CustomerBean();
			try {
				c1=model.viewbyCustomerByEmail(eid);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	try	
	 {
			if(c1==null)
		{     model.registerCustomer(cBean);
				rd=request.getRequestDispatcher("JSP/registrationsuccess.jsp");
					response.setContentType("text/html");
					request.setAttribute("feedback","*customer added successfully");
					rd.include(request, response);
				}
			else
			{
				request.setAttribute("regfail", "   *Email Id already exists");
				rd=request.getRequestDispatcher("JSP/Registration.jsp");
				//out.println("Email Id already exists");response.setContentType("type/html");
				rd.forward(request, response);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
		}
		}
	if(requestSource.equals("view"))
	{

		try {
			ArrayList<CustomerBean> List=model.viewAll();
			if(!List.isEmpty())
			{
				request.setAttribute("list", List);
				rd=request.getRequestDispatcher("JSP/view.jsp");
				rd.forward(request, response);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			out.println(e);
		}
	}
	
	if(requestSource.equals("view1"))
	{
		
		String emailid=request.getParameter("email");
		System.out.println(emailid);
		 cBean = new CustomerBean();
		try {
			cBean = model.viewbyCustomerByEmail(emailid);
			if(cBean!=null)
			{
				request.setAttribute("customer", cBean);
				rd=request.getRequestDispatcher("JSP/viewbyid.jsp");
				rd.forward(request,response);
			}
		
			else
			    {
				rd=request.getRequestDispatcher("JSP/error.jsp");	
				rd.forward(request,response);
				}
		
			}
		catch (SQLException e) {
			
			e.printStackTrace();
		       }
		
	       }
	
	else if(requestSource.equalsIgnoreCase("Deactivate"))
	{
		String emailid=request.getParameter("emailid");	
	try{
	
			if(model.DeleteUser(emailid))
			{						
					
						out.println(request.getParameter("fname") + " User Deactivated<br>");								
							rd=request.getRequestDispatcher("JSP/deactivateSuccess.jsp");
							rd.forward(request, response);
								
			}
				
	}
		catch(Exception e)
		{
			out.print("Something is going wrong please Try Again<br><a href=JSP/index.jsp>Home</a>");
			response.setContentType("text/html");
			rd=request.getRequestDispatcher("JSP/deactivateSuccess.jsp");
			rd.include(request, response);
		
	}}
	
//	if(requestSource.equalsIgnoreCase("deactivatereason"))
//	{
//		try{
//			
//			String emailid=request.getParameter("emailid");
//			String reason=request.getParameter("reason");
//		
//					if(model.DeleteUser(emailid,reason))
//					{						
//						out.println(request.getParameter("fname") + " User Deactivated<br>");								
//						rd=request.getRequestDispatcher("JSP/deactivateSuccess.jsp");
//						rd.forward(request, response);
//				    }
//					
//		}
//			catch(Exception e)
//			
//			{
//				out.print("Something is going wrong please Try Again<br><a href=JSP/index.jsp>Home</a>");
//				response.setContentType("text/html");
//				rd=request.getRequestDispatcher("JSP/deactivateSuccess.jsp");
//				rd.include(request, response);
//}
//	}
		else if(requestSource.equalsIgnoreCase("update")){
		CustomerModel cModel = new CustomerModel();
		HttpSession session = request.getSession();
		
		 try {
			cBean = cModel.viewbyCustomerByEmail((String)session.getAttribute("user"));
			request.setAttribute("cust", cBean);
			rd = request.getRequestDispatcher("JSP/update.jsp");
			rd.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		
	}
	else if(requestSource.equals("updatecustomer"))
	{
		HttpSession session = request.getSession();
		String emailid=(String) session.getAttribute("user");
		CustomerBean cBean1=new CustomerBean();
		cBean1.setFirstName(request.getParameter("firstname"));
		System.out.println("firstname is "+cBean1.getFirstName());
		cBean1.setLastName(request.getParameter("lastname"));
		cBean1.setGender(request.getParameter("gender"));
		cBean1.setDob(request.getParameter("dob"));
		cBean1.setPhone(request.getParameter("phone"));
		cBean1.setCity(request.getParameter("city"));
		cBean1.setLocation(request.getParameter("loc"));
		cBean1.setPassword(request.getParameter("password"));
		try {
			
			boolean flag=model.updateUser(cBean1, emailid);
			System.out.println("uih "+cBean1.getCity());
			if(flag)
			{						
					response.sendRedirect("JSP/deactivateSuccess.jsp");
							
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	else if(requestSource.equalsIgnoreCase("updateconfirm"))
	{
			if(cBean!=null)
			{
					rd=request.getRequestDispatcher("JSP/deactivateSuccess.jsp");
					rd.include(request, response);
				}
				
	}

	//--------------------admin part--------------
	
	if(requestSource.equalsIgnoreCase("viewallcustomer"))
	{	
	try
	{
		ArrayList<CustomerBean> cList=model.viewAllCustomer();
		if(!cList.isEmpty())
		{
			request.setAttribute("customerlist", cList);
			rd=request.getRequestDispatcher("JSP/viewallcustomer.jsp");
			rd.forward(request, response);
		}
	}
	catch(Exception e)
		{
		out.println(e);
		}

	}
	
	if(requestSource.equalsIgnoreCase("deactivatebycid"))
	{
		
		System.out.println(request.getParameter("customerid"));
		System.out.println(request.getParameter("status"));
		String cid=request.getParameter("customerid");
		String status=request.getParameter("status");
		
		try {
			cBean = model.deactivateCustomer(cid, status);
			if(cBean!=null)
			{
				request.setAttribute("delete", cBean);
				System.out.println(cBean.getEmailId() + " " + cBean.getDeactivation());
				rd=request.getRequestDispatcher("JSP/deactivatebycid.jsp");
				rd.forward(request, response);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	
	
	else if(requestSource.equalsIgnoreCase("deletecustomer"))
	{
		
		System.out.println("hiASCDASCDASCAS");
		/*rd=request.getRequestDispatcher("jsp/newupdateshow.jsp");
		rd.include(request, response);*/

		String eid=request.getParameter("emailid");
		String status=request.getParameter("status");
		System.out.println(eid);
		System.out.println(status);
		
		
		//sBean.setMovieId(movieId);
		cBean.setEmailId(eid);
		cBean.setDeactivation(status);

		try{System.out.println("hh");
			CustomerBean cb=model.deactivateCustomer(eid, status);
			
			if(cb!=null)
			{
			//	out.println("<font color:blue><h2><u>Success Page</u></h2><br> Status of the customer: " + eid + " changed successfully</div></font><br><a href=jsp/index.jsp>Home</a>");
				request.setAttribute("deletion", "status of "+eid+" changed successfully to "+status);
				rd=request.getRequestDispatcher("JSP/addsuccess.jsp");		    	
				rd.include(request, response);

			}
		}catch(Exception e)
		{
			out.println(e);
		}
	}
	
	if(requestSource.equals("viewprofile"))
	{	
		String eid=request.getParameter("customeremailid");
		
		System.out.println("email" +eid);
		try {
			cBean = model.viewbyemailId(eid);
			if(cBean!=null)
			{
				request.setAttribute("customer", cBean);
				rd=request.getRequestDispatcher("JSP/viewprofile.jsp");
				rd.forward(request, response);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	
	if(requestSource.equalsIgnoreCase("Go"))
	{
		
		String searchByParam= request.getParameter("searchField");	
		String fname=request.getParameter("name");
		
		
		if(searchByParam.equalsIgnoreCase("searchbyname")){
		try
		{
			ArrayList<CustomerBean> cList=model.viewCustomerByName(fname);
			if(cList!=null)
			{
				request.setAttribute("customerlist", cList);
				rd=request.getRequestDispatcher("JSP/viewallcustomer.jsp");
				rd.forward(request, response);
			}
		}
		catch(Exception e)
			{
			e.printStackTrace();
			//out.println(e);
			
			}
	}
		if(searchByParam.equalsIgnoreCase("searchbycity")){
			try
			{
				ArrayList<CustomerBean> cList=model.viewCustomerBycity(fname);
				if(cList!=null){
					request.setAttribute("customerlist", cList);
					rd=request.getRequestDispatcher("JSP/viewallcustomer.jsp");
					rd.forward(request, response);
				}
			}
			catch(Exception e)
				{
				e.printStackTrace();
				//out.println(e);
				
				}
			}
		
		if(searchByParam.equalsIgnoreCase("searchbyemail")){
			try
			{
				ArrayList<CustomerBean> cList=model.viewCustomerByEmail(fname);
				if(cList!=null){
					request.setAttribute("customerlist", cList);
					rd=request.getRequestDispatcher("JSP/viewallcustomer.jsp");
					rd.forward(request, response);
				}
			}
			catch(Exception e)
				{
				e.printStackTrace();
				//out.println(e);
				
				}
			}
		if(searchByParam.equalsIgnoreCase("searchbyphn")){
			try
			{
				ArrayList<CustomerBean> cList=model.viewCustomerByPhn(fname);
				if(cList!=null){
					request.setAttribute("customerlist", cList);
					rd=request.getRequestDispatcher("JSP/viewallcustomer.jsp");
					rd.forward(request, response);
				}
			}
			catch(Exception e)
				{
				e.printStackTrace();
				//out.println(e);
				
				}
			}
		if(searchByParam.equalsIgnoreCase("searchbystatus")){
				try
				{
					ArrayList<CustomerBean> cList=model.viewCustomerByStatus(fname);
					if(cList!=null){
						request.setAttribute("customerlist", cList);
						rd=request.getRequestDispatcher("JSP/viewallcustomer.jsp");
						rd.forward(request, response);
					}
				}
				catch(Exception e)
					{
					e.printStackTrace();
					//out.println(e);
					
					}
				}
		
		if(searchByParam.equalsIgnoreCase("searchbygender")){
			try
			{
				ArrayList<CustomerBean> cList=model.viewCustomerByGender(fname);
				if(cList!=null){
					request.setAttribute("customerlist", cList);
					rd=request.getRequestDispatcher("JSP/viewallcustomer.jsp");
					rd.forward(request, response);
				}
			}
			catch(Exception e)
				{
				e.printStackTrace();
				//out.println(e);
				
				}
			}
		if(searchByParam.equalsIgnoreCase("searchbydob")){
			try
			{
				ArrayList<CustomerBean> cList=model.viewCustomerByDob(fname);
				if(cList!=null){
					request.setAttribute("customerlist", cList);
					rd=request.getRequestDispatcher("JSP/viewallcustomer.jsp");
					rd.forward(request, response);
				}
			}
			catch(Exception e)
				{
				e.printStackTrace();
				//out.println(e);
				
				}
			}
	}
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doPost(request, response);
		   }
}



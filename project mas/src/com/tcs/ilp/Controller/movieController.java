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
import javax.swing.text.StyledEditorKit.BoldAction;

import com.tcs.ilp.Bean.MovieBean;
import com.tcs.ilp.Model.MovieModel;

/**
 * Servlet implementation class movieController
 */
public class movieController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public movieController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String requestSource=request.getParameter("source");
		System.out.println("");
		if(requestSource.equals("admin"))
			response.sendRedirect("JSP/adminDashBoard.jsp");

		if(requestSource.equals("addmovie")){
			response.sendRedirect("JSP/addmovie.jsp");
		}

		else if(requestSource.equals("addmoviesuccess")){

			PrintWriter out=response.getWriter();
			MovieModel model=new MovieModel();
			MovieBean mBean=new MovieBean();
			String movieName=request.getParameter("moviename");
			String language=request.getParameter("language");
			String startdate=request.getParameter("startdate");
			String photo=request.getParameter("photo");
			System.out.println(photo);
		//	photo = "C:\\Users\\SAHIL\\Documents\\downloads\\" + photo;
			
			Boolean movieExists=false;

			String startdateFormat=startdate.substring(8, 10)+"/"+startdate.substring(5, 7)+"/"+startdate.substring(0 ,4);

			String enddate=request.getParameter("enddate");
			String endDateFormat=enddate.substring(8, 10)+"/"+startdate.substring(5, 7)+"/"+startdate.substring(0 ,4);
			//			
			String category=request.getParameter("category");
			int theaterId=Integer.parseInt(request.getParameter("theaterid"));
			try {
				int mId=model.search(movieName, language);
				if(mId==0)
				{
					mBean=model.addMovie(movieName, language, startdateFormat, endDateFormat, category, theaterId,photo);

				}
				else
				{
					movieExists=true;
				}

			} 
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			RequestDispatcher rd=null;
			if(movieExists)
				request.setAttribute("movieExists", "movie with name "+movieName+" and language "+language+" exists");
			else
				request.setAttribute("movieExists", "movie "+mBean.getMovieName()+" ("+mBean.getLanguage()+") "+" added with id "+mBean.getMovieId());

			rd=request.getRequestDispatcher("JSP/addmovie.jsp");	

			rd.include(request, response);


		}

		else if(requestSource.equalsIgnoreCase("viewallmovie"))
		{		
			MovieModel model=new MovieModel();
			MovieBean mBean=new MovieBean();
			RequestDispatcher rd=null;
			PrintWriter out=response.getWriter();
			try
			{
				ArrayList<MovieBean> movieList=model.getMovieList();
				if(!movieList.isEmpty())
				{
					request.setAttribute("movielist", movieList);
					rd=request.getRequestDispatcher("JSP/viewallmovie.jsp");
					rd.forward(request, response);
				}
			}
			catch(Exception e)
			{
				out.println(e);
			}

		}


		else if(requestSource.equals("deletemovie"))
		{
			PrintWriter out=response.getWriter();
			RequestDispatcher rd=null;
			String movieName=request.getParameter("moviename");
			String language=request.getParameter("movielanguage");

			MovieModel model=new MovieModel();
			MovieBean mBean=new MovieBean();

			mBean.setMovieName(movieName);
			mBean.setLanguage(language);

			try{
				boolean flag=model.removeMovie(movieName, language);
				if(flag)
				{
					//out.println("<font color:blue><h2><u>Success Page</u></h2><br>Movie " + mBean.getMovieName() + " deleted successfully</div></font><br><a href=jsp/index.jsp>Home</a>");
					response.sendRedirect("JSP/viewallshow.jsp");
					rd=request.getRequestDispatcher("JSP/viewallshow.jsp");		    	
					rd.forward(request, response);

				}
			}catch(Exception e)
			{
				out.println(e);
			}


		}


		//		else if(requestSource.equalsIgnoreCase("updatemovie"))
		//		{
		//			PrintWriter out=response.getWriter();
		//			RequestDispatcher rd=null;
		//			String movieName=request.getParameter("moviename");
		//			String language=request.getParameter("movielanguage");
		//			
		//			MovieModel model=new MovieModel();
		//			MovieBean mBean=new MovieBean();
		//
		//			mBean.setMovieName(movieName);
		//			mBean.setLanguage(language);
		//			
		//			try{
		//				boolean flag=model.updateMovie(mBean);
		//				if(flag)
		//				{
		//					out.println("<font color:blue><h2><u>Success Page</u></h2><br>Movie " + mBean.getMovieName() + " updated successfully</div></font><br><a href=jsp/index.jsp>Home</a>");
		//					rd=request.getRequestDispatcher("JSP/addsuccess.jsp");		    	
		//					rd.include(request, response);
		//
		//				}
		//			}catch(Exception e)
		//			{
		//				out.println(e);
		//			}
		//
		//		}

		if(requestSource.equals("viewmoviebyid"))
		{
			MovieModel model=new MovieModel();
			RequestDispatcher rd=null;
			System.out.println(request.getParameter("movieid"));
			System.out.println(request.getParameter("moviename"));
			System.out.println(request.getParameter("movielanguage"));

			int mid=Integer.parseInt(request.getParameter("movieid"));
			MovieBean mBean;
			try {
				mBean = model.viewMovieById(mid);
				if(mBean!=null)
				{
					request.setAttribute("movie", mBean);
					rd=request.getRequestDispatcher("JSP/viewmoviebyid.jsp");
					rd.forward(request, response);
				}
			} catch (SQLException e) {

				e.printStackTrace();
			}

		}
	//---------------------------------------------------------------------------	
		if(requestSource.equals("updatemovie1"))
		{
			ArrayList<String> clist = new ArrayList<String>();
		
			MovieBean mbean = new MovieBean();
			
			String mname = request.getParameter("moviename");
			String language = request.getParameter("movielanguage");
			
			MovieModel mmodel = new MovieModel();
			try {
				int movieid = mmodel.search(mname,language);
				request.setAttribute("movieid",movieid);
				mbean = mmodel.viewMovieById(movieid);
				clist = mmodel.category();


				request.setAttribute("mbean", mbean);
				request.setAttribute("clist", clist);
				RequestDispatcher rd = null;
				rd = request.getRequestDispatcher("JSP/viewdetails.jsp");
				rd.forward(request,response);
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
				
			
			
			
		}
	//---------------------------------------------------------------------------	
		int movieid = 0;
		String mname = null;
		String language= null;

		MovieModel mmodel = new MovieModel();
		MovieBean mbean = new MovieBean();



		ArrayList<String> clist = new ArrayList<String>();
		ArrayList<String> mlist = new ArrayList<String>();

		//---------------------------------------------------------------------------------------------------------------

		String requestsource = request.getParameter("source");
		if(requestsource.equals("updatemovie")){

			try {
				RequestDispatcher rd=null;
				mlist = mmodel.search();
				request.setAttribute("mlist", mlist);
				rd = request.getRequestDispatcher("JSP/search.jsp");
				rd.include(request, response);

			} 
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		//--------------------------------------------------------------------------------------------------------------------	

		if(requestsource.equals("search"))
		{


			mname = request.getParameter("mname");
			language = request.getParameter("language");

			try {


				movieid = mmodel.search(mname, language);
				System.out.println(movieid);
				mbean = mmodel.viewMovieById(movieid);
				clist = mmodel.category();


				request.setAttribute("mbean", mbean);
				request.setAttribute("clist", clist);

				RequestDispatcher rd=null;
				request.setAttribute("movieid",movieid);
				rd = request.getRequestDispatcher("JSP/viewdetails.jsp");
				rd.include(request, response);

			} 
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		//--------------------------------------------------------------------------------------------------------------------------

		if(requestsource.equals("Update"))
		{
			System.out.println("here");
			String startdate = request.getParameter("sd");
			String enddate = request.getParameter("ed");
			String category = request.getParameter("category");
			System.out.println(category);


			String startdateFormat=startdate.substring(8, 10)+"/"+startdate.substring(5, 7)+"/"+startdate.substring(0 ,4);
			String enddateFormat = enddate.substring(8,10)+ "/" +enddate.substring(5,7) + "/" + enddate.substring(0,4);


			try {

				movieid=Integer.parseInt(request.getParameter("id"));
				mmodel.updateMovieById(startdateFormat,enddateFormat,category,movieid);
				RequestDispatcher rd=null;
				rd = request.getRequestDispatcher("JSP/updatesuccess.jsp");
				rd.include(request,response);

			} 
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}


		if(requestSource.equals("viewmoviebyfield"))
		{
			RequestDispatcher rd=null;
			rd=request.getRequestDispatcher("JSP/viewmoviebyfield.jsp");
			rd.forward(request, response);
		}
		else if(requestSource.equals("by"))
		{
			String field=request.getParameter("selectField");
			if(!field.equals(""))
			{
				if(field.equals("byname"))
				{
					System.out.println("hi");
					MovieModel model=new MovieModel();
					ArrayList<String> mlist1;
					try {
						mlist1 = model.viewMovieByName();
						RequestDispatcher rd=null;
						if(!mlist.isEmpty())
						{
							System.out.println("hi");
						}
						request.setAttribute("mlist", mlist1);
						rd=request.getRequestDispatcher("JSP/viewmoviebyfield.jsp");
						rd.forward(request, response);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}


				}
				else if(field.equals("bylang"))
				{
					MovieModel model=new MovieModel();

					ArrayList<String> mlist2;
					try {
						mlist2 = model.viewMovieByLanguage();
						RequestDispatcher rd=null;
						request.setAttribute("llist", mlist2);
						rd=request.getRequestDispatcher("JSP/viewmoviebyfield.jsp");
						rd.forward(request, response);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				else if(field.equals("bycat"))
				{
					MovieModel model=new MovieModel();

					ArrayList<String> mlist3;
					try {
						mlist3 = model.viewMovieByCategory();
						RequestDispatcher rd=null;
						request.setAttribute("clist", mlist3);
						rd=request.getRequestDispatcher("JSP/viewmoviebyfield.jsp");
						rd.forward(request, response);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			else
			{
				response.sendRedirect("JSP/viewmoviebyfield.jsp");	
			}
		}	

		
	//-------------------------search---------------------
		
		if(requestSource.equalsIgnoreCase("Find"))
		{
			
			String searchByParam= request.getParameter("searchField");
			System.out.println("hii" +searchByParam);
			String fname=request.getParameter("name");
			System.out.println("hey" +fname);
			MovieModel model=new MovieModel();
			RequestDispatcher rd=null;
			if(searchByParam.equalsIgnoreCase("searchbyname")){
			try
			{
				ArrayList<MovieBean> mList=model.searchMovieByName(fname);
				if(mList!=null)
				{
					request.setAttribute("movielist", mList);
					rd=request.getRequestDispatcher("JSP/viewallmovie.jsp");
					rd.forward(request, response);
				}
			}
			catch(Exception e)
				{
				e.printStackTrace();
				//out.println(e);
				
				}
		}
			if(searchByParam.equalsIgnoreCase("searchbylanguage")){
				try
				{ArrayList<MovieBean> mList=model.searchMovieByLanguage(fname);
				if(mList!=null)
				{
					request.setAttribute("movielist", mList);
					rd=request.getRequestDispatcher("JSP/viewallmovie.jsp");
					rd.forward(request, response);
				}
				}
				catch(Exception e)
					{
					e.printStackTrace();
					//out.println(e);
					
					}
				}
			
			if(searchByParam.equalsIgnoreCase("searchbycategory")) {
				try
				{
					ArrayList<MovieBean> mList=model.searchMovieByCategory(fname);
					if(mList!=null)
					{
						request.setAttribute("movielist", mList);
						rd=request.getRequestDispatcher("JSP/viewallmovie.jsp");
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}

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

import com.tcs.ilp.Bean.ClassBean;
import com.tcs.ilp.Bean.MovieBean;
import com.tcs.ilp.Bean.ScreenBean;
import com.tcs.ilp.Bean.ShowBean;
import com.tcs.ilp.DAO.ShowImpl;
import com.tcs.ilp.Model.ClassModel;
import com.tcs.ilp.Model.MovieModel;
import com.tcs.ilp.Model.ScreenModel;
import com.tcs.ilp.Model.ShowModel;

/**
 * Servlet implementation class ShowController
 */
public class ShowController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String requestSource=request.getParameter("source");
		
		RequestDispatcher rd=null;
//		if(requestSource.equals("addshowpage"))
//			response.sendRedirect("JSP/addshow.jsp");
//		
		if(requestSource.equals("admin"))
			response.sendRedirect("JSP/adminDashBoard");
		
		if(requestSource.equals("addshowpage")){
			
			PrintWriter out=response.getWriter();
			
			ShowBean sBean= new ShowBean();
			ShowModel sModel= new ShowModel();
			MovieModel movieModel=new MovieModel();
			
			ArrayList<MovieBean> movieList=new ArrayList<MovieBean>();
			try {
				movieList=movieModel.getMovieList();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			request.setAttribute("movielist", movieList);
			rd=request.getRequestDispatcher("JSP/addshow.jsp");
	
			ScreenModel screenModel= new ScreenModel();
			ArrayList<ScreenBean> screenList=new ArrayList<ScreenBean>();
		
			try {
				screenList=screenModel.getScreenList();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			request.setAttribute("screenlist", screenList);
			rd=request.getRequestDispatcher("JSP/addshow.jsp");
			rd.forward(request, response);
		}
		
		if(requestSource.equals("submitshow")){
			
			boolean showExists=false;
			String startDate=request.getParameter("startdate1");
			System.out.println(startDate);
			String startdateFormat=startDate.substring(8, 10)+"/"+startDate.substring(5, 7)+"/"+startDate.substring(0 ,4);
			
			String showslot=request.getParameter("showslot");
			String showClass=request.getParameter("classname");
			//int price=Integer.parseInt(request.getParameter("price"));
			//System.out.println(price);
			Long screenId=Long.parseLong(request.getParameter("screenid"));
			System.out.println(screenId);
			int movieId=Integer.parseInt(request.getParameter("moviename"));
			System.out.println(movieId);
			
			ShowModel showModel=new ShowModel();
			try {
				showExists =showModel.showExists(screenId, movieId,startdateFormat,showslot);
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			if(showExists)
			{
				request.setAttribute("showexists", "*another show exists at this slot");
			}
			else
			{
//			int theaterId=Integer.parseInt(request.getParameter("theater"));
			
			ScreenBean screenBean=new ScreenBean();
			ScreenModel screenModel=new ScreenModel();
			try {
				screenBean=screenModel.getScreenById(screenId);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			ClassModel cModel=new ClassModel();
			System.out.println("screenid is"+screenId);
			ClassBean cBeanSilver=new ClassBean();
			ClassBean cBeanGold=new ClassBean();
			try {
				if(screenBean.getTotalSeats()==300)
				{
					cBeanSilver=cModel.addClassSilver(screenId,Integer.parseInt(request.getParameter("silverprice")),175,175);					
					cBeanGold=cModel.addClassGold(screenId,Integer.parseInt(request.getParameter("goldprice")),125,125);
				}
				if(screenBean.getTotalSeats()==200)
				{
					cBeanSilver=cModel.addClassSilver(screenId,Integer.parseInt(request.getParameter("silverprice")),125,125);					
					cBeanGold=cModel.addClassGold(screenId,Integer.parseInt(request.getParameter("goldprice")),75,75);
				}
				System.out.println("classid is"+cBeanGold.getClassId());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			ShowBean showBean=new ShowBean();
			ShowBean sBean=new ShowBean();
			try {
				
				sBean=	showModel.showMovie(screenId, movieId, startdateFormat, showslot);
				System.out.println("getshow is "+sBean.getShowId());
				Boolean flag1=cModel.updateSilverClass(cBeanSilver.getClassId(),sBean.getShowId());
				
				System.out.println("flag is "+flag1);
				Boolean flag2=cModel.updateGoldClass(cBeanGold.getClassId(),sBean.getShowId());
				
				System.out.println("flag2 is "+flag2);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("showexists", "*show added with id "+sBean.getShowId());
			}
			rd=request.getRequestDispatcher("JSP/addshow.jsp");
			rd.forward(request, response);
				
		
		}
		
		else if(requestSource.equalsIgnoreCase("viewallshow"))
		{		ShowModel model=new ShowModel();
		ShowBean sBean=new ShowBean();
		
		PrintWriter out=response.getWriter();
		try
		{
			ArrayList<ShowBean> showList=model.getShowList();
			if(!showList.isEmpty())
			{
				request.setAttribute("showlist", showList);
				rd=request.getRequestDispatcher("JSP/viewallshow.jsp");
				rd.forward(request, response);
			}
		}
		catch(Exception e)
			{
			out.println(e);
			}

		}


		else if(requestSource.equals("deleteshow"))
		{
			PrintWriter out=response.getWriter();
			
			int showId= Integer.parseInt(request.getParameter("showid"));
					
			
			ShowModel model=new ShowModel();
			ShowBean sBean=new ShowBean();

			sBean.setShowId(showId);
			
			try{
				boolean flag=model.removeShow(showId);
				if(flag)
				{
					out.println("<font color:blue><h2><u>Success Page</u></h2><br>Show " + sBean.getShowId() + " deleted successfully</div></font><br><a href=JSP/index.jsp>Home</a>");
					rd=request.getRequestDispatcher("JSP/addsuccess.jsp");		    	
					rd.forward(request, response);

				}
			}catch(Exception e)
			{
				out.println(e);
			}


		}


		else if(requestSource.equalsIgnoreCase("updateshow"))
		{
			System.out.println("hi");
			/*rd=request.getRequestDispatcher("jsp/newupdateshow.jsp");
			rd.include(request, response);*/
			ShowModel model=new ShowModel();
			ShowBean sBean=new ShowBean();
			
			PrintWriter out=response.getWriter();
			int showid=Integer.parseInt(request.getParameter("showid"));
			System.out.println(showid);
			
			
			String movieId=request.getParameter("mid");
			System.out.println("hjhj"+movieId);
			
			int screenId=Integer.parseInt(request.getParameter("screenid"));
			System.out.println("value Screenid" +screenId);
			System.out.println(screenId);
			
			String showDate=request.getParameter("showdate");
			System.out.println("showdate value" +showDate);
			String startdateFormat=showDate.substring(8, 10)+"/"+showDate.substring(5, 7)+"/"+showDate.substring(0 ,4);
			String showslot=request.getParameter("showslot");
			System.out.println(startdateFormat);
			System.out.println(showslot);
			System.out.println(showDate);
			
			//sBean.setMovieId(movieId);
			sBean.setScreenId(screenId);
			sBean.setShowDate(startdateFormat);
			sBean.setStartTime(showslot);

			try{
				ShowBean sb=model.updatebyShowId(showid, screenId, showslot, startdateFormat);
				System.out.println("hh"+sb);
				if(sb!=null)
				{
					out.println("<font color:blue><h2><u>Success Page</u></h2><br>show " + showid + " updated successfully</div></font><br><a href=jsp/index.jsp>Home</a>");
					rd=request.getRequestDispatcher("JSP/addsuccess.jsp");		    	
					rd.include(request, response);

				}
			}catch(Exception e)
			{
				out.println(e);
			}
		}
		
		if(requestSource.equals("viewshowbysid"))
		{
			ShowModel model=new ShowModel();
			System.out.println(request.getParameter("showid"));
			int sid=Integer.parseInt(request.getParameter("showid"));
			ShowBean sBean;
			try {
				sBean = model.viewbyShowId(sid);
				if(sBean!=null)
				{
					request.setAttribute("show", sBean);
					rd=request.getRequestDispatcher("JSP/viewshowbysid.jsp");
					rd.forward(request, response);
				}
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
		}
		
		if(requestSource.equals("updateshowbysid"))
		{
			ShowModel model=new ShowModel();
			System.out.println(request.getParameter("showid"));
			int sid=Integer.parseInt(request.getParameter("showid"));
			ShowBean sBean;
			try {
				sBean = model.viewbyShowId(sid);
				if(sBean!=null)
				{
					request.setAttribute("show", sBean);
					rd=request.getRequestDispatcher("JSP/updateshowbysid.jsp");
					rd.forward(request, response);
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
		}
		if(requestSource.equalsIgnoreCase("Find"))
		{
			
			String searchByParam= request.getParameter("searchField");
			System.out.println("hii" +searchByParam);
			String fname=request.getParameter("name");
			System.out.println("hey" +fname);
			ShowModel model=new ShowModel();
			//RequestDispatcher rd=null;
			if(searchByParam.equalsIgnoreCase("searchbydate")){
			try
			{
				ArrayList<ShowBean> sList=model.searchShowByShowDate(fname);
				if(sList!=null)
				{
					request.setAttribute("showlist", sList);
					rd=request.getRequestDispatcher("JSP/viewallshow.jsp");
					rd.forward(request, response);
				}
			}
			catch(Exception e)
				{
				e.printStackTrace();
				//out.println(e);
				
				}
		}
			if(searchByParam.equalsIgnoreCase("searchbytime")){
				try
				{
					ArrayList<ShowBean> sList=model.searchShowByShowTime(fname);
					if(sList!=null)
					{
						request.setAttribute("showlist", sList);
						rd=request.getRequestDispatcher("JSP/viewallshow.jsp");
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

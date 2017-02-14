package com.tcs.ilp.Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tcs.ilp.Bean.BookingBean;
import com.tcs.ilp.Bean.MovieBean;
import com.tcs.ilp.Bean.ShowBean;
import com.tcs.ilp.Bean.TicketBean;
import com.tcs.ilp.Model.BookingModel;
import com.tcs.ilp.Model.MovieModel;
import com.tcs.ilp.Model.ShowModel;

/**
 * Servlet implementation class TicketController
 */
public class TicketController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TicketController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String requestSource=request.getParameter("source");
		BookingModel bModel=new BookingModel();
		MovieModel movieModel=new MovieModel();
		ShowModel sModel=new ShowModel();
		
		MovieBean mBean=new MovieBean();
		ShowBean sBean=new ShowBean();
		
		ArrayList<TicketBean> ticketList=new ArrayList<>();
		ArrayList<BookingBean> bookingList=new ArrayList<>();
		
		TicketBean tBean;
		
		if(requestSource.equalsIgnoreCase("viewbooking"))
		{
			try {
				bookingList=bModel.getBookingList();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			if(bookingList!=null){
				System.out.println("booking size "+ bookingList.size());
			for(BookingBean bookingBean:bookingList)
			{
				tBean=new TicketBean();
				tBean.setBookingId(bookingBean.getBookingId());
				tBean.setEmailid(bookingBean.getEmailId());
				try {
					sBean=sModel.viewbyShowId(bookingBean.getShowId());
					mBean=movieModel.viewMovieById(sBean.getMovieId());
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				catch(Exception e){
					e.printStackTrace();
				}
				
				try{
				tBean.setShowDate(sBean.getShowDate().substring(0, 11));
				tBean.setShowSlot(sBean.getStartTime());
				tBean.setSeatNumber(bookingBean.getSeatNumber());
				tBean.setPrice(bookingBean.getPrice());
				tBean.setMovieName(mBean.getMovieName());
				tBean.setLanguage(mBean.getLanguage());
				tBean.setScreenId(sBean.getScreenId());
				ticketList.add(tBean);				
				System.out.println("aakhri "+mBean.getMovieName()+ " "+sBean.getMovieId());
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
			request.setAttribute("ticketlist", ticketList);
			System.out.println("bookking list size "+bookingList.size()+" "+" ticketlist "+ticketList.size());
			System.out.println("hua ki nahii?");
			RequestDispatcher disp=request.getRequestDispatcher("JSP/adminbooklist.jsp");
			disp.forward(request, response);
		}}
		else
		if(requestSource.equalsIgnoreCase("bookedhistory"))
		{
			HttpSession session=request.getSession();
			String user=(String)session.getAttribute("user");
			System.out.println("user is in bookkinglist "+user);

			try {
				bookingList=bModel.getBookingList(user);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if(bookingList!=null){
				for(BookingBean bookingBean:bookingList)
				{
					tBean=new TicketBean();
					tBean.setBookingId(bookingBean.getBookingId());
					tBean.setEmailid(bookingBean.getEmailId());
					try {
						sBean=sModel.viewbyShowId(bookingBean.getShowId());
						mBean=movieModel.viewMovieById(sBean.getMovieId());
						tBean.setShowDate(sBean.getShowDate());
						tBean.setShowDate(sBean.getShowDate());
						tBean.setShowSlot(sBean.getStartTime());
						tBean.setSeatNumber(bookingBean.getSeatNumber());
						tBean.setPrice(bookingBean.getPrice());
						tBean.setMovieName(mBean.getMovieName());
						tBean.setLanguage(mBean.getLanguage());
						tBean.setScreenId(sBean.getScreenId());
						ticketList.add(tBean);				
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					

				}
				request.setAttribute("ticketlist", ticketList);
				RequestDispatcher disp=request.getRequestDispatcher("JSP/viewbookedhistory.jsp");
				disp.forward(request, response);
			}}

		//		if(request.getParameter("searchbyparam")){
		//			
		//			String searchField=request.getParameter("searchfield");
		//			if(searchField.equals("emailid"))
		//		}

		
		if(requestSource.equals("makepayment"))
		{
			String bookingId=request.getParameter("source1");
			String emailid=request.getParameter("source2");
			String movieName=request.getParameter("source3");
			String language=request.getParameter("source4");
			String showDate=request.getParameter("source5");
			String showSlot=request.getParameter("source6");
			String seatNumber=request.getParameter("source7");
			String price=request.getParameter("source8");
			
			//request.setAttribute("ticketlist", ticketList);
			RequestDispatcher disp=request.getRequestDispatcher("JSP/payment.jsp");
			disp.forward(request, response);
		}
		
		if(requestSource.equals("paid"))
			
		if(request.getParameter("action")!=null){
		System.out.println("jashsd "+request.getParameter("action"));
		if(request.getParameter("action")!=null&&request.getParameter("action").equalsIgnoreCase("ConfirmTicket"))
		{
			String bookingId=request.getParameter("source1");
			System.out.println(request.getParameter("source1"));
			String emailid=request.getParameter("source2");
			String movieName=request.getParameter("source3");
			String language=request.getParameter("source4");
			String showDate=request.getParameter("source5");
			String showSlot=request.getParameter("source6");
			String seatNumber=request.getParameter("source7");
			String price=request.getParameter("source8");
			RequestDispatcher disp1=request.getRequestDispatcher("JSP/printticket.jsp");
			disp1.forward(request, response);
		}
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String requestSource=request.getParameter("source");		
		}	
		}



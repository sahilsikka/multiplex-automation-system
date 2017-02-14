package com.tcs.ilp.Controller;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;









import javax.servlet.http.HttpSession;

import oracle.net.aso.s;

import com.tcs.ilp.Bean.BookingBean;
import com.tcs.ilp.Bean.ClassBean;
import com.tcs.ilp.Bean.LocationBean;
import com.tcs.ilp.Bean.MovieBean;
import com.tcs.ilp.Bean.ShowBean;
import com.tcs.ilp.Bean.TheaterBean;
import com.tcs.ilp.Model.BookingModel;
import com.tcs.ilp.Model.ClassModel;
import com.tcs.ilp.Model.LocationModel;
import com.tcs.ilp.Model.MovieModel;
import com.tcs.ilp.Model.ShowModel;
import com.tcs.ilp.Model.TheaterModel;

/**
 * Servlet implementation class MainController
 */
public class BookingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static int count=0;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BookingController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BookingBean bookingBean = new BookingBean();
		String requestsource = request.getParameter("source");
		System.out.println("source is "+requestsource);
		String action = request.getParameter("action");
		System.out.println("action value is "+action);
		MovieBean mBean=new MovieBean();
		Boolean userFlag=false;
		HttpSession session=request.getSession();
		
		if(action!=null)userFlag=true;
		
		if(requestsource.equalsIgnoreCase("book")&&action==null)
		{			
			if(session.getAttribute("user")==null)
			{
				RequestDispatcher disp=request.getRequestDispatcher("JSP/login.jsp");
				disp.forward(request, response);				
			}
			else
			{
				RequestDispatcher disp=request.getRequestDispatcher("JSP/Autopopulate.jsp");
				userFlag=true;
				//disp.forward(request, response);			
			}
			
		}
		
		boolean locationFlag, theaterFlag, movieFlag,showDateFlag,showSlotFlag,showClassFlag,finalSubmit,seatSelectionFlag,seatsFlag, finalBookingFlag;
	
			locationFlag=false;
			theaterFlag=false;
			movieFlag=false;
			showDateFlag=false;
			showSlotFlag=false;
			showClassFlag=false;
			finalSubmit=false;
			seatSelectionFlag=false;
			seatsFlag=false;
			finalBookingFlag=false;
			
			
			request.setAttribute("setLocationFlag", locationFlag);
			request.setAttribute("setTheaterFlag", theaterFlag);
			request.setAttribute("setMovieFlag", movieFlag);
			request.setAttribute("setShowDateFlag", showDateFlag);
			request.setAttribute("setShowSlotFlag", showSlotFlag);
			request.setAttribute("setShowClassFlag", showClassFlag);
			request.setAttribute("setseatselectionflag", seatSelectionFlag);
			
			
			ArrayList<LocationBean>locationList=new ArrayList<LocationBean>();
			ArrayList<TheaterBean>theaterList=new ArrayList<TheaterBean>();
			ArrayList<MovieBean>movieList=new ArrayList<MovieBean>();
			ArrayList<ShowBean>showDateList=new ArrayList<ShowBean>();
			ArrayList<ShowBean>showSlotList=new ArrayList<ShowBean>();
			ArrayList<ClassBean>showClassList=new ArrayList<ClassBean>();

			LocationModel lModel=new LocationModel();
			TheaterModel tModel=new TheaterModel();
			MovieModel mModel=new MovieModel();
			ShowModel sModel=new ShowModel();
			ClassModel cModel=new ClassModel();
			

			try {
				locationList=lModel.getLocationList();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.out.println("inside controller in onchange");

			request.setAttribute("locationlist", locationList);
			System.out.println("action neeche "+action);

			if(userFlag==true){
			if(action!=null&&action.equalsIgnoreCase("locationAction")){
		
				int locationId =  Integer.parseInt(request.getParameter("location"));
	//			System.out.println("location id is "+ locationId);
				request.setAttribute("selectedLocation", locationId);
   //			System.out.println("location id in controller is "+locationId);
				try{
					theaterList=tModel.getTheaterList(locationId);
				}
				catch(Exception e){}
				request.setAttribute("theaterlist", theaterList);
				locationFlag=true;
				request.setAttribute("setLocationFlag", locationFlag);
				count++;
				
			}
			
			if(action!=null&& action.equalsIgnoreCase("theaterAction")){
				
				int locationId =  Integer.parseInt(request.getParameter("location"));
				int theaterId =  Integer.parseInt(request.getParameter("theater"));
				
				System.out.println("theater id is "+ theaterId);
				
				request.setAttribute("selectedLocation", locationId);
				request.setAttribute("selectedTheater", theaterId);
				
//				System.out.println("location id in controller is "+locationId);
				try{
						theaterList=tModel.getTheaterList(locationId);
						movieList=mModel.getMovieListByTheater(theaterId);
					}
					catch(Exception e){}
					request.setAttribute("movielist", movieList);
					request.setAttribute("theaterlist", theaterList);
					theaterFlag=true;
					request.setAttribute("setTheaterFlag", theaterFlag);
					locationFlag=true;
					request.setAttribute("setLocationFlag", locationFlag);	
					count++;
			}
					
					
					if(action!=null&& action.equalsIgnoreCase("movieAction")){
						
						int locationId =  Integer.parseInt(request.getParameter("location"));
						int theaterId =  Integer.parseInt(request.getParameter("theater"));							
						int movieId =  Integer.parseInt(request.getParameter("movie"));
						
						System.out.println("movie id in controller is "+movieId);
	
						
						request.setAttribute("selectedLocation", locationId);
						request.setAttribute("selectedTheater", theaterId);
						request.setAttribute("selectedMovie", movieId);
						
//						System.out.println("location id in controller is "+locationId);
						try{
								theaterList=tModel.getTheaterList(locationId);
								movieList=mModel.getMovieListByTheater(theaterId);
								showDateList=sModel.getShowDateListByMovie(movieId);
							}
							catch(Exception e){}
							request.setAttribute("movielist", movieList);
							request.setAttribute("theaterlist", theaterList);
							request.setAttribute("showdatelist", showDateList);
							
							movieFlag=true;
							request.setAttribute("setMovieFlag", movieFlag);
							theaterFlag=true;
							request.setAttribute("setTheaterFlag", theaterFlag);
							locationFlag=true;
							request.setAttribute("setLocationFlag", locationFlag);			
							count++;
					}
					
					
						if(action!=null&& action.equalsIgnoreCase("showDateAction")){
						
						int locationId =  Integer.parseInt(request.getParameter("location"));
						int theaterId =  Integer.parseInt(request.getParameter("theater"));							
						int movieId =  Integer.parseInt(request.getParameter("movie"));						
						String showDate=request.getParameter("showdate");

						request.setAttribute("selectedLocation", locationId);
						request.setAttribute("selectedTheater", theaterId);
						request.setAttribute("selectedMovie", movieId);
						request.setAttribute("selectedshowdate", showDate);
						
//						System.out.println("location id in controller is "+locationId);
						try{
								theaterList=tModel.getTheaterList(locationId);
								movieList=mModel.getMovieListByTheater(theaterId);
								showDateList=sModel.getShowDateListByMovie(movieId);
								showSlotList=sModel.getShowSlotListByMovieDate(movieId,showDate);
							}	
							catch(Exception e){}
							request.setAttribute("movielist", movieList);
							request.setAttribute("theaterlist", theaterList);
							request.setAttribute("showdatelist", showDateList);
							request.setAttribute("showslotlist", showSlotList);
							
							movieFlag=true;
							request.setAttribute("setMovieFlag", movieFlag);
							theaterFlag=true;
							request.setAttribute("setTheaterFlag", theaterFlag);
							locationFlag=true;
							request.setAttribute("setLocationFlag", locationFlag);
							showDateFlag=true;
							request.setAttribute("setShowDateFlag", showDateFlag);
							showSlotFlag=true;
							request.setAttribute("setShowSlotFlag", showSlotFlag);
							count++;
					}
					
			
						if(action!=null&& action.equalsIgnoreCase("showSlotAction")){
							
							int locationId =  Integer.parseInt(request.getParameter("location"));
							int theaterId =  Integer.parseInt(request.getParameter("theater"));							
							int movieId =  Integer.parseInt(request.getParameter("movie"));						
							String showDate=request.getParameter("showdate");
							String showSlot=request.getParameter("showslot");
							int index=showSlot.indexOf(" ");
//							System.out.println("showslot is "+showSlot);
							int showId=Integer.parseInt(showSlot.substring(index+1));
							
							System.out.println("showid is df "+showId );

							request.setAttribute("selectedLocation", locationId);
							request.setAttribute("selectedTheater", theaterId);
							request.setAttribute("selectedMovie", movieId);
							request.setAttribute("selectedshowdate", showDate);
							request.setAttribute("selectedshowslot", showSlot.substring(0, index));
							
//							System.out.println("location id in controller is "+locationId);
							try{
									theaterList=tModel.getTheaterList(locationId);
									movieList=mModel.getMovieListByTheater(theaterId);
									showDateList=sModel.getShowDateListByMovie(movieId);
									showSlotList=sModel.getShowSlotListByMovieDate(movieId,showDate);
									showClassList=cModel.getClassByShow(showId);
									System.out.println("class size is"+showClassList.size());
								}
							
								catch(Exception e){}
								request.setAttribute("movielist", movieList);
								request.setAttribute("theaterlist", theaterList);
								request.setAttribute("showdatelist", showDateList);
								request.setAttribute("showslotlist", showSlotList);
								request.setAttribute("showclasslist", showClassList);
								
								movieFlag=true;
								request.setAttribute("setMovieFlag", movieFlag);
								theaterFlag=true;
								request.setAttribute("setTheaterFlag", theaterFlag);
								locationFlag=true;
								request.setAttribute("setLocationFlag", locationFlag);
								showDateFlag=true;
								request.setAttribute("setShowDateFlag", showDateFlag);
								showSlotFlag=true;
								request.setAttribute("setShowSlotFlag", showSlotFlag);								
								count++;				
				
						}		
						
						
			if(action!=null&& action.equalsIgnoreCase("showClass")){
							
							int locationId =  Integer.parseInt(request.getParameter("location"));
							int theaterId =  Integer.parseInt(request.getParameter("theater"));							
							int movieId =  Integer.parseInt(request.getParameter("movie"));						
							String showDate=request.getParameter("showdate");
							String showSlot=request.getParameter("showslot");
							int index=showSlot.indexOf(" ");
//							System.out.println("showslot is "+showSlot);
							int showId=Integer.parseInt(showSlot.substring(index+1));
							int classId =  Integer.parseInt(request.getParameter("class"));
							
							System.out.println("showid is df "+showId );

							request.setAttribute("selectedLocation", locationId);
							request.setAttribute("selectedTheater", theaterId);
							request.setAttribute("selectedMovie", movieId);
							request.setAttribute("selectedshowdate", showDate);
							request.setAttribute("selectedshowslot", showSlot.substring(0, index));
							System.out.println("selectedshowclassflag "+classId);
							request.setAttribute("selectedshowclass", classId);
														
//							System.out.println("location id in controller is "+locationId);
							try{
									theaterList=tModel.getTheaterList(locationId);
									movieList=mModel.getMovieListByTheater(theaterId);
									showDateList=sModel.getShowDateListByMovie(movieId);
									showSlotList=sModel.getShowSlotListByMovieDate(movieId,showDate);
									showClassList=cModel.getClassByShow(showId);
									System.out.println("class size is"+showClassList.size());
								}
							
								catch(Exception e){}
								request.setAttribute("movielist", movieList);
								request.setAttribute("theaterlist", theaterList);
								request.setAttribute("showdatelist", showDateList);
								request.setAttribute("showslotlist", showSlotList);
								request.setAttribute("showclasslist", showClassList);
								
								movieFlag=true;
								request.setAttribute("setMovieFlag", movieFlag);
								theaterFlag=true;
								request.setAttribute("setTheaterFlag", theaterFlag);
								locationFlag=true;
								request.setAttribute("setLocationFlag", locationFlag);
								showDateFlag=true;
								request.setAttribute("setShowDateFlag", showDateFlag);
								showSlotFlag=true;
								request.setAttribute("setShowSlotFlag", showSlotFlag);								
								showClassFlag=true;
								request.setAttribute("setShowClassFlag", showClassFlag);
								//finalSubmit=true;
								count++;
								System.out.println("final submit in classaction "+finalSubmit);
						}		
			
			if(action!=null&& action.equalsIgnoreCase("seatselection")){
				
				int locationId =  Integer.parseInt(request.getParameter("location"));
				int theaterId =  Integer.parseInt(request.getParameter("theater"));							
				int movieId =  Integer.parseInt(request.getParameter("movie"));						
				String showDate=request.getParameter("showdate");
				String showSlot=request.getParameter("showslot");
				int index=showSlot.indexOf(" ");
//				System.out.println("showslot is "+showSlot);
				int showId=Integer.parseInt(showSlot.substring(index+1));
				int classId =  Integer.parseInt(request.getParameter("class"));
				
				int seatsSelected=Integer.parseInt(request.getParameter("seatselect"));
				
				System.out.println("seats selected are "+seatsSelected);
				
				System.out.println("showid is df "+showId );

				request.setAttribute("selectedLocation", locationId);
				request.setAttribute("selectedTheater", theaterId);
				request.setAttribute("selectedMovie", movieId);
				request.setAttribute("selectedshowdate", showDate);
				request.setAttribute("selectedshowslot", showSlot.substring(0, index));
				System.out.println("selectedshowclassflag "+classId);
				request.setAttribute("selectedshowclass", classId);
				request.setAttribute("seatselection", seatsSelected);
				
//				System.out.println("location id in controller is "+locationId);
				try{
						theaterList=tModel.getTheaterList(locationId);
						movieList=mModel.getMovieListByTheater(theaterId);
						showDateList=sModel.getShowDateListByMovie(movieId);
						showSlotList=sModel.getShowSlotListByMovieDate(movieId,showDate);
						showClassList=cModel.getClassByShow(showId);
						System.out.println("class size is"+showClassList.size());
					}
				
					catch(Exception e){}
					request.setAttribute("movielist", movieList);
					request.setAttribute("theaterlist", theaterList);
					request.setAttribute("showdatelist", showDateList);
					request.setAttribute("showslotlist", showSlotList);
					request.setAttribute("showclasslist", showClassList);
					
					movieFlag=true;
					request.setAttribute("setMovieFlag", movieFlag);
					theaterFlag=true;
					request.setAttribute("setTheaterFlag", theaterFlag);
					locationFlag=true;
					request.setAttribute("setLocationFlag", locationFlag);
					showDateFlag=true;
					request.setAttribute("setShowDateFlag", showDateFlag);
					showSlotFlag=true;
					request.setAttribute("setShowSlotFlag", showSlotFlag);								
					showClassFlag=true;
					request.setAttribute("setShowClassFlag", showClassFlag);
					seatSelectionFlag=true;
					request.setAttribute("setseatselectionflag", seatSelectionFlag);					
					//finalSubmit=true;
					
			}
						
			if(action!=null&& action.equalsIgnoreCase("finalbook")){
				System.out.println("final submit in classaction "+finalSubmit);count++;
			  System.out.println("hello");
				int seatsBooked=Integer.parseInt(request.getParameter("seatselect"));	
				System.out.println("seats bookeda are "+seatsBooked);
				int movieId =  Integer.parseInt(request.getParameter("movie"));						
				String showDate=request.getParameter("showdate");
				String showSlot=request.getParameter("showslot");
				int index=showSlot.indexOf(" ");
//				System.out.println("showslot is "+showSlot);
				int showId=Integer.parseInt(showSlot.substring(index+1));
				
				int classId =  Integer.parseInt(request.getParameter("class"));
				int price = 0,seats = 0;
				ClassModel classModel=new ClassModel();
				try {
					 price = classModel.getPriceByClassId(classId,showId);
					 seats = classModel.getSeatsByClassId(classId,showId);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				
				HttpSession session1 = request.getSession();
				String emailId=(String) session1.getAttribute("user");
				
				System.out.println("classid is "+classId);
				BookingModel bModel=new BookingModel();
				
				price*=seatsBooked;
				price+=10;
				
				try {
					if(seatsBooked<=seats)
					{	int totalseats=classModel.getTotalSeatsById(classId,showId);
						int remainingseats=classModel.getReainingSeatsById(classId,showId);
						String s="";
						for(int i=totalseats-remainingseats+1;i<totalseats-remainingseats+1+seatsBooked;i++)
							s+=i+", ";
						
						bookingBean=bModel.bookTicket(classId,showId,emailId,price,seatsBooked,s);
						classModel.updateRemainingSeats(seatsBooked,classId,showId);
						mBean=mModel.viewMovieById(movieId);
						finalBookingFlag=true;
					}
					else
					{
						seatsFlag=true;							
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
				if(seatsFlag==false)
				{
					if(finalBookingFlag==false&&userFlag==true)
					{
						request.setAttribute("errormsg", "");					
						RequestDispatcher disp=request.getRequestDispatcher("JSP/Autopopulate.jsp");
						disp.forward(request, response);
					}
					else if(finalBookingFlag==true&&userFlag==true)
					{
						String showSlot=request.getParameter("showslot");
						int index=showSlot.indexOf(" ");
//						System.out.println("showslot is "+showSlot);
						String showslot=showSlot.substring(0,index+1);
						request.setAttribute("finalbooking", bookingBean);
						request.setAttribute("finalbookingmovie", mBean);
						request.setAttribute("showdate", request.getParameter("showdate").substring(0, 11));
						request.setAttribute("showslot", showslot);						
						RequestDispatcher disp=request.getRequestDispatcher("JSP/booking.jsp");
						disp.forward(request, response);
					}
				}
				else
				{
					request.setAttribute("errormsg",  "*not enough seats available");
					//PrintWriter out=response.getWriter();					
					//out.print("not enough seats available");
					RequestDispatcher disp=request.getRequestDispatcher("JSP/Autopopulate.jsp");
					disp.include(request, response);
				}
					
	}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//		Httprequest request = request.getrequest();
	

	}

}

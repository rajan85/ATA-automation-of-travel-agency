package com.ata.serlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ata.bean.ReservationBean;
import com.ata.dao.*;

import com.ata.services.*;

/**
 * Servlet implementation class ReservationServlet
 */
public class ReservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	
		String resId= request.getParameter("resId");
		String userId= request.getParameter("uid");
		String vehicleId= request.getParameter("vid");
		String routeId= request.getParameter("rid");
		String bookingdate= request.getParameter("bookdate");
		String jdate= request.getParameter("jdate");
		String driverId= request.getParameter("driverid");
		String bookstatus= request.getParameter("status");
		String tfare= request.getParameter("totalfare");
		String board= request.getParameter("boarding");
		String drop= request.getParameter("drop");
		
		ReservationBean reBean = new ReservationBean();
		reBean.setReservationID(resId);
		reBean.setUserID(userId);
		reBean.setvehicleID(vehicleId);
		reBean.setRouteID(routeId);
			
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date dd2 = null;
		try {
			dd2 = s.parse(jdate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		SimpleDateFormat s1 = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date dd = null;
		try {
			dd = s1.parse(bookingdate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		reBean.setBookingDate(new java.sql.Date(dd.getTime()));
		reBean.setJourneyDate(new java.sql.Date(dd2.getTime()));
		reBean.setDriverID(driverId);
		reBean.setBookingStatus(bookstatus);	
		double totalfare = Double.parseDouble(tfare);		
		reBean.setTotalFare(totalfare);
		reBean.setBoardingPoint(board);
		reBean.setdroppingpoint(drop);
		
		boolean status=false;
		ServletContext sc = request.getServletContext();
		HttpSession session= request.getSession();
		
		if("approved".equals(bookstatus))
		{
			AdministratorImpl administratorImpl= new AdministratorImpl();
			status=administratorImpl.allotDriver(reBean.getReservationID(),reBean.getDriverID());

			if(status==true)
			{
				session.setAttribute("UpdateStatus", "Driver Alloted Successfully !!!");
				RequestDispatcher rd = sc.getRequestDispatcher("/admin.jsp");
				rd.forward(request, response);
			}
			else
			{
				session.setAttribute("UpdateStatus", "Driver Could Not Be Allotted !!!");
				RequestDispatcher rd = sc.getRequestDispatcher("/admin.jsp");
				rd.forward(request, response);
			}
		}
		else
		{
			session.setAttribute("UpdateStatus", "Select Approve option to Allot Driver !!!");
			RequestDispatcher rd = sc.getRequestDispatcher("/admin.jsp");
			rd.forward(request, response);
		}
		
	}

	/**
	 * @param request Function Parameter
	 * @param response Function Parameter
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * @throws ServletException Throws any Servlet Exception
	 * @throws IOException Throws any IO Exception
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{

		String vehicleID=request.getParameter("vehicleid");
		String routeId=request.getParameter("routeid");
		String bookingDate=request.getParameter("jdate");
		String jDate=request.getParameter("jdate");
		String boardingPoint=request.getParameter("boarding");
		String droppingPoint=request.getParameter("dropping");
		
	
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date dd2 = null;
		try {
			dd2 = s.parse(jDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		SimpleDateFormat s1 = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date dd3 = null;
		try {
			dd3 = s.parse(bookingDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
	
		
		
		
		HttpSession session = request.getSession();
		ServletContext sc = request.getServletContext();
		if(dd2.after(dd3))
		{
			
		
		ReservationBean resBean = new ReservationBean();
		resBean.setBookingDate(new java.sql.Date(dd3.getTime()));
		resBean.setJourneyDate(new java.sql.Date(dd2.getTime()));		
		
		
		
		
		
		String userId =(String)session.getAttribute("userid");	

		resBean.setUserID(userId);
		resBean.setvehicleID(vehicleID);
		resBean.setRouteID(routeId);
		resBean.setDriverID("Du1006");
		resBean.setBookingStatus("To be paid");
		
		ReservationDao reDaoImpl = new ReservationDaoImpl();
		double fare= 234.4;
		
		session.setAttribute("sessionfare",fare);
		
		resBean.setTotalFare(fare);
		resBean.setBoardingPoint(boardingPoint);
		resBean.setdroppingpoint(droppingPoint);		
		
		String status="FAIL";
		
		CustomerImpl customerImpl= new CustomerImpl();
		status=customerImpl.bookVehicle(resBean);
		
	
		if(status.length()==8)
		{
			session.setAttribute("fare", fare);
			RequestDispatcher rd = sc.getRequestDispatcher("/payment.jsp");
			rd.forward(request, response);			
		}
		else if("FAIL".equals(status))
		{		
			session.setAttribute("UpdateStatus", "Payment Could Not be Completed !!!");			
			RequestDispatcher rd = sc.getRequestDispatcher("/userhome.jsp");
			rd.forward(request, response);		
		}
		else
		{
			session.setAttribute("UpdateStatus", "Some Error Occured, PLease try Again !!!");
			RequestDispatcher rd = sc.getRequestDispatcher("/userhome.jsp");
			rd.forward(request, response);			
		}
		
		
		
		}
		else
		{
			session.setAttribute("UpdateStatus", "Select Appropriate Date of Journey !!!");
			RequestDispatcher rd = sc.getRequestDispatcher("/user.jsp");
			rd.forward(request, response);	
		}
		
		
		
	}

}

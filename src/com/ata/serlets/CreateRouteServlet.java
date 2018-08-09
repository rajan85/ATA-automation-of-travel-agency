package com.ata.serlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ata.bean.RouteBean;
import com.ata.services.Administrator;
import com.ata.services.AdministratorImpl;

/**
 * Servlet implementation class CreateRouteServlet
 */
public class CreateRouteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String source  = request.getParameter("source");
		String destination  = request.getParameter("destination");
		String distance  = request.getParameter("distance");
		String duration  = request.getParameter("duration");
		
		RouteBean rb = new RouteBean();
		rb.setSource(source);
		rb.setDestination(destination);
		rb.setDistance(Integer.parseInt(distance));
		rb.setTravelDuration(Double.parseDouble(duration));
		
		Administrator ad = new AdministratorImpl();
		String result = ad.addRoute(rb);
		HttpSession session = request.getSession();
		if(result.length()==8)
		{
			System.out.println("==============");
			session.setAttribute("status", "Registered Route's id is "+result);
		}
		else if( result.equals("FAIL") || result.equals("INVALID") )
		{
			System.out.println("++++++++++++++++++");
			session.setAttribute("status", "Route couldn't be registered");
		}
		else if( source.equalsIgnoreCase(destination) )
		{
			System.out.println("################");
			session.setAttribute("status", "source and destination can't be same");
			RequestDispatcher rd = request.getRequestDispatcher("/adminhome.jsp");
			rd.forward(request, response);
		}
		else
		{
			System.out.println("-------------");
			session.setAttribute("status", "Route couldn't be registered");
		}
		RequestDispatcher rd = request.getRequestDispatcher("/adminhome.jsp");
		rd.forward(request, response);
		
	}

}

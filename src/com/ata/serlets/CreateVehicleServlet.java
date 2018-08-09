package com.ata.serlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ata.bean.VehicleBean;
import com.ata.services.Administrator;
import com.ata.services.AdministratorImpl;

/**
 * Servlet implementation class CreateVehicleServlet
 */
public class CreateVehicleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String type = request.getParameter("type");
		String regnum = request.getParameter("rnumber");
		String cap = request.getParameter("capacity");
		String fare = request.getParameter("fpkm");
		
		VehicleBean vb = new VehicleBean();
		vb.setName(name);
		vb.setType(type);
		vb.setRegistrationNumber(regnum);
		vb.setSeatingCapacity(Integer.parseInt(cap));
		vb.setFarePerKM(Double.parseDouble(fare));
		
		Administrator ad = new AdministratorImpl();
		String result = ad.addVehicle(vb);
		HttpSession session = request.getSession();
		if(result.length()==6)
		{
			System.out.println("==============");
			session.setAttribute("status", "Registered vehicle's id is "+result);
		}
		else if( result.equals("FAIL") || result.equals("INVALID") )
		{
			System.out.println("++++++++++++++++++");
			session.setAttribute("status", "vehicle couldn't be registered");
		}
		else
		{
			System.out.println("-------------");
			session.setAttribute("status", "vehicle couldn't be registered");
		}
		RequestDispatcher rd = request.getRequestDispatcher("/adminhome.jsp");
		rd.forward(request, response);
		
		
	}

}

package com.ata.serlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ata.bean.VehicleBean;
import com.ata.services.Customer;
import com.ata.services.CustomerImpl;

/**
 * Servlet implementation class VehicleByType
 */
public class VehicleByType extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VehicleByType() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type = request.getParameter("type");
		Customer c = new CustomerImpl();
		ArrayList<VehicleBean> ar ;
		boolean notNull = false;
		
		ar= c.viewVehiclesByType(type);
		if(ar!=null)
		{
			notNull = true;
		}
		HttpSession session = request.getSession();
		
		if(notNull==true)
		{
			session.setAttribute("vehiclelist", ar);
			RequestDispatcher rd = request.getRequestDispatcher("/viewVehicleByType.jsp");
			rd.forward(request, response);
		}
		else
		{
			session.setAttribute("status", "no Vehicle registered");
			RequestDispatcher rd = request.getRequestDispatcher("/userhome.jsp");
			rd.forward(request, response);
		}
	}

}

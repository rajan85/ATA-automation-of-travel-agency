package com.ata.serlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ata.bean.DriverBean;
import com.ata.services.Administrator;
import com.ata.services.AdministratorImpl;

/**
 * Servlet implementation class CreateDriverServlet
 */
public class CreateDriverServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateDriverServlet() {
        super();
    }

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String street = request.getParameter("street");
		String location = request.getParameter("location");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String pin= request.getParameter("pin");
		String mno = request.getParameter("mno");
		String lno = request.getParameter("lno");
		
		DriverBean db = new DriverBean();
		db.setName(name);
		db.setStreet(street);
		db.setLocation(location);
		db.setCity(city);
		db.setState(state);
		db.setPincode(pin);
		db.setMobileNo(mno);
		db.setLicenseNumber(lno);
		
		Administrator admin = new AdministratorImpl();
		String result = admin.addDriver(db);
		HttpSession session = request.getSession();
		if(result.length()==6)
		{
			System.out.println("==============");
			session.setAttribute("status", "Registered Driver's id is "+result);
		}
		else if( result.equals("FAIL") || result.equals("INVALID") )
		{
			System.out.println("++++++++++++++++++");
			session.setAttribute("status", "driver couldn't be registered");
		}
		else
		{
			System.out.println("-------------");
			session.setAttribute("status", "driver couldn't be registered");
		}
		RequestDispatcher rd = request.getRequestDispatcher("/adminhome.jsp");
		rd.forward(request, response);
		
	}

}

package com.ata.serlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ata.bean.DriverBean;
import com.ata.bean.VehicleBean;
import com.ata.dao.DriverDao;
import com.ata.dao.DriverDaoImpl;
import com.ata.dao.VehicleDao;
import com.ata.dao.VehicleDaoImpl;

/**
 * Servlet implementation class VehicleViewServlet
 */
public class VehicleViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VehicleViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		VehicleDao dd  = new VehicleDaoImpl();
		boolean notNull = false;
		ArrayList<VehicleBean>  ar = dd.findAll();
		if(ar!=null)
		{
			notNull=true;
		}
		
		HttpSession session = request.getSession();
		
		if(notNull==true)
		{
			session.setAttribute("vehiclelist", ar);
			RequestDispatcher rd = request.getRequestDispatcher("/viewVehicle.jsp");
			rd.forward(request, response);
		}
		else
		{
			session.setAttribute("status", "no Vehicle registered");
			RequestDispatcher rd = request.getRequestDispatcher("/adnimhome.jsp");
			rd.forward(request, response);
		}
	}

}

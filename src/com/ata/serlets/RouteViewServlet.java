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
import com.ata.bean.RouteBean;
import com.ata.dao.DriverDao;
import com.ata.dao.DriverDaoImpl;
import com.ata.dao.RouteDao;
import com.ata.dao.RouteDaoImpl;

/**
 * Servlet implementation class RouteViewServlet
 */
public class RouteViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RouteViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RouteDao dd  = new RouteDaoImpl();
		boolean notNull = false;
		ArrayList<RouteBean>  ar = dd.findAll();
		if(ar!=null)
		{
			notNull=true;
		}
		
		HttpSession session = request.getSession();
		
		if(notNull==true)
		{
			session.setAttribute("routelist", ar);
			RequestDispatcher rd = request.getRequestDispatcher("/viewRoute.jsp");
			rd.forward(request, response);
		}
		else
		{
			session.setAttribute("status", "no Route registered");
			RequestDispatcher rd = request.getRequestDispatcher("/adnimhome.jsp");
			rd.forward(request, response);
		}
	}

	

}

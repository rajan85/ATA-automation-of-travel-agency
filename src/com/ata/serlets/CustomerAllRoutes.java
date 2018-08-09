package com.ata.serlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ata.bean.RouteBean;
import com.ata.dao.RouteDao;
import com.ata.dao.RouteDaoImpl;

/**
 * Servlet implementation class CustomerAllRoutes
 */
public class CustomerAllRoutes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerAllRoutes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
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
			RequestDispatcher rd = request.getRequestDispatcher("/customerViewRoute.jsp");
			rd.forward(request, response);
		}
		else
		{
			session.setAttribute("status", "no Route registered");
			RequestDispatcher rd = request.getRequestDispatcher("/userhome.jsp");
			rd.forward(request, response);
		}
	}

}

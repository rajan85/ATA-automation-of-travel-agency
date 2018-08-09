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
import com.ata.dao.DriverDao;
import com.ata.dao.DriverDaoImpl;

/**
 * Servlet implementation class DriverViewServlet
 */
public class DriverViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DriverViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DriverDao dd  = new DriverDaoImpl();
		boolean notNull = false;
		ArrayList<DriverBean>  ar = dd.findAll();
		if(ar!=null)
		{
			notNull=true;
		}
		
		HttpSession session = request.getSession();
		
		if(notNull==true)
		{
			session.setAttribute("driverlist", ar);
			RequestDispatcher rd = request.getRequestDispatcher("/viewdriver.jsp");
			rd.forward(request, response);
		}
		else
		{
			session.setAttribute("status", "no Driver registered");
			RequestDispatcher rd = request.getRequestDispatcher("/adnimhome.jsp");
			rd.forward(request, response);
		}
	}

}

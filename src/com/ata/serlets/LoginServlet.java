package com.ata.serlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.Security;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ata.bean.CredentialsBean;
import com.ata.util.Encryption;
import com.ata.util.User;
import com.ata.util.UserImpl;
import com.ata.util.Encryption.EncryptionException;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("uname");
		Security.addProvider(new com.sun.crypto.provider.SunJCE());
		final byte[] keyBytes = "0123456789ABCDEF01234567".getBytes("ASCII");
		final byte[] IVBytes = "ABCDEFGH".getBytes("ASCII");
		Encryption enc;
		try {
			enc = new Encryption(keyBytes, IVBytes);
			String pass = request.getParameter("pass");
			String encPass = enc.encrypt(pass);
			HttpSession session = request.getSession();
			session.setAttribute("status", "None");
			session.setAttribute("viewallstatus", "None");
			
			session.setAttribute("userid", uname);
			CredentialsBean cBean = new CredentialsBean();
			cBean.setUserID(uname);
			cBean.setPassword(encPass);
			
			User user = new UserImpl();
			String status = user.login(cBean);
			
			
			if(status.equalsIgnoreCase("a"))
			{
				session.setAttribute("status", "Admin signed in successfully");
				RequestDispatcher rd = request.getRequestDispatcher("/adminhome.jsp");
				rd.forward(request, response);
			}
			else if (status.equalsIgnoreCase("u"))
			{
				session.setAttribute("status", "User signed in successfully");
				RequestDispatcher rd = request.getRequestDispatcher("/userhome.jsp");
				rd.forward(request, response);
			}
			else if(status.equals("INVALID"))
			{
				PrintWriter pw = response.getWriter();
				pw.println("Invalid username or password");
				RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
				rd.include(request, response);
			}
			else
			{
				PrintWriter pw = response.getWriter();
				pw.println("Invalid username or password....");
				RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
				rd.include(request, response);
			}
		} catch (EncryptionException e) {
			e.printStackTrace();
		}
	}

}

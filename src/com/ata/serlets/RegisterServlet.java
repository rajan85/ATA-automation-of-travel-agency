package com.ata.serlets;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ata.bean.CredentialsBean;
import com.ata.bean.ProfileBean;
import com.ata.dao.ProfileDao;
import com.ata.dao.ProfileDaoImpl;
import com.ata.util.UserImpl;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String dob = request.getParameter("dob");
		String gender = request.getParameter("gender");
		String street = request.getParameter("street");
		String location = request.getParameter("location");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String pincode = request.getParameter("pincode");
		String moblie = request.getParameter("mobile");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String cPassword = request.getParameter("cpassword");
		
		ProfileBean profilebean = new ProfileBean();
		
		profilebean.setFirstName(fname);
		profilebean.setLastName(lname);
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date d = null;
		try {
			d = s.parse(dob);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		profilebean.setDateOfBirth(new java.sql.Date(d.getTime()));
		profilebean.setGender(gender);
		profilebean.setCity(city);
		profilebean.setLocation(location);
		profilebean.setState(state);
		profilebean.setStreet(street);
		profilebean.setPincode(pincode);
		profilebean.setMobileNo(moblie);
		profilebean.setEmailID(email);
		
		CredentialsBean cb = new CredentialsBean();
		ProfileDao pd = new ProfileDaoImpl();
		cb.setPassword(password);
		UserImpl userImpl = new UserImpl();
		String flag = null;
		if(password.equals(cPassword)){
		 flag = userImpl.register(cb, fname.substring(0,2));
		}
		profilebean.setUserid(flag);
		String status = null;
		if(!(flag.equals("FAIL") || flag.equals("INVALID")))
		{
			status = pd.createProfile(profilebean);
		}
		ServletContext sc = request.getServletContext();
		HttpSession session = request.getSession();
		
		if(status.equals("SUCCESS")){
			session.setAttribute("userid", flag);
			RequestDispatcher rd = sc.getRequestDispatcher("/userhome.jsp");
			rd.forward(request, response);
		}
		else 
		{
			session.setAttribute("registration", "incomplete");
			RequestDispatcher rd = sc.getRequestDispatcher("/again.jsp");
			rd.forward(request, response);
		}
		
		
		

	}

}

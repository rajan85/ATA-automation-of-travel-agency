<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.ata.bean.DriverBean" %>
<%@ page import="java.util.Iterator" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

		<div id="subheader">

			<%@ include file="subheaderadmin.jsp"%>
		</div>
		<div id="body">
			<div id="left" style="width:300px; float:left;">
				<%@ include file="adminleft.jsp"%>
			</div>
			<%
				if (session.getAttribute("userid") == null) {
					response.sendRedirect("index.jsp");
				}
			%>
			
			
			<%

			if (session.getAttribute("userid") == null) {
				response.sendRedirect("index.jsp");
			}
			else
			{
				ArrayList<DriverBean> alistDriver = (ArrayList) session.getAttribute("driverlist");
				DriverBean dbean = new DriverBean();
				Iterator itr = alistDriver.iterator();
				int i = 1;
			%></div>
			<br>
			<br>
			
			<br>
			<br><br>
			<br><br>
			<br>
			<br><br>
			
			<br>
			<br><br>
			<br><br>
			
			<br>
			<br><br>
			<br><br>
			<br><br>
			
			<br>
			<br><br>
			<br><br>
			
			<br>
			<br><br>
			<br><br>
			
			<br>
			<br><br>
			<br>
			<br>
			
	<table border="3px" cellspacing="1"  cellpadding="3" align="center" id="viewdriver">
		<tr>			
			<th >ID</th>
			<th >Name</th>
			<th>Street</th>
			<th>Location</th>
			<th >City</th>
			<th>PinCode</th>
			<th>Mobile No.</th>
			<th>License Number</th>
			<th>State</th>
			<th>Update</th>
			<th>Delete</th>
		</tr>
		<%
			while (itr.hasNext()) 
			{
				dbean = (DriverBean) itr.next();
		%>
		<tr>
			<form name="f4" method="post" action="DriverServlet">								
				<td ><input name="id" type="text"  size="6" maxlength="6" readonly="readonly"  value="<%=dbean.getDriverID()%>"></td>
				<td ><%=dbean.getName()%></td>
				<td><%=dbean.getStreet()%></td>
				<td><%=dbean.getLocation()%></td>
				<td ><%=dbean.getCity()%></td>
				<td><%=dbean.getPincode()%></td>
				<td><%=dbean.getMobileNo()%></td>
				<td ><%=dbean.getLicenseNumber()%></td>
				<td><%=dbean.getState()%></td>		
				<td><a href='DriverServlet?driveID=<%=dbean.getDriverID()%>'> Update</a></td>
				<td><a href='DriverDeleteServlet?driverID=<%=dbean.getDriverID()%>'> Delete</a></td>		
			</form>
		</tr>
					<%	
			}}
					%>
	</table>	
			
			
				
			
		<br><br><br><br><br><br><br><br>
			
			<br>
			<br><br>
			<br><br>
			
			<br>
			<br><br>
			<br>
			<%@ include file="footer.html"%>
		
</body>
</html>
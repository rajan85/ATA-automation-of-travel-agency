<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.ata.bean.VehicleBean" %>
<%@ page import="java.util.ArrayList" %>
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
				<%@ include file="userleft.jsp"%>
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
				ArrayList<VehicleBean> alistVehicle= (ArrayList)session.getAttribute("vehiclelist");
				VehicleBean vbean = new VehicleBean();
				Iterator itr= alistVehicle.iterator();
			%></div>
			<br>
			<br>
			<br><br>
			<br>
			<br><br>
			<br>
			<br><br>
			<br>
			<br><br>
			<br>
			<br><br>
			<br>
			<br><br>
			<br>
			<br><br>
			<br>
			<br><br>
			<br>
			<br><br>
			<br>
			<br><br>
			<br>
			<br>
			
		<table border="3px" cellspacing="1" cellpadding="3" align="center">
		<tr>

			<th>ID</th>
			<th>Name</th>
			<th>Type</th>
			<th>Registration Number</th>
			<th>Seating Capacity</th>
			<th>Fare Per Km</th>

		</tr>
		<%
			while (itr.hasNext()) 
			{
				
				vbean = (VehicleBean) itr.next();
		%>
		<tr>
			<form name="f4" method="post">

				<td><input name="id" type="text" size="6" maxlength="6"
					readonly="readonly" value="<%=vbean.getVehicleID()%>"></td>
				<td><%=vbean.getName()%></td>
				<td><%=vbean.getType()%></td>
				<td><%=vbean.getRegistrationNumber()%></td>
				<td><%=vbean.getSeatingCapacity()%></td>
				<td><%=vbean.getFarePerKM()%></td>
			</form>
		</tr>
		<%	
			}}
		%>
	</table>	
				
			<br><br><br><br><br><br><br>
			<%@ include file="footer.html"%>
		
</body>
</html>
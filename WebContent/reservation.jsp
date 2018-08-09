<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page  import="com.ata.dao.VehicleDao"	import="com.ata.dao.VehicleDaoImpl" %>
<%@ page  import="com.ata.dao.RouteDao"	import="com.ata.dao.RouteDaoImpl" %>
<%@ page import="com.ata.bean.RouteBean"	import="com.ata.bean.VehicleBean" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body >
<div id="subheader">

			<%@ include file="subheaderadmin.jsp"%>
		</div>
		<div id="body" style="width:1300px;">
			<div id="left" style="width:300px; float:left;">
				<%@ include file="userleft.jsp"%>
			</div>
			<div id = "right">
			
			<%
				if (session.getAttribute("userid") == null) {
					response.sendRedirect("index.jsp");
				}
				else 
				{
					VehicleDao vd = new VehicleDaoImpl();
					ArrayList<VehicleBean> allVehicles = vd.findAll();
					Iterator itrVehicle = allVehicles.iterator();
					
					RouteDao rd = new RouteDaoImpl();
					ArrayList<RouteBean> allRoutes = rd.findAll();
					Iterator itrRoute = allRoutes.iterator();
					
				
			%>
			
				<form name="f12" method="post" action="ReservationServlet">
					<br>
					<table align="center">
						<tr>
							<td>Vehicle</td>
							<td><select name="vehicleid">
									<%
										while (itrVehicle.hasNext()) {
											VehicleBean vbean = (VehicleBean) itrVehicle.next();
									%>
									<option value="<%=vbean.getVehicleID()%>">
										<%=vbean.getName()%>
									</option>
									<%
										}
									%>
							</select></td>
						</tr>
						<tr>
							<td>Route</td>
							<td><select name="routeid">
									<%
										while (itrRoute.hasNext()) {
											RouteBean rbean = (RouteBean) itrRoute.next();
									%>
									<option value="<%=rbean.getRouteID()%>">
										<%=rbean.getSource()%>-<%=rbean.getDestination()%>
									</option>
									<%
										}
									%>
							</select></td>
						</tr>
						<tr>
							<td>Booking Date</td>
							<td><input TYPE="date"  NAME="bdate"  required></td>
						</tr>
						<tr>
							<td>Journey Date</td>
							<td>
									<input TYPE="date"  NAME="jdate"  required>						
								</td>
						</tr>

						<tr>
							<td>Boarding Point</td>
							<td><input name="boarding" type="text"></td>
						</tr>
						<tr>
							<td>Dropping Point</td>
							<td><input name="dropping" type="text"></td>
						</tr>
						<tr>
							<td></td>
							<td><input name="submit" type="submit" value="Book Journey">
							</td>
						</tr>
					</table>
					<br>
				</form>
				<% } %>
				</div>
	<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
	</div>
			<%@ include file="footer.html"%>
		
</body>
</html>
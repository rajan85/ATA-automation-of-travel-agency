<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.ata.bean.RouteBean" %>

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
					ArrayList<RouteBean> alistRoute= (ArrayList)session.getAttribute("routelist");
					RouteBean rbean = new RouteBean();
					Iterator itr= alistRoute.iterator();
					int i=1;
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
			<th>Route ID</th>
			<th>Source</th>
			<th>Destination</th>
			<th>Distance</th>
			<th>Duration</th>
		</tr>
		<%
			while (itr.hasNext()) 
			{
				i++;
				rbean = (RouteBean) itr.next();
		%>
		<tr>
			<form name="f4" method="post">				
				
				<td ><input name="id" type="text"  size="8" maxlength="8" readonly="readonly"  value="<%=rbean.getRouteID()%>"></td>
				<td ><%=rbean.getSource()%></td>
				<td><%=rbean.getDestination()%></td>
				<td><%=rbean.getDistance()%></td>
				<td ><%=rbean.getTravelDuration()%></td>
			</form>
		</tr>
		
	<%  	}	}	%>
	</table>
			
				
			<br><br><br><br><br><br><br>
			<%@ include file="footer.html"%>
		
</body>
</html>
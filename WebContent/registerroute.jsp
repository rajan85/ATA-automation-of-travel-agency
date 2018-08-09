<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
		<div id="body" style="width:1300px;">
			<div id="left" style="width:300px; float:left;">
				<%@ include file="adminleft.jsp"%>
			</div>
			<%
				if (session.getAttribute("userid") == null) {
					response.sendRedirect("index.jsp");
				}
			%></div>
			
				<form name="f7" method="post" action="CreateRouteServlet" >
					<br><br><br><br><br><br><br><br><br>
					<table align="center" border="3px" >
			<tr>
				<td>Source</td>
				<td><input name="source" type="text"></td>
			</tr>
			<tr>
				<td>Destination</td>
				<td><input name="destination" type="text"  ></td>
			</tr>
			<tr>
				<td>Distance(in Km.)</td>
				<td><input name="distance" type="text" value="in (Kms)"
											style="color: #888;" onfocus="inputFocus(this)"
											onblur="inputBlur(this)"></td>
			</tr>
			<tr>
				<td>Travel Duration</td>
				<td><input name="duration" type="text" value="in (minutes)" 
											style="color: #888;" onfocus="inputFocus(this)"
											onblur="inputBlur(this)"></td>
			</tr>
			
			<tr>
				
				<td><input name="submit" type="submit" value="Register Route">
				</td>
			</tr>
		</table>
		<br>
	</form>
	<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
			<%@ include file="footer.html"%>
		
</body>
</html>
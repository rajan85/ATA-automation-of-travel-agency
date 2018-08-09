<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Vehicle By Type</title>
</head>
<body >
<div id="subheader">

			<%@ include file="subheaderadmin.jsp"%>
		</div>
		<div id="body" style="width:1300px;">
			<div id="left" style="width:300px; float:left;">
				<%@ include file="userleft.jsp"%>
			</div>
			<%
				if (session.getAttribute("userid") == null) {
					response.sendRedirect("index.jsp");
				}
			%></div>
			
				<form name="f132" method="post" action="VehicleBySeats">
					<br><br><br><br><br><br><br><br><br>
				<table cellspacing="1" cellpadding="3" align="center"  >
							<tr>
							
							<td><select name="seats">
									<option value="1">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
									<option value="4">4</option>
									<option value="5">5</option>
									<option value="6">6</option>
									<option value="7">7</option>
									</select>
									</td>
						</tr>
						<tr>
							
							<td><input name="submit" type="submit" value="View">
							</td>
						</tr>
						
				</table>
				<br>
				</form>
	<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
			<%@ include file="footer.html"%>
		
</body>
</html>
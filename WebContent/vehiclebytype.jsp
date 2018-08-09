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
			
				<form name="f131" method="post" action="VehicleByType">
					<br><br><br><br><br><br><br><br><br>
				<table  cellspacing="1" cellpadding="3" align="center" >								
					<tr>					
							<tr>
							
							<td><select name="type">
									<option value="AC">AC</option>
									<option value="NON-AC">NON-AC</option>
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
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div id="full">
		<div id="header">
			<%@ include file="header.html"%>
		</div>
		<div id="subheader">

			<%@ include file="subheaderadmin.jsp"%>
		</div>
		<div id="body" style="width:1300px;">
			<div id="left" style="width:300px; float:left;" >
				<%@ include file="adminleft.jsp"%>
			</div>
			<%
				if (session.getAttribute("userid") == null) {
					response.sendRedirect("index.jsp");
				}
			%>
			<div id="right" style="width:1000px; height:340px; float:right;">

				Register Driver Details
				<form name="f3" method="post" action="CreateDriverServlet" ">
					<br>
					<table >
						<tr>
							<td>Name</td>
							<td><input name="name" type="text"></td>
						</tr>
						<tr>
							<td>Street</td>
							<td><input name="street" type="text"></td>
						</tr>
						<tr>
							<td>Location</td>
							<td><input name="location" type="text"></td>
						</tr>
						<tr>
							<td>City</td>
							<td>
							
							<select name="city" id="city">
									<option value="Lucknow">Lucknow</option>
									<option value="Ludhiana">Ludhiana</option>
									<option value="Agra">Agra</option>
									<option value="Chennai">Chennai</option>
									<option value="Bangalore">Bangalore</option>
									<option value="Pune">Pune</option>
									<option value="Vishakhapatnam">Vishakhapatnam</option>
									<option value="Merrut">Merrut</option>
									<option value="Bareily">Bareily</option>
									<option value="Ghaziabad">Ghaziabad</option>
									<option value="Mumbai">Mumbai</option>
									<option value="Srinagar">Srinagar</option>
									<option value="Kolkata">Kolkata</option>
									<option value="Kochi">Kochi</option>
									<option value="Patna">Patna</option>
									<option value="Bhubhaneshwar">Bhubhaneshwar</option>
									<option value="Dharbhanga">Dharbhanga</option>
									<option value="Hyderabad">Hyderabad</option>
									<option value="Durgapur">Durgapur</option>
									<option value="Jaipur">Jaipur</option>
								</select>
								</td>
						</tr>
						<tr>
							<td>State</td>
							<td>
							
							<select name="state" id="state">
									<option value="andhrapradesh">Andhra Pradesh</option>
									<option value="arunachalpradesh">Arunachal Pradesh</option>
									<option value="delhi">Delhi</option>
									<option value="westbengal">West Bengal</option>
									<option value="jharkhand">Jharkhand</option>
									<option value="uttarpradesh">Uttar Pradesh</option>
									<option value="utrakhand">Utrakhand</option>
									<option value="punjab">Punjab</option>
									<option value="tamilnadu">Tamil Nadu</option>
									<option value="haryana">Haryana</option>
									<option value="assam">Assam</option>
									<option value="jammuandkashmir">Jammu and Kashmir</option>
									<option value="himachalpradesh">Himachal Pradesh</option>
									<option value="kerala">Kerala</option>
									<option value="karnataka">Karnataka</option>
									<option value="maharastra">Maharastra</option>
									<option value="bihar">Bihar</option>
									<option value="orrisa">Orrisa</option>
									<option value="gujarat">Gujarat</option>
									<option value="rajasthan">Rajasthan</option>
								</select>
								</td>
						</tr>
						<tr>
							<td>PinCode</td>
							<td><input name="pin" type="text" maxlength="6"></td>
						</tr>
						<tr>
							<td>Mobile Number</td>
							<td><input name="mno" type="text" maxlength="10"></td>
						</tr>
						<tr>
							<td>Licence Number</td>
							<td><input name="lno" type="text"></td>
						</tr>
						<tr>
							<td></td>
							<td><input name="submit" type="submit"
								value="Register Driver"></td>
						</tr>
					</table>
					<br>
				</form>
			</div>
		</div>
		<div id="footer">
			<%@ include file="footer.html"%>
		</div>
	</div>
</body>
</html>
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
		<div id="header"><%@ include file="header.html" %>
		</div>
		<div id="body">
		<div id="bodyleft">
				
			</div>
			<div id="bodyright">
				<br>
				<form name="f2" method="post" action="RegisterServlet" >
					<br>
					<table align="center">
						<tr>
							<td>FIRST NAME</td>
							<td><input name="fname" type = "text"  PLACEHOLDER="rajan " required>
						</td></tr>
						<tr>
							<td>LAST NAME</td>
							<td><input name="lname" type = "text"  PLACEHOLDER="gupta" required></td>
						 <tr>
					<td>DATE OF BIRTH(dd-mm-yyyy):</td>
					<td><input TYPE="date" PLACEHOLDER="e.g. 2017-09-21" NAME="dob"
						  required><br></td>
					</tr>  -->

<tr>
							<td>GENDER</td>
							<td>
							<select name="gender">
									<option value="Male">Male</option>
									<option value="Female">Female</option>
									<option value="other">Other</option>
							</select>
								</td>
						</tr>
<tr>
							<td>Street</td>
							<td><input name="street" type="text" ></td>
						</tr>
						<tr>
							<td>Location</td>
							<td><input name="location" type="text" required></td>
						</tr>
						<tr>
							<td>City</td>
							<td>
							
							<select name="city" id="city" required>
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
							
							<select name="state" id="state" required>
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
							<td><input name="pincode" type="text" maxlength="6" required></td>
						</tr> 
						<tr>
							<td>Mobile Number</td>
							<td><input name="mobile" type="text" maxlength="10" required></td>
						</tr>
						<tr>
							<td>Email Id</td>
							<td><input name="email" type="text" required></td>
						</tr>
						<tr>
							<td>password</td>
							<td><input name="password" type="password" required></td>
						</tr>
						<tr>
							<td>Confirm Password</td>
							<td><input name="cpassword" type="password" required></td>
						</tr>
						
						<tr>
							<td></td>
							<td><input name="submit" type="submit" value="Register">
							</td>
						</tr>
					</table>
		
		
		
		
		
		
		</div>
				<div id="footer">

			<%@ include file="footer.html"%>
		</div>
	</div>

</body>
</html>
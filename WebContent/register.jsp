<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

	<meta charset="UTF-8">
	
	<link rel="stylesheet" href="css/style.css" type="text/css">

<title>register</title>
</head>
<body style= "background-image : url('atabg8.jpg')">
<%@include file="header.html" %>
<br><br>

<div class="form-box">
<form name="f2" method="post" action="RegisterServlet" >
<input type="text" name="fname" id="fn" placeholder="enter ur first name" required><br><br>
<input type="text" name="lname" id="ln" placeholder="enter ur last name" required><br><br>
<input TYPE="date" PLACEHOLDER="e.g. 2017-09-21" NAME="dob"  required><br><br>
<input name="street" type="text" placeholder="enter ur street" required><br><br>
<input name="location" type="text" placeholder="enter ur location" required><br><br>
<input name="city" type="text" placeholder="enter ur city" required><br><br>
<input name="state" type="text" placeholder="enter state name" required><br><br>
<input name="pincode" type="text" maxlength="6" placeholder="enter pincode" required><br><br>

<select id="nm"><option>+91</option><option>+92</option><option>+93</option><option>+94</option></select>
<input type="number" name="mobile" id="ph" placeholder="enter ur number" required><br><br>
<input type="radio" name="gender" id="rd"><span id="ml">Male</span><input type="radio" name="gender" id="rd"><span id="ml">FeMale</span><br><br>
<input type="email" name="email" id="em" placeholder="enter ur email address" required><br><br>
<input type="password" name="password" id="pw" placeholder="enter ur password" required><br><br>
<input name="cpassword" type="password" placeholder="confirm password"  required><br><br>
<input type="submit" value="Register" name="submit" id="reg">
</div>
<%@include file="footer.html" %>
</body>
</html>
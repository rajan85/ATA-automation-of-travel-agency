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
		<div id="bleft"></div>
			<div id="bright">
			<H2>Forgot Password Page</H2>
			
<form name="forgot Form" method="POST" action="ForgotPasswordServlet">

<br>
					<table>
						<tr>
							<td>ENTER URERID</td>
							<td><input type="text" name="userid" required></td>
						</tr>
						<tr>
							<td>What is your favourite color?</td>
							<td><input type="text" name="ans" requires></td>
						</tr>
						<tr>
							<td></td>
							<td><input type="submit" value="SUBMIT"></td>
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
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
		<div id="body">
			<div id="left" style="width:300px; float:left;">
				<%@ include file="adminleft.jsp"%>
			</div>
			<%
				if (session.getAttribute("userid") == null) {
					response.sendRedirect("index.jsp");
				}
			%>
			<div id="right" style="width:1000px; height:340px; float:right;">

				
			</div>
		</div>
		<div id="footer">
			<%@ include file="footer.html"%>
		</div>
	</div>
</body>
</html>
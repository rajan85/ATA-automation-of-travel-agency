<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Home</title>
</head>
<body >

<%
if(session.getAttribute("userid") == null)
{
	response.sendRedirect("index.jsp");
}
else {
	String userId = (String)session.getAttribute("userId");
}
%>

	<%@include file="subheaderadmin.jsp" %>
	</div>
	
	<div id="body" style="width:1300px;">
		
		<div id="left" style="width:300px; float:left;">
			<%@include file="adminleft.jsp" %>
		</div>
		
		<div id="right" style="width:1000px; height:340px; float:right;">
		
		<%if(!(session.getAttribute("status") == "None"))
		{
			String status = (String)session.getAttribute("status");
		
			
		%>
		<br><br>
				<div >
					<h2><%= status  %>
					</h2>
				</div>
				
		<%} %>
		</div>
		
	</div>
	
	<%-- <div id="footer">
			<%@ include file="footer.html"%>
		</div> --%>
	
</div>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
			
			
			
			
			
			
			
			
			
<%@include file="footer.html" %>

</body>
</html>
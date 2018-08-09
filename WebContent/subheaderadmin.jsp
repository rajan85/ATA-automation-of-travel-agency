<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="com.ata.bean.ProfileBean" %>
  <%@ page import="com.ata.dao.ProfileDao" %>
   <%@ page import="com.ata.dao.ProfileDaoImpl" %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body style= "background-image : url('atabg8.jpg');background-size: cover";>
<%@include file="header.html" %>
<br><br><br><br>
<%
String userId = (String)session.getAttribute("userid");
ProfileDao pd = new ProfileDaoImpl();
ProfileBean pb = pd.findByID(userId);

%>
<div class="subheader-box">
<table border="0" width="100%" align="center" cellpadding="5" >
		<tr><td><button><h1 >Welcome <%=pb.getFirstName() %>!!!</h1></button></td>
			<td></td>
			<td></td>
			<td><button class="button1"><a href="adminhome.jsp">Home</button></a></td>

			<td><form method="link" action="LogoutServlet">
    <button type="submit" class="logout_button" value="Logout"/>Logout
</button></form>
			</td> 
		</tr>
	</table>
	</div>

</body>
</html>
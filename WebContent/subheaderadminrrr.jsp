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
<body>
<%
String userId = (String)session.getAttribute("userid");
ProfileDao pd = new ProfileDaoImpl();
ProfileBean pb = pd.findByID(userId);

%>
<table border="0" width="100%" align="center" cellpadding="5" >
		<tr>

			<td>Welcome <%=pb.getFirstName() %>!!!</td>
			<td></td>
			<td></td>
			<td width="120px" align="center"><div
					style="background-color: white"><a href="adminhome.jsp">Home</a></div></td>

			<td width="120px" align="center">
				<div style="background-color: white"><a href="LogoutServlet"> Logout</a></div>
			</td> 
		</tr>
	</table>
</body>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.ecommerce.LoginDao"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="loginBean" class="com.ecommerce.LoginBean"
		scope="session"></jsp:useBean>
		<jsp:setProperty name="loginBean" property="*" />
		
<%
String result = LoginDao.loginCheck(loginBean);
if(result.equals("true")){
session.setAttribute("email",loginBean.getEmail());
response.sendRedirect("dashboard.jsp");
}
 
if(result.equals("false")){
response.sendRedirect("index.jsp?status=false");
}
 
if(result.equals("error")){
    response.sendRedirect("index.jsp?status=error");
}
%>	
</body>
</html>
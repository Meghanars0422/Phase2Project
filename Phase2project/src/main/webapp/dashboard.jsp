<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	String email = (String) session.getAttribute("email");
	//redirect user to login page if not logged in
	if (email == null) {
		response.sendRedirect("index.jsp");
	}
	%>
	<p>Welcome to the Learner's Academy</p>
	<br>

	<p>1.  Click on the student details link to view the Class Report</p>
	<a href="details">Student Details</a>
	<br>
	<br>

	<p>2.  Click on the class details link to view Classes assigned for subjects</p>
	<a href="classdetails">Class Details</a>
	<br>
	<br>

	<p>3.  Click on the teacher details link to view Teachers assigned to a class for subjects</p>
	<a href="teacherdetails">Teacher Details</a>
	<br>
	<br>

	<p>4.  Click on the logout link to logout</p>
	<a href="logout.jsp">Logout</a>
</body>
</html>
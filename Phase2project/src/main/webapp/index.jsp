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
        String email=(String)session.getAttribute("email");
        
        //redirect user to home page if already logged in
        if(email!=null){
            response.sendRedirect("dashboard.jsp");
        }
 
        String status=request.getParameter("status");
        
        if(status!=null){
         if(status.equals("false")){
            out.print("Incorrect login details!");           
         }
         else{
         out.print("Some error occurred!");
         }
        }
        %>
    
        <form action="login.jsp" method="post">
            <table cellpadding="5">
                <tr>
                    <td><b>Email:</b></td>
                    <td><input type="text" name="email" required/></td>
                </tr>
 
                <tr>
                    <td><b>Password:</b></td>
                    <td><input type="password" name="password" required/></td>
                </tr>
 
                <tr>
                    <td colspan="2" align="center"><input type="submit" value="Login"/></td>
                </tr>
 
            </table>
        </form>
</body>
</html>
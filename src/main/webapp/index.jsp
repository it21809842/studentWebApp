<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Insert Student</h1>

<form action="<%= request.getContextPath() %>/AddStudentServlet" method="post">

First Name <input type="text" name="FirstName">
Last Name <input type="text" name="LastName">
Address <input type="text" name="Address">
Mobile Number <input type="text" name="MobileNo">
<input type="submit" value="add student"  >

</form>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.student.model.*" %>
<%@ page import="com.student.service.*" %>
<%@ page import="java.util.ArrayList" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Update Student</title>
</head>
<body>
    <h2>Update Student</h2>
    <% 
        String studentID = (String) request.getAttribute("studentID");

        iStudentService iStudentService = new studentServiceImpl();
        ArrayList<Student> studentList = iStudentService.getStudentByID(studentID);
    %>

    <%
        for (Student students : studentList) {
    %>
    <form action="<%= request.getContextPath()%>/updatestudentServlet" method="post">

        Student ID <input type="text" name="studentID" value="<%= students.getStudentID() %>" disabled>
        First Name <input type="text" name="FirstName" value="<%= students.getFirstName() %>" disabled>
        Last Name <input type="text" name="LastName" value="<%= students.getLastName() %>" disabled>
        Address <input type="text" name="Address" value="<%= students.getAddress() %>" disabled>
        Mobile Number <input type="text" name="MobileNo" value="<%= students.getMobileNo() %>" disabled>
        <input type="submit" value="update">
    </form>

    <%
        } // end for loop
    %>

</body>
</html>

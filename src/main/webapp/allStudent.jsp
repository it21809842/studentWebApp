<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.student.model.*" %>
<%@ page import="com.student.service.*" %>
<%@ page import="java.util.ArrayList" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Student List</title>
</head>
<body>
    <h2>All Students</h2>
    <table>
        <thead>
            <tr>
                <th>Student ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Address</th>
                <th>Mobile Number</th>
            </tr>
        </thead>
        <tbody>
            <% 
                iStudentService iStudentService = new studentServiceImpl();
                ArrayList<Student> studentList = iStudentService.getStudents();

                for (Student students : studentList) {
            %>
            <tr>
                <td><%= students.getStudentID() %></td>
                <td><%= students.getFirstName() %></td>
                <td><%= students.getLastName() %></td>
                <td><%= students.getAddress() %></td>
                <td><%= students.getMobileNo() %></td>
                <td>
                    <form action="<%= request.getContextPath() %>/GetstudentServlet" method="post">
                        <input type="hidden" name="studentID" value="<%= students.getStudentID() %>">
                        <input type="submit" value="Edit">
                    </form>
                </td>
                <td>
                    <form action="<%= request.getContextPath() %>/DeletestudentServlet" method="post">
                        <input type="hidden" name="studentID" value="<%= students.getStudentID() %>">
                        <input type="submit" value="Delete">
                    </form>
                </td>
            </tr>
            <% 
                } // end for loop
            %>
        </tbody>
    </table>
</body>
</html>

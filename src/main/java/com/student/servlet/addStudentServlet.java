package com.student.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.model.Student;
import com.student.service.iStudentService;
import com.student.service.studentServiceImpl;

@WebServlet("/addStudentServlet")  // Specify the servlet mapping
public class addStudentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public addStudentServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");

        Student student = new Student();

        student.setFirstName(request.getParameter("FirstName"));
        student.setLastName(request.getParameter("LastName"));
        student.setAddress(request.getParameter("Address"));
        student.setMobileNo(request.getParameter("MobileNo"));

        iStudentService istudentService = new studentServiceImpl();
        istudentService.addStudent(student);

        request.setAttribute("student", student);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/allStudent.jsp");
        dispatcher.forward(request, response);
    }
}

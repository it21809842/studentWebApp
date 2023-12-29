package com.student.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.model.Student;
import com.student.service.iStudentService;
import com.student.service.studentServiceImpl;

public class updatestudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public updatestudentServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
response.setContentType("text/html");
		
		Student student = new Student();
		String studentID = request.getParameter("studentID");
		student.setStudentID(studentID);
		
		student.setFirstName(request.getParameter("FirstName"));
		student.setLastName(request.getParameter("LastName"));
		student.setAddress(request.getParameter("Address"));
		student.setMobileNo(request.getParameter("MobileNo"));
		
		System.out.println(student.getStudentID());

		
		iStudentService istudentservice = new studentServiceImpl();
		istudentservice.updateStudent(studentID,student);
		
		request.setAttribute("student", student);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/assStudent.jsp");
		dispatcher.forward(request,response);
	}

}

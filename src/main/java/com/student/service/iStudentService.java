package com.student.service;


import java.util.ArrayList;

import com.student.model.Student;

public interface iStudentService {

	public void addStudent(Student student);
	
	public ArrayList<Student> getStudents();
	public ArrayList<Student> getStudentByID(String studentID);
	
	public void updateStudent(String studentID,Student student);
	public void deleteStudent(String studentID,Student student);

	public void deleteStudent(String studentID);


	
	
}

package com.student.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.student.model.Student;
import com.student.util.DBConnection;
import com.student.util.QueryUtil;
import com.student.util.commonConstants;
import com.student.util.commonUtil;

public class studentServiceImpl implements iStudentService {

    private static Connection connection;
    private static Statement stmt;
    private static PreparedStatement prepareStatement;

    static {
        createStudentTable();
    }

    private static void createStudentTable() {

        try {
            connection = DBConnection.getDBConnection();

            stmt = connection.createStatement();
            stmt.execute(QueryUtil.queryById(commonConstants.QUERY_ID_CREATE_STUDENT_TABLE));
        } catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
            System.out.println("Create table exception" + e.getMessage());
        } finally {

            try {
                if (connection != null) {
                    connection.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public void addStudent(Student student) {
        String studentIDs = commonUtil.generateStudentIds(getStudentIDs());

        try {

            connection = DBConnection.getDBConnection();

            prepareStatement = connection.prepareStatement(QueryUtil.queryById(commonConstants.QUERY_ID_INSERT_STUDENT));
            connection.setAutoCommit(false);

            student.setStudentID(studentIDs);

            prepareStatement.setString(commonConstants.COLUM_INDEX_ONE, student.getStudentID());
            prepareStatement.setString(commonConstants.COLUM_INDEX_TWO, student.getFirstName());
            prepareStatement.setString(commonConstants.COLUM_INDEX_THREE, student.getLastName());
            prepareStatement.setString(commonConstants.COLUM_INDEX_FOUR, student.getAddress());
            prepareStatement.setString(commonConstants.COLUM_INDEX_FIVE, student.getMobileNo());

            prepareStatement.executeLargeUpdate();
            connection.commit();

        } catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {

            try {
                if (connection != null) {
                    connection.close();
                }

                if (prepareStatement != null) {
                    prepareStatement.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public ArrayList<Student> getStudents() {
        ArrayList<Student> studentList = new ArrayList<Student>();

        try {
            connection = DBConnection.getDBConnection();

            prepareStatement = connection
                    .prepareStatement(QueryUtil.queryById(commonConstants.QUERY_ID_GET_ALL_STUDENT));
            ResultSet rs = prepareStatement.executeQuery();
            while (rs.next()) {
                Student st = new Student();
                st.setStudentID(rs.getString(commonConstants.COLUM_INDEX_ONE));
                st.setFirstName(rs.getString(commonConstants.COLUM_INDEX_TWO));
                st.setLastName(rs.getString(commonConstants.COLUM_INDEX_THREE));
                st.setAddress(rs.getString(commonConstants.COLUM_INDEX_FOUR));
                st.setMobileNo(rs.getString(commonConstants.COLUM_INDEX_FIVE));

                studentList.add(st);
            }
        } catch (SQLException | SAXException | IOException | ParserConfigurationException
                | ClassNotFoundException e) {
            System.out.println(e.getMessage());

        } finally {

            try {
                if (connection != null) {
                    connection.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return studentList;
    }

    @Override
    public ArrayList<Student> getStudentByID(String studentID) {
        ArrayList<Student> studentList = new ArrayList<Student>();

        try {
            connection = DBConnection.getDBConnection();

            prepareStatement = connection
                    .prepareStatement(QueryUtil.queryById(commonConstants.QUERY_ID_GET_STUDENT_BY_ID));
            prepareStatement.setString(commonConstants.COLUM_INDEX_ONE, studentID);
            ResultSet rs = prepareStatement.executeQuery();
            while (rs.next()) {
                Student st = new Student();
                st.setStudentID(rs.getString(commonConstants.COLUM_INDEX_ONE));
                st.setFirstName(rs.getString(commonConstants.COLUM_INDEX_TWO));
                st.setLastName(rs.getString(commonConstants.COLUM_INDEX_THREE));
                st.setAddress(rs.getString(commonConstants.COLUM_INDEX_FOUR));
                st.setMobileNo(rs.getString(commonConstants.COLUM_INDEX_FIVE));

                studentList.add(st);
            }
        } catch (SQLException | SAXException | IOException | ParserConfigurationException
                | ClassNotFoundException e) {
            System.out.println(e.getMessage());

        } finally {

            try {
                if (connection != null) {
                    connection.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return studentList;
    }

    @Override
    public void updateStudent(String studentID, Student student) {
        try {
            connection = DBConnection.getDBConnection();

            System.out.println(" from student try at update student method " + studentID);

            prepareStatement = connection.prepareStatement(QueryUtil.queryById(commonConstants.QUERY_ID_UPDATE_STUDENT));
            connection.setAutoCommit(false);

            prepareStatement.setString(commonConstants.COLUM_INDEX_ONE, student.getFirstName());
            prepareStatement.setString(commonConstants.COLUM_INDEX_TWO, student.getLastName());
            prepareStatement.setString(commonConstants.COLUM_INDEX_THREE, student.getAddress());
            prepareStatement.setString(commonConstants.COLUM_INDEX_FOUR, student.getMobileNo());
            prepareStatement.setString(commonConstants.COLUM_INDEX_FIVE, student.getStudentID());

            prepareStatement.executeLargeUpdate();
            connection.commit();

        } catch (SQLException | SAXException | IOException | ParserConfigurationException
                | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {

            try {
                if (connection != null) {
                    connection.close();
                }

                if (prepareStatement != null) {
                    prepareStatement.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public void deleteStudent(String studentID) {
        if (studentID != null && !studentID.isEmpty()) {

            try {
                connection = DBConnection.getDBConnection();

                prepareStatement = connection
                        .prepareStatement(QueryUtil.queryById(commonConstants.QUERY_ID_DELETE_STUDENT));
                prepareStatement.setString(commonConstants.COLUM_INDEX_ONE, studentID);

                prepareStatement.execute();

            } catch (SQLException | SAXException | IOException | ParserConfigurationException
                    | ClassNotFoundException e) {
                System.out.println(e.getMessage());

            } finally {

                try {

                    if (connection != null) {
                        connection.close();
                    }

                    if (prepareStatement != null) {
                        prepareStatement.close();
                    }
                } catch (SQLException e) {
                }
            }
        }
    }

    public ArrayList<String> getStudentIDs() {
        ArrayList<String> ids = new ArrayList<String>();

        try {
            connection = DBConnection.getDBConnection();

            prepareStatement = connection
                    .prepareStatement(QueryUtil.queryById(commonConstants.QUERY_ID_GET_STUDENT_IDS));
            ResultSet rs = prepareStatement.executeQuery();
            while (rs.next()) {
                ids.add(rs.getString(commonConstants.COLUM_INDEX_ONE));
            }

        } catch (SQLException | SAXException | IOException | ParserConfigurationException
                | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {

            try {

                if (prepareStatement != null) {
                    prepareStatement.close();
                }

                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                return ids;
            }
        }

        return ids;
    }

	@Override
	public void deleteStudent(String studentID, Student student) {
		// TODO Auto-generated method stub
		
	}
}

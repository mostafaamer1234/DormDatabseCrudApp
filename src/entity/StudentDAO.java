/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import core.*;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
/**
 *
 * @author Gokhan
 */
public class StudentDAO implements DAO<Student>
{   
    public StudentDAO() {
        
    }
    List<Student> Students;
    /**
     * Get a single Student entity as a Student object
     * @param id
     * @return 
     */
    @Override
    public Optional<Student> get(int id) {
        DB db = DB.getInstance();
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM AP_Student WHERE Student_ID = ?";
            PreparedStatement stmt = db.getPreparedStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            Student Student = null;
            while (rs.next()) {
                Student = new Student(rs.getInt("Student_ID"), rs.getString("Student_FirstName"),rs.getString("Student_LastName"),rs.getString("DateOfBirth"),rs.getString("SchoolEmail"),rs.getString("PhoneNumber"));
            }
            return Optional.ofNullable(Student);
        } catch (SQLException ex) {
            System.err.println(ex.toString());
            return null;
        }
    }
    
    /**
     * Get all Student entities as a List
     * @return 
     */
    @Override
    public List<Student> getAll() {
        DB db = DB.getInstance();
        ResultSet rs = null;
        Students = new ArrayList<>();
        try {
            String sql = "SELECT * FROM AP_Student";
            rs = db.executeQuery(sql);
            Student Student = null;
            while (rs.next()) {
                Student = new Student(rs.getInt("Student_ID"), rs.getString("Student_FirstName"),rs.getString("Student_LastName"),rs.getString("DateOfBirth"),rs.getString("SchoolEmail"),rs.getString("PhoneNumber"));
                Students.add(Student);
            }
            return Students;
        } catch (SQLException ex) {
            System.err.println(ex.toString());
            return null;
        }
    }
    
    /**
     * Insert a Student object into Student table
     * @param checkIn 
     */
    @Override
    public void insert(Student checkIn)
    {
        DB db = DB.getInstance();
        try {
            String sql = "INSERT INTO AP_Student(Student_ID, Student_FirstName, Student_LastName, DateOfBirth, SchoolEmail, PhoneNumber) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = db.getPreparedStatement(sql);
            stmt.setInt(1, checkIn.getStudent_ID());
            stmt.setString(2, checkIn.getStudent_FirstName());
            stmt.setString(3, checkIn.getStudent_LastName());
            stmt.setString(4, checkIn.getDateOfBirth());
            stmt.setString(5, checkIn.getSchoolEmail());
            stmt.setString(6, checkIn.getPhoneNumber());
            int rowInserted = stmt.executeUpdate();
            if (rowInserted > 0) {
                System.out.println("A new Student was inserted successfully!");
            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
    }
    
    /**
     * Update a Student entity in database if it exists using a Student object
     * @param checkIn
     */
    @Override
    public void update(Student checkIn) {
        DB db = DB.getInstance();
        try {
            String sql = "UPDATE AP_Student SET Student_FirstName=?, Student_LastName=?, DateOfBirth=?, SchoolEmail=?, PhoneNumber=? WHERE Student_ID=?";
            PreparedStatement stmt = db.getPreparedStatement(sql);
            stmt.setString(1, checkIn.getStudent_FirstName());
            stmt.setString(2, checkIn.getStudent_LastName());
            stmt.setString(3, checkIn.getDateOfBirth());
            stmt.setString(4, checkIn.getSchoolEmail());
            stmt.setString(5, checkIn.getPhoneNumber());
            stmt.setInt(6, checkIn.getStudent_ID());
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("An existing Student was updated successfully!");
            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
    }
    
    /**
     * Delete a Student from Student table if the entity exists
     * @param Student 
     */
    @Override
    public void delete(Student Student) {
        DB db = DB.getInstance();
        try {
            String sql = "DELETE FROM AP_Student WHERE Student_ID = ?";
            PreparedStatement stmt = db.getPreparedStatement(sql);
            stmt.setInt(1, Student.getStudent_ID());
            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("A Student was deleted successfully!");
            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
    }
    
    /**
     * Get all column names in a list array
     * @return 
     */
    @Override
    public List<String> getColumnNames() {
        DB db = DB.getInstance();
        ResultSet rs = null;
        List<String> headers = new ArrayList<>();
        try {
            String sql = "SELECT * FROM AP_Student WHERE Student_ID = -1";
//We just need this sql query to get the column headers
            rs = db.executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();
            //Get number of columns in the result set
            int numberCols = rsmd.getColumnCount();
            for (int i = 1; i <= numberCols; i++) {
                headers.add(rsmd.getColumnLabel(i));//Add column headers to the list
            }
            return headers;
        } catch (SQLException ex) {
            System.err.println(ex.toString());
            return null;
        } 
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import core.DB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author mta5343
 */
public class AssignmentDAO implements DAO<Assignment>{
    
    public AssignmentDAO() {
        
    }
    List<Assignment> Assignments;
    /**
     * Get a single Assignment entity as an Assignment object
     * @param id
     * @return 
     */
    @Override
    public Optional<Assignment> get(int id) {
        DB db = DB.getInstance();
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM AP_Assignment WHERE Assignment_ID = ?";
            PreparedStatement stmt = db.getPreparedStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            Assignment Assignment = null;
            while (rs.next()) {
                Assignment = new Assignment(rs.getInt("Assignment_ID"),rs.getString("DateAssigned"),rs.getInt("Student_ID"),rs.getInt("Room_ID"),rs.getInt("Staff_ID"));
            }
            return Optional.ofNullable(Assignment);
        } catch (SQLException ex) {
            System.err.println(ex.toString());
            return null;
        }
    }
    
    /**
     * Get all Assignment entities as a List
     * @return 
     */
    @Override
    public List<Assignment> getAll() {
        DB db = DB.getInstance();
        ResultSet rs = null;
        Assignments = new ArrayList<>();
        try {
            String sql = "SELECT * FROM AP_Assignment";
            rs = db.executeQuery(sql);
            Assignment Assignment = null;
            while (rs.next()) {
                Assignment = new Assignment(rs.getInt("Assignment_ID"),rs.getString("DateAssigned"),rs.getInt("Student_ID"),rs.getInt("Room_ID"),rs.getInt("Staff_ID"));
                Assignments.add(Assignment);
            }
            return Assignments;
        } catch (SQLException ex) {
            System.err.println(ex.toString());
            return null;
        }
    }
    
    /**
     * Insert an Assignment object into Assignment table
     * @param Assignment 
     */
    @Override
    public void insert(Assignment Assignment)
    {
        DB db = DB.getInstance();
        try {
            String sql = "INSERT INTO AP_Assignment(Assignment_ID, DateAssigned, Student_ID, Room_ID, Staff_ID) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = db.getPreparedStatement(sql);
            stmt.setInt(1, Assignment.getAssignment_ID());
            stmt.setString(2, Assignment.getDateAssigned());
            stmt.setInt(3, Assignment.getStudent_ID());
            stmt.setInt(4, Assignment.getRoom_ID());
            stmt.setInt(5, Assignment.getStaff_ID());
            int rowInserted = stmt.executeUpdate();
            if (rowInserted > 0) {
                System.out.println("A new Assignment was inserted successfully!");
            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
    }
    
    /**
     * Update an Assignment entity in database if it exists using an Assignment object
     * @param Assignment
     */
    @Override
    public void update(Assignment Assignment) {
        DB db = DB.getInstance();
        try {
            String sql = "UPDATE AP_Assignment SET DateAssigned=?,Student_ID=?, Room_ID=?, Staff_ID=? WHERE Assignment_ID=?";
            PreparedStatement stmt = db.getPreparedStatement(sql);
            stmt.setString(1, Assignment.getDateAssigned());
            stmt.setInt(2, Assignment.getStudent_ID());
            stmt.setInt(3, Assignment.getRoom_ID());
            stmt.setInt(4, Assignment.getStaff_ID());
            stmt.setInt(5, Assignment.getAssignment_ID());
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("An existing Assignment was updated successfully!");
            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
    }
    
    /**
     * Delete an Assignment from Assignment table if the entity exists
     * @param Assignment 
     */
    @Override
    public void delete(Assignment Assignment) {
        DB db = DB.getInstance();
        try {
            String sql = "DELETE FROM AP_Assignment WHERE Assignment_ID = ?";
            PreparedStatement stmt = db.getPreparedStatement(sql);
            stmt.setInt(1, Assignment.getAssignment_ID());
            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("An Assignment was deleted successfully!");
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
            String sql = "SELECT * FROM AP_Assignment WHERE Assignment_ID = -1";
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

    


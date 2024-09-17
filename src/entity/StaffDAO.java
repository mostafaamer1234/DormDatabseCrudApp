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
public class StaffDAO implements DAO<Staff>{
    
    public StaffDAO() {
        
    }
    List<Staff> Staff;
    /**
     * Get a single Student entity as a Student object
     * @param id
     * @return 
     */
    @Override
    public Optional<Staff> get(int id) {
        DB db = DB.getInstance();
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM AP_Staff WHERE Staff_ID = ?";
            PreparedStatement stmt = db.getPreparedStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            Staff Staff = null;
            while (rs.next()) {
                Staff = new Staff(rs.getInt("Staff_ID"), rs.getString("Staff_FirstName"),rs.getString("Staff_LastName"),rs.getString("HireDate"),rs.getString("StaffPosition"),rs.getString("StaffDepartment"),rs.getString("StaffPhoneNumber"),rs.getString("SchoolEmail"));
            }
            return Optional.ofNullable(Staff);
        } catch (SQLException ex) {
            System.err.println(ex.toString());
            return null;
        }
    }
    
    /**
     * Get all Staff entities as a List
     * @return 
     */
    @Override
    public List<Staff> getAll() {
        DB db = DB.getInstance();
        ResultSet rs = null;
        Staff = new ArrayList<>();
        try {
            String sql = "SELECT * FROM AP_Staff";
            rs = db.executeQuery(sql);
            Staff staff = null;
            while (rs.next()) {
                staff = new Staff(rs.getInt("Staff_ID"), rs.getString("Staff_FirstName"),rs.getString("Staff_LastName"),rs.getString("HireDate"),rs.getString("StaffPosition"),rs.getString("StaffDepartment"),rs.getString("StaffPhoneNumber"),rs.getString("SchoolEmail"));
                Staff.add(staff);
            }
            return Staff;
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
    public void insert(Staff checkIn)
    {
        DB db = DB.getInstance();
        try {
            String sql = "INSERT INTO AP_Staff(Staff_ID, Staff_FirstName, Staff_LastName, HireDate, StaffPosition, StaffDepartment, StaffPhoneNumber, SchoolEmail) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = db.getPreparedStatement(sql);
            stmt.setInt(1, checkIn.getStaff_ID());
            stmt.setString(2, checkIn.getStaff_FirstName());
            stmt.setString(3, checkIn.getStaff_LastName());
            stmt.setString(4, checkIn.getHireDate());
            stmt.setString(5, checkIn.getStaffPosition());
            stmt.setString(6, checkIn.getStaffDepartment());
            stmt.setString(7, checkIn.getStaffPhoneNumber());
            stmt.setString(8, checkIn.getSchoolEmail());
            int rowInserted = stmt.executeUpdate();
            if (rowInserted > 0) {
                System.out.println("A new Staff was inserted successfully!");
            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
            System.out.println("Wrong Format!");
        }
    }
    
    /**
     * Update a Student entity in database if it exists using a Student object
     * @param checkIn
     */
    @Override
    public void update(Staff checkIn) {
        DB db = DB.getInstance();
        try {
            String sql = "UPDATE AP_Staff SET Staff_FirstName=?, Staff_LastName=?, HireDate=?, StaffPosition=?, StaffDepartment=?, StaffPhoneNumber=?, SchoolEmail=? WHERE Staff_ID=?";
            PreparedStatement stmt = db.getPreparedStatement(sql);
            stmt.setString(1, checkIn.getStaff_FirstName());
            stmt.setString(2, checkIn.getStaff_LastName());
            stmt.setString(3, checkIn.getHireDate());
            stmt.setString(4, checkIn.getStaffPosition());
            stmt.setString(5, checkIn.getStaffDepartment());
            stmt.setString(6, checkIn.getStaffPhoneNumber());
            stmt.setString(7, checkIn.getSchoolEmail());
            stmt.setInt(8, checkIn.getStaff_ID());
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("An existing Staff was updated successfully!");
            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
    }
    
    /**
     * Delete a Student from Student table if the entity exists
     * @param Staff 
     */
    @Override
    public void delete(Staff Staff) {
        DB db = DB.getInstance();
        try {
            String sql = "DELETE FROM AP_Staff WHERE Staff_ID = ?";
            PreparedStatement stmt = db.getPreparedStatement(sql);
            stmt.setInt(1, Staff.getStaff_ID());
            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("A Staff was deleted successfully!");
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
            String sql = "SELECT * FROM AP_Staff WHERE Staff_ID = -1";
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

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
public class RoomDAO implements DAO<Room>
{   
    public RoomDAO() {
        
    }
    List<Room> rooms;
    /**
     * Get a single Room entity as an Room object
     * @param id
     * @return 
     */
    @Override
    public Optional<Room> get(int id) {
        DB db = DB.getInstance();
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM AP_Room WHERE Room_ID = ?";
            PreparedStatement stmt = db.getPreparedStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            Room Room = null;
            while (rs.next()) {
                Room = new Room(rs.getInt("Room_ID"), rs.getInt("RoomNumber"), rs.getString("RoomType"), rs.getInt("RoomPrice"));
            }
            return Optional.ofNullable(Room);
        } catch (SQLException ex) {
            System.err.println(ex.toString());
            return null;
        }
    }
    
    /**
     * Get all Room entities as a List
     * @return 
     */
    @Override
    public List<Room> getAll() {
        DB db = DB.getInstance();
        ResultSet rs = null;
        rooms = new ArrayList<>();
        try {
            String sql = "SELECT * FROM AP_Room";
            rs = db.executeQuery(sql);
            Room Room = null;
            while (rs.next()) {
                 Room = new Room(rs.getInt("Room_ID"), rs.getInt("RoomNumber"), rs.getString("RoomType"), rs.getInt("RoomPrice"));
                rooms.add(Room);
            }
            return rooms;
        } catch (SQLException ex) {
            System.err.println(ex.toString());
            return null;
        }
    }
    
    /**
     * Insert an Room object into Room table
     * @param Room 
     */
    @Override
    public void insert(Room Room)
    {
        DB db = DB.getInstance();
        try {
            String sql = "INSERT INTO AP_Room(Room_ID, RoomNumber, RoomType, RoomPrice) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = db.getPreparedStatement(sql);
            stmt.setInt(1, Room.getRoom_ID());
            stmt.setInt(2, Room.getRoomNumber());
            stmt.setString(3, Room.getRoomType());  
            stmt.setInt(4, Room.getRoomPrice());
            int rowInserted = stmt.executeUpdate();
            if (rowInserted > 0) {
                System.out.println("A new Room was inserted successfully!");
            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
    }
    
    /**
     * Update an Room entity in database if it exists using an Room object
     * @param Room
     */
    @Override
    public void update(Room Room) {
        DB db = DB.getInstance();
        try {
            String sql = "UPDATE AP_Room SET RoomNumber=?, RoomType=?, RoomPrice=? WHERE Room_ID=?";
            PreparedStatement stmt = db.getPreparedStatement(sql);
            stmt.setInt(1, Room.getRoomNumber());
            stmt.setString(2, Room.getRoomType());
            stmt.setInt(3, Room.getRoomPrice());
            stmt.setInt(4, Room.getRoom_ID());
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("An existing Room was updated successfully!");
            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
    }
    
    /**
     * Delete an Room from Room table if the entity exists
     * @param Room 
     */
    @Override
    public void delete(Room Room) {
        DB db = DB.getInstance();
        try {
            String sql = "DELETE FROM AP_Room WHERE Room_ID = ?";
            PreparedStatement stmt = db.getPreparedStatement(sql);
            stmt.setInt(1, Room.getRoom_ID());
            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("An Room was deleted successfully!");
            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
            System.out.println("A violation of foreign key constraint!");
            
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
            String sql = "SELECT * FROM AP_Room WHERE Room_ID = -1";
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

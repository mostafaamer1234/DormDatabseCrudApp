/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;


/**
 *
 * @author Gokhan
 */
public class Room 
{
    private int Room_ID;
    private int RoomNumber;
    private String RoomType;
    private int RoomPrice;

    public int getRoomPrice() {
        return RoomPrice;
    }

    public void setRoomPrice(int RoomPrice) {
        this.RoomPrice = RoomPrice;
    }
    

    public Room(int Room_ID, int RoomNumber, String RoomType, int RoomPrice) {
        this.Room_ID = Room_ID;
        this.RoomNumber = RoomNumber;
        this.RoomType = RoomType;
        this.RoomPrice = RoomPrice;
    }

    public int getRoom_ID() {
        return Room_ID;
    }

    public int getRoomNumber() {
        return RoomNumber;
    }
    

    public String getRoomType() {
        return RoomType;
    }

    @Override
    public String toString() {
        return "Room{" + "Room_ID=" + Room_ID + ", " + "RoomNumber=" + RoomNumber + ", RoomType=" + RoomType +", RoomPrice=" + RoomPrice + '}';
    }



    

    
}

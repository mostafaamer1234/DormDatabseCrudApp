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
public class Assignment 
{
    private int Assignment_ID;
    private String DateAssigned;
    private int Student_ID;
    private int Room_ID;
    private int Staff_ID;
    

    public int getStudent_ID() {
        return Student_ID;
    }

    public void setStudent_ID(int Student_ID) {
        this.Student_ID = Student_ID;
    }

    public int getRoom_ID() {
        return Room_ID;
    }

    public void setRoom_ID(int Room_ID) {
        this.Room_ID = Room_ID;
    }

    public int getStaff_ID() {
        return Staff_ID;
    }

    public void setStaff_ID(int Staff_ID) {
        this.Staff_ID = Staff_ID;
    }
   

    public Assignment(int Assignment_ID, String DateAssigned, int Student_ID, int Room_ID, int Staff_ID) {
        this.Assignment_ID = Assignment_ID;
        this.DateAssigned = DateAssigned;
        this.Student_ID = Student_ID;
        this.Room_ID = Room_ID;
        this.Staff_ID = Staff_ID;
    }

    public int getAssignment_ID() {
        return Assignment_ID;
    }


    

    public String getDateAssigned() {
        return DateAssigned;
    }

    @Override
    public String toString() {
        return "Assignment{" + "Assignment_ID=" + Assignment_ID +  ", DateAssigned=" + DateAssigned +", Student_ID=" + Student_ID +", Room_ID=" + Room_ID +", Staff_ID=" + Staff_ID + '}';
    }

}
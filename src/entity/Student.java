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
public class Student 
{
    private int Student_ID;
    private String Student_FirstName;
    private String Student_LastName;
    private String DateOfBirth;
    private String  SchoolEmail; 
    private String  PhoneNumber;
    

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }
    
    public String getSchoolEmail() {
        return SchoolEmail;
    }

    public void setSchoolEmail(String SchoolEmail) {
        this.SchoolEmail = SchoolEmail;
    }
    public String getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(String DateOfBirth) {
        this.DateOfBirth = DateOfBirth;
    }

    public String getStudent_LastName() {
        return Student_LastName;
    }

    public void setStudent_LastName(String Student_LastName) {
        this.Student_LastName = Student_LastName;
    }
    

    public Student(int Student_ID, String Student_FirstName, String Student_LastName, String DateOfBirth, String SchoolEmail, String PhoneNumber) {
        this.Student_ID = Student_ID;
        this.Student_FirstName = Student_FirstName;
        this.Student_LastName = Student_LastName;
        this.DateOfBirth = DateOfBirth;
        this.SchoolEmail = SchoolEmail;
        this.PhoneNumber = PhoneNumber;
        
    }

    public int getStudent_ID() {
        return Student_ID;
    }

    public String getStudent_FirstName() {
        return Student_FirstName;
    }

    @Override
    public String toString() {
        return "Student{" + "ID=" + Student_ID + ", Firstname=" + Student_FirstName + ", Lastname=" + Student_LastName +", DateOfBirth=" + DateOfBirth +", SchoolEmail=" + SchoolEmail +", PhoneNumber=" + PhoneNumber + '}';
    }

   
}

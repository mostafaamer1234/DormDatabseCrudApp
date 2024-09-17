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
public class Staff 
{
    private int Staff_ID;
    private String Staff_FirstName;
    private String Staff_LastName;
    private String HireDate;
    private String  StaffPosition; 
    private String  StaffDepartment;
    private String  StaffPhoneNumber;
    private String  SchoolEmail;

    public String getSchoolEmail() {
        return SchoolEmail;
    }

    public void setSchoolEmail(String SchoolEmail) {
        this.SchoolEmail = SchoolEmail;
    }

    public String getStaffPhoneNumber() {
        return StaffPhoneNumber;
    }

    public void setStaffPhoneNumber(String StaffPhoneNumber) {
        this.StaffPhoneNumber = StaffPhoneNumber;
    }
    

    public String getStaffDepartment() {
        return StaffDepartment;
    }

    public void setStaffDepartment(String StaffDepartment) {
        this.StaffDepartment = StaffDepartment;
    }
    
    public String getStaffPosition() {
        return StaffPosition;
    }

    public void setStaffPosition(String StaffPosition) {
        this.StaffPosition = StaffPosition;
    }
    public String getHireDate() {
        return HireDate;
    }

    public void setHireDate(String HireDate) {
        this.HireDate = HireDate;
    }

    public String getStaff_LastName() {
        return Staff_LastName;
    }

    public void setStaff_LastName(String Staff_LastName) {
        this.Staff_LastName = Staff_LastName;
    }
    

    public Staff(int Staff_ID, String Staff_FirstName, String Staff_LastName, String HireDate, String StaffPosition, String StaffDepartment, String StaffPhoneNumber, String SchoolEmail) {
        this.Staff_ID = Staff_ID;
        this.Staff_FirstName = Staff_FirstName;
        this.Staff_LastName = Staff_LastName;
        this.HireDate = HireDate;
        this.StaffPosition = StaffPosition;
        this.StaffDepartment = StaffDepartment;
        this.StaffPhoneNumber = StaffPhoneNumber;
        this.SchoolEmail = SchoolEmail;
    }

    public int getStaff_ID() {
        return Staff_ID;
    }

    public String getStaff_FirstName() {
        return Staff_FirstName;
    }

    @Override
    public String toString() {
        return "Staff{" + "Staff_ID=" + Staff_ID + ", Staff_FirstName=" + Staff_FirstName + ", Staff_LastName=" + Staff_LastName +", HireDate=" + HireDate +", StaffPosition=" + StaffPosition +", StaffDepartment=" + StaffDepartment +", StaffPhoneNumber=" + StaffPhoneNumber +", SchoolEmail=" + SchoolEmail + '}';
    }

   
}
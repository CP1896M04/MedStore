package pattern.model;

import java.util.Date;

public class Staff {
   private Integer  StaffID ;
   private String StaffCode ;
   private Integer RoleID ;
   private String FName ;
   private String LName ;
   private Date DOB ;
   private String Address ;
   private String SEX ;
   private String PhoneNo ;
   private String Username ;
   private String Password ;

    public Staff() {

    }


    public Integer getStaffID() {
        return StaffID;
    }

    public void setStaffID(Integer staffID) {
        StaffID = staffID;
    }

    public String getStaffCode() {
        return StaffCode;
    }

    public void setStaffCode(String staffCode) {
        StaffCode = staffCode;
    }

    public Integer getRoleID() {
        return RoleID;
    }

    public void setRoleID(Integer roleID) {
        RoleID = roleID;
    }

    public String getFName() {
        return FName;
    }

    public void setFName(String FName) {
        this.FName = FName;
    }

    public String getLName() {
        return LName;
    }

    public void setLName(String LName) {
        this.LName = LName;
    }

    public Date getDOB() {
        return DOB;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getSEX() {
        return SEX;
    }

    public void setSEX(String SEX) {
        this.SEX = SEX;
    }

    public String getPhoneNo() {
        return PhoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        PhoneNo = phoneNo;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public Staff(Integer staffID, String staffCode, Integer roleID, String FName, String LName, Date DOB, String address, String SEX, String phoneNo, String username, String password) {
        StaffID = staffID;
        StaffCode = staffCode;
        RoleID = roleID;
        this.FName = FName;
        this.LName = LName;
        this.DOB = DOB;
        Address = address;
        this.SEX = SEX;
        PhoneNo = phoneNo;
        Username = username;
        Password = password;
    }
}





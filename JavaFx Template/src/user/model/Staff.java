package user.model;

import java.util.Date;

public class Staff {
    private int StaffID;
    private String RoleID;
    private String FName;
    private String LName;
    private Date DOB;
    private String Address;
    private String Sex;
    private String PhoneNo;
    private String userName;
    private String passWord;

    public Staff(int staffID, String roleID, String FName, String LName, Date DOB, String address, String sex, String phoneNo, String userName, String passWord) {
        StaffID = staffID;
        RoleID = roleID;
        this.FName = FName;
        this.LName = LName;
        this.DOB = DOB;
        Address = address;
        Sex = sex;
        PhoneNo = phoneNo;
        this.userName = userName;
        this.passWord = passWord;
    }

    public int getStaffID() {
        return StaffID;
    }

    public void setStaffID(int staffID) {
        StaffID = staffID;
    }

    public String getRoleID() {
        return RoleID;
    }

    public void setRoleID(String roleID) {
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

    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        Sex = sex;
    }

    public String getPhoneNo() {
        return PhoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        PhoneNo = phoneNo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
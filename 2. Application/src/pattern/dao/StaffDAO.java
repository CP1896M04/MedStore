package pattern.dao;

import pattern.connection.ConnectionFactory;
import pattern.model.Staff;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StaffDAO implements DAO<Staff> {
    private Connection connection;
    public  StaffDAO() {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connection =connectionFactory.getConnection();
    }
    @Override
    public void add(Staff o) {
        String sql="INSERT INTO [dbo].[Staff]\n" +
                "           ([StaffCode]\n" +
                "           ,[RoleID]\n" +
                "           ,[FName]\n" +
                "           ,[LName]\n" +
                "           ,[DOB]\n" +
                "           ,[Address]\n" +
                "           ,[SEX]\n" +
                "           ,[PhoneNo]\n" +
                "           ,[Username]\n" +
                "           ,[Password])\n" +
                "     VALUES\n" +
                "           (?\n" +
                "           ,?\n" +
                "           ,?\n" +
                "           ,?\n" +
                "           ,?\n" +
                "           ,?\n" +
                "           ,?\n" +
                "           ,?\n" +
                "           ,?\n" +
                "           ,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, o.getStaffCode());
            preparedStatement.setInt(2, o.getRoleID());
            preparedStatement.setString(3, o.getFName());
            preparedStatement.setString(4, o.getLName());
            preparedStatement.setDate(5,(Date)o.getDOB());
            preparedStatement.setString(6, o.getAddress());
            preparedStatement.setString(7, o.getSEX());
            preparedStatement.setString(8, o.getPhoneNo());
            preparedStatement.setString(9, o.getUsername());
            preparedStatement.setString(10, o.getPassword());


            preparedStatement.execute();
        } catch (  SQLException e ) {

            throw new RuntimeException(e);
        }

    }

    @Override
    public void remove(String staffID) throws SQLException {
    String sql = "DELETE FROM [dbo].[Staff] WHERE StaffID=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, Integer.parseInt(staffID));
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Staff o) {
        String sql = "UPDATE [dbo].[Staff]\n" +
                "   SET [StaffCode] = ?\n" +
                "      ,[RoleID] = ?\n" +
                "      ,[FName] = ?\n" +
                "      ,[LName] = ?\n" +
                "      ,[DOB] = ?\n" +
                "      ,[Address] = ?\n" +
                "      ,[SEX] = ?\n" +
                "      ,[PhoneNo] = ?\n" +
                "      ,[Username] = ?\n" +
                "      ,[Password] = ?\n" +
                " WHERE StaffID = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, o.getStaffCode());
            preparedStatement.setInt(2, o.getRoleID());
            preparedStatement.setString(3, o.getFName());
            preparedStatement.setString(4, o.getLName());
            preparedStatement.setDate(5, (Date) o.getDOB());
            preparedStatement.setString(6, o.getAddress());
            preparedStatement.setString(7, o.getSEX());
            preparedStatement.setString(8, o.getPhoneNo());
            preparedStatement.setString(9, o.getUsername());
            preparedStatement.setString(10, o.getPassword());
            preparedStatement.setInt(11, o.getStaffID());
            preparedStatement.execute();
        } catch (  SQLException e ) {

            throw new RuntimeException(e);
        }
    }


    @Override
    public List<Staff> getList() {
        List<Staff> staffs = new ArrayList<>();
        String sql = "SELECT [StaffID]\n" +
                "      ,[StaffCode]\n" +
                "      ,[RoleID]\n" +
                "      ,[FName]\n" +
                "      ,[LName]\n" +
                "      ,[DOB]\n" +
                "      ,[Address]\n" +
                "      ,[SEX]\n" +
                "      ,[PhoneNo]\n" +
                "      ,[Username]\n" +
                "      ,[Password]\n" +
                "  FROM [dbo].[Staff]";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int StaffID= resultSet.getInt("StaffID");
                String StaffCode = resultSet.getString("StaffCode");
                int RoleID = resultSet.getInt("RoleID");
                String FName = resultSet.getString("FName");
                String LName = resultSet.getString("LName");
                Date DOB = resultSet.getDate("DOB");
                String Address = resultSet.getString("Address");
                String SEX = resultSet.getString("SEX");
                String PhoneNo = resultSet.getString("PhoneNo");
                String Username = resultSet.getString("Username");
                String Password = resultSet.getString("Password");
                Staff staff= new Staff(StaffID,StaffCode,RoleID,FName,LName,DOB,Address,SEX,PhoneNo,Username,Password);
                staffs.add(staff);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return staffs;
    }
    public Boolean checkExist(String username , String password) {
        boolean exist = false;
        String sql = "SELECT [Username] FROM [dbo].[Staff] WHERE Username = ? and Password = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            int i=0;
            while (resultSet.next()) {
                i++;
            }
            if (i>0){
                exist = true;
                System.out.println("User dang nhap thanh cong");
            }
        } catch (  SQLException e ) {

            throw new RuntimeException(e);
        }
        return exist;
    }

}

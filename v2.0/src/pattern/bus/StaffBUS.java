package pattern.bus;

import javafx.scene.control.Alert;
import javafx.stage.StageStyle;
import pattern.connection.ConnectionFactory;
import pattern.dao.StaffDAO;
import pattern.model.Staff;
import pattern.model.Unit;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StaffBUS  implements BUS<Staff>{
    private Connection connection;
    public  StaffBUS() {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connection = connectionFactory.getConnection();

    }
    StaffDAO staffDAO= new StaffDAO();
    @Override
    public void add(Staff o) {
        if (isUniqName(o)) {
            staffDAO.add(o);
        }
    }

    @Override
    public void update(Staff o) {
        if (isTrueUpdate(o)) {
           staffDAO.update(o);
        } else if (isUniqName(o)) {
         staffDAO.update(o);
        }
    }

    @Override
    public void delete(Staff o) {
        if(staffDAO.isNotUsed(o)){
            try {
               staffDAO.remove(String.valueOf(o));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else{
            //noting
        }
    }

    @Override
    public boolean isTrueUpdate(Staff o) {
        boolean isTreu = false;
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
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                return isTreu;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isTreu;
    }

    @Override
    public boolean isUniqName(Staff o) {
        boolean uniqStaff = false;
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
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println("in not uniq");
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Sucess");
                alert.setHeaderText("ERROR : used");
                alert.setContentText("Brand" + "  '" + o.getLName() + "' " + "Already exist");
                alert.initStyle(StageStyle.UNDECORATED);
                alert.showAndWait();
                return uniqStaff;
            }
        } catch (  SQLException e ) {

            Logger.getLogger(Staff.class.getName()).log(Level.SEVERE, null, e);
        }
        return uniqStaff;
    }
}

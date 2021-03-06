package pattern.dao;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.stage.StageStyle;
import pattern.connection.ConnectionFactory;
import pattern.model.InventoryLedger;
import pattern.model.Role;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoleDAO implements DAO<Role> {
    private Connection connection;
    public  RoleDAO() {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connection = connectionFactory.getConnection();
    }

    @Override
    public void add(Role o) {
        String sql="INSERT INTO [dbo].[Role]\n" +
                "           ([RoleName]\n" +
                "           ,[Descr])\n" +
                "     VALUES\n" +
                "           (?\n" +
                "           ,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, o.getRoleName());
            preparedStatement.setString(2, o.getDescr());
            preparedStatement.execute();
        } catch (  SQLException e ) {

            throw new RuntimeException(e);
        }
    }

    @Override
    public void remove(String roleID) throws SQLException {
        String sql = "DELETE FROM [dbo].[Role] WHERE RoleID = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, Integer.parseInt(roleID));
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Role o) {
        String sql = "UPDATE [dbo].[Role]\n" +
                "   SET [RoleName] = ?\n" +
                "      ,[Descr] = ?\n" +
                " WHERE RoleID = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, o.getRoleName());
            preparedStatement.setString(2, o.getDescr());
            preparedStatement.setInt(3, o.getRoleID());
            preparedStatement.execute();
        } catch (  SQLException e ) {

            throw new RuntimeException(e);
        }
    }

    @Override
    public ObservableList<Role> getList() {
       ObservableList<Role> roles = FXCollections.observableArrayList();
        String sql = "SELECT [RoleID]\n" +
                "      ,[RoleName]\n" +
                "      ,[Descr]\n" +
                "  FROM [dbo].[Role]";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int RoleID= resultSet.getInt("RoleID");
                String RoleName = resultSet.getString("RoleName");
                String Descr = resultSet.getString("Descr");
                Role role= new Role(RoleID,RoleName,Descr);
                roles.add(role);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return roles;
    }
    public boolean isUniqName(Role o) {
        boolean isUniq = false;
        String sql = "select [RoleID] from Role where RoleName=? ";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, o.getRoleName());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("ERROE : Already exist ");
                alert.setContentText("Brand" + "  '" + o.getRoleName() + "' " + "Already exist");
                alert.initStyle(StageStyle.UNDECORATED);
                alert.showAndWait();
                return isUniq;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return isUniq;
    }
    public boolean isUpdate(Role o) {
        boolean isUniq = false;
        String sql = "select [RoleID] from Role where RoleName=? ";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, o.getRoleName());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (!resultSet.next()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("ERROE : Name doesn't exist ");
                alert.setContentText("Brand" + "  '" + o.getRoleName() + "' " + "not exist");
                alert.initStyle(StageStyle.UNDECORATED);
                alert.showAndWait();
                return isUniq;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return isUniq;
    }


}

package pattern.dao;

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
            preparedStatement.execute();
        } catch (  SQLException e ) {

            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Role> getList() {
        List<Role> roles = new ArrayList<>();
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
                Role role= new Role(RoleName,Descr);
                roles.add(role);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return roles;
    }

}

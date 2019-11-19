package pattern.bus;

import javafx.scene.control.Alert;
import javafx.stage.StageStyle;
import pattern.connection.ConnectionFactory;
import pattern.dao.RoleDAO;
import pattern.model.Product;
import pattern.model.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RoleBUS implements  BUS<Role> {
    private Connection connection;
    public  RoleBUS() {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connection = connectionFactory.getConnection();
    }
    RoleDAO roleDAO= new RoleDAO();
    @Override
    public void add(Role o) {
        if (isUniqName(o)) {
          roleDAO.add(o);
        }
    }

    @Override
    public void update(Role o) {
        if (isTrueUpdate(o)) {
            roleDAO.update(o);
        } else if (isUniqName(o)) {
            roleDAO.update(o);
        }
    }

    @Override
    public void delete(Role o) {
        if(roleDAO.isNotUsed(o)){
            try {
                roleDAO.remove(String.valueOf(o));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else{
            //noting
        }
    }

    @Override
    public boolean isTrueUpdate(Role o) {
        boolean isTreu = false;
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
    public boolean isUniqName(Role o) {
        boolean uniqRole = false;
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
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println("in not uniq");
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Sucess");
                alert.setHeaderText("ERROR : used");
                alert.setContentText("Brand" + "  '" + o.getRoleName() + "' " + "Already exist");
                alert.initStyle(StageStyle.UNDECORATED);
                alert.showAndWait();

                return  uniqRole;
            }
            uniqRole = true;
        } catch (  SQLException e ) {

            Logger.getLogger(Role.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }
}

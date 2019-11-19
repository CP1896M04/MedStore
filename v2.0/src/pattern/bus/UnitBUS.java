package pattern.bus;

import javafx.scene.control.Alert;
import javafx.stage.StageStyle;
import pattern.connection.ConnectionFactory;
import pattern.dao.UnitDAO;
import pattern.model.Unit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UnitBUS implements BUS<Unit> {
    private Connection connection;
    public  UnitBUS() {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connection =connectionFactory.getConnection();
    }

    UnitDAO unitDAO= new UnitDAO();
    @Override
    public void add(Unit o) {
        if (isUniqName(o)) {
            unitDAO.add(o);
        }
    }

    @Override
    public void update(Unit o) {
        if (isTrueUpdate(o)) {
           unitDAO.update(o);
        } else if (isUniqName(o)) {
            unitDAO.update(o);
        }
    }

    @Override
    public void delete(Unit o) {
        if (unitDAO.isNotUsed(o)) {
            try {
                unitDAO.remove(String.valueOf(o));//
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            //no no;
        }
    }

    @Override
    public boolean isTrueUpdate(Unit o) {
        boolean isTreu = false;
        String sql="UPDATE [dbo].[Unit]\n" +
                "   SET [Uname] = ?\n" +
                "      ,[UInStock] = ?\n" +
                "      ,[UInStockName] = ?\n" +
                "      ,[UInOrder] = ?\n" +
                "      ,[UInOrderName] = ?\n" +
                "      ,[Desc] = ?\n" +
                " WHERE UnitID = ? ";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,o.getUname());
            preparedStatement.setInt(2,o.getUInStock());
            preparedStatement.setString(3,o.getUInStockName() );
            preparedStatement.setInt(4,o.getUInOrder());
            preparedStatement.setString(5,o.getUInOrderName());
            preparedStatement.setString(6,o.getDesc());
            preparedStatement.setInt(7,o.getUnitID());
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
    public boolean isUniqName(Unit o) {
        boolean uniqUnit = false;
        String sql="INSERT INTO [dbo].[Unit]\n" +
                "           ([Uname]\n" +
                "           ,[UInStock]\n" +
                "           ,[UInStockName]\n" +
                "           ,[UInOrder]\n" +
                "           ,[UInOrderName]\n" +
                "           ,[Desc])\n" +
                "     VALUES\n" +
                "           (?\n" +
                "           ,?\n" +
                "           ,?\n" +
                "           ,?\n" +
                "           ,?\n" +
                "           ,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, o.getUname());
            preparedStatement.setInt(2, o.getUInOrder());
            preparedStatement.setString(3, o.getUInStockName());
            preparedStatement.setInt(4, o.getUInOrder());
            preparedStatement.setString(5, o.getUInOrderName());
            preparedStatement.setString(6, o.getDesc());
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println("in not uniq");
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Sucess");
                alert.setHeaderText("ERROR : used");
                alert.setContentText("Brand" + "  '" + o.getUname() + "' " + "Already exist");
                alert.initStyle(StageStyle.UNDECORATED);
                alert.showAndWait();

                return uniqUnit;
            }
            uniqUnit = true;
        } catch (  SQLException e ) {

            Logger.getLogger(Unit.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }
}

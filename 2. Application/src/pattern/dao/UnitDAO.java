package pattern.dao;

import pattern.connection.ConnectionFactory;
import pattern.model.InventoryLedger;
import pattern.model.Unit;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UnitDAO implements DAO<Unit> {
    private Connection connection;
    public  UnitDAO() {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connection =connectionFactory.getConnection();
    }

    @Override
    public void add(Unit o) {
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
            preparedStatement.setInt(1, o.getUnitID());

            preparedStatement.execute();
        } catch (  SQLException e ) {

            throw new RuntimeException(e);
        }

    }

    @Override
    public void remove(String unitID) throws SQLException {
        String sql = "DELETE FROM [dbo].[Unit] WHERE UnitID = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, Integer.parseInt(unitID));
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }




    @Override
    public void update(Unit o) {
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
            preparedStatement.setString(6,o.getDescr());
            preparedStatement.setInt(7,o.getUnitID());
            preparedStatement.execute();
        } catch (  SQLException e ) {

            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Unit> getList() {
        List<Unit> units = new ArrayList<>();
        String sql = "SELECT [UnitID]\n" +
                "      ,[Uname]\n" +
                "      ,[UInStock]\n" +
                "      ,[UInStockName]\n" +
                "      ,[UInOrder]\n" +
                "      ,[UInOrderName]\n" +
                "      ,[Desc]\n" +
                "  FROM [dbo].[Unit]";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int UnitID = resultSet.getInt("UnitID");
                String Uname = resultSet.getString("Uname");
                Integer UInStock = resultSet.getInt("UInStock");
                String UInStockName = resultSet.getString("UInStockName");
                Integer UInOrder = resultSet.getInt("UInOrder");
                String UInOrderName =resultSet.getString("UInOrderName");
                String Desc =resultSet.getString("Desc");
                Unit unit= new Unit(UnitID,Uname,UInStock,UInStockName,UInOrder,UInOrderName,Desc);
                units.add(unit);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return units;
    }

}


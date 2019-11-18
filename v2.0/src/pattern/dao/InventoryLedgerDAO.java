package pattern.dao;

import pattern.connection.ConnectionFactory;
import pattern.model.Category;
import pattern.model.InventoryLedger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InventoryLedgerDAO implements DAO<InventoryLedger> {
    private Connection connection;
    public  InventoryLedgerDAO() {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connection =connectionFactory.getConnection();
    }
    @Override
    public void add(InventoryLedger o) {
        String sql = "INSERT INTO [dbo].[InventoryLedger]\n" +
                "           ([LegerCode]\n" +
                "           ,[ProductID]\n" +
                "           ,[TransactionType]\n" +
                "           ,[QuantityTransacted]\n" +
                "           ,[InventoryPurchaseCost])\n" +
                "     VALUES\n" +
                "           (?\n" +
                "           ,?\n" +
                "           ,?\n" +
                "           ,?\n" +
                "           ,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, o.getLegerCode());
            preparedStatement.setInt(2, o.getProductID());
            preparedStatement.setString(3, o.getTransactionType());
            preparedStatement.setInt(4, o.getQuantityTransacted());
            preparedStatement.setFloat(5, o.getInventoryPurchaseCost());
            preparedStatement.execute();
        } catch (  SQLException e ) {

            throw new RuntimeException(e);
        }

    }

    @Override
    public void remove(String legerID)  {
        String sql = "DELETE FROM [dbo].[InventoryLedger] WHERE LegerID = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, Integer.parseInt(legerID));
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(InventoryLedger o) {
        String sql = "UPDATE [dbo].[InventoryLedger]\n" +
                "   SET [LegerCode] = ?\n" +
                "      ,[ProductID] = ?\n" +
                "      ,[TransactionType] = ?\n" +
                "      ,[QuantityTransacted] = ?\n" +
                "      ,[InventoryPurchaseCost] = ?\n" +
                " WHERE LegerID = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, o.getLegerCode());
            preparedStatement.setInt(2, o.getProductID());
            preparedStatement.setString(3, o.getTransactionType());
            preparedStatement.setInt(4, o.getQuantityTransacted());
            preparedStatement.setFloat(5, o.getInventoryPurchaseCost());
            preparedStatement.setInt(6, o.getLegerID());
            preparedStatement.execute();
        } catch (  SQLException e ) {

            throw new RuntimeException(e);
        }
    }

    @Override
    public List<InventoryLedger> getList() {
        List<InventoryLedger> inventoryLedgers = new ArrayList<>();
        String sql = "SELECT [LegerID]\n" +
                "      ,[LegerCode]\n" +
                "      ,[ProductID]\n" +
                "      ,[TransactionType]\n" +
                "      ,[QuantityTransacted]\n" +
                "      ,[InventoryPurchaseCost]\n" +
                "      ,[DateTime]\n" +
                "  FROM [dbo].[InventoryLedger]\n";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int LegerID= resultSet.getInt("LegerID");
                String LegerCode = resultSet.getString("LegerCode");
                Integer ProductID = resultSet.getInt("ProductID");
                String TransactionType = resultSet.getString("TransactionType");
                Integer QuantityTransacted = resultSet.getInt("QuantityTransacted");
                Float InventoryPurchaseCost =resultSet.getFloat("InventoryPurchaseCost");
                Date Datetime =resultSet.getDate("Datetime");
                InventoryLedger inventoryLedger= new InventoryLedger(LegerID,LegerCode,ProductID,TransactionType,QuantityTransacted,InventoryPurchaseCost,Datetime);
                inventoryLedgers.add(inventoryLedger);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return inventoryLedgers;
    }
}

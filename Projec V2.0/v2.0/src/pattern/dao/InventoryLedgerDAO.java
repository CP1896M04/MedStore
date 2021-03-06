package pattern.dao;

import javafx.scene.control.Alert;
import javafx.stage.StageStyle;
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
                "           ,[InventoryPurchaseCost]\n" +
                "           ,[DateKey])\n" +
                "     VALUES\n" +
                "           (?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, o.getLegerCode());
            preparedStatement.setInt(2, o.getProductID());
            preparedStatement.setString(3, o.getTransactionType());
            preparedStatement.setInt(4, o.getQuantityTransacted());
            preparedStatement.setFloat(5, o.getInventoryPurchaseCost());
            preparedStatement.setInt(6,o.getDateTag());
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
                "      ,[InventoryPurchaseCost] = ?\n"+
                "      ,[DateTag]                 =?\n"+
                " WHERE LegerID = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, o.getLegerCode());
            preparedStatement.setInt(2, o.getProductID());
            preparedStatement.setString(3, o.getTransactionType());
            preparedStatement.setInt(4, o.getQuantityTransacted());
            preparedStatement.setFloat(5, o.getInventoryPurchaseCost());
            preparedStatement.setInt(6,o.getDateTag());
            preparedStatement.setInt(7, o.getLegerID());
            preparedStatement.execute();
        } catch (  SQLException e ) {

            throw new RuntimeException(e);
        }
    }

    @Override
    public List<InventoryLedger> getList() {
        List<InventoryLedger> inventoryLedgers = new ArrayList<>();
        String sql = "SELECT * FROM [dbo].[InventoryLedger]";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int LegerID= resultSet.getInt("LegerID");
                String LegerCode = resultSet.getString("LegerCode");
                Integer ProductID = resultSet.getInt("ProductID");
                String TransactionType = resultSet.getString("TransactionType");
                Integer QuantityTransacted = resultSet.getInt("QuantityTransacted");
                Float InventoryPurchaseCost =resultSet.getFloat("InventoryPurchaseCost");
                Integer DateKey =resultSet.getInt("DateKey");
                InventoryLedger inventoryLedger= new InventoryLedger(LegerID,LegerCode,ProductID,TransactionType,QuantityTransacted,InventoryPurchaseCost,DateKey);
                inventoryLedgers.add(inventoryLedger);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return inventoryLedgers;
    }
    public boolean isUniqName(InventoryLedger o) {
        boolean isUniq = false;
        String sql = "select [LegerID] from InventoryLedger where LegerCode=? ";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, o.getLegerCode());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("ERROE : Already exist ");
                alert.setContentText("Brand" + "  '" + o.getLegerCode() + "' " + "Already exist");
                alert.initStyle(StageStyle.UNDECORATED);
                alert.showAndWait();
                return isUniq;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return isUniq;
    }
    public boolean isUpdate(InventoryLedger o) {
        boolean isUniq = false;
        String sql = "select [LegerID] from InventoryLedger where LegerCode=? ";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, o.getLegerCode());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (!resultSet.next()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("ERROE : Name doesn't exist ");
                alert.setContentText("Brand" + "  '" + o.getLegerCode() + "' " + "not exist");
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

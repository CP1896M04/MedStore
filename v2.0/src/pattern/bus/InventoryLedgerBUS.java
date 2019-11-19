package pattern.bus;

import javafx.scene.control.Alert;
import javafx.stage.StageStyle;
import pattern.connection.ConnectionFactory;
import pattern.dao.InventoryLedgerDAO;
import pattern.model.InventoryDetails;
import pattern.model.InventoryLedger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InventoryLedgerBUS implements BUS<InventoryLedger> {
    private Connection connection;
    public  InventoryLedgerBUS() {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connection =connectionFactory.getConnection();
    }
    InventoryLedgerDAO inventoryLedgerDAO= new InventoryLedgerDAO();

    @Override
    public void add(InventoryLedger o) {
        if(isUniqName(o)){
            inventoryLedgerDAO.add(o);

        }
    }

    @Override
    public void update(InventoryLedger o) {
        if (isTrueUpdate(o)) {
            inventoryLedgerDAO.update(o);
        } else if (isUniqName(o)) {
            inventoryLedgerDAO.update(o);
        }
    }

    @Override
    public void delete(InventoryLedger o) {
        if(inventoryLedgerDAO.isNotUsed(o)){
            inventoryLedgerDAO.remove(String.valueOf(o));
        }else{
            //noting
        }
    }

    @Override
    public boolean isTrueUpdate(InventoryLedger o) {
        boolean isTreu = false;
//        brands.supplyrId = sql.getIdNo(brands.supplyerName, brands.supplyrId, "Supplyer", "SupplyerName");
        System.out.println("we are in update");
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
    public boolean isUniqName(InventoryLedger o) {
        boolean uniqInventoryLedger = false;
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
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println("in not uniq");
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Sucess");
                alert.setHeaderText("ERROR : used");
                alert.setContentText("CategoryName" + "  '" + o.getLegerCode() + "' " + "Already exist");
                alert.initStyle(StageStyle.UNDECORATED);
                alert.showAndWait();
            }
            uniqInventoryLedger  = true;
        } catch (  SQLException e ) {

            Logger.getLogger(InventoryLedger.class.getName()).log(Level.SEVERE, null, e);
        }

        return uniqInventoryLedger ;
    }
}

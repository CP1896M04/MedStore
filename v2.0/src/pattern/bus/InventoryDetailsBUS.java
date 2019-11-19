package pattern.bus;

import javafx.scene.control.Alert;
import javafx.stage.StageStyle;
import pattern.connection.ConnectionFactory;
import pattern.dao.InventoryDetailsDAO;
import pattern.model.InventoryDetails;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InventoryDetailsBUS implements BUS<InventoryDetails> {
    private Connection connection;
    public InventoryDetailsBUS(){
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connection =connectionFactory.getConnection();
    }
    InventoryDetailsDAO inventoryDetailsDAO= new InventoryDetailsDAO();
    @Override
    public void add(InventoryDetails o) {
        if(isUniqName(o)){
            inventoryDetailsDAO.add(o);

        }
    }

    @Override
    public void update(InventoryDetails o) {
    if(isTrueUpdate(o)){
        inventoryDetailsDAO.update(o);
    }else if(isUniqName(o)){
        inventoryDetailsDAO.update(o);
    }
    }

    @Override
    public void delete(InventoryDetails o) {
        if(inventoryDetailsDAO.isNotUsed(o)){
            try {
                inventoryDetailsDAO.remove(String.valueOf(o));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else{
            //
        }
    }

    @Override
    public boolean isTrueUpdate(InventoryDetails o) {
        boolean isTreu = false;
//        brands.supplyrId = sql.getIdNo(brands.supplyerName, brands.supplyrId, "Supplyer", "SupplyerName");
        System.out.println("we are in update");

        try {
            String sql = "UPDATE [dbo].[InventoryDetails]" +
                    "   SET [DetailsCode] = ?" +
                    "      ,[ProductID] = ?" +
                    "      ,[PurchasePrice] = ?" +
                    "      ,[TentativeSalesPrice] = ?" +
                    "      ,[QuantityBought] = ?" +
                    "      ,[QuantityAvailable] = ?" +
                    "      ,[Batchid] = ?" +
                    "      ,[ManufacturedDate] = ?" +
                    "      ,[ExpiryDate] = ?" +
                    "       WHERE DetailsID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, o.getDetailsCode());
            preparedStatement.setInt(2, o.getProductID());
            preparedStatement.setFloat(3, o.getPurchasePrice());
            preparedStatement.setFloat(4, o.getTentativeSalesPrice());
            preparedStatement.setInt(5, o.getQuantityBought());
            preparedStatement.setInt(6, o.getQuantityAvailable());
            preparedStatement.setString(7, o.getBatchid());
            preparedStatement.setDate(8, o.getManufacturedDate());
            preparedStatement.setDate(9, o.getExpiryDate());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                return isTreu;
            }
        } catch (  SQLException e ) {

            e.printStackTrace();
        }
        return isTreu;
    }

    @Override
    public boolean isUniqName(InventoryDetails o) {
        boolean uniqInventoryDetails = false;
        String sql = "insert into InventoryDetails (DetailsCode, ProductID , PurchasePrice, TentativeSalesPrice, QuantityBought ,QuantityAvailable, Batchid , ManufacturedDate, ExpiryDate ) values (?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, o.getDetailsCode());
            preparedStatement.setInt(2, o.getProductID());
            preparedStatement.setFloat(3, o.getPurchasePrice());
            preparedStatement.setFloat(4, o.getTentativeSalesPrice());
            preparedStatement.setInt(5, o.getQuantityBought());
            preparedStatement.setInt(6, o.getQuantityAvailable());
            preparedStatement.setString(7, o.getBatchid());
            preparedStatement.setDate(8, o.getManufacturedDate());
            preparedStatement.setDate(9, o.getExpiryDate());

            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println("in not uniq");
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Sucess");
                alert.setHeaderText("ERROR : used");
                alert.setContentText("CategoryName" + "  '" + o.getDetailsCode() + "' " + "Already exist");
                alert.initStyle(StageStyle.UNDECORATED);
                alert.showAndWait();


            }
            uniqInventoryDetails  = true;
        } catch (  SQLException e ) {


            Logger.getLogger(InventoryDetails.class.getName()).log(Level.SEVERE, null, e);
        }
        return uniqInventoryDetails;
    }
}

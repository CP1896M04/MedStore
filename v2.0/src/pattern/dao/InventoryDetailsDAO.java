package pattern.dao;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.stage.StageStyle;
import pattern.connection.ConnectionFactory;
import pattern.model.Category;
import pattern.model.InventoryDetails;
import pattern.model.ViewProduct;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InventoryDetailsDAO implements DAO<InventoryDetails> {
    private Connection connection;
    public InventoryDetailsDAO(){
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connection =connectionFactory.getConnection();
    }
    @Override
    public void add(InventoryDetails o) {
        String sql = "insert into InventoryDetails (DetailsCode, ProductID ,PName, PurchasePrice, TentativeSalesPrice, QuantityBought ,QuantityAvailable, Batchid , ManufacturedDate, ExpiryDate ) values (?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, o.getDetailsCode());
            preparedStatement.setInt(2, o.getProductID());
            preparedStatement.setString(3,o.getPName());
            preparedStatement.setFloat(4, o.getPurchasePrice());
            preparedStatement.setFloat(5, o.getTentativeSalesPrice());
            preparedStatement.setInt(6, o.getQuantityBought());
            preparedStatement.setInt(7, o.getQuantityAvailable());
            preparedStatement.setString(8, o.getBatchid());
            preparedStatement.setDate(9, o.getManufacturedDate());
            preparedStatement.setDate(10, o.getExpiryDate());
            preparedStatement.execute();
        } catch (  SQLException e ) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public void remove(String detailsID ) throws SQLException {
        String sql = "DELETE FROM [dbo].[InventoryDetails] WHERE DetailsID = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, Integer.parseInt(detailsID));
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(InventoryDetails o) {
        String sql = "UPDATE [dbo].[InventoryDetails]\n" +
                "   SET [DetailsCode] = ?\n" +
                "      ,[ProductID] = ?\n" +
                "      ,[PName] = ?\n" +
                "      ,[PurchasePrice] = ?\n" +
                "      ,[TentativeSalesPrice] = ?\n" +
                "      ,[QuantityBought] = ?\n" +
                "      ,[QuantityAvailable] = ?\n" +
                "      ,[Batchid] = ?\n" +
                "      ,[ManufacturedDate] = ?\n" +
                "      ,[ExpiryDate] = ?\n" +
                " WHERE [DetailsID] =?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            System.out.println("Bought"+o.getQuantityBought());
            preparedStatement.setString(1, o.getDetailsCode());
            preparedStatement.setInt(2, o.getProductID());
            preparedStatement.setString(3,o.getPName());
            preparedStatement.setFloat(4, o.getPurchasePrice());
            preparedStatement.setFloat(5, o.getTentativeSalesPrice());
            preparedStatement.setInt(6, o.getQuantityBought());
            preparedStatement.setInt(7, o.getQuantityAvailable());
            preparedStatement.setString(8, o.getBatchid());
            preparedStatement.setDate(9, o.getManufacturedDate());
            preparedStatement.setDate(10, o.getExpiryDate());
            preparedStatement.setInt(11, o.getDetailsID());
            preparedStatement.execute();
        } catch (  SQLException e ) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public List<InventoryDetails> getList() {
        List<InventoryDetails> inventoryDetails = new ArrayList<>();
        String sql = "SELECT * FROM [dbo].[InventoryDetails]";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int detailsID = resultSet.getInt("DetailsID");
                String detailsCode = resultSet.getString("DetailsCode");
                int productID = resultSet.getInt("ProductID");
                String productName =resultSet.getString("PName");
                Float purchasePrice = resultSet.getFloat("PurchasePrice");
                Float tentativeSalesPrice = resultSet.getFloat("TentativeSalesPrice");
                int quantityBought = resultSet.getInt("QuantityBought");
                int quantityAvailable = resultSet.getInt("QuantityAvailable");
                String batchID=resultSet.getString("Batchid");
                Date manufacturedDate = resultSet.getDate("ManufacturedDate");
                Date expiryDate = resultSet.getDate("ExpiryDate");
                InventoryDetails inventorydetails = new InventoryDetails(detailsID, detailsCode ,productID,productName,purchasePrice,tentativeSalesPrice,quantityBought,quantityAvailable,batchID,manufacturedDate,expiryDate);
                inventoryDetails.add(inventorydetails);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return inventoryDetails;
    }
    public ObservableList<ViewProduct> getTableView() {
        ObservableList<ViewProduct> viewProducts = FXCollections.observableArrayList();
        String sql = "SELECT * FROM [dbo].[InventoryDetails]";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int detailsID = resultSet.getInt("DetailsID");
                String detailsCode = resultSet.getString("DetailsCode");
                int productID = resultSet.getInt("ProductID");
                String pName  = resultSet.getString("PName");
                Float purchasePrice = resultSet.getFloat("PurchasePrice");
                Float tentativeSalesPrice = resultSet.getFloat("TentativeSalesPrice");
                int quantityBought = resultSet.getInt("QuantityBought");
                int quantityAvailable = resultSet.getInt("QuantityAvailable");
                String batchID = resultSet.getString("Batchid");
                Date manufacturedDate = resultSet.getDate("ManufacturedDate");
                Date expiryDate = resultSet.getDate("ExpiryDate");
                ViewProduct viewProduct = new ViewProduct(detailsID, detailsCode ,productID,pName ,purchasePrice,tentativeSalesPrice,quantityBought,quantityAvailable,batchID,manufacturedDate,expiryDate);
                viewProducts.add(viewProduct);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return viewProducts;
    }
    public boolean isUniqName(InventoryDetails o) {
        boolean isUniq = false;
        String sql = "select [DetailsID],[QuantityBought] ,[QuantityAvailable] from InventoryDetails where DetailsCode=? ";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, o.getDetailsCode());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                //Update current
                Integer currentBought = resultSet.getInt("QuantityBought");
                Integer currentAvailable = resultSet.getInt("QuantityAvailable");
                Integer id = resultSet.getInt("DetailsID");
                o.setQuantityBought(o.getQuantityBought()+currentBought);
                o.setQuantityAvailable(o.getQuantityAvailable()+currentAvailable);
                o.setDetailsID(id);
                update(o);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Update Inventory");
                alert.setHeaderText("Update inventory");
                alert.setContentText("Brand" + "  '" + o.getDetailsCode() + "' " + "has been update, Quantity Bought to :"+ o.getQuantityBought());
                alert.initStyle(StageStyle.UNDECORATED);
                alert.showAndWait();
                return isUniq;
            }
            isUniq=true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return isUniq;
    }

    public boolean isUpdate(InventoryDetails o) {
        boolean isUniq = false;
        String sql = "select [DetailsID] from InventoryDetails where DetailsCode=? ";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, o.getDetailsCode());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (!resultSet.next()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("ERROE : Name doesn't exist ");
                alert.setContentText("Brand" + "  '" + o.getDetailsCode() + "' " + "not exist");
                alert.initStyle(StageStyle.UNDECORATED);
                alert.showAndWait();
                return isUniq;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return isUniq;
    }
    public int checkAvailable(Integer ProductId){
        int amount=0;
        String sql = "select [QuantityAvailable] from InventoryDetails where LegerCode=? ";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1,ProductId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (!resultSet.next()) {

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return amount;

    }
}

package pattern.dao;

import pattern.connection.ConnectionFactory;
import pattern.model.Category;
import pattern.model.InventoryDetails;

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
        } catch (  SQLException e ) {

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
                " WHERE DetailsID = ?";
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
        } catch (  SQLException e ) {

            throw new RuntimeException(e);
        }
    }

    @Override
    public List<InventoryDetails> getList() {
        List<InventoryDetails> inventoryDetails = new ArrayList<>();
        String sql = "select * from InventoryDetails";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int detailsID = resultSet.getInt("DetailsID");
                String detailsCode = resultSet.getString("DetailsCode");
                int productID = resultSet.getInt("ProductID");
                Float purchasePrice = resultSet.getFloat("PurchasePrice");
                Float tentativeSalesPrice = resultSet.getFloat("TentativeSalesPrice");
                int quantityBought = resultSet.getInt("QuantityBought");
                int quantityAvailable = resultSet.getInt("QuantityAvailable");
                String batchID = resultSet.getString("Batchid");
                Date manufacturedDate = resultSet.getDate("ManufacturedDate");
                Date expiryDate = resultSet.getDate("ExpiryDate");
                InventoryDetails inventorydetails = new InventoryDetails(detailsID, detailsCode ,productID,purchasePrice,tentativeSalesPrice,quantityBought,quantityAvailable,batchID,manufacturedDate,expiryDate);

                inventoryDetails.add(inventorydetails);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return inventoryDetails;
    }
    }


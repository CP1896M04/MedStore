package pattern.dao;

import pattern.connection.ConnectionFactory;
import pattern.model.ODetail;
import pattern.model.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ODetailDAO implements DAO<ODetail> {
    private Connection connection;
    public  ODetailDAO() {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connection =connectionFactory.getConnection();
    }
    @Override
    public void add(ODetail o) {
        String sql = "([OrderID]" +
                "     ,[ProductID]\n" +
                "     ,[USP]\n" +
                "     ,[HTU]\n" +
                "     ,[Qty]\n" +
                "     ,[Discount]\n" +
                "     ,[Total]) values (?,?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, o.getOrderID());
            preparedStatement.setInt(2, o.getProductID());
            preparedStatement.setFloat(3, o.getUSP());
            preparedStatement.setString(4, o.getHTU());
            preparedStatement.setInt(5, o.getQty());
            preparedStatement.setDouble(6, o.getDiscount());
            preparedStatement.setFloat(7, o.getTotal());

            preparedStatement.execute();
        } catch (  SQLException e ) {

            throw new RuntimeException(e);
        }
    }

    @Override
    public void remove(String oDetailID) throws SQLException {
        String sql = "DELETE FROM [dbo].[O] WHERE ODetailID = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, Integer.parseInt(oDetailID));
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(ODetail o) {
        String sql = "UPDATE [dbo].[ODetail]" +
                "   SET [OrderID] = ?" +
                "      ,[ProductID] = ?" +
                "      ,[USP] = ?" +
                "      ,[HTU] = ?" +
                "      ,[Qty] = ?" +
                "      ,[Discount] = ?" +
                "      ,[Total] = ?" +
                " WHERE ODetailID = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, o.getOrderID());
            preparedStatement.setInt(2, o.getProductID());
            preparedStatement.setFloat(3, o.getUSP());
            preparedStatement.setString(4, o.getHTU());
            preparedStatement.setInt(5, o.getQty());
            preparedStatement.setDouble(6, o.getDiscount());
            preparedStatement.setFloat(7, o.getTotal());

            preparedStatement.execute();
        } catch (  SQLException e ) {

            throw new RuntimeException(e);
        }
    }

    @Override
    public List<ODetail> getList() {
        List<ODetail> oDetails = new ArrayList<>();
        String sql = "select * from ODetail";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int oDetailID = resultSet.getInt("ODetailID");
                int orderID = resultSet.getInt("OrderID");
                int productID = resultSet.getInt("ProductID");
                Float usp = resultSet.getFloat("USP");
                String htu = resultSet.getString("HTU");
                int qty = resultSet.getInt("Qty");
                Double discount = resultSet.getDouble("Discount");
                Float total = resultSet.getFloat("Total");

                ODetail oDetail = new ODetail(oDetailID,orderID,productID,usp,htu,qty,discount,total);
                oDetails.add(oDetail);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return oDetails;
    }
}

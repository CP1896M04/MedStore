package pattern.dao;

import javafx.scene.control.Alert;
import javafx.stage.StageStyle;
import pattern.connection.ConnectionFactory;
import pattern.model.ODetail;
import pattern.model.Order;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ODetailDAO implements DAO<ODetail> {
    private Connection connection;
    public  ODetailDAO() {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connection =connectionFactory.getConnection();
    }
    public int insertProc(){
        int id=0;
        CallableStatement cs = null;
        try {
            cs = connection.prepareCall("{call insertODetail(?,?,?)}");
            cs.registerOutParameter(3, Types.INTEGER);
            cs.setInt(1, 1);
            cs.setInt(2,1);
            cs.execute();
            Integer str = cs.getInt(3);
            id=str;
        } catch (SQLException e) {
            System.err.println("SQLException: " + e.getMessage());
        }
        return id;
    }
    @Override
    public void add(ODetail o) {
        String sql = "Insert INTO [ODetail]([OrderID]" +
                "     ,[ProductID]\n" +
                "     ,[PName]    \n"+
                "     ,[USP]\n" +
                "     ,[HTU]\n" +
                "     ,[Qty]\n" +
                "     ,[Discount]\n" +
                "     ,[Total]) values (?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, o.getOrderID());
            preparedStatement.setInt(2, o.getProductID());
            preparedStatement.setString(3,o.getPName());
            preparedStatement.setFloat(4, o.getUPS());
            preparedStatement.setString(5, o.getHTU());
            preparedStatement.setInt(6, o.getQty());
            preparedStatement.setDouble(7, o.getDiscount());
            preparedStatement.setDouble(8, o.getTotal());

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
                "      ,[PName]=?"+
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
            preparedStatement.setString(3,o.getPName());
            preparedStatement.setFloat(4, o.getUPS());
            preparedStatement.setString(5, o.getHTU());
            preparedStatement.setInt(6, o.getQty());
            preparedStatement.setDouble(7, o.getDiscount());
            preparedStatement.setFloat(8, o.getTotal());

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
                String productName = resultSet.getString("PName");
                Float usp = resultSet.getFloat("USP");
                String htu = resultSet.getString("HTU");
                int qty = resultSet.getInt("Qty");
                Double discount = resultSet.getDouble("Discount");
                Float total = resultSet.getFloat("Total");
                ODetail oDetail = new ODetail(oDetailID,orderID,productID,productName,usp,htu,qty,discount,total);
                oDetails.add(oDetail);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return oDetails;
    }

}

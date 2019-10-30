package pattern.dao;

import pattern.connection.ConnectionFactory;
import pattern.model.Category;
import pattern.model.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OderDAO implements DAO<Order> {
    private Connection connection;
    public  OderDAO() {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connection =connectionFactory.getConnection();
    }
    @Override
    public void add(Order o) {
        String sql = "insert into Order ([DateKey],[StaffID]) values (?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, o.getDateKey());
            preparedStatement.setInt(2, o.getStaffID());

            preparedStatement.execute();
        } catch (  SQLException e ) {

            throw new RuntimeException(e);
        }
    }

    @Override
    public void remove(String orderID) throws SQLException {
        String sql = "DELETE FROM [dbo].[Order] WHERE OrderID = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, Integer.parseInt(orderID));
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Order o) {
        String sql = "UPDATE [dbo].[Order]" +
                "   SET [DateKey] = ?" +
                "      ,[StaffID] = ?" +
                " WHERE OrderID = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, o.getDateKey());
            preparedStatement.setInt(2, o.getStaffID());

            preparedStatement.execute();
        } catch (  SQLException e ) {

            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Order> getList() {
        List<Order> orders = new ArrayList<>();
        String sql = "select * from Order";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int orderID = resultSet.getInt("OrderID");
                int DateKey = resultSet.getInt("DateKey");
                int staffID = resultSet.getInt("StaffID");
                Order order = new Order(orderID,DateKey,staffID);
                orders.add(order);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return orders;

    }
}

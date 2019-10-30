package pattern.dao;

import pattern.connection.ConnectionFactory;
import pattern.model.Supplier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SupplierDao implements DAO<Supplier>{
    private Connection connection;
public void SupplierDao(){
    ConnectionFactory connectionFactory = new ConnectionFactory();
    connection =connectionFactory.getConnection();
}
    @Override
    public void add(Supplier o) {
        String sql = "insert into Supplier (ComCode,ComName,Address,Phone,Email,Tax) values (?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, o.getComCode());
            preparedStatement.setString(2, o.getComName());
            preparedStatement.setString(3, o.getAddress());
            preparedStatement.setString(4, o.getPhone());
            preparedStatement.setString(5, o.getEmail());
            preparedStatement.setString(6, o.getTax());


            preparedStatement.execute();
        } catch (  SQLException e ) {

            throw new RuntimeException(e);
        }
    }

    @Override
    public void remove(String supplierID) throws SQLException {
        String sql = "DELETE FROM [dbo].[Supplier] WHERE SupplierID = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, Integer.parseInt(supplierID));
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Supplier o) {
        String sql = "UPDATE [dbo].[Supplier]" +
                "   SET [ComCode] = ? " +
                "      ,[ComName] = ?" +
                "      ,[Address] = ?" +
                "      ,[Phone] = ?" +
                "      ,[Email] = ?" +
                "      ,[Tax] = ?" +
                " WHERE [supplierID]=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, o.getComCode());
            preparedStatement.setString(2, o.getComName());
            preparedStatement.setString(3, o.getAddress());
            preparedStatement.setString(4, o.getPhone());
            preparedStatement.setString(5, o.getEmail());
            preparedStatement.setString(6, o.getTax());
            preparedStatement.setInt(7, o.getSupplierID());
            preparedStatement.execute();
        } catch (  SQLException e ) {

            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Supplier> getList() {
    List<Supplier> suppliers= new ArrayList<>();
        String sql = "select * from Supplier";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int supplierID= resultSet.getInt("columnSupplierId");
                String comCode = resultSet.getString("columnComCode");
                String comName = resultSet.getString("columnComName");
                String address = resultSet.getString("columnAddress");
                String phone= resultSet.getString("columnPhone");
                String email = resultSet.getString("columnEmail");
                String tax = resultSet.getString("columnTax");
               Supplier supplier= new Supplier(supplierID,comCode,comName,address,phone,email,tax);
                suppliers.add(supplier);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return suppliers;
    }
    }


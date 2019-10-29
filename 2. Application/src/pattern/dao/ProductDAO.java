package pattern.dao;

import pattern.connection.ConnectionFactory;
import pattern.model.Product;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ProductDAO implements DAO<Product>{
    private Connection connection;

    public ProductDAO(Connection connection) {
        this.connection = connection;
    }

//    public ProductDAO{
//        ConnectionFactory connectionFactory = new ConnectionFactory();
//        connection =connectionFactory.getConnection();
//    }

    public ProductDAO() {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connection =connectionFactory.getConnection();
    }
    @Override
    public void add(Product o) {
        String sql = "INSERT INTO [dbo].[Product] ([CatID],[UnitID],[SupplierID],[PName],[PDescr],[PComposition],[PManufacturer],[Uprice],[USP],[ReOrLevel],[HTU],[DefaultInDose]) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
//            PreparedStatement preparedStatement = new connection.prepareStatement(sql);
            PreparedStatement preparedStatement= connection.prepareStatement(sql);

            preparedStatement.setInt(1, o.getSupplierID());
            preparedStatement.setString(2, o.getPName());
            preparedStatement.setString(3, o.getPDescr());
            preparedStatement.setString(4, o.getPComposition());
            preparedStatement.setString(5, o.getPManufacturer());
            preparedStatement.setFloat(6, o.getUPrice());
            preparedStatement.setFloat(7, o.getUSP());
            preparedStatement.setInt(8, o.getReOrLevel());
            preparedStatement.setString(9, o.getHTU());
            preparedStatement.setInt(10, o.getDefaultInDose());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void remove(String ProductID) throws SQLException {
        String sql = "DELETE FROM [dbo].[Product] WHERE ProductID = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, String.valueOf(Integer.parseInt(ProductID)));
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Product o) {

    }

    @Override
    public List getList() {
        return null;
    }
}

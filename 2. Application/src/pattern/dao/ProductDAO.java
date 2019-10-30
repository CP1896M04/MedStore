package pattern.dao;

import pattern.connection.ConnectionFactory;
import pattern.model.Category;
import pattern.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements DAO<Product>{
    private Connection connection;
    public  ProductDAO() {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connection =connectionFactory.getConnection();
    }
    @Override
    public void add(Product o) {
        String sql = "insert into Product (CatID, UnitID, SupplierID, PName, PDescr, PComposition, PManufacturer, Uprice, USP, ReOrLevel, HTU, DefaultInDose) values (?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, o.getCatID());
            preparedStatement.setInt(2, o.getUnitID());
            preparedStatement.setInt(3, o.getSupplierID());
            preparedStatement.setString(4, o.getPName());
            preparedStatement.setString(5, o.getPDescr());
            preparedStatement.setString(6, o.getPComposition());
            preparedStatement.setString(7, o.getPManufacturer());
            preparedStatement.setFloat(8, o.getUPrice());
            preparedStatement.setFloat(9,o.getUSP());
            preparedStatement.setInt(10, o.getReOrLevel());
            preparedStatement.setString(11, o.getHTU());
            preparedStatement.setInt(12, o.getDefaultInDose());
            preparedStatement.execute();
        } catch (  SQLException e ) {

            throw new RuntimeException(e);
        }
    }

    @Override
    public void remove(String productID) throws SQLException {
        String sql = "DELETE FROM [dbo].[Product] WHERE ProductID = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, Integer.parseInt(productID));
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Product o) {
        String sql = "UPDATE [dbo].[Product]" +
                "   SET [CatID] = ?" +
                "      ,[UnitID] = ?" +
                "      ,[SupplierID] = ?" +
                "      ,[PName] = ?" +
                "      ,[PDescr] = ?" +
                "      ,[PComposition] = ?" +
                "      ,[PManufacturer] = ?" +
                "      ,[Uprice] = ?" +
                "      ,[USP] = ?" +
                "      ,[ReOrLevel] = ?" +
                "      ,[HTU] = ?" +
                "      ,[DefaultInDose] = ?" +
                " WHERE [ProductID] = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, o.getCatID());
            preparedStatement.setInt(2, o.getUnitID());
            preparedStatement.setInt(3, o.getSupplierID());
            preparedStatement.setString(4, o.getPName());
            preparedStatement.setString(5, o.getPDescr());
            preparedStatement.setString(6, o.getPComposition());
            preparedStatement.setString(7, o.getPManufacturer());
            preparedStatement.setFloat(8, o.getUPrice());
            preparedStatement.setFloat(9,o.getUSP());
            preparedStatement.setInt(10, o.getReOrLevel());
            preparedStatement.setString(11, o.getHTU());
            preparedStatement.setInt(12, o.getDefaultInDose());
            preparedStatement.execute();
        } catch (  SQLException e ) {

            throw new RuntimeException(e);
        }


    }

    @Override
    public List<Product> getList() {

        List<Product> products = new ArrayList<>();
        String sql = "select * from Product";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int productID= resultSet.getInt("ProductID");
                int catID = resultSet.getInt("CatID");
                int unitID = resultSet.getInt("UnitID");
                int supplierID = resultSet.getInt("SupplierID");
                String pName = resultSet.getString("PName");
                String pDescr  = resultSet.getString("PDescr");
                String pComposition  = resultSet.getString("PComposition");
                String pManufacturer = resultSet.getString("PManufacturer");
                Float uprice = resultSet.getFloat("Uprice");
                Float usp = resultSet.getFloat("USP");
                int reOrLevel= resultSet.getInt("ReOrLevel");
                String htu= resultSet.getString("HTU");
                int defaultInDose = resultSet.getInt("DefaultInDose");
                Product product = new Product(productID,catID,unitID ,supplierID,pName,pDescr,pComposition,pManufacturer,uprice,usp,reOrLevel,htu,defaultInDose);
                products.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }
}

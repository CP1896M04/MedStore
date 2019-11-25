package pattern.viewDAO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pattern.connection.ConnectionFactory;
import pattern.dao.DAO;
import pattern.list.ProductList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ViewProductDAO implements DAO<ProductList> {
    private Connection connection;
    public ViewProductDAO() {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connection =connectionFactory.getConnection();
    }
    @Override
    public void add(ProductList o) {

    }

    @Override
    public void remove(String id) throws SQLException {

    }

    @Override
    public void update(ProductList o) {

    }

    @Override
    public List<ProductList> getList() {
        return null;
    }

    public ObservableList<ProductList> getViewProduct() {
        ObservableList<ProductList> productLists = FXCollections.observableArrayList();
        String sql = "SELECT * FROM ProductList_VIEW";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int productID= resultSet.getInt("ProductID");
                String pName = resultSet.getString("PName");
//                        int catID = resultSet.getInt("CatID");
                String cName= resultSet.getString("CatName");
                String pDescr  = resultSet.getString("PDescr");
                String pComposition  = resultSet.getString("PComposition");
                String pManufacturer = resultSet.getString("PManufacturer");
                Float uprice = resultSet.getFloat("Uprice");
                Float usp = resultSet.getFloat("USP");

                ProductList productList = new ProductList(productID,pName,cName,pDescr,pComposition,pManufacturer,uprice,usp);
                productLists.add(productList);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return productLists;
    }


}
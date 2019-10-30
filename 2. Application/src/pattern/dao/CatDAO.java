package pattern.dao;

import pattern.connection.ConnectionFactory;
import pattern.model.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CatDAO implements DAO<Category> {
    private Connection connection;
    public  CatDAO() {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connection =connectionFactory.getConnection();
    }
    @Override
    public void add(Category o) {
        String sql = "insert into Category (CatName, [Desc]) values (?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, o.getCatName());
            preparedStatement.setString(2, o.getDesc());

            preparedStatement.execute();
        } catch (  SQLException e ) {

            throw new RuntimeException(e);
        }
    }

    @Override
    public void remove(String catID) {
        String sql = "DELETE FROM [dbo].[Category] WHERE CatID = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, Integer.parseInt(catID));
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Category o) {
        String sql = "UPDATE [dbo].[Category]" +
                "   SET [CatName] = ? " +
                "      ,[Desc] = ?" +
                " WHERE [CatId]=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, o.getCatName());
            preparedStatement.setString(2, o.getDesc());
            preparedStatement.setInt(3, o.getCatID());
            preparedStatement.execute();
        } catch (  SQLException e ) {

            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Category> getList() {
        List<Category> categories = new ArrayList<>();
        String sql = "select * from Category";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {


                int catID= resultSet.getInt("CatID");
                String catName = resultSet.getString("CatName");
                String desc = resultSet.getString("Desc");
                Category category= new Category(catID,catName,desc);
                categories.add(category);


            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return categories;
    }
}

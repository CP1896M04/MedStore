package pattern.dao;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.stage.StageStyle;
import pattern.connection.ConnectionFactory;
import pattern.model.Category;
import pattern.model.Supplier;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CatDAO implements DAO<Category> {
    private Connection connection;

    public CatDAO() {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connection = connectionFactory.getConnection();
    }

    @Override
    public void add(Category o) {
        String sql = "insert into Category (CatName, [Desc]) values (?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, o.getCatName());
            preparedStatement.setString(2, o.getDesc());

            preparedStatement.execute();
        } catch (SQLException e) {

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
        } catch (SQLException e) {

            throw new RuntimeException(e);
        }
    }

    @Override
    public ObservableList<Category> getList() {
        ObservableList<Category> categories = FXCollections.observableArrayList();
        String sql = "select * from Category";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int catID = resultSet.getInt("CatID");
                String catName = resultSet.getString("CatName");
                String desc = resultSet.getString("Desc");
                Category category = new Category(catID, catName, desc);
                categories.add(category);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return categories;
    }
    public boolean isUniqName(Category o) {
        boolean isUniq = false;
        String sql = "select [CatID] from Category where CatName=? ";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, o.getCatName());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("ERROE : Already exist ");
                alert.setContentText("Brand" + "  '" + o.getCatName() + "' " + "Already exist");
                alert.initStyle(StageStyle.UNDECORATED);
                alert.showAndWait();
                return isUniq;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return isUniq;
    }
    public boolean isUpdate(Category o) {
        boolean isUniq = false;
        String sql = "select [CatID] from Category where CatName=? ";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, o.getCatName());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (!resultSet.next()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("ERROE : Name doesn't exist ");
                alert.setContentText("Brand" + "  '" + o.getCatName() + "' " + "not exist");
                alert.initStyle(StageStyle.UNDECORATED);
                alert.showAndWait();
                return isUniq;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return isUniq;
    }

}







package pattern.bus;

import javafx.scene.control.Alert;
import javafx.stage.StageStyle;
import pattern.connection.ConnectionFactory;
import pattern.dao.CatDAO;
import pattern.model.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CatBUS implements BUS<Category> {
    private Connection connection;

    public CatBUS() {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connection = connectionFactory.getConnection();
    }

    CatDAO catDAO = new CatDAO();
    Category category = new Category();

    @Override
    public void add(Category o) {
        if (isUniqName(o)) {
            catDAO.add(o);
        }
    }

    @Override
    public void update(Category o) {
        if (isTrueUpdate(o)) {
            catDAO.update(o);
        } else if (isUniqName(o)) {
            catDAO.update(o);
        }
    }

    @Override
    public void delete(Category o) {
        if (catDAO.isNotUsed(o)) {
            catDAO.remove(String.valueOf(o));//
        }
    }

    @Override
    public boolean isTrueUpdate(Category o) {
        boolean isTrue = false;
        System.out.println("we are in update");
        try {
            String sql = "UPDATE [dbo].[Category]" +
                    "   SET [CatName] = ? " +
                    "      ,[Desc] = ?" +
                    " WHERE [CatId]=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, o.getCatName());
            preparedStatement.setString(2, o.getDesc());
            preparedStatement.setInt(3, o.getCatID());
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                isTrue=true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isTrue;
    }

    @Override
    public boolean isUniqName(Category o) {
        boolean uniqCategory = false;

        return uniqCategory;
    }
}




package pattern.bus;

<<<<<<< HEAD
import pattern.dao.CatDAO;
import pattern.model.Category;

public class CatBUS implements BUS<Category> {
    CatDAO catDAO = new CatDAO();
    @Override
    public void add(Category o) {
        if(isUniqueName(o)){
=======
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
>>>>>>> 3ecfc4fa8522d906303f7d38e882c5fbdf94d9e4
            catDAO.add(o);
        }
    }

    @Override
    public void update(Category o) {
<<<<<<< HEAD

=======
        if (isTrueUpdate(o)) {
            catDAO.update(o);
        } else if (isUniqName(o)) {
            catDAO.update(o);
        }
>>>>>>> 3ecfc4fa8522d906303f7d38e882c5fbdf94d9e4
    }

    @Override
    public void delete(Category o) {
<<<<<<< HEAD

=======
        if (catDAO.isNotUsed(o)) {
            catDAO.remove(String.valueOf(o));//
        }
>>>>>>> 3ecfc4fa8522d906303f7d38e882c5fbdf94d9e4
    }

    @Override
    public boolean isTrueUpdate(Category o) {
<<<<<<< HEAD
        return false;
    }

    @Override
    public boolean isUniqueName(Category o) {
        return false;
    }
}
=======
        boolean isTreu = false;
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
                return isTreu;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isTreu;
    }

    @Override
    public boolean isUniqName(Category o) {
        boolean uniqCategory = false;
        String sql = "insert into Category (CatName, [Desc]) values (?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, o.getCatName());
            preparedStatement.setString(2, o.getDesc());

            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println("in not uniq");
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Sucess");
                alert.setHeaderText("ERROR : used");
                alert.setContentText("CategoryName" + "  '" + o.getCatName() + "' " + "Already exist");
                alert.initStyle(StageStyle.UNDECORATED);
                alert.showAndWait();


            }
            uniqCategory = true;
        } catch (SQLException e) {
            Logger.getLogger(Category.class.getName()).log(Level.SEVERE, null, e);
        }
           return uniqCategory;
    }
}



>>>>>>> 3ecfc4fa8522d906303f7d38e882c5fbdf94d9e4

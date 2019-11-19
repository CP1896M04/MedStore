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
        } else {
            //no no;
        }
    }

    @Override
    public boolean isTrueUpdate(Category o) {
            return false;
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




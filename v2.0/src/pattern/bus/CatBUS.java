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
    CatDAO catDAO = new CatDAO();
    @Override
    public void add(Category o) {
        if (catDAO.isUniqName(o)) {
            catDAO.add(o);
        }
    }

    @Override
    public void update(Category o) {
        if (!catDAO.isUniqName(o)) {
            catDAO.update(o);
        }
    }

    @Override
    public void delete(String id) {
        catDAO.remove(id);
    }


}




package pattern.bus;

import javafx.scene.control.Alert;
import javafx.stage.StageStyle;
import pattern.connection.ConnectionFactory;
import pattern.dao.ProductDAO;
import pattern.model.Category;
import pattern.model.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductBUS implements BUS<Product> {
ProductDAO productDAO= new ProductDAO();
    @Override
    public void add(Product o) {
        if (productDAO.isUniqName(o)) {
        productDAO.add(o);
        }
    }

    @Override
    public void update(Product o) {
        if (productDAO.isUpdate(o)) {
            productDAO.update(o);
        }
    }

    @Override
    public void delete(String id) {
        try {
            productDAO.remove(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

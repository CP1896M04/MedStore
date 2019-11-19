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

    @Override
    public void add(Product o) {

    }

    @Override
    public void update(Product o) {

    }

    @Override
    public void delete(String id) {

    }
}

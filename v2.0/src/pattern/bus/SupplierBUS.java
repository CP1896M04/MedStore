package pattern.bus;

import javafx.scene.control.Alert;
import javafx.stage.StageStyle;
import pattern.connection.ConnectionFactory;
import pattern.dao.SupplierDao;
import pattern.model.Product;
import pattern.model.Supplier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SupplierBUS implements  BUS<Supplier> {

    @Override
    public void add(Supplier o) {

    }

    @Override
    public void update(Supplier o) {

    }

    @Override
    public void delete(String id) {

    }
}

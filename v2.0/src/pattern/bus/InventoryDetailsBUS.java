package pattern.bus;

import javafx.scene.control.Alert;
import javafx.stage.StageStyle;
import pattern.connection.ConnectionFactory;
import pattern.dao.InventoryDetailsDAO;
import pattern.model.InventoryDetails;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InventoryDetailsBUS implements BUS<InventoryDetails> {

    @Override
    public void add(InventoryDetails o) {

    }

    @Override
    public void update(InventoryDetails o) {

    }

    @Override
    public void delete(String id) {

    }
}

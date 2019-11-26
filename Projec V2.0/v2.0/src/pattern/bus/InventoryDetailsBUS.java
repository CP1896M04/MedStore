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
    InventoryDetailsDAO inventoryDetailsDAO = new InventoryDetailsDAO();
    @Override
    public void add(InventoryDetails o) {
        if (inventoryDetailsDAO.isUniqName(o)) {
            inventoryDetailsDAO.add(o);
        }
    }

    @Override
    public void update(InventoryDetails o) {
        if (inventoryDetailsDAO.isUpdate(o)) {
            inventoryDetailsDAO.update(o);
        }
    }

    @Override
    public void delete(String id){
        try {
            inventoryDetailsDAO.remove(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

package pattern.bus;

import javafx.scene.control.Alert;
import javafx.stage.StageStyle;
import pattern.connection.ConnectionFactory;
import pattern.dao.InventoryLedgerDAO;
import pattern.model.InventoryDetails;
import pattern.model.InventoryLedger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InventoryLedgerBUS implements BUS<InventoryLedger> {
InventoryLedgerDAO inventoryLedgerDAO = new InventoryLedgerDAO();
    @Override
    public void add(InventoryLedger o) {
        if (inventoryLedgerDAO.isUniqName(o)) {
            inventoryLedgerDAO.add(o);
        }
    }

    @Override
    public void update(InventoryLedger o) {
        if (inventoryLedgerDAO.isUpdate(o)) {
            inventoryLedgerDAO.update(o);
        }
    }

    @Override
    public void delete(String id) {inventoryLedgerDAO.remove(id);

    }
}

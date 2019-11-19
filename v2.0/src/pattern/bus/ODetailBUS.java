package pattern.bus;

import javafx.scene.control.Alert;
import javafx.stage.StageStyle;
import pattern.connection.ConnectionFactory;
import pattern.dao.ODetailDAO;
import pattern.dao.OderDAO;
import pattern.model.InventoryDetails;
import pattern.model.ODetail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ODetailBUS implements BUS<ODetail> {
    ODetailDAO oDetailDAO= new ODetailDAO();
    @Override
    public void add(ODetail o) {
        oDetailDAO.add(o);
    }

    @Override
    public void update(ODetail o) {
        oDetailDAO.update(o);
    }

    @Override
    public void delete(String id) {
        try {
       oDetailDAO.remove(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

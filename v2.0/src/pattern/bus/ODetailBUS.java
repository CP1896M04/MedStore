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
OderDAO oderDAO= new OderDAO();
    @Override
    public void add(ODetail o) {
//        if (oderDAO.isUniqName(o)) {
//            oderDAO.add(o);
//        }
    }

    @Override
    public void update(ODetail o) {
//        if (oderDAO.isUpdate(o)) {
//            oderDAO.update(o);
//        }

    }

    @Override
    public void delete(String id) {
//        try {
//            oderDAO.remove(id);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }
}

package pattern.bus;

import javafx.scene.control.Alert;
import javafx.stage.StageStyle;
import pattern.connection.ConnectionFactory;
import pattern.dao.UnitDAO;
import pattern.model.Unit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UnitBUS implements BUS<Unit> {
UnitDAO unitDAO= new UnitDAO();
    @Override
    public void add(Unit o) {
        if (unitDAO.isUniqName(o)) {
            unitDAO.add(o);
        }
    }

    @Override
    public void update(Unit o) {
        if (unitDAO.isUpdate(o)) {
            unitDAO.update(o);
        }
    }

    @Override
    public void delete(String id) {
        try {
            unitDAO.remove(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

package pattern.bus;

import javafx.scene.control.Alert;
import javafx.stage.StageStyle;
import pattern.connection.ConnectionFactory;
import pattern.dao.StaffDAO;
import pattern.model.Staff;
import pattern.model.Unit;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StaffBUS  implements BUS<Staff>{
        StaffDAO staffDAO= new StaffDAO();
    @Override
    public void add(Staff o) {
        if (staffDAO.isUniqName(o)) {
            staffDAO.add(o);
        }
    }

    @Override
    public void update(Staff o) {
        if (staffDAO.isUpdate(o)) {
            staffDAO.update(o);
        }
    }

    @Override
    public void delete(String id) {
        try {
            staffDAO.remove(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

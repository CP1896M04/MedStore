package pattern.bus;

import javafx.scene.control.Alert;
import javafx.stage.StageStyle;
import pattern.connection.ConnectionFactory;
import pattern.dao.RoleDAO;
import pattern.model.Product;
import pattern.model.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RoleBUS implements  BUS<Role> {
 RoleDAO roleDAO= new RoleDAO();
    @Override
    public void add(Role o) {
        if (roleDAO.isUniqName(o)) {
            roleDAO.add(o);
        }
    }

    @Override
    public void update(Role o) {
        if (roleDAO.isUpdate(o)) {
            roleDAO.update(o);
        }
    }

    @Override
    public void delete(String id) {
        try {
            roleDAO.remove(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

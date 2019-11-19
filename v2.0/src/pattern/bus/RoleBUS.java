package pattern.bus;

import pattern.dao.RoleDAO;
import pattern.model.Role;

import java.sql.SQLException;

public class RoleBUS implements  BUS<Role> {
    RoleDAO roleDAO= new RoleDAO();
    @Override
    public void add(Role o) {
        if (isUniqName(o)) {
          roleDAO.add(o);
        }
    }

    @Override
    public void update(Role o) {
        if (isTrueUpdate(o)) {
            roleDAO.update(o);
        } else if (isUniqName(o)) {
            roleDAO.update(o);
        }
    }

    @Override
    public void delete(Role o) {
        if(roleDAO.isNotUsed(o)){
            try {
                roleDAO.remove(String.valueOf(o));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else{
            //noting
        }
    }

    @Override
    public boolean isTrueUpdate(Role o) {
        return false;
    }

    @Override
    public boolean isUniqName(Role o) {
        return false;
    }
}

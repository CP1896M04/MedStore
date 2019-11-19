package pattern.bus;

import pattern.dao.OderDAO;
import pattern.model.Order;

import java.sql.SQLException;

public class OderBUS implements BUS<Order> {
    OderDAO oderDAO= new OderDAO();
    @Override
    public void add(Order o) {
        if (isUniqName(o)) {
            oderDAO.add(o);
        }
    }

    @Override
    public void update(Order o) {
        if (isTrueUpdate(o)) {
            oderDAO.update(o);
        } else if (isUniqName(o)) {
            oderDAO.update(o);
        }
    }

    @Override
    public void delete(Order o) {
        if(oderDAO.isNotUsed(o)){
            try {
                oderDAO.remove(String.valueOf(o));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else{
            //noting
        }
    }

    @Override
    public boolean isTrueUpdate(Order o) {
        return false;
    }

    @Override
    public boolean isUniqName(Order o) {

        return false;
    }
}

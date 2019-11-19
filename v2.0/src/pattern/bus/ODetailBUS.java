package pattern.bus;

import pattern.dao.ODetailDAO;
import pattern.model.ODetail;

import java.sql.SQLException;

public class ODetailBUS implements BUS<ODetail> {
    ODetailDAO oDetailDAO= new ODetailDAO();
    @Override
    public void add(ODetail o) {
        if (isUniqName(o)) {
            oDetailDAO.add(o);
        }
    }

    @Override
    public void update(ODetail o) {
        if (isTrueUpdate(o)) {
            oDetailDAO.update(o);
        } else if (isUniqName(o)) {
            oDetailDAO.update(o);
        }
    }

    @Override
    public void delete(ODetail o) {
        if(oDetailDAO.isNotUsed(o)){
            try {
                oDetailDAO.remove(String.valueOf(o));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else{
            //noting
        }
    }

    @Override
    public boolean isTrueUpdate(ODetail o) {
        return false;
    }

    @Override
    public boolean isUniqName(ODetail o) {
        return false;
    }
}

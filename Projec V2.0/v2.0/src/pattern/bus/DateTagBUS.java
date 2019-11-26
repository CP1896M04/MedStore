package pattern.bus;

import pattern.dao.DateTagDAO;
import pattern.model.DateTag;

import java.sql.SQLException;

public class DateTagBUS implements BUS<DateTag>{
    DateTagDAO dateTagDAO = new DateTagDAO();
    @Override
    public void add(DateTag o) {
        if (dateTagDAO.isUniqName(o)) {
            dateTagDAO.add(o);
        }
    }

    @Override
    public void update(DateTag o) {
        if (dateTagDAO.isUpdate(o)) {
            dateTagDAO.update(o);
        }
    }

    @Override
    public void delete(String id) {
        try {
            dateTagDAO.remove(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

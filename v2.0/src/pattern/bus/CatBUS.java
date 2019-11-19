package pattern.bus;

import pattern.dao.CatDAO;
import pattern.model.Category;

public class CatBUS implements BUS<Category> {
    CatDAO catDAO = new CatDAO();
    @Override
    public void add(Category o) {
        if(isUniqueName(o)){
            catDAO.add(o);
        }
    }

    @Override
    public void update(Category o) {

    }

    @Override
    public void delete(Category o) {

    }

    @Override
    public boolean isTrueUpdate(Category o) {
        return false;
    }

    @Override
    public boolean isUniqueName(Category o) {
        return false;
    }
}

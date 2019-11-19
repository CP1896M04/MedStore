package pattern.bus;

import pattern.dao.ProductDAO;
import pattern.model.Product;

import java.sql.SQLException;

public class ProductBUS implements BUS<Product> {
    ProductDAO productDAO= new ProductDAO();
    @Override
    public void add(Product o) {
        if (isUniqName(o)) {
           productDAO.add(o);
        }
    }

    @Override
    public void update(Product o) {
        if (isTrueUpdate(o)) {
            productDAO.update(o);
        } else if (isUniqName(o)) {
            productDAO.update(o);
        }
    }

    @Override
    public void delete(Product o) {
        if(productDAO.isNotUsed(o)){
            try {
                productDAO.remove(String.valueOf(o));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else{
            //noting
        }
    }

    @Override
    public boolean isTrueUpdate(Product o) {
        return false;
    }

    @Override
    public boolean isUniqName(Product o) {
        return false;
    }
}

package pattern.bus;

import pattern.dao.InventoryDetailsDAO;
import pattern.model.InventoryDetails;

import java.sql.SQLException;

public class InventoryDetailsBUS implements BUS<InventoryDetails> {
    InventoryDetailsDAO inventoryDetailsDAO= new InventoryDetailsDAO();
    @Override
    public void add(InventoryDetails o) {
        if(isUniqName(o)){
            inventoryDetailsDAO.add(o);

        }
    }

    @Override
    public void update(InventoryDetails o) {
    if(isTrueUpdate(o)){
        inventoryDetailsDAO.update(o);
    }else if(isUniqName(o)){
        inventoryDetailsDAO.update(o);
    }
    }

    @Override
    public void delete(InventoryDetails o) {
        if(inventoryDetailsDAO.isNotUsed(o)){
            try {
                inventoryDetailsDAO.remove(String.valueOf(o));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else{
            //
        }
    }

    @Override
    public boolean isTrueUpdate(InventoryDetails o) {
        return false;
    }

    @Override
    public boolean isUniqName(InventoryDetails o) {
        return false;
    }
}

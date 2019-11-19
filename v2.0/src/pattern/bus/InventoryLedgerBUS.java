package pattern.bus;

import pattern.dao.InventoryLedgerDAO;
import pattern.model.InventoryLedger;

public class InventoryLedgerBUS implements BUS<InventoryLedger> {
    InventoryLedgerDAO inventoryLedgerDAO= new InventoryLedgerDAO();

    @Override
    public void add(InventoryLedger o) {
        if(isUniqName(o)){
            inventoryLedgerDAO.add(o);

        }
    }

    @Override
    public void update(InventoryLedger o) {
        if (isTrueUpdate(o)) {
            inventoryLedgerDAO.update(o);
        } else if (isUniqName(o)) {
            inventoryLedgerDAO.update(o);
        }
    }

    @Override
    public void delete(InventoryLedger o) {
        if(inventoryLedgerDAO.isNotUsed(o)){
            inventoryLedgerDAO.remove(String.valueOf(o));
        }else{
            //noting
        }
    }

    @Override
    public boolean isTrueUpdate(InventoryLedger o) {
        return false;
    }

    @Override
    public boolean isUniqName(InventoryLedger o) {
        return false;
    }
}

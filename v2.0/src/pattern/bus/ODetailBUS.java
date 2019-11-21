package pattern.bus;

import javafx.scene.control.Alert;
import javafx.stage.StageStyle;
import lib.LibraryAssistant;
import pattern.connection.ConnectionFactory;
import pattern.dao.*;
import pattern.model.DateTag;
import pattern.model.InventoryDetails;
import pattern.model.InventoryLedger;
import pattern.model.ODetail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ODetailBUS implements BUS<ODetail> {
    ODetailDAO oDetailDAO= new ODetailDAO();
    InventoryDetailsDAO inventoryDetailsDAO = new InventoryDetailsDAO();
    public int insertProc(){
        return oDetailDAO.insertProc();
    }
    @Override
    public void add(ODetail o) {
        if(inventoryDetailsDAO.isEnough(o.getProductID().toString(),o.getQty(),o.getPName())){
            //add to oDetail
            oDetailDAO.add(o);
            //add to log
            DateTagDAO dateTagDAO = new DateTagDAO();
            DateTag dateTag = new DateTag();
            LibraryAssistant.formatDate(dateTag);
            addLeger(o,dateTagDAO.procInsert(dateTag));
            //update inventory detail
            inventoryDetailsDAO.withdraw(o.getProductID().toString(),o.getQty());
        }
    }

    @Override
    public void update(ODetail o) {
        oDetailDAO.update(o);
    }

    @Override
    public void delete(String id) {
        try {
       oDetailDAO.remove(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void addLeger(ODetail oDetail,int datTagID){
        InventoryLedgerDAO inventoryLedgerDAO = new InventoryLedgerDAO();
        InventoryLedger inventoryLedger = new InventoryLedger();
        inventoryLedger.setLegerCode(oDetail.getProductID()+"-"+datTagID);
        inventoryLedger.setInventoryPurchaseCost(oDetail.getTotal());
        inventoryLedger.setProductID(oDetail.getProductID());
        inventoryLedger.setQuantityTransacted(oDetail.getQty());
        inventoryLedger.setDateTag(datTagID);
        inventoryLedger.setTransactionType("O");

        inventoryLedgerDAO.add(inventoryLedger);
    }
}

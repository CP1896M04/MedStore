package pattern.model;

import java.sql.Date;
import java.sql.Timestamp;

public class InventoryLedger {
    private Integer LegerID;
    private String LegerCode;
    private Integer ProductID;
    private String TransactionType;
    private Integer QuantityTransacted;
    private Float InventoryPurchaseCost;
    private int DateTag;

    public InventoryLedger(Integer legerID, String legerCode, Integer productID, String transactionType, Integer quantityTransacted, Float inventoryPurchaseCost, int dateTag) {
        LegerID = legerID;
        LegerCode = legerCode;
        ProductID = productID;
        TransactionType = transactionType;
        QuantityTransacted = quantityTransacted;
        InventoryPurchaseCost = inventoryPurchaseCost;
        DateTag = dateTag;
    }

    public InventoryLedger() {
    }

    public void setLegerID(Integer legerID) {
        LegerID = legerID;
    }

    public void setLegerCode(String legerCode) {
        LegerCode = legerCode;
    }

    public void setProductID(Integer productID) {
        ProductID = productID;
    }

    public void setTransactionType(String transactionType) {
        TransactionType = transactionType;
    }

    public void setQuantityTransacted(Integer quantityTransacted) {
        QuantityTransacted = quantityTransacted;
    }

    public void setInventoryPurchaseCost(Float inventoryPurchaseCost) {
        InventoryPurchaseCost = inventoryPurchaseCost;
    }

    public void setDateTag(int dateTag) {
        DateTag = dateTag;
    }

    public Integer getLegerID() {
        return LegerID;
    }

    public String getLegerCode() {
        return LegerCode;
    }

    public Integer getProductID() {
        return ProductID;
    }

    public String getTransactionType() {
        return TransactionType;
    }

    public Integer getQuantityTransacted() {
        return QuantityTransacted;
    }

    public Float getInventoryPurchaseCost() {
        return InventoryPurchaseCost;
    }

    public int getDateTag() {
        return DateTag;
    }
}

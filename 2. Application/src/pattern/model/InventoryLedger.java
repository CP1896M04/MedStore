package pattern.model;

import java.sql.Timestamp;

public class InventoryLedger {
    private Integer LegerID ;
    private String LegerCode ;
    private Integer ProductID ;
    private Integer QuantityTransacted ;
    private Float InventoryPurchaseCost ;
    private Timestamp DateTime ;

    public InventoryLedger(Integer legerID, String legerCode, Integer productID, Integer quantityTransacted, Float inventoryPurchaseCost, Timestamp dateTime) {
        LegerID = legerID;
        LegerCode = legerCode;
        ProductID = productID;
        QuantityTransacted = quantityTransacted;
        InventoryPurchaseCost = inventoryPurchaseCost;
        DateTime = dateTime;
    }

    public Integer getLegerID() {
        return LegerID;
    }

    public void setLegerID(Integer legerID) {
        LegerID = legerID;
    }

    public String getLegerCode() {
        return LegerCode;
    }

    public void setLegerCode(String legerCode) {
        LegerCode = legerCode;
    }

    public Integer getProductID() {
        return ProductID;
    }

    public void setProductID(Integer productID) {
        ProductID = productID;
    }

    public Integer getQuantityTransacted() {
        return QuantityTransacted;
    }

    public void setQuantityTransacted(Integer quantityTransacted) {
        QuantityTransacted = quantityTransacted;
    }

    public Float getInventoryPurchaseCost() {
        return InventoryPurchaseCost;
    }

    public void setInventoryPurchaseCost(Float inventoryPurchaseCost) {
        InventoryPurchaseCost = inventoryPurchaseCost;
    }

    public Timestamp getDateTime() {
        return DateTime;
    }

    public void setDateTime(Timestamp dateTime) {
        DateTime = dateTime;
    }
}

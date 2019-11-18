package pattern.model;

import java.sql.Date;

public class InventoryDetails {
   private Integer  DetailsID ;
   private String DetailsCode;
   private Integer ProductID ;
   private Float PurchasePrice ;
   private Float TentativeSalesPrice ;
   private Integer QuantityBought ;
   private Integer QuantityAvailable;
   private String Batchid ;
   private Date ManufacturedDate ;
   private Date ExpiryDate;

    public InventoryDetails(Integer detailsID, String detailsCode, Integer productID, Float purchasePrice, Float tentativeSalesPrice, Integer quantityBought, Integer quantityAvailable, String batchid, Date manufacturedDate, Date expiryDate) {
        DetailsID = detailsID;
        DetailsCode = detailsCode;
        ProductID = productID;
        PurchasePrice = purchasePrice;
        TentativeSalesPrice = tentativeSalesPrice;
        QuantityBought = quantityBought;
        QuantityAvailable = quantityAvailable;
        Batchid = batchid;
        ManufacturedDate = manufacturedDate;
        ExpiryDate = expiryDate;
    }

    public InventoryDetails() {

    }

    public Integer getDetailsID() {
        return DetailsID;
    }

    public void setDetailsID(Integer detailsID) {
        DetailsID = detailsID;
    }

    public String getDetailsCode() {
        return DetailsCode;
    }

    public void setDetailsCode(String detailsCode) {
        DetailsCode = detailsCode;
    }

    public int getProductID() {
        return ProductID;
    }

    public void setProductID(Integer productID) {
        ProductID = productID;
    }

    public Float getPurchasePrice() {
        return PurchasePrice;
    }

    public void setPurchasePrice(Float purchasePrice) {
        PurchasePrice = purchasePrice;
    }

    public Float getTentativeSalesPrice() {
        return TentativeSalesPrice;
    }

    public void setTentativeSalesPrice(Float tentativeSalesPrice) {
        TentativeSalesPrice = tentativeSalesPrice;
    }

    public int getQuantityBought() {
        return QuantityBought;
    }

    public void setQuantityBought(Integer quantityBought) {
        QuantityBought = quantityBought;
    }

    public int getQuantityAvailable() {
        return QuantityAvailable;
    }

    public void setQuantityAvailable(Integer quantityAvailable) {
        QuantityAvailable = quantityAvailable;
    }

    public String getBatchid() {
        return Batchid;
    }

    public void setBatchid(String batchid) {
        Batchid = batchid;
    }

    public Date getManufacturedDate() {
        return ManufacturedDate;
    }

    public void setManufacturedDate(Date manufacturedDate) {
        ManufacturedDate = manufacturedDate;
    }

    public Date getExpiryDate() {
        return ExpiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        ExpiryDate = expiryDate;
    }
    public String toString() {
        return String.format("DetailsID "+DetailsID+"DetailsCode"+DetailsCode+"ProductID "+ProductID +" PurchasePrice"+ PurchasePrice+"TentativeSalesPrice"+TentativeSalesPrice+"QuantityBought"+QuantityBought+"QuantityAvailable"+QuantityAvailable+"Batchid"+Batchid+"ManufacturedDate"+ManufacturedDate +"ExpiryDate"+ExpiryDate);
    }


}

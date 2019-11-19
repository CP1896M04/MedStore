package pattern.model;

import java.sql.Date;

public class InventoryDetails {
   private Integer  DetailsID ;
   private String DetailsCode;
   private Integer ProductID ;
   private String Pname;
   private Float PurchasePrice ;
   private Float TentativeSalesPrice ;
   private Integer QuantityBought ;
   private Integer QuantityAvailable;
   private String Batchid ;
   private Date ManufacturedDate ;
   private Date ExpiryDate;

    public InventoryDetails(Integer detailsID, String detailsCode, Integer productID, String pname, Float purchasePrice, Float tentativeSalesPrice, Integer quantityBought, Integer quantityAvailable, String batchid, Date manufacturedDate, Date expiryDate) {
        DetailsID = detailsID;
        DetailsCode = detailsCode;
        ProductID = productID;
        Pname = pname;
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

    public void setDetailsID(Integer detailsID) {
        DetailsID = detailsID;
    }

    public void setDetailsCode(String detailsCode) {
        DetailsCode = detailsCode;
    }

    public void setProductID(Integer productID) {
        ProductID = productID;
    }

    public void setPname(String pname) {
        Pname = pname;
    }

    public void setPurchasePrice(Float purchasePrice) {
        PurchasePrice = purchasePrice;
    }

    public void setTentativeSalesPrice(Float tentativeSalesPrice) {
        TentativeSalesPrice = tentativeSalesPrice;
    }

    public void setQuantityBought(Integer quantityBought) {
        QuantityBought = quantityBought;
    }

    public void setQuantityAvailable(Integer quantityAvailable) {
        QuantityAvailable = quantityAvailable;
    }

    public void setBatchid(String batchid) {
        Batchid = batchid;
    }

    public void setManufacturedDate(Date manufacturedDate) {
        ManufacturedDate = manufacturedDate;
    }

    public void setExpiryDate(Date expiryDate) {
        ExpiryDate = expiryDate;
    }

    public Integer getDetailsID() {
        return DetailsID;
    }

    public String getDetailsCode() {
        return DetailsCode;
    }

    public Integer getProductID() {
        return ProductID;
    }

    public String getPname() {
        return Pname;
    }

    public Float getPurchasePrice() {
        return PurchasePrice;
    }

    public Float getTentativeSalesPrice() {
        return TentativeSalesPrice;
    }

    public Integer getQuantityBought() {
        return QuantityBought;
    }

    public Integer getQuantityAvailable() {
        return QuantityAvailable;
    }

    public String getBatchid() {
        return Batchid;
    }

    public Date getManufacturedDate() {
        return ManufacturedDate;
    }

    public Date getExpiryDate() {
        return ExpiryDate;
    }

    public String toString() {
        return String.format("DetailsID "+DetailsID+"DetailsCode"+DetailsCode+"ProductID "+ProductID +" PurchasePrice"+ PurchasePrice+"TentativeSalesPrice"+TentativeSalesPrice+"QuantityBought"+QuantityBought+"QuantityAvailable"+QuantityAvailable+"Batchid"+Batchid+"ManufacturedDate"+ManufacturedDate +"ExpiryDate"+ExpiryDate);
    }


}

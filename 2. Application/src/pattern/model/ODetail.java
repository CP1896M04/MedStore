package pattern.model;

public class ODetail {
    private Integer ODetailID ;
    private Integer OrderID ;
    private Integer ProductID ;
    private Float USP;
    private String HTU ;
    private Integer Qty;
    private Double Discount ;
    private Float Total ;

    public ODetail(Integer ODetailID, Integer orderID, Integer productID, Float USP, String HTU, Integer qty, Double discount, Float total) {
        this.ODetailID = ODetailID;
        OrderID = orderID;
        ProductID = productID;
        this.USP = USP;
        this.HTU = HTU;
        Qty = qty;
        Discount = discount;
        Total = total;
    }

    public Integer getODetailID() {
        return ODetailID;
    }

    public void setODetailID(Integer ODetailID) {
        this.ODetailID = ODetailID;
    }

    public Integer getOrderID() {
        return OrderID;
    }

    public void setOrderID(Integer orderID) {
        OrderID = orderID;
    }

    public Integer getProductID() {
        return ProductID;
    }

    public void setProductID(Integer productID) {
        ProductID = productID;
    }

    public Float getUSP() {
        return USP;
    }

    public void setUSP(Float USP) {
        this.USP = USP;
    }

    public String getHTU() {
        return HTU;
    }

    public void setHTU(String HTU) {
        this.HTU = HTU;
    }

    public Integer getQty() {
        return Qty;
    }

    public void setQty(Integer qty) {
        Qty = qty;
    }

    public Double getDiscount() {
        return Discount;
    }

    public void setDiscount(Double discount) {
        Discount = discount;
    }

    public Float getTotal() {
        return Total;
    }

    public void setTotal(Float total) {
        Total = total;
    }
}

package pattern.model;

public class ODetail {
    private Integer ODetailID ;
    private Integer OrderID ;
    private Integer ProductID ;
    private String  PName;
    private Float UPS;
    private String HTU ;
    private Integer Qty;
    private Double Discount ;
    private Float Total ;

    public ODetail() {
    }

    public ODetail(Integer ODetailID, Integer orderID, Integer productID, String PName, Float UPS, String HTU, Integer qty, Double discount, Float total) {
        this.ODetailID = ODetailID;
        OrderID = orderID;
        ProductID = productID;
        this.PName = PName;
        this.UPS = UPS;
        this.HTU = HTU;
        Qty = qty;
        Discount = discount;
        Total = total;
    }

    public Integer getODetailID() {
        return ODetailID;
    }

    public Integer getOrderID() {
        return OrderID;
    }

    public Integer getProductID() {
        return ProductID;
    }

    public String getPName() {
        return PName;
    }

    public Float getUPS() {
        return UPS;
    }

    public String getHTU() {
        return HTU;
    }

    public Integer getQty() {
        return Qty;
    }

    public Double getDiscount() {
        return Discount;
    }

    public Float getTotal() {
        return Total;
    }

    public void setODetailID(Integer ODetailID) {
        this.ODetailID = ODetailID;
    }

    public void setOrderID(Integer orderID) {
        OrderID = orderID;
    }

    public void setProductID(Integer productID) {
        ProductID = productID;
    }

    public void setPName(String PName) {
        this.PName = PName;
    }

    public void setUPS(Float UPS) {
        this.UPS = UPS;
    }

    public void setHTU(String HTU) {
        this.HTU = HTU;
    }

    public void setQty(Integer qty) {
        Qty = qty;
    }

    public void setDiscount(Double discount) {
        Discount = discount;
    }

    public void setTotal(Float total) {
        Total = total;
    }
}

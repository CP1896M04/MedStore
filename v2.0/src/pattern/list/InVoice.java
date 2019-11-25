package pattern.list;

public class InVoice {
    private Integer OrderID ;
    private Integer ProductID ;
    private String  PName;
    private Float UPS;
    private String HTU ;
    private Integer Qty;
    private Double Discount ;
    private Double Total ;
    private String Fname;
    private String LName;
    private String Date;

    public InVoice(Integer orderID, Integer productID, String PName, Float UPS, String HTU, Integer qty, Double discount, Double total, String fname, String LName, String date) {
        OrderID = orderID;
        ProductID = productID;
        this.PName = PName;
        this.UPS = UPS;
        this.HTU = HTU;
        Qty = qty;
        Discount = discount;
        Total = total;
        Fname = fname;
        this.LName = LName;
        Date = date;
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

    public String getPName() {
        return PName;
    }

    public void setPName(String PName) {
        this.PName = PName;
    }

    public Float getUPS() {
        return UPS;
    }

    public void setUPS(Float UPS) {
        this.UPS = UPS;
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

    public Double getTotal() {
        return Total;
    }

    public void setTotal(Double total) {
        Total = total;
    }

    public String getFname() {
        return Fname;
    }

    public void setFname(String fname) {
        Fname = fname;
    }

    public String getLName() {
        return LName;
    }

    public void setLName(String LName) {
        this.LName = LName;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }
}

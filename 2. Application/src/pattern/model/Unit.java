package pattern.model;

public class Unit {
    private Integer UnitID ;
    private String Uname ;
    private Integer UInStock ;
    private  String UInStockName ;
    private  Integer UInOrder ;
    private  String UInOrderName ;
    private String Descr ;

    public Unit(Integer unitID, String uname, Integer UInStock, String UInStockName, Integer UInOrder, String UInOrderName, String descr) {
        UnitID = unitID;
        Uname = uname;
        this.UInStock = UInStock;
        this.UInStockName = UInStockName;
        this.UInOrder = UInOrder;
        this.UInOrderName = UInOrderName;
        Descr = descr;
    }

    public Integer getUnitID() {
        return UnitID;
    }

    public void setUnitID(Integer unitID) {
        UnitID = unitID;
    }

    public String getUname() {
        return Uname;
    }

    public void setUname(String uname) {
        Uname = uname;
    }

    public Integer getUInStock() {
        return UInStock;
    }

    public void setUInStock(Integer UInStock) {
        this.UInStock = UInStock;
    }

    public String getUInStockName() {
        return UInStockName;
    }

    public void setUInStockName(String UInStockName) {
        this.UInStockName = UInStockName;
    }

    public Integer getUInOrder() {
        return UInOrder;
    }

    public void setUInOrder(Integer UInOrder) {
        this.UInOrder = UInOrder;
    }

    public String getUInOrderName() {
        return UInOrderName;
    }

    public void setUInOrderName(String UInOrderName) {
        this.UInOrderName = UInOrderName;
    }

    public String getDescr() {
        return Descr;
    }

    public void setDescr(String descr) {
        Descr = descr;
    }
}

package pattern.model;

public class Order {
    private  Integer OrderID ;
    private Integer DateKey ;
    private Integer StaffID ;

    public Order() {
    }

    public Order(Integer orderID, Integer dateKey, Integer staffID) {
        OrderID = orderID;
        DateKey = dateKey;
        StaffID = staffID;
    }

    public Integer getOrderID() {
        return OrderID;
    }

    public void setOrderID(Integer orderID) {
        OrderID = orderID;
    }

    public Integer getDateKey() {
        return DateKey;
    }

    public void setDateKey(Integer dateKey) {
        DateKey = dateKey;
    }

    public Integer getStaffID() {
        return StaffID;
    }

    public void setStaffID(Integer staffID) {
        StaffID = staffID;
    }
}

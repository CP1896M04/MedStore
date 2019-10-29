package pattern.model;

public class Supplier {
    private Integer SupplierID ;
    private String ComCode ;
    private String ComName ;
    private String Address ;
    private String Phone ;
    private String Email ;
    private String Tax ;

    public Supplier(Integer supplierID, String comCode, String comName, String address, String phone, String email, String tax) {
        SupplierID = supplierID;
        ComCode = comCode;
        ComName = comName;
        Address = address;
        Phone = phone;
        Email = email;
        Tax = tax;
    }

    public Integer getSupplierID() {
        return SupplierID;
    }

    public void setSupplierID(Integer supplierID) {
        SupplierID = supplierID;
    }

    public String getComCode() {
        return ComCode;
    }

    public void setComCode(String comCode) {
        ComCode = comCode;
    }

    public String getComName() {
        return ComName;
    }

    public void setComName(String comName) {
        ComName = comName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getTax() {
        return Tax;
    }

    public void setTax(String tax) {
        Tax = tax;
    }
}

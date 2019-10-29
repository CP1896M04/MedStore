package pattern.model;

public class Product {
    private Integer ProductID;
    private Integer CatID;
    private Integer SupplierID;
    private String PName;
    private String PDescr;
    private String PComposition;
    private String PManufacturer;
    private Float UPrice;
    private Float USP;
    private Integer ReOrLevel;
    private String HTU;
    private Integer DefaultInDose;

    public Product(Integer productID, Integer catID, Integer supplierID, String PName, String PDescr, String PComposition, String PManufacturer, Float UPrice, Float USP, Integer reOrLevel, String HTU, Integer defaultInDose) {
        ProductID = productID;
        CatID = catID;
        SupplierID = supplierID;
        this.PName = PName;
        this.PDescr = PDescr;
        this.PComposition = PComposition;
        this.PManufacturer = PManufacturer;
        this.UPrice = UPrice;
        this.USP = USP;
        ReOrLevel = reOrLevel;
        this.HTU = HTU;
        DefaultInDose = defaultInDose;
    }

    public Integer getProductID() {
        return ProductID;
    }

    public Integer getCatID() {
        return CatID;
    }

    public String getSupplierID() {
        return SupplierID;
    }

    public String getPName() {
        return PName;
    }

    public String getPDescr() {
        return PDescr;
    }

    public String getPComposition() {
        return PComposition;
    }

    public String getPManufacturer() {
        return PManufacturer;
    }

    public String getUPrice() {
        return UPrice;
    }

    public String getUSP() {
        return USP;
    }

    public String getReOrLevel() {
        return ReOrLevel;
    }

    public String getHTU() {
        return HTU;
    }

    public String getDefaultInDose() {
        return DefaultInDose;
    }

    public void setProductID(Integer productID) {
        ProductID = productID;
    }

    public void setCatID(Integer catID) {
        CatID = catID;
    }

    public void setSupplierID(Integer supplierID) {
        SupplierID = supplierID;
    }

    public void setPName(String PName) {
        this.PName = PName;
    }

    public void setPDescr(String PDescr) {
        this.PDescr = PDescr;
    }

    public void setPComposition(String PComposition) {
        this.PComposition = PComposition;
    }

    public void setPManufacturer(String PManufacturer) {
        this.PManufacturer = PManufacturer;
    }

    public void setUPrice(Float UPrice) {
        this.UPrice = UPrice;
    }

    public void setUSP(Float USP) {
        this.USP = USP;
    }

    public void setReOrLevel(Integer reOrLevel) {
        ReOrLevel = reOrLevel;
    }

    public void setHTU(String HTU) {
        this.HTU = HTU;
    }

    public void setDefaultInDose(Integer defaultInDose) {
        DefaultInDose = defaultInDose;
    }
}


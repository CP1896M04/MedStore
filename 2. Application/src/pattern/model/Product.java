package pattern.model;

public class Product {
    private Integer ProductID;
    private Integer CatID;
    private Integer UnitID;
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

    public Product(Integer productID, Integer catID, Integer unitID, Integer supplierID, String PName, String PDescr, String PComposition, String PManufacturer, Float UPrice, Float USP, Integer reOrLevel, String HTU, Integer defaultInDose) {
        ProductID = productID;
        CatID = catID;
        UnitID = unitID;
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

    public Product() {
    }

    public Integer getProductID() {
        return ProductID;
    }

    public void setProductID(Integer productID) {
        ProductID = productID;
    }

    public Integer getCatID() {
        return CatID;
    }

    public void setCatID(Integer catID) {
        CatID = catID;
    }

    public Integer getUnitID() {
        return UnitID;
    }

    public void setUnitID(Integer unitID) {
        UnitID = unitID;
    }

    public Integer getSupplierID() {
        return SupplierID;
    }

    public void setSupplierID(Integer supplierID) {
        SupplierID = supplierID;
    }

    public String getPName() {
        return PName;
    }

    public void setPName(String PName) {
        this.PName = PName;
    }

    public String getPDescr() {
        return PDescr;
    }

    public void setPDescr(String PDescr) {
        this.PDescr = PDescr;
    }

    public String getPComposition() {
        return PComposition;
    }

    public void setPComposition(String PComposition) {
        this.PComposition = PComposition;
    }

    public String getPManufacturer() {
        return PManufacturer;
    }

    public void setPManufacturer(String PManufacturer) {
        this.PManufacturer = PManufacturer;
    }

    public Float getUPrice() {
        return UPrice;
    }

    public void setUPrice(Float UPrice) {
        this.UPrice = UPrice;
    }

    public Float getUSP() {
        return USP;
    }

    public void setUSP(Float USP) {
        this.USP = USP;
    }

    public Integer getReOrLevel() {
        return ReOrLevel;
    }

    public void setReOrLevel(Integer reOrLevel) {
        ReOrLevel = reOrLevel;
    }

    public String getHTU() {
        return HTU;
    }

    public void setHTU(String HTU) {
        this.HTU = HTU;
    }

    public Integer getDefaultInDose() {
        return DefaultInDose;
    }

    public void setDefaultInDose(Integer defaultInDose) {
        DefaultInDose = defaultInDose;
    }
}
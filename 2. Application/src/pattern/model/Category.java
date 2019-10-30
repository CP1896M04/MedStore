package pattern.model;

public class Category {
    private Integer CatID;
    private String CatName;
    private String Desc;

    public Category(Integer catID, String catName, String desc) {
        CatID = catID;
        CatName = catName;
        Desc = desc;
    }
    public Integer getCatID() {

        return CatID;
    }
    public void setCatID(Integer catID) {
        CatID = catID;
    }

    public String getCatName() {
        return CatName;
    }

    public void setCatName(String catName) {
        CatName = catName;
    }

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String desc) {
        Desc = desc;
    }
    public String toString() {
        return String.format("CatID"+CatID+"CatName"+CatName+"Desc"+Desc);

    }
}

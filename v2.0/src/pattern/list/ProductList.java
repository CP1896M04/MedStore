package pattern.list;

public class ProductList {
        private Integer ProductID;
        private String PName;
        private String CatName;
        private String PDescr;
        private String PComposition;
        private String PManufacturer;
        private  Float Uprice;
        private Float USP;

        public ProductList(Integer productID, String PName, String catName, String PDescr, String PComposition, String PManufacturer, Float uprice, Float USP) {
            ProductID = productID;
            this.PName = PName;
            CatName = catName;
            this.PDescr = PDescr;
            this.PComposition = PComposition;
            this.PManufacturer = PManufacturer;
            Uprice = uprice;
            this.USP = USP;
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

        public String getCatName() {
            return CatName;
        }

        public void setCatName(String catName) {
            CatName = catName;
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

        public Float getUprice() {
            return Uprice;
        }

        public void setUprice(Float uprice) {
            Uprice = uprice;
        }

        public Float getUSP() {
            return USP;
        }

        public void setUSP(Float USP) {
            this.USP = USP;
        }
    }


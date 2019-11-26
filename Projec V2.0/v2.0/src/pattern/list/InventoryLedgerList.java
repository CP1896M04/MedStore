package pattern.list;

public class InventoryLedgerList {
        private Integer LegerID;
        private Integer ProductID;
        private String PName;
        private String TransactionType;
        private Integer QuantityTransacted;
        private Float InventoryPurchaseCost;
        private int DateTag;

        public InventoryLedgerList(Integer legerID, Integer productID, String PName, String transactionType, Integer quantityTransacted, Float inventoryPurchaseCost, int dateTag) {
            LegerID = legerID;
            ProductID = productID;
            this.PName = PName;
            TransactionType = transactionType;
            QuantityTransacted = quantityTransacted;
            InventoryPurchaseCost = inventoryPurchaseCost;
            DateTag = dateTag;
        }

        public Integer getLegerID() {
            return LegerID;
        }

        public void setLegerID(Integer legerID) {
            LegerID = legerID;
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

        public String getTransactionType() {
            return TransactionType;
        }

        public void setTransactionType(String transactionType) {
            TransactionType = transactionType;
        }

        public Integer getQuantityTransacted() {
            return QuantityTransacted;
        }

        public void setQuantityTransacted(Integer quantityTransacted) {
            QuantityTransacted = quantityTransacted;
        }

        public Float getInventoryPurchaseCost() {
            return InventoryPurchaseCost;
        }

        public void setInventoryPurchaseCost(Float inventoryPurchaseCost) {
            InventoryPurchaseCost = inventoryPurchaseCost;
        }

        public int getDateTag() {
            return DateTag;
        }

        public void setDateTag(int dateTag) {
            DateTag = dateTag;
        }
    }



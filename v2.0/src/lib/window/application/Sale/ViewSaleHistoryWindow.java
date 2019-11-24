package lib.window.application.Sale;

import controller.application.sale.ViewPointOfSaleController;
import controller.application.sale.ViewSaleHistoryController;

public class ViewSaleHistoryWindow {
    private static ViewSaleHistoryController instance;
    private ViewSaleHistoryWindow() throws Exception {}
    public static  ViewSaleHistoryController getInstance() throws Exception {
        if(instance == null){
            instance = new ViewSaleHistoryController();
        }
        return instance;
    }
}

package lib.window.application.Sale;

import controller.application.sale.ViewPointOfSaleController;

public class viewPointOfSaleWindow {
    private static ViewPointOfSaleController instance;
    private viewPointOfSaleWindow() throws Exception {}
    public static  ViewPointOfSaleController getInstance() throws Exception {
        if(instance == null){
            instance = new ViewPointOfSaleController();
        }
        return instance;
    }
}

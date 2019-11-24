package lib.window.application;

import controller.application.SaleController;

public class SaleWindow {
    private static SaleController instance;
    private SaleWindow() throws Exception {}
    public static SaleController getInstance() throws Exception {
        if(instance == null){
            instance = new SaleController();
        }
        return instance;
    }
}

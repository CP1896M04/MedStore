package lib.window.application.product;

import controller.application.product.ViewUnitController;

public class ViewUnitWindow {
    private static ViewUnitController instance;
    private ViewUnitWindow() throws Exception {}
    public static ViewUnitController  getInstance() throws Exception {
        if(instance == null){
            instance = new ViewUnitController();
        }
        return instance;
    }
}

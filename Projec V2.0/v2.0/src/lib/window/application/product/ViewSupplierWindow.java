package lib.window.application.product;

import controller.application.product.ViewSupplierCotroller;

public class ViewSupplierWindow {
    private static ViewSupplierCotroller instance;
    private ViewSupplierWindow() throws Exception {}
    public static ViewSupplierCotroller  getInstance() throws Exception {
        if(instance == null){
            instance = new ViewSupplierCotroller();
        }
        return instance;
    }
}

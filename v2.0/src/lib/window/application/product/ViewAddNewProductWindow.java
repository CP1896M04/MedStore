package lib.window.application.product;

import controller.application.product.ViewAddNewProductController;

public class ViewAddNewProductWindow {
    private static ViewAddNewProductController instance;
    private ViewAddNewProductWindow() throws Exception {}
    public static  ViewAddNewProductController getInstance() throws Exception {
        if(instance == null){
            instance = new ViewAddNewProductController();
        }
        return instance;
    }
}

package lib.window.application.product;

import controller.application.product.ViewCurrentProductController;

public class ViewCurrentProductWindow {
    private static ViewCurrentProductController instance;
    private ViewCurrentProductWindow() throws Exception {}
    public static ViewCurrentProductController  getInstance() throws Exception {
        if(instance == null){
            instance = new ViewCurrentProductController();
        }
        return instance;
    }
}

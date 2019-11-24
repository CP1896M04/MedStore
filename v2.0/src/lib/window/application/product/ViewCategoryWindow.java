package lib.window.application.product;

import controller.application.product.ViewCategoryController;

public class ViewCategoryWindow {
    private static ViewCategoryController instance;
    private ViewCategoryWindow() throws Exception {}
    public static  ViewCategoryController  getInstance() throws Exception {
        if(instance == null){
            instance = new ViewCategoryController();
        }
        return instance;
    }
}

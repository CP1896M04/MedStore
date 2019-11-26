package lib.window.application;

import controller.application.ProductController;
import controller.application.SaleController;

public class ProductWindow {
    private static ProductController instance;
    private ProductWindow() throws Exception {}
    public static ProductController getInstance() throws Exception {
        if(instance == null){
            instance = new ProductController();
        }
        return instance;
    }
}

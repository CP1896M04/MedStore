package lib.window.application;

import controller.application.ReportController;
import controller.application.SaleController;

public class ReportWindow {
    private static ReportController instance;
    private ReportWindow() throws Exception {}
    public static ReportController getInstance() throws Exception {
        if(instance == null){
            instance = new ReportController();
        }
        return instance;
    }
}

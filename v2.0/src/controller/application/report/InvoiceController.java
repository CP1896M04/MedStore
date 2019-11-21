package controller.application.report;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.print.PageOrientation;
import javafx.print.Paper;
import javafx.print.Printer;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class InvoiceController implements Initializable {
    @FXML
    private Label lbFName;

    @FXML
    private Label lbDateOrder;

    @FXML
    private Label lbTotal;

    @FXML
    private TableColumn<?, ?> collumStt;

    @FXML
    private TableColumn<?, ?> columPName;

    @FXML
    private TableColumn<?, ?> columQty;

    @FXML
    private TableColumn<?, ?> columHTU;

    @FXML
    private TableColumn<?, ?> columPrice;
    @FXML
    private Label jobStatus;
    @FXML
    private AnchorPane root;
    @FXML
    private Button btnPrint;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    private void print(Node node) {
//        jobStatus.textProperty().unbind();
////        jobStatus.setText("Creating a printer job...");
////
////        // Create a printer job for teh default printer
////        Printer printer = Printer.getDefaultPrinter();
////        printer.createPageLayout(Paper.A4, PageOrientation.PORTRAIT, Printer.MarginType.EQUAL);
////        PrinterJob job = PrinterJob.createPrinterJob(printer);
////        if (job != null) {
////            // Show the printer job status
////            jobStatus.textProperty().bind(job.jobStatusProperty().asString());
////
////            // Print the node
////            boolean printed = job.printPage(node);
////            if (printed) {
////                // End the printer job
////                job.endJob();
////            } else {
////                jobStatus.textProperty().unbind();
////                jobStatus.setText("Printing failed.");
////            }
////        } else {
////            jobStatus.setText("Could not create a printer job.");
////        }
        Printer printer = Printer.getDefaultPrinter();
        printer.createPageLayout(Paper.A4, PageOrientation.PORTRAIT, Printer.MarginType.EQUAL);
        PrinterJob printerJob = PrinterJob.createPrinterJob(printer);
        printerJob.showPageSetupDialog(node.getScene().getWindow());
        //printerJob.showPrintDialog(node.getScene().getWindow());
        if (printerJob != null) {
            boolean success = printerJob.printPage(node);
            if (success) {
                printerJob.endJob();
            }
        }
    }
    @FXML
    void btnPrintClick(ActionEvent event) {
       print(root);
    }

}

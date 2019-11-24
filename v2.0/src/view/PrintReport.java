package view;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.view.JasperViewer;
import org.springframework.core.io.ClassPathResource;
import pattern.connection.ConnectionFactory;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Map;

public class PrintReport extends JFrame {
    ConnectionFactory connectionFactory = new ConnectionFactory();
    Connection connection = connectionFactory.getConnection();
    ResultSet rs=null;
    public void showReport(){
        try {
            this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            //JasperDesign jasperDesign;
            //JasperReport jasperReport = JasperCompileManager.compileReport(new ClassPathResource("/report/design/report1.jasper").getInputStream());
            //JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, connection);
            JasperPrint jasperPrint = JasperFillManager.fillReport(new ClassPathResource("/report/design/invoice.jasper").getInputStream(), null, connection);
            JasperViewer jasperViewer = new JasperViewer(jasperPrint);
            JDialog dialog = new JDialog(this);//the owner
            dialog.setContentPane(jasperViewer.getContentPane());
            dialog.setSize(jasperViewer.getSize());
            dialog.setTitle("XXXXX");
            dialog.setVisible(true);
            //jasperViewer.setVisible(true);
//            this.add(jasperViewer);
//            this.setSize(900,500);
//            this.setVisible(true);
//            this.pack();
        }catch (Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(rootPane,e.getMessage());
        }
    }
}

package controller.application.report;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;
import org.springframework.core.io.ClassPathResource;
import pattern.connection.ConnectionFactory;
import pattern.dao.ODetailDAO;
import pattern.model.ODetail;
import view.PrintReport;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReportWindow extends JFrame {
    private JPanel jPanel;
    public ReportWindow(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100,100,450,300);
        jPanel = new JPanel();
        jPanel.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(jPanel);
        this.pack();
        this.setVisible(true);
        showReport();
    }
    public static void main(String[] args) throws IOException, JRException {
            ReportWindow reportWindow = new ReportWindow();
            reportWindow.showReport();
    }
    public void showReport() {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.getConnection();
        ResultSet rs = null;
        try {
            ODetailDAO oDetailDAO = new ODetailDAO();
            List<ODetail> oDetails =oDetailDAO.getList();
            List<Map<String,?>> dataSource = new ArrayList<Map<String,?>>();
            for(ODetail oDetail:oDetails){
                Map<String,Object> m = new HashMap<String,Object>();
                m.put("Pname",oDetail.getPName());
                m.put("Qty",oDetail.getQty());
                m.put("HTU",oDetail.getHTU());
                m.put("USP",oDetail.getUPS());
                m.put("Total",oDetail.getTotal());
                dataSource.add(m);
            }
            //JasperDesign jasperDesign;
            //JasperReport jasperReport = JasperCompileManager.compileReport(new ClassPathResource("/report/design/report1.jasper").getInputStream());
            //JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, connection);
            JRDataSource jrDataSource = new JRBeanCollectionDataSource(dataSource);
            JasperPrint jasperPrint = JasperFillManager.fillReport(new ClassPathResource("/report/design/invoice.jasper").getInputStream(), null, jrDataSource);
            this.getContentPane().add(new JasperViewer(jasperPrint));
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }
    }
}


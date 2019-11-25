package report.print;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.view.JasperViewer;
import org.springframework.core.io.ClassPathResource;
import pattern.connection.ConnectionFactory;
import pattern.dao.ODetailDAO;
import pattern.list.InVoice;
import pattern.model.ODetail;

import javax.swing.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrintInvoice extends JFrame {
    ConnectionFactory connectionFactory = new ConnectionFactory();
    Connection connection = connectionFactory.getConnection();
    ResultSet rs=null;
    public void showReport(int id){
        try {
            ODetailDAO oDetailDAO = new ODetailDAO();
            List<Map<String,?>> dataSource = new ArrayList<Map<String,?>>();
            List<InVoice> oDetails =oDetailDAO.searchOrder(id);
            for(InVoice oDetail:oDetails){
                Map<String,Object> m = new HashMap<String,Object>();
                m.put("OrderID",oDetail.getOrderID());
                m.put("PName",oDetail.getPName());
                m.put("Qty",oDetail.getQty());
                m.put("USP",oDetail.getUPS());
                m.put("HTU",oDetail.getHTU());
                m.put("Discount",oDetail.getDiscount());
                m.put("Total",oDetail.getTotal());
                m.put("FName",oDetail.getFname());
                m.put("LName",oDetail.getLName());
                m.put("Date", Date.valueOf(oDetail.getDate()));
                dataSource.add(m);
            }
            JRDataSource jrDataSource = new JRBeanCollectionDataSource(dataSource);
            Map para = new HashMap();
            para.put("OrderID",id);
            //JasperDesign jasperDesign;
            //JasperReport jasperReport = JasperCompileManager.compileReport(new ClassPathResource("/report/design/report1.jasper").getInputStream());
            //JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, connection);
            this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            JasperPrint jasperPrint = JasperFillManager.fillReport(new ClassPathResource("/report/design/invoice.jasper").getInputStream(), para, jrDataSource);
            JasperViewer jasperViewer = new JasperViewer(jasperPrint);
            JDialog dialog = new JDialog(this);//the owner
            dialog.setContentPane(jasperViewer.getContentPane());
            dialog.setSize(jasperViewer.getSize());
            dialog.setTitle("Invoice:"+id);
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

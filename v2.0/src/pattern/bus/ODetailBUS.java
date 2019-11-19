package pattern.bus;

import javafx.scene.control.Alert;
import javafx.stage.StageStyle;
import pattern.connection.ConnectionFactory;
import pattern.dao.ODetailDAO;
import pattern.model.InventoryDetails;
import pattern.model.ODetail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ODetailBUS implements BUS<ODetail> {
    private Connection connection;
    public  ODetailBUS() {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connection =connectionFactory.getConnection();
    }
    ODetailDAO oDetailDAO= new ODetailDAO();
    @Override
    public void add(ODetail o) {
        if (isUniqName(o)) {
            oDetailDAO.add(o);
        }
    }

    @Override
    public void update(ODetail o) {
        if (isTrueUpdate(o)) {
            oDetailDAO.update(o);
        } else if (isUniqName(o)) {
            oDetailDAO.update(o);
        }
    }

    @Override
    public void delete(ODetail o) {
        if(oDetailDAO.isNotUsed(o)){
            try {
                oDetailDAO.remove(String.valueOf(o));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else{
            //noting
        }
    }

    @Override
    public boolean isTrueUpdate(ODetail o) {
        boolean isTreu = false;
        System.out.println("we are in update");
        String sql = "UPDATE [dbo].[ODetail]" +
                "   SET [OrderID] = ?" +
                "      ,[ProductID] = ?" +
                "      ,[PName]=?"+
                "      ,[USP] = ?" +
                "      ,[HTU] = ?" +
                "      ,[Qty] = ?" +
                "      ,[Discount] = ?" +
                "      ,[Total] = ?" +
                " WHERE ODetailID = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, o.getOrderID());
            preparedStatement.setInt(2, o.getProductID());
            preparedStatement.setString(3,o.getPName());
            preparedStatement.setFloat(4, o.getUPS());
            preparedStatement.setString(5, o.getHTU());
            preparedStatement.setInt(6, o.getQty());
            preparedStatement.setDouble(7, o.getDiscount());
            preparedStatement.setFloat(8, o.getTotal());

            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                return isTreu;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isTreu;
    }

    @Override
    public boolean isUniqName(ODetail o) {
        boolean uniqOdetail= false;
        String sql = "Insert INTO [ODetail]([OrderID]" +
                "     ,[ProductID]\n" +
                "     ,[PName]    \n"+
                "     ,[USP]\n" +
                "     ,[HTU]\n" +
                "     ,[Qty]\n" +
                "     ,[Discount]\n" +
                "     ,[Total]) values (?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, o.getOrderID());
            preparedStatement.setInt(2, o.getProductID());
            preparedStatement.setString(3,o.getPName());
            preparedStatement.setFloat(4, o.getUPS());
            preparedStatement.setString(5, o.getHTU());
            preparedStatement.setInt(6, o.getQty());
            preparedStatement.setDouble(7, o.getDiscount());
            preparedStatement.setDouble(8, o.getTotal());
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println("in not uniq");
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Sucess");
                alert.setHeaderText("ERROR : used");
                alert.setContentText("CategoryName" + "  '" + o.getPName() + "' " + "Already exist");
                alert.initStyle(StageStyle.UNDECORATED);
                alert.showAndWait();
            }
            uniqOdetail  = true;
        } catch (  SQLException e ) {

            Logger.getLogger(ODetail.class.getName()).log(Level.SEVERE, null, e);
        }
        return  uniqOdetail;
    }
}

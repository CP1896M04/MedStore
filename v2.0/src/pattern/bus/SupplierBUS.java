package pattern.bus;

import javafx.scene.control.Alert;
import javafx.stage.StageStyle;
import pattern.connection.ConnectionFactory;
import pattern.dao.SupplierDao;
import pattern.model.Product;
import pattern.model.Supplier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SupplierBUS implements  BUS<Supplier> {
    private Connection connection;
    public SupplierBUS() {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connection = connectionFactory.getConnection();
    }
    SupplierDao supplierDao= new SupplierDao();
    @Override
    public void add(Supplier o) {
        if (isUniqName(o)) {
            supplierDao.add(o);
        }
    }

    @Override
    public void update(Supplier o) {
        if (isTrueUpdate(o)) {
            supplierDao.update(o);
        } else if (isUniqName(o)) {
           supplierDao.update(o);
        }
    }

    @Override
    public void delete(Supplier o) {
        if(supplierDao.isNotUsed(o)){
            try {
               supplierDao.remove(String.valueOf(o));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else{
            //noting
        }
    }

    @Override
    public boolean isTrueUpdate(Supplier o) {
        boolean isTreu = false;
        String sql = "UPDATE [dbo].[Supplier]" +
                "   SET [ComCode] = ? " +
                "      ,[ComName] = ?" +
                "      ,[Address] = ?" +
                "      ,[Phone] = ?" +
                "      ,[Email] = ?" +
                "      ,[Tax] = ?" +
                " WHERE [supplierID]=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, o.getComCode());
            preparedStatement.setString(2, o.getComName());
            preparedStatement.setString(3, o.getAddress());
            preparedStatement.setString(4, o.getPhone());
            preparedStatement.setString(5, o.getEmail());
            preparedStatement.setString(6, o.getTax());
            preparedStatement.setInt(7, o.getSupplierID());
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
    public boolean isUniqName(Supplier o) {
        boolean uniqSupplier = false;
        String sql = "insert into Supplier(ComCode,ComName,Address,Phone,Email,Tax) values (?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, o.getComCode());
            preparedStatement.setString(2, o.getComName());
            preparedStatement.setString(3, o.getAddress());
            preparedStatement.setString(4, o.getPhone());
            preparedStatement.setString(5, o.getEmail());
            preparedStatement.setString(6, o.getTax());
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println("in not uniq");
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Sucess");
                alert.setHeaderText("ERROR : used");
                alert.setContentText("Brand" + "  '" + o.getComName() + "' " + "Already exist");
                alert.initStyle(StageStyle.UNDECORATED);
                alert.showAndWait();
                return  uniqSupplier;
            }
            uniqSupplier = true;
        } catch (  SQLException e ) {

            Logger.getLogger(Supplier.class.getName()).log(Level.SEVERE, null, e);
        }
        return uniqSupplier;
    }
}

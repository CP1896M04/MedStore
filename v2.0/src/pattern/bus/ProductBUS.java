package pattern.bus;

import javafx.scene.control.Alert;
import javafx.stage.StageStyle;
import pattern.connection.ConnectionFactory;
import pattern.dao.ProductDAO;
import pattern.model.Category;
import pattern.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductBUS implements BUS<Product> {
    private Connection connection;
    public  ProductBUS() {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connection = connectionFactory.getConnection();
    }
    ProductDAO productDAO= new ProductDAO();
    @Override
    public void add(Product o) {
        if (isUniqName(o)) {
           productDAO.add(o);
        }
    }

    @Override
    public void update(Product o) {
        if (isTrueUpdate(o)) {
            productDAO.update(o);
        } else if (isUniqName(o)) {
            productDAO.update(o);
        }
    }

    @Override
    public void delete(Product o) {
        if(productDAO.isNotUsed(o)){
            try {
                productDAO.remove(String.valueOf(o));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else{
            //noting
        }
    }

    @Override
    public boolean isTrueUpdate(Product o) {
        boolean isTreu = false;
        String sql = "insert into Product (CatID, UnitID, SupplierID, PName, PDescr, PComposition, PManufacturer, Uprice, USP, ReOrLevel, HTU, DefaultInDose) values (?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, o.getCatID());
            preparedStatement.setInt(2, o.getUnitID());
            preparedStatement.setInt(3, o.getSupplierID());
            preparedStatement.setString(4, o.getPName());
            preparedStatement.setString(5, o.getPDescr());
            preparedStatement.setString(6, o.getPComposition());
            preparedStatement.setString(7, o.getPManufacturer());
            preparedStatement.setFloat(8, o.getUprice());
            preparedStatement.setFloat(9, o.getUSP());
            preparedStatement.setInt(10, o.getReOrLevel());
            preparedStatement.setString(11, o.getHTU());
            preparedStatement.setInt(12, o.getDefaultInDose());
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                return isTreu;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isTreu;
    }

    @Override
    public boolean isUniqName(Product o) {
        boolean uniqProduct = false;
        String sql = "insert into Product (CatID, UnitID, SupplierID, PName, PDescr, PComposition, PManufacturer, Uprice, USP, ReOrLevel, HTU, DefaultInDose) values (?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, o.getCatID());
            preparedStatement.setInt(2, o.getUnitID());
            preparedStatement.setInt(3, o.getSupplierID());
            preparedStatement.setString(4, o.getPName());
            preparedStatement.setString(5, o.getPDescr());
            preparedStatement.setString(6, o.getPComposition());
            preparedStatement.setString(7, o.getPManufacturer());
            preparedStatement.setFloat(8, o.getUprice());
            preparedStatement.setFloat(9,o.getUSP());
            preparedStatement.setInt(10, o.getReOrLevel());
            preparedStatement.setString(11, o.getHTU());
            preparedStatement.setInt(12, o.getDefaultInDose());
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
            uniqProduct = true;
        } catch (  SQLException e ) {

            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, e);
        }
        return uniqProduct;
    }
}

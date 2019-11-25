package pattern.viewDAO;

import pattern.connection.ConnectionFactory;
import pattern.dao.DAO;
import pattern.list.InventoryLedgerList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ViewInventoryLedgerDAO implements DAO<InventoryLedgerList> {
    private Connection connection;
    public ViewInventoryLedgerDAO() {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connection =connectionFactory.getConnection();
    }


    @Override
    public void add(InventoryLedgerList o) {

    }

    @Override
    public void remove(String id) throws SQLException {

    }

    @Override
    public void update(InventoryLedgerList o) {

    }

    @Override
    public List<InventoryLedgerList> getList() {
        List<InventoryLedgerList> inventoryLedgerLists = new ArrayList<>();
        String sql = "SELECT * FROM InventoryLedger_View";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer LegerID= resultSet.getInt("LegerID");
                Integer ProductID = resultSet.getInt("ProductID");
                String pName = resultSet.getString("PName");
                String TransactionType = resultSet.getString("TransactionType");
                Integer QuantityTransacted = resultSet.getInt("QuantityTransacted");
                Float InventoryPurchaseCost =resultSet.getFloat("InventoryPurchaseCost");
                Integer DateKey =resultSet.getInt("DateKey");
                InventoryLedgerList inventoryLedgerList = new InventoryLedgerList(LegerID,ProductID,pName,TransactionType,QuantityTransacted,InventoryPurchaseCost,DateKey);
                inventoryLedgerLists.add(inventoryLedgerList);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return inventoryLedgerLists;
    }


}
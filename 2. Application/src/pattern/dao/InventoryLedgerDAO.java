package pattern.dao;

import pattern.connection.ConnectionFactory;
import pattern.model.InventoryLedger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class InventoryLedgerDAO implements DAO<InventoryLedger> {
    private Connection connection;
    public  InventoryLedgerDAO() {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connection =connectionFactory.getConnection();
    }
    @Override
    public void add(InventoryLedger o) {
        String sql = "INSERT INTO [dbo].[InventoryLedger]\n" +
                "           ([LegerCode]\n" +
                "           ,[ProductID]\n" +
                "           ,[TransactionType]\n" +
                "           ,[QuantityTransacted]\n" +
                "           ,[InventoryPurchaseCost])\n" +
                "     VALUES\n" +
                "           (?\n" +
                "           ,?\n" +
                "           ,?\n" +
                "           ,?\n" +
                "           ,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, o.getLegerCode());

            preparedStatement.execute();
        } catch (  SQLException e ) {

            throw new RuntimeException(e);
        }

    }

    @Override
    public void remove(String id) throws SQLException {

    }

    @Override
    public void update(InventoryLedger o) {

    }

    @Override
    public List<InventoryLedger> getList() {
        return null;
    }
}

package pattern.dao;

import pattern.connection.ConnectionFactory;
import pattern.model.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class CatDAO implements DAO<Category> {
    private Connection connection;
    public  CatDAO() {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connection =connectionFactory.getConnection();
    }
    @Override
    public void add(Category o) {
        String sql = "insert into Category (CatID, CatName, [Desc]) values (? ,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, o.getCatName());
            preparedStatement.setString(2, o.getDesc());

            preparedStatement.execute();
        } catch (  SQLException e ) {

            throw new RuntimeException(e);
        }
    }

    @Override
    public void remove(Category o) {

    }

    @Override
    public void update(Category o) {

    }

    @Override
    public List<Category> getList() {
        return null;
    }
}

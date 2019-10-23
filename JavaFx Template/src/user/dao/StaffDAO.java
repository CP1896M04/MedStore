package user.dao;

import user.connection.ConnectionFactory;
import user.model.Staff;

import java.sql.Connection;
import java.util.List;

public class StaffDAO implements DAO<Staff> {
    private Connection connection;
    public  StaffDAO() {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connection =connectionFactory.getConnection();
    }
    @Override
    public void add(Staff o) {

    }

    @Override
    public void remove(Staff o) {

    }

    @Override
    public void update(Staff o) {

    }

    @Override
    public List<Staff> getList() {
        return null;
    }
}

package main.java.dao;

import main.java.connection.ConnectionFactory;
import main.java.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
//UserDAO implement DAO nên Override tất cả các phương thức
public class UserDAO implements DAO<User> {
    private Connection connection;
    public UserDAO(){
        this.connection = new ConnectionFactory().getConnection();
    }
    @Override
    public void add(User o) {
        String sql = "insert into users (username, password) values (? ,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, o.getUserName());
            preparedStatement.setString(2, o.getPassWord());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void remove(User o) {
        String sql = "insert into user (username, password) values (? ,?)";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, o.getUserName());
            preparedStatement.setString(2, o.getPassWord());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(User o) {
        String sql = "insert into user (username, password) values (? ,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, o.getUserName());
            preparedStatement.setString(2, o.getPassWord());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<User> getList() {
        return null;
    }
}

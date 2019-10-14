package user.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public Connection getConnection(){
        try {
            String dbURL = "jdbc:sqlserver://localhost;databaseName=Demo;user=thientinh99;password=thientinh";
            Connection conn = DriverManager.getConnection(dbURL);
            return conn;
        } catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}

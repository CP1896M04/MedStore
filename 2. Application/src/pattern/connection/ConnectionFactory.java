package pattern.connection;

import lib.Config;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
    public static Connection getConnection(){
        //Load config
        try {
          String connectString= "jdbc:sqlserver://"+ Config.getProperty("db.url")+
                  ";databaseName="+ Config.getProperty("db.dbName")+
                  ";user="+ Config.getProperty("db.user") +
                  ";password="+ Config.getProperty("db.password");
            //create a new connectString
            Connection conn = DriverManager.getConnection(connectString);
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}

package main.database;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectionTest {
    public static void main(String[] args) {
        //Nhớ chỉnh SQL Server Configuration Manager > SQL Server Network Configuration > Protocol for SQL Server > Port all thành 1433
        try {
            String dbURL = "jdbc:sqlserver://localhost;databaseName=Demo;user=sa;password=123456";
            Connection conn = DriverManager.getConnection(dbURL);
            if (conn != null) {
                System.out.println("Connected");
                DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
                System.out.println("Driver name: " + dm.getDriverName());
                System.out.println("Driver version: " + dm.getDriverVersion());
                System.out.println("Product name: " + dm.getDatabaseProductName());
                System.out.println("Product version: " + dm.getDatabaseProductVersion());
            }
        } catch (SQLException ex) {
            System.err.println("Cannot connect database, " + ex);
        }
    }
}
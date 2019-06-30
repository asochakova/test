package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {

    private Connection connection;

    private static final String DB_DRIVER = "org.postgresql.Driver";
    private static final String DB_URL = "jdbc:postgresql:Test";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "123456";

    public Connection getConnection() {
        try{
            Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        } catch (SQLException ex){
            ex.printStackTrace();
        }

        return connection;
    }
}

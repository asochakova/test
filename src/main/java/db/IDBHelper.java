package db;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface IDBHelper {

    int requestExecute(String request);

    ResultSet getRecords(String request) throws SQLException;

    void closeConnection();

}

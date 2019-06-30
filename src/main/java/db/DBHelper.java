package db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBHelper extends Util implements IDBHelper {

    Connection connection;
    Statement statement;

    public int requestExecute(String request){
        int countRows = 0;
        try{
            openConnection();
            countRows = statement.executeUpdate(request);
        } catch (SQLException e){
            e.printStackTrace();
        }finally {
            closeConnection();
        }
        return countRows;
    }

    public ResultSet getRecords(String request) throws SQLException{
        openConnection();
        ResultSet resultSet = statement.executeQuery(request);
        return resultSet;
    }

    private void openConnection(){
        try{
            if(connection==null||connection.isClosed()){
                connection = getConnection();
                statement = connection.createStatement();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        try{
            if(statement!=null){
                statement.close();
            }
            if(connection!=null){
                connection.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

}

package db;

import model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

public class UserHelper {

    private IDBHelper dbHelper;
    private static Logger log = Logger.getLogger(UserHelper.class.getName());

    public UserHelper(IDBHelper dbHelper){
        this.dbHelper = dbHelper;
    }

    public int addUser(User user){
        String request = String.format("INSERT INTO \"USERS\" (\"LASTNAME\",\"NAME\",\"MIDDLENAME\",\"LOGIN\",\"PASSWORD\") VALUES ('%s','%s','%s','%s','%s')",
                user.getLastName(),user.getName(),user.getMiddleName(),user.getLogin(),user.getPassword());
        int row = dbHelper.requestExecute(request);
        log.info("В базу данных добавлен "+user.toString());
        return row;
    }

    public int updateUserLastName(String loginUser, String newLastName){
        String request = String.format("UPDATE \"USERS\" SET \"LASTNAME\" = '%s' WHERE \"LOGIN\" = '%s' ",newLastName,loginUser);
        int row = dbHelper.requestExecute(request);
        log.info(String.format("У пользователя с логином '%s' была изменена фамилия на '%s'",loginUser,newLastName));
        return row;
    }

    public User getUser(String uniqueLogin){
        String request = String.format("SELECT * FROM \"USERS\" WHERE \"LOGIN\"='%s'",uniqueLogin);
        User user = null;
        try{
            user = new User();
            ResultSet resultSet = dbHelper.getRecords(request);
            if(resultSet.next()){
                user.setLastName(resultSet.getString("LASTNAME"));
                user.setName(resultSet.getString("NAME"));
                user.setMiddleName(resultSet.getString("MIDDLENAME"));
                user.setLogin(resultSet.getString("LOGIN"));
                user.setPassword(resultSet.getString("PASSWORD"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            dbHelper.closeConnection();
        }
        return user;
    }

}

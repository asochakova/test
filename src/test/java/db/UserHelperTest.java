package db;

import model.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class UserHelperTest {

    private UserHelper helper;

    @Before
    public  void setUp() throws Exception {
        IDBHelper db = new DBHelper();
        helper = new UserHelper(db);
    }

    private User getUser(){
        String time = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss").format(Calendar.getInstance().getTime());
        String name = "User "+time;
        User user = new User(name);
//        user.setLastName(name);
//        user.setName(name);
//        user.setMiddleName(name);
//        user.setLogin(name);
//        user.setPassword(name);
        return user;
    }

    @Test
    public void insert_into_user_database_test() {
        User userExpected = getUser();
        int row = helper.addUser(userExpected);
        User userActual = helper.getUser(userExpected.getLogin());
        Assert.assertEquals(userExpected,userActual);
        Assert.assertEquals("В базу данных должна была добавиться только одна запись",1,row);
    }

    @Test
    public void update_lastname_user_test(){
        User user = getUser();
        helper.addUser(user);
        String newLastName = "New LastName";
        int row = helper.updateUserLastName(user.getLogin(),newLastName);
        User userActual = helper.getUser(user.getLogin());
        Assert.assertEquals("Должна была обновиться только одна запись, так как логин является уникальным",1,row);
        Assert.assertEquals(user.getName(),userActual.getName());
        Assert.assertNotEquals(user.getLastName(),userActual.getLastName());
        Assert.assertEquals(newLastName,userActual.getLastName());
        Assert.assertEquals(user.getLogin(),userActual.getLogin());
        Assert.assertEquals(user.getPassword(),userActual.getPassword());
    }

}
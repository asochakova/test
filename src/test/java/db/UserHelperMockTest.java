package db;

import model.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static org.mockito.Mockito.*;

public class UserHelperMockTest {

    private IDBHelper dbHelperMock;
    private UserHelper userHelper;

    @Before
    public void setUp(){
        dbHelperMock = mock(IDBHelper.class);
        userHelper = new UserHelper(dbHelperMock);
    }

    @Test
    public void insert_into_user_database() throws Exception{
        String time = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss").format(Calendar.getInstance().getTime());
        String name = "User "+time;
        User user = new User(name);
        userHelper.addUser(user);
        String request = String.format("INSERT INTO \"USERS\" (\"LASTNAME\",\"NAME\",\"MIDDLENAME\",\"LOGIN\",\"PASSWORD\") VALUES ('%s','%s','%s','%s','%s')",
                user.getLastName(),user.getName(),user.getMiddleName(),user.getLogin(),user.getPassword());
        verify(dbHelperMock).requestExecute(request);
        verifyNoMoreInteractions(dbHelperMock);
    }

    @Test
    public void update_lastname_user_test(){
        when(dbHelperMock.requestExecute("")).thenReturn(1);
        userHelper.updateUserLastName("login","newLastName");
        Assert.assertEquals(1,dbHelperMock.requestExecute(""));
    }


}

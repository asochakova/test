import db.DBHelper;
import db.IDBHelper;
import db.UserHelper;
import model.User;

public class Main {

    public static void main(String[] args){
        User user1 = initUser("User4","User4","User4","User4","User4");
        IDBHelper db = new DBHelper();
        UserHelper helper = new UserHelper(db);
        helper.addUser(user1);
        helper.updateUserLastName("User3","Kate");
        User user = helper.getUser("User3");
        System.out.println(user.toString());
    }

    static User initUser(String lastName,String name, String middleName,String login, String password){
        User user = new User();
        user.setLastName(lastName);
        user.setName(name);
        user.setMiddleName(middleName);
        user.setLogin(login);
        user.setPassword(password);
        return user;
    }

}

package model;

public class User {

    private String name;
    private String lastName;
    private String middleName;
    private String login;
    private String password;

    public User(){

    }

    public User(String lastName,String name,String middleName,String login,String password){
        this.lastName = lastName;
        this.name = name;
        this.middleName = middleName;
        this.login = login;
        this.password = password;
    }

    //TODO Написан только для написания тестов
    public User(String name){
        this(name,name,name,name,name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

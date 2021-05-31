public class User {
    String login, password, email;
    int age;
    int id;

    public User(String login, String password, String email, int age, int id) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.age = age;
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public int getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }
}

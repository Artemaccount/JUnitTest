import java.util.Scanner;
import java.util.logging.SocketHandler;

public class Main {
    public static final int ACCESS_AGE = 18;

    public static void main(String[] args) throws UserNotFoundException, AccessDeniedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите логин");
        String login = scanner.nextLine();
        System.out.println("Введите пароль");
        String password = scanner.nextLine();
        validateUser(getUserByLoginAndPassword(login, password));
    }

    public static User[] getUsers() {
        User user1 = new User("ivan", "ivan111", "ivan@mail.ru", 15, 123412);
        User user2 = new User("megarobot", "robo333", "sergey@mail.ru", 45, 12314);
        User user3 = new User("carlthebest", "iamcarl", "carlbest@gmail.ru", 25, 99421);
        User user4 = new User("nastya", "love1234", "love1234@ya.ru", 17, 921847);
        User user5 = new User("lena1", "welldone@@@", "hackerlena@hacker.ru", 30, 112111);
        return new User[]{user1, user2, user3, user4, user5};
    }

    public static User getUserByLoginAndPassword(String login, String password) throws UserNotFoundException {
        User[] users = getUsers();
        for (User user : users) {
            if (user.login.equalsIgnoreCase(login) && user.password.equals(password))
                return user;
        }
        throw new UserNotFoundException("User not found");
    }

    public static void validateUser(User user) throws AccessDeniedException {
        if (user.age >= ACCESS_AGE) {
            System.out.println("Доступ предоставлен!");
        } else {
            throw new AccessDeniedException("Доступ запрещен!");
        }
    }
}

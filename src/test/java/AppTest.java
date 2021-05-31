import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


public class AppTest {
    static User[] users = new User[]{};

    @BeforeAll
    static void users() {
        System.out.println("Users[] array created!");
        users = Main.getUsers();
    }

    @Test
    void validateUser_not_exception() {
        Assertions.assertDoesNotThrow(
                () -> Main.validateUser(users[1]));

    }

    @Test
    void validateUser_exception() {
        Assertions.assertThrows(AccessDeniedException.class,
                () -> Main.validateUser(users[0]));
    }

    @Test
    void getUser_exception() {
        Assertions.assertThrows(UserNotFoundException.class,
                () -> Main.getUserByLoginAndPassword("Login", "Password"));
    }

    @Test
    void getUser_not_exception() {
        User expected = users[0];
        User actual = null;
        try {
            actual = Main.getUserByLoginAndPassword(users[0].getLogin(), users[0].getPassword());
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        }
        Assertions.assertEquals(expected.getId(), actual.getId());
    }
}

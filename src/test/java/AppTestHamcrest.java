import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class AppTestHamcrest {
    static User[] users = new User[]{};

    @BeforeAll
    static void users() {
        System.out.println("Users[] array created!");
        users = Main.getUsers();
    }

    @Test
    void first_login_is_ivan() {
        String expectedLogin = "ivan";
        String actualLogin = users[0].getLogin();

        assertThat(expectedLogin, equalTo(actualLogin));
    }

    @Test
    void array_size_is_five() {
        assertThat(users, arrayWithSize(5));
    }

    @Test
    void array_is_not_empty(){
        assertThat(users, not(emptyArray()));
    }
}

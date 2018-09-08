import business.LoginPageBo;
import core.driver.DriverManager;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LogInTest {
    private LoginPageBo loginPageBo;

    @BeforeTest
    public void setup() {
        loginPageBo = new LoginPageBo();
    }

    @Test
    public void logInTest() {
        loginPageBo.logIn("login", "password");
    }

    @AfterTest
    public void quit() {
        DriverManager.removeDriver();
    }
}

import com.epam.lab.business.LoginPageBo;
import com.epam.lab.core.driver.DriverManager;
import com.epam.lab.core.util.CsvParser;
import com.epam.lab.core.util.User;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.epam.lab.core.util.Constants.CSV_PATH;

public class LogInTest {
    private LoginPageBo loginPageBo;
    private User user;

    @BeforeTest
    @Description("Loading configurations before test")
    public void setup() {
        user = CsvParser.createObjectsFromCsv(CSV_PATH);
        loginPageBo = new LoginPageBo();
    }

    @Test
    @Description("Invalid Login Scenario with invalid login and password")
    @Severity(SeverityLevel.NORMAL)
    public void logInTest() {

        loginPageBo.logIn(user.getLogin(), user.getPassword());
    }


    @AfterTest
    @Description("Exit from program")
    public void quit() {
        DriverManager.removeDriver();
    }}

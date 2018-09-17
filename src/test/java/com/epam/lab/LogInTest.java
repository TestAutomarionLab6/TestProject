import com.epam.lab.business.LoginPageBo;
import com.epam.lab.core.driver.DriverManager;
import com.epam.lab.core.util.CsvParser;
import com.epam.lab.core.util.User;
import com.epam.lab.core.util.reportListeners.TestListener;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.ITestNGListener;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.epam.lab.core.util.Constants.CSV_PATH;

@Listeners({TestListener.class})
public class LogInTest implements ITestNGListener{
    private LoginPageBo loginPageBo;
    private User user;

    @BeforeTest
    @Description("Loading configurations before test")
    public void setup() {
        user = CsvParser.createObjectsFromCsv(CSV_PATH);
        loginPageBo = new LoginPageBo();
    }

    @Test(priority = 0, description = "Invalid LogInTest Scenario with wrong username and password")
    @Description("LogInTest Description: Login test with invalid login and password")
    @Severity(SeverityLevel.NORMAL)
    public void logInTest() {
        loginPageBo.logIn(user.getLogin(), user.getPassword());
    }


    @AfterTest
    @Description("Exit from program")
    public void quit() {
        DriverManager.removeDriver();
    }
}

package com.epam.lab;

import com.epam.lab.business.HomePageBo;
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

import static com.epam.lab.core.util.Constants.*;

@Listeners({TestListener.class})
public class LogInTest implements ITestNGListener {
    private LoginPageBo loginPageBo;
    private HomePageBo homePageBo;
    private User user;
    private String currentURL;

    @BeforeTest
    @Description("Loading configurations before test")
    public void setup() {
        user = CsvParser.createObjectsFromCsv(CSV_PATH);
        loginPageBo = new LoginPageBo();
        homePageBo = new HomePageBo();
    }

    @Test(priority = 8, description = "LogInTest Scenario with valid username and valid password")
    @Description("LogInTest Description: Login test valid login and valid password")
    @Severity(SeverityLevel.NORMAL)
    public void logInTestWithValidLoginAndValidPassword() {
        loginPageBo.logIn(user.getLogin(), user.getPassword());
        currentURL = DriverManager.getDriver().getCurrentUrl();
        homePageBo.logout();
        Assert.assertEquals(currentURL, HOME_PAGE_URL);
    }

    @Test(priority = 0, description = "Verify link password.epam.com")
    @Description("LogInTest Description: Verify link password.epam.com")
    @Severity(SeverityLevel.NORMAL)
    public void verifyLinkPasswordEpamCom() {
        loginPageBo.passwordEpamComLink();
        currentURL = DriverManager.getDriver().getCurrentUrl();
        loginPageBo.goBack();
        Assert.assertEquals(currentURL, "https://password.epam.com/");
    }

    @Test(priority = 1, description = "Verify link Privacy Policy")
    @Description("LogInTest Description: Verify link Privacy Policy")
    @Severity(SeverityLevel.NORMAL)
    public void verifyLinkPrivacyPolicy() {
        loginPageBo.privacyPolicyLink();
        currentURL = DriverManager.getDriver().getCurrentUrl();
        loginPageBo.goBack();
        Assert.assertEquals(currentURL, "https://www.epam.com/privacy-policy");
    }

    @Test(priority = 2, description = "Verify link for support email")
    @Description("LogInTest Description: Verify link for support email")
    @Severity(SeverityLevel.NORMAL)
    public void verifyLinkForSupportEmail() {
        currentURL = loginPageBo.hrefLink();
        Assert.assertEquals(currentURL, "mailto:Support@epam.com");
    }


    @Test(priority = 3, description = "Verify link Self Service")
    @Description("LogInTest Description: Verify link Self Service")
    @Severity(SeverityLevel.NORMAL)
    public void verifyLinkSelfService() {
        loginPageBo.selfServiceLink();
        currentURL = DriverManager.getDriver().getCurrentUrl();
        loginPageBo.goBack();
        Assert.assertEquals(currentURL, "https://password.epam.com/");
    }

    @Test(priority = 4, description = "LogInTest Scenario with blank username and blank password")
    @Description("LogInTest Description: blank login and password")
    @Severity(SeverityLevel.NORMAL)
    public void logInTestWithBlankLoginAndPassword() {
        loginPageBo.logIn("", "");
        currentURL = DriverManager.getDriver().getCurrentUrl();
        Assert.assertNotEquals(currentURL, HOME_PAGE_URL);
    }

    @Test(priority = 5, description = "LogInTest Scenario with invalid username and invalid password")
    @Description("LogInTest Description: invalid login and invalid password")
    @Severity(SeverityLevel.NORMAL)
    public void logInTestWithInvalidLoginAndInvalidPassword() {
        loginPageBo.logIn(INVALID_LOGIN, INVALID_PASSWORD);
        currentURL = DriverManager.getDriver().getCurrentUrl();
        Assert.assertNotEquals(currentURL, HOME_PAGE_URL);
    }

    @Test(priority = 6, description = "LogInTest Scenario with invalid username and valid password")
    @Description("LogInTest Description:invalid login and valid password")
    @Severity(SeverityLevel.NORMAL)
    public void logInTestWithInvalidLoginAndValidPassword() {
        loginPageBo.logIn(INVALID_LOGIN, user.getPassword());
        currentURL = DriverManager.getDriver().getCurrentUrl();
        Assert.assertNotEquals(currentURL, HOME_PAGE_URL);
    }

    @Test(priority = 7, description = "LogInTest Scenario with valid username and invalid password")
    @Description("LogInTest Description:valid login and invalid password")
    @Severity(SeverityLevel.NORMAL)
    public void logInTestWithValidLoginAndInvalidPassword() {
        loginPageBo.logIn(user.getLogin(), INVALID_PASSWORD);
        currentURL = DriverManager.getDriver().getCurrentUrl();
        Assert.assertNotEquals(currentURL, HOME_PAGE_URL);
    }


    @AfterTest
    @Description("Exit from program")
    public void quit() {
        DriverManager.removeDriver();
    }

}
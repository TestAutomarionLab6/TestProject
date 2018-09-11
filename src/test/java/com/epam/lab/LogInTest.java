package com.epam.lab;

import com.epam.lab.business.LoginPageBo;
import com.epam.lab.core.driver.DriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Flaky;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LogInTest {
    private LoginPageBo loginPageBo;

    @BeforeTest
    @Description("Loading configurations before test")
    public void setup() {
        loginPageBo = new LoginPageBo();
    }

    @Test
    @Description("Invalid Login Scenario with invalid login and password")
    @Severity(SeverityLevel.NORMAL)
    public void logInTest() {
        loginPageBo.logIn("login", "password");
    }


    @AfterTest
    @Description ("Exit from program")
    public void quit() {
        DriverManager.removeDriver();
    }
}
